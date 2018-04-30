class gcd {

	public static void main(String[] args) {

		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);

		System.out.println("GCD: " + gcd(num1, num2));

	}

	public static int gcd(int num1, int num2) {

		int remainder = num1 % num2;
		
		if(remainder > 0){
			return gcd(num2, remainder);
		} else {
			return num2;
		}
	}

}
