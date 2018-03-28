package virtual2015;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emi on 2015/12/11.
 * VM args : -Xms120M -Xmx120M -Xmn70M -XX:+UseSerialGC
 * 改代码以64K/1000毫秒的速度往堆了填充数据，一共填充1000次，使用JConsole的内存也监控
 */
public class V151211_OOMObject {

    /**
     * 内存占位符对象，一个OOMObject大小约64k；
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0;i < num; i++) {
            //稍作延迟，令曲线变化更下明显
            Thread.sleep(10000);
            list.add(new OOMObject());
            System.out.println(" index: " + i);
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(30000);
        fillHeap(1000);
    }


}

/**分配策略
 *  1：对象优先在Eden去分配：当Eden没有足够的空间进行分配时，虚拟机将发起一次Minor GC.
 *  2：大对象直接进入老年代: -XXPretenureSizeThreshold参数设置阀值，例如：-XXPretenureSizeThreshold=3145728
 *  3：长期存活的对象直接进入老年代
 *  4：动态对象年龄判断
 *
 *  Eden: 27328k  26.6875M
 *  to Survive: 3392k  3.3125M
 *  Tenured : 68288k  66.6875M
 *  当执行第一次是， Eden初始时空间就已被占用50%，执行24次之后，eden满，执行gc，surv满，tenured基本空，执行到76次，eden满，执行gc，surv满，tenured3730k，执行到76次，eden满，执行gc，surv满，tenured7193k，……当执行到288次时 ，出现第六个峰值
 *
 */