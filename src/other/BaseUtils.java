package other;


import org.apache.commons.lang3.StringUtils;
import other.common.DateFormatType;
import other.common.RandomType;
import other.common.TimeUnitType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @author kexia.lu on 2017/8/31.
 */
public class BaseUtils {




    /**
     * 生成随机字符串
     * @param length  随机字符串长度
     * @param type	  1:数字    2:字母   3及其他:数字和字符串类型
     * @return 随机字符串
     */
    public static String generateRandom(int length, RandomType type) {

        if (length < 1) {
            return "";
        }
        String base = null;
        if (RandomType.Number == type) {
            base = "0123456789";
        } else if (RandomType.Chars == type) {
            base = "abcdefghijklmnopqrstuvwxyz";
        } else {
            base = "abcdefghijklmnopqrstuvwxyz0123456789";
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        if (sb.substring(0,1).equals("0")) {
            return (new Random().nextInt(9) + 1) + sb.substring(1);
        }
        return sb.toString();
    }

    /**
     * 以date为基础，生成之前或之后的时间，
     * @param date  当前时间点
     * @param unitType  1:分钟    2:小时    3:天   4:月 为单位
     * @param outDegree  超时时间
     * @param ifAfter  true:生成之后的时间   false:生成之前的时间
     * @return  生成相应的时间
     */
    public static Date generateTimeOut(Date date, TimeUnitType unitType, int outDegree, boolean ifAfter) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        int degree = unitType.ordinal();
        if (ifAfter) {
            if (0 == degree) {
                int minute =  cld.get(Calendar.MINUTE) + outDegree;
                cld.set(Calendar.MINUTE, minute);
            } else if (1 == degree) {
                int hour = cld.get(Calendar.HOUR) + outDegree;
                cld.set(Calendar.HOUR, hour);
            } else if (2 == degree) {
                int day = cld.get(Calendar.DATE) + outDegree;
                cld.set(Calendar.DATE, day);
            } else if (3 == degree) {
                int month = cld.get(Calendar.MONTH) + outDegree;
                cld.set(Calendar.MONTH, month);
            }
        } else {
            if (0 == degree) {
                int minute =  cld.get(Calendar.MINUTE) - outDegree;
                cld.set(Calendar.MINUTE, minute);
            } else if (1 == degree) {
                int hour = cld.get(Calendar.HOUR) - outDegree;
                cld.set(Calendar.HOUR, hour);
            } else if (2 == degree) {
                int day = cld.get(Calendar.DATE) - outDegree;
                cld.set(Calendar.DATE, day);
            } else if (3 == degree) {
                int month = cld.get(Calendar.MONTH) - outDegree;
                cld.set(Calendar.MONTH, month);
            }
        }
        return cld.getTime();
    }



    /**
     * 将对象转为x-www-form-urlencoded兼容的字符串格式（属性必须有get方法）
     * @param object 要转换的对象
     * @return
     */
    public static String generateFormParams(Object object) {
        if (null == object) {
            return "";
        }

        Field[] fields = object.getClass().getDeclaredFields();
        if (fields.length == 0) {
            try {
                object = object.getClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i].getName()).append("=").append(fetchFieldValueByName(fields[i].getName(), object)).append("&");
        }
        String resultStr = sb.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

    /**
     * 将参数列表用‘、’合并
     * @param params 要转换的参数列表
     * @return
     */
    public static String generateParamsStr(Object... params) {
        if (null == params) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            sb.append(params[i]).append("、");
        }
        String resultStr = sb.toString();
        return resultStr.substring(0, resultStr.length() - 1);
    }

//    /**
//     * 将传输对象放入MultiValueMap中（属性必须有get方法）
//     * @param object 要转换的对象
//     * @return
//     */
//    public static MultiValueMap<String, String> generateMapsFromDto(Object object) {
//        if (null == object) {
//            return new LinkedMultiValueMap<>();
//        } else {
//            Field[] fields = object.getClass().getDeclaredFields();
//            if (fields.length == 0) {
//                try {
//                    object = object.getClass().newInstance();
//                } catch (IllegalAccessException | InstantiationException var4) {
//                    var4.printStackTrace();
//                    return new LinkedMultiValueMap<>();
//                }
//            }
//
//            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//            for (int i = 0; i < fields.length; ++i) {
//                map.set(fields[i].getName(), fetchFieldValueByName(fields[i].getName(), object));
//            }
//
//            return map;
//        }
//    }
//
//    /**
//     * 将传输对象放入MultiValueMap中（属性必须有get方法）
//     * @param object 要转换的对象
//     * @return
//     */
//    public static MultiValueMap<String, Object> generateMapsObjFromDto(Object object) {
//        if (null == object) {
//            return new LinkedMultiValueMap<>();
//        } else {
//            Field[] fields = object.getClass().getDeclaredFields();
//            if (fields.length == 0) {
//                try {
//                    object = object.getClass().newInstance();
//                } catch (IllegalAccessException | InstantiationException var4) {
//                    var4.printStackTrace();
//                    return new LinkedMultiValueMap<>();
//                }
//            }
//
//            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//            for (int i = 0; i < fields.length; ++i) {
//                map.set(fields[i].getName(), fetchFieldValueByName(fields[i].getName(), object));
//            }
//
//            return map;
//        }
//    }



//    /**
//     * @return 当前整点小时数的时间磋
//     */
//    public static long generateCurrentIntegralHourMillis() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        return calendar.getTimeInMillis();
//    }

    /**
     * long型时间转字符串
     * @param formatType 见DateFormatType
     * @param createTime 时间磋
     * @return
     */
    public static String dateLong2Str(DateFormatType formatType, long createTime) {
        if (0 == createTime) {
            return "/";
        }
        return new SimpleDateFormat(formatType.getFormat()).format(new Date(createTime));
    }

    /**
     * string型时间转long
     * @param formatType 见DateFormatType
     * @param createTime 时间磋
     * @return
     */
    public static long dateStr2Long(DateFormatType formatType, String createTime) {
        if (StringUtils.isEmpty(createTime)) {
            return 0;
        }
        return dateStr2Date(formatType, createTime).getTime();
    }

    /**
     * string型时间转Date
     * @param formatType 见DateFormatType
     * @param createTime 时间磋
     * @return
     */
    public static Date dateStr2Date(DateFormatType formatType, String createTime) {
        if (StringUtils.isEmpty(createTime)) {
            return null;
        }
        try {
            return new SimpleDateFormat(formatType.getFormat()).parse(createTime);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 用这个方法的话，属性必须有get方法，否则值为""
     */
    private static String fetchFieldValueByName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter);
            Object value = method.invoke(object);
            return null == value ? "" : value + "";
        } catch (Exception e) {
            return "";
        }
    }


    private static class HasValueVo {

        private boolean hasValue;

        private Object value;

        public HasValueVo() {
        }

        public HasValueVo(Object value) {
            this.hasValue = true;
            this.value = value;
        }

        public boolean isHasValue() {
            return hasValue;
        }

        public Object getValue() {
            return value;
        }

    }
}
