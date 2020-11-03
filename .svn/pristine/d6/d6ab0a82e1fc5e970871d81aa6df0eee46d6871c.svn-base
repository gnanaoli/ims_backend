
package com.fa.inventory.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Shankar
 */
public class MasterDateUtil {
	
	public static Timestamp converTimeStamp(String sDate)
	{
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    Date parsedDate = dateFormat.parse(sDate);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    System.out.println("Timestatmp:"+timestamp);
		    return timestamp;
		} catch(Exception e) { 
			e.printStackTrace();
			return null;
		}
	}
	/*public static Timestamp convertStringToTimeStampDate(String dateValue)  {
		Timestamp timestamp=null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date parsedDate = dateFormat.parse(dateValue);
			  timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) {
			return new Timestamp(new Date().getTime());
		}
		return timestamp;

	}*/
	
	public static Timestamp convertStringToTimeStampDate(String dateValue)  {
		//Timestamp timestamp=null;
		try {
			 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateValue);  
			 Timestamp timestamp=new Timestamp(date1.getTime());
			 return timestamp;
		} catch (Exception e) {
			return new Timestamp(new Date().getTime());
		}
	
	}

	public static Timestamp convertStringToDate(String dateValue) throws Exception {

		SimpleDateFormat dfFormat = new SimpleDateFormat("dd/MM/yyyy");
	
		return (Timestamp) dfFormat.parse(dateValue);

	}
	
	
	public static Date convertStringToDateWithoutTime(String dateValue) throws Exception {
		SimpleDateFormat dfFormat=null;
		Date date=null;
		try {
		  dfFormat = new SimpleDateFormat("dd/MM/yyyy");
		  date=dfFormat.parse(dateValue);
		 // System.out.println("date value"+date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;

	}
	
	
	public static String convertDateToString(Date date) throws Exception {

		if(date != null)
		{
			SimpleDateFormat dfFormat = new SimpleDateFormat("dd/MM/yyyy");

			return dfFormat.format(date);
		}
		else
		{
			return null;
		}
	}
	
	public static String convertDateToStringWithTime(Date date) throws Exception {

		SimpleDateFormat dfFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");

		return dfFormat.format(date);

	}

	public static Date getValidDate(String date) {
		Date mydate = null;
		if (isValidDateFormat(date)) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);
			try {
				mydate = dateFormat.parse(date);
			} catch (ParseException e) {
				mydate = null;
			}
		}
		return mydate;
	}

	public static boolean isValidDateFormat(String date) {
		String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
		boolean result = false;
		if (date.matches(pattern)) {
			result = true;
		}
		return result;
	}
	
	
	public static String datetoStringFormatter(Date value) {
		String val = "";
		if (value != null) {
			String DATE_FORMAT_NOW = "dd/MM/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			val = sdf.format(value);
		}
		return val;
	}
	
	public static Date convertDateToString(String value) /* throws ApplicationException */ {
		Date date = new Date();
		try {
			if (value != null) {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(value);
			} else {
				return null;
			}
		} catch (ParseException e) {
			try {
				date = new SimpleDateFormat("MM/dd/yyyy").parse(value);
			} catch (ParseException e1) {
				return null;
			}
		}
		return date;
	}
	
	
	public static String checkNull(String value)
	{
		if(value!=null && !value.isEmpty())
		{
			return value;
		}
		return "";
	}
	
	public static Long ConvertStringtoLong(String value)
	{
		if(value!=null && !value.isEmpty())
		{
			Long returnValue = Long.valueOf(value);
			return returnValue;
		}
		return null;		
	}
	
	public static Integer ConvertStringtoInteger(String value)
	{
		if(value!=null && !value.isEmpty())
		{
			Integer returnValue = Integer.valueOf(value);
			return returnValue;
		}
		return null;		
	}
	
	public static String ConvertIntegertoString(Integer value)
	{
		if(value!=null)
		{
			String returnValue = String.valueOf(value);
			return returnValue;
		}
		return null;		
	}
	
	public static String ConvertLongtoString(Long value)
	{
		if(value!=null)
		{
			String returnValue = String.valueOf(value);
			return returnValue;
		}
		return null;		
	}
	
	public static Calendar caculateServiceDueDate(Date purchaseDate,int month)
	{
		Calendar calc=Calendar.getInstance();
		calc.setTime(purchaseDate);
		//calc.add(Calendar.YEAR, year);
		calc.add(Calendar.MONTH, month);
		return calc;
	}
	
	public static Calendar caculateWarranty(int year,int month)
	{
		Calendar calc=Calendar.getInstance();
		calc.setTime(new Date());
		calc.add(Calendar.YEAR, year);
		calc.add(Calendar.MONTH, month);
		return calc;
	}
	
	public static Date convertCalendarToDate(Calendar calc)
	{
		Date date=null;
		try {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			
			String formatted = format1.format(calc.getTime());
			date=format1.parse(formatted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date convertFromStringToDate(String date) {
		try {
			/*if (StringUtils.isNotBlank(date)) {*/
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println(sdf.parse(date));
				return sdf.parse(date);
			/*} else {
				return new Date();
			}*/
		} catch (ParseException e) {
			return new Date();
		}
	}
	public static String convertTimeStampToString(Timestamp time)
	{
		String formattedDate=null;
		try {
			Date date = new Date();
			date.setTime(time.getTime());
			formattedDate = new SimpleDateFormat("ddMMyyyy").format(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formattedDate;
	}
	
	
	public static int getDifferenceDays(Date d1, Date d2) {
	    int daysdiff = 0;
	    long diff = d2.getTime() - d1.getTime();
	    long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
	    daysdiff = (int) diffDays;
	    return daysdiff;
	}
}