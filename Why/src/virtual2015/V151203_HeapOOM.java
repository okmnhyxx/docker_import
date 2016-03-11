package virtual2015;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emi on 2015/12/3.
 * test virtual args
 * VM options:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class V151203_HeapOOM {

 static class OOMObject {

 }

 public static void main(String[] args) {
  List<OOMObject> list = new ArrayList<OOMObject>();
  long l = 0;
  while (true) {
   list.add(new OOMObject());
   System.out.println("l: " + l ++);
  }

 }

}

/*Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Arrays.java:3210)
        at java.util.Arrays.copyOf(Arrays.java:3181)
        at java.util.ArrayList.grow(ArrayList.java:261)
        at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
        at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
        at java.util.ArrayList.add(ArrayList.java:458)
        at virtual2015.V151203_HeapOOM.main(V151203_HeapOOM.java:23)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:497)
        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:140)*/

/**
 内存溢出 out of memory，是指程序在申请内存时，没有足够的内存空间供其使用，出现out of memory；比如申请了一个integer,但给它存了long才能存下的数，那就是内存溢出。
 内存泄露 memory leak，是指程序在申请内存后，无法释放已申请的内存空间，一次内存泄露危害可以忽略，但内存泄露堆积后果很严重，无论多少内存,迟早会被占光。
 */

/**
 假设你是windows平台，你安装了J2SDK，那么现在你从cmd控制台窗口进入J2SDK安装目录下的bin目录，然后运行java命令，出现如下结果，这些就是包括java.exe工具的和JVM的所有命令都在里面。
 C:\Java\jdk1.8.0_45\bin>java
 C:\Java\jdk1.8.0_45\bin>java -X
 C:\Java\jdk1.8.0_45\bin>jar
 C:\Java\jdk1.8.0_45\bin>javac
 C:\Java\jdk1.8.0_45\bin>javadoc
 C:\Java\jdk1.8.0_45\bin>rmid
 */

/**
 * 其中 java -X：
 1、-Xmixed           mixed mode execution (default)
 混合模式执行

 2、-Xint             interpreted mode execution only
 解释模式执行

 3、-Xbootclasspath:<directories and zip/jar files separated by ;>
 set search path for bootstrap classes and resources
 设置zip/jar资源或者类（.class文件）存放目录路径

 3、-Xbootclasspath/a:<directories and zip/jar files separated by ;>
 append to end of bootstrap class path
 追加zip/jar资源或者类（.class文件）存放目录路径

 4、-Xbootclasspath/p:<directories and zip/jar files separated by ;>
 prepend in front of bootstrap class path
 预先加载zip/jar资源或者类（.class文件）存放目录路径

 5、-Xnoclassgc       disable class garbage collection
 关闭类垃圾回收功能

 6、-Xincgc           enable incremental garbage collection
 开启类的垃圾回收功能

 7、-Xloggc:<file>    log GC status to a file with time stamps
 记录垃圾回日志到一个文件。

 8、-Xbatch           disable background compilation
 关闭后台编译

 9、-Xms<size>        set initial Java heap size
 设置JVM初始化堆内存大小

 10、-Xmx<size>        set maximum Java heap size
 设置JVM最大的堆内存大小

 11、-Xss<size>        set java thread stack size
 设置JVM栈内存大小

 12、-Xprof            output cpu profiling data
 输入CPU概要表数据

 13、-Xfuture          enable strictest checks, anticipating future default
 执行严格的代码检查，预测可能出现的情况

 14、-Xrs              reduce use of OS signals by Java/VM (see documentation)
 通过JVM还原操作系统信号

 15、-Xcheck:jni       perform additional checks for JNI functions
 对JNI函数执行检查

 16、-Xshare:off       do not attempt to use shared class data
 尽可能不去使用共享类的数据

 17、-Xshare:auto      use shared class data if possible (default)
 尽可能的使用共享类的数据

 18、-Xshare:on       require using shared class data, otherwise fail.
 尽可能的使用共享类的数据，否则运行失败

 The -X options are non-standard and subject to change without notice.
 */

/**
 * additional:
 * -Xmn2g：设置年轻代大小为2G。整个JVM(堆)内存大小=年轻代大小 + 年老代大小 + 持久代大小。持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。
 * -XX:SurvivorRatio -- 设置Eden与Survivor空间的大小比例，通常：-XX:SurvivorRatio=8，及Eden, To Survivor, From Survivor空间比例8 ： 1 : 1。
 * -XX:PretenureSizeThreshold=3145728 --设置超过3M的对象直接在老年代分配空间。（大对象直接进入老年代）
 * -XX:MaxTenuringThreshold=15 --从新生代晋升到老年代的年龄阀值（默认15）。
 * -XX:HandlePromotionFailure --设置是否允许担保失败。
 * -XX:PermSize --设置永久代大小，（-XX:MaxPermSizeXX:MaxPermSize 设置Perm区最大值）
 * -XX:PrintGCDetails --发生垃圾收集行为时打印内存回收日志
 * -XX:PrintAssembly --输出反编译内容
 * -XX:MaxDirectMemorySize=40M --设置最大堆外内存为40M（堆外内存是在Full GC时，回收的。            疑问：System.gc()是不是先执行Minor GC，再执行Major GC？）//todo:???
 * -XX:+DisableExplicitGC --禁止代码中显示调用GC，（比如代码中输System.gc()会无效，堆外内存需要System.gc()时无效，所以若使用java nio的direct memory时需谨慎），
 *
 * */