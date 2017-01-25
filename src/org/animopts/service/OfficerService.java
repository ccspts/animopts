package org.animopts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.animopts.bean.Account;
import org.animopts.bean.AccountLevel;
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.DeactivatedTutor;
import org.animopts.bean.Evaluation;
import org.animopts.bean.Officer;
import org.animopts.bean.OfficerPosition;
import org.animopts.bean.PendingTutor;
import org.animopts.bean.RejectedTutor;
import org.animopts.bean.RequestSchedule;
import org.animopts.bean.RequestTutor;
import org.animopts.bean.Subject;
import org.animopts.bean.TermDetail;
import org.animopts.bean.TutorSchedule;
import org.animopts.db.DBPool;

public class OfficerService {

	public static ActivatedTutor[] getAllActivatedTutorName() {

		String sql = String.format("SELECT %s.%s, %s, %s FROM %s, %s WHERE %s.%s = %s.%s", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_LASTNAME, ActivatedTutor.COL_FIRSTNAME,
				ActivatedTutor.TABLE_NAME, Account.TABLE_NAME, ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER,
				Account.TABLE_NAME, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println("getAllActivatedTutorName: " + s);

			r = s.executeQuery();

			ArrayList<ActivatedTutor> tutorList = new ArrayList<ActivatedTutor>();

			while (r.next()) {
				ActivatedTutor t = new ActivatedTutor();
				t.setIdNumber(r.getString(ActivatedTutor.COL_IDNUMBER));
				t.setLastName(r.getString(ActivatedTutor.COL_LASTNAME));
				t.setFirstName(r.getString(ActivatedTutor.COL_FIRSTNAME));
				tutorList.add(t);
			}

			return tutorList.toArray(new ActivatedTutor[tutorList.size()]);

		} catch (

		SQLException e) {
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

	public static PendingTutor[] getAllPendingTutorName() {

		String sql = String.format("SELECT %s.%s, %s, %s, %s, %s FROM %s, %s WHERE %s.%s = %s.%s",
				PendingTutor.TABLE_NAME, PendingTutor.COL_IDNUMBER, PendingTutor.COL_LASTNAME,
				PendingTutor.COL_FIRSTNAME, PendingTutor.COL_CURRINVOLVEMENT, PendingTutor.COL_REASONFORJOINING,
				PendingTutor.TABLE_NAME, Account.TABLE_NAME, PendingTutor.TABLE_NAME, PendingTutor.COL_IDNUMBER,
				Account.TABLE_NAME, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println("getAllPendingTutorName: " + s);

			r = s.executeQuery();

			ArrayList<PendingTutor> tutorList = new ArrayList<PendingTutor>();

			while (r.next()) {
				PendingTutor t = new PendingTutor();
				t.setIdNumber(r.getString(PendingTutor.COL_IDNUMBER));
				t.setLastName(r.getString(PendingTutor.COL_LASTNAME));
				t.setFirstName(r.getString(PendingTutor.COL_FIRSTNAME));
				t.setCurrentInvolvements(r.getString(PendingTutor.COL_CURRINVOLVEMENT));
				t.setReasonForJoining(r.getString(PendingTutor.COL_REASONFORJOINING));
				tutorList.add(t);
			}

			return tutorList.toArray(new PendingTutor[tutorList.size()]);

		} catch (

		SQLException e) {
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

	public static DeactivatedTutor[] getAllDeactivatedTutorName() {

		String sql = String.format("SELECT %s.%s, %s, %s FROM %s, %s WHERE %s.%s = %s.%s", DeactivatedTutor.TABLE_NAME,
				DeactivatedTutor.COL_IDNUMBER, DeactivatedTutor.COL_LASTNAME, DeactivatedTutor.COL_FIRSTNAME,
				DeactivatedTutor.TABLE_NAME, Account.TABLE_NAME, DeactivatedTutor.TABLE_NAME,
				DeactivatedTutor.COL_IDNUMBER, Account.TABLE_NAME, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println("getAllDeactivatedTutorName: " + s);

			r = s.executeQuery();

			ArrayList<DeactivatedTutor> tutorList = new ArrayList<DeactivatedTutor>();

			while (r.next()) {
				DeactivatedTutor t = new DeactivatedTutor();
				t.setIdNumber(r.getString(DeactivatedTutor.COL_IDNUMBER));
				t.setLastName(r.getString(DeactivatedTutor.COL_LASTNAME));
				t.setFirstName(r.getString(DeactivatedTutor.COL_FIRSTNAME));
				tutorList.add(t);
			}

			return tutorList.toArray(new DeactivatedTutor[tutorList.size()]);

		} catch (

		SQLException e) {
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

	public static RejectedTutor[] getAllRejectedTutorName() {

		String sql = String.format("SELECT %s.%s, %s, %s, %s FROM %s, %s WHERE %s.%s = %s.%s", RejectedTutor.TABLE_NAME,
				RejectedTutor.COL_IDNUMBER, RejectedTutor.COL_LASTNAME, RejectedTutor.COL_FIRSTNAME,
				RejectedTutor.COL_REJECTIONREASON, RejectedTutor.TABLE_NAME, Account.TABLE_NAME,
				RejectedTutor.TABLE_NAME, RejectedTutor.COL_IDNUMBER, Account.TABLE_NAME, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println("getAllRejectedTutorName: " + s);

			r = s.executeQuery();

			ArrayList<RejectedTutor> tutorList = new ArrayList<RejectedTutor>();

			while (r.next()) {
				RejectedTutor t = new RejectedTutor();
				t.setIdNumber(r.getString(RejectedTutor.COL_IDNUMBER));
				t.setLastName(r.getString(RejectedTutor.COL_LASTNAME));
				t.setFirstName(r.getString(RejectedTutor.COL_FIRSTNAME));
				t.setRejectionReason(r.getString(RejectedTutor.COL_REJECTIONREASON));
				tutorList.add(t);
			}

			return tutorList.toArray(new RejectedTutor[tutorList.size()]);

		} catch (

		SQLException e) {
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

	public static boolean acceptPendingTutor(String idNumber) {

		String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", PendingTutor.TABLE_NAME,
				PendingTutor.COL_IDNUMBER);
		String sqlAdd = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_MAXTUTEECOUNT);
		String sqlUpdate = String.format("UPDATE %s SET %s=? WHERE %s=?", Account.TABLE_NAME, Account.COL_ACCOUNTLEVEL,
				ActivatedTutor.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Add to activatedtutor table
			s = c.prepareStatement(sqlAdd);
			s.setString(1, idNumber);
			s.setString(2, "0");

			System.out.println("acceptPendingTutor: " + s);

			isSuccessful = s.executeUpdate() > 0;

			// Delete from pendingtutor table
			s = c.prepareStatement(sqlDelete);
			s.setString(1, idNumber);

			System.out.println("acceptPendingTutor: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;

			// Update accountlevel from account
			s = c.prepareStatement(sqlUpdate);
			s.setString(1, AccountLevel.TUTOR.getValue() + "");
			s.setString(2, idNumber);

			System.out.println("acceptPendingTutor: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;
			return isSuccessful;
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

	public static boolean acceptRejectedTutor(String idNumber) {

		String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", RejectedTutor.TABLE_NAME,
				RejectedTutor.COL_IDNUMBER);
		String sqlAdd = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_MAXTUTEECOUNT);
		String sqlUpdate = String.format("UPDATE %s SET %s=? WHERE %s=?", Account.TABLE_NAME, Account.COL_ACCOUNTLEVEL,
				ActivatedTutor.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Add to activatedtutor table
			s = c.prepareStatement(sqlAdd);
			s.setString(1, idNumber);
			s.setString(2, "0");

			System.out.println("acceptRejectedTutor: " + s);

			isSuccessful = s.executeUpdate() > 0;

			// Delete from rejected table
			s = c.prepareStatement(sqlDelete);
			s.setString(1, idNumber);

			System.out.println("acceptRejectedTutor: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;

			// Update accountlevel from account
			s = c.prepareStatement(sqlUpdate);
			s.setString(1, AccountLevel.TUTOR.getValue() + "");
			s.setString(2, idNumber);

			System.out.println("acceptRejectedTutor: " + s);

			isSuccessful = s.executeUpdate() > 0;
			return isSuccessful;
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

	public static boolean rejectTutor(String idNumber, String rejectionReason) {

		String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", PendingTutor.TABLE_NAME,
				PendingTutor.COL_IDNUMBER);
		String sqlAdd = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", RejectedTutor.TABLE_NAME,
				RejectedTutor.COL_IDNUMBER, RejectedTutor.COL_REJECTIONREASON);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Add to activatedtutor table
			s = c.prepareStatement(sqlAdd);
			s.setString(1, idNumber);
			s.setString(2, rejectionReason);

			System.out.println("rejectTutor: " + s);

			isSuccessful = s.executeUpdate() > 0;

			// Delete from rejectedtutor table
			s = c.prepareStatement(sqlDelete);
			s.setString(1, idNumber);

			System.out.println("rejectTutor: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;
			return isSuccessful;
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

	public static boolean deactivateTutor(String idNumber) {

		String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER);
		String sqlAdd = String.format("INSERT INTO %s (%s) VALUES (?)", DeactivatedTutor.TABLE_NAME,
				DeactivatedTutor.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Add to deactivateTutor table
			s = c.prepareStatement(sqlAdd);
			s.setString(1, idNumber);

			System.out.println("deactivateTutor: " + s);

			isSuccessful = s.executeUpdate() > 0;

			// Delete from deactivateTutor table
			s = c.prepareStatement(sqlDelete);
			s.setString(1, idNumber);

			System.out.println("deactivateTutor: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;
			return isSuccessful;
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

	public static boolean reactivateTutor(String idNumber) {

		String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", DeactivatedTutor.TABLE_NAME,
				DeactivatedTutor.COL_IDNUMBER);
		String sqlAdd = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_MAXTUTEECOUNT);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Add to activatedtutor table
			s = c.prepareStatement(sqlAdd);
			s.setString(1, idNumber);
			s.setString(2, "0");

			System.out.println("reactivateTutor: " + s);

			isSuccessful = s.executeUpdate() > 0;

			// Delete from deactivatedtutor table
			s = c.prepareStatement(sqlDelete);
			s.setString(1, idNumber);

			System.out.println("reactivateTutor: " + s);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;
			return isSuccessful;

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

	public static boolean clearTutorDetails() {

		String sqlPrefTutorial = String.format("TRUNCATE TABLE %s", ActivatedTutor.TABLE_PREFTUTORIAL_NAME);
		String sqlPrefSubject = String.format("TRUNCATE TABLE %s", ActivatedTutor.TABLE_PREFSUBJECT_NAME);
		String sqlTutorSchedule = String.format("TRUNCATE TABLE %s", TutorSchedule.TABLE_NAME);
		String sqlMaxTuteeCount = String.format("UPDATE %s SET %s=?", ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_MAXTUTEECOUNT);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Clear preftutorial table
			s = c.prepareStatement(sqlPrefTutorial);

			isSuccessful = s.executeUpdate() > 0;

			// Clear prefsubject table
			s = c.prepareStatement(sqlPrefSubject);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;

			// Clear tutorschedule table
			s = c.prepareStatement(sqlTutorSchedule);

			isSuccessful = isSuccessful && s.executeUpdate() > 0;

			// Update activatedtutor.maxtuteecount table
			s = c.prepareStatement(sqlMaxTuteeCount);
			s.setString(1, 0 + "");

			isSuccessful = isSuccessful && s.executeUpdate() > 0;
			return isSuccessful;
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

	public static RequestTutor[] getAllTuteeWithMatch(int term, int year, boolean assigned) {

		String sql = String.format(
				"SELECT %s, %s, %s, %s, %s, %s, %s.%s, %s FROM %s, %s, %s WHERE %s IS " + (assigned ? "NOT " : "")
						+ "NULL AND %s=%s AND %s.%s = %s.%s AND %s=? AND %s=?",
				RequestTutor.COL_ASSIGNEDTUTORID, RequestTutor.COL_REQUESTTUTORID, RequestTutor.COL_TUTEEID,
				Account.COL_LASTNAME, Account.COL_FIRSTNAME, RequestTutor.COL_PREFTUTORID, Subject.TABLE_NAME,
				Subject.COL_ID, Subject.COL_NAME, Account.TABLE_NAME, RequestTutor.TABLE_NAME, Subject.TABLE_NAME,
				RequestTutor.COL_ASSIGNEDTUTORID, RequestTutor.COL_TUTEEID, Account.COL_IDNUMBER,
				RequestTutor.TABLE_NAME, RequestTutor.COL_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID,
				TermDetail.COL_TERM, TermDetail.COL_YEAR);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Clear preftutorial table
			s = c.prepareStatement(sql);
			s.setString(1, term + "");
			s.setString(2, year + "");
			System.out.println("getAllUnassignedTutee: " + s);

			ResultSet r = s.executeQuery();

			ArrayList<RequestTutor> tuteeList = new ArrayList<RequestTutor>();
			while (r.next()) {
				RequestTutor requestTutor = new RequestTutor();
				requestTutor.setId(Integer.parseInt(r.getString(RequestTutor.COL_REQUESTTUTORID)));

				// Set request tutor's tutee
				Account tutee = new Account();
				tutee.setIdNumber(r.getString(RequestTutor.COL_TUTEEID));
				tutee.setLastName(r.getString(Account.COL_LASTNAME));
				tutee.setFirstName(r.getString(Account.COL_FIRSTNAME));
				requestTutor.setTutee(tutee);

				// Set request tutor's preferredtutor
				// Because preferred can already be deactivated at the time of
				// assigning
				requestTutor.setPreferredTutor(
						AccountService.getUserPreviewInfo(r.getString(RequestTutor.COL_PREFTUTORID)));

				// Set request tutor's assignedtutor
				if (assigned)
					requestTutor
							.setTutor(AccountService.getUserPreviewInfo(r.getString(RequestTutor.COL_ASSIGNEDTUTORID)));

				// Set request tutor's subject
				Subject subject = new Subject();
				subject.setId(Integer.parseInt(r.getString(Subject.COL_ID)));
				subject.setName(r.getString(Subject.COL_NAME));
				requestTutor.setSubj(subject);

				// Set request tutor's possible tutors
				requestTutor.setPossibleTutor(getPossibleTutors(requestTutor.getId()));
				tuteeList.add(requestTutor);
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

	public static ActivatedTutor[] getPossibleTutors(int requestId) {

		String sql = String.format(
				"SELECT %s.%s, %s.%s, %s, %s, %s FROM %s, %s, %s WHERE %s = ? AND %s.%s = %s.%s AND %s.%s = %s.%s AND %s = %s",
				TutorSchedule.TABLE_NAME, TutorSchedule.COL_DAY, TutorSchedule.TABLE_NAME, TutorSchedule.COL_TIME,
				TutorSchedule.COL_ACTIVATEDTUTORID, Account.COL_FIRSTNAME, Account.COL_LASTNAME,
				RequestSchedule.TABLE_NAME, TutorSchedule.TABLE_NAME, Account.TABLE_NAME,
				RequestSchedule.COL_REQUESTTUTORID, RequestSchedule.TABLE_NAME, RequestSchedule.COL_DAY,
				TutorSchedule.TABLE_NAME, TutorSchedule.COL_DAY, RequestSchedule.TABLE_NAME, RequestSchedule.COL_TIME,
				TutorSchedule.TABLE_NAME, TutorSchedule.COL_TIME, Account.COL_IDNUMBER,
				TutorSchedule.COL_ACTIVATEDTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			boolean isSuccessful;

			// Clear preftutorial table
			s = c.prepareStatement(sql);
			s.setString(1, requestId + "");
			System.out.println("getPossibleTutors: " + s);

			ResultSet r = s.executeQuery();

			ArrayList<ActivatedTutor> tuteeList = new ArrayList<ActivatedTutor>();
			ArrayList<TutorSchedule> schedList = null;
			ActivatedTutor a = null;
			String currId = null;

			while (r.next()) {

				String newId = r.getString(TutorSchedule.COL_ACTIVATEDTUTORID);

				if (currId != null)
					System.out.println("IM CURRENTLY ON CURRID = " + currId);

				System.out.println("IM CURRENTLY ON ID = " + newId);

				if (currId == null || !currId.equals(newId)) {
					System.out.println("(CHANGED) IM CURRENTLY ON ID = " + newId);
					a = new ActivatedTutor();
					a.setIdNumber(newId);
					a.setLastName(r.getString(Account.COL_LASTNAME));
					a.setFirstName(r.getString(Account.COL_FIRSTNAME));

					if (schedList != null) {
						a.setSchedule(schedList.toArray(new TutorSchedule[schedList.size()]));
						tuteeList.add(a);
					}
					schedList = new ArrayList<TutorSchedule>();
					currId = newId;
				}

				TutorSchedule sched = new TutorSchedule();
				String[] dayList = { "M", "T", "W", "H", "F", "S" };
				sched.setDay(dayList[r.getInt(TutorSchedule.COL_DAY) - 1]);
				String[] timeList = { "7:30 AM - 9:00 AM", "9:15 AM - 10:45 AM", "11:00 AM - 12:30 PM",
						"12:45 PM - 2:15 PM", "2:30 PM - 4:00 PM", "4:15 PM - 6:00 PM", "6:00 PM - 7:00 PM" };
				sched.setTime(timeList[r.getInt(TutorSchedule.COL_DAY) - 1]);
				schedList.add(sched);

				System.out.println("IM CURRENTLY ON " + dayList[r.getInt(TutorSchedule.COL_DAY) - 1]);
			}

			if (schedList != null) {
				a.setSchedule(schedList.toArray(new TutorSchedule[schedList.size()]));
				tuteeList.add(a);
			}

			return tuteeList.toArray(new ActivatedTutor[tuteeList.size()]);
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

	public static boolean assignTutorToTutee(String tutorId, int requestId) {

		String sqlUpdate = String.format("UPDATE %s SET %s=? WHERE %s=?", RequestTutor.TABLE_NAME,
				RequestTutor.COL_ASSIGNEDTUTORID, RequestTutor.COL_REQUESTTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			s = c.prepareStatement(sqlUpdate);
			s.setString(1, tutorId);
			s.setString(2, requestId + "");

			System.out.println("assignTutorToTutee: " + s);

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

	public static boolean unassignTutorToTutee(int requestId) {

		String sqlUpdate = String.format("UPDATE %s SET %s=? WHERE %s=?", RequestTutor.TABLE_NAME,
				RequestTutor.COL_ASSIGNEDTUTORID, RequestTutor.COL_REQUESTTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			s = c.prepareStatement(sqlUpdate);
			s.setNull(1, java.sql.Types.VARCHAR);
			s.setString(2, requestId + "");

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

	public static boolean sendEvaluationRequest(int term, int year) {

		String sqlAdd = String.format("INSERT INTO %s (%s) SELECT %s.%s FROM %s WHERE %s=? AND %s=?",
				Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME, RequestTutor.COL_TERM, RequestTutor.COL_YEAR);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			// Add to activatedtutor table
			s = c.prepareStatement(sqlAdd);
			s.setString(1, term + "");
			s.setString(2, year + "");

			System.out.println("sendEvaluationRequest: " + s);

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

	public static boolean forwardEvaluation(int term, int year) {

		String sqlUpdate = String.format(
				"UPDATE %s INNER JOIN %s ON %s.%s = %s.%s SET %s=? WHERE %s=? AND %s=? AND %s=?", Evaluation.TABLE_NAME,
				RequestTutor.TABLE_NAME, Evaluation.TABLE_NAME, Evaluation.COL_REQUESTTUTORID, RequestTutor.TABLE_NAME,
				RequestTutor.COL_REQUESTTUTORID, Evaluation.COL_SENT, Evaluation.COL_ANSWERED, RequestTutor.COL_TERM,
				RequestTutor.COL_YEAR);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			s = c.prepareStatement(sqlUpdate);
			s.setString(1, 1 + "");
			s.setString(2, 1 + "");
			s.setString(3, term + "");
			s.setString(4, year + "");

			System.out.println("forwardEvaluation: " + s);

			s.executeUpdate();

			return true;
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

	public static boolean addOfficer(String activatedtutorid, String officerpositionid) {
		String sql = String.format("INSERT INTO %s VALUES(?, ?)", Officer.TABLE_NAME);
		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, activatedtutorid);
			s.setString(2, officerpositionid);

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

	public static Officer[] getOfficerList() {
		String sql = String.format(
				"SELECT %s.%s, %s.%s, %s.%s, %s.%s, %s,%s FROM %s, %s, %s, %s WHERE %s.%s = %s.%s AND %s.%s = %s.%s AND %s.%s = %s.%s",
				Account.TABLE_NAME, Account.COL_IDNUMBER, Account.TABLE_NAME, Account.COL_FIRSTNAME, Account.TABLE_NAME,
				Account.COL_LASTNAME, Account.TABLE_NAME, Account.COL_DEGREE, OfficerPosition.COL_OFFICERTITLE,
				OfficerPosition.COL_IDOFFICERPOSITION, Account.TABLE_NAME, ActivatedTutor.TABLE_NAME,
				Officer.TABLE_NAME, OfficerPosition.TABLE_NAME, Account.TABLE_NAME, Account.COL_IDNUMBER,
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, Officer.TABLE_NAME, Officer.COL_ACTIVATEDTUTORID, Officer.TABLE_NAME,
				Officer.COL_OFFICERPOSITIONID, OfficerPosition.TABLE_NAME, OfficerPosition.COL_IDOFFICERPOSITION);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println("getAllOfficer: " + s);

			r = s.executeQuery();

			ArrayList<Officer> officerList = new ArrayList<Officer>();

			while (r.next()) {
				Officer o = new Officer();
				o.setIdNumber(r.getString(Officer.COL_IDNUMBER));
				o.setLastName(r.getString(Officer.COL_LASTNAME));
				o.setFirstName(r.getString(Officer.COL_FIRSTNAME));
				o.setDegree(r.getString(Officer.COL_DEGREE));
				o.setOfficertitle(r.getString(Officer.COL_OFFICERTITLE));
				o.setOfficerpositionid(r.getString(OfficerPosition.COL_IDOFFICERPOSITION));
				officerList.add(o);
			}

			return officerList.toArray(new Officer[officerList.size()]);

		} catch (

		SQLException e) {
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

	public static Officer getSpecifiedOfficer(String idNumber) {

		String sql = String.format("SELECT %s.%s, %s, %s, %s FROM %s, %s, %s WHERE %s.%s = %s.%s AND %s.%s = %s",
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_LASTNAME,
				ActivatedTutor.COL_FIRSTNAME, ActivatedTutor.COL_DEGREE, ActivatedTutor.TABLE_NAME, Account.TABLE_NAME,
				Officer.TABLE_NAME, ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, Account.TABLE_NAME,
				Account.COL_IDNUMBER, ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER,
				Officer.COL_ACTIVATEDTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println(s + "getSpecific");

			r = s.executeQuery();
			Officer officer = new Officer();
			while (r.next()) {
				officer.setIdNumber(r.getString(ActivatedTutor.COL_IDNUMBER));
				officer.setLastName(r.getString(ActivatedTutor.COL_LASTNAME));
				officer.setFirstName(r.getString(ActivatedTutor.COL_FIRSTNAME));
				officer.setDegree(r.getString(ActivatedTutor.COL_DEGREE));
			}
			return officer;

		} catch (

		SQLException e) {
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

	public static boolean removeOfficer(String idNumber) {
		String sql = String.format("DELETE FROM %s WHERE %s = ?", Officer.TABLE_NAME, Officer.COL_ACTIVATEDTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

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

	public static boolean updateOfficer(String idNumber, String position) {
		String sql = String.format("UPDATE %s SET %s=? WHERE %s=?", Officer.TABLE_NAME, Officer.COL_OFFICERPOSITIONID,
				Officer.COL_ACTIVATEDTUTORID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {

			s = c.prepareStatement(sql);
			s.setString(1, position);
			s.setString(2, idNumber);

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
}
