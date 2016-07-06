package features.steps

import org.junit.runner.RunWith

import cucumber.api.PendingException
import cucumber.api.junit.Cucumber
import cucumber.api.scala.EN
import cucumber.api.scala.ScalaDsl
import model.Tablero
import model.Tarea
import model.Release
import model.Sprint
import org.junit.Assert._

@RunWith(classOf[Cucumber])
class TaskTest extends ScalaDsl with EN {
  var tablero = new Tablero(7)
  var tarea = new Tarea(115, null)
  tablero.agregarTarea(tarea)

  When("""^Elimino la tarea con id (\d+)$""") { (arg0: Integer) =>
    var tarea = new Tarea(arg0,null)
    var release = new Release(0)
//    var sprint = new Sprint(0)
    tablero.agregarRelease(release)
//    tablero.agregarSprint(0)
    tablero agregarTarea(0,0,tarea)
    tablero eliminarTarea(0,0,arg0.asInstanceOf[Integer])
  }
  Then("""^La tarea con la id (\d+) ya no debe estar mas en el tablero$""") { (arg0: Int) =>
    assert(!tablero.tareas.contains(arg0))
  }

  Given("""^Tengo una tarea$""") { () =>
    //// Express the Regexp above with the code you wish you had
    tarea = new Tarea(1, null)
  }
  When("""^Le seteo el nombre como "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.nombre = arg0
  }

  Then("""^El nombre de la  tarea debe ser "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    assertEquals(arg0, tarea.nombre)
  }

  Given("""^Una tarea sin autor$""") { () =>
    //// Express the Regexp above with the code you wish you had
  }
  When("""^Pongo el autor "([^"]*)" a una tarea$""") { (arg0: String) =>
    tarea.autor = arg0
  }
  Then("""^El autor de la tarea debe ser "([^"]*)"$""") { (arg0: String) =>
    assertEquals(tarea.autor, arg0)
  }

  Given("""^Una tarea con autor "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.autor = arg0
  }
  When("""^Cambio el autor por "([^"]*)"$""") { (arg0: String) =>
    tarea.autor = arg0
  }
  Then("""^El autor de la tarea tiene que ser "([^"]*)"$""") { (arg0: String) =>
    assertEquals(tarea.autor, arg0)
  }

  Given("""^Una tarea sin descripcion$""") { () =>
    //// Express the Regexp above with the code you wish you had
  }
  When("""^Pongo la descripcion "([^"]*)"$""") { (arg0: String) =>
    tarea.descripcion = arg0
  }
  Then("""^La descripcion de la tarea tiene que ser "([^"]*)"$""") { (arg0: String) =>
    assertEquals(tarea.descripcion, arg0)
  }

  Given("""^Una tarea con descripcion "([^"]*)"$""") { (arg0: String) =>
    //// Express the Regexp above with the code you wish you had
    tarea.descripcion = arg0
  }
  When("""^Cambio la descripcion por "([^"]*)"$""") { (arg0: String) =>
    tarea.descripcion = arg0
  }
  Then("""^La descripcion de la tarea debe ser "([^"]*)"$""") { (arg0: String) =>
    assertEquals(tarea.descripcion, arg0)
  }
}