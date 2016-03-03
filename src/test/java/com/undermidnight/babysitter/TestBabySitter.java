package com.undermidnight.babysitter;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBabySitter extends TestCase {
	@Test
	public void testOneHourWithinStartTimeToBedTime() throws Exception {
		int bedTime = 9;
		BabySitter babySitter = new BabySitter();
		
		// Test One hour... 
		int pay = babySitter.calculatePay(5,6, bedTime);
		assertEquals(12, pay);

		// Test start time to bedtime
		pay = babySitter.calculatePay(5, bedTime, bedTime);
		assertEquals(48, pay);
		
		// Test exception case... (prior to start time of 5)
		pay = babySitter.calculatePay(4, 6, bedTime);
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
