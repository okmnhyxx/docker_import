package my2015;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class B9Date {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private void doTest() throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYYMMDDhhmmss");
		String date1 = "20150506172612";
		String date2 = "20150506072612";

		System.out.println("sdf1: " + sdf1.parse(date1));
		System.out.println("sdf2: " + sdf2.parse(date1));
		System.out.println("sdf1: " + sdf1.parse(date2));
		System.out.println("sdf2: " + sdf2.parse(date2));

		System.out.println("sdf1: " + sdf1.format(new Date()));
		System.out.println("sdf2: " + sdf2.format(new Date()));
	}


	private void testCalendar() throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		Date date1 = sdf1.parse("2015-11-17 18:46");
		Date date2 = sdf1.parse("2015-11-17 10:46");
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(date1);
		calendar2.setTime(date2);
		int hour1 = calendar1.get(Calendar.HOUR_OF_DAY);
		int hour2 = calendar2.get(Calendar.HOUR_OF_DAY);
		System.out.println(" 1 : " + hour1);
		System.out.println(" 2 : " + hour2);
	
	}

	private void testCalendar2() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(sdf.format(date));
		System.out.println(" YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println(" MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println(" DATE: " + calendar.get(Calendar.DATE));
		System.out.println(" HOUR: " + calendar.get(Calendar.HOUR));
		System.out.println(" MINUTE: " + calendar.get(Calendar.MINUTE));
		System.out.println(" SECOND: " + calendar.get(Calendar.SECOND));
		System.out.println(" DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(" DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(" DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println(" DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println(" HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));

//		calendar.set(Calendar.HOUR, 0);//是12点
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date1 = calendar.getTime();
		System.out.println(sdf.format(date1));
	}

	
	public static void main(String[] args) throws ParseException {
		B9Date b = new B9Date();
//		b.doTest();
//		b.testCalendar();
		b.testCalendar2();
	}
}
