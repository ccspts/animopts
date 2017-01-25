package org.animopts.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.GlobalConstant;

public class ServletHelper {

	public static void redirectFromRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String redirectPage = (String) request.getAttribute(GlobalConstant.NAME_REDIRECT_PAGE);
		System.out.println("redirectPage: " + redirectPage);
		if (redirectPage != null && !redirectPage.isEmpty()) {
			response.sendRedirect(redirectPage);
		}
	}

	// public static String getBaseUrl(HttpServletRequest request) {
	// StringBuffer url = request.getRequestURL();
	// String uri = request.getRequestURI();
	// String ctx = request.getContextPath();
	// return url.substring(0, url.length() - uri.length() + ctx.length()) +
	// "/";
	// }
}
