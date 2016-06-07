package features.steps

import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import cucumber.api.scala.{ ScalaDsl, EN }
import org.junit.Assert._
import model.Project
import model.Tablero
import model.Task

@RunWith(classOf[Cucumber])
class RunCukesTest extends ScalaDsl with EN {

  var project = null: Project
  var tarea = null: Task
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

}