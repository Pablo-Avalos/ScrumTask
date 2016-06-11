package features.steps

import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import cucumber.api.scala.{ ScalaDsl, EN }
import org.junit.Assert._
import model.Project
import model.Tablero
import model.Release
import model.Task
import model.Colaborador

@RunWith(classOf[Cucumber])
class RunCukesTest extends ScalaDsl with EN {

  var project = null: Project
  var tablero = null: Tablero
  var tarea = null: Task
  var tarea2 = null: Task
  var colaborador = null: Colaborador
  var release = null: Release 
  Given("""^Tengo un proyecto inicializado$""") { () =>
    //// Express the Regexp above with the code you wish you had
    project = new Project

  }
  When("""^Le seteo el nombre "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    project.name = arg0
  }
  Then("""^El nombre del proyecto debe ser "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, project.name)
  }

  Given("""^Tengo un proyecto incializado$""") { () =>
    //// Express the Regexp above with the code you wish you had
    project = new Project
  }
  When("""^Seteo el tablero con id (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    project.tablero = new Tablero(17)
  }
  Then("""^El tablero que esta en el proyecto tiene que tener id (\d+)$""") { (arg0: Int) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, project.tablero.id)

  }
  Given("""^Tengo una tarea$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tarea = new Task
  }
  When("""^Le seteo el nombre como "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.name = arg0
  }

  Then("""^El nombre de la  tarea debe ser "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tarea.name)
  }
  
  Given("""^Un tablero inicializado y una tarea inicializada$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(1)
    tarea = new Task
  }
  When("""^Agrego la tarea con nombre "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.name=arg0
    tablero.agregarTarea(tarea)
  }
  Then("""^La primer tarea del tablero debe ser "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.tareas(0).name) 
  }
  
  Given("""^Un tablero inicializado y dos tarea inicializadas$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tablero = new Tablero(1)
    tarea = new Task
    tarea2 = new Task
  }
  When("""^Agrego la tarea con nombre "([^"]*)" y agrego la tarea con nombre "([^"]*)"$""") { (arg0: String,arg1: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.name=arg0
    tarea2.name=arg1
    tablero.agregarTarea(tarea)
    tablero.agregarTarea(tarea2)
  }
  Then("""^La primer tarea del tablero debe ser "([^"]*)" y la segunda "([^"]*)"$""") { (arg0: String,arg1: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tablero.tareas(0).name) 
    assertEquals(arg1, tablero.tareas(1).name) 
  }  
  
  Given("""^Un proyecto sin colaboradores y un colaborador$""") { () =>
    //// Express the Regexp above with the code you wish you had
    project = new Project
    colaborador = new Colaborador
  }
  When("""^Agrego al colaborador "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    colaborador.name=arg0
    project.agregarColaborador(colaborador)
  }
  Then("""^El proyecto debe tener como primer colaborador a "([^"]*)" y la cantidad de colaboradores debe ser (\d+)$""") { (arg0: String, arg1: Int) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, project.colaboradores(0).name)
    assertEquals(arg1, project.colaboradores.size)
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

}