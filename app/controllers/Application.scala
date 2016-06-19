package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.Result
import scala.collection.mutable.ListBuffer
import play.api.libs.json.Json
import play.api.libs.functional.syntax._
import model._



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
    
  val appPorDefecto = new AppPorDefecto
        
  implicit val proyectoWrites = Json.writes[Project]
  
  
  def proyectos = Action {
    val json = Json.toJson(appPorDefecto.proyectos)
    Ok(json)
  }
  
  
  
}