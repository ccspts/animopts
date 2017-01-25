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
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.DeactivatedTutor;
import org.animopts.bean.Evaluation;
import org.animopts.bean.FormConstant;
import org.animopts.bean.GlobalConstant;
import org.animopts.bean.Officer;
import org.animopts.bean.PendingTutor;
import org.animopts.bean.RejectedTutor;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.TermDetail;
import org.animopts.db.CookieHelper;
import org.animopts.service.AccountService;
import org.animopts.service.GlobalService;
import org.animopts.service.OfficerService;
import org.animopts.service.TutorService;
import org.animopts.servlet.IServlet;

import com.google.gson.Gson;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/dashboard/manageofficer", "/dashboard/manageofficer/add",
		"/dashboard/manageofficer/remove", "/dashboard/manageofficer/update", "/dashboard/managetutee",
		"/dashboard/managetutee/update/assign", "/dashboard/managetutee/update/unassign", "/dashboard/managetutor",
		"/dashboard/managetutor/update/acceptpending", "/dashboard/managetutor/update/acceptrejected",
		"/dashboard/managetutor/update/reject", "/dashboard/managetutor/update/deactivate",
		"/dashboard/managetutor/update/reactivate", "/dashboard/manageevaluation",
		"/dashboard/manageevaluation/forward", "/dashboard/manageevaluation/send", "/dashboard/controlpanel",
		"/dashboard/managetutor/update", "/dashboard/managetutee/update" })
public class OfficerController extends AbstractController {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OfficerController() {
		super();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UrlPatternEnum servletPath = UrlPatternEnum.toEnum(request.getServletPath());

		switch (servletPath) {
		case MANAGEOFFICER_LOAD:
			manageOfficer(request, response);
			break;
		case MANAGEOFFICER_ADD:
			manageOfficer_add(request, response);
			break;
		case MANAGEOFFICER_REMOVE:
			manageOfficer_remove(request, response);
			break;
		case MANAGEOFFICER_UPDATE:
			manageOfficer_update(request, response);
			break;
		case MANAGETUTEE_LOAD:
			manageTutee(request, response);
			break;
		case MANAGETUTEE_UPDATE:
			manageTutee_update(request, response);
			break;
		// case MANAGETUTEE_ASSIGN:
		// manageTutee_assign(request, response);
		// break;
		// case MANAGETUTEE_UNASSIGN:
		// manageTutee_unassign(request, response);
		// break;
		case MANAGETUTOR_LOAD:
			manageTutor(request, response);
			break;
		case MANAGETUTOR_UPDATE:
			manageTutor_update(request, response);
			break;
		// case MANAGETUTOR_ACCEPTPENDING:
		// manageTutor_acceptPending(request, response);
		// break;
		// case MANAGETUTOR_ACCEPTREJECTED:
		// manageTutor_acceptRejected(request, response);
		// break;
		// case MANAGETUTOR_DEACTIVATETUTOR:
		// manageTutor_deactivate(request, response);
		// break;
		// case MANAGETUTOR_REACTIVATE:
		// manageTutor_reactivate(request, response);
		// break;
		case MANAGEEVALUATION_LOAD:
			manageEvaluation(request, response);
			break;
		case MANAGEEVALUATION_FORWARD:
			manageEvaluation_forward(request, response);
			break;
		case MANAGEEVALUATION_SEND:
			manageEvaluation_send(request, response);
			break;
		case CONTROLPANEL_LOAD:
			controlPanel(request, response);
			break;
		}
	}

