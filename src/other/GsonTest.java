package other;

import other.common.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author kexia.lu on 2017/8/31.
 */
public class GsonTest {

    public static void main(String[] args) {
        GsonTest g = new GsonTest();
        g.testGson();
    }

    private void testGson() {

        Student student = null;
//        student = new Student(1, "emi");

//        String s = new Gson().toJson(student);
//        System.out.println(s);
//
        String s2 = generateFormParams(student, Student.class);
        System.out.println(s2);


    }

    /**
     * 将对象转为x-www-form-urlencoded兼容的字符串格式
     * @param object 要转换的对象
     * @param class_ 对象的Class
     * @return
     */
    public static String generateFormParams(Object object, Class class_) {
        if (null == object) {
            try {
                object = class_.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return "";
            }
        }

        Field[] fields = object.getClass().getDeclaredFields();
        if (fields.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAccessible()) {
                sb.append(fields[i].getName()).append("=").append(fetchFieldValue(fields[i], object)).append("&");
            } else {
                sb.append(fields[i].getName()).append("=").append(fetchFieldValueByName(fields[i].getName(), object)).append("&");
            }
        }
        String resultStr = sb.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

    /**
     * 用这个方法，属性没有get方法也可以转出其值
     */
    private static Object fetchFieldValue(Field field, Object object) {
        Object value = null;
        try {
            value = field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return null == value ? "" : value;
    }

    /**
     * 用这个方法的话，属性必须有get方法，否则值为""
     * @param fieldName
     * @param object
     * @return
     */
    private static Object fetchFieldValueByName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter);
            Object value = method.invoke(object);
            return null == value ? "" : value;
        } catch (Exception e) {
            //java.lang.NoSuchMethodException: other.common.Student.getAge()
            return "";
        }
    }
}
