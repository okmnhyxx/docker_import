package my2015;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2015/12/18.
 * javac -encoding UTF-8 my2015\C7Son.java
 * javap -c my2015\C7Son.class
 * java my2015/C7Son
 */
class Father {

    public void param0(String s) {
        System.out.println(" 0: 父类范围一样");
    }

    public void param1(HashMap<String,String> hashMap) {
        System.out.println(" 1: 父类范围小");
    }

    public void param2(Map<String,String> map) {
        System.out.println(" 2: 父类范围大");
    }
}

public class C7Son extends Father{

    public void param0(String s) {
        System.out.println(" 0: 子类范围一样");
    }

    public void param1(Map<String,String> map) {
        System.out.println(" 1: 子类范围大");
    }

    public void param2(HashMap<String,String> hashMap) {
        System.out.println(" 2: 子类范围小");
    }

    public void param3() {
        System.out.println(" 3: 子类有");
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        Map<String,String> map = null;
        Map<String,String> map2 = new HashMap<>();

        C7Son s = new C7Son();
        Father fs = new C7Son();

        s.param0("");
        s.param1(hashMap);
        s.param2(hashMap);//uncertain
        System.out.println();

        s.param1(map);
        s.param2(map);//uncertain
        System.out.println();

        s.param1(map2);
        s.param2(map2);
        System.out.println();

        fs.param0("");
        fs.param1(hashMap);
        fs.param2(hashMap);//error
        System.out.println();

//        fs.param1(map);//编译不通过
        fs.param2(map);
//        fs.param1(map2);//编译不通过
        fs.param2(map2);
//        fs.param3();//调不到
    }
}


//    // 1.这样你就只能调用List接口里面定义好的方法，而不能使用你自己在ArrayList扩展的方法。
//    List list = new ArrayList();
//
//    // 2.这样你可以使用自己在ArrayList类上扩展的方法
//    ArrayList list = new ArrayList();
//
// 接口就是定义了一些行为，它要求你应该做什么。
// 假如你采用了面向接口编程方式，也就是第一种方式：List list = new ArrayList();
// 就能通过接口很大限度上规范开发人员的实现规则，因为你现在只能调用接口的方法。


/*	a.	多态三要素
	1）	在继承环境下，子类重写父类方法。
	2）	通过父类引用变量指向子类对象。
	3）	恰好通过父类引用变量调用的是被重写的方法。
	       在此情况下，将发生多态效应，从常态来说，
	       通过父类引用变量指向子类对象，该引用变量只能看到子类对象中的父类部分，不可能调用到子类方法。
	       但是由于这里存在重写，通过父类引用变量向子类对象发送信号的时候，
	       该方法调用信号由于和子类重写方法签名是完全一致，结果调用子类的该重写方法，
	       对于方法的主调者来说，其并不知道会产生这个结果，纯属意外。
*/
