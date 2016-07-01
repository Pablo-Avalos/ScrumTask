package model

import scala.collection.mutable.ListBuffer

import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._
import java.text.SimpleDateFormat
import java.text.SimpleDateFormat._

import java.sql.Time

class Reunion(idR:Int) {
  var id = idR
  var fecha = null: Date
  var horaDeInicio = null: Time
  var integrantes = new ListBuffer[Usuario]
  var temasTratados = null: Tema
  var tipoDeReunion = null: TipoDeReunion.Tipo
  
  def setFecha(dia: Integer, mes: Integer, anio: Integer) {
    fecha = new Date((anio - 1900), mes - 1, dia)
  }

  def setHora(hora: Integer, minutos: Integer) {
    horaDeInicio = new Time(hora, minutos, 0)
   }

  def agregarIntegrante(participante: Usuario) {
    integrantes.+=(participante)
  }

  def agregarTema(temaNvo: String, descripcionDelTema: String) {
    temasTratados.setDescripcionTema(descripcionDelTema)
    temasTratados.temas.+=:(temaNvo)
  }

  def crearReunion(id: Integer, dia: Integer, mes: Integer, anio: Integer, hora: Integer, minutos: Integer) {
    this.id = id
    this.setFecha(dia, mes, anio)
    this.setHora(hora, minutos)
  }
  
  def datosDeIntegrantes():ListBuffer[String] = {
     integrantes.map(integrante=> integrante.name)
  }
  
  def datosDeTemas():String = {
   temasTratados.nombre+ ": " + temasTratados.descripcion
  }
  
   def crearReunion(id:Int, tipo:String,integrantes :ListBuffer[Usuario],nombreTema:String,descripcionTema:String){
    var nuevaReunion = new Reunion(id)
    var tipoReunion = TipoDeReunion
    nuevaReunion.tipoDeReunion = tipoReunion.withName(tipo)
    nuevaReunion.integrantes = integrantes
    nuevaReunion.temasTratados = new Tema()
    nuevaReunion.temasTratados.nombre =  nombreTema
    nuevaReunion.temasTratados.descripcion =  descripcionTema
    nuevaReunion
  }
}