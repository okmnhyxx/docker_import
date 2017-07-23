 package my2013.my20130705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DemoStr {

	
	public void strTest1(){
		String s="asdklasdfalasjdfjlffs";
		String[] arr = s.split("l");
		
	    for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * 
	 */
	public void strTest2() {
		String mat = "^[a-z]{3}-\\d{3,}$";//
//		String mat = "^a*b";
		String s = null;
		Pattern pt = Pattern.compile(mat);
		System.out.println("please input three char, and more num");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while ((s = br.readLine())!=null) {
				Matcher mt = pt.matcher(s);
				boolean b = Pattern.matches(mat, s);
				
				System.out.println("information:\n\t" + mt);
				System.out.println("if match?:\n\t" + b);
 			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void strTest3() throws IOException {
		String s;
		String tmp = null;
		String c;
		int contn = 1;
		int bk = 0;
		
		while (contn == 1){
			Scanner sc = new Scanner(System.in);
			System.out.println("please input the original string");
			s = sc.nextLine();
			System.out.println("please input the sub string");
			c = sc.nextLine();
		
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < c.length() - 1; j++) {
					if(s.charAt(i) != c.charAt(j)) {
						bk = 1;
						break; 
					}
					bk =0;
					System.out.println("bk:" +bk);
					continue;
				}
				System.out.println("<<<<<<<<<" + i);
				if(bk == 1) continue;
				if((s.charAt(i +c.length() -1)) ==c.charAt(c.length() -1)){
					System.out.println("--------" + i);
					System.out.println("s:" +s);
					tmp = s.substring(0,i).concat(s.substring(i +c.length()));
					s = tmp;
				}
			}	

			System.out.println("=====" + s);
			System.out.print("\nif continue?(0:no 1:yes)\n\t");
			contn = sc.nextInt();
//			contn = System.in.read();
		}

	}
	
	
	public void strTest4(){
		
		
		String a="xyz";
		String b="xyz";
		System.out.println(a==b);
		System.out.println("2 \t" + a==b);//because of the precedence of operator
		System.out.println("3 \t" + (a==b));
		System.out.println("4 \t" + a.equals(b));
		
		System.out.println("\n================================================\n");
		
		String s=new String("abc");
		String m=new String("abc");
		System.out.println(s==m);
		System.out.println("2 \t" + s==m);//because of the precedence of operator
		System.out.println("3 \t" + (s==m));
		System.out.println("4 \t" + s.equals(m));

	}
	
	public void strTest5(){//stringBuffer
		
		//StringBuffer to String
		StringBuffer sb = new StringBuffer();
		sb.append("one");
		sb.append("two");
		String str = sb.toString();
		System.out.println("  StringBuffer to String test:\t" +str);
		
		
		//String to StringBuffer
		String app = "apple";
		String ban = "banane";
		StringBuffer sbf =  new StringBuffer();
		sbf.append(app).append(ban);
		System.out.println("  String to StringBuffer test:\t" + sbf);
		
	}
	
	public void strTest6(){
		String dou = "0";
		String doub = null;
		System.out.println("\tstring:"+dou);
		System.out.println("\tstring:"+doub);
		System.out.println(Double.parseDouble(dou));
//		System.out.println(Double.parseDouble(doub));
	}
	
	public static void main(String[] args) throws IOException {
		DemoStr d = new DemoStr();
//		d.strTest1();
//		d.strTest2();
//		d.strTest3();
		d.strTest4();
//		d.strTest5();
//		d.strTest6();
	}

}
