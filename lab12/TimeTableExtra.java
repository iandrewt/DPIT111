import java.util.Scanner;

class TimeTableExtra {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("******");
        System.out.print("Please input a positive integer number N: ");

        int num = input.nextInt();

        int size = (int)Math.floor(Math.log10(num)) + 1;
        int cellSize = (int)Math.floor(Math.log10(num * num)) + 1;
        System.out.println(size);
        System.out.println(cellSize);
        String spaces = String.format("%0" + size + "d", 0).replace("0", " ");

        // header
        for (int i = 0; i <= num; i++) {
            if (i == 0) {
                System.out.printf("%s* |", spaces);
            } else {
                System.out.printf("%" + cellSize + "d ",i);
            }
        }
        // new line
        System.out.println();
        // dashes
        for (int i = 1; i < (num + 1) * cellSize + num + 2; i++) {
            System.out.printf("-");
        }
        System.out.println();

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                if (j == 0) {
                    System.out.printf(" %" + size + "d |", i);
                } else {
                    System.out.printf("%" + cellSize + "d ", i * j);
                }
            }
            System.out.println();
        }
    }
}
