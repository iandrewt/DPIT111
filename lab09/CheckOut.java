public class CheckOut {

	public static void main(String[] args) {

		Product[] products = new Product[3];
		products[0] = new Product("Milk", 2.99);
		products[1] = new Product("Apple", 5.49);
		products[2] = new Product("Bread", 1.75);

		CashRegister register1 = new CashRegister();
		System.out.println("***** At Register 1 *****");
		register1.scanProduct(products[0]);
		register1.scanProduct(products[1]);
		register1.scanProduct(products[2]);
		register1.displayRegister();
		register1.scanProduct(products[1]);
		register1.displayRegister();
		
		CashRegister register2 = new CashRegister();
		System.out.println("***** At Register 2 *****");
		register2.scanProduct(products[0]);
		register2.scanProduct(products[2]);
		register2.displayRegister();
	}
}

