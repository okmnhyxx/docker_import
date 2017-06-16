package my2013.my20130705;

public class Person {
	
	// the properties age and description will err as :Cannot reference a field before it is defined
	/*
	{
		System.out.println("super class common code segment, age before: " + age);
		System.out.println("super class common code segment,description before: " + description);
	}*/
	
	private static String name = "aaa";
	private int age = 10;
	private String description = "description:super class Person";
	
	{
		System.out.println("super class common code segment, age before: " + age);
		System.out.println("super class common code segment,description before: " + description);
	}
	
	static {
		System.out.println("super static ----" + name);
		name = "name:super class static code segment";
		System.out.println(name);
	}

	private static int bbb = 20;

	public Person(int age, String description) {
		System.out.println("super main class age: " + age);
		this.age = age;
		this.description = description;
		System.out.println("super construct class age after: " + this.age);
		System.out.println("super construct class description after: " + this.description);
	}

	public static void main(String[] args) {
		
		Person p = null;//it will tells : common codes blocks wouldn't be called until the class be instantiated
		new Person(20, "test");
	}
}
