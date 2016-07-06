package model

import scala.collection.mutable.ListBuffer


case class Release(num: Int) {
  var numero = num 
  var name = null : String
  var listaSprints =  new ListBuffer[Sprint]
  
  def getSprint(idSprint:Int): Sprint = {
    listaSprints.filter { sprint => sprint.numero == idSprint }.head
  }
}