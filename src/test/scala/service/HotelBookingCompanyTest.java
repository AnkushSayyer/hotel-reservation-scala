package service;

import model.*;
import org.junit.Before;
import org.junit.Test;
import util.DateFromStringUtil;

import static org.junit.Assert.*;

public class HotelBookingCompanyTest {

    public static boolean initialized = false;
    @Before
    public void init(){

        if(!initialized) {
            HotelCatalogue.addHotel(new Hotel("LakeWood", 3, RateCard.generateRateCard(110, 80, 90, 80)));
            HotelCatalogue.addHotel(new Hotel("BridgeWood", 4, RateCard.generateRateCard(160, 110, 60, 50)));
            HotelCatalogue.addHotel(new Hotel("RidgeWood", 5, RateCard.generateRateCard(220, 100, 150, 40)));
            initialized = true;
        }
    }

    @Test
    public void test1(){
        System.out.println((new HotelBookingCompany()).getCheapestHotel(new Request(Customer.REGULAR(), DateFromStringUtil.getDateFromString("16/3/2009"), DateFromStringUtil.getDateFromString("18/3/2009"))).name());
        System.out.println((new HotelBookingCompany()).getCheapestHotel(new Request(Customer.REGULAR(), DateFromStringUtil.getDateFromString("20/3/2009"), DateFromStringUtil.getDateFromString("22/3/2009"))).name());
        System.out.println((new HotelBookingCompany()).getCheapestHotel(new Request(Customer.REWARDS(), DateFromStringUtil.getDateFromString("26/3/2009"), DateFromStringUtil.getDateFromString("28/3/2009"))).name());
    }

}