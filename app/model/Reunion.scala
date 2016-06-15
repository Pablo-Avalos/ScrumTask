package model

import scala.collection.mutable.ListBuffer

import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.sql.Time

class Reunion {
	var fecha = null: Date
	var horaDeInicio = null: Time
//var horaDeFinalizacion = null: Time
	var integrantes = new ListBuffer[Usuario]

			def setFecha(dia: Integer, mes: Integer, anio: Integer) {
	       var nvaFecha = new Date((anio - 1900), mes - 1, dia)
				 var df = getDateInstance(LONG, Locale.ENGLISH)
				 //println(df format fecha)
	    }

	    def setHora(hora: Integer, minutos: Integer) { 
		     var nvaHora = new Time(hora, minutos,0)
	    
				 //println(t)
	    }
	    
	    def agregarIntegrante(participante:Usuario){
        integrantes.+=(participante)
      }
      
	    def agregarTema(lista: ListBuffer[String], descripicionDelTema:String){
        lista.+=:(descripicionDelTema)
      }
	    
	    def crearReunion(dia:Integer, mes:Integer, anio:Integer, hora:Integer, minutos:Integer ){
         this.setFecha(dia,mes,anio)
         this.setHora(hora, minutos)
      }
}