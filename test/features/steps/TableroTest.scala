package features.steps

import org.junit.runner.RunWith

import org.junit.Assert._
import cucumber.api.PendingException
import cucumber.api.junit.Cucumber
import cucumber.api.scala.EN
import cucumber.api.scala.ScalaDsl
import model.Tablero
import model.Release
import model.Tarea


@RunWith(classOf[Cucumber])
class TableroTest extends ScalaDsl with EN{
  
  var tablero = null: Tablero
  var tarea = null: Tarea
  var tarea2 = null: Tarea
  var release = null: Release

  Given("""^Un tablero sin tarea$""") { () =>
    //// Express the Regexp above with the code you wish you had
  }
  When("""^Creo un tablero con id (\d+) sin tarea$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(arg0)
  }
  Then("""^La cantidad de tareas en el tablero debe ser (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.tareas.size) 
  }
  
  Given("""^Un tablero con una tarea con id (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    tarea = new Tarea(arg0,null)
  }
  When("""^Creo un tablero con id (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(arg0)
    tablero.agregarTarea(tarea)
  }
  Then("""^La cantidad de tareas del tablero debe ser (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.tareas.size) 
  }
  
  Given("""^Un tablero inicializado y una tarea inicializada$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(1)
    tarea = new Tarea(1,null)
  }
  When("""^Agrego la tarea con nombre "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.nombre=arg0
    tablero.agregarTarea(tarea)
  }
  Then("""^La primer tarea del tablero debe ser "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.tareas(0).nombre) 
  }
  
  Given("""^Un tablero inicializado y dos tarea inicializadas$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(1)
    tarea = new Tarea(1,null)
    tarea2 = new Tarea(2,null)
  }
  When("""^Agrego la tarea con nombre "([^"]*)" y agrego la tarea con nombre "([^"]*)"$""") { (arg0: String,arg1: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.nombre=arg0
    tarea2.nombre=arg1
    tablero.agregarTarea(tarea)
    tablero.agregarTarea(tarea2)
  }
  Then("""^La primer tarea del tablero debe ser "([^"]*)" y la segunda "([^"]*)"$""") { (arg0: String,arg1: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.tareas(0).nombre) 
    assertEquals(arg1, tablero.tareas(1).nombre) 
  }
  
  Given("""^Un tablero sin release$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(1)
    release = new Release
  }
  When("""^Agrego un release con nombre "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    release.name=arg0
    tablero.agregarRelease(release)
  }
  Then("""^El nombre del primer release del tablero debe ser "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.listaDeRelease(0).name) 
  }
  
  Given("""^Un tablero con release$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(1)
    release = new Release
    tablero.agregarRelease(release)
  }
  When("""^Agrego un nuevo release$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero.agregarRelease(release)
  }
  Then("""^La cantidad de release debe ser (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.listaDeRelease.size) 
  }
}