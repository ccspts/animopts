package org.animopts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.animopts.bean.TermDetail;
import org.animopts.db.DBPool;

public class GlobalService {

	public static TermDetail getTermDetail() {

		String sql = String.format("SELECT * FROM %s", TermDetail.TABLE_NAME);

		Connection c = DBPool.getInstance().getConnection();
		PreparedStatement s = null;

		ResultSet r = null;
		try {
			s = c.prepareStatement(sql);

			r = s.executeQuery();

			if (r.next()) {
				TermDetail d = new TermDetail();
				d.setYear(r.getInt(TermDetail.COL_YEAR));
				d.setTerm(r.getInt(TermDetail.COL_TERM));

				return d;
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
}
