package org.animopts.bean;

public class FormConstant {
	public static final String NAME_ERROR = "error";
	public static final String LOGIN_ERROR = "Invalid ID number or password";
	public static final String REGISTER_ERROR_CONFIRMPASSWORD = "Whoops, these passwords don't match";
	public static final String REGISTER_ERROR_IDNUMBER = "Please input a valid ID number";

	public static final String MANAGETUTOR_ID = "update";
	public static final String MANAGETUTOR_NAME_ACTION = "action";
	public static final String MANAGETUTOR_PENDINGPREFIX = "pending";
	public static final String MANAGETUTOR_ACTIVATEDPREFIX = "activated";
	public static final String MANAGETUTOR_DEACTIVATEDPREFIX = "deactivated";
	public static final String MANAGETUTOR_REJECTEDPREFIX = "rejected";
	public static final String MANAGETUTOR_ACTION_ACCEPT = "accept";
	public static final String MANAGETUTOR_ACTION_REJECT = "reject";
	public static final String MANAGETUTOR_ACTION_DEACTIVATE = "deactivated";
	public static final String MANAGETUTOR_ACTION_ACTIVATE = "activate";

	public static final String MANAGETUTEE_ID = "update";
	public static final String MANAGETUTEE_NAME_ACTION = "toggleAssign";
	public static final String MANAGETUTEE_ASSIGNEDPREFIX = "a";
	public static final String MANAGETUTEE_UNASSIGNEDPREFIX = "u";

	public String getMANAGETUTEE_ID() {
		return MANAGETUTEE_ID;
	}

	public String getMANAGETUTEE_NAME_ACTION() {
		return MANAGETUTEE_NAME_ACTION;
	}

	public String getMANAGETUTEE_ASSIGNEDPREFIX() {
		return MANAGETUTEE_ASSIGNEDPREFIX;
	}

	public String getMANAGETUTEE_UNASSIGNEDPREFIX() {
		return MANAGETUTEE_UNASSIGNEDPREFIX;
	}

	public String getMANAGETUTOR_ID() {
		return MANAGETUTOR_ID;
	}

	public String getMANAGETUTOR_NAME_ACTION() {
		return MANAGETUTOR_NAME_ACTION;
	}

	public String getMANAGETUTOR_PENDINGPREFIX() {
		return MANAGETUTOR_PENDINGPREFIX;
	}

	public String getMANAGETUTOR_ACTIVATEDPREFIX() {
		return MANAGETUTOR_ACTIVATEDPREFIX;
	}

	public String getMANAGETUTOR_DEACTIVATEDPREFIX() {
		return MANAGETUTOR_DEACTIVATEDPREFIX;
	}

	public String getMANAGETUTOR_REJECTEDPREFIX() {
		return MANAGETUTOR_REJECTEDPREFIX;
	}

	public String getMANAGETUTOR_ACTION_ACCEPT() {
		return MANAGETUTOR_ACTION_ACCEPT;
	}

	public String getMANAGETUTOR_ACTION_REJECT() {
		return MANAGETUTOR_ACTION_REJECT;
	}

	public String getMANAGETUTOR_ACTION_DEACTIVATE() {
		return MANAGETUTOR_ACTION_DEACTIVATE;
	}

	public String getMANAGETUTOR_ACTION_ACTIVATE() {
		return MANAGETUTOR_ACTION_ACTIVATE;
	}

	public String getNAME_ERROR() {
		return NAME_ERROR;
	}

	public String getLOGIN_ERROR() {
		return LOGIN_ERROR;
	}

	public String getREGISTER_ERROR_CONFIRMPASSWORD() {
		return REGISTER_ERROR_CONFIRMPASSWORD;
	}

	public String getREGISTER_ERROR_IDNUMBER() {
		return REGISTER_ERROR_IDNUMBER;
	}

}
