package my2017;

import java.io.*;

/**
 * http://blog.csdn.net/sheepmu/article/details/27579895
 */
public class A9Serializable implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name="SheepMu";
    private static int age=24;
    private transient int score = 100;
    public static void main(String[] args) throws Exception {

        A9Serializable a = new A9Serializable();
        a.testSerializable();
    }

    private void testSerializable() throws Exception {
        File file = A8Transient.createFile("\\src\\musses\\A9Serializable.txt");//file.mkdirs()创建目录

        //以下代码实现序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));//输出流保存的文件名为 my.out ；ObjectOutputStream能把Object输出成Byte流
        A9Serializable a = new A9Serializable();
        oos.writeObject(a);
        oos.flush();  //缓冲流
        oos.close(); //关闭流

        fan();
    }

    public static void fan() throws Exception{
        File file = A8Transient.createFile("\\src\\musses\\A9Serializable.txt");//file.mkdirs()创建目录

        new A9Serializable().name="SheepMu_1";     //!!!!!!!!!!!!!!!!重点看这两行 更改部分
        age=1;        //!!!!!!!!!!!!!!!!!!!重点看这两行 更改部分

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        A9Serializable mts = (A9Serializable ) oin.readObject();//由Object对象向下转型为A9Serializable对象

        System.out.println("name="+mts.name);
        System.out.println("age="+mts.age);
        System.out.println("score="+mts.score);
    }
}



/**
 * Created by emi on 2017/7/25.
 1、什么是序列化和反序列化
 Serialization（序列化）是一种将对象以一连串的字节描述的过程；反序列化deserialization是一种将这些字节重建成一个对象的过程。
 2、什么情况下需要序列化
 a）当你想把的内存中的对象保存到一个文件中或者数据库中时候；
 b）当你想用套接字在网络上传送对象的时候；
 c）当你想通过RMI传输对象的时候；
 3、如何实现序列化
 将需要序列化的类实现Serializable接口就可以了，Serializable接口中没有任何方法，可以理解为一个标记，即表明这个类可以序列化。

 4、
 记住：对象的序列化是基于字节的，不能使用Reader和Writer等基于字符的层次结构
 要使用ObjectXXXStream，里面套着FileXXXStream、ByteArrayXXXStream等

 5、序列化ID
 序列化 ID 在 Eclipse 下提供了两种生成策略，
 一个是固定的 1L，一个是随机生成一个不重复的 long 类型数据（实际上是使用 JDK 工具生成），
 在这里有一个建议，如果没有特殊需求，就是用默认的 1L 就可以，这样可以确保代码一致时反序列化成功。这也可能是造成序列化和反序列化失败的原因，因为不同的序列化id之间不能进行序列化和反序列化。


 6.序列化前和序列化后的对象的关系
 是 "=="还是equal？ or  是浅复制还是深复制？
 答案：深复制，反序列化还原后的对象地址与原来的的地址不同

 序列化前后对象的地址不同了，但是内容是一样的，而且对象中包含的引用也相同。换句话说，通过序列化操作,我们可以实现对任何可Serializable对象的”深度复制（deep copy）"
 ——这意味着我们复制的是整个对象网，而不仅仅是基本对象及其引用。对于同一流的对象，他们的地址是相同，说明他们是同一个对象，但是与其他流的对象地址却不相同。
 也就说，只要将对象序列化到单一流中，就可以恢复出与我们写出时一样的对象网，而且只要在同一流中，对象都是同一个。

 8、总结:
 a）当一个父类实现序列化，子类自动实现序列化，不需要显式实现Serializable接口；
 b）当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化；
 c） static,transient后的变量不能被序列化；
    原因： 序列化会忽略静态变量，即序列化不保存静态变量的状态。静态成员属于类级别的，所以不能序列化。即 序列化的是对象的状态不是类的状态。
 */
