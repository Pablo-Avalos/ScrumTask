package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.Result
import scala.collection.mutable.ListBuffer
import play.api.libs.json.Json
import play.api.libs.functional.syntax._
import model._
import akka.io.Tcp.Write
import play.api.libs.json.Writes

object Application extends Controller {

  val appPorDefecto = new AppPorDefecto

  implicit val tareaWrites = new Writes[Tarea] {
    def writes(tarea: Tarea) = Json.obj(
      "id" -> tarea.id,
      "nombre" -> tarea.nombre,
      "descripcion" -> tarea.descripcion,
      "autor" -> tarea.autor //,"estado" -> tarea.estado
      )
  }

  implicit val tableroWrites = new Writes[Tablero] {
    def writes(tablero: Tablero) = Json.obj(
      "idT" -> tablero.id,
      "tareas" -> tablero.tareas)
  }

  implicit val colaboradorWrites = new Writes[Colaborador] {
    def writes(colaborador: Colaborador) = Json.obj(
      "nombre" -> colaborador.name)
  }

  implicit val proyectoWrites = new Writes[Project] {
    def writes(proyecto: Project) = Json.obj(
      "id" -> proyecto.id,
      "nombre" -> proyecto.nombre,
      "colaboradores" -> proyecto.colaboradores //,"tablero" -> proyecto.tablero// con este atributo falla la consulta
      )
  }

  def getProyectos = Action {
    val json = Json.toJson(appPorDefecto.proyectos)
    Ok(json)
  }

  def getTablero(idProyecto: Int) = Action {
    val tablero = appPorDefecto.getTablero(idProyecto)
    if (tablero == null) {
      InternalServerError("Upps al parecer este proyecto no tiene un tablero asociado.")
    } else {
      val json = Json.toJson(tablero)
      Ok(json)
    }
  }
  def agregarTarea(idProyecto: Int, nombre: String, descripcion: String) = Action {

    val tarea = new Tarea(appPorDefecto.getTablero(idProyecto).tareas.length, nombre)
    tarea.descripcion = descripcion
    val t = appPorDefecto.getTablero(idProyecto).agregarTarea(tarea)
    val json = Json.toJson(t)
    Ok("{ 'tarea' :" + t +"}" )
  }
  
  def getTarea(){
    
    
  }
}