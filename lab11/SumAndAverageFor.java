import java.util.Scanner;

class SumAndAverageFor {

    public static void main(String[] args) {

        System.out.println("*********");

        Scanner input = new Scanner(System.in);

        int number = -1;
        while (number < 0) {
            System.out.print("Please input a positive interger number N: ");
            if (!input.hasNextInt()) {
                input.next();
                continue;
            } else {
                number = input.nextInt();
            }
        }

        int sum = 0;

        for (int i = number; i > 0; i--) {
            sum += i;
        }

        double average = (double)sum / (double)number;

        System.out.printf("The sum from 1 to %d is: %d\n", number, sum);
        System.out.printf("The average is: %.1f\n", average);

        System.out.println("*********");
    }
}
