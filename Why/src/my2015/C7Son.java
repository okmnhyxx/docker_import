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

    public void param1(HashMap<String,String> hashMap) {
        System.out.println(" 1: 父类范围小");
    }

    public void param2(Map<String,String> map) {
        System.out.println(" 2: 父类范围大");
    }
}

public class C7Son extends Father{

    public void param1(Map<String,String> map) {
        System.out.println(" 1: 子类范围大");
    }

    public void param2(HashMap<String,String> hashMap) {
        System.out.println(" 2: 子类范围小");
    }

    public static void main(String[] args) {
        Father father = new Father();
        C7Son c7Son = new C7Son();
        HashMap<String,String> hashMap = new HashMap<>();
        Map map = null;

        father.param1(hashMap);
        c7Son.param1(hashMap);

        father.param2(hashMap);
        c7Son.param2(hashMap);
    }
}
