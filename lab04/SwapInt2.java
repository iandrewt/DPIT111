class SwapInt2 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		System.out.println("Before: " + "a = " + a + ", b = " + b);
		/* -- Please insert below your code for swapping a and b -- */

		a = a+ b;
		b = a -b;
		a = a -b;

		System.out.println("After: " + "a = " + a + ", b = " + b);
	}
}
