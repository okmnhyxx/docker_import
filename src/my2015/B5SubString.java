package my2015;

public class B5SubString {
	
	private void subTest() {
		String str = "abcdefg\\abc";
		System.out.println(" --- abcdefg.subString(1): \t\t\t" + str.substring(1));
		System.out.println(" --- abcdefg.lastIndexOf(a): \t\t\t" + str.lastIndexOf("a"));
		System.out.println(" --- abcdefg.lastIndexOf(\\): \t\t\t" + str.lastIndexOf("\\"));
		System.out.println(" --- abcdefg.substring(1,10): \t\t\t" + str.substring(1, 10));
		System.out.println(" --- abcdefg.substring(str.lastIndexOf(\\)+1) \t"+ str.substring(str.lastIndexOf("\\") + 1));
	}

	public static void main(String[] args) {
		B5SubString b = new B5SubString();
		b.subTest();
	}
}
