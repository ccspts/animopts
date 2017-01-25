package org.animopts.bean;

import java.io.Serializable;

public class TermDetail implements Serializable {

	public static final String TABLE_NAME = "global";
	public static final String COL_YEAR = "year";
	public static final String COL_TERM = "term";

	public String getCOL_COL_YEAR() {
		return COL_YEAR;
	};

	public String getCOL_COL_TERM() {
		return COL_TERM;
	}

	private int year;
	private int term;

	public TermDetail() {

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}
