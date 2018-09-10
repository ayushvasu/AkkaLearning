name := "AkkaLearning"

version := "1.0"

scalaVersion := "2.11.7"

lazy val akkaV = "2.4.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaV,
  "com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
  "com.typesafe.akka" %% "akka-slf4j" % akkaV,
  "org.scalatest" %% "scalatest" % "2.2.5" % "test",
  //For akka persistent
  "com.typesafe.akka"           %% "akka-persistence" % akkaV,
  "org.iq80.leveldb"            % "leveldb"           % "0.7",
  "org.fusesource.leveldbjni"   % "leveldbjni-all"    % "1.8"
)