package com.akka.epcots.FormatReader.service;

import com.akka.epcots.FormatReader.model.GGAFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GGAServiceTest {

    GGAService ggaService;
    @BeforeEach
    void setUp() {
        ggaService = new GGAService();
    }

    @Test
    public void extractGGA_GGAFrame_Return_GGAFormat(){
        String message = "$GPGGA,100000,5233.629,N,01323.973,E,1,12,1.0,0.0,M,0.0,M,,*6E";
        GGAFormat ggaFormat = ggaService.extractGGA(message.split(","));

        GGAFormat expected = new GGAFormat();
        expected.setLatitude(5233.629);
        expected.setCardinalLatitude('N');
        expected.setLongitude(1323.973);
        expected.setCardinalLongitude('E');
        expected.setAltitude(0.0);
        expected.setUnityAltitude('M');

        /** Test don't verify date Fix */

        boolean isEqual =
                (ggaFormat.getLatitude() == expected.getLatitude()) &&
                (ggaFormat.getCardinalLatitude() == expected.getCardinalLatitude()) &&
                (ggaFormat.getLongitude() == expected.getLongitude()) &&
                (ggaFormat.getCardinalLongitude() == expected.getCardinalLongitude()) &&
                (ggaFormat.getAltitude() == expected.getAltitude()) &&
                (ggaFormat.getUnityAltitude() == expected.getUnityAltitude());

        assertTrue(isEqual);
    }

    @Test
    public void extractGGA_VTGFrame_Return_null(){
        String message = "$GPVTG,054.7,T,034.4,M,005.5,N,010.2,K";
        GGAFormat ggaFormat = ggaService.extractGGA(message.split(","));

        boolean isEqual = ggaFormat == null;
        assertTrue(isEqual);
    }

    @Test
    public void convertDate_string_return_Date(){
        String time = "100000";
        Date date = ggaService.convertDate(time);

        assertNotEquals(null, date);
    }

    @Test
    public void convertDate_string_return_null(){
        String time = "1000000";
        Date date = ggaService.convertDate(time);

        assertEquals(null, date);
    }
}