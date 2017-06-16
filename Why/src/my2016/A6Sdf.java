package my2016;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by emi on 2016/10/9.
 */
public class A6Sdf {

    public static void main(String[] args) {
        A6Sdf a = new A6Sdf();
        a.test();
    }

    private void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("2016/09/09".replace("/", "-"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }
}
