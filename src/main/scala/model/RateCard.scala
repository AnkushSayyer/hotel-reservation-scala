package model

import scala.collection.immutable.HashMap

object RateCard {
  def generateRateCard(wkdReg : Int, wkdRwd : Int, wkndReg : Int, wkndRwd : Int): Map[Category, Int] ={
    val rateCard : Map[Category, Int] = HashMap(
      Category(Customer.REGULAR,Day.WEEKDAY) -> wkdReg,
      Category(Customer.REGULAR,Day.WEEKEND) -> wkndReg,
      Category(Customer.REWARDS,Day.WEEKDAY) -> wkdRwd,
      Category(Customer.REWARDS,Day.WEEKEND) -> wkndRwd
    )
    rateCard
  }
}
