package model

import scala.collection.mutable.ListBuffer

class Planning extends Reunion  {
  var sprintBacklog = new ListBuffer[Tarea] //  Lista de tareas de la iteracion
  
   def crearPlaning(dia:Integer, mes:Integer, anio:Integer, hora:Integer, minutos:Integer ){
     this.crearReunion(dia, mes, anio, hora, minutos)
  }


}