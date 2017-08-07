package my2017;

import java.io.*;

/**
 * Created by emi on 2017/7/25.
 * 对象的序列化可以通过实现两种接口来实现，
 * 若操作的是一个Serializable对象，则所有的序列化将会自动进行，
 * 若操作的是 一个Externalizable对象，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。
 * 因此这个例子输出的是变量content初始化的内容，而不是null
 */
public class A8Externalizable implements Externalizable {

    private transient String content = "哈哈~我将会被序列化，不管我是是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }


    public static void main(String[] args) throws Exception {
        A8Externalizable a = new A8Externalizable();
        a.testExternalizable();
    }

    private void testExternalizable() throws Exception{
        A8Externalizable et = new A8Externalizable();

        File file = A8Transient.createFile("\\src\\musses\\A8Externalizable.txt");//file.mkdirs()创建目录
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(file));
        A8Externalizable et1 = (A8Externalizable) in.readObject();
        System.out.println(et1.content);

        out.close();
        in.close();
    }
}
