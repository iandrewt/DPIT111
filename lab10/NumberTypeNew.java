import java.util.Scanner;

class NumberTypeNew {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String sign, type;

        System.out.print("Please input a number: ");
        String num = input.next();

        if (num.indexOf("-") == -1) {
            sign = "positive";
        } else {
            sign = "negative";
        }

        if (num.indexOf(".") != -1) {
            type = "floating";
        } else if (Integer.parseInt(num) % 2 == 0) {
            type = "even";
        } else {
            type = "odd";
        }

        System.out.printf("%s is a %s, %s number.\n", num, sign, type);

    }
}
