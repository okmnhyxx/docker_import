package my2016;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2016/1/20.
 */
public class A1LSP_FatherSon {

    public static class Father {

        public Collection say_one (HashMap hashMap) {
            System.out.println("父类 one 方法被执行");
            return hashMap.values();
        }

        public Collection say_two (Map map) {
            System.out.println("父类 two 方法被执行");
            return map.values();
        }

        public Collection say_three (HashMap hashMap) {
            System.out.println("父类 three 方法被执行");
            return hashMap.values();
        }

    }

    public static class Son extends Father {

        public Collection say_one (Map map) {
            System.out.println("子类 one 方法被执行");
            return map.values();
        }

        public Collection say_two (HashMap hashMap) {
            System.out.println("子类 two 方法被执行");
            return hashMap.values();
        }

        public Collection say_three (HashMap hashMap) {
            System.out.println("子类 three 方法被执行");
            return hashMap.values();
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("h","hehe");


        Father f = new Father();
        Son s = new Son();
        System.out.println(" --------------------------------- father HashMap , son Map ------------------------------------");
        f.say_one(hashMap);
        s.say_one(hashMap);

        System.out.println(" --------------------------------- father Map , son HashMap ------------------------------------");
        f.say_two(hashMap);
        s.say_two(hashMap);


        Father fs = new Son();
        System.out.println(" --------------------------------- father HashMap , son Map ------------------------------------");
        fs.say_one(hashMap);
        System.out.println(" --------------------------------- father Map , son HashMap ------------------------------------");
        fs.say_two(hashMap);
        System.out.println(" --------------------------------- father HashMap , son HashMap ------------------------------------");
        fs.say_three(hashMap);

        //对比fs.sayTwo  和 fs.sayThree   不知道要说什么………………，可参考my2013.my2013071015.Son11;
    }
}
