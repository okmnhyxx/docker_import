package my2016;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by emi on 2017/1/11.
 */
public class B5SetJCB {

    public static void main(String[] args) {


        B5SetJCB b = new B5SetJCB();
        b.jcb();
        b.refNotDuplicate();
    }

    private void refNotDuplicate() {
        Set<String> set = new HashSet<>();//任意俩元素 e1.equals(e2) = false;
        String a = new String("aaa");
        String b = new String("aaa");
        String c = a;
        String d = "a" + "aa";

        System.out.println("a == b" + (a == b));
        System.out.println("a == c" + (a == c));
        System.out.println("a == d" + (a == d));

        set.add(a);
        set.add(b);
//        set.add(c);
        set.add(d);
        System.out.println(set);


        Set<TestBean> beanSet = new HashSet<>();
        TestBean tb1 = new TestBean("aaa");
        TestBean tb2 = new TestBean("aaa");
        TestBean tb3 = tb1;
        

        beanSet.add(tb1);
        beanSet.add(tb2);
        beanSet.add(tb3);
        System.out.println(beanSet);



    }

    private void jcb() {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>(){{
            add(1);
            add(3);
            add(5);
        }};

        Set<Integer> set2 = new HashSet<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集："+result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集："+result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集："+result);

    }


    private class TestBean {
        private String name;

        public TestBean(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
