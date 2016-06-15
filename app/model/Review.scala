package model

import scala.collection.mutable.ListBuffer

class Review extends Reunion {
    
  // Se supone que habria que modelar el codigo que se le muestra al cliente
  
  var cambios = new ListBuffer[String]
  
  
  def crearReview(dia:Integer, mes:Integer, anio:Integer, hora:Integer, minutos:Integer ){
    this.crearReunion(dia, mes, anio, hora, minutos)
  }
}