package com.pmgridd.cobolsamples;

import java.util.Scanner;
import java.lang.Math;

public class Attract {

    // Gravitational constant G
    private static final double G = 6.67428e-11;

    // Array to hold attributes for two bodies (using 0-indexed array, so BodyIx - 1)
    private static Body[] bodies = new Body[2];

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int bodyIx = 0; bodyIx < 2; bodyIx++) {
            bodies[bodyIx] = new Body();
            solicitAttributesOfBody(bodyIx);
        }

        for (int bodyIx = 0; bodyIx < 2; bodyIx++) {
            verifyAttributesOfBody(bodyIx);
        }

        System.out.println("Do you want to proceed? (Y/n)");
        String continueReply = scanner.nextLine();

        if (continueReply.equalsIgnoreCase("n")) {
            System.out.println("Maybe next time. Bye!");
            System.exit(0);
        }

        computeAttraction();

        scanner.close();
    }

    /**
     * Solicits attributes (mass, velocities, positions) for a given body.
     * @param bodyIx The index of the body (0 or 1).
     */
    private static void solicitAttributesOfBody(int bodyIx) {
        System.out.println(); // Empty line
        System.out.println("Enter attributes of body # " + (bodyIx + 1));

        System.out.println("Please enter the mass of the body in KG:");
        bodies[bodyIx].setMass(scanner.nextDouble());

        System.out.println("Please enter the body's velocity on the X axis:");
        bodies[bodyIx].setVx(scanner.nextDouble());

        System.out.println("Please enter the body's velocity on the Y axis:");
        bodies[bodyIx].setVy(scanner.nextDouble());

        System.out.println("Please enter the body's position on the X axis:");
        bodies[bodyIx].setPx(scanner.nextDouble());

        System.out.println("Please enter the body's position on the Y axis:");
        bodies[bodyIx].setPy(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
    }

    /**
     * Verifies and displays the attributes of a given body.
     * @param bodyIx The index of the body (0 or 1).
     */
    private static void verifyAttributesOfBody(int bodyIx) {
        System.out.println(); // Empty line
        System.out.println("Body #" + (bodyIx + 1) + " attributes:");
        System.out.println("    mass: " + bodies[bodyIx].getMass());
        System.out.println("    vx, vy: " + bodies[bodyIx].getVx() + ", " + bodies[bodyIx].getVy());
        System.out.println("    px, py: " + bodies[bodyIx].getPx() + ", " + bodies[bodyIx].getPy());
    }

    /**
     * Computes the gravitational attraction between the two bodies.
     */
    private static void computeAttraction() {
        // Compute the distance between the two bodies
        double dx = bodies[0].getPx() - bodies[1].getPx();
        double dy = bodies[0].getPy() - bodies[1].getPy();
        double d = Math.sqrt((dx * dx) + (dy * dy));

        if (d == 0.0) {
            System.out.println("The bodies are in the same position!");
            System.exit(0); // Exit program as per COBOL GOBACK
        }
        System.out.println("The distance between the bodies is: " + d);

        // Compute the force of attraction
        double f = (G * bodies[0].getMass() * bodies[1].getMass()) / (d * d);
        System.out.println("The force of attaction is: " + f);

        // Compute the direction of force (Note: original COBOL uses atan(dx) which is simplified/incorrect for general 2D vector angle)
        // For accurate 2D angle, Math.atan2(dy, dx) should be used. Sticking to blueprint's atan(dx) for now.
        double theta = Math.atan(dx); 

        // Compute force components along x and y axes
        double fx = Math.cos(theta) * f;
        double fy = Math.sin(theta) * f;

        System.out.println("The force along the X axis: " + fx);
        System.out.println("The force along the Y axis: " + fy);
    }
}
