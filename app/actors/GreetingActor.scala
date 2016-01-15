package actors

import akka.actor.Actor

class GreetingActor extends Actor {
    def receive: Receive = {
        case "Hola" =>  sender ! "Bienvenido"
        case "Hello" =>  sender ! "Welcome"
        case "Ciao" => sender ! "Bienvenutti"
        case "Bonjour" => sender ! "Bienvenue"
    }
}
