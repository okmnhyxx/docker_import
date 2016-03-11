package my2013.my20130709;

public class staticTest {
	
	public static String name;
	
	public void student(String name){
		
		System.out.println(name);
	}
	public static void main(String[] args) {
		new staticTest().student("Miaomiao");//局部变量
		System.out.println(staticTest.name);//全局变量
	}
//静态属性也将被子类继承。
//访问静态属性，最好直接直接使用类名，但使用this也是可以的，只是不推荐，容易在阅读代码过程中产生混淆。

}