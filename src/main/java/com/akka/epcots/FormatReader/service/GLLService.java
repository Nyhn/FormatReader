package com.akka.epcots.FormatReader.service;

import com.akka.epcots.FormatReader.model.GLLFormat;
import org.springframework.stereotype.Service;

@Service
public class GLLService {
    public GLLFormat extractGLL(String[] messages){
        if(!messages[0].equals("$GPGLL")){
            return null;
        }
        GLLFormat gllFormat = new GLLFormat();
        gllFormat.setLatitude(Double.parseDouble(messages[1]));
        gllFormat.setCardinalLatitude(messages[2].charAt(0));
        gllFormat.setLongitude(Double.parseDouble(messages[3]));
        gllFormat.setCardinalLongitude(messages[4].charAt(0));
        return gllFormat;
    }
}
