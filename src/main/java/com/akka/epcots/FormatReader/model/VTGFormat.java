package com.akka.epcots.FormatReader.model;

public class VTGFormat extends NMEAFormat{
    private double realCap;
    private double magneticCap;
    private double NSpeed;
    private double Kspeed;

    public VTGFormat() {
    }

    public double getRealCap() {
        return realCap;
    }

    public void setRealCap(double realCap) {
        this.realCap = realCap;
    }

    public double getMagneticCap() {
        return magneticCap;
    }

    public void setMagneticCap(double magneticCap) {
        this.magneticCap = magneticCap;
    }

    public double getNSpeed() {
        return NSpeed;
    }

    public void setNSpeed(double NSpeed) {
        this.NSpeed = NSpeed;
    }

    public double getKspeed() {
        return Kspeed;
    }

    public void setKspeed(double kspeed) {
        Kspeed = kspeed;
    }

    @Override
    public String toString() {
        return "VTGFormat{" +
                "realCap=" + realCap +
                ", magneticCap=" + magneticCap +
                ", NSpeed=" + NSpeed +
                ", Kspeed=" + Kspeed +
                '}';
    }
}
