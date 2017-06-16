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
        A5UrlEncoder a = new A5UrlEncoder();

        String encodeStr = a.testEncode();
        a.testDecode(encodeStr);

        String escapeStr = a.testEscape();
        a.testUnEscape(escapeStr);
    }

    //转义
    private String testEscape() {
        String unescapeStr = "<name>king</name>";
        String escapeStr = StringEscapeUtils.escapeXml11(unescapeStr);
        System.out.println(escapeStr);
        return escapeStr;
    }

    //反转义
    private String testUnEscape(String escapeStr) {
        String unescapeStr = StringEscapeUtils.unescapeXml(escapeStr);
        System.out.println(unescapeStr);
        return unescapeStr;
    }


    //编码
    private String testEncode() throws UnsupportedEncodingException {

        String strTest = "?=abc?中%1&2<3,4>";
        strTest = URLEncoder.encode(strTest, "UTF-8");
        System.out.println(strTest);
        return strTest;
    }

    //解码
    private String testDecode(String encodeStr) throws UnsupportedEncodingException {
        String decodeStr = URLDecoder.decode(encodeStr,"UTF-8");
        System.out.println(decodeStr);
        return decodeStr;
    }


}
