package other;

import com.google.gson.Gson;
import other.common.Book;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author kexia.lu on 2017/10/23.
 */
public class AssignUtils {

    public static void main(String[] args) throws NoSuchMethodException {

        AssignUtils assignUtils = new AssignUtils();
        WrapperResult<Book> obj = new WrapperResult<>(new Book());
        obj = assignUtils.autoAssignValue(obj);
        System.out.println(new Gson().toJson(obj.getResult()));
    }


    public <T> T autoAssignValue(T subObj) {

        if (null == subObj) {
            try {
                subObj = (T) subObj.getClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                return null;
            }
        }

        Field[] fields = ((T)subObj).getClass().getDeclaredFields();
        if (fields.length == 0) {
            return null;
        }

        for (Field f : fields) {
            Class<?> fieldType = f.getType();
//            String fieldClassName = fieldType.getSimpleName();
            if (isSimpleClass(fieldType)) {
                assignFieldValue(f, subObj, fetchSimpleFieldDefaultValue(fieldType));
            } else if (isListClass(fieldType)) {
                assignFieldValue(f, subObj, fetchListFieldDefaultValue(f));
            } else if (isSetClass(fieldType)) {
                assignFieldValue(f, subObj, fetchSetFieldDefaultValue(f));
            } else if (isMapClass(fieldType)) {
                assignFieldValue(f, subObj, fetchMapFieldDefaultValue(f));
            } else if (isArrayClass(fieldType)) {
                assignFieldValue(f, subObj, fetchArrayFieldDefaultValue(f));
            } else {
                try {
                    assignFieldValue(f, subObj, autoAssignValue(f.getType().newInstance()));
                } catch (InstantiationException | IllegalAccessException | RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }

        return subObj;
    }

    private <T> void assignFieldValue(Field field, Object object, T value) {
        try {
            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(setter, field.getType());
            if (field.getType() == long.class || field.getType() == Long.class) {
                value = (T)Long.valueOf((Integer)value);
            }
            method.invoke(object, (T)value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Type[] fetchTemplateType(Field field) {
        return ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
    }


    private boolean isListClass(Class class_) {
        return class_ == List.class || class_ == ArrayList.class || class_ == LinkedList.class;
    }

    private boolean isSetClass(Class class_) {
        return class_ == Set.class || class_ == HashSet.class || class_ == TreeSet.class;
    }

    private boolean isMapClass(Class class_) {
        return class_ == Map.class || class_ == HashMap.class || class_ == TreeMap.class;
    }

    private boolean isSimpleClass(Class<?> class_) {
        if (class_.isPrimitive()) {
            return true;
        }
        try {
            return ((Class) class_.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
        }
        if (isStrClass(class_)) {
            return true;
        }
        if (class_.isEnum()) {
            return true;
        }
        return false;
    }

    private boolean isArrayClass(Class class_) {
        return class_.isArray();
    }


    private boolean isStrClass(Class<?> fieldClass) {
        return fieldClass.getSimpleName().equals("String");
    }


    private Object fetchSimpleFieldDefaultValue(Class<?> type) {

        String className = type.getSimpleName();
        if (className.equals("short") || className.equals("Short")
                || className.equals("int") || className.equals("Integer")
                || className.equals("byte") || className.equals("Long")) {
            return 1;
        }
        if (className.equals("long") || className.equals("Long")) {
            return 1L;
        }
        if (className.equals("float") || className.equals("Float")
                || className.equals("double") || className.equals("double")) {
            return 1.0;
        }
        if (className.equals("boolean") || className.equals("Boolean")) {
            return false;
        }
        if (className.equals("String")) {
            return "string";
        }
        if (type.isEnum()) {
            return 0;
        }
        return null;
    }

    private <T> T fetchCollectGenericValue(T type) {
        T subObj = null;
        try {
            if (isSimpleClass((Class)type)) {
                subObj = (T)fetchSimpleFieldDefaultValue((Class)type);
            } else {
                subObj = (T)autoAssignValue(((Class)type).newInstance());
            }
        } catch (InstantiationException | IllegalAccessException | RuntimeException e) {
            e.printStackTrace();
            subObj = null;
        }
        return subObj;
    }

    private Object fetchListFieldDefaultValue(Field field) {

        Type type = fetchTemplateType(field)[0];
        String fieldClassName = type.getClass().getSimpleName();
        List list = fieldClassName.equals("LinkedList") ? new LinkedList<>() : new ArrayList<>(1);

        list.add(fetchCollectGenericValue(type));
        return list;
    }


    private Object fetchSetFieldDefaultValue(Field field) {

        Type type = fetchTemplateType(field)[0];
        String fieldClassName = type.getClass().getSimpleName();
        Set set = fieldClassName.equals("TreeSet") ? new TreeSet() : new HashSet(1);

        set.add(fetchCollectGenericValue(type));
        return set;
    }

    private Object fetchMapFieldDefaultValue(Field field) {

        Type[] types = fetchTemplateType(field);
        String fieldClassName = types[1].getClass().getSimpleName();
        Map map = fieldClassName.equals("TreeMap") ? new TreeMap() : new HashMap(1);

        map.put(fetchSimpleFieldDefaultValue(types[0].getClass()), fetchCollectGenericValue(types[1]));
        return map;
    }

    private <T> T[] fetchArrayFieldDefaultValue(Field field) {

        Type type = field.getType().getComponentType();
        Class<T> class_ = ((Class)type);

        T[] objArr = (T[])Array.newInstance(class_, 1);
        objArr[0] = fetchCollectGenericValue((T) type);
        return objArr;
    }

}
