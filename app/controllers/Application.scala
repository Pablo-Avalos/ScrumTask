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

  implicit val usarioWrites = new Writes[Usuario] {
    def writes(usuario: Usuario) = Json.obj(
      "nombre" -> usuario.name)
  }
  
  implicit val temaWrites = new Writes[Tema] {
    def writes(tema: Tema) = Json.obj(
      "descripcion" -> tema.descripcion,
      "temas" -> tema.temas
      )
  }
  
  implicit val tipoWrites = new Writes[TipoDeReunion.Tipo] {
    def writes(tipo: TipoDeReunion.Tipo) = Json.obj(
      "tipo" -> tipo.toString()
      )
  }

    implicit val reunionWrites = new Writes[Reunion] {
    def writes(reunion: Reunion) = Json.obj(
      "id" -> reunion.id
      //"tipo" -> reunion.tipoDeReunion,
      //"integrantes" -> reunion.integrantes,
      //"temasTratados" -> reunion.temasTratados
      )
  }
    
  implicit val proyectoWrites = new Writes[Project] {
    def writes(proyecto: Project) = Json.obj(
      "id" -> proyecto.id,
      "nombre" -> proyecto.nombre,
      "reuniones" -> proyecto.reuniones,
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
  
  def getColaboradores(idProyecto: Int) = Action {
    val colaboradores = appPorDefecto.getColaboradores(idProyecto)
    Ok(Json.toJson(colaboradores))
  }
  
  def agregarColaborador(idProyecto: Int, nombre: String) = Action {
    val nuevoColaborador = new Colaborador(nombre)
    nuevoColaborador.name = nombre
    appPorDefecto.getProyecto(idProyecto).agregarColaborador(nuevoColaborador)
    Ok
  }
  
  def eliminarColaborador(idProyecto: Int, nombreColaborador: String) = Action {
    appPorDefecto.getProyecto(idProyecto).eliminarColaborador(nombreColaborador)
    Ok
  }
  
  def agregarTarea(idProyecto: Int, nombre: String, descripcion: String) = Action {

    val tarea = new Tarea(appPorDefecto.getTablero(idProyecto).tareas.length, nombre)
    tarea.descripcion = descripcion
    val t = appPorDefecto.getTablero(idProyecto).agregarTarea(tarea)
    val json = Json.toJson(t)
    Ok("{ 'tarea' :" + t +"}" )
  }
  
   def eliminarTarea(idProyecto: Int, id: Int) = Action{
    appPorDefecto.getProyecto(idProyecto).eliminarTarea(id)
    Ok
  }
   
  def eliminarProyecto(idProyecto: Int) = Action {
    appPorDefecto.eliminarProyecto(idProyecto)
    Ok
  }
  
  def getTarea(){
    
    
  }
  
  def getReuniones(idProyecto: Int) = Action {
    val reuniones = appPorDefecto.getReuniones(idProyecto)
    if (reuniones == null) {
      InternalServerError("El proyecto no tiene reuniones.")
    } else {
      val json = Json.toJson(reuniones)
      Ok(json)
    }
  }
}