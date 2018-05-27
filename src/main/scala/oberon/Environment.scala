package oberon

import scala.collection.mutable.Stack
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap

import oberon.expression.Value
import oberon.expression.Expression

object Environment {
  var stack = new Stack[Map[String, Value]] () 

  def push() {
    stack.push(new HashMap[String, Value]())
  }

  def pop(): Map[String, Value] = {
    stack.pop
  }

  def map(id: String, value: Value) {
    if(stack.isEmpty) {
      push()
    }
    stack.top += (id -> value) 
  }

  def lookup(id: String) : Option[Map[String, Value]] = {
    stack.isEmpty match {
      case true => None
      case _    => Some(stack.top)
    }
  }

  def clear() : Unit = stack.clear() 
}
