package com.lbak.todo.test

import org.specs._
import com.lbak.todo.Task

class TaskSpec extends Specification {
  val task = new Task("(A) This task has all sorts. @context +project")
  val dud  = new Task(" (B) Failed@priority and 2+2 is 4!")

  "Task" should {
    "recognise priority" >> {
      task.priority must_== "A"
    }

    "recognise contexts" >> {
      task.contexts must contain("@context")
    }

    "recognise projects" >> {
      task.projects must contain("+project")
    }

    "extract text correctly" >> {
      task.text must_== "This task has all sorts."
    }
  }

  "Dud task" should {
    "not match priority" >> {
      dud.priority must beNull
    }

    "not match context" >> {
      dud.contexts must beEmpty
    }

    "not match projects" >> {
      dud.projects must beEmpty
    }

    "still match text" >> {
      // It has no leading space because the .text gets trimmed.
      dud.text must_== "(B) Failed@priority and 2+2 is 4!"
    }
  }
}
