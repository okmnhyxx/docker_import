package virtual2015;

/**
 * Created by emi on 2015/12/9.
 * 2-5 创建线程导致内存溢出的测试
 * VM args：-Xss2M,//程序直接卡死也不报错，郁闷
 * VM args: 假如 -Xms1M -Xss10M，会报错，GC triggered before VM initialization completed. Try increasing NewSize, current  value 1536K.

 */
public class V151209_JavaVMStackOOM {
    static int i = 1;

    private void dontStop() {
        while (true) {
            int i1 = 65537;
            long l1 = 65537;
            char c1 = 'c';
            String s1 = "s1";
            float f1 = 1.2f;
            double d1 = 20.00;
            boolean b1 = false;
            byte by1[] = {1,2,3};
            short sh1 = 128;
            System.out.println("count: " + i++);
        }
    }

    public void stackLeakByThread() {
        while (true) {
            int i = 0;
            new  Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        V151209_JavaVMStackOOM oom = new V151209_JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}

/**
 * 不限于单线程去测试，通过不断创建单线程可以导致内存溢出。
 * 如果创建过多线程导致内存溢出，在不能减少线程数或更换64位虚拟机的情况下，只能通过减少最大堆和减小栈容量来换取更多的线程
 */