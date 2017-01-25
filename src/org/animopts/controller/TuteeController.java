package org.animopts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.Account;
import org.animopts.bean.Evaluation;
import org.animopts.bean.GlobalConstant;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.TermDetail;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;
import org.animopts.service.GlobalService;
import org.animopts.service.TuteeService;
import org.animopts.service.TutorService;

import com.google.gson.Gson;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/dashboard/mytutor", "/dashboard/evaluation", "/dashboard/evaluation/send",
		"/dashboard/myprofile", "/dashboard/myprofile/submit", "/dashboard/evaluation/view",
		"/dashboard/mytutor/view" })
public class TuteeController extends AbstractController {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TuteeController() {
		super();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UrlPatternEnum servletPath = UrlPatternEnum.toEnum(request.getServletPath());

		switch (servletPath) {
		case MYTUTOR_LOAD:
			myTutor(request, response);
			break;
		case TUTOREVALUATE_LOAD:
			evaluation(request, response);
			break;
		case TUTOREVALUATE_SEND:
			evaluation_submit(request, response);
			break;
		case MYPROFILE_LOAD:
			myProfile(request, response);
			break;
		case MYPROFILE_SUBMIT:
			myProfile_submit(request, response);
			break;
		case TUTOREVALUATE_VIEW:
			viewEvaluation(request, response);
			break;
		case MYTUTOR_VIEW:
			viewTutorDetail(request, response);
			break;
		}
	}

	protected void viewEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("DUMAAN SA VIEW SERVLET");
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		TermDetail termDetail = GlobalService.getTermDetail();

		PrintWriter pw = response.getWriter();
		Evaluation viewEval = TutorService.getViewEvaluation(c.getValue(), termDetail.getTerm(), termDetail.getYear(),
				request.getParameter(Account.COL_IDNUMBER));

		Gson g = new Gson();
		String jsonString = g.toJson(viewEval);
		pw.write(jsonString);
	}

	protected void viewTutorDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		TermDetail termDetail = GlobalService.getTermDetail();

		PrintWriter pw = response.getWriter();
		RequestTutor[] tutor = TuteeService.viewMyTutor(request.getParameter(Account.COL_IDNUMBER));
		Gson g = new Gson();
		String jsonString = g.toJson(tutor);
		System.out.println(jsonString);
		pw.write(jsonString);
	}

	protected void myTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get id number from cookie
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null) {
			return;
		}

		RequestTutor[] myTutors = TuteeService.getMyTutorList(c.getValue());
		request.setAttribute("myTutors", myTutors);
		request.getRequestDispatcher(GlobalConstant.MYTUTORS).forward(request, response);
	}

	protected void evaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LoadTutorEvaluation");

		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		TermDetail termDetail = GlobalService.getTermDetail();

		Evaluation[] tutorEval = TuteeService.getTutorEvaluation(c.getValue());
		request.setAttribute("tutorEval", tutorEval);

		request.getRequestDispatcher(GlobalConstant.EVALUATION).forward(request, response);
	}

	protected void evaluation_submit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Evaluation e = new Evaluation();
		e.setComment(request.getParameter(Evaluation.COL_COMMENT));
		e.setCon(Float.parseFloat(request.getParameter(Evaluation.COL_CONFIDENCE)));
		e.setEff(Float.parseFloat(request.getParameter(Evaluation.COL_EFFECTIVENESS)));
		e.setEnc(Float.parseFloat(request.getParameter(Evaluation.COL_ENCOURAGING)));
		e.setEnt(Float.parseFloat(request.getParameter(Evaluation.COL_ENTHUSIASM)));
		e.setExc(Float.parseFloat(request.getParameter(Evaluation.COL_EXERCISE)));
		e.setExp(Float.parseFloat(request.getParameter(Evaluation.COL_EXPLANATION)));
		e.setFreq(Float.parseFloat(request.getParameter(Evaluation.COL_FREQUENCY)));
		e.setKno(Float.parseFloat(request.getParameter(Evaluation.COL_KNOWLEDGEABLE)));
		e.setMessage(request.getParameter(Evaluation.COL_MESSAGE));
		e.setPas(Float.parseFloat(request.getParameter(Evaluation.COL_PASSION)));
		e.setPrep(Float.parseFloat(request.getParameter(Evaluation.COL_PREPAREDNESS)));
		e.setQue(Float.parseFloat(request.getParameter(Evaluation.COL_QNA)));
		e.setRel(Float.parseFloat(request.getParameter(Evaluation.COL_RELEVANCE)));
		e.setVoc(Float.parseFloat(request.getParameter(Evaluation.COL_VOCAL)));

		RequestTutor requestTutor = new RequestTutor();
		requestTutor.setId(Integer.parseInt(request.getParameter(Evaluation.COL_REQUESTTUTORID)));
		Account tutor = new Account();
		tutor.setIdNumber(request.getParameter(Account.COL_IDNUMBER));
		tutor.setLastName(request.getParameter(Account.COL_LASTNAME));
		tutor.setFirstName(request.getParameter(Account.COL_FIRSTNAME));

		requestTutor.setTutor(tutor);

		e.setRequestTutor(requestTutor);

		if (!TuteeService.sendEvaluation(e)) {
			throw new ServletException();
		}

		// TODO: Success
		evaluation(request, response);

	}

	protected void myProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LoadMyProfileServlet");

		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		Account a = AccountService.getUser(c.getValue());
		request.setAttribute(Account.COL_FIRSTNAME, a.getFirstName());
		request.setAttribute(Account.COL_LASTNAME, a.getLastName());
		request.setAttribute(Account.COL_IDNUMBER, a.getIdNumber());
		request.setAttribute(Account.COL_DEGREE, a.getDegree());
		request.setAttribute(Account.COL_FBURL, a.getFbUrl());
		request.setAttribute(Account.COL_MOBILENUM, a.getMobileNum());
		request.setAttribute(Account.COL_EMAIL, a.getEmail());

		request.getRequestDispatcher(GlobalConstant.MYPROFILE).forward(request, response);

	}

	protected void myProfile_submit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the ID number of the user for the cookie
		String id = request.getParameter(Account.COL_IDNUMBER);

		if (!AccountService.login(id, request.getParameter(Account.COL_PASSWORD))) {
			// TODO: Wrong password
			System.out.println("Input Password: " + request.getParameter(Account.COL_PASSWORD));
			throw new NotImplementedException();
		}

		System.out.println("ID NUMBER FROM MY PROFILE: " + request.getParameter(Account.COL_IDNUMBER));

		Account a = new Account();
		a.setFirstName(request.getParameter(Account.COL_FIRSTNAME));
		a.setLastName(request.getParameter(Account.COL_LASTNAME));
		a.setIdNumber(request.getParameter(Account.COL_IDNUMBER));
		a.setDegree(request.getParameter(Account.COL_DEGREE));
		a.setFbUrl(request.getParameter(Account.COL_FBURL));
		a.setMobileNum(request.getParameter(Account.COL_MOBILENUM));
		a.setEmail(request.getParameter(Account.COL_EMAIL));
		a.setPassword(request.getParameter(Account.COL_PASSWORD));

		if (!AccountService.udpateAccount(a)) {
			System.out.println("ERROR: Failed to update profile");
			return;
		}

		// TODO: Success
		myProfile(request, response);
	}

}
