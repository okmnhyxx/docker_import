package my2013.my20130709;

class Animal {

	String name;
	Double weight;
	// 任何一个类都将拥有构造方法，如果一个类没有构造方法，则编译器将自动帮其书写一个构造方法，这个构造方法的特征是无参空实现。
	// 如果一个类已经有了一个构造方法了，无论该构造方法是什么情况，编译器也不会再为其自动添加构造方法。

	Animal() {
		System.out.println("----------------------wucangouzao");
	}
	Animal(String name, Double weight) {
		this.name = name;
		this.weight = weight;
		System.out.println("----------------------youcangouzaoxiao");
	}
	public Animal(String name, Double weight, String furColor) {
		System.out.println("----------------------youcangouzaoda");
	}

	void run() {
		System.out.println(this.name + ":我在奔跑!");
	}
	void sound() {
		System.out.println(this.name + ":我在吼叫!");
	}
}


public class TigerConstractor extends Animal{
	
	String fury;
	
	TigerConstractor(){
		System.out.println("======================wucangouzao");
	}
	TigerConstractor(String name, Double weight){//注意   加不加super  各调什么?
//		super(name,weight);
		this.name = name;
		this.weight = weight;
		System.out.println("======================youcangouzaoxiao");
	}
	TigerConstractor(String name, String weight, String fury){
		System.out.println("======================youcangouzaoda");
	}
	
	public static void main(String[] args) {
		new TigerConstractor("Mimi",12.3).run();
	}
}


/*继承环境下的对象构造

子类对象的构造，除了完成自身部分的构造之外，还必须完成父类部分的构造。

子类构造过程，如果没有完成体内父类部分构造，则构造未完成，编译失败。

子类在构造中，必须承担体内父类部分的构造任务，而这个任务是由子类调用父类构造方法来实现的，有的时候，子类调错了父类构造方法，导致构造失败。

子类在构造过程中，必须“先父亲后自己”的原则完成构造。

如果子类构造方法，没有显式指出调用哪个父类构造方法，编译器将自动在子类构造方法的首行写上super(), 调用父类的无参构造方法完成子类内部父类部分的构造工作


//this虽然运行到，但其实还没有构造这个类
//
//this和super是特殊的语句，会先执行, 但这个类还没有 构造出来
//
//所以 必须放在第一句


父类不止一个构造函数怎么办？

默认只调一个就可以（除非super两次）

如果有明显的指出调哪个，则调用该指明的*/

