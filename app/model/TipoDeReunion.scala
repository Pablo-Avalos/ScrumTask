package model

object TipoDeReunion extends Enumeration {
  type Tipo = Value
  val Daily = Value("Daily")
  val Planning = Value("Planning")
  val Demo = Value("Demo")
  val Retrospective = Value("Retrospective")
}