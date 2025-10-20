package com.example.attract.model;

public class Body {
    private double mass; // mass in kg
    private double vx;   // x velocity in meters per second
    private double vy;   // y velocity in meters per second
    private double px;   // x position in meters
    private double py;   // y position in meters

    // Getters and Setters
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getPx() {
        return px;
    }

    public void setPx(double px) {
        this.px = px;
    }

    public double getPy() {
        return py;
    }

    public void setPy(double py) {
        this.py = py;
    }
}