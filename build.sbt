ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dev.gmarmstrong"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "notes",
    libraryDependencies += "org.typelevel" %% "spire" % "0.18.0-M3",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
  )
