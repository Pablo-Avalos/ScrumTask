package features.steps

import org.junit.runner.RunWith

import cucumber.api.PendingException
import cucumber.api.junit.Cucumber
import cucumber.api.scala.EN
import cucumber.api.scala.ScalaDsl

import org.junit.Assert._

import model.Reunion
import model.Tema
import model.Colaborador
import model.TipoDeReunion

import scala.collection.mutable.ListBuffer

import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._
import java.text.SimpleDateFormat
import java.text.SimpleDateFormat._
import java.sql.Time

@RunWith(classOf[Cucumber])
class ReunionTest extends ScalaDsl with EN {
  var reunion = new Reunion(6)

  Given("""^Tengo una reunion con una id$""") { () =>
    // La reunion es inicializada con una id = 6
  }

  When("""^Le seteo la id con (\d+)$""") { (arg0: Int) =>
    reunion.id = arg0
  }

  Then("""^La id de la reunion debe ser (\d+)$""") { (arg0: Int) =>
    assertEquals(arg0, reunion.id)
  }

  Given("""^Tengo una reunion sin integrantes$""") { () =>
    assert((reunion.integrantes).length == 0)
  }

  When("""^Le agrego al integrante "([^"]*)" a la reunion$""") { (arg0: String) =>
    var usuario = new Colaborador(arg0)
    reunion.agregarIntegrante(usuario)
  }

  Then("""^La reunion debe tener un integrante$""") { () =>
    assert(1 == (reunion.integrantes).length)
  }

  Given("""^Tengo una reunion sin fecha$""") { () =>
    assertEquals(reunion.fecha, null)
  }

  When("""^Le seteo la fecha al dia (\d+) del mes (\d+) del anio (\d+)$""") { (arg0: Integer, arg1: Integer, arg2: Integer) =>
    reunion.setFecha(arg0, arg1, arg2)
  }

  Then("""^La fecha de la reunion debe ser el dia (\d+) del mes (\d+) del anio (\d+)$""") { (arg0: Integer, arg1: Integer, arg2: Integer) =>
    var nvaFecha = new Date((arg2 - 1900), arg1 - 1, arg0)
    assertEquals(nvaFecha, reunion.fecha)
  }

  Given("""^Tengo una reunion sin hora de inicio$""") { () =>
    assertEquals(reunion.horaDeInicio, null)
  }

  When("""^Le seteo la hora de inicio con (\d+) horas y (\d+) minutos$""") { (arg0: Integer, arg1: Integer) =>
    reunion.setHora(arg0, arg1)
  }

  Then("""^La hora de inicio de la reunion debe ser a las (\d+) horas y (\d+) minutos$""") { (arg0: Integer, arg1: Integer) =>
    var nvaHora = new Time(arg0, arg1, 0)
    assertEquals(nvaHora, reunion.horaDeInicio)
  }

  Given("""^Tengo una reunion sin temas$""") { () =>
    assertNull(reunion.temasTratados)
  }

  When("""^Le agrego un tema a la reunion$""") { () =>
    reunion.temasTratados = new Tema
    reunion.agregarTema("temaNvo", "descripcionDelTema")

  }

  Then("""^La reunion debe tener un tema$""") { () =>
    assertNotNull(reunion.temasTratados)
  }

  Given("""^Una reunion sin tipo$""") { () =>
  }

  When("""^Creo una "([^"]*)"$""") { (arg0: String) =>
    reunion = new Reunion(1)
    var tipo = TipoDeReunion
    arg0 match {
      case "Daily" => reunion.tipoDeReunion = tipo.Daily
      case "Planning" => reunion.tipoDeReunion = tipo.Planning
      case "Demo" => reunion.tipoDeReunion = tipo.Demo
      case "Retrospective" => reunion.tipoDeReunion = tipo.Retrospective
      case _ => throw new IllegalArgumentException
    }
  }

  Then("""^La reunion debe ser una "([^"]*)"$""") { (arg0: String) =>
    assertEquals(reunion.tipoDeReunion.toString(), arg0)
  }
}