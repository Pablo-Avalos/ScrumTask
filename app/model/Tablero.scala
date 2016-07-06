package model

import scala.collection.mutable.ListBuffer
import java.util.Date
import java.text.SimpleDateFormat

class Tablero(idT: Integer) {
  var id = idT: Int
  var tareas = new ListBuffer[Tarea]
  var listaDeRelease = new ListBuffer[Release]
  var sdf = new SimpleDateFormat
  def agregarTarea(tarea: Tarea): Tarea = {
    tareas.+=(tarea)
    return tarea
  }

  def eliminarTarea(idRelease: Int, idSprint: Int, id: Integer) {

    listaDeRelease.filter { r => r.numero == idRelease }.head.listaSprints.filter { s => s.numero == idSprint }.head.tareas = listaDeRelease.filter { r => r.numero == idRelease }.head.listaSprints.filter { s => s.numero == idSprint }.head.tareas.filter { t => t.id != id }

  }

  def getTarea(id: Integer) = tareas.find { t => t.id == id }.getOrElse(null)

  def agregarSprint(numeroRelease: Int, fechaInicio: String, fechaFin: String): Sprint = {
    var f1 = sdf.format(new Date())
    var f2 = sdf.format(new Date())

    println("----------------" + f1)
    println("----------------" + f2)

    var sprint = new Sprint(listaDeRelease.filter { r => r.numero == numeroRelease }.head.listaSprints.length, f1, f2)
    listaDeRelease.filter { r => r.numero == numeroRelease }.head.listaSprints += sprint
    sprint
  }

  def obtenerRealase(id: Integer): Release = {

    listaDeRelease.filter { r => r.numero == id }.head

  }
  def agregarTarea(idRealease: Int, idSprint: Int, tarea: Tarea): Tarea = {

    this.obtenerRealase(idRealease).listaSprints.filter { s => s.numero == idSprint }.head.tareas += tarea
    tarea

  }
  def agregarRelease(release: Release) {
    listaDeRelease.+=(release)
  }

}