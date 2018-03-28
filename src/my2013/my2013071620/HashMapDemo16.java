package my2013.my2013071620;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class HashMapDemo16 {
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	int enterFlag;

	public int input1(){
		System.out.print("please input the size of the map ……:\t");
		return sc.nextInt();
	}
	public int inputi(){
		System.out.print("please input the min length of the string ……:\t");
		return sc.nextInt();
	}
	public int inputa(){
		System.out.print("please input the max length of the string ……:\t");
		return sc.nextInt();
	}
	
	public static Map<Integer, String> putInfor(int i,String s,Map<Integer,String> m){
		m.put(i, s);
		return m;
	}
	
	public char getChar(){//获得小写字母
		int rdNum = 0;
		while(rdNum<97)
			 rdNum = rd.nextInt(122);
		return (char)rdNum;
	}
	
	public String getStr(int min,int max){//生成一个长度在min~max之间的string
		
		HashMapDemo16 hmd = new HashMapDemo16();
		int len = 0;
		StringBuffer sb = new StringBuffer();
		while(len<min)
			len = rd.nextInt(max);
//		System.out.println("-------len: " + len);
		for (int i = 0; i < len; i++) 
			sb.append(hmd.getChar());
		
		return sb.toString();
	}
	
	public String wrapStr(String str,int min,int max){//包装string 使1/2的小写字母变为大写
		
		int rand = 0;
		for (int i = 0; i < str.length(); i++) {
			rand = rd.nextInt(9);
			if(rand >= 5){
				//………………………………str.replace has a return  ,you must write as 'str = str.replace('
				str = str.replace(str.charAt(i), Character.toUpperCase(str.charAt(i)));//…………………………has a logic err   but it dosen't metter
			}
		}
		
		return str;
	}
	
	public Map<Integer, String> doMapInit(){
		
		HashMapDemo16 hmd = new HashMapDemo16();
		Map<Integer, String> map = new HashMap<Integer,String>();
		String s = null;
		int size = hmd.input1();
		int min = hmd.inputi();
		int max = hmd.inputa();
		
		for (int i = 1; i <= size; i++) {
			s = hmd.wrapStr(getStr(min,max), min, max);
			HashMapDemo16.putInfor(i, s, map);//将key为i，value为随机生成的s，一对一对的放入到map中
		}
		return map;
	}
	
	
	public void sortKey(Map<Integer,String> map){
		
		HashMapDemo16 hmd = new HashMapDemo16();
		List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>(map.entrySet());
//		public ArrayList(Collection<? extends E> c)构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。 
		
		Collections.sort(entryList,new Comparator<Entry<Integer, String>>(){//………………………………inner class
			@Override
			public int compare(Entry<Integer, String> o1,Entry<Integer, String> o2) {
				return o2.getKey() - o1.getKey();//from large to small//返回的是正数则交换
			}
		});
		
		System.out.println(" sorted by keys : - - - - - - - - - - - - - - - - - - - - - - - ");
//		hmd.traverse2(map);
		hmd.sortTraver(entryList);
	}
	
	
	public void sortValue(Map<Integer,String> map){
		
		HashMapDemo16 hmd = new HashMapDemo16();
		List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>(map.entrySet());
		
		Collections.sort(entryList,new Comparator<Entry<Integer, String>>(){//………………………………inner class
			@Override
			public int compare(Entry<Integer, String> o1,Entry<Integer, String> o2) {
//				System.out.println(o2.getValue().toString());
//				System.out.println(o1.getValue().toString());
//				System.out.println( o1.getValue().toString().compareTo(o2.getValue().toString())  );
				
				return o1.getValue().toString().compareTo(o2.getValue().toString());//from small to large//返回的是正数则交换
			}
		});
		
		System.out.println(" sorted by value : - - - - - - - - - - - - - - - - - - - - - - - ");
//		hmd.traverse2(map);
		hmd.sortTraver(entryList);
	}
	
	
	
	public void traverse1(Map<Integer,String> map){
		
		Set<Integer> setk = new TreeSet<Integer>();
		setk = map.keySet();
		Collection<String> collv = map.values();
		Iterator<Integer> itk = setk.iterator();
		Iterator<String> itr = collv.iterator();
		enterFlag = 0;
		while(itr.hasNext()){
			System.out.print("  key: " + itk.next() + "\tvalue: " + itr.next() + "\t\t\t");
			if(enterFlag%2==1) 
				System.out.println();
			enterFlag++;
		}
		System.out.println();
		
		
		

//		Collection<String> collv = map.values();
//		Iterator<String> itr = collv.iterator();
//		enterFlag = 0;
//		while(itr.hasNext()){
//			System.out.print("\tvalue: " + itr.next() + "\t\t\t");
//			if(enterFlag%2==1) 
//				System.out.println();
//			enterFlag++;
//		}
//		System.out.println();
	}
	
	public void traverse2(Map<Integer,String> map){
		int key = 0;
		for (Iterator<Integer> itr = map.keySet().iterator(); itr.hasNext();) {
			key = itr.next();
			System.out.print("  key: " + key + "\tvalue: " + map.get(key) + "\t\t\t");
			if(enterFlag%2==1) 
				System.out.println();
			enterFlag++;
		}
		System.out.println();
	}
	
	public void traverse3(Map<Integer,String> map){
		Set<Entry<Integer, String>> set = map.entrySet();
		Iterator<Entry<Integer, String>> itr = set.iterator();
		enterFlag = 0;
		while(itr.hasNext()){
			Entry<Integer, String> entry = (Entry<Integer, String>)itr.next();
			System.out.print("  key: " + entry.getKey() + "\tvalue: " + entry.getValue() + "\t\t\t");
			if(enterFlag%2==1) 
				System.out.println();
			enterFlag++;
		}
		System.out.println();
	}

	public void traverse4(Map<Integer,String> map){//the same with traverse2
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> itr = keySet.iterator();
		enterFlag = 0;
		while (itr.hasNext()) {
			Integer key = itr.next();
			String value = map.get(key);
			System.out.print("  key: " + key + "\tvalue: " + value + "\t\t\t");
			if(enterFlag%2==1) 
				System.out.println();
			enterFlag++;
		}
		System.out.println();
	}
	
	public void sortTraver(List<Entry<Integer, String>> entryList){
		for (Iterator<Entry<Integer, String>> iterator = entryList.iterator(); iterator.hasNext();) {
			
			Entry<Integer, String> entry = (Entry<Integer, String>) iterator.next();
			System.out.print("  key: " + entry.getKey() + "\tvalue: " + entry.getValue() + "\t\t\t");
			if(enterFlag%2==1) 
				System.out.println();
			enterFlag++;
		}
	}
	
	public static void main(String[] args) {
		HashMapDemo16 hm = new HashMapDemo16();
		Map<Integer, String> map = new HashMap<Integer,String>();
		
		System.out.println("-------------------------------------------------------> 1 <-------------------------------------------------------");
		map = hm.doMapInit();
		hm.traverse1(map);
		hm.sortKey(map);
		hm.sortValue(map);
		
		System.out.println("-------------------------------------------------------> 2 <-------------------------------------------------------");
		map = hm.doMapInit();
		hm.traverse2(map);
		hm.sortKey(map);
		hm.sortValue(map);
		
		System.out.println("-------------------------------------------------------> 3 <-------------------------------------------------------");
		map = hm.doMapInit();
		hm.traverse3(map);
		hm.sortKey(map);
		hm.sortValue(map);
		
		System.out.println("-------------------------------------------------------> 4 <-------------------------------------------------------");
		map = hm.doMapInit();
		hm.traverse4(map);
		hm.sortKey(map);
		hm.sortValue(map);
	}
}
