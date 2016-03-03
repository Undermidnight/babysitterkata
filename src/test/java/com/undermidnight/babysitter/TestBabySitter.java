package com.undermidnight.babysitter;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBabySitter extends TestCase {
	@Test
	public void testOneHourWithinStartTimeToBedTime() throws Exception {
		int bedTime = 9;
		BabySitter babySitter = new BabySitter();
		int pay = babySitter.calculatePay(5,6, bedTime);
		assertEquals(12, pay);
	}
	
//	@Test
//	public void testBedtimeToMidnight(int hours) throws Exception {
//		
//	}
//	
//	@Test
//	public void testMidnightToEndOfJob(int hours) throws Exception {
//		
//	}
//	
//	@Test
//	public void testFullNightsWork(int hours) throws Exception {
//		
//	}
}
