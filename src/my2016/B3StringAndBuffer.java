package my2016;

import java.util.Random;

/**
 * Created by emi on 2016/12/29.
 */
public class B3StringAndBuffer {
    private Random random = new Random();

    public static void main(String[] args) {
        B3StringAndBuffer b = new B3StringAndBuffer();
        int intValue = new Double(3.3).intValue();

        System.out.println(intValue);
//        b.testSB();
    }

    private void testSB() {
        int time = 10;
        int innerTime = 3;
        for (int i = 0; i < time; i ++) {
            testString(innerTime);
            testBuffer(innerTime);
            System.out.println("------------------------------------------------------------------\n");
        }
    }

    private void testString(int innerTime) {
        long begin = fetchDateLong();
        for (int a1= 0; a1 < 10000; a1 ++) {
            String a = "";
            for (int i = 0; i < innerTime; i ++ ) {
                a = a + generateRandom();
            }
        }
        long end = fetchDateLong();
        System.out.println("  string : " + (end - begin));
    }

    private void testBuffer(int innerTime) {
        long begin = fetchDateLong();
        for (int a1 = 0; a1 < 10000; a1 ++) {
            StringBuffer b = new StringBuffer();
            for (int i = 0; i < innerTime; i ++ ) {
                b.append(generateRandom());
            }
        }
        long end = fetchDateLong();
        System.out.println("  buffer : " + (end - begin));
    }

    private String generateRandom() {
       return random.nextInt(100000) + ",";
    }

    private long fetchDateLong() {
        return System.currentTimeMillis();
//        return Calendar.getInstance().getTimeInMillis();
    }
}