	protected void manageOfficer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null) {
			return;
		}

		ActivatedTutor[] tutorList = AccountService.getAllActivatedTutorNotOfficers(c.getValue());
		request.setAttribute("tutorList", tutorList);

		Officer[] officers = OfficerService.getOfficerList();
		request.setAttribute("officers", officers);
		request.getRequestDispatcher(GlobalConstant.MANAGEOFFICER).forward(request, response);
	}

	protected void manageOfficer_add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idnumber = request.getParameter("idnum");
		String position = request.getParameter("pos");
		if (!OfficerService.addOfficer(idnumber, position))
			return;

		Officer officer = OfficerService.getSpecifiedOfficer(idnumber);
		System.out.println(
				officer.getIdNumber() + " " + " add officer" + officer.getLastName() + " " + officer.getFirstName());
		PrintWriter pw = response.getWriter();

		Gson g = new Gson();
		String jsonString = g.toJson(officer);
		System.out.println(jsonString);
		pw.write(jsonString);
	}

	protected void manageOfficer_remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idnumber = request.getParameter("idnum");
		System.out.println(idnumber + "Is to be removed from officers");
		if (!OfficerService.removeOfficer(idnumber))
			return;
		PrintWriter pw = response.getWriter();
		pw.write("success");
	}

	protected void manageOfficer_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idnumber = request.getParameter("idnum");
		String position = request.getParameter("pos");

		if (!OfficerService.updateOfficer(idnumber, position))
			return;

		PrintWriter pw = response.getWriter();
		pw.write("success");
	}

	protected void manageTutee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		TermDetail termDetail = GlobalService.getTermDetail();

		RequestTutor[] unassignedList = OfficerService.getAllTuteeWithMatch(termDetail.getTerm(), termDetail.getYear(),
				false);

		RequestTutor[] assignedList = OfficerService.getAllTuteeWithMatch(termDetail.getTerm(), termDetail.getYear(),
				true);

		System.out.println("ASSIGNEDLIST COUNT = " + assignedList.length);

		request.setAttribute("unassignedList", unassignedList);
		request.setAttribute("assignedList", assignedList);

		request.getRequestDispatcher(GlobalConstant.MANAGETUTEE).forward(request, response);
	}

	protected void manageTutee_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IServlet updateServlet = null;

		System.out.println("hi poh");

		if (!OfficerService.assignTutorToTutee(request.getParameter(RequestTutor.COL_ASSIGNEDTUTORID),
				Integer.parseInt(request.getParameter(RequestTutor.COL_REQUESTTUTORID)))) {
			throw new ServletException("Failed to update database");
		}

		PrintWriter pw = response.getWriter();

		RequestTutor r = new RequestTutor();
		r.setId(Integer.parseInt(request.getParameter(RequestTutor.COL_REQUESTTUTORID)));
		Account a = new Account();
		a.setIdNumber(request.getParameter(RequestTutor.COL_ASSIGNEDTUTORID));
		r.setTutor(a);

		Gson g = new Gson();
		String jsonString = g.toJson(r);

		pw.write(jsonString);
	}

	protected void manageTutee_assign(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		throw new NotImplementedException();

		// int requestId = (int)
		// request.getAttribute(RequestTutor.COL_REQUESTTUTORID);
		// String tutorId = (String)
		// request.getAttribute(RequestTutor.COL_ASSIGNEDTUTORID);
		//
		// if (requestId == 0 || tutorId == null) {
		// throw new NullPointerException();
		// }
		//
		// if (!OfficerService.assignTutorToTutee(tutorId, requestId)) {
		// throw new ServletException("Failed to update database");
		// }
	}

	protected void manageTutee_unassign(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int requestId = (Integer) request.getAttribute(RequestTutor.COL_REQUESTTUTORID);

		if (requestId == 0) {
			throw new NullPointerException();
		}

		if (!OfficerService.unassignTutorToTutee(requestId)) {
			throw new ServletException("Failed to update database");
		}
	}

	protected void manageTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LoadManageTutorServlet");

		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		PendingTutor[] pendingList = OfficerService.getAllPendingTutorName();
		ActivatedTutor[] activatedList = OfficerService.getAllActivatedTutorName();
		DeactivatedTutor[] deactivatedList = OfficerService.getAllDeactivatedTutorName();
		RejectedTutor[] rejectedList = OfficerService.getAllRejectedTutorName();

		request.setAttribute("pendingList", pendingList);
		request.setAttribute("activatedList", activatedList);
		request.setAttribute("deactivatedList", deactivatedList);
		request.setAttribute("rejectedList", rejectedList);

		request.getRequestDispatcher(GlobalConstant.MANAGETUTOR).forward(request, response);
	}

	protected void manageTutor_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionId = request.getParameter(FormConstant.MANAGETUTOR_NAME_ACTION);

		if (actionId == null)
			throw new NullPointerException();

		System.out.println("actionId: " + actionId);

		String[] actionIdSplit = actionId.split("\\$");
		String tutorType = actionIdSplit[0];
		String action = actionIdSplit[1];
		String idNumber = actionIdSplit[2];
		request.setAttribute(Account.COL_IDNUMBER, idNumber);

		if (tutorType == null || action == null || idNumber == null)
			throw new NullPointerException();

		IServlet updateServlet = null;

		if (tutorType.equals(FormConstant.MANAGETUTOR_PENDINGPREFIX)) {
			if (action.equals(FormConstant.MANAGETUTOR_ACTION_ACCEPT)) {
				manageTutor_acceptPending(request, response);
			} else if (action.equals(FormConstant.MANAGETUTOR_ACTION_REJECT)) {
				manageTutor_reject(request, response);
			}
		} else if (tutorType.equals(FormConstant.MANAGETUTOR_ACTIVATEDPREFIX)) {
			if (action.equals(FormConstant.MANAGETUTOR_ACTION_DEACTIVATE)) {
				manageTutor_deactivate(request, response);
			}
		} else if (tutorType.equals(FormConstant.MANAGETUTOR_DEACTIVATEDPREFIX)) {
			if (action.equals(FormConstant.MANAGETUTOR_ACTION_ACTIVATE)) {
				manageTutor_reactivate(request, response);
			}
		} else if (tutorType.equals(FormConstant.MANAGETUTOR_REJECTEDPREFIX)) {
			if (action.equals(FormConstant.MANAGETUTOR_ACTION_ACCEPT)) {
				manageTutor_acceptRejected(request, response);
			}
		}

		// TODO: Success
		response.sendRedirect(UrlPatternEnum.MANAGETUTOR_LOAD.getValue(request));

	}

	protected void manageTutor_acceptPending(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNumber = (String) request.getAttribute(Account.COL_IDNUMBER);

		if (idNumber == null) {
			throw new NullPointerException();
		}

		if (!OfficerService.acceptPendingTutor(idNumber)) {
			throw new ServletException("Failed to update database");
		}
	}

	protected void manageTutor_acceptRejected(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNumber = (String) request.getAttribute(Account.COL_IDNUMBER);

		if (idNumber == null) {
			throw new NullPointerException();
		}

		if (!OfficerService.acceptRejectedTutor(idNumber)) {
			throw new ServletException("Failed to update database");
		}
	}

	protected void manageTutor_reject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNumber = (String) request.getAttribute(Account.COL_IDNUMBER);
		// String rejectionReason =
		// (String) request.getAttribute(RejectedTutor.COL_REJECTIONREASON);
		String rejectionReason = "secret";

		if (idNumber == null || rejectionReason == null) {
			throw new NullPointerException();
		}

		if (!OfficerService.rejectTutor(idNumber, rejectionReason)) {
			throw new ServletException("Failed to update database");
		}
	}

	protected void manageTutor_deactivate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNumber = (String) request.getAttribute(Account.COL_IDNUMBER);

		if (idNumber == null) {
			throw new NullPointerException();
		}

		if (!OfficerService.deactivateTutor(idNumber)) {
			throw new ServletException("Failed to update database");
		}
	}

	protected void manageTutor_reactivate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNumber = (String) request.getAttribute(Account.COL_IDNUMBER);

		if (idNumber == null) {
			throw new NullPointerException();
		}

		if (!OfficerService.reactivateTutor(idNumber)) {
			throw new ServletException("Failed to update database");
		}
	}

	protected void manageEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("bananabananabananabanana");

		Cookie c = CookieHelper.getCookie(Account.COOKIE_IDNUMBER, request);

		if (c == null)
			return;

		TermDetail termDetail = GlobalService.getTermDetail();

		Evaluation[] myEval = TutorService.getMyEvaluation(c.getValue(), termDetail.getTerm(), termDetail.getYear());
		System.out.println(myEval);
		request.setAttribute("myEval", myEval);

		request.getRequestDispatcher(GlobalConstant.MANAGEEVALUATION).forward(request, response);
	}

	protected void manageEvaluation_forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TermDetail termDetail = GlobalService.getTermDetail();

		if (!OfficerService.forwardEvaluation(termDetail.getTerm(), termDetail.getYear())) {
			throw new ServletException();
		}

		PrintWriter pw = response.getWriter();
		pw.write("success");
	}

	protected void manageEvaluation_send(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TermDetail termDetail = GlobalService.getTermDetail();

		if (!OfficerService.sendEvaluationRequest(termDetail.getTerm(), termDetail.getYear())) {
			throw new ServletException();
		}

		PrintWriter pw = response.getWriter();
		pw.write("success");

		// TODO: Success
		// response.sendRedirect(UrlPatternEnum.MANAGEEVALUATION_LOAD.getValue(request));
	}

	protected void controlPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		throw new NotImplementedException();
	}

}
