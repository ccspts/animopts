package org.animopts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.ActivatedTutor;
import org.animopts.service.AccountService;

/**
 * Servlet implementation class BrowseTutorServlet
 */
@WebServlet("/BrowseTutorServlet")
public class BrowseTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BrowseTutorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActivatedTutor[] tutorList = AccountService.getAllActivatedTutorNameWithSubject();
		request.setAttribute("tutorList", tutorList);
		System.out.println(tutorList[0].getCOL_IDNUMBER());
		request.getRequestDispatcher("browse-tutor.jsp").forward(request, response);
		/*
		 * Account[] tutorList = AccountService.getAllActiveTutors();
		 * request.setAttribute("tutorList", tutorList);
		 * request.getRequestDispatcher("browse-tutor.jsp").forward(request,
		 * response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
