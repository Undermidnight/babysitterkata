package com.undermidnight.babysitter;

public class BabySitter {

	public static int START_TIME = 5; // 5 PM
	public static int END_TIME = 16; // 4 AM
	public static int START_TIME_TO_BEDTIME_RATE = 12;
	public static int BEDTIME_TO_MIDNIGHT_RATE = 8;
	public static int MIDNIGHT_TO_END_TIME_RATE = 16;
	
	private int bedTime;

	public int calculatePay(int startTime, int endTime) {
		int pay = 0;
		int totalPay = 0;
		
		for (int hourWorked = startTime; hourWorked < endTime; hourWorked++) {
			if( isBeforeBedPay(hourWorked)) {
				pay = START_TIME_TO_BEDTIME_RATE;
			} else if (isBeforeMidnight(hourWorked)) {
				pay = BEDTIME_TO_MIDNIGHT_RATE;
			} else if (isAfterMidnight(hourWorked)) {
				pay = MIDNIGHT_TO_END_TIME_RATE;
			}
			totalPay+=pay;
			pay = 0;
		}
		return totalPay;
	}

	private boolean isBeforeBedPay(int hourWorked) {
		return hourWorked < bedTime && hourWorked >= START_TIME;
	}
	
	private boolean isBeforeMidnight(int hourWorked) {
		return hourWorked >= bedTime && hourWorked < 12;
	}
	
	private boolean isAfterMidnight(int hourWorked) {
		return hourWorked >= 12 && hourWorked < END_TIME;
	}

	public int getBedTime() {
		return bedTime;
	}

	public void setBedTime(int bedTime) {
		this.bedTime = bedTime;
	}
}
