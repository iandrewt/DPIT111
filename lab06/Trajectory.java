class Trajectory {

	private final double G = 9.8;

	public double calculateMaxHeight(double initialVelocity) {
		double hMax = Math.pow(initialVelocity, 2) / (2 * G);
		return hMax;
	}
}
