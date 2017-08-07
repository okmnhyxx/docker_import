package my2017;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2017/2/27.
 */
public class A1MapKeyBoxed {


    public static void main(String[] args) {
        A1MapKeyBoxed a1 = new A1MapKeyBoxed();
        a1.testAssign();
        a1.testMapKeyLong(128L);
        a1.testMapKeyStr("a");
    }

    /**
     * 测试引用传递
     */
    private void testAssign() {
        Map<String, String> map1 = new HashMap<String, String>(){{put("a", "aaa");}};
        Map<String, String> map2 = map1;
        map1.put("b","bbbb");
        System.out.println(map2);
    }

    private void testMapKeyLong(Long a2) {
        Long a1 = 128L;
        Long a3 = 128L;

        Map<Long, String> map = new HashMap<>();
        map.put(a1, "a1");
        if (!map.containsKey(a2)) {//是否包换key，好像是通过hashcode和equals算出来的
            map.put(a2, "a2");
        }
        if (map.containsKey(a3)) {
            System.out.println(map.get(a3));
        }
    }

    private void testMapKeyStr(String a2) {
        String a1 = "a";
        String a3 = "a";

        Map<String, String> map = new HashMap<>();
        map.put(a1, "a1");
        if (!map.containsKey(a2)) {//是否包换key，好像是通过hashcode和equals算出来的
            map.put(a2, "a2");
        }
        if (map.containsKey(a3)) {
            System.out.println(map.get(a3));
        }
    }
}
