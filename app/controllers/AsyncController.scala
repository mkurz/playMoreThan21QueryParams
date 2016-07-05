package controllers

import akka.actor.ActorSystem
import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._

/**
  * This controller creates an `Action` that demonstrates how to write
  * simple asynchronous code in a controller. It uses a timer to
  * asynchronously delay sending a response for 1 second.
  *
  * @param actorSystem We need the `ActorSystem`'s `Scheduler` to
  * run code after a delay.
  * @param exec We need an `ExecutionContext` to execute our
  * asynchronous code.
  */
@Singleton
class AsyncController @Inject()(actorSystem: ActorSystem)(
    implicit exec: ExecutionContext)
    extends Controller {

  /**
    * Create an Action that returns a plain text message after a delay
    * of 1 second.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/message`.
    */
  def message = Action.async {
    getFutureMessage(1.second).map { msg =>
      Ok(msg)
    }
  }

  def moreThan21(one: Option[String],
                 two: Option[String],
                 three: Option[String],
                 four: Option[String],
                 five: Option[String],
                 six: Option[String],
                 seven: Option[String],
                 eight: Option[String],
                 nine: Option[String],
                 ten: Option[String],
                 eleven: Option[String],
                 twelve: Option[String],
                 thirteen: Option[String],
                 fourteen: Option[String],
                 fifteen: Option[String],
                 sixteen: Option[String],
                 seventeen: Option[String],
                 eighteen: Option[String],
                 nineteen: Option[String],
                 twenty: Option[String],
                 twentyOne: Option[String],
                 twentyTwo: Option[String]) = Action{
    Ok(s"one:$one,two:$two,three:$three,four:$four,five:$five,six:$six,seven:$seven,eight:$eight,nine:$nine,ten:$ten,eleven:$eleven,twelve:$twelve,thirteen:$thirteen,fourteen:$fourteen,fifteen:$fifteen,sixteen:$sixteen,seventeen:$seventeen,eighteen:$eighteen,nineteen:$nineteen,twenty:$twenty,twentyOne:$twentyOne,twentyTwo:$twentyTwo")
  }

  private def getFutureMessage(delayTime: FiniteDuration): Future[String] = {
    val promise: Promise[String] = Promise[String]()
    actorSystem.scheduler.scheduleOnce(delayTime) { promise.success("Hi!") }
    promise.future
  }

}
