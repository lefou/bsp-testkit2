import mill._
import mill.scalalib._

object testkit extends RootModule {
  def millSourcePath = super.millSourcePath / "bsp-testkit"
  
  object client extends ScalaModule {
    def scalaVersion = "2.13.11"
    def moduleDeps = Seq(utils)
    def sources = T.sources(millSourcePath)
    def ivyDeps = Agg(
      ivy"ch.epfl.scala:bsp4j:2.1.0-M5",
      ivy"org.junit.jupiter:junit-jupiter-api:5.9.3",
      ivy"org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:0.21.0"
    )
  }
  
  object utils extends ScalaModule {
    def scalaVersion = "2.13.11"
    def sources = T.sources(millSourcePath)
    def ivyDeps = Agg(
      ivy"com.google.code.gson:gson:2.10.1",
      ivy"org.junit.jupiter:junit-jupiter-api:5.9.3",
      ivy"com.google.guava:guava:31.0.1-jre"
    )
  }
}
