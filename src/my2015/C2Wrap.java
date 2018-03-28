package my2015;

import java.util.HashMap;
import java.util.Map;

import other.common.Student;

public class C2Wrap {
	

	private void wrapStr(String s1, String s2) {
		String tmp = s1;
		s1 = s2;
		s2 = tmp;
		System.out.println(" s1: " + s1 + ", s2: " + s2);	
	}
	
	
//	private 
	
	public static void main(String[] args) {

		C2Wrap c = new C2Wrap();
		
		String s1 = "s1";
		String s2 = "s2";
		
		Student stu1 = new Student(10, "xiaomiao");
		Student stu2 = new Student(9, "miao~");
		
		Map<String,String> map = new HashMap<String, String>(); 
		map.put("m1", "one");
		
		c.wrapStr(s1,s2);
		c.alterStudent(stu1);  
		c.wrapStudent(stu1,stu2);
		c.alterMap(map);
		
		System.out.println(" --- main --- s1: " + s1 + ", s2: " + s2);
		System.out.println(" --- main --- student age: " + stu1.getAge() + ", student name: " + stu2.getName());
		System.out.println(" --- main --- student1's name: " + stu1.getName() + ", student2's name: " + stu2.getName());
		System.out.println(" --- main --- map.m1:" + map.get("m1"));
	}


private void alterMap(Map<String, String> map) {
	map.put("m1", "two");
	System.out.println(" map.m1:" + map.get("m1"));
	
}

      
private void wrapStudent(Student stu1, Student stu2) {
	Student s = new Student();
	s = stu1;
	stu1 = stu2;
	stu2 = s;
	System.out.println(" student1's name: " + stu1.getName() + ", student2's name: " + stu2.getName());
	
}


private void alterStudent(Student s) {
	s.setAge(3);
	s.setName("xiaohei");
	System.out.println(" student age: " + s.getAge() + ", student name: " + s.getName());
}



}
