package my2016;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by emi on 2016/12/22.
 */
public class A9Jdk8 {

    public static void main(String[] args) {
        A9Jdk8 a = new A9Jdk8();
//        a.testMapStream();
//        a.steamMapper();


        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
        a.testRunTime();
        System.out.println();
    }



    private void testRunTime() {
        List<Integer> il = new ArrayList<>();
        for (int i = 0; i < 500000; i ++)
            il.add(i);
        long a0 = this.fetchDateLong();

        List<String> sl1 = new ArrayList<>();
        for (int i = 0; i < il.size(); i ++) {
            sl1.add(String.valueOf(i));
        }
        long a1 = this.fetchDateLong();
        System.out.println("a1: " + a1);
        System.out.println(" --------------- (a1 - a0): " + (a1 - a0));

        List<String> sl2 = il.stream().map(o -> String.valueOf(o)).collect(Collectors.toList());
        long a2 = this.fetchDateLong();
        System.out.println("a2: " + a2);
        System.out.println(" --------------- (a2 - a1): " + (a2 - a1));

        List<String> sl3 = il.parallelStream().map(o -> String.valueOf(o)).collect(Collectors.toList());
        long a3 = this.fetchDateLong();
        System.out.println("a3: " + a3);
        System.out.println(" --------------- (a3 - a2): " + (a3 - a2));

        List<String> sl4 = il.stream().map(String::valueOf).collect(Collectors.toList());
        long a4 = this.fetchDateLong();
        System.out.println("a4: " + a4);
        System.out.println(" --------------- (a4 - a3): " + (a4 - a3));

        List<String> sl5 = il.parallelStream().map(String::valueOf).collect(Collectors.toList());
        long a5 = this.fetchDateLong();
        System.out.println("a5: " + a5);
        System.out.println(" --------------- (a5 - a4): " + (a5 - a4));
    }

    private long fetchDateLong() {
//        return System.currentTimeMillis();
        return Calendar.getInstance().getTimeInMillis();
    }

    private void steamMapper() {
        List<Integer> il = Arrays.asList(1, 2, 3);
//        List<String> sl = new ArrayList<>(il.size());
//        sl.addAll(il.stream().map(String::valueOf).collect(Collectors.toList()));
        List<String> sl = il.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(sl);
    }

    private void testMapStream() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "aa");
        map.put("2", "cc");
        map.put("3", "bb");
        String o1 = (String) map.computeIfPresent("3", (a, b) -> a + b);
        String o2 = (String) map.computeIfPresent("4", (a, b) -> a + b);
        System.out.println(o1);

        String s3 = (String) map.getOrDefault("4", "not found");
        System.out.println(s3);
    }



}
