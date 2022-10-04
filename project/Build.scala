import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "sgp-new"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
  	
    // Add your project dependencies here,
    "postgresql" % "postgresql" % "9.1-901.jdbc4",
    javaJpa,
    javaCore,
    javaJdbc,
    javaEbean,
"com.lowagie" % "itext" % "2.1.7",
  "org.avaje.ebeanorm" % "avaje-ebeanorm" % "3.3.3",
  "com.typesafe.play" % "play-ebean-33-compat" % "1.0.1",
  "org.apache.commons" % "commons-email" % "1.3.1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
