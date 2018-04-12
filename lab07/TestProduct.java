class Product {
	
	private String name;
	private double price;
	private int scanCode;
	private static int numOfObjects = 0;

	public Product(String n, double p) {
		name = n;
		price = p;
		scanCode = 1000 + numOfObjects++;
	}

	public String getName() {
		return name;
	}

	public int getScanCode() {
		return scanCode;
	}

	public double getPrice() {
		return price;
	}

	public void changePrice(double p) {
		price = p;
	}

	public static int getNumOfObjects() {
		return numOfObjects;
	}
}

class TestProduct {
	public static void main(String[] args) {
		System.out.println("There are " + Product.getNumOfObjects() + " items.");

		Product pr1 = new Product("Computer", 1500.0);

		System.out.println("There are " + Product.getNumOfObjects() + " items.");

		Product pr2 = new Product("Printer", 600.0);
		Product pr3 = new Product("Monitor", 240.0);
		System.out.println("There are " + Product.getNumOfObjects() + " items.");

		pr2.changePrice( 549.99 );

		System.out.println(" -- Product info -- ");
		System.out.println("Name: " + pr2.getName());
		System.out.println("Scan code: " + pr2.getScanCode());
		System.out.println("Price: " + pr2.getPrice());
	}
}
