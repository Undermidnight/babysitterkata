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
	}
	
	@Test
	public void testBedtimeToMidnight() throws Exception {
		// Test one hour
		int pay = babySitter.calculatePay(10, 11);
		assertEquals(8, pay);
		
		// Test two hours
		pay = babySitter.calculatePay(10, 12);
		assertEquals(16, pay);
		
		// Test bedtime to midnight
		pay = babySitter.calculatePay(bedTime, 12);
		assertEquals(24, pay);
	}
	
	@Test
	public void testMidnightToEndOfJob() throws Exception {
		// Test one hour
		int pay = babySitter.calculatePay(12, 13);
		assertEquals(16, pay);
		
		// Test four hours
		pay = babySitter.calculatePay(12, 16);
		assertEquals(64, pay);
	}
	
	@Test
	public void testFullNightsWork() throws Exception {
		
		// All night work... 
		int pay = babySitter.calculatePay(5, 16);
		assertEquals(136, pay);
		
	}
	
	@Test
	public void testMixedHoursWork() throws Exception {
		// 7pm to 2am
		int pay = babySitter.calculatePay(7, 14);
		assertEquals(80, pay);
		
		pay = babySitter.calculatePay(11, 15);
		assertEquals(56, pay);
	}
	
	@Test
	public void testExceptionCases() throws Exception
	{
		// Prior to start time of 5 pm
		int pay = babySitter.calculatePay(4, 6);
		assertEquals(12, pay);	
		
		// Submitting hours after 4 am
		pay = babySitter.calculatePay(12, 18);
		assertEquals(64, pay);
		
		// More hours than the allowed window
		pay = babySitter.calculatePay(4, 18);
		assertEquals(136, pay);
		
		// Odd numbers.. this one would only give the max pay
		pay = babySitter.calculatePay(-800, 800);
		assertEquals(136, pay);
		
		// Return zero
		pay = babySitter.calculatePay(800, -800);
		assertEquals(0, pay);
		
		// Return zero
		pay = babySitter.calculatePay(-800, -800);
		assertEquals(0, pay);
		
	}
}
