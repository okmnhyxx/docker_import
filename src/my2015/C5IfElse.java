package my2015;

public class C5IfElse {
	
	private void testIf() {
		int a = 10;
		
		if(a > 3) {
			System.out.println(" a > 3: " + a);
		} else if (a > 5) {
			System.out.println(" a > 10: " + a);
		}
	}
	
	
	
	public static void main(String[] args) {
		C5IfElse c = new C5IfElse();
		c.testIf();
	}

}
