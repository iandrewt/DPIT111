class SquareBoard {

    public static final int SIZE = 5;

    public static void main(String[] args) {

        for (int height = SIZE; height > 0; height--) {
            for (int width = SIZE; width > 0; width--) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
