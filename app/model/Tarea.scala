package model

class Tarea(var id:Integer) {
  var nombre = null: String
  var estado = new StateTaskNotStarted: StateTask
  var descripcion= null: String
  var autor = null: String
 def setEstado(estado1:StateTask)= estado=estado1 
 def nextState = estado.nextState(this)
 
}