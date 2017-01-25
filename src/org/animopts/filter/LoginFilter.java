package org.animopts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.animopts.bean.Account;
import org.animopts.bean.AccountLevel;
import org.animopts.bean.GlobalConstant;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		boolean isNoPermission = false;

		System.out.println("LoginFilter");

		HttpServletRequest req = (HttpServletRequest) request;
		try {

			// Check if login is required on the page
			if (!isLoginRequired(req.getRequestURI()))
				return;

			Cookie c = null;
			c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, req);

			if (c == null) {
				System.out.println("Sending redirection to : " + req.getRequestURI());
				request.setAttribute(GlobalConstant.NAME_REDIRECT_PAGE, req.getRequestURI());
				request.getRequestDispatcher(GlobalConstant.LOGIN).forward(request, response);
				return;
			}

			String idNumber = c.getValue();

			AccountLevel level = AccountService.getUserAccountLevel(idNumber);

			if (!hasPermission(level, req.getRequestURI())) {
				System.out.println("No permission");
				isNoPermission = true;
				request.getRequestDispatcher(GlobalConstant.NOPERMISSION).forward(request, response);
			}
		} finally {
			if (!isNoPermission)
				chain.doFilter(request, response);
		}

	}

	private boolean isLoginRequired(String url) {
		return url.endsWith(GlobalConstant.DASHBOARD) || url.endsWith(GlobalConstant.MYTUTORS)
				|| url.endsWith(GlobalConstant.MYPROFILE) || url.endsWith(GlobalConstant.MANAGETUTEE)
				|| url.endsWith(GlobalConstant.MYTUTEES) || url.endsWith(GlobalConstant.UPDATETUTOR)
				|| url.endsWith(GlobalConstant.MANAGETUTOR) || url.endsWith(GlobalConstant.EVALUATION)
				|| url.endsWith(GlobalConstant.MANAGEEVALUATION) || url.endsWith(GlobalConstant.MANAGEOFFICER);
	}

	private boolean hasPermission(AccountLevel level, String url) {
		switch (level) {
		case ADMIN:
			return hasPermissionAdmin(url);
		case GUEST:
			return !isLoginRequired(url);
		case OFFICER:
			return hasPermissionOfficer(url);
		case TUTEE:
			return hasPermissionTutee(url);
		case TUTOR:
			return hasPermissionTutor(url);
		}
		return false;
	}

	private boolean hasPermissionTutee(String url) {
		return url.endsWith(GlobalConstant.DASHBOARD) || url.endsWith(GlobalConstant.MYTUTORS)
				|| url.endsWith(GlobalConstant.MYPROFILE) || url.endsWith(GlobalConstant.EVALUATION);
	}

	private boolean hasPermissionAdmin(String url) {
		return hasPermissionOfficer(url);
	}

	private boolean hasPermissionOfficer(String url) {
		return url.endsWith(GlobalConstant.MANAGETUTEE) || url.endsWith(GlobalConstant.MANAGETUTOR)
				|| url.endsWith(GlobalConstant.MANAGEEVALUATION) || url.endsWith(GlobalConstant.MANAGEOFFICER)
				|| hasPermissionTutor(url);
	}

	private boolean hasPermissionTutor(String url) {
		return url.endsWith(GlobalConstant.MYTUTEES) || url.endsWith(GlobalConstant.UPDATETUTOR)
				|| url.endsWith(GlobalConstant.EVALUATION) || hasPermissionTutee(url);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
