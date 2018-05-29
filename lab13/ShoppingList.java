import java.util.Scanner;
import java.util.ArrayList;

class ShoppingList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> items = new ArrayList<>();

        while(true) {
            System.out.print("Please input an item: ");
            String item = sc.nextLine();
            if (item.equals("None")) {
                break;
            }
            items.add(item);
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
}
