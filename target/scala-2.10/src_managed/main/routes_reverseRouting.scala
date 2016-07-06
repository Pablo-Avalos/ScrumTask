// @SOURCE:/home/matias/TPI-1er-cuatri-2016/Ingenieria/workspace/ScrumTask/conf/routes
// @HASH:3a9312f9c498022106df95e5b731b443dc58341e
// @DATE:Wed Jul 06 09:52:17 ART 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
// @LINE:6
class ReverseAssets {
    

// @LINE:9
// @LINE:6
def at(file:String): Call = {
   (file: @unchecked) match {
// @LINE:6
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "ScrumTask/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
// @LINE:9
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
   }
}
                                                
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:12
def agregarTarea(idProyecto:Int, numeroRelease:Int, numeroSprint:Int, nombre:String, descripcion:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "agregarTarea/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[Int]].unbind("numeroRelease", numeroRelease) + "/" + implicitly[PathBindable[Int]].unbind("numeroSprint", numeroSprint) + "/" + implicitly[PathBindable[String]].unbind("nombre", dynamicString(nombre)) + "/" + implicitly[PathBindable[String]].unbind("descripcion", dynamicString(descripcion)))
}
                                                

// @LINE:18
def eliminarProyecto(idProyecto:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "eliminarProyecto/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto))
}
                                                

// @LINE:17
def eliminarTarea(idProyecto:Int, idRelease:Int, idSprint:Int, id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "eliminarTarea/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[Int]].unbind("idRelease", idRelease) + "/" + implicitly[PathBindable[Int]].unbind("idSprint", idSprint) + "/" + implicitly[PathBindable[Int]].unbind("id", id))
}
                                                

// @LINE:25
def getIntegrantesReunion(idProyecto:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "integrantesReunion/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto))
}
                                                

// @LINE:19
def crearRelease(idProyecto:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "crearRelease/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto))
}
                                                

// @LINE:22
def getTipoReuniones(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tiposDeReunion")
}
                                                

// @LINE:20
def crearSprint(idProyecto:Int, numeroRelease:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "crearSprint/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[Int]].unbind("numeroRelease", numeroRelease))
}
                                                

// @LINE:10
def getProyectos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "proyectos")
}
                                                

// @LINE:23
def guardarReunion(idProyecto:Int, idReunion:Int, fecha:String, tipo:String, nombre:String, descripcion:String, integrantes:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "guardarReunion/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[Int]].unbind("idReunion", idReunion) + "/" + implicitly[PathBindable[String]].unbind("fecha", dynamicString(fecha)) + "/" + implicitly[PathBindable[String]].unbind("tipo", dynamicString(tipo)) + "/" + implicitly[PathBindable[String]].unbind("nombre", dynamicString(nombre)) + "/" + implicitly[PathBindable[String]].unbind("descripcion", dynamicString(descripcion)) + "/" + implicitly[PathBindable[String]].unbind("integrantes", dynamicString(integrantes)))
}
                                                

// @LINE:11
def getTablero(idProyecto:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tablero/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto))
}
                                                

// @LINE:16
def getReuniones(idProyecto:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reuniones/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto))
}
                                                

// @LINE:15
def eliminarColaborador(idProyecto:Int, nombreColaborador:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "eliminarIntegrante/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[String]].unbind("nombreColaborador", dynamicString(nombreColaborador)))
}
                                                

// @LINE:14
def agregarColaborador(idProyecto:Int, nombre:String, tipo:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "agregarIntegrante/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[String]].unbind("nombre", dynamicString(nombre)) + "/" + implicitly[PathBindable[String]].unbind("tipo", dynamicString(tipo)))
}
                                                

// @LINE:13
def getColaboradores(idProyecto:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "integrantes/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto))
}
                                                

// @LINE:24
def agregarProyecto(nombre:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "agregarProyecto/" + implicitly[PathBindable[String]].unbind("nombre", dynamicString(nombre)))
}
                                                

// @LINE:26
def getObtenerUsuariosDeReunion(idProyecto:Int, idReunion:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "usuariosReunion/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[Int]].unbind("idReunion", idReunion))
}
                                                

// @LINE:21
def eliminarReunion(idProyecto:Int, idReunion:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "eliminarReunion/" + implicitly[PathBindable[Int]].unbind("idProyecto", idProyecto) + "/" + implicitly[PathBindable[Int]].unbind("idReunion", idReunion))
}
                                                
    
}
                          
}
                  


// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:9
// @LINE:6
class ReverseAssets {
    

// @LINE:9
// @LINE:6
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ScrumTask/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:12
def agregarTarea : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.agregarTarea",
   """
      function(idProyecto,numeroRelease,numeroSprint,nombre,descripcion) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "agregarTarea/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("numeroRelease", numeroRelease) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("numeroSprint", numeroSprint) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nombre", encodeURIComponent(nombre)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("descripcion", encodeURIComponent(descripcion))})
      }
   """
)
                        

