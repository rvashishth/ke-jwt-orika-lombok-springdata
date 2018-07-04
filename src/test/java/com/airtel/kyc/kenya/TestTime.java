package com.airtel.kyc.kenya;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

public class TestTime {

	@Test
	public void testTime(){
		Time time = new Time(System.currentTimeMillis());
		System.out.println("sql time: "+time);
		
		System.out.println("java date: "+new Date());
		
		System.out.println("sql date: "+new java.sql.Date(System.currentTimeMillis()));
	}
}
