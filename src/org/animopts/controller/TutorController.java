package org.animopts.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.animopts.bean.Account;
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.Evaluation;
import org.animopts.bean.GlobalConstant;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.Subject;
import org.animopts.bean.TermDetail;
import org.animopts.bean.TutorTypeOfTutorialEnum;
import org.animopts.db.CookieHelper;
import org.animopts.service.GlobalService;
import org.animopts.service.SubjectService;
import org.animopts.service.TutorService;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/dashboard/mytutee", "/dashboard/update", "/dashboard/update/submit",
		"/dashboard/update/success", "/dashboard/myevaluation" })
public class TutorController extends AbstractController {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TutorController() {
		super();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UrlPatternEnum servletPath = UrlPatternEnum.toEnum(request.getServletPath());

		switch (servletPath) {
		case MYTUTEE_LOAD:
			myTutee(request, response);
			break;
		case UPDATEDETAIL_LOAD:
			updateDetail(request, response);
			break;
		case UPDATEDETAIL_SUBMIT:
			updateDetail_submit(request, response);
			break;
		case UPDATEDETAIL_SUCCESS:
			updateDetail_success(request, response);
			break;
		case MYEVALUATION_LOAD:
			myEvaluation(request, response);
			break;
		}
	}

	protected void updateDetail_success(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(GlobalConstant.UPDATETUTORSUCCESS).forward(request, response);
	}

	protected void myTutee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get id number from cookie
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null) {
			return;
		}

		RequestTutor[] myTutees = TutorService.getMyTuteeList(c.getValue());
		request.setAttribute("myTutees", myTutees);
		request.getRequestDispatcher(GlobalConstant.MYTUTEES).forward(request, response);

	}

	protected void updateDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Subject[] subjectList = SubjectService.getAllOfferedSubject();
		request.setAttribute("subjectList", subjectList);

		request.getRequestDispatcher(GlobalConstant.UPDATETUTOR).forward(request, response);
	}

	protected void updateDetail_submit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get id number from cookie
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		ActivatedTutor tutor = new ActivatedTutor();
		tutor.setIdNumber(c.getValue());

		// Set maxtuteecount
		tutor.setMaxTuteeCount(Integer.parseInt(request.getParameter(ActivatedTutor.COL_MAXTUTEECOUNT)));

		// Set preftutorial
		String prefTutorial = request.getParameter(ActivatedTutor.TABLE_PREFTUTORIAL_NAME);
		ArrayList<TutorTypeOfTutorialEnum> typeList = new ArrayList<TutorTypeOfTutorialEnum>();

		String[] splitPrefTutorial = prefTutorial.split(",");

		for (int i = 0; i < splitPrefTutorial.length; i++) {
			if (splitPrefTutorial[i].equals(ActivatedTutor.COL_PREFTUTORIAL_SOLO))
				typeList.add(TutorTypeOfTutorialEnum.SOLO);
			else if (splitPrefTutorial[i].equals(ActivatedTutor.COL_PREFTUTORIAL_PAIR))
				typeList.add(TutorTypeOfTutorialEnum.PAIR);
			else if (splitPrefTutorial[i].equals(ActivatedTutor.COL_PREFTUTORIAL_GROUP))
				typeList.add(TutorTypeOfTutorialEnum.GROUP);
			else if (splitPrefTutorial[i].equals(ActivatedTutor.COL_PREFTUTORIAL_CLASSROOM))
				typeList.add(TutorTypeOfTutorialEnum.CLASSROOM);
		}
		tutor.setPreferredTutorial(typeList.toArray(new TutorTypeOfTutorialEnum[typeList.size()]));

		// Set prefsubject
		String[] prefSubjectList = request.getParameterValues(ActivatedTutor.COL_PREFSUBJECT_SUBJECTID);

		ArrayList<Subject> subjList = new ArrayList<Subject>();
		for (int i = 0; i < prefSubjectList.length; i++) {
			Subject subj = new Subject();
			subj.setId(Integer.parseInt(prefSubjectList[i]));
			subjList.add(subj);
		}

		tutor.setPreferredSubject(subjList.toArray(new Subject[subjList.size()]));

		TutorService.updateTutor(tutor, request.getParameter(GlobalConstant.NAME_SCHEDULE));

		// TODO: Success
		response.sendRedirect(UrlPatternEnum.UPDATEDETAIL_SUCCESS.getValue(request));

	}

	protected void myEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		TermDetail termDetail = GlobalService.getTermDetail();

		Evaluation[] myEval = TutorService.getMyEvaluation(c.getValue(), termDetail.getTerm(), termDetail.getYear());
		request.setAttribute("myEval", myEval);
		request.getRequestDispatcher(GlobalConstant.MYEVALUATION).forward(request, response);
	}

}
