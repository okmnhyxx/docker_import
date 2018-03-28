package my2016;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by emi on 2016/12/23.
 */
public class B2TestRunTime {

    public static void main(String[] args) {

        B2TestRunTime b = new B2TestRunTime();
        for (int i = 0; i < 100; i ++) {
            b.testLambdaTime();
            System.out.println("-------------------------");
        }
    }

    private void testLambdaTime() {
        int tt = 1;
        int times = 500000;
        List<Integer> il = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            il.add(i);
        }
        long s0 = System.currentTimeMillis();
        for (int k = 0; k < tt; k++) {
            List<String> sl = new ArrayList<>(times);
            for (int j = 0; j < times; j++) {
                sl.add(String.valueOf(il.get(j)));
            }
        }
        long s1 = System.currentTimeMillis();
        System.out.println(s1 - s0);

        long s10 = System.currentTimeMillis();
        for (int k1 = 0; k1 < tt; k1++) {
            il.stream().map(String::valueOf).collect(Collectors.toList());
        }
        long s11 = System.currentTimeMillis();
        System.out.println(s11 - s10);
    }
}
