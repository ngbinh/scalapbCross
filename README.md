# scalapbCross

To reproduce
```
barJS/dependencyTree
[info] Updating {file:/home/binh/works/external/scalapbCross/}barJS...
[info] Done updating.
[info] bar:bar_sjs0.6_2.12:0.1-SNAPSHOT [S]
[info]   +-com.thesamet.scalapb:scalapb-runtime_2.12:0.7.0-rc7 [S]
[info]   | +-com.google.protobuf:protobuf-java:3.5.0
[info]   | +-com.lihaoyi:fastparse_2.12:1.0.0 [S]
[info]   | | +-com.lihaoyi:fastparse-utils_2.12:1.0.0 [S]
[info]   | | | +-com.lihaoyi:sourcecode_2.12:0.1.4 [S]
[info]   | | |
[info]   | | +-com.lihaoyi:sourcecode_2.12:0.1.4 [S]
[info]   | |
[info]   | +-com.thesamet.scalapb:lenses_2.12:0.7.0-test2 [S]
[info]   |
[info]   +-org.scala-js:scalajs-library_2.12:0.6.22 [S]
[info]
```

Note that `barJS` is a `scala.js` project so it should not depend on `scalapb-runtime_2.12`.