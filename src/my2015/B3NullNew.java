package my2015;

public class B3NullNew {
	
	private void doTest(){
		StringBuffer sb = new StringBuffer();
		if(null == sb.toString()) {
			System.out.println("new不赋值，toString仍为null");
		} else {
			System.out.println("new不赋值，toString却不为null，其值为：" + sb.toString());
		}
		if("".equals(sb.toString())) {
			System.out.println("new不赋值，toString值为\"\"");
		} else {
			System.out.println("new不赋值，toString却不为\"\"，其值为：" + sb.toString());
		}
		if("".equals(sb)) {
			System.out.println("new不赋值，sb值为\"\"");
		} else {
			System.out.println("new不赋值，sb却不为\"\"，其值为：" + sb);
		}
	}
	
	private void nullTrim () {
		String str1 = null;
//		String str2 = str1.trim();
		String str2 = "";
		System.out.println("str2:" + str2);
		System.out.println(str1.trim().equals(str2));
	}

	public static void main(String[] args) {
		B3NullNew b = new B3NullNew();
//		b.doTest();
		b.nullTrim();
	}
}
