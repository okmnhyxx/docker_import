package my2016;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emi on 2016/3/3.
 */
public class A3Transport_Value_Reference {


    private void alterValue(boolean b1, int i1, Integer i2, String s1,List<Integer> list) {
        b1 = true;
        i1 = i1 + 10;
        i2 = i2 + 10;
        s1 = s1 + " --- 233333333333";
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(" --- " + b1);
        System.out.println(" --- " + i1);
        System.out.println(" --- " + i2);
        System.out.println(" --- " + s1);
        System.out.println(" --- " + list);

        String a = "a";
        a = a + "b";//指针变了
    }




    public static void main(String[] args) {
        A3Transport_Value_Reference a = new A3Transport_Value_Reference();

        boolean b1 = false;
        int i1 = 1;
        Integer i2 = 2;
        String s1 = "额呵呵呵呵";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        a.alterValue(b1, i1, i2, s1, list);
        System.out.println(b1);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(s1);
        System.out.println(list);


//        List<String> stringList1 = a.generateStrList(10);
//        a.alterListItem1(stringList1);
//        System.out.println(" str list 1" + stringList1);
//
//        List<String> stringList2 = a.generateStrList(10);
//        a.alterListItem2(stringList2);
//        System.out.println(" str list 1" + stringList2);
//
//        List<Student> studentList = a.generateStudentList(3);
//        a.alterStuItem1(studentList);
//        System.out.println(new Gson().toJson(studentList));
//
//        List<Student> studentList2 = a.generateStudentList(3);
//        a.alterStuItem2(studentList2);
//        System.out.println(new Gson().toJson(studentList2));

        List<Student> studentList3 = a.generateStudentList(3);
        System.out.println( "before alter: " +new Gson().toJson(studentList3));
        a.alterStuItem3(studentList3);
        System.out.println( "after alter: " +new Gson().toJson(studentList3));

    }

    private void alterStuItem3(List<Student> studentList3) {
        Student student;
        for (int i = 0;i < studentList3.size(); i ++) {
            student = studentList3.get(i);
            student.setAge(i + 30);
        }
    }

    private void alterStuItem2(List<Student> studentList2) {
        for (Student s : studentList2) {
            s.setAge(s.getAge() + 20);
        }
    }

    private void alterStuItem1(List<Student> studentList) {
        for (int i = 0;i < studentList.size(); i ++) {
            studentList.get(i).setAge(i + 10);
        }
    }

    private List<Student> generateStudentList(int size) {
        List<Student> studentList = new ArrayList<>(size);
        Student student;
        for (int i = 0; i < size; i ++) {
            student = new Student("s" + i,i);
            studentList.add(student);
        }
        return studentList;
    }


    private void alterListItem2(List<String> stringList2) {
        String s;
        for (int i = 0; i < stringList2.size(); i ++) {
            s = stringList2.get(i);
            s = s + "a";
        }
//        System.out.println(" str list 2" + stringList2);
    }

    private void alterListItem1(List<String> stringList) {
        for (String s : stringList) {
            s = s + "a";
        }
//        System.out.println(" str list 1" + stringList);
    }

    private List<String> generateStrList(int size) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            stringList.add(String.valueOf(i));
        }
        return stringList;
    }


}

class Student {
    private String name;

    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
