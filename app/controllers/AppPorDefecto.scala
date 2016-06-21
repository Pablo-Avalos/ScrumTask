package controllers

import model.Project
import scala.collection.mutable.ListBuffer
import model.Tablero
import model.Tarea

class AppPorDefecto {

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

  var proyecto2 = new Project(2, "Public Project")
  proyecto2.tablero = tablero2
  
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
 

}