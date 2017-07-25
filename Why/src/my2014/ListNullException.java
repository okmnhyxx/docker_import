package my2014;

import java.util.ArrayList;
import java.util.List;

public class ListNullException {
	
	public void testNull(){
		
		List<String> list = new ArrayList<String>();
		
		if(0==list.size()){
			System.out.println(111);
		}
		
		String testOne = list.get(0);
		System.out.println(testOne);
	}
	
	public static void main(String[] args) {
		ListNullException lne = new ListNullException();
//		lne.testNull();
		lne.testClear();
	}

	private void testClear() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		System.out.println(list.toString());
		list.clear();
		System.out.println(list);
		list.add("ccc");
		System.out.println(list);

	}
}
