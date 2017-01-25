package org.animopts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.animopts.bean.Subject;
import org.animopts.bean.Tag;
import org.animopts.db.DBPool;

public class SubjectService {

	public static Subject[] getAllOfferedSubject() {

		String sql = String.format("SELECT * FROM %s WHERE %s=1", Subject.TABLE_NAME, Subject.COL_ISOFFERED);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			r = s.executeQuery();

			ArrayList<Subject> subjectList = new ArrayList<Subject>();

			while (r.next()) {
				Subject subject = new Subject();
				subject.setId(r.getInt(Subject.COL_ID));
				subject.setName(r.getString(Subject.COL_NAME));
				subject.setOffered(r.getInt(Subject.COL_ISOFFERED) == 1);
				subject.setTagList(getTagsFromSubject(subject.getId()));
				subjectList.add(subject);
			}

			return subjectList.toArray(new Subject[subjectList.size()]);

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

	public static ArrayList<Tag> getTagsFromSubject(int subjectId) {
		String sql = String.format("SELECT * FROM %s WHERE %s = ?", Tag.TABLE_NAME, Tag.COL_SUBJECTID);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);
			s.setString(1, subjectId + "");

			System.out.println(s);
			r = s.executeQuery();

			ArrayList<Tag> tagList = new ArrayList<Tag>();

			while (r.next()) {
				Tag t = new Tag();
				t.setId(r.getInt(Tag.COL_ID));
				t.setName(r.getString(Tag.COL_NAME));

				tagList.add(t);
			}

			return tagList;

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
