package com.lbak.todo

import scala.util.matching.Regex

class Task(val orig: String) {
  private val PriorityRegex = new Regex("""^\(([A-Za-z])\)\s+.*?""")
  private val ContextsRegex = new Regex("""(?:\s+|^)@\w+""")
  private val ProjectsRegex = new Regex("""(?:\s+|^)\+\w+""")

  lazy val priority = getPriority()
  lazy val contexts = getContexts()
  lazy val projects = getProjects()
  lazy val text     = getText()

  private def getPriority(): String = orig match {
    case PriorityRegex(priorityMatch) => priorityMatch
    case _ => null // Do Nothing
  }

  private def getContexts(): List[String] = {
    ContextsRegex.findAllIn(orig).toList.map(_.trim)
  }

  private def getProjects(): List[String] = {
    ProjectsRegex.findAllIn(orig).toList.map(_.trim)
  }

  private def getText(): String = {
    orig.replaceAll(PriorityRegex.toString, "").
         replaceAll(ContextsRegex.toString, "").
         replaceAll(ProjectsRegex.toString, "").
         replaceAll("""\s+""", " ").
         trim
  }
}
