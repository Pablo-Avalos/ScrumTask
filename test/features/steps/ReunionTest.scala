package features.steps

import org.junit.runner.RunWith

import cucumber.api.PendingException
import cucumber.api.junit.Cucumber
import cucumber.api.scala.EN
import cucumber.api.scala.ScalaDsl

import org.junit.Assert._

import model.Reunion
import model.Tema
import model.Usuario

import scala.collection.mutable.ListBuffer

import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._
import java.text.SimpleDateFormat
import java.text.SimpleDateFormat._
import java.sql.Time

@RunWith(classOf[Cucumber])
class ReunionTest extends ScalaDsl with EN {
  var reunion = null: Reunion

  Given("""^Tengo una reunion sin nada$""") { () =>
    assertEquals(reunion, null)
  }

  When("""^Le seteo la id con (\d+), con el dia (\d+), con el mes (\d+), con el anio (\d+), con la hora (\d+) y los minutos (\d+)$""") { (arg0: Integer, arg1: Integer, arg2: Integer, arg3: Integer, arg4: Integer, arg5: Integer) =>
    reunion.crearReunion(arg0, arg1, arg2, arg3, arg4, arg5)
  }

  Then("""^La id deberia ser (\d+), la fecha (.*)\, y la hora (.*)$""") { (arg0: Integer, arg1: Date, arg2: Time) =>
    assertEquals(arg0, reunion.id)
    assertEquals(arg1, reunion.fecha)
    assertEquals(arg2, reunion.horaDeInicio)
  }

  Given("""^Tengo una reunion sin integrantes (.*)$""") { () =>
    assert(reunion.integrantes == 0)
  }

  When("""^Agrego un integrante (.*) a la reunion$""") { (arg0: Usuario) =>
    reunion.agregarIntegrante(arg0)
  }

  Then("""^La reunion debe tener un integrante(.*)$""") { () =>
    assert(1 == (reunion.integrantes).length)
  }

  Given("""^Tengo una reunion sin temas (.*)$""") { () =>
    assertNull(reunion.temasTratados)
  }

  When("""^Agrego un tema (.*) a la reunion$""") { (arg0: String, arg1: String) =>
    reunion.agregarTema(arg0, arg1)
  }

  Then("""^La reunion debe tener un tema(.*)$""") { () =>
    assertNotNull(reunion.temasTratados)
  }
}