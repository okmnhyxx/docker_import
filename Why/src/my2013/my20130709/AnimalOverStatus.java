package my2013.my20130709;

public class AnimalOverStatus {

	protected String name;
	public AnimalOverStatus(String name) {
		this.name = name;
		System.out.println(name + ": is father one parameter constrator");
	}
/*	a.	多态三要素
	1）	在继承环境下，子类重写父类方法。
	2）	通过父类引用变量指向子类对象。
	3）	恰好通过父类引用变量调用的是被重写的方法。
	       
	       在此情况下，将发生多态效应，从常态来说，
	       通过父类引用变量指向子类对象，该引用变量只能看到子类对象中的父类部分，不可能调用到子类方法。
	       但是由于这里存在重写，通过父类引用变量向子类对象发送信号的时候，该方法调用信号由于和子类重写方法签名是完全一致，结果调用子类的该重写方法，
	       对于方法的主调者来说，其并不知道会产生这个结果，纯属意外。
*/
	public static void letAnimalSound(AnimalOverStatus aos) {// 多态的体现
		System.out.println("\t" + aos.name + " can sound");
	}
	public static void main(String[] args) {
		AnimalOverStatus.letAnimalSound(new Tiger());
		AnimalOverStatus.letAnimalSound(new Mouse("qiuqiu"));
		AnimalOverStatus.letAnimalSound(new Sheep("yangy",3));
	}
}

class Tiger extends AnimalOverStatus {
	
//	public String name;
//	public Tiger(){
//		super(name);//这样会报错 ，因为super这类特殊指针是要先于构造函数而构造的（原来的顺序：先初始化属性后构造函数），所以会报错 name没有初始化，所以name要改成静态的才可以
//	}
	public static String name = "gudingtiger";
	public Tiger(){
		super(name);
		System.out.println(name + ": is tiger zero parameter constrator");
	}
}

class Mouse extends AnimalOverStatus {

	public Mouse(String name) {
		super(name);
		System.out.println(name + ": is mouse one parameter constrstor");
	}
}

class Sheep extends AnimalOverStatus {
	
//	public int age;
	public Sheep(String name,int age) {
		super(name);
		System.out.println(name + ": is sheep two parameter constrator");
	}
}



