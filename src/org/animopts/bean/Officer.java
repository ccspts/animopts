package org.animopts.bean;

public class Officer extends ActivatedTutor {
	
	public static final String TABLE_NAME = "officer";
	public final static String COL_ACTIVATEDTUTORID = "activatedtutorid";
	public final static String COL_OFFICERPOSITIONID = "officerpositionid";
	public static final String COL_OFFICERTITLE = "officertitle";
	
	public static String getColActivatedtutorid() {
		return COL_ACTIVATEDTUTORID;
	}
	public static String getColOfficerpositionid() {
		return COL_OFFICERPOSITIONID;
	}
	public static String getTableName() {
		return TABLE_NAME;
	}
	
	private String officertitle;
	private String officerpositionid;

	public String getOfficerpositionid() {
		return officerpositionid;
	}
	public void setOfficerpositionid(String officerpositionid) {
		this.officerpositionid = officerpositionid;
	}
	public static String getColOfficertitle() {
		return COL_OFFICERTITLE;
	}
	public String getOfficertitle() {
		return officertitle;
	}
	public void setOfficertitle(String officertitle) {
		this.officertitle = officertitle;
	}
	
	
}
