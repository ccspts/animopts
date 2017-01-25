package org.animopts.bean;

import java.io.Serializable;

public class RejectedTutor extends Account implements Serializable {

	public static final String TABLE_NAME = "rejectedtutor";
	public static final String COL_REJECTIONREASON = "rejectionreason";

	public String getCOL_CURRINVOLVEMENT() {
		return COL_REJECTIONREASON;
	};

	private String rejectionReason;

	public RejectedTutor() {

	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
}
