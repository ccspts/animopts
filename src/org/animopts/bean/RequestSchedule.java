package org.animopts.bean;

import java.io.Serializable;

public class RequestSchedule implements Serializable {

	public static final String TABLE_NAME = "requestschedule";
	public static final String COL_ID = "requestscheduleid";
	public static final String COL_DAY = "day";
	public static final String COL_TIME = "time";
	public static final String COL_REQUESTTUTORID = "requesttutorid";

	public String getCOL_ID() {
		return COL_ID;
	}

	public String getCOL_DAY() {
		return COL_DAY;
	}

	public String getCOL_TIME() {
		return COL_TIME;
	}

	public String getCOL_REQUESTTUTORID() {
		return COL_REQUESTTUTORID;
	}

	private Day day;
	private String time;

	public RequestSchedule() {

	}

	public Day getDay() {
		return day;
	}

	public String getTime() {
		return time;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
