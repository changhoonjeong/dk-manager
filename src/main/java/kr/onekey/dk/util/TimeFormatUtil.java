package kr.onekey.dk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeFormatUtil {
	
	public static Date currentTime() { return Calendar.getInstance(Locale.KOREA).getTime(); }
	
	public static String getTimeStamp() { return getTimeStamp(currentTime().getTime()); }
    public static String getTimeStamp(long time) {
    	SimpleDateFormat sdf_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	SimpleDateFormat sdf_time = new SimpleDateFormat("yyyy-MM-dd");
        sdf_time.setTimeZone(TimeZone.getTimeZone("ROK"));
    	return sdf_time.format(new Date(time));
	}

	public static Date stringToDate(String strDate){

		try {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = transFormat.parse(strDate);
			return date;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static Date stringToMonth(String strDate){

		try {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM");
			Date date = transFormat.parse(strDate);
			return date;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static Date stringToYear(String strDate){

		try {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy");
			Date date = transFormat.parse(strDate);
			return date;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static Date stringToDateTime(String strDate){

		try {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = transFormat.parse(strDate);
			return date;
		} catch (ParseException p){
			throw new RuntimeException("날짜 데이터가 올바르지 않습니다.");
		} catch (Exception e){
//			e.printStackTrace();
			return null;
		}
	}

	public static Date DateToNextDay(String strDate){

		try {
			Date today = stringToDate(strDate);
			Date nextDay = new Date(today.getTime() + (1000 * 60 * 60 * 24));
			return nextDay;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
