# Original COBOL Logic for BRAKES.CBL

This COBOL program `BRAKES.CBL` calculates the temperature of truck brakes after a downhill drive. It demonstrates how to code engineering calculations in COBOL.

## Problem Description (from source comments):

This program solves a problem posed on the Internet to compute the temperature of truck brakes after a downhill drive. (See https://courses.lumenlearning.com/physics/chapter/14-2-deltaT-Celsius-and-heat-capacity/).

## Data Structures:

### `GIVEN-VALUES`
- `m`: Mass of brake material in KG (COMP-2, VALUE 100).
- `sh`: Specific heat of brake material in Joules per KG x Temp Celsius (COMP-2, VALUE 800).
- `w`: Weight of the truck in KG (COMP-2, VALUE 10000).
- `d`: Vertical displacement on the downhill run in meters (COMP-2, VALUE 75.0).
- `a`: Acceleration due to gravity (9.8 meters per second squared) (COMP-2, VALUE 9.8).

### `CALCULATED-VALUES`
- `Mgh`: Gravitational potential energy loss of the truck in descent (COMP-2).
- `deltaT-Celsius`: Temperature change in Celsius from the heat exchange (COMP-2).
- `mc`: Mass of brake material times specific heat (COMP-2).
- `deltaT-Celsius-Formatted`: Temperature change formatted for display (PIC Z,ZZ9.99).

## Procedure Division (Main Logic Flow):

1.  **Calculate `Mgh` (loss of potential energy of the truck):**
    - Formula: `Mgh = w * a * d`
    - *Example (from source comments):* Mgh = (10,000 kg)(9.80 m/s2)(75.0 m) = 7.35 × 10^6 J.

2.  **Calculate the temperature change (`deltaT-Celsius`):**
    - First, calculate `mc = m * sh` (mass of brake material times specific heat).
    - Then, `deltaT-Celsius = Mgh / mc`.

3.  **Display Result:**
    - `MOVE deltaT-Celsius TO deltaT-Celsius-Formatted`.
    - `DISPLAY 'deltaT-Celsius: ' deltaT-Celsius-Formatted`.

4.  **Terminate:** `GOBACK`.
