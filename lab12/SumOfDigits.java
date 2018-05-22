import java.util.Scanner;

class SumOfDigits {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("******");

        String[] num = new String[0];
        int numInput = 0;
        int sum = 0;

        do {
            System.out.print("Please input a positive integer number N: ");
            while (!input.hasNextInt()) {
                System.out.print("Please input a positive integer number N: ");
                input.next();
            }
            numInput = input.nextInt();
        } while (numInput <= 0);

        num = String.valueOf(numInput).split("");

        for (int i = 0; i < num.length; i++) {
            sum += Integer.parseInt(num[i]);
        }

        System.out.printf("Sum of all digits of the number %s is: %d\n", numInput, sum);
    }
}
