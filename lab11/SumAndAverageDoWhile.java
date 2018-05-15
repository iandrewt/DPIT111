import java.util.Scanner;

class SumAndAverageDoWhile {

    public static void main(String[] args) {

        System.out.println("*********");

        Scanner input = new Scanner(System.in);

        int number = -1;
        do {
            System.out.print("Please input a positive interger number N: ");
            if(!input.hasNextInt()) {
                input.next();
                continue;
            } else {
                number = input.nextInt();
            }
        } while (number <= 0);

        int start = number;

        int output = 0;

        do {
            output += number--;
        } while (number > 0);

        double average = (double)output / (double)start;

        System.out.printf("The sum from 1 to %d is: %d\n", start, output);
        System.out.printf("The average is: %.1f\n", average);

        System.out.println("*********");
    }
}
