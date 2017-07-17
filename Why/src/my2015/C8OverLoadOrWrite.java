package my2015;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2017/7/12.
 */
public class C8OverLoadOrWrite {

    public void test(HashMap<String, String> hashMap) {
        System.out.println("hashMap");
    }
    public void test(Map<String, String> map) {
        System.out.println("map");
    }

    public static void main(String[] args) {
        Map<String, String> map = null;
        HashMap<String, String> hashMap = new HashMap<>();
        Map<String, String> fakeHashMap = new HashMap<>();
        C8OverLoadOrWrite c = new C8OverLoadOrWrite();

        c.test(hashMap);
        c.test(fakeHashMap);
    }
}
