package com.akka.epcots.FormatReader;

import com.akka.epcots.FormatReader.model.GGAFormat;
import com.akka.epcots.FormatReader.model.GLLFormat;
import com.akka.epcots.FormatReader.model.NMEAFormat;
import static org.junit.jupiter.api.Assertions.*;

import com.akka.epcots.FormatReader.model.VTGFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatProcessingTest {
    FormatProcessing formatProcessing;
    @BeforeEach
    void setUp() {
        formatProcessing = new FormatProcessing();
    }

    @Test
    public void extractToData_string_GGAFormat(){
        String message = "$GPGGA,123519,4807.038,N,01131.324,E,1,08,0.9,545.4,M,46.9,M, , *42";
        NMEAFormat trame= formatProcessing.selectExtractToData(message);
        boolean isGGAFormat = (trame instanceof GGAFormat);
        assertTrue(isGGAFormat);
    }

    @Test
    public void extractToData_string_GLLFormat(){
        String message = "$GPGLL,4916.45,N,12311.12,W,225444,A";
        NMEAFormat trame= formatProcessing.selectExtractToData(message);
        boolean isGGAFormat = (trame instanceof GLLFormat);
        assertTrue(isGGAFormat);
    }

    @Test
    public void extractToData_string_VTGFormat(){
        String message = "$GPVTG,054.7,T,034.4,M,005.5,N,010.2,K";
        NMEAFormat trame= formatProcessing.selectExtractToData(message);
        boolean isGGAFormat = (trame instanceof VTGFormat);
        assertTrue(isGGAFormat);
    }
}