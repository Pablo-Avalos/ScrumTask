package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.Result
import play.libs.Json
import scala.collection.mutable.ListBuffer
import model.Project
import model.Project



object Application extends Controller {

//  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
//  }
//
//  public static Result libros() {
//     response().setContentType("application/json");
//     Collection<Libro> libros = Biblioteca.getInstance().todasLasInstancias();
//     return ok(Json.toJson(libros));
//    }
        def proyectos = Action {
        var project =  new Project
        project.name = "Mi Primer Proyecto"
        val json = Json.toJson(project.toString())
        print(json)
          Ok(Json.stringify(json))
        }
        
}