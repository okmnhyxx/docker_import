package my2013.my2013071015;

abstract class Base{
	abstract public void myfunc();
	public void another(){
		System.out.println("Another method");
	}
}
public class Abs extends Base{
	public static void main(String argv[]){
		Base b= new Abs(); //A
		b. myfunc(); //B
	}
	public void myfunc(){
		System.out.println("My Func");
	}
}

