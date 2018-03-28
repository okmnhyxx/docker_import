package my2016;

/**
 * Created by emi on 2016/10/9.
 */
public class A5SelfAdd {

    public static void main(String[] args) {
        A5SelfAdd a = new A5SelfAdd();
        a.selfIndex();
    }

    private void selfIndex() {
        int i = 1;
        selfIndex2(++i, ++i, i);
    }

    private void selfIndex2(int i, int i1, int i2) {
        System.out.println("i: " + i);
        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);
    }
}
