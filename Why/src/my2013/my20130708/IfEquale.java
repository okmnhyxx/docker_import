package my2013.my20130708;
import java.util.Scanner;

public class IfEquale {//------------------------??�-128  ~  127????true   
	
	public void test(int before,int end) {
		Integer a,b;
		for (int i = before; i <= end; i++) {
			a=i;
			b=i;
			System.out.println(a + "==" + b + "? " + (a==b));
		}
	}
	
	
	public void test2() {
		Object o1 = new Object();
		Object o2 = new Object();
		o1 = o2;
		if(o1.equals(o2)) { 
			System.out.println("equals"); 
		}else{
			System.out.println("not equals");
		}
	}
	
	public static void main(String[] args) {
		IfEquale ie = new  IfEquale();
		
		int bef,end;
		Scanner in  = new Scanner(System.in);
		
		System.out.println("please input before:");
		bef = in.nextInt();
		System.out.println("please input end:");
		end = in.nextInt();
		ie.test(bef,end);
		
		ie.test2();
	}
}


/*static final Integer cache[] = new Integer[-(-128) + 127 + 1];

static {
    for(int i = 0; i < cache.length; i++)
	cache[i] = new Integer(i - 128);
}
*/
//??object??????   equale ?? ==??????
/*	    public boolean equals(Object obj) {
		return (this == obj);
}*/