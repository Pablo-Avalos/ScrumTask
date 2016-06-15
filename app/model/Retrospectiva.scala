package model

import scala.collection.mutable.ListBuffer

class Retrospectiva extends Reunion {
  var cosasQueFuncionanBien = new ListBuffer[String]
  var cosasAMejorar = new ListBuffer[String]
  var problemasSurgidos = new ListBuffer[String]
  var puntosRealizados = null: Integer
  
  def crearRetrospectiva(dia:Integer, mes:Integer, anio:Integer, hora:Integer, minutos:Integer ){
    this.crearReunion(dia, mes, anio, hora, minutos)
  }

}