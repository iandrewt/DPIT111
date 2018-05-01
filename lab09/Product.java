class Product {
	private String name;
	private double price;
	private int productID;
	private static int total;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		productID = ++total;
	}
	
	public String getName() {
		return name;
	}

	public int getProductID() {
		return productID;
	}

	public double getPrice() {
		return price;
	}

	public void changePrice(double price) {
		this.price = price;
	}

	public static int getTotal() {
		return total;
	}
}
