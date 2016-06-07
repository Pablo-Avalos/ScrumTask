name := "ScrumTask"

version := "1.0-SNAPSHOT"

resolvers += "Sonatype-Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"


libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scalatest" % "scalatest_2.10" % "2.1.6" % "test",
    "info.cukes" % "cucumber-junit" % "1.1.5",
  "info.cukes" % "cucumber-scala_2.10" % "1.1.5" % "test"
)     

play.Project.playScalaSettings

cucumberSettings

cucumberFeaturesLocation := "./features"

cucumberStepsBasePackage := "./features/steps"