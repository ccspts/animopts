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
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.Account;
import org.animopts.bean.AccountLevel;
import org.animopts.bean.GlobalConstant;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;
import org.animopts.service.TutorService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/ApplyAsTutorFilter")
public class ApplyAsTutorFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ApplyAsTutorFilter() {
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

		System.out.println("ApplyAsTutorFilter");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {

			Cookie c = null;
			c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, req);

			if (c == null) {
				request.setAttribute(GlobalConstant.NAME_REDIRECT_PAGE, GlobalConstant.APPLY_TUTOR);
				request.getRequestDispatcher(GlobalConstant.REGISTER).forward(request, response);
				return;
			}

			String idNumber = c.getValue();

			boolean isPending = TutorService.isPending(idNumber);
			boolean isRejected = TutorService.isRejected(idNumber);
			boolean isTutor = AccountService.getUserAccountLevel(idNumber) == AccountLevel.TUTOR;
			if (isPending || isRejected) {
				request.setAttribute(GlobalConstant.NAME_TUTOR_STATUS,
						isPending ? GlobalConstant.VALUE_TUTOR_STATUS_PENDING
								: isRejected ? GlobalConstant.VALUE_TUTOR_STATUS_REJECTED : null);
				req.getRequestDispatcher(GlobalConstant.CONFIRM).forward(request, response);
				return;
			}

			if (isTutor) {
				res.sendRedirect(GlobalConstant.DASHBOARD);
				return;
			}

			req.getRequestDispatcher(GlobalConstant.APPLY_TUTOR).forward(request, response);

		} finally {
			if (req.getSession() == null)
				chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
