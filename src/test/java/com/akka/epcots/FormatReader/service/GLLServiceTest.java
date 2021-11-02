package com.akka.epcots.FormatReader.service;

import com.akka.epcots.FormatReader.model.GLLFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GLLServiceTest {

    GLLService gllService;
    @BeforeEach
    void setUp() {
        gllService = new GLLService();
    }

    @Test
    public void extractGLL_StringArray_returnGLLFormat(){
        String message = "$GPGLL,4916.45,N,12311.12,W,225444,A";
        GLLFormat gllFormat = gllService.extractGLL(message.split(","));

        GLLFormat expected = new GLLFormat();
        expected.setLatitude(4916.45);
        expected.setCardinalLatitude('N');
        expected.setLongitude(12311.12);
        expected.setCardinalLongitude('W');

        boolean isEqual =
                (gllFormat.getLatitude() == expected.getLatitude()) &&
                (gllFormat.getCardinalLatitude() == expected.getCardinalLatitude()) &&
                (gllFormat.getLongitude() == expected.getLongitude()) &&
                (gllFormat.getCardinalLongitude() == expected.getCardinalLongitude());

        assertTrue(isEqual);
    }

    @Test
    public void extractGLL_GGAFrame_return_null(){
        String message = "$GPGGA,100000,5233.629,N,01323.973,E,1,12,1.0,0.0,M,0.0,M,,*6E";
        GLLFormat gllFormat = gllService.extractGLL(message.split(","));

        boolean isEqual = gllFormat == null;

        assertTrue(isEqual);
    }
}