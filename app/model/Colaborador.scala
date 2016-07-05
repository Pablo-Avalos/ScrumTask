package model

trait Usuario {
  var name:String
  var id:Int
  val tipo:String
}

class Colaborador(var nombre:String) extends Usuario{
  var name = nombre
  var id = 0
  val tipo = "desarrollador"
}

class ScrumMaster(var nombre:String) extends Usuario{
  var name = nombre
  var id = 0
  val tipo = "scrumMaster"
}

class ProductOwner(var nombre:String) extends Usuario {
  var name = nombre
  var id = 0
  val tipo = "productOwner"
}