package my201407;

import java.util.ArrayList;
import java.util.List;

public class ListNullException {
	
	public String testNull(){
		
		List<String> list = new ArrayList<String>();
		
		if(0==list.size()){
			System.out.println(111);
		}
		
		String testOne = list.get(0);
		
		return "qqq";
		
	}
	
	public static void main(String[] args) {
		ListNullException lne = new ListNullException();
		System.out.println(lne.testNull());
	}

}
