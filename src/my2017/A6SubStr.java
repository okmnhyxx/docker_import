package my2017;

/**
 * Created by emi on 2017/6/16.
 */
public class A6SubStr {

    public static void main(String[] args) {
        A6SubStr a = new A6SubStr();
        a.testSubStr();
    }

    private void testSubStr() {
        String a = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<string xmlns=\"http://www.sd.sinotrans.com\"><?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<TallyResponse>\n" +
                "  <ResponseResult>N</ResponseResult>\n" +
                "  <ResponseDesc>服务接口请求信息中箱型：admin不存在！</ResponseDesc>\n" +
                "</TallyResponse></string>";


        String newa = a.substring(a.lastIndexOf("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"), a.indexOf("</string>"));
        System.out.println(newa);
    }
}
