package model

import scala.collection.mutable.ListBuffer


case class Release(num: Int) {
  var numero = num 
  var name = null : String
  var listaSprints =  new ListBuffer[Sprint]
}