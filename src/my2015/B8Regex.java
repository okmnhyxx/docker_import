package my2015;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B8Regex {
	
	public static void main(String[] args) {
		B8Regex b = new B8Regex();
		String target = "yunni.lu@tpv-tech.com";
//		String target = "okmnhyxx@sina.com";
		b.doRegex(target);
			
	}

	private void doRegex(String target) {
//		String regex = "^(\\w+((-\\w+)|(\\.\\w+))*)\\+\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		boolean isMail = matcher.matches();
		System.out.println(isMail);
	}

}
