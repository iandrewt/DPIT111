import java.util.Scanner;

class GoldenRatio {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("******");

        int num = 0;

        do {
            System.out.print("Please input a positive integer number N: ");
            while (!input.hasNextInt()) {
                System.out.print("Please input a positive integer number N: ");
                input.next();
            }
            num = input.nextInt();
        } while (num <= 0);

        System.out.printf("The GoldenRation for %d is: %.15f\n", num, ratio(num));
    }

    public static double ratio(int n) {
        if (n == 0) {
            return 1.0;
        } else {
            return 1.0 + 1.0/ratio(n-1);
        }
    }
}
