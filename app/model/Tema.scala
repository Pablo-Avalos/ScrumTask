package model

import scala.collection.mutable.ListBuffer

class Tema {
  var descripcion = null: String
  var temas = new ListBuffer[String]

  def setDescripcionTema(descripcion: String) {
    this.descripcion = descripcion
  }

}