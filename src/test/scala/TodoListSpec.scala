package com.lbak.todo.test

import com.lbak.todo.TodoList
import com.lbak.todo.Task
import org.specs._
import java.io.File

class TodoListSpec extends Specification {
  // Get the test data file. Pretty hacky but it'll do for now.
  val path = new File(".").getAbsolutePath().stripSuffix(".") +
    "src/test/scala/data/todo.txt"
  // Create a TodoList out of the path given.
  val list = new TodoList(path)

  "TodoList" should {
    "grab a list of Tasks" >> {
      var allTasks = true
      list.tasks.foreach({ task =>
        if (!task.isInstanceOf[Task]) {
          allTasks = false
        }
      })

      allTasks must beTrue
    }
  }
}
