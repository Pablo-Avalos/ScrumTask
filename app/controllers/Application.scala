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
  var idp = 3
  
  implicit val estadoWrites = new Writes[StateTask] {
    def writes(estado: StateTask) = Json.obj(
      "codigo" -> estado.codigo
      )
  }
  
  implicit val tareaWrites = new Writes[Tarea] {
    def writes(tarea: Tarea) = Json.obj(
      "id" -> tarea.id,
      "nombre" -> tarea.nombre,
      "descripcion" -> tarea.descripcion,
      "autor" -> tarea.autor
      ,"estado" -> tarea.estado
      )
  }

  implicit val sprintWrites = new Writes[Sprint] {
    def writes(sprint: Sprint) = Json.obj(
      "numero" -> sprint.numero,
      "listaTareas" -> sprint.tareas,
        "fechaInicio" -> sprint.fechaIncio,
          "fechaFin" -> sprint.fechaFin
    )
  }

  implicit val releaseWrites = new Writes[Release] {
    def writes(release: Release) = Json.obj(
      "numero" -> release.numero,
      "listaSprints" -> release.listaSprints)
  }

  implicit val tableroWrites = new Writes[Tablero] {
    def writes(tablero: Tablero) = Json.obj(
      "idT" -> tablero.id,
      "tareas" -> tablero.tareas,
      "release" -> tablero.listaDeRelease)
  }

  implicit val usarioWrites = new Writes[Usuario] {
    def writes(usuario: Usuario) = Json.obj(
      "nombre" -> usuario.name,
      "id" -> usuario.id,
      "tipo" -> usuario.tipo)
  }

  implicit val temaWrites = new Writes[Tema] {
    def writes(tema: Tema) = Json.obj(
      "descripcion" -> tema.descripcion,
      "temas" -> tema.temas)
  }

  implicit val tipoWrites = new Writes[TipoDeReunion.Tipo] {
    def writes(tipo: TipoDeReunion.Tipo) = Json.obj(
      "tipo" -> tipo.toString())
  }

  implicit val reunionWrites = new Writes[Reunion] {
    def writes(reunion: Reunion) = Json.obj(
      "id" -> reunion.id,
      "tipo" -> reunion.tipoDeReunion.toString(),
      "fecha" -> reunion.fechatexto,
      "integrantes" -> reunion.integrantes.map {i => i.name},
      "temasTratados" -> reunion.datosDeTemas())
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

  def agregarColaborador(idProyecto: Int, nombre: String, tipo: String) = Action {
    if(tipo == "desarrollador") {
      var nuevoIntegrante = new Colaborador(nombre)
      nuevoIntegrante.id = idp
      appPorDefecto.getProyecto(idProyecto).agregarColaborador(nuevoIntegrante)
     }
    else if (tipo == "productOwner") { 
      var nuevoIntegrante = new ProductOwner(nombre)
      nuevoIntegrante.id = idp
      appPorDefecto.getProyecto(idProyecto).agregarColaborador(nuevoIntegrante)
    }
    else if (tipo == "scrumMaster") {
      var nuevoIntegrante = new ScrumMaster(nombre)
      nuevoIntegrante.id = idp
      appPorDefecto.getProyecto(idProyecto).agregarColaborador(nuevoIntegrante)
    }
    else {InternalServerError("No se pudo agregar el integrante")}
    idp = idp + 1 // esto lo puse provisorio para manejar el id de usuario
    Ok
  }

  def eliminarColaborador(idProyecto: Int, nombreColaborador: String) = Action {
    appPorDefecto.getProyecto(idProyecto).eliminarColaborador(nombreColaborador)
    Ok
  }

  def agregarTarea(idProyecto: Int, numeroRelease: Int, numeroSprint: Int, nombre: String, descripcion: String) = Action {

    var nuevoID = appPorDefecto.getTablero(idProyecto).obtenerRealase(numeroRelease).getSprint(numeroSprint).tareas.length + 1
    val tarea = new Tarea(nuevoID, nombre)
    tarea.descripcion = descripcion
    val t = appPorDefecto.getTablero(idProyecto).agregarTarea(numeroRelease, numeroSprint, tarea)
    val json = Json.toJson(t)
    Ok("{ 'tarea' :" + t + "}")

  }

  def eliminarTarea(idProyecto: Int, idRelease: Int, idSprint: Int, id: Int) = Action {
    appPorDefecto.getTablero(idProyecto).eliminarTarea(idRelease, idSprint, id)
    Ok
  }

  def eliminarProyecto(idProyecto: Int) = Action {
    appPorDefecto.eliminarProyecto(idProyecto)
    Ok
  }

  def getTarea() {

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
  def crearRelease(idProyecto: Int) = Action {
    var release = new Release(appPorDefecto.getTablero(idProyecto).listaDeRelease.length)
    appPorDefecto.getTablero(idProyecto).agregarRelease(release)

    val json = Json.toJson(release)
    Ok(json)
  }
  def crearSprint(idProyecto: Int, numeroRelease: Int, fechaInicio:String, fechaFin:String) = Action {
    var sprint = appPorDefecto.getTablero(idProyecto).agregarSprint(numeroRelease, fechaInicio, fechaFin)
    val json = Json.toJson(sprint)
    Ok(json)
  }

  def eliminarReunion(idProyecto: Int, idReunion: Int) = Action {
    appPorDefecto.getProyecto(idProyecto).eliminarReunion(idReunion)
    Ok
  }

  def getTipoReuniones() = Action {
    val tipoDeReuniones = appPorDefecto.getTipoDeReuniones()
    val json = Json.toJson(tipoDeReuniones)
    Ok(json)
  }

  def agregarProyecto(nombre: String) = Action {
    var proyecto = new Project(appPorDefecto.idProyecto,nombre)
    proyecto.tablero = new Tablero(appPorDefecto.idProyecto)
    appPorDefecto.agregarProyecto(proyecto)
    val json = Json.toJson(proyecto)
    Ok(json)
  }
  
    def guardarReunion(idProyecto: Int,idR:Int,fecha:String,tipo:String,nombre:String,descripcion:String,integrantes:String)= Action {
    var participantes = new ListBuffer[Int] 
    ((((integrantes.split(","))).filterNot { x => x == "" }).map { x => x.toInt }).foreach{ x => participantes.+=(x) };
    var proyecto = appPorDefecto.getProyecto(idProyecto)
    proyecto.crearReunion(idR,fecha, tipo, participantes, nombre, descripcion)
    Ok
  }
  
   def getIntegrantesReunion(idProyecto: Int) = Action {
    var integrantes = new ListBuffer[Usuario]
    integrantes = appPorDefecto.getProyecto(idProyecto).colaboradores
    Ok(Json.toJson(integrantes))
  }
   
   def getObtenerUsuariosDeReunion(idProyecto: Int,idReunion: Int)= Action {
    var asistentes = new ListBuffer[Usuario]
    if(((appPorDefecto.getProyecto(idProyecto).reuniones.map{r=>r.id}).contains(idReunion))){
    asistentes =(appPorDefecto.getProyecto(idProyecto).reuniones.filter { r => r.id == idReunion }.head.integrantes)
    }
    Ok(Json.toJson(asistentes))
   }
}