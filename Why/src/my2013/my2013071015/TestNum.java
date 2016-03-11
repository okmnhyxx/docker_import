package my2013.my2013071015;

public class TestNum {
	
	void howManyParam(int...m){
		int sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum = sum + m[i];
		}
		System.out.println("sum:" + sum);
	}
	public static void main(String[] args) {
		new TestNum().howManyParam(10,4,6,8,1);
	}
}
