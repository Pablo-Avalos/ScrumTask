package model

import scala.collection.mutable.ListBuffer

class Tablero(idT:Integer) {
  var id = idT: Int
  var tareas =new ListBuffer[Tarea]
  var listaDeRelease =new ListBuffer[Release]
  
  def agregarTarea(tarea:Tarea): Tarea = {
    tareas.+=(tarea)
    return tarea
  }
  
  def eliminarTarea(id:Integer)= tareas = tareas filter { t => t.id != id }
  
  def getTarea(id:Integer)= tareas.find{ t => t.id == id }.getOrElse(null)
  
  def agregarRelease(release:Release){
    listaDeRelease.+=(release)
  }
}