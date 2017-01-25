package org.animopts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.Account;
import org.animopts.bean.AccountLevel;
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.GlobalConstant;
import org.animopts.bean.PendingTutor;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.Subject;
import org.animopts.bean.TermDetail;
import org.animopts.bean.TuteeTypeOfTutorialEnum;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;
import org.animopts.service.GlobalService;
import org.animopts.service.SubjectService;
import org.animopts.service.TuteeService;
import org.animopts.service.TutorService;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/register", "/request-load", "/request", "/apply", "/confirm" })
public class RegisterController extends AbstractController {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UrlPatternEnum servletPath = UrlPatternEnum.toEnum(request.getServletPath());

		switch (servletPath) {
		case REGISTER:
			register(request, response);
			break;
		case REQUESTTUTOR_LOAD:
			requestTutor(request, response);
			break;
		case REQUESTTUTOR_SUBMIT:
			requestTutor_submit(request, response);
			break;
		case APPLYASTUTOR:
			applyAsTutor(request, response);
			break;
		case CONFIRM:
			request.getRequestDispatcher(GlobalConstant.CONFIRM).forward(request, response);
			break;
		}
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the input from the user
		Account a = new Account();
		a.setFirstName(request.getParameter(Account.COL_FIRSTNAME));
		a.setLastName(request.getParameter(Account.COL_LASTNAME));
		a.setDegree(request.getParameter(Account.COL_DEGREE));
		a.setFbUrl(request.getParameter(Account.COL_FBURL));
		a.setIdNumber(request.getParameter(Account.COL_IDNUMBER));
		a.setMobileNum(request.getParameter(Account.COL_MOBILENUM));
		a.setAccountLevel(AccountLevel.TUTEE);
		a.setEmail(request.getParameter(Account.COL_EMAIL));
		a.setPassword(request.getParameter(Account.COL_PASSWORD));

		if (!AccountService.addAccount(a))
			return;

		LoginController loginServlet = new LoginController();
		loginServlet.doPost(request, response);
	}

	protected void applyAsTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PendingTutor a = new PendingTutor();

		// Get id number from cookie
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null) {
			return;
		}

		a.setIdNumber(c.getValue());
		a.setCurrentInvolvements(request.getParameter(PendingTutor.COL_CURRINVOLVEMENT));
		a.setReasonForJoining(request.getParameter(PendingTutor.COL_REASONFORJOINING));
		// Call the service which will add new book to DB
		TutorService.addPendingTutor(a);

		response.sendRedirect(GlobalConstant.CONFIRM);

	}

	protected void requestTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get id number from cookie
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		Subject[] subjectList = SubjectService.getAllOfferedSubject();
		request.setAttribute("subjectList", subjectList);

		ActivatedTutor[] tutorList = AccountService.getAllActivatedTutorName(c.getValue());
		request.setAttribute("tutorList", tutorList);

		request.getRequestDispatcher(GlobalConstant.REQUEST_TUTOR).forward(request, response);
	}

	protected void requestTutor_submit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("requestTutor_submit: " +
		// request.getParameter(GlobalConstant.NAME_SCHEDULE));

		RequestTutor r = new RequestTutor();

		// Get id number from cookie
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		// Set up Tutee
		Account tutee = new Account();
		tutee.setIdNumber(c.getValue());
		r.setTutee(tutee);

		// Set up Tutorial Type
		r.setTutorialType(
				TuteeTypeOfTutorialEnum.valueOf(Integer.parseInt(request.getParameter(RequestTutor.COL_TUTORIALTYPE))));

		// Set up Subject
		Subject subject = new Subject();
		subject.setId(Integer.parseInt(request.getParameter(RequestTutor.COL_SUBJECTID)));
		r.setSubj(subject);

		// Set up Preferred Tutor
		Account preferredTutor = null;
		String preferredTutorId = request.getParameter(RequestTutor.COL_PREFTUTORID);
		if (!preferredTutorId.equals("0")) {
			preferredTutor = new Account();
			preferredTutor.setIdNumber(preferredTutorId);
			System.out.println("Preferred Tutor ID = " + preferredTutorId);
		}
		r.setPreferredTutor(preferredTutor);

		// Set up Term Detail
		TermDetail termDetail = GlobalService.getTermDetail();
		r.setYear(termDetail.getYear());
		r.setTerm(termDetail.getTerm());

		TuteeService.addRequestTutor(r, request.getParameter(GlobalConstant.NAME_SCHEDULE));

		response.sendRedirect(UrlPatternEnum.MYTUTOR_LOAD.getValue(request));
	}

}
