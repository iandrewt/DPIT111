import java.util.Arrays;
import java.util.Scanner;

class FindBiggest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n; // array length

        do {
            System.out.print("Please input a positive integer n: ");
            while(!sc.hasNextInt()) {
                System.out.print("Not a positive integer!");
                sc.nextLine();
                System.out.print("Please input a positive integer n: ");
            }
            n = sc.nextInt();
        } while (n <= 0);

        int[] numArray = new int[n];

        System.out.printf("Please input %d numbers (space delimited): ", n);

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = sc.nextInt();
        }

        int[] biggest = findBiggest(numArray);

        System.out.printf("The list of numbers is: %s\n", Arrays.toString(numArray));
        System.out.printf("The biggest number and its index is: %d, %d\n", biggest[0], biggest[1]);

    }

    public static boolean isBiggest(int x, int[] list) {
        if (x == list[list.length - 1]) {
            return true;
        }
        return false;
    }

    public static int[] findBiggest(int[] list) {
        int[] sortedList = list.clone();
        Arrays.sort(sortedList);

        int[] biggest = new int[2];

        for (int i = 0; i < list.length; i++) {
            if (isBiggest(list[i], sortedList)) {
                biggest[0] = list[i];
                biggest[1] = i;
                break;
            }
        }

        return biggest;
    }
}
