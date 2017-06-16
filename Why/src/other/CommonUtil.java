package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @param orderBeginTime  当前时间点
	 * @param degree  1:分钟    2:小时    3:天   为单位
	 * @param outDegree  超时时间
	 * @param flag  true:生成之后的时间   false:生成之前的时间
	 * @return
	 * @throws ParseException
	 * 	 * 获取outDay天后的时间
	 */
	public static Date generateOrdrTimeOut(Date date,int degree,int outDegree,boolean flag) throws ParseException {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		if(flag) {
			if(1 == degree) {
				int minute =  cld.get(Calendar.MINUTE) + outDegree;
				cld.set(Calendar.MINUTE, minute);
			} else if(2 == degree) {
				int hour = cld.get(Calendar.HOUR) + outDegree;
				cld.set(Calendar.HOUR, hour);
			} else if(3 == degree) {
				int day = cld.get(Calendar.DATE) + outDegree;
				cld.set(Calendar.DATE, day);
			}
		} else {
			if(1 == degree) {
				int minute =  cld.get(Calendar.MINUTE) - outDegree;
				cld.set(Calendar.MINUTE, minute);
			} else if(2 == degree) {
				int hour = cld.get(Calendar.HOUR) - outDegree;
				cld.set(Calendar.HOUR, hour);
			} else if(3 == degree) {
				int day = cld.get(Calendar.DATE) - outDegree;
				cld.set(Calendar.DATE, day);
			}
		}
		return cld.getTime();
	}
	
	/**
	 * 生成随机字符串
	 * @param length  随机字符串长度
	 * @param type	  1:数字    2:字母   3及其他:数字和字符串类型
	 * @return
	 */
	public static String generateRandom(int length,int type) {
		if(1 == type) {
			Random r = new Random();
			int randNum = 0;
			while(randNum < 100000) {
				randNum = (int) r.nextInt(999999);  
			}
			return randNum + "";
		}
		String base = null;	
		if (2 == type) {
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
	    return sb.toString();   
	}
	
	public static void main(String[] args) throws ParseException {
//		Date d = generateOrdrTimeOut(new Date(), 1, 60, false);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(d));


//		testHourAndHourOfYear(15);
		testCalender();
	}



	public static void testHourAndHourOfYear(int hour) {
		Calendar calendar = Calendar.getInstance();
		int h = calendar.get(Calendar.HOUR);
		int hd = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(h);
		System.out.println(hd);


		calendar = Calendar.getInstance();
		System.out.println(sdf.format(calendar.getTime()));

		calendar.set(Calendar.HOUR, hour);//todo: HOUR 12   HOUR_OF_DAY 24
		System.out.println(sdf.format(calendar.getTime()));

		calendar.set(Calendar.HOUR_OF_DAY, hour);//todo: HOUR 12   HOUR_OF_DAY 24
		System.out.println(sdf.format(calendar.getTime()));

	}

	public static void testCalender() {

		Calendar calendar = Calendar.getInstance();
		System.out.println(sdf.format(calendar.getTime()));

		calendar.add(Calendar.DATE, 1);
		System.out.println(sdf.format(calendar.getTime()));

		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(sdf.format(calendar.getTime()));

		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_WEEK, 1);
		System.out.println(sdf.format(calendar.getTime()));

	}
}
