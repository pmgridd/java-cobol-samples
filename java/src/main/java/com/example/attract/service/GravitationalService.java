package com.example.attract.service;

import com.example.attract.model.Body;
import org.springframework.stereotype.Service;

@Service
public class GravitationalService {

    // Gravitational constant G
    private static final double G = 6.67428e-11;

    public GravitationalCalculationResult calculateAttraction(Body body1, Body body2) {
        // Compute the distance between the two bodies
        double dx = body1.getPx() - body2.getPx();
        double dy = body1.getPy() - body2.getPy();
        double d = Math.sqrt((dx * dx) + (dy * dy));

        if (d == 0) {
            throw new IllegalArgumentException("The bodies are in the same position!");
        }

        // Compute the force of attraction
        double f = (G * body1.getMass() * body2.getMass()) / (d * d);

        // Compute the direction of force
        // Original COBOL code used: compute theta = function atan(dx)
        // This is noted in the COBOL code as "wrong, but OK for this demo."
        // A more accurate calculation would typically use Math.atan2(dy, dx)
        double theta = Math.atan(dx);
        double fx = Math.cos(theta) * f;
        double fy = Math.sin(theta) * f;

        return new GravitationalCalculationResult(d, f, fx, fy);
    }

    public static class GravitationalCalculationResult {
        private final double distance;
        private final double force;
        private final double forceAlongX;
        private final double forceAlongY;

        public GravitationalCalculationResult(double distance, double force, double forceAlongX, double forceAlongY) {
            this.distance = distance;
            this.force = force;
            this.forceAlongX = forceAlongX;
            this.forceAlongY = forceAlongY;
        }

        public double getDistance() {
            return distance;
        }

        public double getForce() {
            return force;
        }

        public double getForceAlongX() {
            return forceAlongX;
        }

        public double getForceAlongY() {
            return forceAlongY;
        }
    }
}