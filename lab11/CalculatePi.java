class CalculatePi {

    public static void main(String[] args) {

        double pi = 0;

        for (int i = 1; i < 100000000; i++) {
            double nextValue = 1.0/((i*2.0)-1.0);
            if (i % 2 == 1) {
                pi += nextValue;
            } else {
                pi -= nextValue;
            }
        }

        pi *= 4;

        double percentage = pi / Math.PI;

        System.out.printf("Calculated Pi: %.20f\n", pi);
        System.out.printf("Java Math.PI: %.20f\n", Math.PI);
        System.out.printf("Percentage of Math.PI: %f%%\n", percentage * 100.0);
    }
}
