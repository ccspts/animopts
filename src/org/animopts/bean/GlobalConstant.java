package org.animopts.bean;

import org.animopts.controller.UrlPatternEnum;

public class GlobalConstant {

	public static final String NAME_TUTOR_STATUS = "status";
	public static final String VALUE_TUTOR_STATUS_PENDING = "pending";
	public static final String VALUE_TUTOR_STATUS_REJECTED = "rejected";

	public static final String NAME_REDIRECT_PAGE = "redirectpage";
	public static final String NAME_SCHEDULE = "schedule";

	public String getNAME_REDIRECT_PAGE() {
		return NAME_REDIRECT_PAGE;
	}

	public String getNAME_SCHEDULE() {
		return NAME_SCHEDULE;
	}

	public String getNAME_TUTOR_STATUS() {
		return NAME_TUTOR_STATUS;
	}

	public String getVALUE_TUTOR_STATUS_PENDING() {
		return VALUE_TUTOR_STATUS_PENDING;
	}

	public String getVALUE_TUTOR_STATUS_REJECTED() {
		return VALUE_TUTOR_STATUS_REJECTED;
	}

	// Pages\
	public static final String HOME = "index.jsp";
	public static final String REGISTER = "/register.jsp";
	public static final String REQUEST_TUTOR = "/request-tutor.jsp";
	public static final String APPLY_TUTOR = "/apply-tutor.jsp";
	public static final String LOGIN = "/login.jsp";
	public static final String LOGOUT = UrlPatternEnum.LOGOUT.getValue();
	public static final String DASHBOARD = "/dashboard.jsp";
	public static final String MYTUTORS = "/dashboard/mytutors.jsp";
	public static final String MYPROFILE = "/dashboard/myprofile.jsp";
	public static final String MANAGETUTEE = "/dashboard/managetutee.jsp";
	public static final String CONFIRM = "confirm.jsp";
	public static final String MYTUTEES = "/dashboard/mytutees.jsp";
	public static final String UPDATETUTOR = "/dashboard/updatetutor.jsp";
	public static final String UPDATETUTORSUCCESS = "/dashboard/updatetutorsuccess.jsp";
	public static final String MANAGETUTOR = "/dashboard/managetutor.jsp";
	public static final String EVALUATION = "/dashboard/evaluation.jsp";
	public static final String MYEVALUATION = "/dashboard/myevaluation.jsp";
	public static final String MANAGEEVALUATION = "/dashboard/manageevaluation.jsp";
	public static final String MANAGEOFFICER = "/dashboard/manageofficer.jsp";
	public static final String BROWSETUTOR = "/browse-tutor.jsp";
	public static final String NOPERMISSION = "/dashboard/no-permission.jsp";

	// Images
	public final String NO_AVATAR = "img/no_avatar.jpg";
	public final String TEMP_CAPTCHA = "img/temp_captcha.gif";
	public final String LOGO = "img/logo.png";

	public String getHOME() {
		return formatGetter(HOME);
	}

	public String getREGISTER() {
		return formatGetter(REGISTER);
	}

	public String getREQUEST_TUTOR() {
		return formatGetter(REQUEST_TUTOR);
	}

	public String getAPPLY_TUTOR() {
		return formatGetter(APPLY_TUTOR);
	}

	public String getLOGIN() {
		return formatGetter(LOGIN);
	}

	public String getLOGOUT() {
		return formatGetter(LOGOUT);
	}

	public String getDASHBOARD() {
		return formatGetter(DASHBOARD);
	}

	public String getMYTUTORS() {
		return formatGetter(MYTUTORS, PageSection.DASHBOARD);
	}

	public String getMYPROFILE() {
		return formatGetter(MYPROFILE, PageSection.DASHBOARD);
	}

	public String getMANAGETUTEE() {
		return formatGetter(MANAGETUTEE, PageSection.DASHBOARD);
	}

	public String getCONFIRM() {
		return formatGetter(CONFIRM);
	}

	public String getMYTUTEES() {
		return formatGetter(MYTUTEES, PageSection.DASHBOARD);
	}

	public String getUPDATETUTOR() {
		return formatGetter(UPDATETUTOR, PageSection.DASHBOARD);
	}

	public String getMANAGETUTOR() {
		return formatGetter(MANAGETUTOR, PageSection.DASHBOARD);
	}

	public String getEVALUATION() {
		return formatGetter(EVALUATION, PageSection.DASHBOARD);
	}

	public String getMYEVALUATION() {
		return formatGetter(MYEVALUATION, PageSection.DASHBOARD);
	}

	public String getMANAGEEVALUATION() {
		return formatGetter(MANAGEEVALUATION, PageSection.DASHBOARD);
	}

	public String getMANAGEOFFICER() {
		return formatGetter(MANAGEOFFICER, PageSection.DASHBOARD);
	}

	public String getBROWSETUTOR() {
		return formatGetter(BROWSETUTOR);
	}

	// Images

	public String getNO_AVATAR() {
		return formatGetter(NO_AVATAR);
	}

	public String getLOGO() {
		return formatGetter(LOGO);
	}

	public String getTEMP_CAPTCHA() {
		return formatGetter(TEMP_CAPTCHA);
	}

	private String formatGetter(String url) {
		return formatGetter(url, PageSection.NONE);
	}

	private String formatGetter(String url, PageSection s) {
		return url;
	}
}
