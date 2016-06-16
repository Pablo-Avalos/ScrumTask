package features.steps
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import cucumber.api.scala.{ ScalaDsl, EN }
import org.junit.Assert._
import model.Tarea

@RunWith(classOf[Cucumber])
class TaskStateTest extends ScalaDsl with EN {
  var tarea = new Tarea(115) 
  var tarea2 = new Tarea(2)
  var tarea3= new Tarea(3)

When("""^Le seteo el estado Finished$"""){ () =>
  //// Express the Regexp above with the code you wish you had
    tarea.nextState
    tarea.nextState
}
Then("""^El estado de la  tarea debe ser Finished$"""){ () =>
  //// Express the Regexp above with the code you wish you had
  assertEquals(tarea.estado.codigo,1)
}

When("""^Le seteo el estado Started$"""){ () =>
  //// Express the Regexp above with the code you wish you had
    tarea2.nextState
}
Then("""^El estado de la  tarea debe ser Started$"""){ () =>
  //// Express the Regexp above with the code you wish you had
  assertEquals(tarea2.estado.codigo,2)
}

When("""^Le seteo el estado NotStarted$"""){ () =>
  //// Express the Regexp above with the code you wish you had
  
}
Then("""^El estado de la  tarea debe ser NotStarted$"""){ () =>
  //// Express the Regexp above with the code you wish you had
  assertEquals(tarea3.estado.codigo,3)
}  
  
 
}