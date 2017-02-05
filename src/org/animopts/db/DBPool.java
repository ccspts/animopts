package org.animopts.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBPool {

	private static String DB_FILE = "dbconfig.xml";
	private static DBPool dbPool = null;
	private static BasicDataSource basicDataSource;

	private DBPool() {
		System.out.println("Establishing database connection pool");
		Document doc = null;
		try {
			System.out.println("Loading database config file: dbconfig.xml");
			ClassLoader classLoader = this.getClass().getClassLoader();
			InputStream input = classLoader.getResourceAsStream(DB_FILE);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(input);
		} catch (IOException e) {
			System.out.println("File not found(" + DB_FILE + ")");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "";
		String username = "";
		String password = "";
		String driver = "";
		
		try {
			Element database = doc.getDocumentElement();
			url = database.getElementsByTagName("url").item(0).getTextContent();
			username = database.getElementsByTagName("username").item(0).getTextContent();
			password = database.getElementsByTagName("password").item(0).getTextContent();
			driver = database.getElementsByTagName("driver").item(0).getTextContent();
		} catch (DOMException e) {
			e.printStackTrace();
		}
		
		System.out.println("User(" + username + ") Connecting to (" + url + ") using (" + driver + ")");
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		System.out.println("SUCCESS::Database connection pool established");
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
			e.printStackTrace();
		}

		return null;
	}
}
