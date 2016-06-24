package model

trait Usuario {
  var name:String
}

class Colaborador(var nombre:String) extends Usuario{
  var name = nombre
}

class ScrumMaster(var nombre:String) extends Usuario{
  var name = nombre
}

class ProductOwner(var nombre:String) extends Usuario{
  var name = nombre
}