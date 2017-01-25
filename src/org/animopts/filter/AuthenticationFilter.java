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
import org.animopts.bean.ActivatedTutor;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;
import org.animopts.service.TutorService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthenticationFilter() {
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

		HttpServletRequest req = (HttpServletRequest) request;

		System.out.println("AuthenticationFilter: " + req.getRequestURI());

		Cookie c = null;
		String idNumber = "";
		try {
			c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, req);

			if (c == null) {
				System.out.println("COOKIE IS NULL WAT");
				return;

			}
			idNumber = c.getValue();

			System.out.println("idNumber: " + idNumber);

			Account a = AccountService.getUserPreviewInfo(idNumber);

			request.setAttribute(Account.COL_FIRSTNAME, a.getFirstName());
			request.setAttribute(Account.COL_LASTNAME, a.getLastName());
			request.setAttribute(Account.COL_ACCOUNTLEVEL, a.getAccountLevel().getValue());
			request.setAttribute(ActivatedTutor.ID_ISUPDATED, TutorService.isDetailsUpdated(idNumber) ? 1 : 0);

		} finally {

			request.setAttribute(Account.COL_IDNUMBER, c == null ? null : idNumber);
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
