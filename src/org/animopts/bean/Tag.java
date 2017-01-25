package org.animopts.bean;

import java.io.Serializable;

public class Tag implements Serializable {

	public static final String TABLE_NAME = "tag";
	public static final String COL_ID = "subjectid";
	public static final String COL_SUBJECTID = "subjectid";
	public static final String COL_NAME = "tagname";

	public String getCOL_ID() {
		return COL_ID;
	}

	public String getCOL_SUBJECTID() {
		return COL_SUBJECTID;
	}

	public String getCOL_NAME() {
		return COL_NAME;
	}

	private int id;
	private String name;

	public Tag() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
