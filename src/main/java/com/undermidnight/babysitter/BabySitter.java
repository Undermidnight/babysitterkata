package com.undermidnight.babysitter;

public class BabySitter {

	public static int EARLIEST_START_TIME = 5; // 5 PM
	public static int LATEST_START_TIME = 16; // 4 AM
	public static int START_TIME_TO_BEDTIME_RATE = 12;
	
	public int calculatePay(int startTime, int endTime, int bedTime) {
		int pay = 0;
		int totalPay = 0;
		
		for (int hourWorked = startTime; hourWorked < endTime; hourWorked++) {
			// Check before bed pay
			if( isBeforeBedPay(bedTime, hourWorked)) {
				pay = START_TIME_TO_BEDTIME_RATE;
			}
			totalPay+=pay;
		}
		return totalPay;
	}

	private boolean isBeforeBedPay(int bedTime, int hourWorked) {
		return hourWorked < bedTime && hourWorked >= EARLIEST_START_TIME;
	}
}
