package com.lbak.todo

import scala.io.Source

class TodoList(val path: String) {
  /**
   *
   */
  val tasks = Source.fromFile(path).getLines.map(new Task(_))
}
