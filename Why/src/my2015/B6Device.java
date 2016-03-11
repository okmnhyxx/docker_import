package my2015;

public class B6Device {
	
	
	private void doTest() {
		int a = 10;
		int b = 2;
		int c = 3;
		int ab = a/b;
		int ac = a/c;
		System.out.println("a/b: " + ab);
		System.out.println("a/c: " + ac);
	}
	
	private void testEqual() {
		int a = 3;
		double b = 3.0;
		double c = 3.3;
		int d = (int)c;
		if(a == b) {
			System.out.println("3 == 3.0");
		} else {
			System.out.println("3 != 3.0");
		}
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		B6Device b = new B6Device();
//		b.doTest();
		b.testEqual();
	}

}
