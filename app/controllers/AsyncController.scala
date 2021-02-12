package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class AsyncController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

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

}
