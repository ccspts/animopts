package org.animopts.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public enum UrlPatternEnum {
	NONE("/*"), LOGIN_SUBMIT("/login"), LOGOUT("/logout"), BROWSETUTOR_LOAD("/browse"), TUTORDETAILS_LOAD(
			"/view"), APPLYASTUTOR("/apply"), CONFIRM("/confirm"), MYTUTEE_LOAD(
					"/dashboard/mytutee"), UPDATEDETAIL_LOAD("/dashboard/update"), UPDATEDETAIL_SUBMIT(
							"/dashboard/update/submit"), UPDATEDETAIL_SUCCESS(
									"/dashboard/update/success"), MYEVALUATION_LOAD(
											"/dashboard/myevaluation"), REGISTER("/register"), REQUESTTUTOR_LOAD(
													"/request-load"), REQUESTTUTOR_SUBMIT("/request"), MYTUTOR_LOAD(
															"/dashboard/mytutor"), TUTOREVALUATE_LOAD(
																	"/dashboard/evaluation"), TUTOREVALUATE_VIEW(
																			"/dashboard/evaluation/view"), MYTUTOR_VIEW(
																					"/dashboard/mytutor/view"), TUTOREVALUATE_SEND(
																							"/dashboard/evaluation/send"), MYPROFILE_LOAD(
																									"/dashboard/myprofile"), MYPROFILE_SUBMIT(
																											"/dashboard/myprofile/submit"), MANAGEOFFICER_LOAD(
																													"/dashboard/manageofficer"), MANAGEOFFICER_ADD(
																															"/dashboard/manageofficer/add"), MANAGEOFFICER_REMOVE(
																																	"/dashboard/manageofficer/remove"), MANAGEOFFICER_UPDATE(
																																			"/dashboard/manageofficer/update"), MANAGETUTEE_LOAD(
																																					"/dashboard/managetutee"), MANAGETUTEE_UPDATE(
																																							"/dashboard/managetutee/update"), MANAGETUTEE_ASSIGN(
																																									"/dashboard/managetutee/update/assign"), MANAGETUTEE_UNASSIGN(
																																											"/dashboard/managetutee/update/unassign"), MANAGETUTOR_LOAD(
																																													"/dashboard/managetutor"), MANAGETUTOR_UPDATE(
																																															"/dashboard/managetutor/update"), MANAGETUTOR_ACCEPTPENDING(
																																																	"/dashboard/managetutor/update/acceptpending"), MANAGETUTOR_ACCEPTREJECTED(
																																																			"/dashboard/managetutor/update/acceptrejected"), MANAGETUTOR_REJECTED(
																																																					"/dashboard/managetutor/update/reject"), MANAGETUTOR_DEACTIVATETUTOR(
																																																							"/dashboard/managetutor/update/deactivate"), MANAGETUTOR_REACTIVATE(
																																																									"/dashboard/managetutor/update/reactivate"), MANAGEEVALUATION_LOAD(
																																																											"/dashboard/manageevaluation"), MANAGEEVALUATION_FORWARD(
																																																													"/dashboard/manageevaluation/forward"), MANAGEEVALUATION_SEND(
																																																															"/dashboard/manageevaluation/send"), CONTROLPANEL_LOAD(
																																																																	"/dashboard/controlpanel");

	private final String value;

	UrlPatternEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return getValue(null);
	}

	public String getValue(HttpServletRequest request) {

		if (request != null)
			return request.getContextPath() + value;

		return value;
	}

	private static final Map<String, UrlPatternEnum> intToTypeMap = new HashMap<String, UrlPatternEnum>();
	static {
		for (UrlPatternEnum type : UrlPatternEnum.values()) {
			intToTypeMap.put(type.value, type);
		}
	}

	public static UrlPatternEnum toEnum(String i) {
		UrlPatternEnum type = intToTypeMap.get(i);
		if (type == null)
			return UrlPatternEnum.NONE;
		return type;
	}
}
