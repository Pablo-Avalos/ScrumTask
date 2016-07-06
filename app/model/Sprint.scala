package model

import scala.collection.mutable.ListBuffer
import java.text.SimpleDateFormat

case class Sprint(id: Int, fechaIncio: String, fechaFin: String) {

  var numero = id
  var tareas = new ListBuffer[Tarea]
}
