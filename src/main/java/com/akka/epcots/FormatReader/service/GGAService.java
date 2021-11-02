package com.akka.epcots.FormatReader.service;

import com.akka.epcots.FormatReader.model.GGAFormat;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
public class GGAService {
    public GGAFormat extractGGA(String[] messages){
        if(!messages[0].equals("$GPGGA")){
            return null;
        }
        GGAFormat ggaFormat = new GGAFormat();
        Date date = convertDate(messages[1]);
        ggaFormat.setFix(convertDate(messages[1]));
        ggaFormat.setLatitude(Double.parseDouble(messages[2]));
        ggaFormat.setCardinalLatitude(messages[3].charAt(0));
        ggaFormat.setLongitude(Double.parseDouble(messages[4]));
        ggaFormat.setCardinalLongitude(messages[5].charAt(0));
        ggaFormat.setAltitude(Double.parseDouble(messages[9]));
        ggaFormat.setUnityAltitude(messages[10].charAt(0));
        return ggaFormat;
    }

    public Date convertDate(String message) {
        if(message.length() != 6)
            return null;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(message.substring(0, 2)));
        cal.set(Calendar.MINUTE,Integer.parseInt(message.substring(2, 4)));
        cal.set(Calendar.SECOND,Integer.parseInt(message.substring(4)));

        return cal.getTime();
    }
}
