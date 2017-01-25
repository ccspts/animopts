package org.animopts.bean;

import java.io.Serializable;

public class RequestTutor implements Serializable {
	// table
	public static final String TABLE_NAME = "requesttutor";

	// col
	public static final String COL_REQUESTTUTORID = "requesttutorid";
	public static final String COL_TUTEEID = "tuteeid";
	public static final String COL_PREFTUTORID = "preftutorid";
	public static final String COL_ASSIGNEDTUTORID = "assignedtutorid";
	public static final String COL_SUBJECTID = "subjectid";
	public static final String COL_YEAR = "year";
	public static final String COL_TERM = "term";
	public static final String COL_TUTORIALTYPE = "tutorialtype";

	public String getCOL_REQUESTTUTORID() {
		return COL_REQUESTTUTORID;
	}

	public String getCOL_TUTEEID() {
		return COL_TUTEEID;
	}

	public String getCOL_PREFTUTORID() {
		return COL_PREFTUTORID;
	}

	public String getCOL_ASSIGNEDTUTORID() {
		return COL_ASSIGNEDTUTORID;
	}

	public String getCOL_SUBJECTID() {
		return COL_SUBJECTID;
	}

	public String getCOL_YEAR() {
		return COL_YEAR;
	}

	public String getCOL_TERM() {
		return COL_TERM;
	}

	public String getCOL_TUTORIALTYPE() {
		return COL_TUTORIALTYPE;
	}

	private int id;
	private Account tutee;
	private Account preferredTutor;
	private Account tutor;
	private Subject subj;
	private int year;
	private int term;
	private TuteeTypeOfTutorialEnum tutorialType;
	private RequestSchedule[] requestSchedule;
	private ActivatedTutor[] possibleTutor;

	public RequestTutor() {

	}

	public RequestTutor(Account tutor, Subject subj) {
		super();
		this.tutor = tutor;
		this.subj = subj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getTutor() {
		return tutor;
	}

	public void setTutor(Account tutor) {
		this.tutor = tutor;
	}

	public Subject getSubj() {
		return subj;
	}

	public void setSubj(Subject subj) {
		this.subj = subj;
	}

	public Account getTutee() {
		return tutee;
	}

	public Account getPreferredTutor() {
		return preferredTutor;
	}

	public int getYear() {
		return year;
	}

	public int getTerm() {
		return term;
	}

	public TuteeTypeOfTutorialEnum getTutorialType() {
		return tutorialType;
	}

	public void setTutee(Account tutee) {
		this.tutee = tutee;
	}

	public void setPreferredTutor(Account preferredTutor) {
		this.preferredTutor = preferredTutor;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public void setTutorialType(TuteeTypeOfTutorialEnum tutorialType) {
		this.tutorialType = tutorialType;
	}

	public RequestSchedule[] getRequestSchedule() {
		return requestSchedule;
	}

	public void setRequestSchedule(RequestSchedule[] requestSchedule) {
		this.requestSchedule = requestSchedule;
	}

	public ActivatedTutor[] getPossibleTutor() {
		return possibleTutor;
	}

	public void setPossibleTutor(ActivatedTutor[] possibleTutor) {
		this.possibleTutor = possibleTutor;
	}

}
