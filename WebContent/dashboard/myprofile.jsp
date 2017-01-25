<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Account" class="org.animopts.bean.Account" scope="session"/>

<template:dashboard-template pageTitle="My Profile">
	<jsp:attribute name="body">
	
<div class="col-lg-6">
    <h2>
        My Profile
    </h2>
    <br>
        <div class="col-lg-12 well">
            <div class="row">
                <form action="dashboard/myprofile/submit" method="POST" data-toggle="validator">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label>
                                Name
                            </label>
                            <div class="row">
                                <div class="col-xs-6 col-md-6">
                                    <input class="form-control" name="${Account.COL_FIRSTNAME}" placeholder="First" type="text" value="${firstname}" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="col-xs-6 col-md-6">
                                    <input class="form-control" name="${Account.COL_LASTNAME}" placeholder="Last" type="text" value="${lastname}" required>
                                    <div class="help-block with-errors"></div>
                                    </input>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-xs-6 col-md-6">
                                    <label>
                                        ID Number
                                    </label>
                                    <input class="form-control form-id-edit" name="${Account.COL_IDNUMBER}" placeholder="ID Number" type="number" value="${idnumber}" readonly="readonly">
                                    </input>
                                </div>
                                <div class="col-xs-6 col-md-6">
                                    <label>
                                        Degree
                                    </label>
                                    <br>
                                        <select class="selectpicker form-control" name="${Account.COL_DEGREE}" title="Your Degree" required>
                                            <option <c:if test="${degree == 'BSCS'}">selected="selected"</c:if> >
                                                BSCS
                                            </option>
                                            <option <c:if test="${degree == 'CS-ST'}">selected="selected"</c:if>>
                                                CS-ST
                                            </option>
                                            <option <c:if test="${degree == 'CS-NE'}">selected="selected"</c:if>>
                                                CS-NE
                                            </option>
                                            <option <c:if test="${degree == 'CS-IST'}">selected="selected"</c:if>>
                                                CS-IST
                                            </option>
                                            <option <c:if test="${degree == 'BSCS-CSE'}">selected="selected"</c:if>>
                                                BSCS-CSE
                                            </option>
                                            <option <c:if test="${degree == 'BS-INSYS'}">selected="selected"</c:if>>
                                                BS-INSYS
                                            </option>
                                            <option <c:if test="${degree == 'BSIT'}">selected="selected"</c:if>>
                                                BSIT
                                            </option>
                                            <option data-divider="true">
                                            </option>
                                            <option <c:if test="${degree == 'Other'}">selected="selected"</c:if>>
                                                Other
                                            </option>
                                        </select>
                                    	<div class="help-block with-errors"></div>
                                    </br>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>
                                Facebook URL
                            </label>
                            <input class="form-control" name="${Account.COL_FBURL}" placeholder="Your Facebook URL Here.." type="text" value="${fburl}" required>
                            <p class="small note">
                                * We will contact you through this profile.
                            </p>
							<div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label>
                                Mobile Number
                            </label>
                            <div class="input-group">
	                            <span class="input-group-addon">+639</span>
	                            <input class="form-control" name="${Account.COL_MOBILENUM}" placeholder="Your Mobile Number Here.." type="number" value="${mobilenum}" required>
                                <div class="help-block with-errors"></div>
                            </div>
                            </input>
                        </div>
                        <div class="form-group">
                            <label>
                                Email
                            </label>
                            <input class="form-control" name="${Account.COL_EMAIL}" placeholder="Your Email Here.." type="email" value="${email}" required>
							<div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <label>
                                Current Password
                            </label>
                            <input class="form-control" name="${Account.COL_PASSWORD}" placeholder="Your Current Password Here.." type="password" required>
                                <p class="small note">
                                    * To verify your edits.
                                </p>
                                <div class="help-block with-errors"></div>
                        </div>
<!--                         <div class="alert alert-dismissible alert-danger"> -->
<!--   										<p>Incorrect password</p> -->
<!-- 									</div> -->
                        
                        <img src="<c:url value="/img/temp_captcha.gif" />" style="width: 300px; height: auto;"/>
                        <br>
                            <br>
                                <button class="btn btn-md btn-info" type="submit">
                                    Submit
                                </button>
                            </br>
                        </br>
                    </div>
                </form>
            </div>
        </div>
    </br>
</div>

</jsp:attribute>
</template:dashboard-template>