package my2013.my2013071015;


/**
 * type 方法测试指向问题
 *
 */
class Father {

	public Boolean type(){
		return true;
	}
}

public class Son11 extends Father{
	//……………………重写返回值类型也无需完全一致，只要符合逻辑即可，子类返回值类型可以是父类返回值类型的子类，符合is判断法即可。但是,见下:

	public Boolean type(){
		return false;
	}

	public static void main(String[] args) {


		Father father = new Father();
		Son11 son = new Son11();
		Father fs = new Son11();

		//…………………………………………………………………………………………………………………………(Father)new C7Son()   ==   Father jubing = new C7Son();
		Boolean b1 = ((Father)new Son11()).type();/*………………从这里可以知道： */
		/*……………………… …………………………………………………………………………………………………该匿名句柄 是father类的，返回结果按father类的，但指向Son，返回结果实际是son的*/
		Boolean b2 = ((Father)son).type();//
//		Boolean b3 = ((Son11)father).type();//ClassCastException
		Boolean b4 = fs.type();

		System.out.println(" b1: " + b1);
		System.out.println(" b2: " + b2);
//		System.out.println(" b3: " + b3);
		System.out.println(" b4: " + b4);


	}
}
