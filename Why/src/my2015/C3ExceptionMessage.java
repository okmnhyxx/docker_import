package my2015;

import java.util.HashMap;
import java.util.Map;

public class C3ExceptionMessage {
	
	

	
	
	public static void main(String[] args) {

		C3ExceptionMessage c = new C3ExceptionMessage();
		try {
			c.doTestExcep();
		} catch (Exception e) {
			System.out.println(" main --- e.getMessage(): " + e.getMessage());
		}
		

	}

	private void doTestExcep() {
		
		try {
			int a = 1/0;
		} catch (Exception e) {
			System.out.println(" method --- e.getMessage(): " + e.getMessage());
			throw new RuntimeException("除数不能为零");
		}
		
	}




}
