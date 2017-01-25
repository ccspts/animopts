package org.animopts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.animopts.bean.AccountLevel;
import org.animopts.bean.GlobalConstant;
import org.animopts.controller.UrlPatternEnum;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/ServletToJspFilter")
public class ServletToJspFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ServletToJspFilter() {
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

		System.out.println("ServerToJspFilter");

		HttpServletRequest req = (HttpServletRequest) request;

		try {

			String url = req.getRequestURI();

			if (url.endsWith(GlobalConstant.REQUEST_TUTOR))
				req.getRequestDispatcher(UrlPatternEnum.REQUESTTUTOR_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MYPROFILE))
				req.getRequestDispatcher(UrlPatternEnum.MYPROFILE_LOAD.getValue()).forward(request, response);
			// else if (url.endsWith(UpdateMyProfileServlet.PAGE_NAME))
			// req.getRequestDispatcher(GlobalConstant.MYPROFILE).forward(request,
			// response);
			else if (url.endsWith(GlobalConstant.MANAGETUTOR))
				req.getRequestDispatcher(UrlPatternEnum.MANAGETUTOR_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MANAGETUTEE))
				req.getRequestDispatcher(UrlPatternEnum.MANAGETUTEE_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MYTUTORS))
				req.getRequestDispatcher(UrlPatternEnum.MYTUTOR_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MYTUTEES))
				req.getRequestDispatcher(UrlPatternEnum.MYTUTEE_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.UPDATETUTOR))
				req.getRequestDispatcher(UrlPatternEnum.UPDATEDETAIL_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MANAGEEVALUATION))
				req.getRequestDispatcher(UrlPatternEnum.MANAGEEVALUATION_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.EVALUATION))
				req.getRequestDispatcher(UrlPatternEnum.TUTOREVALUATE_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MYEVALUATION))
				req.getRequestDispatcher(UrlPatternEnum.MYEVALUATION_LOAD.getValue()).forward(request, response);
			else if (url.endsWith(GlobalConstant.MANAGEOFFICER))
				req.getRequestDispatcher(UrlPatternEnum.MANAGEOFFICER_LOAD.getValue()).forward(request, response);

		} finally {
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
