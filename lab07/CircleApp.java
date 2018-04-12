class Circle {
	
	private double rd;

	public Circle( double r ) {
		rd = r;
	}

	public Circle() {
		this(1);
	}

	public Circle( Circle source ) {
		this(source.rd);
	}

	public void setRadius( double r ) {
		rd = r;
	}

	public double getRadius() {
		return rd;
	}

	public double calCircumference() {
		return 2*Math.PI*rd;
	}

	public double calArea() {
		return Math.PI*rd*rd;
	}
}

class CircleApp {

	public static void main( String[] args ) {

		double rd = Double.parseDouble(args[0]);

		System.out.println("Circle radius = " + rd);

		// create an object of Circle with the radius rd
		Circle circle1 = new Circle(rd);
		Circle circle2 = new Circle(circle1);
		Circle circle3 = circle2;

		double cir = circle1.calCircumference();
		double area = circle1.calArea();

		System.out.println("Circumference = " + cir);
		System.out.println("Area = " + area);

		System.out.println("Circle1 radius = " + circle1.getRadius());
		System.out.println("Circle2 radius = " + circle2.getRadius());
		System.out.println("Changing circle 1 radius to 2");
		circle1.setRadius(2);
		System.out.println("Circle1 radius = " + circle1.getRadius());
		System.out.println("Circle2 radius = " + circle2.getRadius());
		System.out.println();
		System.out.println("Circle2 radius = " + circle2.getRadius());
		System.out.println("Circle3 radius = " + circle3.getRadius());
		System.out.println("Changing circle3 radius to 5");
		circle3.setRadius(5);
		System.out.println("Circle2 radius = " + circle2.getRadius());
		System.out.println("Circle3 radius = " + circle3.getRadius());

	}
}
