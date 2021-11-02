package com.akka.epcots.FormatReader.service;

import com.akka.epcots.FormatReader.model.VTGFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VTGServiceTest {
    VTGService vtgService;
    @BeforeEach
    void setUp() {
        vtgService = new VTGService();
    }

    @Test
    public void extractVTG_StringArray_returnVTGFormat(){
        String message = "$GPVTG,054.7,T,034.4,M,005.5,N,010.2,K";
        VTGFormat vtgFormat = vtgService.extractVTG(message.split(","));

        System.out.println(vtgFormat);
        VTGFormat expected = new VTGFormat();
        expected.setKspeed(10.2);
        expected.setNSpeed(5.5);
        expected.setRealCap(54.7);
        expected.setMagneticCap(34.4);

        boolean isEqual =
                (vtgFormat.getKspeed() == expected.getKspeed()) &&
                        (vtgFormat.getNSpeed() == expected.getNSpeed() ) &&
                        (vtgFormat.getMagneticCap() == expected.getMagneticCap()) &&
                        (vtgFormat.getRealCap() == expected.getRealCap());

        assertTrue(isEqual);
    }

    @Test
    public void extractVTG_GGAFrame_return_null(){
        String message = "$GPGGA,100000,5233.629,N,01323.973,E,1,12,1.0,0.0,M,0.0,M,,*6E";
        VTGFormat vtgFormat = vtgService.extractVTG(message.split(","));

        boolean isEqual = vtgFormat == null;

        assertTrue(isEqual);
    }

}