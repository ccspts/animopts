package org.animopts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.animopts.bean.Account;
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.Evaluation;
import org.animopts.bean.RequestSchedule;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.Subject;
import org.animopts.db.DBPool;

public class TuteeService {
	public static void addRequestTutor(RequestTutor r, String requestScheduleString) {

		String sql = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)",
				RequestTutor.TABLE_NAME, RequestTutor.COL_TUTEEID, RequestTutor.COL_PREFTUTORID,
				RequestTutor.COL_SUBJECTID, RequestTutor.COL_TERM, RequestTutor.COL_YEAR,
				RequestTutor.COL_TUTORIALTYPE);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {
			s = c.prepareStatement(sql);
			s.setString(1, r.getTutee().getIdNumber());
			if (r.getPreferredTutor() != null) {
				System.out.println("banana");
				s.setString(2, r.getPreferredTutor().getIdNumber());

			} else
				s.setNull(2, Types.VARCHAR);
			s.setString(3, r.getSubj().getId() + "");
			s.setString(4, r.getTerm() + "");
			s.setString(5, r.getYear() + "");
			s.setString(6, r.getTutorialType().getValue() + "");

			s.executeUpdate();

			addRequestSchedule(getLastRequestTutorId(), requestScheduleString);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static RequestTutor[] getMyTutorList(String idNumber) {

		String sql = String.format("SELECT %s,%s,%s,%s FROM %s,%s WHERE %s=? AND %s.%s = %s.%s",
				RequestTutor.COL_ASSIGNEDTUTORID, Subject.COL_NAME, RequestTutor.COL_TERM, RequestTutor.COL_YEAR,
				RequestTutor.TABLE_NAME, Subject.TABLE_NAME, RequestTutor.COL_TUTEEID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			System.out.println("getMyTutorList: " + s);

			r = s.executeQuery();

			ArrayList<RequestTutor> tuteeList = new ArrayList<RequestTutor>();

			while (r.next()) {
				RequestTutor t = new RequestTutor();
				t.setYear(r.getInt(RequestTutor.COL_YEAR));
				t.setTerm(r.getInt(RequestTutor.COL_TERM));

				t.setTutor(AccountService.getUserPreviewInfo(r.getString(RequestTutor.COL_ASSIGNEDTUTORID)));

				Subject subject = new Subject();
				subject.setName(r.getString(Subject.COL_NAME));
				t.setSubj(subject);

				tuteeList.add(t);
			}

			return tuteeList.toArray(new RequestTutor[tuteeList.size()]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

	public static Evaluation[] getMyEvaluation(String idNumber) {

		String sql = String.format(
				"SELECT %s, %s, %s, %s FROM %s, %s, %s WHERE %s=? AND %s=? AND %s.%s=%s.%s AND %s=%s",
				Evaluation.COL_REQUESTTUTORID, Account.COL_IDNUMBER, Account.COL_LASTNAME, Account.COL_FIRSTNAME,
				Evaluation.TABLE_NAME, Account.TABLE_NAME, RequestTutor.TABLE_NAME, Evaluation.COL_SENT,
				Evaluation.COL_ANSWERED, Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_REQUESTTUTORID, RequestTutor.COL_ASSIGNEDTUTORID, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, 1 + "");
			s.setString(2, 0 + "");

			System.out.println("getMyTutorList: " + s);

			r = s.executeQuery();

			ArrayList<Evaluation> evalList = new ArrayList<Evaluation>();

			while (r.next()) {
				Evaluation e = new Evaluation();

				RequestTutor requestTutor = new RequestTutor();
				requestTutor.setId(r.getInt(Evaluation.COL_REQUESTTUTORID));
				Account tutor = new Account();
				tutor.setIdNumber(r.getString(Account.COL_IDNUMBER));
				tutor.setLastName(r.getString(Account.COL_LASTNAME));
				tutor.setFirstName(r.getString(Account.COL_FIRSTNAME));

				requestTutor.setTutor(tutor);

				e.setRequestTutor(requestTutor);

				evalList.add(e);
			}

			return evalList.toArray(new Evaluation[evalList.size()]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

	public static boolean sendEvaluation(Evaluation evaluation) {

		String sqlUpdate = String.format(
				"UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
				Evaluation.TABLE_NAME, Evaluation.COL_FREQUENCY, Evaluation.COL_PREPAREDNESS,
				Evaluation.COL_EXPLANATION, Evaluation.COL_EXERCISE, Evaluation.COL_RELEVANCE,
				Evaluation.COL_ENTHUSIASM, Evaluation.COL_CONFIDENCE, Evaluation.COL_KNOWLEDGEABLE,
				Evaluation.COL_VOCAL, Evaluation.COL_QNA, Evaluation.COL_EFFECTIVENESS, Evaluation.COL_ENCOURAGING,
				Evaluation.COL_PASSION, Evaluation.COL_TUTEE_LEARNING, Evaluation.COL_TUTEE_UNDERSTANDING,
				Evaluation.COL_EFFECTIVENESS, Evaluation.COL_MESSAGE, Evaluation.COL_COMMENT, Evaluation.COL_ANSWERED,
				Evaluation.COL_REQUESTTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {
			// Add to activatedtutor table
			s = c.prepareStatement(sqlUpdate);
			s.setString(1, evaluation.getFreq() + "");
			s.setString(2, evaluation.getPrep() + "");
			s.setString(3, evaluation.getExp() + "");
			s.setString(4, evaluation.getExc() + "");
			s.setString(5, evaluation.getRel() + "");
			s.setString(6, evaluation.getEnt() + "");
			s.setString(7, evaluation.getCon() + "");
			s.setString(8, evaluation.getKno() + "");
			s.setString(9, evaluation.getVoc() + "");
			s.setString(10, evaluation.getQue() + "");
			s.setString(11, evaluation.getEff() + "");
			s.setString(12, evaluation.getEnc() + "");
			s.setString(13, evaluation.getPas() + "");
			s.setString(14, evaluation.getTutee_lrn() + "");
			s.setString(15, evaluation.getTutee_und() + "");
			s.setString(16, evaluation.getTutee_eff() + "");
			s.setString(17, evaluation.getSent() + "");
			s.setString(18, evaluation.getRead() + "");
			s.setString(19, 1 + "");
			s.setString(20, evaluation.getRequestTutor().getTutor().getIdNumber() + "");

			System.out.println("sendEvaluation: " + s);

			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	// Added 8-25-2016 1-47 - Gelo
	public static void addRequestSchedule(int requestTutorId, String requestScheduleString) {

		StringBuilder sql = new StringBuilder(
				String.format("INSERT INTO %s (%s, %s, %s) VALUES ", RequestSchedule.TABLE_NAME,
						RequestSchedule.COL_REQUESTTUTORID, RequestSchedule.COL_DAY, RequestSchedule.COL_TIME));

		String[] splitSched = requestScheduleString.split(",");

		for (int i = 0; i < splitSched.length; i++) {
			sql.append("(?, ?, ?)");
			if (i + 1 < splitSched.length)
				sql.append(", ");
		}

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {
			s = c.prepareStatement(sql.toString());

			int counter = 1;
			for (int i = 0; i < splitSched.length; i++) {
				s.setString(counter++, requestTutorId + "");
				s.setString(counter++, splitSched[i].charAt(0) + "");
				s.setString(counter++, splitSched[i].charAt(2) + "");
			}

			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static int getLastRequestTutorId() {

		String sql = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1", RequestTutor.COL_REQUESTTUTORID,
				RequestTutor.TABLE_NAME, RequestTutor.COL_REQUESTTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			r = s.executeQuery();

			if (r.next()) {
				return r.getInt(RequestTutor.COL_REQUESTTUTORID);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return -1;

	}

	// Gaius

	public static RequestTutor viewMyTutor(String tuteeidNumber, String tutoridNumber) {
		String sql = String.format("SELECT %s,%s,%s,%s,%s,%s FROM %s,%s,%s WHERE %s=? AND %s.%s = %s.%s AND %s=?",
				Account.COL_FIRSTNAME, Account.COL_LASTNAME, RequestTutor.COL_ASSIGNEDTUTORID, Subject.COL_NAME,
				RequestTutor.COL_TERM, RequestTutor.COL_YEAR, Account.TABLE_NAME, RequestTutor.TABLE_NAME,
				Subject.TABLE_NAME, RequestTutor.COL_TUTEEID, RequestTutor.TABLE_NAME, RequestTutor.COL_SUBJECTID,
				Subject.TABLE_NAME, Subject.COL_ID, RequestTutor.COL_ASSIGNEDTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;
		RequestTutor t = new RequestTutor();
		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, tuteeidNumber);
			s.setString(2, tutoridNumber);
			System.out.println("getMyTutorList: " + s);

			r = s.executeQuery();

			while (r.next()) {

				t.setYear(r.getInt(RequestTutor.COL_YEAR));
				t.setTerm(r.getInt(RequestTutor.COL_TERM));
				t.setTutor(AccountService.getUserPreviewInfo(r.getString(RequestTutor.COL_ASSIGNEDTUTORID)));
				Subject subject = new Subject();
				subject.setName(r.getString(Subject.COL_NAME));
				t.setSubj(subject);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return t;

	}

	public static Evaluation[] getTutorEvaluation(String idNumber) {

		String sql = String.format(
				"SELECT %s.%s, %s, %s, %s, %s FROM %s, %s, %s, %s WHERE %s=? AND %s=? AND %s.%s=%s.%s AND %s=%s AND %s.%s=%s.%s",
				Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID, Account.COL_IDNUMBER, Account.COL_LASTNAME,
				Account.COL_FIRSTNAME, Subject.COL_NAME, Evaluation.TABLE_NAME, Account.TABLE_NAME,
				RequestTutor.TABLE_NAME, Subject.TABLE_NAME, Evaluation.COL_SENT, Evaluation.COL_ANSWERED,
				Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_REQUESTTUTORID, RequestTutor.COL_ASSIGNEDTUTORID, Account.COL_IDNUMBER,
				RequestTutor.TABLE_NAME, RequestTutor.COL_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, 0 + "");
			s.setString(2, 0 + "");

			System.out.println("getTutorEvalList: " + s);

			r = s.executeQuery();

			ArrayList<Evaluation> evalList = new ArrayList<Evaluation>();

			while (r.next()) {
				Evaluation e = new Evaluation();
				Subject subj = new Subject();
				RequestTutor requestTutor = new RequestTutor();
				requestTutor.setId(r.getInt(Evaluation.COL_REQUESTTUTORID));
				Account tutor = new Account();
				tutor.setIdNumber(r.getString(Account.COL_IDNUMBER));
				tutor.setLastName(r.getString(Account.COL_LASTNAME));
				tutor.setFirstName(r.getString(Account.COL_FIRSTNAME));
				subj.setName(r.getString(Subject.COL_NAME));
				requestTutor.setSubj(subj);
				requestTutor.setTutor(tutor);

				e.setRequestTutor(requestTutor);

				evalList.add(e);
			}

			return evalList.toArray(new Evaluation[evalList.size()]);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

	public static RequestTutor[] viewMyTutor(String tutoridNumber) {
		String sql = String.format(
				"SELECT %s, %s,%s,%s,%s FROM %s,%s,%s WHERE %s = ? AND %s.%s = %s.%s AND %s.%s=%s.%s",
				Account.COL_IDNUMBER, Account.COL_DEGREE, Account.COL_FIRSTNAME, Account.COL_LASTNAME, Subject.COL_NAME,
				Account.TABLE_NAME, ActivatedTutor.TABLE_PREFSUBJECT_NAME, Subject.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.COL_PREFSUBJECT_ACTIVATEDTUTORID, Account.TABLE_NAME, Account.COL_IDNUMBER,
				ActivatedTutor.TABLE_PREFSUBJECT_NAME, ActivatedTutor.COL_PREFSUBJECT_SUBJECTID, Subject.TABLE_NAME,
				Subject.COL_ID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;
		RequestTutor t = new RequestTutor();
		ResultSet r = null;
		ArrayList<RequestTutor> prefSubj = new ArrayList<>();
		try {
			s = c.prepareStatement(sql);
			s.setString(1, tutoridNumber);

			System.out.println(s);
			r = s.executeQuery();

			while (r.next()) {
				Subject sub = new Subject();
				Account tutor = new Account();
				RequestTutor tutorSubs = new RequestTutor();
				tutor.setFirstName(r.getString(Account.COL_FIRSTNAME));
				tutor.setLastName(r.getString(Account.COL_LASTNAME));
				tutor.setDegree(r.getString(Account.COL_DEGREE));
				tutor.setIdNumber(r.getString(Account.COL_IDNUMBER));
				tutorSubs.setTutor(tutor);
				sub.setName(r.getString(Subject.COL_NAME));
				tutorSubs.setSubj(sub);
				prefSubj.add(tutorSubs);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return prefSubj.toArray(new RequestTutor[prefSubj.size()]);

	}
}
