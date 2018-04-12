import java.util.Scanner;

class Projectile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input initial velocity: ");
		double initialVelocity = input.nextDouble();

		Trajectory trajectory1 = new Trajectory();
		double maxHeight = trajectory1.calculateMaxHeight(initialVelocity);

		System.out.println("Max height: " + maxHeight);	
	}
}
