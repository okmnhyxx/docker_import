package my2015;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emi on 2015/12/16.
 */
public class C6LinkMap {

    private void test1() {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(map);
            System.out.println(map.entrySet());
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

    private void nullSize() {
        Gson gson = new Gson();
        List<String> stringList = new ArrayList<>();
        System.out.println(" --- strL: " + stringList + " ,size: " + stringList.size());
        String json = gson.toJson(stringList);
        System.out.println(" --- json: " + json);
        List<String> toList = gson.fromJson(json,new TypeToken<List<String>>() {}.getType());
        System.out.println(" --- toLt: " + toList);
    }

    public static void main(String[] args) {
        C6LinkMap c = new C6LinkMap();
        c.test1();
        c.nullSize();
    }

}
