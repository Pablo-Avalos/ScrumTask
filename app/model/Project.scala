package model
import scala.collection.mutable.ListBuffer

case class Project (idP:Int, nombreP:String){
  var id = idP
  var nombre=nombreP
  var tablero = null : Tablero
  var colaboradores = new ListBuffer[Usuario]
  var reuniones = new ListBuffer[Reunion]
  
  def agregarColaborador(colaborador:Usuario){
    colaboradores.+=(colaborador)
  }
  
  def eliminarColaborador(nombre: String){
    colaboradores = colaboradores.filterNot { c => c.name == nombre }
  }
  
  def agregarReunion(reunion:Reunion){
    reuniones.+=(reunion)
  }
  
  def eliminarTarea(id: Int){
    tablero.eliminarTarea(id)
  }
  def eliminarReunion(idReunion: Int){
    reuniones = reuniones.filterNot { c => c.id == idReunion }
  }
}