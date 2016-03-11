package my2013.my20130705;

class B3 {     
	private int aa = 1;
	public B3() {                 
		System.out.println("1:\t"+ this.aa); 
		System.out.println("qqqqqqq");
	}         
	
	public B3(int aa){
		System.out.println("===="+aa);
	}
}
public class A3 extends B3 {             
	
	private int aa = 100;             
	
	public A3(int aa) {                 
		super();  		//------------------------------------------super()ִ�У�    
	
		System.out.println("2:\t"+aa);                
		System.out.println("ssssssss");                
		this.aa = 200;             
	}           

	public static void main(String[] args) {                 
		System.out.println("3:\t"+new A3(111).aa);     
		
		System.out.println("sdf".charAt(1));
	}         
}