package com.akka.epcots.FormatReader.model;

public class GLLFormat extends NMEAFormat{
    private double latitude;
    private char cardinalLatitude; // N,E,S,O
    private double longitude;
    private char cardinalLongitude;

    public GLLFormat() {
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

    @Override
    public String toString() {
        return "GLLFormat{" +
                "latitude=" + latitude +
                ", cardinalLatitude=" + cardinalLatitude +
                ", longitude=" + longitude +
                ", cardinalLongitude=" + cardinalLongitude +
                '}';
    }
}
