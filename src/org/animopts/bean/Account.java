package org.animopts.bean;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	public static final String COOKIE_IDNUMBER = "userid";

	private static final long serialVersionUID = 1L;
	public static final String TABLE_NAME = "account";
	public static final String COL_IDNUMBER = "idnumber";
	public static final String COL_LASTNAME = "lastname";
	public static final String COL_FIRSTNAME = "firstname";
	public static final String COL_DEGREE = "degree";
	public static final String COL_FBURL = "fburl";
	public static final String COL_MOBILENUM = "mobilenum";
	public static final String COL_EMAIL = "email";
	public static final String COL_PASSWORD = "password";
	public static final String COL_ACCOUNTLEVEL = "accountlevel";

	public String getCOL_IDNUMBER() {
		return COL_IDNUMBER;
	}

	public String getCOL_LASTNAME() {
		return COL_LASTNAME;
	}

	public String getCOL_FIRSTNAME() {
		return COL_FIRSTNAME;
	}

	public String getCOL_DEGREE() {
		return COL_DEGREE;
	}

	public String getCOL_FBURL() {
		return COL_FBURL;
	}

	public String getCOL_MOBILENUM() {
		return COL_MOBILENUM;
	}

	public String getCOL_EMAIL() {
		return COL_EMAIL;
	}

	public String getCOL_PASSWORD() {
		return COL_PASSWORD;
	}

	public String getCOL_ACCOUNTLEVEL() {
		return COL_ACCOUNTLEVEL;
	}

	private String idNumber;
	private String lastName;
	private String firstName;
	private String degree;
	private String fbUrl;
	private String mobileNum;
	private String email;
	private String password;
	private AccountLevel accountLevel;

	public Account() {

	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getFbUrl() {
		return fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountLevel getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(AccountLevel accountLevel) {
		this.accountLevel = accountLevel;
	}

}
