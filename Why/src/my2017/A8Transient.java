package my2017;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Date;

/**
 * Created by emi on 2017/7/25.
 * http://www.cnblogs.com/liuling/archive/2013/05/05/transient.html

 1、transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
 2、被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 3、一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。也可以认为在将持久化的对象反序列化后，被transient修饰的变量将按照普通类成员变量一样被初始化。
 */
public class A8Transient implements Serializable {

    private static final long serialVersionUID = -5836283489677344417L;
    private transient int classValue = 10;
    private transient Date date = new Date();
    private transient static int staticValue = 10;

    public static void main(String[] args) throws Exception {
        A8Transient a = new A8Transient();
        a.testTransient();
    }

    private void testTransient() throws Exception {

        A8Transient a = new A8Transient();
        a.classValue = 11;
        A8Transient.staticValue = 11;
        File file = A8Transient.createFile("\\src\\musses\\A8Transient.txt");//file.mkdirs()创建目录

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(a);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        A8Transient a1 = (A8Transient) in.readObject();
        in.close();

        System.out.println(a1.classValue);
        System.out.println((a1.date == null ? "date is null" : "date is not null"));
    }


    public static File createFile(String path) {
        String rootPath = System.getProperty("user.dir");
        path = rootPath + path;
        if (StringUtils.isEmpty(path)) {
            System.out.println("路径为空");
        }
        try {
            // 获得文件对象
            File f = new File(path);
            if (f.exists()) {
                return f;
            }
            // 如果路径不存在,则创建
            if (!f.getParentFile().exists()) {
                if (!f.getParentFile().mkdirs()) {
                    System.out.println("父路径创建错误");
                }
            }
            if (f.createNewFile()) {
                System.out.println("文件创建错误");
            }
            return f;
        } catch (Exception e) {
            System.out.println("创建文件错误.path=" + path);
            throw new RuntimeException();
        }
    }
}
