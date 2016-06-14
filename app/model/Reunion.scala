package model

import org.joda.time.DateTime
import scala.collection.mutable.ListBuffer

class Reunion(var fecha: DateTime) {
  
  var temasTratados = new ListBuffer[String]
  var participantes = new ListBuffer[Usuario]
  
  def agregarTema(descripicionDelTema:String){
    temasTratados.+=:(descripicionDelTema)
  }
  
  def agregarParticipante(participante:Usuario){
    participantes.+=(participante)
  }
}

class Daily(fecha:DateTime) extends Reunion(fecha) {
}

class Planning(fecha:DateTime) extends Reunion(fecha) {
  var tareas = new ListBuffer[Tarea]
}

class Review(fecha:DateTime) extends Reunion(fecha) {
  
}

class Retrospectiva(fecha:DateTime) extends Reunion(fecha) {
  
}