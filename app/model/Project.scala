package model
import scala.collection.mutable.ListBuffer
class Project {
  var name = null : String
  var tablero = null : Tablero
  var colaboradores =new ListBuffer[Colaborador]
  
  def agregarColaborador(colaborador:Colaborador){
    colaboradores.+=(colaborador)
  }
}