package model

abstract class StateTask {
  def codigo:Int
  def  nextState(tarea:Tarea) 
}

class StateTaskFinished extends StateTask{   
   def codigo:Int= 1
   def nextState(tarea:Tarea){
    ""
  }
 
}

class StateTaskStarted extends StateTask{
 def codigo :Int= 2
 def  nextState(tarea:Tarea)= tarea.setEstado(new StateTaskFinished)
}

class StateTaskNotStarted extends StateTask{ 
 def codigo :Int=3
 def  nextState(tarea:Tarea) = tarea.setEstado(new StateTaskStarted)
 
}