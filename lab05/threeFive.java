import java.util.Scanner;

public class threeFive {

	public static void main(String[] args) {
		
		System.out.print("Enter flaoting point number nA: ");

		Scanner input = new Scanner(System.in);
		double nA = input.nextDouble();

		double nB = Math.pow(nA, 3.5);

		System.out.printf("%.1f\n", Math.min(nB,199.0));
	}
}
