package org.animopts.bean;

import java.io.Serializable;

public class ActivatedTutor extends Account implements Serializable {

	public static final String TABLE_NAME = "activatedtutor";
	public static final String COL_MAXTUTEECOUNT = "maxtutorcount";

	public static final String TABLE_PREFTUTORIAL_NAME = "preftutorial";
	public static final String COL_PREFTUTORIAL_ACTIVATEDTUTORID = "activatedtutorid";
	public static final String COL_PREFTUTORIAL_SOLO = "solo";
	public static final String COL_PREFTUTORIAL_PAIR = "pair";
	public static final String COL_PREFTUTORIAL_GROUP = "smallgroup";
	public static final String COL_PREFTUTORIAL_CLASSROOM = "classroom";

	public static final String TABLE_PREFSUBJECT_NAME = "prefsubject";
	public static final String COL_PREFSUBJECT_ACTIVATEDTUTORID = "activatedtutorid";
	public static final String COL_PREFSUBJECT_SUBJECTID = "subjectid";

	public static final String ID_ISUPDATED = "updated";

	public String getCOL_MAXTUTEECOUNT() {
		return COL_MAXTUTEECOUNT;
	}

	public String getID_ISUPDATED() {
		return ID_ISUPDATED;
	}

	public String getTABLE_PREFTUTORIAL_NAME() {
		return TABLE_PREFTUTORIAL_NAME;
	}

	public String getCOL_PREFTUTORIAL_ACTIVATEDTUTORID() {
		return COL_PREFTUTORIAL_ACTIVATEDTUTORID;
	}

	public String getCOL_PREFTUTORIAL_SOLO() {
		return COL_PREFTUTORIAL_SOLO;
	}

	public String getCOL_PREFTUTORIAL_PAIR() {
		return COL_PREFTUTORIAL_PAIR;
	}

	public String getCOL_PREFTUTORIAL_GROUP() {
		return COL_PREFTUTORIAL_GROUP;
	}

	public String getCOL_PREFTUTORIAL_CLASSROOM() {
		return COL_PREFTUTORIAL_CLASSROOM;
	}

	public String getCOL_PREFSUBJECT_ACTIVATEDTUTORID() {
		return COL_PREFSUBJECT_ACTIVATEDTUTORID;
	}

	public String getCOL_PREFSUBJECT_SUBJECTID() {
		return COL_PREFSUBJECT_SUBJECTID;
	}

	private int maxTuteeCount;
	private Subject[] preferredSubject;
	private TutorTypeOfTutorialEnum[] preferredTutorial;
	private TutorSchedule[] schedule;

	public ActivatedTutor() {

	}

	public int getMaxTuteeCount() {
		return maxTuteeCount;
	}

	public Subject[] getPreferredSubject() {
		return preferredSubject;
	}

	public TutorTypeOfTutorialEnum[] getPreferredTutorial() {
		return preferredTutorial;
	}

	public TutorSchedule[] getSchedule() {
		return schedule;
	}

	public void setMaxTuteeCount(int maxTuteeCount) {
		this.maxTuteeCount = maxTuteeCount;
	}

	public void setPreferredSubject(Subject[] preferredSubject) {
		this.preferredSubject = preferredSubject;
	}

	public void setPreferredTutorial(TutorTypeOfTutorialEnum[] preferredTutorial) {
		this.preferredTutorial = preferredTutorial;
	}

	public void setSchedule(TutorSchedule[] schedule) {
		this.schedule = schedule;
	}

}
