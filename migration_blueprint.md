# Migration Blueprint: COBOL ATTRACT to Java

## Project Summary

This project, originally written in COBOL, calculates the gravitational attraction between two celestial bodies in space. It serves as a demonstration of floating-point arithmetic and basic input/output operations in COBOL. The program prompts the user for the mass, velocity components (vx, vy), and position components (px, py) for two bodies. It then computes the distance between them, the force of attraction, and the x and y components of that force.

## File Breakdown and Pseudocode

### Source File: `src/main/cobol/ATTRACT.CBL`

This is the sole source file for the COBOL project. It contains the main program logic, data definitions, and subroutines for soliciting input, verifying attributes, and performing the gravitational force calculation.

#### Global Constants / Working-Storage Variables

*   `G`: Gravitational constant. Type: Floating-point (double). Initial value: `6.67428e-11`.
*   `dx`, `dy`: Differences in x and y positions between the two bodies. Type: Floating-point (double).
*   `d`: Euclidean distance between the two bodies. Type: Floating-point (double).
*   `f`: Force of attraction. Type: Floating-point (double).
*   `theta`: Angle used in force direction calculation. Type: Floating-point (double).
*   `fx`, `fy`: X and Y components of the force of attraction. Type: Floating-point (double).
*   `Body`: An array/structure to hold attributes for two bodies. Each body has:
    *   `mass`: Mass in kilograms. Type: Floating-point (double).
    *   `vx`, `vy`: Velocity components (x and y) in meters/second. Type: Floating-point (double).
    *   `px`, `py`: Position components (x and y) in meters. Type: Floating-point (double).
*   `ContinueReply`: User's response (Y/n) to continue. Type: String.

#### Main Program Flow

```pseudocode
FUNCTION main()
    FOR BodyIx FROM 1 TO 2
        CALL SolicitAttributesOfBody(BodyIx)
    END FOR

    FOR BodyIx FROM 1 TO 2
        CALL VerifyAttributesOfBody(BodyIx)
    END FOR

    DISPLAY "Do you want to proceed? (Y/n)"
    ACCEPT ContinueReply FROM CONSOLE

    IF ContinueReply IS "n" OR "N" THEN
        DISPLAY "Maybe next time. Bye!"
        EXIT PROGRAM
    END IF

    CALL ComputeAttraction()

    EXIT PROGRAM
END FUNCTION
```

#### Function: `SolicitAttributesOfBody(BodyIx)`

This function prompts the user to enter the mass, velocity (x and y), and position (x and y) for a specific body identified by `BodyIx`.

```pseudocode
FUNCTION SolicitAttributesOfBody(BodyIx)
    DISPLAY EMPTY LINE
    DISPLAY "Enter attributes of body # " + BodyIx
    DISPLAY "Please enter the mass of the body in KG:"
    ACCEPT mass[BodyIx] FROM CONSOLE

    DISPLAY "Please enter the body's velocity on the X axis:"
    ACCEPT vx[BodyIx] FROM CONSOLE

    DISPLAY "Please enter the body's velocity on the Y axis:"
    ACCEPT vy[BodyIx] FROM CONSOLE

    DISPLAY "Please enter the body's position on the X axis:"
    ACCEPT px[BodyIx] FROM CONSOLE

    DISPLAY "Please enter the body's position on the Y axis:"
    ACCEPT py[BodyIx] FROM CONSOLE
END FUNCTION
```

#### Function: `VerifyAttributesOfBody(BodyIx)`

This function displays the attributes (mass, velocities, positions) that were entered for a specific body.

```pseudocode
FUNCTION VerifyAttributesOfBody(BodyIx)
    DISPLAY EMPTY LINE
    DISPLAY "Body #" + BodyIx + " attributes:"
    DISPLAY "    mass: " + mass[BodyIx]
    DISPLAY "    vx, vy: " + vx[BodyIx] + ", " + vy[BodyIx]
    DISPLAY "    px, py: " + px[BodyIx] + ", " + py[BodyIx]
END FUNCTION
```

#### Function: `ComputeAttraction()`

This function calculates the distance between the two bodies, the gravitational force of attraction, and its x and y components.

```pseudocode
FUNCTION ComputeAttraction()
    // Compute the distance between the two bodies
    SET dx = px[1] - px[2]
    SET dy = py[1] - py[2]
    SET d = SQRT((dx * dx) + (dy * dy))

    IF d IS EQUAL TO ZERO THEN
        DISPLAY "The bodies are in the same position!"
        EXIT PROGRAM // Or handle as an error/special case
    END IF
    DISPLAY "The distance between the bodies is: " + d

    // Compute the force of attraction
    SET f = (G * mass[1] * mass[2]) / (d * d)
    DISPLAY "The force of attaction is: " + f

    // Compute the direction of force (Note: original COBOL uses atan(dx) which is simplified/incorrect for general 2D vector angle)
    SET theta = ATAN(dx) // This should ideally be ATAN2(dy, dx) for correct quadrant handling

    // Compute force components along x and y axes
    SET fx = COS(theta) * f
    SET fy = SIN(theta) * f

    DISPLAY "The force along the X axis: " + fx
    DISPLAY "The force along the Y axis: " + fy
END FUNCTION
```

## Identified External Dependencies

*   Standard Input/Output (Console for Java)
*   Mathematical functions: `sqrt`, `atan`, `cos`, `sin` (available in `java.lang.Math` in Java).

---