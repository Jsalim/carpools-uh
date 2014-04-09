name := "carpools-uh"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "com.typesafe" %% "play-plugins-mailer" % "2.2.0",
  cache
)     

play.Project.playJavaSettings
