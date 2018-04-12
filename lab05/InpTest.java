import java.util.Scanner;

class InpTest {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter a double: ");
		double db = keyboard.nextDouble();
		System.out.println("Input was: " + db);

		System.out.print("Enter an integer: ");
		try {
			int ia = keyboard.nextInt();
			System.out.println("Input was: " + ia);
		} catch (java.util.InputMismatchException e) {
			System.out.println("Input should be an integer");
		}
	}
}
