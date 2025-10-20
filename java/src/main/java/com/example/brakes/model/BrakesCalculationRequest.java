package com.example.brakes.model;

public class BrakesCalculationRequest {
    private double massBrakeMaterial; // m: Mass of brake material in KG, default 100
    private double specificHeatBrakeMaterial; // sh: Specific heat of brake material in Joules per KG x Temp Celsius, default 800
    private double weightTruck; // w: Weight of the truck in KG, default 10000
    private double verticalDisplacement; // d: Vertical displacement on the downhill run in meters, default 75.0
    private double gravityAcceleration; // a: 9.8 meters per second squared, default 9.8

    // Constructor with default values, similar to COBOL's VALUE clause
    public BrakesCalculationRequest() {
        this.massBrakeMaterial = 100.0;
        this.specificHeatBrakeMaterial = 800.0;
        this.weightTruck = 10000.0;
        this.verticalDisplacement = 75.0;
        this.gravityAcceleration = 9.8;
    }

    // Getters and Setters
    public double getMassBrakeMaterial() {
        return massBrakeMaterial;
    }

    public void setMassBrakeMaterial(double massBrakeMaterial) {
        this.massBrakeMaterial = massBrakeMaterial;
    }

    public double getSpecificHeatBrakeMaterial() {
        return specificHeatBrakeMaterial;
    }

    public void setSpecificHeatBrakeMaterial(double specificHeatBrakeMaterial) {
        this.specificHeatBrakeMaterial = specificHeatBrakeMaterial;
    }

    public double getWeightTruck() {
        return weightTruck;
    }

    public void setWeightTruck(double weightTruck) {
        this.weightTruck = weightTruck;
    }

    public double getVerticalDisplacement() {
        return verticalDisplacement;
    }

    public void setVerticalDisplacement(double verticalDisplacement) {
        this.verticalDisplacement = verticalDisplacement;
    }

    public double getGravityAcceleration() {
        return gravityAcceleration;
    }

    public void setGravityAcceleration(double gravityAcceleration) {
        this.gravityAcceleration = gravityAcceleration;
    }
}