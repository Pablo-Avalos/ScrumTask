package model
import scala.collection.mutable.ListBuffer

case class Project (id: Int, var nombre: String){

  var tablero = null : Tablero
  var colaboradores = new ListBuffer[Colaborador]
  
  def agregarColaborador(colaborador:Colaborador){
    colaboradores.+=(colaborador)
  }
}