import java.util.Arrays;

class FindSmallest {

    public static void main(String[] args) {

        int[] randomList = new int[10];
        for (int i = 0; i < randomList.length; i++) {
            randomList[i] = (int)(Math.random()*100 + 1);
        }

        int[] smallest = findSmallest(randomList);

        System.out.printf("The list of numbers is: %s\n", Arrays.toString(randomList));
        System.out.printf("The smallest number and its index is: %d, %d\n", smallest[0], smallest[1]);

    }

    public static boolean isSmallest(int x, int[] list) {
        return x == list[0];
    }

    public static int[] findSmallest(int[] list) {
        int[] sortedList = list.clone();
        Arrays.sort(sortedList);

        int[] smallest = new int[2];

        for (int i = 0; i < list.length; i++) {
            if (isSmallest(list[i], sortedList)) {
                smallest[0] = list[i];
                smallest[1] = i;
                break;
            }
        }

        return smallest;
    }
}
