name := "play-akka"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies +=
    "com.typesafe.akka" %% "akka-actor" % "2.4.1"
libraryDependencies +=
    "com.typesafe.akka" %% "akka-slf4j" % "2.4.1"

