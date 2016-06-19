package controllers

import model.Project
import scala.collection.mutable.ListBuffer

class AppPorDefecto {
  
  var proyectos = new ListBuffer[Project]
  proyectos.+=(new Project(1, "ScrumTask"))
  proyectos.+=(new Project(2, "Public Project"))
  proyectos.+=(new Project(3, "Secret Project"))
}