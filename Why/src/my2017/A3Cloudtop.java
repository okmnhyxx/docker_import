package my2017;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emi on 2017/3/28.
 */
public class A3Cloudtop {

    private final List<String> aaa = new ArrayList<String>();

    public static void main(String[] args) {
        A3Cloudtop a = new A3Cloudtop();
        int b = a.get();
        System.out.println(b);
        a.testAAA();
    }

    public int get() {
        try{
            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            return 2;
        }
    }

    private void testAAA() {
        aaa.add("aaaaaaa");
        System.out.println(aaa);
    }
}

