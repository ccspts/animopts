package org.animopts.bean;

import java.io.Serializable;

public class PendingTutor extends Account implements Serializable {

	public static final String TABLE_NAME = "pendingtutor";
	public static final String COL_CURRINVOLVEMENT = "currinvolvement";
	public static final String COL_REASONFORJOINING = "reasonforjoining";

	public String getCOL_CURRINVOLVEMENT() {
		return COL_CURRINVOLVEMENT;
	};

	public String getCOL_REASONFORJOINING() {
		return COL_REASONFORJOINING;
	}

	private String currentInvolvements;
	private String reasonForJoining;

	public PendingTutor() {

	}

	public String getCurrentInvolvements() {
		return currentInvolvements;
	}

	public void setCurrentInvolvements(String currentInvolvements) {
		this.currentInvolvements = currentInvolvements;
	}

	public String getReasonForJoining() {
		return reasonForJoining;
	}

	public void setReasonForJoining(String reasonForJoining) {
		this.reasonForJoining = reasonForJoining;
	}

}
