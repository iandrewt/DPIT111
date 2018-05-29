class TimeTable2DArray {

    public static void main(String[] args) {

        final int size = 9;

        int[][] numArray = new int[size][size];

        // create table
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                numArray[i][j] = (i + 1) * (j + 1);
            }
        }

        // header
        for (int i = 0; i <= size; i++) {
            if (i == 0) {
                System.out.print(" * | ");
            } else {
                System.out.printf(" %d ",i);
            }
        }
        // new line
        System.out.println();
        // dashes
        for (int i = 0; i <= size; i++) {
            System.out.print("---");
        }
        // new line with final dash
        System.out.println("-");

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (j == 0) {
                    System.out.printf(" %d |", i);
                } else {
                    System.out.printf(" %2d", numArray[i-1][j-1]);
                }
            }
            System.out.println();
        }
    }
}
