package model

import scala.collection.mutable.ListBuffer

case class Sprint(id:Int) {
  var numero = id
  var tareas = new ListBuffer[Tarea]
}