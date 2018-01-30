import sbtcrossproject.{CrossType, crossProject}
import sbtprotoc.ProtocPlugin.ProtobufConfig

def crossSourceDir(baseDir: File, config: Configuration): File = {
  baseDir.getParentFile / "src" / Defaults.nameForSrc(config.name) / "protobuf"
}

def crossSourceDir(
    projectRef: ProjectReference,
    config: Configuration
): Def.Initialize[File] = {
  Def.setting {
    crossSourceDir((baseDirectory in projectRef).value, config)
  }
}

def protobufSettings(config: Configuration = Compile): Seq[Setting[_]] = {
  val configSettings = if (config != Compile) {
    inConfig(config)(ProtocPlugin.protobufConfigSettings)
  } else {
    Nil
  }

  configSettings ++ Seq(
    PB.protoSources in config := {
      Seq(crossSourceDir(baseDirectory.value, config))
    },
    scalaSource in ProtobufConfig := {
      (sourceDirectory in Compile)(_ / "generated-proto")
    }.value,
    PB.targets in config := Seq(
      scalapb.gen(
        flatPackage = true,
        javaConversions = false,
        grpc = false,
        singleLineToProtoString = false
      ) -> (sourceManaged in config).value
    )
  )
}

lazy val bar = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(protobufSettings())
  .jsSettings(
    libraryDependencies := libraryDependencies.value.filter(_.name == "scalapb-runtime_2.12")
  )

lazy val barJS = bar.js
lazy val barJVM = bar.jvm
