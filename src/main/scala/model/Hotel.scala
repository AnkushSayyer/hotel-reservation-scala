package model

class Hotel(val name : String, val rating : Int, val rateCard: Map[Category, Int]) {
  def apply(name: String, rating: Int, rateCard: Map[Category, Int]): Hotel = new Hotel(name, rating, rateCard)
}