// @LINE:18
def eliminarProyecto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.eliminarProyecto",
   """
      function(idProyecto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eliminarProyecto/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto)})
      }
   """
)
                        

// @LINE:17
def eliminarTarea : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.eliminarTarea",
   """
      function(idProyecto,idRelease,idSprint,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eliminarTarea/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idRelease", idRelease) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idSprint", idSprint) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:25
def getIntegrantesReunion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getIntegrantesReunion",
   """
      function(idProyecto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "integrantesReunion/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto)})
      }
   """
)
                        

// @LINE:19
def crearRelease : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.crearRelease",
   """
      function(idProyecto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "crearRelease/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto)})
      }
   """
)
                        

// @LINE:22
def getTipoReuniones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getTipoReuniones",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tiposDeReunion"})
      }
   """
)
                        

// @LINE:20
def crearSprint : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.crearSprint",
   """
      function(idProyecto,numeroRelease) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "crearSprint/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("numeroRelease", numeroRelease)})
      }
   """
)
                        

// @LINE:10
def getProyectos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getProyectos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "proyectos"})
      }
   """
)
                        

// @LINE:23
def guardarReunion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.guardarReunion",
   """
      function(idProyecto,idReunion,fecha,tipo,nombre,descripcion,integrantes) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "guardarReunion/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idReunion", idReunion) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("fecha", encodeURIComponent(fecha)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tipo", encodeURIComponent(tipo)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nombre", encodeURIComponent(nombre)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("descripcion", encodeURIComponent(descripcion)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("integrantes", encodeURIComponent(integrantes))})
      }
   """
)
                        

// @LINE:11
def getTablero : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getTablero",
   """
      function(idProyecto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tablero/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto)})
      }
   """
)
                        

// @LINE:16
def getReuniones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getReuniones",
   """
      function(idProyecto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reuniones/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto)})
      }
   """
)
                        

// @LINE:15
def eliminarColaborador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.eliminarColaborador",
   """
      function(idProyecto,nombreColaborador) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eliminarIntegrante/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nombreColaborador", encodeURIComponent(nombreColaborador))})
      }
   """
)
                        

// @LINE:14
def agregarColaborador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.agregarColaborador",
   """
      function(idProyecto,nombre,tipo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "agregarIntegrante/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nombre", encodeURIComponent(nombre)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tipo", encodeURIComponent(tipo))})
      }
   """
)
                        

// @LINE:13
def getColaboradores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getColaboradores",
   """
      function(idProyecto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "integrantes/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto)})
      }
   """
)
                        

// @LINE:24
def agregarProyecto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.agregarProyecto",
   """
      function(nombre) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "agregarProyecto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nombre", encodeURIComponent(nombre))})
      }
   """
)
                        

// @LINE:26
def getObtenerUsuariosDeReunion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getObtenerUsuariosDeReunion",
   """
      function(idProyecto,idReunion) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuariosReunion/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idReunion", idReunion)})
      }
   """
)
                        

// @LINE:21
def eliminarReunion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.eliminarReunion",
   """
      function(idProyecto,idReunion) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eliminarReunion/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idProyecto", idProyecto) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("idReunion", idReunion)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Home page""", _prefix + """ScrumTask/$file<.+>""")
)
                      
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:12
def agregarTarea(idProyecto:Int, numeroRelease:Int, numeroSprint:Int, nombre:String, descripcion:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.agregarTarea(idProyecto, numeroRelease, numeroSprint, nombre, descripcion), HandlerDef(this, "controllers.Application", "agregarTarea", Seq(classOf[Int], classOf[Int], classOf[Int], classOf[String], classOf[String]), "GET", """""", _prefix + """agregarTarea/$idProyecto<[^/]+>/$numeroRelease<[^/]+>/$numeroSprint<[^/]+>/$nombre<[^/]+>/$descripcion<[^/]+>""")
)
                      

// @LINE:18
def eliminarProyecto(idProyecto:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.eliminarProyecto(idProyecto), HandlerDef(this, "controllers.Application", "eliminarProyecto", Seq(classOf[Int]), "GET", """""", _prefix + """eliminarProyecto/$idProyecto<[^/]+>""")
)
                      

