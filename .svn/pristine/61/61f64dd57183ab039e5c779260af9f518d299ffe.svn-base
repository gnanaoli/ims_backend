package com.fa.inventory.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sDate="11-05-2018 23:00:00";
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		    Date parsedDate = dateFormat.parse(sDate);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    System.out.println("Time:"+timestamp);
		} catch(Exception e) { //this generic but you can control another types of exception
		    // look the origin of excption
			e.printStackTrace();
		}

	}

}
