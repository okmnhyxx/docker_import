package my2016;

import java.util.Arrays;

/**
 * Created by emi on 2016/12/22.
 */
public class A8ArrayStr {



    public static void main(String[] args) {
        A8ArrayStr a = new A8ArrayStr();
        a.testArrStr(1,2,3,4);
    }

    private void testArrStr(Integer... intArr) {

        Integer [] a = new Integer[]{7,8,9};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(intArr));
    }
}
