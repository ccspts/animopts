package org.animopts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.Account;
import org.animopts.bean.GlobalConstant;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;
import org.animopts.servlet.ServletHelper;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String pathInfo = request != null ? request.getPathInfo() : null;
		// String url = pathInfo != null ? pathInfo.substring(1) : null;
		// String filename = url != null ? URLDecoder.decode(url, "UTF-8") :
		// null;

		// TODO Auto-generated method stub
		UrlPatternEnum servletPath = UrlPatternEnum.toEnum(request.getServletPath());

		System.out.println("IM HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEERE");
		System.out.println("request.getServletPath(): " + request.getServletPath());

		switch (servletPath) {
		case LOGIN_SUBMIT:
			submit(request, response);
			break;
		case LOGOUT:
			logout(request, response);
			break;
		}
	}

	protected void submit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the ID number of the user for the cookie
		String id = request.getParameter(Account.COL_IDNUMBER);

		if (!AccountService.login(id, request.getParameter(Account.COL_PASSWORD))) {
			// TODO: Wrong account info
			request.getRequestDispatcher(GlobalConstant.LOGIN).forward(request, response);
		}

		CookieHelper.addCookie(Account.COOKIE_IDNUMBER, id, request, response);

		// Redirect to original destination
		request.setAttribute(GlobalConstant.NAME_REDIRECT_PAGE, GlobalConstant.HOME);
		ServletHelper.redirectFromRequest(request, response);
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CookieHelper.removeCookie(Account.COOKIE_IDNUMBER, request, response);
		response.sendRedirect(GlobalConstant.HOME);
	}

}
