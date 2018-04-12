/*------------------------------------------------------
My name: Andrew Titmuss
My subject code: DPIT111/CSIT111
My student number: 6123521
My email address: at740@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.Scanner; // take input from the user

class OprWithComplexNumbers {

	// variables used by calculateResults() and displayResults()
	// are shared and only used in the OprWithComplexNumbers class
	private static ComplexNumber resSum, resDifference, resProduct;

	public static void main(String[] args) {

		System.out.println("--- Basic arithmetic operations with complex numbers ---");

		Scanner input = new Scanner(System.in); // initialise input method

		// asks for first complex set and stores it in an array of strings,
		// split into comp1[0] and comp2[1] by the whitespace between them using regex
		System.out.print("Enter the first complex number in the format r i: ");
		String[] comp1 = input.nextLine().split("\\s+");

		// converts the strings in the comp1 array to doubles to later be put in the
		// ComplexNumber objects. Creating variables like this makes the code more
		// readable at the expense of memory consumption (each portion is stored 3 times,
		// once in the array, once here, and again in the ComplexNumber object and isn't
		// cleaned up).
		double comp1real = Double.parseDouble(comp1[0]);
		double comp1imaginary = Double.parseDouble(comp1[1]);

		// again as above for comp2.
		System.out.print("Enter the second complex number in the format r i: ");
		String[] comp2 = input.nextLine().split("\\s+");

		double comp2real = Double.parseDouble(comp2[0]);
		double comp2imaginary = Double.parseDouble(comp2[1]);

		// creates the ComplexNumber objects for the two complex numbers
		ComplexNumber compNum1 = new ComplexNumber(comp1real, comp1imaginary);
		ComplexNumber compNum2 = new ComplexNumber(comp2real, comp2imaginary);

		// calculate and display the results
		calculateResults(compNum1, compNum2);
		displayResults(compNum1, compNum2);

		System.out.println("--- The program has terminated ---");

	}

	public static void calculateResults(ComplexNumber comp1, ComplexNumber comp2) {

		// initialise the calculator object using the two complex numbers
		Calculator calc = new Calculator(comp1, comp2);

		// set the results of the functions to the static variables to
		// be accessed later by displayResults()
		resSum = calc.addTwoNumbers();
		resDifference = calc.subTwoNumbers();
		resProduct = calc.mulTwoNumbers();

	}

	public static void displayResults(ComplexNumber comp1, ComplexNumber comp2) {

		// take the original complex numbers and display them alongside the
		// results that were set in calculateResults
		System.out.printf("(%.1f, %.1f) + (%.1f, %.1f) = (%.1f, %.1f)\n", comp1.real, comp1.imaginary, comp2.real, comp2.imaginary, resSum.real, resSum.imaginary);
		System.out.printf("(%.1f, %.1f) - (%.1f, %.1f) = (%.1f, %.1f)\n", comp1.real, comp1.imaginary, comp2.real, comp2.imaginary, resDifference.real, resDifference.imaginary);
		System.out.printf("(%.1f, %.1f) * (%.1f, %.1f) = (%.1f, %.1f)\n", comp1.real, comp1.imaginary, comp2.real, comp2.imaginary, resProduct.real, resProduct.imaginary);

	}

}

class Calculator {

	// the two complex numbers, set in the constructor method
	// these are instance variables as they change for each instance
	// of the class
	private ComplexNumber compNum1, compNum2;

	// constructor method to take the input for the method and store it in the instance
	public Calculator(ComplexNumber compNum1, ComplexNumber compNum2) {
		this.compNum1 = compNum1;
		this.compNum2 = compNum2;
	}

	// for each of the following three functions:
	// 1. calculates the real and imaginary parts of the result
	// 2. creates a ComplexNumber object with the real and imaginary variables
	// 3. returns the result as a ComplexNumber object
	public ComplexNumber addTwoNumbers() {

		double realPart = compNum1.real + compNum2.real;
		double imaginaryPart = compNum1.imaginary + compNum2.imaginary;

		ComplexNumber added = new ComplexNumber(realPart, imaginaryPart);

		return added;
	}

	public ComplexNumber subTwoNumbers() {

		double realPart = compNum1.real - compNum2.real;
		double imaginaryPart = compNum1.imaginary - compNum2.imaginary;

		ComplexNumber subtracted = new ComplexNumber(realPart, imaginaryPart);

		return subtracted;
	}

	public ComplexNumber mulTwoNumbers() {

		double realPart = (compNum1.real * compNum2.real) - (compNum1.imaginary * compNum2.imaginary);
		double imaginaryPart = (compNum1.real * compNum2.imaginary) + (compNum1.imaginary * compNum2.real);

		ComplexNumber multiplied = new ComplexNumber(realPart, imaginaryPart);

		return multiplied;
	}

}

class ComplexNumber {

	// initialises the real and imaginary portions of the complex number
	// as separate addressable variables
	public double real, imaginary;

	// constructor method to take the two double variables and store
	// them as the ComplexNumber
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

}
