package my2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emi on 2016/3/14.
 */
public class A4Null {

    public static void main(String[] args) {
        A4Null a = new A4Null();
        a.testNullStr();
//        a.testNullList();
//        a.testNullStringBuffer();
    }

    private void testNullStringBuffer() {
        StringBuffer sb = new StringBuffer();
        String a = sb.toString();
        System.out.println(a);
    }

    private void testNullStr() {

        String a = null;
        System.out.println(a);

        System.out.println("aaa".equals(a));
        System.out.println(a.equals("aaa"));
    }

    private void testNullList() {
        List<String> sl = new ArrayList<String>(){{add("0");}};
//        if (0 != sl.size()) {
        if (null != sl && 0 != sl.size()) {
            System.out.println(true);
        } else {
            System.out.println( false);
        }
        Object[] oa = sl.toArray();
        System.out.println(sl.toArray());
    }
}
