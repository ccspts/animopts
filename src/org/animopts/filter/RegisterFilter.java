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
import org.animopts.bean.GlobalConstant;
import org.animopts.db.CookieHelper;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/RegisterFilter")
public class RegisterFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RegisterFilter() {
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

		System.out.println("RegisterFilter");
		HttpServletRequest req = (HttpServletRequest) request;

		try {

			Cookie c = null;
			c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, req);

			if (c == null) {
				request.setAttribute(GlobalConstant.NAME_REDIRECT_PAGE, req.getRequestURI());
				request.getRequestDispatcher(GlobalConstant.REGISTER).forward(request, response);
				return;
			}

		} finally {
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
