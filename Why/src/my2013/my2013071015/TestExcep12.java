package my2013.my2013071015;

class A1 {
	public void process() { 
		System.out.println("A"); 
	} 
}
class B1 extends A1 {//NullPointerException也是RuntimeException, 所以此处不认为子类重写方法抛出了比父类对应方法更多的异常。
	public void process() throws NullPointerException {
		super.process();
		if (true) throw new NullPointerException ();
		System.out.println("B"); 
	}//子类不能抛出比父类更多的异常，子类访问修饰权限不能比父类严格
}



class TestException2 extends Exception {

	private static final long serialVersionUID = 1L;
	TestException2(){
		System.out.println("null name err");
	}
}

class A2 {
	public String sayHello(String name) throws TestException2 {//……………………检查异常TestException要么显式抛出或者捕获处理。在main中也是這樣

		if(name == null) {
			throw new TestException2();
		}
		return "Hello " + name;
	}
 }




public class TestExcep12
{
	public  void method1(int x) throws Exception//……………………what will be printed out
	{
		try
		{
			method2(x); 
			System.out.println("Checkpoint 1");
		}
		catch (Exception e) {
			System.out.println("catch^^");
		}
		finally{
			System.out.println("Checkpoint 2");
		}
		System.out.println("Checkpoint 3");
	}
	public void method2(int x) throws Exception
	{
		if (x < 0)
		{
			throw new NegativeArraySizeException();
		}
	}
	
	
	static public void main(String[] args) throws Exception
	{
		TestExcep12 t = new TestExcep12();
		t.method1(-55);
		System.out.println("Checkpoint 4");
	
		

		try { 
			((A1)new B1()).process(); //……………………………………………………………………………………………………调用 A or B 的process
		}catch (Exception e) { 
			System.out.println("Exception "); 
		}
		A2 a=new A2();
		System.out.println(a.sayHello("John"));
	}
}


