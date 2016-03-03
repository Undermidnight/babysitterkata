package com.undermidnight.babysitter;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestBabySitter extends TestCase {
	
	BabySitter babySitter;
	int bedTime = 9;
	
	@Before
	public void setUp() throws Exception {
		babySitter = new BabySitter();
		babySitter.setBedTime(bedTime);
	}
	
	@Test
	public void testOneHourWithinStartTimeToBedTime() throws Exception {
		// Test One hour... 
		int pay = babySitter.calculatePay(5,6);
		assertEquals(12, pay);

		// Test start time to bedtime
		pay = babySitter.calculatePay(5, bedTime);
		assertEquals(48, pay);
		
		// Test exception case... (prior to start time of 5 pm)
		pay = babySitter.calculatePay(4, 6);
		assertEquals(12, pay);
	}
	
	@Test
	public void testBedtimeToMidnight() throws Exception {
		// Test one hour
		int pay = babySitter.calculatePay(10, 11);
		assertEquals(8, pay);
		
		// Test two hours
		pay = babySitter.calculatePay(10, 12);
		assertEquals(16, pay);
	}
	
	@Test
	public void testMidnightToEndOfJob() throws Exception {
		// Test one hour
		int pay = babySitter.calculatePay(12, 13);
		assertEquals(16, pay);
		
		// Test four hours
		pay = babySitter.calculatePay(12, 16);
		assertEquals(64, pay);
		
		// Test exception case... (submitting hours after 4 am)
		pay = babySitter.calculatePay(12, 18);
		assertEquals(64, pay);
	}

//	
//	@Test
//	public void testFullNightsWork() throws Exception {
//		
//	}
}
