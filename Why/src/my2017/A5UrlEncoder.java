package my2017;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by emi on 2017/6/15.
 */
public class A5UrlEncoder {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String encodeStr = A5UrlEncoder.testEncode();
        A5UrlEncoder.testDecode(encodeStr);

        String escapeStr = A5UrlEncoder.testEscape();
        A5UrlEncoder.testUnEscape(escapeStr);
    }

    public static String encode(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return str;
    }

    public static String decode(String str) {
        try {
            str = URLDecoder.decode(str,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return str;
    }

    //转义
    private static String testEscape() {
        String unescapeStr = "<name>king</name>";
        String escapeStr = StringEscapeUtils.escapeXml11(unescapeStr);
        System.out.println(escapeStr);
        return escapeStr;
    }

    //反转义
    private static String testUnEscape(String escapeStr) {
        String unescapeStr = StringEscapeUtils.unescapeXml(escapeStr);
        System.out.println(unescapeStr);
        return unescapeStr;
    }


    //编码
    private static String testEncode() throws UnsupportedEncodingException {

        String strTest = "?=abc?中%1&2<3,4>";
        return encode(strTest);
    }

    //解码
    private static String testDecode(String encodeStr) throws UnsupportedEncodingException {

        return decode(encodeStr);
    }


}
