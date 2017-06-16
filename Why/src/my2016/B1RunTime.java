package my2016;

import java.util.*;

/**
 * Created by emi on 2016/12/23.
 */
public class B1RunTime {

    public static void main(String[] args) {
        int times = 10;
        int times2 = 100000;
        B1RunTime b = new B1RunTime();
        b.testListAverage(times, times2);
        b.testArrAverage(times, times2);
    }


    private void testListAverage(int times, int times2) {
        Long[] addSort;
        Long[] addSortAll = new Long[] {0L, 0L};

        for (int i = 0; i < times; i ++) {
            addSort = testListRun(times2);
            addSortAll[0] = addSortAll[0] + addSort[0];
            addSortAll[1] = addSortAll[1] + addSort[1];
        }
        System.out.println(" --------------------------------- list add: " + addSortAll[0] + "           list sort: " + addSortAll[1]);
    }

    private void testArrAverage(int times, int times2) {
        Long[] addSort;
        Long[] addSortAll = new Long[] {0L, 0L};

        for (int i = 0; i < times; i ++) {
            addSort = testArrRun(times2);
            addSortAll[0] = addSortAll[0] + addSort[0];
            addSortAll[1] = addSortAll[1] + addSort[1];
        }
        System.out.println(" --------------------------------- arr add: " + addSortAll[0] + "           arr sort: " + addSortAll[1]);
    }

    private Long[] testListRun(int times2) {
        Random random = new Random();
        long begin = fetchDateLong();

        List<Integer> il = new ArrayList<>();
        for (int i = 0; i < times2; i ++) {
            il.add(random.nextInt(100000));
        }
        long middle = fetchDateLong();

        Collections.sort(il, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        long end = fetchDateLong();

        long interval1 = middle - begin;
        long interval2 = end - middle;
        System.out.println(" list add: " + interval1 + "      list sort: " + interval2);
        return new Long[] {interval1, interval2};
    }

    private Long[] testArrRun(int times2) {
        Random random = new Random();
        long begin = fetchDateLong();

        Integer[] ia = new Integer[times2];
        for (int i = 0; i < times2; i ++) {
            ia[i] = random.nextInt(100000);
        }
        long middle = fetchDateLong();

        Arrays.sort(ia, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        long end = fetchDateLong();

        long interval1 = middle - begin;
        long interval2 = end - middle;
        System.out.println(" arr add: " + interval1 + "      arr sort: " + interval2);
        return new Long[] {interval1, interval2};
    }


    private long fetchDateLong() {
        return System.currentTimeMillis();
//        return Calendar.getInstance().getTimeInMillis();
    }
}
