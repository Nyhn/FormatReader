package com.akka.epcots.FormatReader.service;

import com.akka.epcots.FormatReader.model.VTGFormat;
import org.springframework.stereotype.Service;

@Service
public class VTGService {
    public VTGFormat extractVTG(String[] messages){
        if(!messages[0].equals("$GPVTG")){
            return null;
        }
        VTGFormat vtgFormat = new VTGFormat();
        /* ATTENTION on suppose que la chaine est ordonnée */
        vtgFormat.setRealCap(Double.parseDouble(messages[1]));
        vtgFormat.setMagneticCap(Double.parseDouble(messages[3]));
        vtgFormat.setNSpeed(Double.parseDouble(messages[5]));
        vtgFormat.setKspeed(Double.parseDouble(messages[7]));
        return vtgFormat;
    }
}
