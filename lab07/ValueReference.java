class ValueRefence {

	public static void main(String[] args) {
		method1();
		method3();
	}
	
	public static void method1() {
		int ap = 5;
		System.out.println("method1 before method2(), ap="+ap);
		method2(ap);
		System.out.println("method1 after method2(), ap="+ap);
	}
	public static void method2(int fp) {
		System.out.println("method2 before calc, fp="+fp);
		fp *= 2;
		System.out.println("method2 after calc, fp="+fp);
	}

	public static void method3() {
		Acl ap = new Acl();
		ap.a = 5;

		System.out.println("method3 before method4(), ap.a="+ap.a);
		method4(ap);
		System.out.println("method3 after method4(), ap.a="+ap.a);
	}

	public static void method4(Acl fp) {
		System.out.println("method4 before calc, fp.a="+fp.a);
		fp.a *= 2;
		System.out.println("method4 after calc, fp.a="+fp.a);
	}
}

class Acl {
	public int a=0;
}
