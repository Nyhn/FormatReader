package com.akka.epcots.FormatReader;

import com.akka.epcots.FormatReader.model.GLLFormat;
import com.akka.epcots.FormatReader.model.NMEAFormat;
import com.akka.epcots.FormatReader.service.GGAService;
import com.akka.epcots.FormatReader.service.GLLService;
import com.akka.epcots.FormatReader.service.VTGService;

/**
 * @Author Created by Dubois Geoffrey
 */
public class FormatProcessing {


    /**
     * Return the First data of Format
     * FOR NMEA is : $GPGGA / $GPVTG / ...
     * @param messages All format
     * @return String
     */
    public String formatDetected(String[] messages){
        return messages[0];
    }

    /**
     * By id of format, function call the good extract methode and good model to keep data of format
     * @param message full format
     */
    public NMEAFormat selectExtractToData(String message){
        FormatReaderService formatReaderService = new FormatReaderService();
        String[] messages = formatReaderService.extractFormat(message);
        if(formatDetected(messages).equals("$GPGGA")){
            GGAService ggaService = new GGAService();
            return ggaService.extractGGA(messages);
        }
        else if(formatDetected(messages).equals("$GPVTG")){
            VTGService vtgService = new VTGService();
            return vtgService.extractVTG(messages);
        }
        else if(formatDetected(messages).equals("$GPGLL")){
            GLLService gllService = new GLLService();
            return gllService.extractGLL(messages);
        }
        else{
            System.out.println("Aucune Identification de la trame -> "+ formatDetected(messages));
            return null;
        }
    }
}
