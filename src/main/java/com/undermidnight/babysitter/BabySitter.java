package com.undermidnight.babysitter;

public class BabySitter {

	public static int EARLIEST_START_TIME = 5; // 5 PM
	public static int LATEST_START_TIME = 16; // 4 AM
	public static int START_TIME_TO_BEDTIME_RATE = 12;
	
	public int calculatePay(int startTime, int endTime, int bedTime) {
		int pay = 0;
		if(startTime >= EARLIEST_START_TIME && endTime <= bedTime) {
			pay = (endTime - startTime) * START_TIME_TO_BEDTIME_RATE;
		}
		return pay;
	}
}
