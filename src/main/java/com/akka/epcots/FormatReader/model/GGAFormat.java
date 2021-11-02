package com.akka.epcots.FormatReader.model;

import java.util.Date;

public class GGAFormat extends NMEAFormat{
    /** fix acquisition **/
    private Date fix;
    private double latitude;
    private char cardinalLatitude; // N,E,S,O
    private double longitude;
    private char cardinalLongitude;
    private double altitude;
    private char unityAltitude; //M : meter

    /* Constructor */
    public GGAFormat() {
    }

    /* Getter and Setter */
    public Date getFix() {
        return fix;
    }
    public void setFix(Date fix) {
        this.fix = fix;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public char getCardinalLatitude() {
        return cardinalLatitude;
    }
    public void setCardinalLatitude(char cardinalLatitude) {
        this.cardinalLatitude = cardinalLatitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public char getCardinalLongitude() {
        return cardinalLongitude;
    }
    public void setCardinalLongitude(char cardinalLongitude) {
        this.cardinalLongitude = cardinalLongitude;
    }

    public double getAltitude() {
        return altitude;
    }
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public char getUnityAltitude() {
        return unityAltitude;
    }
    public void setUnityAltitude(char unityAltitude) {
        this.unityAltitude = unityAltitude;
    }

    /**
     * toString Data of GGA
     * @return
     */
    @Override
    public String toString() {
        return "GGAFormat{" +
                "fix=" + fix +
                ", latitude=" + latitude +
                ", cardinalLatitude=" + cardinalLatitude +
                ", longitude=" + longitude +
                ", cardinalLongitude=" + cardinalLongitude +
                ", altitude=" + altitude +
                ", unityAltitude=" + unityAltitude +
                '}';
    }
}
