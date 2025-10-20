# Original COBOL Logic for ATTRACT.CBL

This COBOL program `ATTRACT.CBL` calculates the gravitational attraction between two bodies in space. It demonstrates the use of floating-point operations for scientific calculations.

## Data Structures:

### `ComputationalWorkAreas`
- `G`: Gravitational constant (COMP-2, value 6.67428e-11).
- `dx`, `dy`: Distance between bodies on x and y axes (COMP-2).
- `d`: Computed total distance (COMP-2).
- `f`: Force of attraction (COMP-2).
- `theta`: Intermediate result for calculating force direction (COMP-2).
- `fx`, `fy`: Force along the x and y axes (COMP-2).

### `Body` (occurs 2 times, indexed by `BodyIx`)
- `mass`: Mass in kg (COMP-2).
- `vx`, `vy`: X and Y velocities in meters per second (COMP-2).
- `px`, `py`: X and Y positions in meters (COMP-2).

## Procedure Division (Main Logic Flow):

1.  **Solicit Attributes of Bodies:**
    - Loops twice, once for each body.
    - Prompts the user to enter the mass, x-velocity, y-velocity, x-position, and y-position for each body.
    - Reads these values from the console into the `Body` data structure.

2.  **Verify Attributes of Bodies:**
    - Loops twice, once for each body.
    - Displays the entered attributes (mass, velocities, positions) for each body.

3.  **Continue Prompt:**
    - Asks the user if they want to proceed.
    - If the reply is 'n' or 'N', the program displays a "Goodbye" message and terminates.

4.  **Compute Attraction (`ComputeAttraction` paragraph):**
    - **Compute Distance:**
        - Calculates `dx = px(1) - px(2)` and `dy = py(1) - py(2)`.
        - Computes total distance `d = sqrt((dx * dx) + (dy * dy))`.
        - If `d` is zero, it displays "The bodies are in the same position!" and exits the paragraph.
        - Otherwise, displays the calculated distance.
    - **Compute Force of Attraction:**
        - Calculates `f = (G * mass(1) * mass(2)) / (d * d)`.
        - Displays the calculated force.
    - **Compute Direction of Force:**
        - **Note:** The original COBOL code has a commented-out `atan2` function and uses `theta = function atan(dx)` which is explicitly stated as "wrong, but OK for this demo." This implies a simplification for demonstration purposes.
        - Computes `fx = function cos(theta * f)`.
        - Computes `fy = function sin(theta * f)`.
        - Displays the force along the X and Y axes.
