package model

import scala.collection.mutable.ListBuffer

class Tablero(idT: Integer) {
  var id = idT: Int
  var tareas = new ListBuffer[Tarea]
  var listaDeRelease = new ListBuffer[Release]

  def agregarTarea(tarea: Tarea): Tarea = {
    tareas.+=(tarea)
    return tarea
  }

  def eliminarTarea(idRelease: Int, idSprint: Int, id: Integer) {

    listaDeRelease.filter { r => r.numero == idRelease }.head.listaSprints.filter { s => s.numero == idSprint }.head.tareas = listaDeRelease.filter { r => r.numero == idRelease }.head.listaSprints.filter { s => s.numero == idSprint }.head.tareas.filter { t => t.id != id }

  }

  def getTarea(id: Integer) = tareas.find { t => t.id == id }.getOrElse(null)

  def agregarSprint(numeroRelease: Int): Sprint = {
    var sprint = new Sprint(listaDeRelease.filter { r => r.numero == numeroRelease }.head.listaSprints.length)
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