// @LINE:17
def eliminarTarea(idProyecto:Int, idRelease:Int, idSprint:Int, id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.eliminarTarea(idProyecto, idRelease, idSprint, id), HandlerDef(this, "controllers.Application", "eliminarTarea", Seq(classOf[Int], classOf[Int], classOf[Int], classOf[Int]), "GET", """""", _prefix + """eliminarTarea/$idProyecto<[^/]+>/$idRelease<[^/]+>/$idSprint<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:25
def getIntegrantesReunion(idProyecto:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getIntegrantesReunion(idProyecto), HandlerDef(this, "controllers.Application", "getIntegrantesReunion", Seq(classOf[Int]), "GET", """""", _prefix + """integrantesReunion/$idProyecto<[^/]+>""")
)
                      

// @LINE:19
def crearRelease(idProyecto:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.crearRelease(idProyecto), HandlerDef(this, "controllers.Application", "crearRelease", Seq(classOf[Int]), "GET", """""", _prefix + """crearRelease/$idProyecto<[^/]+>""")
)
                      

// @LINE:22
def getTipoReuniones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getTipoReuniones(), HandlerDef(this, "controllers.Application", "getTipoReuniones", Seq(), "GET", """""", _prefix + """tiposDeReunion""")
)
                      

// @LINE:20
def crearSprint(idProyecto:Int, numeroRelease:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.crearSprint(idProyecto, numeroRelease), HandlerDef(this, "controllers.Application", "crearSprint", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """crearSprint/$idProyecto<[^/]+>/$numeroRelease<[^/]+>""")
)
                      

// @LINE:10
def getProyectos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getProyectos(), HandlerDef(this, "controllers.Application", "getProyectos", Seq(), "GET", """""", _prefix + """proyectos""")
)
                      

// @LINE:23
def guardarReunion(idProyecto:Int, idReunion:Int, fecha:String, tipo:String, nombre:String, descripcion:String, integrantes:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.guardarReunion(idProyecto, idReunion, fecha, tipo, nombre, descripcion, integrantes), HandlerDef(this, "controllers.Application", "guardarReunion", Seq(classOf[Int], classOf[Int], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """guardarReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>/$fecha<[^/]+>/$tipo<[^/]+>/$nombre<[^/]+>/$descripcion<[^/]+>/$integrantes<[^/]+>""")
)
                      

// @LINE:11
def getTablero(idProyecto:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getTablero(idProyecto), HandlerDef(this, "controllers.Application", "getTablero", Seq(classOf[Int]), "GET", """""", _prefix + """tablero/$idProyecto<[^/]+>""")
)
                      

// @LINE:16
def getReuniones(idProyecto:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getReuniones(idProyecto), HandlerDef(this, "controllers.Application", "getReuniones", Seq(classOf[Int]), "GET", """""", _prefix + """reuniones/$idProyecto<[^/]+>""")
)
                      

// @LINE:15
def eliminarColaborador(idProyecto:Int, nombreColaborador:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.eliminarColaborador(idProyecto, nombreColaborador), HandlerDef(this, "controllers.Application", "eliminarColaborador", Seq(classOf[Int], classOf[String]), "GET", """""", _prefix + """eliminarIntegrante/$idProyecto<[^/]+>/$nombreColaborador<[^/]+>""")
)
                      

// @LINE:14
def agregarColaborador(idProyecto:Int, nombre:String, tipo:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.agregarColaborador(idProyecto, nombre, tipo), HandlerDef(this, "controllers.Application", "agregarColaborador", Seq(classOf[Int], classOf[String], classOf[String]), "GET", """""", _prefix + """agregarIntegrante/$idProyecto<[^/]+>/$nombre<[^/]+>/$tipo<[^/]+>""")
)
                      

// @LINE:13
def getColaboradores(idProyecto:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getColaboradores(idProyecto), HandlerDef(this, "controllers.Application", "getColaboradores", Seq(classOf[Int]), "GET", """""", _prefix + """integrantes/$idProyecto<[^/]+>""")
)
                      

// @LINE:24
def agregarProyecto(nombre:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.agregarProyecto(nombre), HandlerDef(this, "controllers.Application", "agregarProyecto", Seq(classOf[String]), "GET", """""", _prefix + """agregarProyecto/$nombre<[^/]+>""")
)
                      

// @LINE:26
def getObtenerUsuariosDeReunion(idProyecto:Int, idReunion:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getObtenerUsuariosDeReunion(idProyecto, idReunion), HandlerDef(this, "controllers.Application", "getObtenerUsuariosDeReunion", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """usuariosReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>""")
)
                      

// @LINE:21
def eliminarReunion(idProyecto:Int, idReunion:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.eliminarReunion(idProyecto, idReunion), HandlerDef(this, "controllers.Application", "eliminarReunion", Seq(classOf[Int], classOf[Int]), "GET", """""", _prefix + """eliminarReunion/$idProyecto<[^/]+>/$idReunion<[^/]+>""")
)
                      
    
}
                          
}
        
    