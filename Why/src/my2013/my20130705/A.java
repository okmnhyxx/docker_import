package my2013.my20130705;

class B {                      
	public B() {                 
		System.out.println("1:\t"+((A) this).a); 
		System.out.println("qqqqqqq");
	}         
	public B(int aa){
		System.out.println("===="+aa);
	}
}
public class A extends B {             
	protected int a = 100;             
	
	public A(int aa) {                 
		super(aa);  		//------------------------------------------super()ִ�У�    
	
		System.out.println("2:\t"+a);                
		System.out.println("ssssssss");                
		a = 200;             
	}                      
	public static void main(String[] args) {                 
		System.out.println("3:\t"+new A(111).a);     
		
		System.out.println("sdf".charAt(1));
	}         
}

