package virtual2015;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by emi on 2015/12/7.
 * reference http://my.oschina.net/ydsakyclguozi/blog/404389
 * test weak reference
 */
public class V151207_ReferenceTest {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> ref = null;
        while ((ref = rq.poll()) != null) {//①
            System.out.println("In queue: can poll");
            if (ref != null) {
                System.out.println("In queue: "   + ((VeryBigWeakReference) (ref)).id);
            }
        }
    }

    public static void main(String args[]) {
        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
//          WeakReference<VeryBig> wf = new VeryBigWeakReference(new VeryBig("Weak " + i),rq);
            weakList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
            System.out.println("Just created weak: " + weakList.getLast());
//            System.out.println("Just created weak: " + ((WeakReference<VeryBig>)weakList.getLast()));
        }

        System.gc();
        try { // 下面休息几分钟，让上面的垃圾回收线程运行完成
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
        Object o = new Object();
        ArrayList arrayList = new ArrayList();

    }
}

class VeryBig {
    public String id;
    // 占用空间,让线程进行回收
    byte[] b = new byte[2 * 1024];

    public VeryBig(String id) {
        this.id = id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBig " + id);
    }
}

class VeryBigWeakReference extends WeakReference<VeryBig> {
    public String id;

    public VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBigWeakReference " + id);
    }
}

/**
 * 下面很多解释都在说：“被垃圾回收器回收”。是指“加入到相应的Reference里面，然后在判断是否能被finalize（）方法拯救”？
 */

/**
 *
 * java引用分为4种：
    1：强引用：
        强引用是使用最普遍的引用。如果一个对象具有强引用，那垃圾回收器绝不会回收它。显式地设置o为null，或超出对象的生命周期范围，则gc认为该对象不存在引用，这时就可以回收这个对象。否则Java虚拟机宁愿抛出OutOfMemoryError错误，也不会靠随意回收具有强引用的对象来解决内存不足的问题。（全局变量对象，如果不使用时，要通过如下方式来弱化引用：Object o = null;     // 帮助垃圾收集器回收此对象）
    2：软引用：
        如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存。
        （String str=new String("abc");// 强引用    SoftReference<String> softRef=new SoftReference<String>(str);// 软引用）
        虚引用在实际中有重要的应用，例如浏览器的后退按钮。按后退时，这个后退时显示的网页内容是重新进行请求还是从缓存中取出呢？
         Browser prev = new Browser();               // 获取页面进行浏览
         SoftReference sr = new SoftReference(prev); // 浏览完毕后置为软引用
         if(sr.get()!=null){
             rev = (Browser) sr.get();           // 还没有被回收器回收，直接获取
         }else{
             prev = new Browser();               // 由于内存吃紧，所以对软引用的对象回收了
             sr = new SoftReference(prev);       // 重新构建
         }
    3：弱引用（该程序测试的就是弱引用）：
        当你想引用一个对象，但是这个对象有自己的生命周期，你不想介入这个对象的生命周期，这时候你就是用弱引用。这个引用(弱引用)不会在对象的垃圾回收判断中产生任何附加的影响。
        弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程，因此不一定会很快发现那些只具有弱引用的对象。
        【如：
            String str=new String("abc");   WeakReference<String> abcWeakRef = new WeakReference<String>(str);  str=null;
        当垃圾回收器进行扫描回收时等价于：
            str = null;     System.gc();】
        下面的代码会让str再次变为一个强引用：
            String  abc = abcWeakRef.get();】
    4.虚引用：
        虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。 虚引用主要用来跟踪对象被垃圾回收器回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列 （ReferenceQueue）联合使用。
 */


/**
 * ①
 个人理解：
     pop：相当于get的操作，就是只是查看。
     poll：相当于先get然后再remove掉，就是查看的同时，也将这个元素从容器中删除掉。
 jdk官方解释：
     pop()         从此列表所表示的堆栈处弹出一个元素。
     poll()          获取并移除此列表的头（第一个元素）
 */
