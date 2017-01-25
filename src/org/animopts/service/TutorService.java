package org.animopts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.animopts.bean.Account;
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.Evaluation;
import org.animopts.bean.PendingTutor;
import org.animopts.bean.RejectedTutor;
import org.animopts.bean.RequestSchedule;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.Subject;
import org.animopts.bean.TutorSchedule;
import org.animopts.bean.TutorTypeOfTutorialEnum;
import org.animopts.db.DBPool;

public class TutorService {

	public static void addPendingTutor(PendingTutor a) {
		// INSERT INTO book(title, author, publisher, numOfPages)
		// VALUES (?, ?, ? ,?);

		String sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", PendingTutor.TABLE_NAME,
				PendingTutor.COL_IDNUMBER, PendingTutor.COL_CURRINVOLVEMENT, PendingTutor.COL_REASONFORJOINING);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {
			s = c.prepareStatement(sql);
			s.setString(1, a.getIdNumber());
			s.setString(2, a.getCurrentInvolvements());
			s.setString(3, a.getReasonForJoining());

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

	public static boolean isPending(String idNumber) {

		String sql = String.format("SELECT * FROM %s WHERE %s = ?", PendingTutor.TABLE_NAME, PendingTutor.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			r = s.executeQuery();

			return r.next();

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

	public static boolean isRejected(String idNumber) {

		String sql = String.format("SELECT * FROM %s WHERE %s = ?", RejectedTutor.TABLE_NAME,
				RejectedTutor.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			r = s.executeQuery();

			return r.next();

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

	public static RequestTutor[] getMyTuteeList(String idNumber) {

		String sql = String.format("SELECT %s, %s, %s, %s,%s,%s FROM %s,%s,%s WHERE %s=? AND %s=%s AND %s.%s=%s.%s",
				Account.COL_LASTNAME, Account.COL_FIRSTNAME, Account.COL_FBURL, Subject.COL_NAME, RequestTutor.COL_TERM,
				RequestTutor.COL_YEAR, RequestTutor.TABLE_NAME, Account.TABLE_NAME, Subject.TABLE_NAME,
				RequestTutor.COL_ASSIGNEDTUTORID, Account.COL_IDNUMBER, RequestTutor.COL_TUTEEID, Subject.TABLE_NAME,
				Subject.COL_ID, RequestTutor.TABLE_NAME, RequestTutor.COL_SUBJECTID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			System.out.println("getMyTuteeList: " + s);

			r = s.executeQuery();

			ArrayList<RequestTutor> tuteeList = new ArrayList<RequestTutor>();

			while (r.next()) {
				RequestTutor t = new RequestTutor();
				t.setYear(r.getInt(RequestTutor.COL_YEAR));
				t.setTerm(r.getInt(RequestTutor.COL_TERM));

				Account tutee = new Account();
				tutee.setFirstName(r.getString(Account.COL_FIRSTNAME));
				tutee.setLastName(r.getString(Account.COL_LASTNAME));
				tutee.setFbUrl(r.getString(Account.COL_FBURL));
				t.setTutee(tutee);

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

	public static boolean updateTutor(ActivatedTutor tutor, String scheduleString) {

		String sqlMaxTuteeCount = String.format("UPDATE %s SET %s=? WHERE %s=?", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_MAXTUTEECOUNT, ActivatedTutor.COL_IDNUMBER);
		String sqlPrefTutorial = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ? ,?)",
				ActivatedTutor.TABLE_PREFTUTORIAL_NAME, ActivatedTutor.COL_PREFTUTORIAL_ACTIVATEDTUTORID,
				ActivatedTutor.COL_PREFTUTORIAL_SOLO, ActivatedTutor.COL_PREFTUTORIAL_PAIR,
				ActivatedTutor.COL_PREFTUTORIAL_GROUP, ActivatedTutor.COL_PREFTUTORIAL_CLASSROOM);
		String sqlPrefSubject = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)",
				ActivatedTutor.TABLE_PREFSUBJECT_NAME, ActivatedTutor.COL_PREFSUBJECT_ACTIVATEDTUTORID,
				ActivatedTutor.COL_PREFSUBJECT_SUBJECTID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Update activatedtutor.maxtuteecount
			s = c.prepareStatement(sqlMaxTuteeCount);
			s.setString(1, tutor.getMaxTuteeCount() + "");
			s.setString(2, tutor.getIdNumber());

			System.out.println("updateTutor sqlMaxTuteeCount: " + s);

			isSuccessful = s.executeUpdate() > 0;

			// Add preftutorial
			s = c.prepareStatement(sqlPrefTutorial);
			s.setString(1, tutor.getIdNumber());
			s.setString(2, 0 + "");
			s.setString(3, 0 + "");
			s.setString(4, 0 + "");
			s.setString(5, 0 + "");

			TutorTypeOfTutorialEnum[] t = tutor.getPreferredTutorial();
			for (int i = 0; i < tutor.getPreferredTutorial().length; i++) {
				if (t[i] == TutorTypeOfTutorialEnum.SOLO)
					s.setString(2, 1 + "");
				else if (t[i] == TutorTypeOfTutorialEnum.PAIR)
					s.setString(3, 1 + "");
				else if (t[i] == TutorTypeOfTutorialEnum.GROUP)
					s.setString(4, 1 + "");
				else if (t[i] == TutorTypeOfTutorialEnum.CLASSROOM)
					s.setString(5, 1 + "");
			}

			System.out.println("updateTutor sqlPrefTutorial: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;

			// Add prefsubjects
			for (int i = 0; i < tutor.getPreferredSubject().length; i++) {
				s = c.prepareStatement(sqlPrefSubject);
				s.setString(1, tutor.getIdNumber());
				s.setString(2, tutor.getPreferredSubject()[i].getId() + "");

				System.out.println("updateTutor sqlPrefSubject: " + s);
				isSuccessful = isSuccessful && s.executeUpdate() > 0;
			}

			// Add tutorschedules
			return isSuccessful && updateTutorSchedule(tutor.getIdNumber(), scheduleString);
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

	public static Evaluation[] getMyEvaluation(String idNumber, int term, int year) {

		String sql = String.format(
				"SELECT %s.*, %s, %s, %s, %s, %s, %s FROM %s, %s, %s, %s WHERE %s=? AND %s.%s = ? AND %s.%s = ? AND %s.%s = %s.%s AND %s=? AND %s=? AND %s.%s = %s.%s AND %s.%s = %s.%s ORDER BY %s DESC, %s DESC, %s ASC, %s ASC",
				Evaluation.TABLE_NAME, RequestTutor.COL_YEAR, RequestTutor.COL_TERM, Account.COL_LASTNAME,
				Account.COL_FIRSTNAME, Account.COL_IDNUMBER, Subject.COL_NAME, Subject.TABLE_NAME,
				Evaluation.TABLE_NAME, RequestTutor.TABLE_NAME, Account.TABLE_NAME, RequestTutor.COL_TUTEEID,
				RequestTutor.TABLE_NAME, RequestTutor.COL_TERM, RequestTutor.TABLE_NAME, RequestTutor.COL_YEAR,
				RequestTutor.TABLE_NAME, RequestTutor.COL_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID,
				Evaluation.COL_ANSWERED, Evaluation.COL_SENT, Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID,
				RequestTutor.TABLE_NAME, RequestTutor.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_ASSIGNEDTUTORID, Account.TABLE_NAME, Account.COL_IDNUMBER, RequestTutor.COL_TERM,
				RequestTutor.COL_YEAR, Account.COL_LASTNAME, Account.COL_FIRSTNAME);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);
			s.setInt(2, term);
			s.setInt(3, year);
			s.setString(4, 0 + "");
			s.setString(5, 1 + "");
			System.out.println("getMyEvaluation: " + s);
			r = s.executeQuery();

			ArrayList<Evaluation> evalList = new ArrayList<Evaluation>();
			while (r.next()) {
				Evaluation e = new Evaluation();
				e.setAnswered(r.getInt(Evaluation.COL_ANSWERED) == 1);
				e.setComment(r.getString(Evaluation.COL_COMMENT));
				e.setCon(r.getFloat(Evaluation.COL_CONFIDENCE));
				e.setEff(r.getFloat(Evaluation.COL_EFFECTIVENESS));
				e.setEnc(r.getFloat(Evaluation.COL_ENCOURAGING));
				e.setEnt(r.getFloat(Evaluation.COL_ENTHUSIASM));
				e.setExc(r.getFloat(Evaluation.COL_EXERCISE));
				e.setExp(r.getFloat(Evaluation.COL_EXPLANATION));
				e.setFreq(r.getFloat(Evaluation.COL_FREQUENCY));
				e.setKno(r.getFloat(Evaluation.COL_KNOWLEDGEABLE));
				e.setMessage(r.getString(Evaluation.COL_MESSAGE));
				e.setPas(r.getFloat(Evaluation.COL_PASSION));
				e.setPrep(r.getFloat(Evaluation.COL_PREPAREDNESS));
				e.setQue(r.getFloat(Evaluation.COL_QNA));
				e.setRel(r.getFloat(Evaluation.COL_RELEVANCE));
				e.setVoc(r.getFloat(Evaluation.COL_VOCAL));
				Subject subj = new Subject();
				subj.setName(r.getString(Subject.COL_NAME));
				RequestTutor requestTutor = new RequestTutor();
				requestTutor.setId(r.getInt(Evaluation.COL_REQUESTTUTORID));
				requestTutor.setSubj(subj);
				Account tutor = new Account();
				tutor.setIdNumber(r.getString(Account.COL_IDNUMBER));
				tutor.setLastName(r.getString(Account.COL_LASTNAME));
				tutor.setFirstName(r.getString(Account.COL_FIRSTNAME));
				requestTutor.setTutor(tutor);
				requestTutor.setTerm(r.getInt(RequestTutor.COL_TERM));
				requestTutor.setYear(r.getInt(RequestTutor.COL_YEAR));
				e.setRequestTutor(requestTutor);
				// e.setTutee_eff(r.getFloat(Evaluation.COL_TUTEE_EFFECTIVENESS));
				// e.setTutee_lrn(r.getFloat(Evaluation.COL_TUTEE_LEARNING));
				// e.setTutee_und(r.getFloat(Evaluation.COL_TUTEE_UNDERSTANDING));

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

	// Added 8-25-2016 3-36 - Gelo

	// public static boolean removeAllTutorScheduleById(String idNumber) {
	//
	// String sqlDelete = String.format("DELETE FROM %s WHERE %s=?",
	// TutorSchedule.TABLE_NAME,
	// TutorSchedule.COL_ACTIVATEDTUTORID);
	//
	// Connection c = DBPool.getInstance().getConnection();
	// PreparedStatement s = null;
	//
	// try {
	//
	// boolean isSuccessful;
	//
	// // Delete from rejectedtutor table
	// s = c.prepareStatement(sqlDelete);
	// s.setString(1, idNumber);
	//
	// System.out.println("removeAllTutorScheduleById: " + s);
	//
	// isSuccessful = s.executeUpdate() > 0;
	// return isSuccessful;
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// s.close();
	// c.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return false;
	// }
	//
	// public static boolean removeAllPrefSubjectById(String idNumber) {
	//
	// String sqlDelete = String.format("DELETE FROM %s WHERE %s=?",
	// ActivatedTutor.TABLE_PREFSUBJECT_NAME,
	// ActivatedTutor.COL_PREFSUBJECT_ACTIVATEDTUTORID);
	//
	// Connection c = DBPool.getInstance().getConnection();
	// PreparedStatement s = null;
	//
	// try {
	//
	// boolean isSuccessful;
	//
	// // Delete from rejectedtutor table
	// s = c.prepareStatement(sqlDelete);
	// s.setString(1, idNumber);
	//
	// System.out.println("removeAllPrefSubjectById: " + s);
	//
	// isSuccessful = s.executeUpdate() > 0;
	// return isSuccessful;
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// s.close();
	// c.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return false;
	// }
	//
	// public static boolean removeAllPrefTutorialById(String idNumber) {
	//
	// String sqlDelete = String.format("DELETE FROM %s WHERE %s=?",
	// ActivatedTutor.TABLE_PREFTUTORIAL_NAME,
	// ActivatedTutor.COL_PREFTUTORIAL_ACTIVATEDTUTORID);
	//
	// Connection c = DBPool.getInstance().getConnection();
	// PreparedStatement s = null;
	//
	// try {
	//
	// boolean isSuccessful;
	//
	// // Delete from rejectedtutor table
	// s = c.prepareStatement(sqlDelete);
	// s.setString(1, idNumber);
	//
	// System.out.println("removeAllPrefTutorialById: " + s);
	//
	// isSuccessful = s.executeUpdate() > 0;
	// return isSuccessful;
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// try {
	// s.close();
	// c.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return false;
	// }

	public static boolean updateTutorSchedule(String activatedTutorId, String scheduleString) {

		StringBuilder sql = new StringBuilder(
				String.format("INSERT INTO %s (%s, %s, %s) VALUES ", TutorSchedule.TABLE_NAME,
						TutorSchedule.COL_ACTIVATEDTUTORID, RequestSchedule.COL_DAY, RequestSchedule.COL_TIME));

		String[] splitSched = scheduleString.split(",");

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
				s.setString(counter++, activatedTutorId + "");
				s.setString(counter++, splitSched[i].charAt(0) + "");
				s.setString(counter++, splitSched[i].charAt(2) + "");
			}

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

	public static boolean isDetailsUpdated(String idNumber) {

		String sql = String.format("SELECT %s FROM %s WHERE %s=? LIMIT 1",
				ActivatedTutor.COL_PREFSUBJECT_ACTIVATEDTUTORID, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.COL_PREFSUBJECT_ACTIVATEDTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);
			System.out.println("isDetailsUpdated: " + s);
			r = s.executeQuery();

			if (r.next()) {
				return true;
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

		return false;

	}

	// Gaius

	public static Evaluation getViewEvaluation(String tuteeidNumber, int term, int year, String tutoridNumber) {

		String sql = String.format(
				"SELECT %s.*, %s, %s, %s, %s, %s, %s FROM %s, %s, %s, %s WHERE %s=? AND %s.%s = ? AND %s.%s = ? AND %s.%s = %s.%s AND %s=? AND %s=? AND %s.%s = %s.%s AND %s.%s = %s.%s AND %s = ?",
				Evaluation.TABLE_NAME, RequestTutor.COL_YEAR, RequestTutor.COL_TERM, Account.COL_LASTNAME,
				Account.COL_FIRSTNAME, Account.COL_IDNUMBER, Subject.COL_NAME, Subject.TABLE_NAME,
				Evaluation.TABLE_NAME, RequestTutor.TABLE_NAME, Account.TABLE_NAME, RequestTutor.COL_TUTEEID,
				RequestTutor.TABLE_NAME, RequestTutor.COL_TERM, RequestTutor.TABLE_NAME, RequestTutor.COL_YEAR,
				RequestTutor.TABLE_NAME, RequestTutor.COL_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID,
				Evaluation.COL_ANSWERED, Evaluation.COL_SENT, Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID,
				RequestTutor.TABLE_NAME, RequestTutor.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_ASSIGNEDTUTORID, Account.TABLE_NAME, Account.COL_IDNUMBER, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, tuteeidNumber);
			s.setInt(2, term);
			s.setInt(3, year);
			s.setString(4, 0 + "");
			s.setString(5, 1 + "");
			s.setString(6, tutoridNumber);
			System.out.println("getMyEvaluation: " + s);
			r = s.executeQuery();

			Evaluation e = new Evaluation();
			while (r.next()) {

				e.setAnswered(r.getInt(Evaluation.COL_ANSWERED) == 1);
				e.setComment(r.getString(Evaluation.COL_COMMENT));
				e.setCon(r.getFloat(Evaluation.COL_CONFIDENCE));
				e.setEff(r.getFloat(Evaluation.COL_EFFECTIVENESS));
				e.setEnc(r.getFloat(Evaluation.COL_ENCOURAGING));
				e.setEnt(r.getFloat(Evaluation.COL_ENTHUSIASM));
				e.setExc(r.getFloat(Evaluation.COL_EXERCISE));
				e.setExp(r.getFloat(Evaluation.COL_EXPLANATION));
				e.setFreq(r.getFloat(Evaluation.COL_FREQUENCY));
				e.setKno(r.getFloat(Evaluation.COL_KNOWLEDGEABLE));
				e.setMessage(r.getString(Evaluation.COL_MESSAGE));
				e.setPas(r.getFloat(Evaluation.COL_PASSION));
				e.setPrep(r.getFloat(Evaluation.COL_PREPAREDNESS));
				e.setQue(r.getFloat(Evaluation.COL_QNA));
				e.setRel(r.getFloat(Evaluation.COL_RELEVANCE));
				e.setVoc(r.getFloat(Evaluation.COL_VOCAL));
				Subject subj = new Subject();
				subj.setName(r.getString(Subject.COL_NAME));
				RequestTutor requestTutor = new RequestTutor();
				requestTutor.setId(r.getInt(Evaluation.COL_REQUESTTUTORID));
				requestTutor.setSubj(subj);
				Account tutor = new Account();
				tutor.setIdNumber(r.getString(Account.COL_IDNUMBER));
				tutor.setLastName(r.getString(Account.COL_LASTNAME));
				tutor.setFirstName(r.getString(Account.COL_FIRSTNAME));
				requestTutor.setTutor(tutor);
				requestTutor.setTerm(r.getInt(RequestTutor.COL_TERM));
				requestTutor.setYear(r.getInt(RequestTutor.COL_YEAR));
				e.setRequestTutor(requestTutor);
				// e.setTutee_eff(r.getFloat(Evaluation.COL_TUTEE_EFFECTIVENESS));
				// e.setTutee_lrn(r.getFloat(Evaluation.COL_TUTEE_LEARNING));
				// e.setTutee_und(r.getFloat(Evaluation.COL_TUTEE_UNDERSTANDING));

			}
			return e;

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
}
