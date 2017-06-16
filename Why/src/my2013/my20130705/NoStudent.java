package my2013.my20130705;

	public class NoStudent extends Person {
		private static String name = "bbb";
		private int age = 20;
		private String description = "description:sub class User";
		
		{
			System.out.println("sub class common code segment, age before:" + this.age);
			System.out.println("sub class common code segment ,description before:" + this.description);
		}
		static {
			System.out.println("sub static ----" + name);
			name = "name:sub class static code segment";
			System.out.println(name);
		}

		private static int aaa = 10;
	
		public NoStudent(int age, String description) {
			super(age, description);
			this.age = age;
			this.description = description;
			System.out.println("sub construct class age after:" + this.age);
			System.out.println("sub construct class description after:" + this.description);
		}
	
		public static void main(String[] args) {
			new NoStudent(30, "subTest");
		}
	}

