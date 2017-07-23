package my2013.my20130709;

public class AnimalOverStatus {
	protected String name;
	public AnimalOverStatus(String name) {
		this.name = name;
		System.out.println(name + ": is father one parameter constructor");
	}

	public static void letAnimalSound(AnimalOverStatus aos) {// 多态的体现
		System.out.println("\t" + aos.name + " can sound");
	}
	public static void main(String[] args) {
		AnimalOverStatus.letAnimalSound(new Tiger());
		AnimalOverStatus.letAnimalSound(new Mouse("mouseName"));
		AnimalOverStatus.letAnimalSound(new Sheep("sheepName",3));
	}
}

class Tiger extends AnimalOverStatus {
	public static String name = "tigerName";
	public String name2 = "tigerName2";
	public Tiger(){
		super(name);//如果是super(name2),则报错，因为先初始化父类的成员变量 构造函数 再初始化子类的成员变量 构造函数，
		System.out.println(name + ": is tiger zero parameter constructor");
	}
}
class Mouse extends AnimalOverStatus {
	public Mouse(String name) {
		super(name);
		System.out.println(name + ": is mouse one parameter constructor");
	}
}
class Sheep extends AnimalOverStatus {
	public Sheep(String name,int age) {
		super(name);
		System.out.println(name + ": is sheep two parameter constructor");
	}
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



