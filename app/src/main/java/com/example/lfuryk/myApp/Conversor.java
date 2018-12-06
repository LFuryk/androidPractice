package com.example.lfuryk.myApp;

public class Conversor {
    private double miles;
    private double kilometers;

    public Conversor(){
        this.miles = 0;
        this.kilometers = 0;
    }

    public void convert(){
        this.kilometers = this.miles * 1.60934;
    }

    public double getKilometers() {
        return this.kilometers;
    }

    public double getMiles() {
        return this.miles;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }
}
