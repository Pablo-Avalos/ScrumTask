//package features.steps
//
//import cucumber.api.scala.{ ScalaDsl, EN }
//import org.junit.Assert._
//import model.Task
//
//class TaskStepDefinitions extends ScalaDsl with EN {
//  var tarea  = null:Task
////  var project = null :Project
////  Given("""^Tengo un proyecto inicializado$"""){
////    project = new Project
////    
////  }
////  When("""^Le seteo su (\d+)$"""){ (nombre: String) =>
////      project.name= nombre
////    }
////
////  Then("^the result is (\\d+)$") { nombre: String =>
////    assertEquals(nombre, project.name)
////  }
//
////    Given("""^Tengo una tarea$""") { () =>
////    //// Express the Regexp above with the code you wish you had
////    tarea = new Task
////  }
////  When("""^Le seteo el nombre "([^"]*)"$""") { (arg0: String) =>
////    //// Express the Regexp above with the code you wish you had
////    tarea.name = arg0
////  }
////
////  Then("""^El nombre de la  tarea debe ser "([^"]*)"$""") { (arg0: String) =>
////    //// Express the Regexp above with the code you wish you had
////    assertEquals(arg0, tarea.name)
////  }
////
////  
////  
//}