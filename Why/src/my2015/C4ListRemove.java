package my2015;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C4ListRemove {
	
	

	public static void main(String[] args) {
		
		C4ListRemove c = new C4ListRemove();
		List<String> slist = c.generateList();
//		c.testRemove(slist);
//		c.testAddBefore(slist);
		c.testRemoveIndex(slist);
//		c.testDelete(slist);
//		c.test0SizeList();
//		c.testIterator(slist);
	}

	private void test0SizeList() {
		List<String> list = new ArrayList<>();
		System.out.println(list.size());
		
	}

	private void testAddBefore(List<String> slist) {
		for(int i = 0; i <slist.size(); i++ ) {
			System.out.println("第" + i + 1 + "个： " + slist.get(i));
		}
		System.out.println("-------------------------------------------------------");
		for(int i = 0; i <slist.size(); ++i ) {
			System.out.println("第" + i + 1 + "个： " + slist.get(i));
		}
	}

	private List<String> generateList() {
		List<String> slist = new ArrayList<>(10);
		slist.add("1");
		slist.add("2");
		slist.add("3");
		slist.add("4");
		slist.add("5");
		slist.add("6");
		slist.add("7");
		slist.add("8");
		slist.add("9");
		slist.add("10");
		return slist;
	}

	private void testRemove(List<String> slist) {
		
		System.out.println("list: " + slist);
		
		for (String s : slist) {
			if("4".equals(s)) {
				slist.remove(3);
			}
		}
		System.out.println("list: " + slist);
	}
	
	
	private void testRemoveIndex(List<String> slist) {
		System.out.println("list: " + slist);
		for(int i = 0;i < slist.size(); i++ ) {
			if(i == 4) {
				slist.remove(4);
			}
			System.out.println(i + " -- " + slist.get(i));
		}
		System.out.println("list: " + slist);
	}


	private void testDelete(List<String> slist) {
		System.out.println("before list: " + slist);
		for(int i = 0;i < slist.size(); i++ ) {
			if(i == 4) {
				slist.remove("5");
			}
		}
		System.out.println("end list: " + slist);
	}
	
	private void testIterator(List<String> slist) {
		System.out.println("before list: " + slist);
		Iterator<String> it = slist.iterator();
		String s = "";
		while(it.hasNext()) {
			s = it.next();
			if(s.equals("5")) {
				slist.remove(4);
			}
		}
		System.out.println("end list: " + slist);
	}

	
}
