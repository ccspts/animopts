package org.animopts.bean;

import java.io.Serializable;

public class TutorSchedule implements Serializable {

	public static final String TABLE_NAME = "tutorschedule";
	public static final String COL_ID = "tutorscheduleid";
	public static final String COL_DAY = "day";
	public static final String COL_TIME = "time";
	public static final String COL_ACTIVATEDTUTORID = "activatedtutorid";

	public String getCOL_ID() {
		return COL_ID;
	}

	public String getCOL_DAY() {
		return COL_DAY;
	}

	public String getCOL_TIME() {
		return COL_TIME;
	}

	public String getCOL_ACTIVATEDTUTORID() {
		return COL_ACTIVATEDTUTORID;
	}

	private String day;
	private String time;

	public TutorSchedule() {

	}

	public String getDay() {
		return day;
	}

	public String getTime() {
		return time;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
