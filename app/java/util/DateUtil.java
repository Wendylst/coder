package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String changeDate(Date dt){
		SimpleDateFormat sd = 
				new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(dt);
		
	}
	
	public static Date changeDate(java.sql.Date dt){
		return new Date(dt.getTime());
	}
	public static java.sql.Date changeSqlDate(String dt) {
		Date d = changeDate(dt);
		return new java.sql.Date(d.getTime());
	}
	public static Date changeDate(String dt) {
		SimpleDateFormat sd = 
				new SimpleDateFormat("yyyy-mm-dd");
		try {
			return sd.parse(dt);
		} catch (ParseException e) {
			
		}
		return new Date();
	}

}
