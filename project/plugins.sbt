val protoc = "0.99.14"
val slf4j = "1.7.21"
val dependencyGraph = "0.9.0"

addSbtPlugin("org.scala-js"       % "sbt-scalajs"              % "0.6.22")
addSbtPlugin("org.portable-scala" % "sbt-crossproject"         % "0.3.1")  // (1)
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.3.1")  // (2)
addSbtPlugin("com.thesamet" % "sbt-protoc" % protoc)
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % dependencyGraph)

libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-nop" % slf4j,
    "com.thesamet.scalapb" %% "compilerplugin-shaded" % "0.7.0-rc7"
)