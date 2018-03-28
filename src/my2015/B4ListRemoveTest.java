package my2015;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class B4ListRemoveTest {

	private void remove1(List<String> l) {
		List<String> list = new ArrayList<String>();
		list.add("one");  
		list.add("two");  
		list.add("two");  
		list.add("three");  
		list.add("for"); 
		for(int i=0;i<list.size();i++){  
            if(list.get(i).equals("two")){  
            	System.out.print("  " + i + "~" + list.get(i));
                list.remove(i);  
            } else {
            	System.out.print("  " + i + "*" + list.get(i));
            }
        }  
		System.out.println();
        System.out.println("\t" + list);
	}
	
	private void remove2(List<String> l) {
		List<String> list = new ArrayList<String>();
		list.add("one");  
		list.add("two");  
		list.add("two");  
		list.add("three");  
		list.add("for"); 
		int i = 0;
		for(String s:list){  
		    if(s.equals("two")){ 
		    	System.out.print("  " + i + "~" + list.get(i));
		        list.remove(s);  
		    } else {
            	System.out.print("  " + i + "*" + list.get(i));
            }
		    i ++;
		} 
		System.out.println();
        System.out.println("\t" + list);
	}
	
	private void remove3(List<String> l) {
		List<String> list = new ArrayList<String>();
		list.add("one");  
		list.add("two");  
		list.add("two");  
		list.add("three");  
		list.add("for"); 
		Iterator<String> iter = list.iterator(); 
		int i = 0;
		while(iter.hasNext()){  
		    String s = iter.next();  
		    if(s.equals("two")){  
		    	System.out.print("  " + i + "~" + s);
		        iter.remove();  
		    }  else {
            	System.out.print("  " + i + "*" + list.get(i));
            }
		    i++;
		}  
		System.out.println();
        System.out.println("\t" + list);
	}

	private void testAlter(){
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("for");
		list.add("five");

	}
	
	public static void main(String[] args) {
		B4ListRemoveTest b = new B4ListRemoveTest();
		List<String> list = new ArrayList<String>();
		list.add("one");  
		list.add("two");  
		list.add("three");
		list.add("two");  
		list.add("two");  
		System.out.println(" --- 1: ");
		b.remove1(list);
		System.out.println(" --- 2: ");
		b.remove2(list);
/*		System.out.println(" --- 3: ");
		b.remove3(list);*/
	}
}
