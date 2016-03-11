package my2013.my2013071015;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListDemo14 {
	
	public List input(){
		
		List l = new ArrayList(6);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("please input two char inside a to z spilt by a space:\t");
		String []az = sc.nextLine().split(" ");
		l.add((char)az[0].charAt(0));//******* it's no matter whrther or not (char)
		l.add(az[1].charAt(0));      //******* it's no matter whrther or not (char)
		System.out.print("please input two num inside 1 to 9 spilt by a space:\t");
		String []lq = sc.nextLine().split(" ");
		l.add(lq[0].charAt(0));//can not write (int)
		l.add(lq[1].charAt(0));
		System.out.print("please input a num to deside the single length of a list of radom string:\t");
		l.add(sc.nextInt());
		System.out.print("please input a num to deside the allsum number of a list of radom string:\t");
		l.add(sc.nextInt());
		
		return l;
	}
	
	public List gotData(List list1){
		List list2 = new ArrayList();
//		char start = ((String)list1.get(0)).charAt(0); //get a char the frist inputed   //………………………………cause err when running  can't transfer char to string
		char start = (String.valueOf(list1.get(0))).charAt(0); //get a char the frist inputed  //******* it's no matter whrther or not (char)
//		char end = ((String)list1.get(1)).charAt(0);   //get a char the second inputed  //………………………………cause err when running
		char end = (String.valueOf(list1.get(1))).charAt(0); //get a char the frist inputed    //******* it's no matter whrther or not (char)
		if( start > end ){
			char tmp = start;
			start = end;
			end  = tmp;
		}
		for (int i = start; i <= end ; i++) {
			list2.add((char)i);
			System.out.println("a……z："+ i);
		}
		
//		int head = ((String)list1.get(0)).charAt(0); //………………………………cause err when running
		int head = (String.valueOf(list1.get(2))).charAt(0);
//		int tail = ((String)list1.get(1)).charAt(0); //………………………………cause err when running
		int tail = (String.valueOf(list1.get(3))).charAt(0);
		System.out.println("head:" + (char)head);
		System.out.println("tail:" + (char)tail);
		if(head > tail){
			int temp = head;
			head = tail;
			tail = temp;
		}
		for (int i = head; i <= tail; i++) {
			list2.add((char)i);//…………………………………………………………………………………………………………of great importances  change to (int) and you can see every num changes to 5,for the reason  see next line 
			System.out.println("1……9："+ i);
		}
		return list2;
	}
	
	public void generateRandom(List listOrig,List listData){
		
		Random rd = new Random();
		System.out.println("==============listOrig.get(4):  " + listOrig.get(4));
		System.out.println("==============String.valueOf(listOrig.get(4)):  " + String.valueOf(listOrig.get(4)));
		
//		int len = (int)((String)listOrig.get(5)).charAt(0); //………………………………cause err when running
//		int len = (String.valueOf(listOrig.get(4))).charAt(0);//………………………………it will transfer to the num' ASCII
		int len = Integer.parseInt(String.valueOf(listOrig.get(4)));
//		int num = (int)((String)listOrig.get(5)).charAt(0); //………………………………cause err when running
//		int num = (String.valueOf(listOrig.get(5))).charAt(0);//………………………………it will transfer to the num' ASCII  and got the frist cha of the ASCII
		int num = Integer.parseInt(String.valueOf(listOrig.get(5)));
		
		List<String> listStr = new ArrayList<String>(num);
		char[] arr = new char[len];
		
		StringBuffer sb = new StringBuffer();
		System.out.println("sb.append\\(\"sds\"\\):"+ sb.toString());  //………………………………………………………………escape
		for (int i = 0; i < num; i++) {
			sb.delete(0, sb.length());//to clear up sb :you can use length,in spidt of the index of it only to length - 1
//			sb = sb.replace(0, sb.length(), "");
//			sb.setLength(0);
			for (int j = 0; j < len; j++) {
				arr[j] = ( String.valueOf(listData.get(rd.nextInt(listData.size()))) ).charAt(0);
			}
//			String ss = sb.append(arr).toString();//the same of the follows
			String ss = sb.append(String.valueOf(arr)).toString();//the same of the above one 
			
			listStr.add(ss);
			
//			listStr.add(new String(arr));//char arrays to string   of greant importance
		}
		
		Iterator<String> itr = listStr.iterator();
		int i = 0;
		while (itr.hasNext()) {
			System.out.print("\t\t" + itr.next());
			if(i%6==5)
				System.out.println();
			i++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayListDemo14 hs = new ArrayListDemo14();
		List listOrig = hs.input();
		List listData = hs.gotData(listOrig);
		hs.generateRandom(listOrig, listData);
	}
}
