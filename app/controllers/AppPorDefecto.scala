package controllers

import scala.collection.mutable.ListBuffer
import model._

class AppPorDefecto {
  
  
  var integrante1 = new Colaborador("Pepe")
  integrante1.name = "Pepe"
  
  var integrante2 = new Colaborador("Pipo")
  integrante2.name = "Pipo"
  
  var integrante3 = new Colaborador("Pancho")
  integrante3.name = "Pancho"
  
  var integrante4 = new Colaborador("Moncho")
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

  var reunion1 = new Reunion(100)
  var reunion2 = new Reunion(101)
  var reunion3 = new Reunion(102)
  
  var colaborador = new Colaborador("colaborador uno")
  var scrummaster = new ScrumMaster("scrummaster")
  var programowner = new ProductOwner("programowner")
  
  reunion1.integrantes.+=(colaborador)
  reunion1.integrantes.+=(scrummaster)
  reunion2.integrantes.+=(programowner)
  reunion2.integrantes.+=(colaborador)
  reunion3.integrantes.+=(scrummaster)
  reunion3.integrantes.+=(colaborador)
  reunion3.integrantes.+=(programowner)
  
  var tema1 = new Tema
  tema1.nombre = "Preparar el ambiente"
  tema1.descripcion = "Breve explicación de como preparar el ambiente de desarrollo."
  tema1.temas.+=("primer paso")
  tema1.temas.+=("segundo paso")

  var tema2 = new Tema
  tema2.nombre = "Hacer ScrumTask"
  tema2.descripcion = "Breve explicación de como crear ScrumTask."
  tema2.temas.+=("primer paso")
  tema2.temas.+=("segundo paso")
  
  reunion1.temasTratados=tema1
  reunion2.temasTratados=tema2
  reunion3.temasTratados=tema1

  
  reunion1.tipoDeReunion = TipoDeReunion.Daily
  reunion2.tipoDeReunion = TipoDeReunion.Planning
  reunion3.tipoDeReunion = TipoDeReunion.Retrospective

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
  proyecto3.agregarColaborador(integrante3)
  
  var proyecto4 = new Project(4, "Ultra Secret Project")
  proyecto4.tablero = new Tablero(4)
  proyecto4.agregarColaborador(integrante4)

  proyectos.+=(proyecto1)
  proyectos.+=(proyecto2)
  proyectos.+=(proyecto3)
  proyectos.+=(proyecto4)

  proyecto1.reuniones.+=(reunion1)
  proyecto1.reuniones.+=(reunion2)
  proyecto1.reuniones.+=(reunion3)
  
  proyecto2.reuniones.+=(reunion1)
    
  proyecto3.reuniones.+=(reunion2)
  proyecto3.reuniones.+=(reunion3)

  proyecto4.reuniones.+=(reunion1)
  proyecto4.reuniones.+=(reunion2)
  
  def getTablero(idProyecto: Int): Tablero = {
    proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null).tablero
  }
 
  def getProyecto(idProyecto: Int): Project = {
    proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null)
  }
  
  def getColaboradores (idProyecto: Int): ListBuffer[Usuario] = {
    proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null).colaboradores
  }
  
  def getReuniones(idProyecto: Int): ListBuffer[Reunion] = {
     proyectos.find { proyecto => proyecto.id == idProyecto }.getOrElse(null).reuniones
  }
  
  def eliminarProyecto(idProyecto: Int) = proyectos = proyectos.filterNot { p => p.id == idProyecto }
 
  
}