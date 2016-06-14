package features.steps

import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import cucumber.api.scala.{ ScalaDsl, EN }
import org.junit.Assert._
import model.Project
import model.Tablero
import model.Release
import model.Tarea
import model.Colaborador

@RunWith(classOf[Cucumber])
class RunCukesTest extends ScalaDsl with EN {

  var project = null: Project
  var tablero = null: Tablero
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
   
  Given("""^Un proyecto sin colaboradores y un colaborador$""") { () =>
    //// Express the Regexp above with the code you wish you had
    project = new Project
    colaborador = new Colaborador
  }
  When("""^Agrego al colaborador "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    colaborador.name = arg0
    project.agregarColaborador(colaborador)
  }
  Then("""^El proyecto debe tener como primer colaborador a "([^"]*)" y la cantidad de colaboradores debe ser (\d+)$""") { (arg0: String, arg1: Int) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, project.colaboradores(0).name)
    assertEquals(arg1, project.colaboradores.size)
  }

}