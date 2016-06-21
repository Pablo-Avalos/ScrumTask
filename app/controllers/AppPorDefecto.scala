package controllers

import model.Project
import scala.collection.mutable.ListBuffer
import model.Tablero
import model.Tarea
import model.Colaborador

class AppPorDefecto {
  
  
  var integrante1 = new Colaborador()
  integrante1.name = "Pepe"
  
  var integrante2 = new Colaborador()
  integrante2.name = "Pipo"
  
  var integrante3 = new Colaborador()
  integrante3.name = "Pancho"
  
  var integrante4 = new Colaborador()
  integrante4.name = "Moncho"

  var tarea1 = new Tarea(25, "Buscar")
  tarea1.autor = "Pipo"
  tarea1.descripcion = "Buscar algo"

  var tarea2 = new Tarea(26, "Eliminar")
  tarea2.autor = "Pepe"
  tarea2.descripcion = "Eliminar algo"

  var tablero1 = new Tablero(1)
  tablero1.agregarTarea(new Tarea(27, "Trabajar"))
  tablero1.agregarTarea(new Tarea(26, "Hacer algo"))
  tablero1.agregarTarea(tarea1)

  var tablero2 = new Tablero(2)
  tablero2.agregarTarea(new Tarea(27, "Buscar"))
  tablero2.agregarTarea(new Tarea(28, "Hacer algo"))
  tablero2.agregarTarea(tarea2)

  var proyectos = new ListBuffer[Project]

  var proyecto1 = new Project(1, "ScrumTask")
  proyecto1.tablero = tablero1
  proyecto1.agregarColaborador(integrante1)
  proyecto1.agregarColaborador(integrante2)
  
  var proyecto2 = new Project(2, "Public Project")
  proyecto2.tablero = tablero2
  proyecto2.agregarColaborador(integrante3)
  proyecto2.agregarColaborador(integrante4)
  
  var proyecto3 = new Project(3, "Secret Project")
  proyecto3.tablero = new Tablero(3)
  
  var proyecto4 = new Project(4, "Ultra Secret Project")
  proyecto4.tablero = new Tablero(4)

  proyectos.+=(proyecto1)
  proyectos.+=(proyecto2)
  proyectos.+=(proyecto3)
  proyectos.+=(proyecto4)

  def getTablero(idProyecto: Int): Tablero = {
    proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null).tablero
  }
 
  def getProyecto(idProyecto: Int): Project = {
    proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null)
  }
  
  def getColaboradores (idProyecto: Int): ListBuffer[Colaborador] = {
    proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null).colaboradores
  }
  
}