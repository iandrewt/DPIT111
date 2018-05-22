import java.util.Scanner;

class SumOfDigitsRecursion {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("******");

        int num = 0;
        int sum = 0;

        do {
            System.out.print("Please input a positive integer number N: ");
            while (!input.hasNextInt()) {
                System.out.print("Please input a positive integer number N: ");
                input.next();
            }
            numInput = input.nextInt();
        } while (numInput <= 0);

        System.out.printf("Sum of all digits of the number %s is: %d\n", numInput, sumOfDigits(num));
    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10) + sumOfDigits(n / 10);
        }
    }
}
