import java.util.Scanner;

class TimeTable {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("******");
        System.out.print("Please input a positive integer number N: ");

        int num = input.nextInt();

        // header
        for (int i = 0; i <= num; i++) {
            if (i == 0) {
                System.out.print(" * | ");
            } else {
                System.out.printf(" %d ",i);
            }
        }
        // new line
        System.out.println();
        // dashes
        for (int i = 0; i <= num; i++) {
            System.out.print("---");
        }
        // new line with final dash
        System.out.println("-");

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                if (j == 0) {
                    System.out.printf(" %d |", i);
                } else {
                    if (i * j < 10) {
                        System.out.printf("  %d", i * j);
                    } else {
                        System.out.printf(" %d", i * j);
                    }
                }
            }
            System.out.println();
        }
    }
}
