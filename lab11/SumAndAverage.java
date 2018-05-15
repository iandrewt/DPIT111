import java.util.Scanner;

class SumAndAverage {

    public static void main(String[] args) {

        System.out.println("*********");

        Scanner input = new Scanner(System.in);

        int number = -1;
        while (number <= 0) {
            System.out.print("Please input a positive interger number N: ");
            if (!input.hasNextInt()) {
                input.next();
                continue;
            } else {
                number = input.nextInt();
            }
        }

        int start = number;

        int output = 0;

        while (number > 0) {
            output += number--;
        }

        double average = (double)output / (double)start;

        System.out.printf("The sum from 1 to %d is: %d\n", start, output);
        System.out.printf("The average is: %.1f\n", average);

        System.out.println("*********");
    }
}
