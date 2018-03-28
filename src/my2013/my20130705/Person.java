package my2013.my20130705;

public class Person {
	{
		System.out.println("==== super common segment head ====");
    }
	static {
		System.out.println("==== super static segment head ====");
	}
	private String name = "superName0";
	private static String sex = "superSex0";
	public static void persionFunc() {
        System.out.println("==== super static function ====");
    }
	{
//        System.out.println("==== super common block begin:" + name + " " + remark);
        System.out.println("==== super common block begin:" + name);
        name = "superName1";remark = "superRemark1";
        System.out.println("==== super common block end:" + name);
	}
	static {
//        System.out.println("==== super static block begin: ==== " + sex + " " + spring);
        System.out.println("==== super static block begin: " + sex);
        sex = "superSex1";spring = "superString1";
        System.out.println("==== super static block end: " + sex);
	}
    public String remark = "superRemark0";
    public static String spring = "superSpring0";

	public Person(String name, String sex, String age) {
        System.out.println("==== super construct begin: " + this.name + " " + Person.sex + " " + this.age + " " + this.age_ + " " + this.age__
                + " " + this.remark + " " + Person.spring + " ");
        this.name = name;Person.sex = sex;this.age = age;
        System.out.println("==== super construct end: " + this.name + " " + Person.sex + " " + this.age + " " + this.age_ + " " + this.age__);
	}

    public String age = "superAge0";
    public String age_;
    public String age__ = "superAge__0";
	{
		System.out.println("==== super common segment tail ====");
	}
	public static void main(String[] args) {
		Person p = null;//it will tells : common codes blocks wouldn't be called until the class be instantiated
		new Person("mySuperName", "mySuperSex", "mySuperAge");
	}
}
