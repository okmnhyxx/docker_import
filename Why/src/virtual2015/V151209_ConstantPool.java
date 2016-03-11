package virtual2015;

/**
 * Created by emi on 2015/12/9.
 * 2-7 String.intern()返回引用的测试
 */
public class V151209_ConstantPool {
    private void test1() {
        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println("(str1.intern() == str1): " + (str1.intern() == str1));//true
    }
    private void test2() {
        String s = "java";
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println("(str2.intern() == str2): " + (str2.intern() == str2));//false
    }
    private void test3() {
        String str1 = new StringBuffer("计算机").append("呵呵").toString();
        String str11 = str1.intern();
        System.out.println("(str1.intern() == str1): " + (str11 == str1));//true
        String str12 = "计算机呵呵";
        System.out.println("(str1.intern() == str12)" + (str11 == str12));//true
    }

    public static void main(String[] args) {
        V151209_ConstantPool constantPool = new V151209_ConstantPool();
        constantPool.test1();
        constantPool.test2();
        constantPool.test3();
        System.gc();
    }
}
/**
 * 在jdk1.6及以下中：test1() test2()的运行结果为俩false，而1.7及以上，则为一个true，一个false，for：
 *      在JDK1.6中，intern()方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用，
 *  而StringBuffer创建的字符串在java堆中，返回的也是永久代中这个字符串实例的引用，所以必然不是同一个引用，将返回false。
 *      而JDK1.7中（以及部分其他虚拟机，exp：JRockit），intern（）不会再复制实例，只是在常量池中记录首次出现的实例引用。
 *  因此intern()返回的引用和由StringBuffer创建的那个字符串实例是同一个。对于str2返回false，是因为“java”这个字符串
 *  在执行StringBuffer.toString();时已经存在了，(其引用指向的是方法区，而stringBuffer生成的那个在java堆中)
 *      JDK1.7中test3()结果猜测：常量池中首次出现的实例引用是？？
 */