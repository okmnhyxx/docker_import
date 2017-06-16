package my2017;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2017/2/27.
 */
public class A1MapKeyBoxed {


    public static void main(String[] args) {
        A1MapKeyBoxed a1 = new A1MapKeyBoxed();
        a1.testMapKey(1L);
        a1.testAssign();
    }

    private void testAssign() {
        Map<String, String> map1 = new HashMap<String, String>(){{put("a", "aaa");}};
        Map<String, String> map2 = map1;
        map1.put("b","bbbb");
        System.out.println(map2);
    }

    private void testMapKey(Long a2) {
        Long a1 = 1L;
        Long a3 = 1L;

        Map<Long, String> map = new HashMap<>();
        map.put(a1, "a1");
        if (!map.containsKey(a2)) {
            map.put(a2, "a2");
        }
        if (map.containsKey(a3)) {
            System.out.println(map.get(a3));
        }
    }

}
