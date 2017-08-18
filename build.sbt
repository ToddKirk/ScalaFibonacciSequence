enablePlugins(UniversalPlugin, JavaAppPackaging)

val scalamockVersion = "3.4.2"
val scalatestVersion = "3.0.1"
val typesafeConfigVersion = "1.3.1"
val kxbmapConfigsVersion = "0.4.4"

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")
compileScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value

lazy val root = (project in file(".")).
  configs(IntegrationTest).
  settings(Defaults.itSettings: _*).
  enablePlugins(BuildInfoPlugin).
  settings(
    name := "fibonacci-sequence",
    version := "1.0",
    organization := "com.kirk",
    description := "fibonacci sequence generator.",
    scalaVersion := "2.12.3",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    addCompilerPlugin("org.psywerx.hairyfotr" %% "linter" % "0.1.17"),
    (compile in Compile) := ( (compile in Compile) dependsOn compileScalastyle ).value,
    parallelExecution in IntegrationTest := false,
    libraryDependencies ++= Seq(
      "com.github.kxbmap" %% "configs" % kxbmapConfigsVersion,
      "org.scalatest" %% "scalatest" % scalatestVersion % "test,it",
      "org.scalamock" %% "scalamock-scalatest-support" % scalamockVersion % "test,it"
    )
  )

        