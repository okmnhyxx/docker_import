package my2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by emi on 2016/12/14.
 */
public class A7NextIntCompare {

    Random random = new Random();

    public static void main(String[] args) {
        A7NextIntCompare a = new A7NextIntCompare();
//        a.testNextInt();
        a.compare();
    }

    private void compare() {
        List<Integer> l = new ArrayList<>(20);
        for (int i = 0; i < 20 ; i ++) {
            l.add(random.nextInt(20));
        }
        System.out.println(l);
        Collections.sort(l, ((o1, o2) -> o1 > o2 ? -1 : o1 == o2 ? 0 : 1));
        System.out.println(l);
    }

    private void testNextInt() {

        for (int i = 0; i < 200; i ++ ) {
//            System.out.println(random.nextInt(2));
            System.out.println((random.nextInt(9) + 1) + "hehe");
        }

    }
}
