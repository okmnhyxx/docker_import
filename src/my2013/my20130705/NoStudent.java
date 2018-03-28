package my2013.my20130705;

public class NoStudent extends Person {
	{
		System.out.println("---- sub common segment head ---- " + super.remark);
	}
	static {
//			System.out.println("---- sub static segment head ----" + super.spring);
		System.out.println("---- sub static segment head ----");
	}
	private String name = "subName0";
	private static String sex = "subSex0";
	public static void studentFunc() {
		System.out.println("---- sub static function ----");
	}
	{
//			System.out.println("---- sub common block begin:" + name + " " + remark);
		System.out.println("---- sub common block begin:" + name);
		name = "subName1";remark = "subRemark1";
		System.out.println("---- sub common block end:" + name);
	}
	static {
//			System.out.println("---- sub static block begin: ---- " + sex + " " + spring);
		System.out.println("---- sub static block begin: ---- " + sex);
		sex = "subSex1";spring = "subString1";
		System.out.println("---- sub static block end: ---- " + sex);
	}
	public String remark = "subRemark0";
	public static String spring = "subSpring0";

	public NoStudent(String name, String sex, String age) {
		super(name, sex, age);
		System.out.println("---- sub construct begin: " + this.name + " " + NoStudent.sex + " " + this.age + " " + this.age_ + " " + this.age__
				+ " " + this.remark + " " + NoStudent.spring + " ");
		this.name = name;NoStudent.sex = sex;this.age = age;
		System.out.println("---- sub construct end: " + this.name + " " + NoStudent.sex + " " + this.age + " " + this.age_ + " " + this.age__);
	}

	public String age = "subAge0";
	public String age_;
	{
		System.out.println("---- sub common segment tail ----");
	}
	public static void main(String[] args) {
		new NoStudent("mySubName", "mySubSex", "mySubAge");
	}
}

