package service

import junit.framework.Test
import model.{Customer, Hotel, HotelCatalogue, RateCard, Request}
import org.junit.Before
import util.DateFromStringUtil

class HotelBookingCompanyTestScala {

  var initialized = false

  @Before
  def init(): Unit = {
    if (!initialized) {
      HotelCatalogue.addHotel(new Hotel("LakeWood", 3, RateCard.generateRateCard(110, 80, 90, 80)))
      HotelCatalogue.addHotel(new Hotel("BridgeWood", 4, RateCard.generateRateCard(160, 110, 60, 50)))
      HotelCatalogue.addHotel(new Hotel("RidgeWood", 5, RateCard.generateRateCard(220, 100, 150, 40)))
      initialized = true
    }
  }


  def test1(): Unit = {
    println((new HotelBookingCompany).getCheapestHotel(new Request(Customer.REGULAR, DateFromStringUtil.getDateFromString("16/3/2009"), DateFromStringUtil.getDateFromString("18/3/2009"))).name)
    println((new HotelBookingCompany).getCheapestHotel(new Request(Customer.REGULAR, DateFromStringUtil.getDateFromString("20/3/2009"), DateFromStringUtil.getDateFromString("22/3/2009"))).name)
    println((new HotelBookingCompany).getCheapestHotel(new Request(Customer.REWARDS, DateFromStringUtil.getDateFromString("26/3/2009"), DateFromStringUtil.getDateFromString("28/3/2009"))).name)
  }
}
