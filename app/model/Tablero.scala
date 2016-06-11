package model
import scala.collection.mutable.ListBuffer
class Tablero(idT:Integer) {
  var id = idT: Integer
  var tareas =new ListBuffer[Task]
  var listaDeRelease =new ListBuffer[Release]
  
  def agregarTarea(tarea:Task){
    tareas.+=(tarea)
  }
  
  def agregarRelease(release:Release){
    listaDeRelease.+=(release)
  }
}