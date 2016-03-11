package my2013.my2013071620;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo17 {

//	public void doFormat(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
//		Date d = new Date();    
//		Date ddd;  
//		try {   
//			ddd = sdf.parse(sdf.format(d));   
//			System.out.println("d>>>>  "+sdf.format(d));   
//			System.out.println("ddd>>>  "+sdf.format(ddd));  
//		} catch (ParseException e) {  
//			e.printStackTrace();
//		}
//	}
	
	public void doFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd  HH: mm: ss"); 
		Date d1 = new Date();
		Date d2;
		try {
			d2 = sdf.parse(sdf.format(d1));
			System.out.println("d1:  " + sdf.format(d1));
			System.out.println("d2:  " + sdf.format(d2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getMyTime() {
		Date date = new Date();//当前日期  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//格式化对象  
		Calendar calendar = Calendar.getInstance();
		//日历对象  
		calendar.setTime(date);
		//设置当前日期  
		calendar.add(Calendar.MONTH, -3);
		
		//月份减一  
		System.out.println("1-------------------"+sdf.format(new Date()));
		System.out.println("2-------------------"+sdf.format(calendar.getTime()));
		//输出格式化的日期
	}
	
	public Date getDateBefore(Date d,int day){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar now =Calendar.getInstance();  
//		now.setTime(d);
//		now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
		now.add(Calendar.DATE,-day);
		System.out.println(sdf.format(now.getTime()));
		return now.getTime();  
	}

	
	public void getFristLast() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();  
		// 不加下面2行，就是取当前时间前一个月的第一天及最后一天
		cal.set(Calendar.YEAR,2012);  
		cal.set(Calendar.MONTH, 0);  
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -2);
		Date lastDate = cal.getTime();
		System.out.println(sdf.format(lastDate));
		
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDate = cal.getTime();
		
		System.out.println(sdf.format(firstDate));
	}
	
	public static void main(String[] args) {
		DateDemo17 dd = new DateDemo17();
		dd.doFormat();
//		dd.getMyTime();
//		dd.getDateBefore(new Date(),11);
//		dd.getFristLast();
	}
}
