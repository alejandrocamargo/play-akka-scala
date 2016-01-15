package controllers

import akka.util.Timeout
import play.api.mvc.{Action, Controller}
import akka.actor._
import akka.pattern.ask
import scala.collection.mutable.ListBuffer
import scala.concurrent.duration._
import actors._

import scala.concurrent.Await

class HelloWorld extends Controller {

    /*def getHelloWorld = Action {
        Ok(views.html.hello("Hello World!"))
    }*/

    def getMessageList = Action {
        val ls = new ListBuffer[String]
        ls.append("Bienvenue")
        ls.append("Bienvenido")
        ls.append("Welcome")
        ls.append("Aloha")
        ls.append("Benvenuto")


        val system = ActorSystem("MessageSystem")
        val greetingActor = system.actorOf(Props[GreetingActor], name = "greetingActor")
        implicit val timeout = Timeout(5 seconds)

        val future = greetingActor ? "Ciao"
        val result = Await.result(future, timeout.duration).asInstanceOf[String]

        Ok(views.html.hello(result, ls.toList))

    }
}
