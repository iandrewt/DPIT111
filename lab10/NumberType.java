import java.util.Scanner;

class NumberType {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please input a number: ");
        String num = input.next();

        if (num.indexOf("-") == -1) {
            if (num.indexOf(".") == -1) {
                if (Integer.parseInt(num) % 2 == 0) {
                    System.out.printf("%s is a positive, even number.\n", num);
                } else {
                    System.out.printf("%s is a positive, odd number.\n", num);
                }
            } else {
                System.out.printf("%s is a positive, floating number.\n", num);
            }
        } else {
            if (num.indexOf(".") == -1) {
                if (Integer.parseInt(num) % 2 == 0) {
                    System.out.printf("%s is a negative, even number.\n", num);
                } else {
                    System.out.printf("%s is a negative, odd number.\n", num);
                }
            } else {
                System.out.printf("%s is a negative, floating number.\n", num);
            }
        }
    }
}
