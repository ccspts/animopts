package org.animopts.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBPool {

	public final static String url = "jdbc:mysql://localhost:3306/animopts";
	public final static String username = "root";
	public final static String password = "password";
	public final static String driver = "com.mysql.jdbc.Driver";

	private static DBPool dbPool = null;
	private static BasicDataSource basicDataSource;

	private DBPool() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
	}

	public static DBPool getInstance() {
		if (dbPool == null)
			dbPool = new DBPool();

		return dbPool;
	}

	public static Connection getConnection() {
		if (basicDataSource == null)
			return null;

		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
