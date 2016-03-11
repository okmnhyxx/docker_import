package my201407;

import java.io.ObjectInputStream.GetField;

public class TestTransplant {
	
	public int getResult(int a){
		a = 10;
		return a;
	}
	public static void main(String[] args) {
		
		TestTransplant tt = new TestTransplant();
		int a = 3;
		System.out.println("before:--------- " + a);
		
		a = tt.getResult(a);
		
		System.out.println("after:--------- " + a);
	}

}
