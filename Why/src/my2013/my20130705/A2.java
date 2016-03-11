package my2013.my20130705;

class B2 {                      
	public B2() {                 
		System.out.println("1:\t"+((A2) this).aa); 
		System.out.println("qqqqqqq");
	}         
	
	public B2(int aa){
		System.out.println("===="+aa);
	}
}
public class A2 extends B2 {             
	
	protected int aa = 100;             
	
	public A2(int aa) {                 
		super(aa);  		//------------------------------------------super()ִ�У�    
	
		System.out.println("2:\t"+aa);                
		System.out.println("ssssssss");                
		aa = 200;             
	}           

	public static void main(String[] args) {                 
		System.out.println("3:\t"+new A2(111).aa);     
		
		System.out.println("sdf".charAt(1));
	}         
}