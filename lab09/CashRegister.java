public class CashRegister {
	private double total = 0;
	private int numProducts = 0;

	public void scanProduct(Product product) {
		total += product.getPrice();
		numProducts++;
	}

	public int getNumProducts() {
		return numProducts;
	}

	public double getTotal() {
		return total;
	}
	
	public void displayRegister() {
		System.out.printf("You have purchased %d items\n", numProducts);
		System.out.printf("Total: $%.2f\n", total);
	}
}
