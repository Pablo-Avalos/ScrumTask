package model
import scala.collection.mutable.ListBuffer

case class Project(idP: Int, nombreP: String) {
  var id = idP
  var nombre = nombreP
  var tablero = null: Tablero
  var colaboradores = new ListBuffer[Usuario]
  var reuniones = new ListBuffer[Reunion]
  var idsDisponiblesReunion = new ListBuffer[Int]

  def agregarColaborador(colaborador: Usuario) {
    colaboradores.+=(colaborador)
  }

  def eliminarColaborador(nombre: String) {
    colaboradores = colaboradores.filterNot { c => c.name == nombre }
  }

  def agregarReunion(reunion: Reunion) {
    reuniones.+=(reunion)
  }

  def eliminarTarea(id: Int) {
    tablero.eliminarTarea(id)
  }
  def eliminarReunion(idReunion: Int) {
    reuniones = reuniones.filterNot { r => r.id == idReunion }
    idsDisponiblesReunion=idsDisponiblesReunion.+=(idReunion)
  }

  def obtenerIdsReunion(): Int = {
    var id = 0
      if (idsDisponiblesReunion.size >= 1) {
        id = idsDisponiblesReunion.head.asInstanceOf[Int]
        idsDisponiblesReunion=idsDisponiblesReunion.filterNot { e => e==id }
      } else {
        id = reuniones.size
      }
    id
  }
  
  def crearReunion(id:Int, tipo:String,integrantesReunion :ListBuffer[Int],nombreTema:String,descripcionTema:String){
    var nuevaReunion = new Reunion(id)
    var ps = TipoDeReunion
    nuevaReunion.tipoDeReunion = ps.withName(tipo)
    nuevaReunion.integrantes = colaboradores.filter { colaborado => integrantesReunion.contains(colaborado.id)}
    nuevaReunion.temasTratados = new Tema()
    nuevaReunion.temasTratados.nombre =  nombreTema
    nuevaReunion.temasTratados.descripcion =  descripcionTema
    reuniones.+=(nuevaReunion)
  }
}