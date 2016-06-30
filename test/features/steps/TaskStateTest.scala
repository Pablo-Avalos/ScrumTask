package features.steps

import org.junit.runner.RunWith

import cucumber.api.PendingException
import cucumber.api.junit.Cucumber
import cucumber.api.scala.EN
import cucumber.api.scala.ScalaDsl
import org.junit.Assert._
import model.Tarea
import model.StateTask
import model.StateTaskFinished
import model.StateTaskStarted
import model.StateTaskNotStarted

@RunWith(classOf[Cucumber])
class TaskStateTest extends ScalaDsl with EN {

  var tarea = new Tarea(115, null)

  When("""^Le pongo el estado "([^"]*)"$""") { (arg0: String) =>
    tarea = new Tarea(1, null)
    arg0 match {
      case "Finished"   => tarea.estado = new StateTaskFinished()
      case "Started"    => tarea.estado = new StateTaskStarted()
      case "NotStarted" => tarea.estado = new StateTaskNotStarted()
      case _            => throw new IllegalArgumentException
    }
  }

  Then("""^El estado de la tarea debe ser "([^"]*)"$""") { (arg0: String) =>
    var estado = null: StateTask
    arg0 match {
      case "Finished"   => estado = new StateTaskFinished()
      case "Started"    => estado = new StateTaskStarted()
      case "NotStarted" => estado = new StateTaskNotStarted()
      case _            => throw new IllegalArgumentException
    }
    assertEquals(tarea.estado.codigo, estado.codigo)
  }
}