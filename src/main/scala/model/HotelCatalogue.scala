package model

object HotelCatalogue {
  val hotelList = scala.collection.mutable.ListBuffer[Hotel]()

  def addHotel(hotel: Hotel): Unit ={
    hotelList += hotel
  }
}
