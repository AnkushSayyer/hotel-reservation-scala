package service

import java.time.{DayOfWeek, LocalDate}

import model.{Category, Customer, Day, Hotel, HotelCatalogue, Request}

class HotelBookingCompany {

  def getCheapestHotel(request: Request): Hotel ={
    val (weekdays, weekends) = calculateDays(request.checkInDate, request.checkOutDate)
    findcheapestHotel(request.customer, (weekdays, weekends))
  }

  def calculateDays(checkInDate: LocalDate, checkOutDate: LocalDate) = {
    val numberOfDays = checkInDate.datesUntil(checkOutDate.plusDays(1)).count()
    val numberOfWeekends = checkInDate.datesUntil(checkOutDate.plusDays(1))
      .filter(date => date.getDayOfWeek==DayOfWeek.SATURDAY||date.getDayOfWeek==DayOfWeek.SUNDAY).count()

    (numberOfDays-numberOfWeekends, numberOfWeekends)
  }

  def findcheapestHotel(customer: Customer.Value, tuple: (Long, Long)): Hotel = {
    /*HotelCatalogue.hotelList
      .map(hotel => {
        (hotel, (hotel.rateCard(Category(customer, Day.WEEKDAY)) * tuple._1)
          + (hotel.rateCard(Category(customer, Day.WEEKEND)) * tuple._2))
      })
      .groupBy(_._2)      //this groupby creates Map[K,ListBuffer[Hotel, K]]
      .toList
      .minBy(_._1)
      ._2
      .maxBy(_._1.rating) _1
*/
    HotelCatalogue.hotelList
      .groupBy(hotel => {
      ((hotel.rateCard(Category(customer, Day.WEEKDAY)) * tuple._1)    //this groupby creates Map[K,ListBuffer[Hotel]]
        + (hotel.rateCard(Category(customer, Day.WEEKEND)) * tuple._2))
    })
      .toList
      .minBy(_._1)
      ._2
      .maxBy(_.rating)

  }
}
