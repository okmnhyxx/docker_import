package my2013.my2013071015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo {
	
	public String [] input1() {
		System.out.println("please input a list of strings …… split by space");
		Scanner sc  = new Scanner(System.in);
		return sc.nextLine().split(" ");
	}
	
	public String input2() {
		System.out.println("please input a list of strings …… split by space");
		Scanner sc  = new Scanner(System.in);
		@SuppressWarnings("unused")//………………………………………………………………………………@SuppressWarnings
		String str = sc.nextLine();//sc.read return a int type ,it return you character 's ASCII;
		return str;
	}
	
	public int input3() {//the num define the num that from zero to num
		int i = 0;
		System.out.println("please input a num :");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			i = Integer.valueOf(bf.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public void traverse1(String...str){
		System.out.println("1:集合类型遍历法：");
		int i = 0;
		
		List<String> al = new ArrayList<String>(str.length);//写上长度…………………………？
		for (String string : str) {
			al.add(string);
			System.out.print("\t" + string);
			if(i%10==9)
				System.out.println();
			i++;
		}
		
		System.out.println("\n  al:(contains null)\t" + al);
		
//		List<String> al = Arrays.asList(str);
//		for (String string : al) {
//			System.out.print("\t" + string);
//			if(i%10==9)
//				System.out.println();
//			i++;
//		}
		
		System.out.println("\n  remove empty element  the result:");
		boolean flag = true;
		while(flag)
			flag = al.remove("");
		for (String string2 : al) {
			System.out.print("\t" + string2);
			if(i%10==9)
				System.out.println();
			i++;
		}
		System.out.println("\n  al:( no contains null)\t" + al);
	}

	
	public void traverse2(String str){
		System.out.println("2：常规方式遍历法：");
		
		String [] arr =str.split(" ");
		List<String> al = new ArrayList<String>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			al.add(arr[i]);
			System.out.print("\t" + al.get(i));
			if(i%10==9)
				System.out.println();
		}
		
		System.out.println("\n  al(contains null):\t" + al);
		
//		List<String> al = Arrays.asList(str.split(" "));
//		for (int i = 0; i < al.size(); i++) {
//			System.out.println(al.get(i));
//			if(i%10==9)
//				System.out.println();
//		}
		
		System.out.println("\n  remove empty element  the result:");
		int i = 0;
		for (int j = 0; j < al.size(); j++) {
			System.out.print("\n======size:" + al.size() + "\n");//as empty elements has been remove ,the size of al will change………………
			if(al.get(j).isEmpty())
				al.remove(j);
		}
		for (String string2 : al) {
			System.out.print("\t" + string2);
			if(i%10==9)
				System.out.println();
			i++;
		}
		System.out.println("\n  al(no contains null):\t" + al);
	}
	
	
	public List<String> traverse3(String str){
		int i = 0;//…………………………………………………………local variable should be initialized while be defining
		System.out.println("3:迭代iterat遍历法：");
		Iterator<String> itr =  Arrays.asList(str.split(" ")).iterator();
		while(itr.hasNext()){
			System.out.print("\t" + itr.next());
			if(i%10==9)
				System.out.println();
			i++;
		}
		
		System.out.println("\n  remove empty element  the result:");
		itr =  Arrays.asList(str.split(" ")).iterator();//you must assign to itr again becase you use "while(itr.hasNext())" right now
		while(itr.hasNext()){
//			System.out.println("======");
			String itrNt = itr.next();//every time itr.next, it really will get the next element again, so this element should assign to other variable 
			if(itrNt.isEmpty()) continue;
			System.out.print("\t" + itrNt);
			if(i%10==9)
				System.out.println();
			i++;
		}
		return Arrays.asList(str.split(" "));
	}
	
	
	
	
	public void l2a1(int num){
		List<Integer> ilist = new ArrayList<Integer>();
		Integer [] arr = null;
		for (int i = 0; i < num; i++) {
			ilist.add(i);
		}
		arr = (Integer [])ilist.toArray();//own to have no param  construct a object[]  so when running cause a classCastException
		for (int i = 0; i < arr.length; i++) {
			System.out.println("\t" + arr[i]);
			if(i%10==9)
				System.out.println();
		}
	}
	
	public void l2a2(int num){
		List<Integer> ilist = new ArrayList<Integer>();
		Integer [] arr = null;
		for (int i = 0; i < num; i++) {
			ilist.add(i);
		}
		System.out.println(" --num:" + num);
		System.out.println(" --ilist.size():" +ilist.size());
		arr = ilist.toArray(new Integer[ilist.size()]);//toArray(T[] t) :relay on the type of the parameter ,bulit a relavate type's
		
		System.out.println("arr:\t" + arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print("\t" + arr[i]);
			if(i%10==9)
				System.out.println();
		}
		
		if(ilist.contains(100))
			System.out.println("\n ~\\(≧▽≦)/~ it contains 100 ~\\(≧▽≦)/~");//it contains escape character \
		else System.out.println("\n ~~~~(>_<)~~~~ don't contains 100 ~~~~(>_<)~~~~ ");
	}
	
	
	
	
	public void sorted(){
		
		System.out.println("now sorted the list ……………………………………");
		
		List<String> slist = Arrays.asList(input1());
		Collections.sort(slist);
		System.out.println("slist:\t" + slist);
		
		int i = 0;
		for (String string : slist) {
			System.out.print("\t" + string);
			if(i%10==9)
				System.out.println();
			i++;
		}
	}
	
	public static void main(String[] args) {
		ArrayListDemo alt = new ArrayListDemo();
		alt.traverse1(alt.input1());
		System.out.println("\n---------------------------------------------------------------------------------");
		alt.traverse2(alt.input2());
		System.out.println("\n---------------------------------------------------------------------------------");
		alt.traverse3(alt.input2());
		System.out.println("\n---------------------------------------------------------------------------------");
//		alt.l2a1(alt.input3());//when runing   cast an err
//		System.out.println("\n---------------------------------------------------------------------------------");
		alt.l2a2(alt.input3());
		System.out.println("\n---------------------------------------------------------------------------------");
		alt.sorted();
		
	}

}

/*linkedList 底层双向链表实现，增删效率高，查询效率低
 * arrayList 底层数组实现    ，增删效率低，查询效率高，轻量级，线程不安全*/

/*ArrayList和LinkedList在性能上各 有优缺点，都有各自所适用的地方，总的说来可以描述如下：　　
1．对ArrayList和LinkedList而言，在列表末尾增加一个元素所花的开销都是固定的。
   对 ArrayList而言，主要是在内部数组中增加一项，指向所添加的元素，偶尔可能会导致对数组重新进行分配；
   而对LinkedList而言，这个开销是统一的，分配一个内部Entry对象。　　
2．在ArrayList的 中间插入或删除一个元素意味着这个列表中剩余的元素都会被移动；
   而在LinkedList的中间插入或删除一个元素的开销是固定的。　　
3．LinkedList不 支持高效的随机元素访问。　　
4．ArrayList的空 间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间　　
  可以这样说：
  当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用ArrayList会提供比较好的性能；
  当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用LinkedList了。*/
