import java.util.Scanner;

class Coordinates {
	public static void main(String[] args) {
		double radius, angle, x, y;

		// set up inputs
		Scanner radiusInput = new Scanner(System.in);
		Scanner angleInput = new Scanner(System.in);

		// get inputs
		System.out.print("Radius: ");
		radius = radiusInput.nextDouble();
		System.out.print("Angle: ");
		angle = angleInput.nextDouble();

		// calculate coordinates
		x = radius * Math.cos(angle);
		y = radius * Math.sin(angle);

		// return coordinates
		System.out.println("("+x+","+y+")");
	}
}
