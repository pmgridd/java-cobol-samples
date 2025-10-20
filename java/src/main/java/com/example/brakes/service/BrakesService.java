package com.example.brakes.service;

import com.example.brakes.model.BrakesCalculationRequest;
import org.springframework.stereotype.Service;

@Service
public class BrakesService {

    public double calculateTemperatureChange(BrakesCalculationRequest request) {
        // Calculate Mgh (loss of potential energy of the truck)
        // Mgh = w * a * d
        double mgh = request.getWeightTruck() * request.getGravityAcceleration() * request.getVerticalDisplacement();

        // Calculate mc (mass of brake material times specific heat)
        double mc = request.getMassBrakeMaterial() * request.getSpecificHeatBrakeMaterial();

        // Calculate the temperature change Mgh / mc
        double deltaTCelsius = mgh / mc;

        return deltaTCelsius;
    }
}