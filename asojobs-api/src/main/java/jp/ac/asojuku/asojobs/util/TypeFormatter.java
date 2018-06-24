package jp.ac.asojuku.asojobs.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class TypeFormatter {
	public static java.sql.Time convertStringToTime(String time) throws Exception{
	    DateFormat formatter = new SimpleDateFormat("HH:mm");
	    java.sql.Time timeValue = null;
	    try {
	    timeValue = new java.sql.Time(formatter.parse(time).getTime());
	    }catch(Exception e){
	    	throw new Exception(e);
	    }
	    return timeValue;
	}
	public static java.util.Date convertSqlDateToUtilDate(java.sql.Date sqlDate){
		 java.util.Date javaDate = null;
	        if (sqlDate != null) {
	            javaDate = new java.util.Date(sqlDate.getTime());
	        }
	     return javaDate;
	}
	public static String convertSqlDateToString(java.sql.Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String text = df.format(date);
		return text;
	}
	public static String  convertSqlTimeToString(java.sql.Time time){
		DateFormat formatter = new SimpleDateFormat("HH:mm");
	    String timeValue = null;
	    try {
	    	LocalTime localTime = time.toLocalTime();
	    	timeValue = localTime.toString();
		    }catch(Exception e){
		    	
		    }
		return timeValue;
	}
	public static java.sql.Date convertStringToDate(String value) throws Exception{
        //first convert string to java.util.Date object using SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = null;
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
		}
        
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
	}
	public static int convertStringToInt(String number){
		int result = Integer.parseInt(number);
		return result;
	}
	public static Integer convertStringToInteger(String number){
		Integer result = Integer.valueOf(number);
		return result;
	}

}
