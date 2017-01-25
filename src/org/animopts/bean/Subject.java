package org.animopts.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable {

	public static final String TABLE_NAME = "subjecttopic";
	public static final String COL_ID = "subjectid";
	public static final String COL_NAME = "subjectname";
	public static final String COL_ISOFFERED = "isoffered";

	public String getCOL_ID() {
		return COL_ID;
	}

	public String getCOL_NAME() {
		return COL_NAME;
	}

	public String getCOL_ISOFFERED() {
		return COL_ISOFFERED;
	}

	private int id;
	private String name;
	private ArrayList<Tag> tagList;
	private boolean isOffered;

	public Subject() {
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

	public Tag[] getTagList() {
		return tagList.toArray(new Tag[tagList.size()]);
	}

	public void setTagList(ArrayList<Tag> tagList) {
		this.tagList = tagList;
	}

	public boolean getIsOffered() {
		return isOffered;
	}

	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}

}
