package model

import scala.collection.mutable.ListBuffer
import java.text.SimpleDateFormat

case class Sprint(id: Int, fechaIncio: String, fechaFin: String) {

  var numero = id
  var tareas = new ListBuffer[Tarea]
  var proximoId = 0;
  
  def agregarTarea(tarea:Tarea){
    tarea.id = proximoId;
    tareas.+=(tarea)
    proximoId = proximoId + 1
  }
}
