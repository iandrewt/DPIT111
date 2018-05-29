import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

class FindBiggestArrayList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numArray = new ArrayList<>();

        int n; // input

        do {
            System.out.print("Please input a positive integer n: ");
            while(!sc.hasNextInt()) {
                System.out.print("Not a positive integer!");
                sc.nextLine();
                System.out.print("Please input a positive integer n: ");
            }
            n = sc.nextInt();
            if (n != 0) {
                numArray.add(n);
            }
        } while (n != 0);

        int[] biggest = findBiggest(numArray);

        System.out.printf("The list of numbers is: %s\n", Arrays.toString(numArray.toArray()));
        System.out.printf("The biggest number and its index is: %d, %d\n", biggest[0], biggest[1]);

    }

    public static boolean isBiggest(int x, int[] list) {
        if (x == list[list.length - 1]) {
            return true;
        }
        return false;
    }

    public static int[] findBiggest(ArrayList<Integer> list) {

        int value = list.get(0);
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
           if (list.get(i) > value) {
               value = list.get(i);
               index = i;
           }
        }

        int[] biggest = {value, index};

        return biggest;
    }
}
