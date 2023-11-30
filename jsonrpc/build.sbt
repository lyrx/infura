ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.4.2",
  "org.json" % "json" % "20230618",
  "org.scalatest" %% "scalatest" % "3.2.16" % Test ,
  "org.scalatestplus" %% "mockito-3-4" % "3.2.10.0" % Test
)
lazy val root = (project in file("."))
  .settings(
    name := "jsonrpc"
  )
