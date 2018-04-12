import java.util.*;

public class asciiUpper {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Input a lowercase letter: ");
		char lowerCase = input.next().charAt(0);

		int upperCase = (int)lowerCase - 32;

		System.out.println("Uppercase: " + (char)upperCase);
	}
}
