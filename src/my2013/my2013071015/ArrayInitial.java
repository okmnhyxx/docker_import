package my2013.my2013071015;

public class ArrayInitial {
	
	int []a;//guess which will bring out an err in runtime,then just run and see 
	int b[];
	int c[] = {1,2,3,4};
	int d[] = new int[5];
	int e[] = new int[]{1,2,3,4};
	public void test1(){
		
		System.out.println("\n=====a:");
//		for (int i = 0; i < 5; i++) {
//			System.out.print("\t" + a[i]);
//		}
		System.out.println("\n=====b:");
//		for (int i = 0; i < 5; i++) {
//			System.out.print("\t" + b[i]);
//		}
		System.out.println("\n=====c:");
		for (int i = 0; i < 4; i++) {
			System.out.print("\t" + c[i]);			
		}
		System.out.println("\n=====d:");
		for (int i = 0; i < 5; i++) {
			System.out.print("\t" + d[i]);			
		}
		System.out.println("\n=====e:");
		for (int i: e) {
			System.out.print("\t" + i);			
		}
	}
	
	public static void main(String args[]) {
		ArrayInitial ai = new ArrayInitial();
		ai.test1();
	}

}
