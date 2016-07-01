package model

trait Usuario {
  var name:String
  var id:Int
}

class Colaborador(var nombre:String) extends Usuario{
  var name = nombre
  var id = 0
}

class ScrumMaster(var nombre:String) extends Usuario{
  var name = nombre
  var id = 0
}

class ProductOwner(var nombre:String) extends Usuario{
  var name = nombre
  var id = 0
}