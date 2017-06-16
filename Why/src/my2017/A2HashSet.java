package my2017;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by emi on 2017/2/28.
 */
public class A2HashSet {

    public static void main(String[] args) {

        A2HashSet a = new A2HashSet();

        a.testSet();
    }

    private void testSet() {
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("aaa");
        System.out.println(set);
    }
}
