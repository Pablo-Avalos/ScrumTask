package model

import scala.collection.mutable.ListBuffer

class Daily extends Reunion {
  var cosasQueHice = new ListBuffer[String]
  var queVoyAHacer = new ListBuffer[String]
  var impedimentos = new ListBuffer[String]
  

  def crearDaily(dia:Integer, mes:Integer, anio:Integer, hora:Integer, minutos:Integer ){
    this.crearReunion(dia, mes, anio, hora, minutos)
  }
 }
}