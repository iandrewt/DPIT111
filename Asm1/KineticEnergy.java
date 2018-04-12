/*------------------------------------------------------
My name: Andrew Titmuss
My subject code: DPIT111/CSIT111
My student number: 6123521
My email address: at740@uowmail.edu.au
Assignment number: 1
-------------------------------------------------------*/

import static java.lang.Math.*; // import all math methods
import static java.lang.System.*; // in and out can be shorter
import java.util.Scanner; // take input

public class KineticEnergy {

	public static void main(String[] args) {
	
		// variable declarations
		double radius, velocity, mass, linearKineticEnergy,
			angularVelocity, inertia, angularKineticEnergy, kineticEnergy;
		final double DENSITY = 7.8; // density of chosen material, iron here
	
		out.println("*** Kinetic energy calculation ***\n");
		out.println("Enter the following parameters");

		// set up input for radius and linear velocity
		Scanner radiusInput = new Scanner(in);
		Scanner velocityInput = new Scanner(in);

		// get ball radius and store it in the radius variable
		out.print(" - Radius of the ball (m): ");
		radius = radiusInput.nextDouble();
		// get ball velocity and store it in the velocity variable
		out.print(" - Linear velocity of the ball (m/s): ");
		velocity = velocityInput.nextDouble();

		// calculate linear kinetic energy
		mass = 4.0/3.0 * PI * pow(radius, 3) * DENSITY;
		linearKineticEnergy = 0.5 * mass * pow(velocity, 2);

		// calculate angular kinetic energy
		angularVelocity = velocity / radius;
		inertia = 0.4 * mass * pow(radius, 2);
		angularKineticEnergy = 0.5 * inertia * pow(angularVelocity, 2);

		// calculate total kinetic energy
		kineticEnergy = linearKineticEnergy + angularKineticEnergy;
		
		// return the kinetic energy
		out.printf("The total kinetic energy is %.2f (J)\n", kineticEnergy);

		// exit the program
		out.println("The program has terminated");

	}
}
