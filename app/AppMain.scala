import java.io.File

import play.api._
import play.core.server._

object AppMain extends App {
  //  new AppLoader().load(dsp.con)
  val cl          = Thread.currentThread.getContextClassLoader
  val environment = Environment(new File("."), cl, Mode.Dev)
  val context     = ApplicationLoader.createContext(environment)
  val application = new MyApplicationLoader().load(context)
  val server = AkkaHttpServer.fromApplication(application,
    ServerConfig(
      port = Some(9000),
      address = "127.0.0.1"
    ))

}
