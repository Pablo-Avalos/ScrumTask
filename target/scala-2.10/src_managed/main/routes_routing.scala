// @SOURCE:C:/Users/Diego/Desktop/TP-Ingenieria/ScrumTask/conf/routes
// @HASH:e4fe41117a5dbecb4ebd7a92a5652ea6026f8dc2
// @DATE:Sun Jul 03 23:02:11 ART 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Assets_at0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ScrumTask/"),DynamicPart("file", """.+""",false))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:10
private[this] lazy val controllers_Application_getProyectos2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("proyectos"))))
        

// @LINE:11
private[this] lazy val controllers_Application_getTablero3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tablero/"),DynamicPart("idProyecto", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_Application_agregarTarea4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agregarTarea/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("numeroRelease", """[^/]+""",true),StaticPart("/"),DynamicPart("numeroSprint", """[^/]+""",true),StaticPart("/"),DynamicPart("nombre", """[^/]+""",true),StaticPart("/"),DynamicPart("descripcion", """[^/]+""",true))))
        

// @LINE:13
private[this] lazy val controllers_Application_getColaboradores5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("integrantes/"),DynamicPart("idProyecto", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_Application_agregarColaborador6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agregarIntegrante/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("nombre", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Application_eliminarColaborador7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("eliminarIntegrante/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("nombreColaborador", """[^/]+""",true))))
        

// @LINE:16
private[this] lazy val controllers_Application_getReuniones8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reuniones/"),DynamicPart("idProyecto", """[^/]+""",true))))
        

// @LINE:17
private[this] lazy val controllers_Application_eliminarTarea9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("eliminarTarea/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("idRelease", """[^/]+""",true),StaticPart("/"),DynamicPart("idSprint", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:18
private[this] lazy val controllers_Application_eliminarProyecto10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("eliminarProyecto/"),DynamicPart("idProyecto", """[^/]+""",true))))
        

// @LINE:19
private[this] lazy val controllers_Application_crearRelease11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("crearRelease/"),DynamicPart("idProyecto", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_Application_crearSprint12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("crearSprint/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("numeroRelease", """[^/]+""",true))))
        

// @LINE:21
private[this] lazy val controllers_Application_eliminarReunion13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("eliminarReunion/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("idReunion", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_Application_getTipoReuniones14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tiposDeReunion"))))
        

// @LINE:23
private[this] lazy val controllers_Application_guardarReunion15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("guardarReunion/"),DynamicPart("idProyecto", """[^/]+""",true),StaticPart("/"),DynamicPart("idReunion", """[^/]+""",true),StaticPart("/"),DynamicPart("tipo", """[^/]+""",true),StaticPart("/"),DynamicPart("nombre", """[^/]+""",true),StaticPart("/"),DynamicPart("descripcion", """[^/]+""",true),StaticPart("/"),DynamicPart("integrantes", """[^/]+""",true))))
        

// @LINE:24
private[this] lazy val controllers_Application_agregarProyecto16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agregarProyecto/"),DynamicPart("nombre", """[^/]+""",true))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ScrumTask/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """proyectos""","""controllers.Application.getProyectos"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tablero/$idProyecto<[^/]+>""","""controllers.Application.getTablero(idProyecto:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agregarTarea/$idProyecto<[^/]+>/$numeroRelease<[^/]+>/$numeroSprint<[^/]+>/$nombre<[^/]+>/$descripcion<[^/]+>""","""controllers.Application.agregarTarea(idProyecto:Int, numeroRelease:Int, numeroSprint:Int, nombre:String, descripcion:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """integrantes/$idProyecto<[^/]+>""","""controllers.Application.getColaboradores(idProyecto:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agregarIntegrante/$idProyecto<[^/]+>/$nombre<[^/]+>""","""controllers.Application.agregarColaborador(idProyecto:Int, nombre:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """eliminarIntegrante/$idProyecto<[^/]+>/$nombreColaborador<[^/]+>""","""controllers.Application.eliminarColaborador(idProyecto:Int, nombreColaborador:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reuniones/$idProyecto<[^/]+>""","""controllers.Application.getReuniones(idProyecto:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """eliminarTarea/$idProyecto<[^/]+>/$idRelease<[^/]+>/$idSprint<[^/]+>/$id<[^/]+>""","""controllers.Application.eliminarTarea(idProyecto:Int, idRelease:Int, idSprint:Int, id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """eliminarProyecto/$idProyecto<[^/]+>""","""controllers.Application.eliminarProyecto(idProyecto:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """crearRelease/$idProyecto<[^/]+>""","""controllers.Application.crearRelease(idProyecto:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """crearSprint/$idProyecto<[^/]+>/$numeroRelease<[^/]+>""","""controllers.Application.crearSprint(idProyecto:Int, numeroRelease:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """eliminarReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>""","""controllers.Application.eliminarReunion(idProyecto:Int, idReunion:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tiposDeReunion""","""controllers.Application.getTipoReuniones"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """guardarReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>/$tipo<[^/]+>/$nombre<[^/]+>/$descripcion<[^/]+>/$integrantes<[^/]+>""","""controllers.Application.guardarReunion(idProyecto:Int, idReunion:Int, tipo:String, nombre:String, descripcion:String, integrantes:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agregarProyecto/$nombre<[^/]+>""","""controllers.Application.agregarProyecto(nombre:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Assets_at0(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Home page""", Routes.prefix + """ScrumTask/$file<.+>"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:10
case controllers_Application_getProyectos2(params) => {
   call { 
        invokeHandler(controllers.Application.getProyectos, HandlerDef(this, "controllers.Application", "getProyectos", Nil,"GET", """""", Routes.prefix + """proyectos"""))
   }
}
        

// @LINE:11
case controllers_Application_getTablero3(params) => {
   call(params.fromPath[Int]("idProyecto", None)) { (idProyecto) =>
        invokeHandler(controllers.Application.getTablero(idProyecto), HandlerDef(this, "controllers.Application", "getTablero", Seq(classOf[Int]),"GET", """""", Routes.prefix + """tablero/$idProyecto<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_Application_agregarTarea4(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[Int]("numeroRelease", None), params.fromPath[Int]("numeroSprint", None), params.fromPath[String]("nombre", None), params.fromPath[String]("descripcion", None)) { (idProyecto, numeroRelease, numeroSprint, nombre, descripcion) =>
        invokeHandler(controllers.Application.agregarTarea(idProyecto, numeroRelease, numeroSprint, nombre, descripcion), HandlerDef(this, "controllers.Application", "agregarTarea", Seq(classOf[Int], classOf[Int], classOf[Int], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """agregarTarea/$idProyecto<[^/]+>/$numeroRelease<[^/]+>/$numeroSprint<[^/]+>/$nombre<[^/]+>/$descripcion<[^/]+>"""))
   }
}
        

// @LINE:13
case controllers_Application_getColaboradores5(params) => {
   call(params.fromPath[Int]("idProyecto", None)) { (idProyecto) =>
        invokeHandler(controllers.Application.getColaboradores(idProyecto), HandlerDef(this, "controllers.Application", "getColaboradores", Seq(classOf[Int]),"GET", """""", Routes.prefix + """integrantes/$idProyecto<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_Application_agregarColaborador6(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[String]("nombre", None)) { (idProyecto, nombre) =>
        invokeHandler(controllers.Application.agregarColaborador(idProyecto, nombre), HandlerDef(this, "controllers.Application", "agregarColaborador", Seq(classOf[Int], classOf[String]),"GET", """""", Routes.prefix + """agregarIntegrante/$idProyecto<[^/]+>/$nombre<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Application_eliminarColaborador7(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[String]("nombreColaborador", None)) { (idProyecto, nombreColaborador) =>
        invokeHandler(controllers.Application.eliminarColaborador(idProyecto, nombreColaborador), HandlerDef(this, "controllers.Application", "eliminarColaborador", Seq(classOf[Int], classOf[String]),"GET", """""", Routes.prefix + """eliminarIntegrante/$idProyecto<[^/]+>/$nombreColaborador<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_Application_getReuniones8(params) => {
   call(params.fromPath[Int]("idProyecto", None)) { (idProyecto) =>
        invokeHandler(controllers.Application.getReuniones(idProyecto), HandlerDef(this, "controllers.Application", "getReuniones", Seq(classOf[Int]),"GET", """""", Routes.prefix + """reuniones/$idProyecto<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_Application_eliminarTarea9(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[Int]("idRelease", None), params.fromPath[Int]("idSprint", None), params.fromPath[Int]("id", None)) { (idProyecto, idRelease, idSprint, id) =>
        invokeHandler(controllers.Application.eliminarTarea(idProyecto, idRelease, idSprint, id), HandlerDef(this, "controllers.Application", "eliminarTarea", Seq(classOf[Int], classOf[Int], classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """eliminarTarea/$idProyecto<[^/]+>/$idRelease<[^/]+>/$idSprint<[^/]+>/$id<[^/]+>"""))
   }
}
        

// @LINE:18
case controllers_Application_eliminarProyecto10(params) => {
   call(params.fromPath[Int]("idProyecto", None)) { (idProyecto) =>
        invokeHandler(controllers.Application.eliminarProyecto(idProyecto), HandlerDef(this, "controllers.Application", "eliminarProyecto", Seq(classOf[Int]),"GET", """""", Routes.prefix + """eliminarProyecto/$idProyecto<[^/]+>"""))
   }
}
        

// @LINE:19
case controllers_Application_crearRelease11(params) => {
   call(params.fromPath[Int]("idProyecto", None)) { (idProyecto) =>
        invokeHandler(controllers.Application.crearRelease(idProyecto), HandlerDef(this, "controllers.Application", "crearRelease", Seq(classOf[Int]),"GET", """""", Routes.prefix + """crearRelease/$idProyecto<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_Application_crearSprint12(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[Int]("numeroRelease", None)) { (idProyecto, numeroRelease) =>
        invokeHandler(controllers.Application.crearSprint(idProyecto, numeroRelease), HandlerDef(this, "controllers.Application", "crearSprint", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """crearSprint/$idProyecto<[^/]+>/$numeroRelease<[^/]+>"""))
   }
}
        

// @LINE:21
case controllers_Application_eliminarReunion13(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[Int]("idReunion", None)) { (idProyecto, idReunion) =>
        invokeHandler(controllers.Application.eliminarReunion(idProyecto, idReunion), HandlerDef(this, "controllers.Application", "eliminarReunion", Seq(classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """eliminarReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_Application_getTipoReuniones14(params) => {
   call { 
        invokeHandler(controllers.Application.getTipoReuniones, HandlerDef(this, "controllers.Application", "getTipoReuniones", Nil,"GET", """""", Routes.prefix + """tiposDeReunion"""))
   }
}
        

// @LINE:23
case controllers_Application_guardarReunion15(params) => {
   call(params.fromPath[Int]("idProyecto", None), params.fromPath[Int]("idReunion", None), params.fromPath[String]("tipo", None), params.fromPath[String]("nombre", None), params.fromPath[String]("descripcion", None), params.fromPath[String]("integrantes", None)) { (idProyecto, idReunion, tipo, nombre, descripcion, integrantes) =>
        invokeHandler(controllers.Application.guardarReunion(idProyecto, idReunion, tipo, nombre, descripcion, integrantes), HandlerDef(this, "controllers.Application", "guardarReunion", Seq(classOf[Int], classOf[Int], classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """guardarReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>/$tipo<[^/]+>/$nombre<[^/]+>/$descripcion<[^/]+>/$integrantes<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_Application_agregarProyecto16(params) => {
   call(params.fromPath[String]("nombre", None)) { (nombre) =>
        invokeHandler(controllers.Application.agregarProyecto(nombre), HandlerDef(this, "controllers.Application", "agregarProyecto", Seq(classOf[String]),"GET", """""", Routes.prefix + """agregarProyecto/$nombre<[^/]+>"""))
   }
}
        
}

}
     