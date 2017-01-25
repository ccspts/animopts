package org.animopts.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.animopts.bean.Account;
import org.animopts.bean.AccountLevel;
import org.animopts.bean.ActivatedTutor;
import org.animopts.bean.Officer;
import org.animopts.bean.Subject;
import org.animopts.db.DBPool;
import org.animopts.db.Security;

public class AccountService {
	public static boolean addAccount(Account a) {
		// INSERT INTO book(title, author, publisher, numOfPages)
		// VALUES (?, ?, ? ,?);

		String sql = String.format(
				"INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
				Account.TABLE_NAME, Account.COL_IDNUMBER, Account.COL_LASTNAME, Account.COL_FIRSTNAME,
				Account.COL_DEGREE, Account.COL_FBURL, Account.COL_MOBILENUM, Account.COL_EMAIL, Account.COL_PASSWORD,
				Account.COL_ACCOUNTLEVEL);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {
			a.setPassword(Security.sha1(a.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			s = c.prepareStatement(sql);
			s.setString(1, a.getIdNumber());
			s.setString(2, a.getLastName());
			s.setString(3, a.getFirstName());
			s.setString(4, a.getDegree());
			s.setString(5, a.getFbUrl());
			s.setString(6, a.getMobileNum());
			s.setString(7, a.getEmail());
			s.setString(8, a.getPassword());
			s.setString(9, a.getAccountLevel().getValue() + "");

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

	public static boolean udpateAccount(Account a) {
		// INSERT INTO book(title, author, publisher, numOfPages)
		// VALUES (?, ?, ? ,?);

		// UPDATE `animopts`.`requesttutor` SET `tutorialtype`='3' WHERE
		// `requesttutorid`='2';

		String sql = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=? AND %s=?",
				Account.TABLE_NAME, Account.COL_LASTNAME, Account.COL_FIRSTNAME, Account.COL_DEGREE, Account.COL_FBURL,
				Account.COL_MOBILENUM, Account.COL_EMAIL, Account.COL_IDNUMBER, Account.COL_PASSWORD);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		try {
			a.setPassword(Security.sha1(a.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			s = c.prepareStatement(sql);
			s.setString(1, a.getLastName());
			s.setString(2, a.getFirstName());
			s.setString(3, a.getDegree());
			s.setString(4, a.getFbUrl());
			s.setString(5, a.getMobileNum());
			s.setString(6, a.getEmail());
			s.setString(7, a.getIdNumber());
			s.setString(8, a.getPassword());

			System.out.println(s);

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

	public static boolean login(String idNumber, String password) {

		String sql = String.format("SELECT idnumber FROM %s WHERE %s = ? AND %s = ?", Account.TABLE_NAME,
				Account.COL_IDNUMBER, Account.COL_PASSWORD);

		try {
			password = Security.sha1(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);
			s.setString(2, password);

			System.out.println("login: " + s);

			r = s.executeQuery();

			if (r.next())
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

	public static Account getUser(String idNumber) {

		String sql = String.format("SELECT * FROM %s WHERE %s = ?", Account.TABLE_NAME, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			r = s.executeQuery();

			if (r.next()) {
				Account a = new Account();
				a.setFirstName(r.getString(Account.COL_FIRSTNAME));
				a.setLastName(r.getString(Account.COL_LASTNAME));
				a.setDegree(r.getString(Account.COL_DEGREE));
				a.setFbUrl(r.getString(Account.COL_FBURL));
				a.setIdNumber(r.getString(Account.COL_IDNUMBER));
				a.setMobileNum(r.getString(Account.COL_MOBILENUM));
				a.setAccountLevel(AccountLevel.valueOf(r.getInt(Account.COL_ACCOUNTLEVEL)));
				a.setEmail(r.getString(Account.COL_EMAIL));

				return a;
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

		return null;

	}

	public static Account getUserPreviewInfo(String idNumber) {

		String sql = String.format("SELECT %s, %s, %s, %s, %s FROM %s WHERE %s = ?", Account.COL_IDNUMBER,
				Account.COL_LASTNAME, Account.COL_FIRSTNAME, Account.COL_ACCOUNTLEVEL, Account.COL_FBURL,
				Account.TABLE_NAME, Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			r = s.executeQuery();

			if (r.next()) {
				Account a = new Account();
				a.setIdNumber(r.getString(Account.COL_IDNUMBER));
				a.setFirstName(r.getString(Account.COL_FIRSTNAME));
				a.setLastName(r.getString(Account.COL_LASTNAME));
				a.setAccountLevel(AccountLevel.valueOf(r.getInt(Account.COL_ACCOUNTLEVEL)));
				a.setFbUrl(r.getString(Account.COL_FBURL));

				return a;
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

		return null;

	}

	public static AccountLevel getUserAccountLevel(String idNumber) {

		String sql = String.format("SELECT %s FROM %s WHERE %s = ?", Account.COL_ACCOUNTLEVEL, Account.TABLE_NAME,
				Account.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

			r = s.executeQuery();

			if (r.next()) {
				return AccountLevel.valueOf(r.getInt(Account.COL_ACCOUNTLEVEL));
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

		return null;

	}

	public static ActivatedTutor[] getAllActivatedTutorName(String idNumber) {

		String sql = String.format("SELECT %s.%s, %s, %s, %s FROM %s, %s WHERE %s.%s = %s.%s AND %s>0 AND %s.%s<>?",
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_LASTNAME,
				ActivatedTutor.COL_FIRSTNAME, ActivatedTutor.COL_MAXTUTEECOUNT, ActivatedTutor.TABLE_NAME,
				Account.TABLE_NAME, ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, Account.TABLE_NAME,
				Account.COL_IDNUMBER, ActivatedTutor.COL_MAXTUTEECOUNT, ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, idNumber);

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

	public static ActivatedTutor[] getAllActivatedTutorNameWithSubject() {
		String sql = String.format(
				"SELECT * FROM %s, %s, %s, %s WHERE %s.%s = %s.%s AND %s.%s = %s.%s AND %s.%s = %s.%s ",
				ActivatedTutor.TABLE_NAME, Account.TABLE_NAME, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, Account.TABLE_NAME, Account.COL_IDNUMBER,
				ActivatedTutor.TABLE_PREFSUBJECT_NAME, ActivatedTutor.COL_PREFTUTORIAL_ACTIVATEDTUTORID,
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.COL_PREFSUBJECT_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			r = s.executeQuery();

			ArrayList<ActivatedTutor> tutorList = new ArrayList<ActivatedTutor>();

			while (r.next()) {
				ActivatedTutor t = new ActivatedTutor();

				t.setPreferredSubject(
						AccountService.getSpefActivatedTutorPrefSubjects(r.getString(ActivatedTutor.COL_IDNUMBER)));
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

	public static Subject[] getSpefActivatedTutorPrefSubjects(String activeTutorID) {

		String sql = String.format("SELECT * FROM %s, %s, %s WHERE %s.s=%s AND %s.%s = %s.%s AND %s.%s = %s.%s ",
				ActivatedTutor.TABLE_NAME, Subject.TABLE_NAME, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, activeTutorID, ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.COL_PREFSUBJECT_ACTIVATEDTUTORID, ActivatedTutor.TABLE_PREFSUBJECT_NAME,
				ActivatedTutor.COL_PREFSUBJECT_SUBJECTID, Subject.TABLE_NAME, Subject.COL_ID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			r = s.executeQuery();

			ArrayList<Subject> subList = new ArrayList<Subject>();

			while (r.next()) {
				Subject sub = new Subject();

				sub.setId(r.getInt(Subject.COL_ID));
				sub.setName(r.getString(Subject.COL_NAME));
				sub.setName(r.getString(Subject.COL_NAME));

				subList.add(sub);
			}

			return subList.toArray(new Subject[subList.size()]);

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

	public static ActivatedTutor[] getAllActivatedTutorNotOfficers(String idNumber) {

		String sql = String.format(
				"SELECT %s.%s, %s, %s FROM %s, %s WHERE %s.%s = %s.%s AND %s.%s NOT IN (SELECT %s FROM %s)",
				ActivatedTutor.TABLE_NAME, ActivatedTutor.COL_IDNUMBER, ActivatedTutor.COL_LASTNAME,
				ActivatedTutor.COL_FIRSTNAME, ActivatedTutor.TABLE_NAME, Account.TABLE_NAME, ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, Account.TABLE_NAME, Account.COL_IDNUMBER, ActivatedTutor.TABLE_NAME,
				ActivatedTutor.COL_IDNUMBER, Officer.COL_ACTIVATEDTUTORID, Officer.TABLE_NAME);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			System.out.println(s);

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
}
