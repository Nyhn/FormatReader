package com.akka.epcots.FormatReader;

import org.springframework.stereotype.Service;

@Service
public class FormatReaderService {
    public FormatReaderService() {
    }

    public String[] extractFormat(String message){
        return message.split(",");
    }

    public void display(String message){
        System.out.println("Le message initiale avant traitement : "+message);
    }

    public void display(String[] messages){
        System.out.println("Détails du message après split: ");
        for (int i = 0; i < messages.length; i++) {
            System.out.println(i + " : " + messages[i]);
        }
    }
}
