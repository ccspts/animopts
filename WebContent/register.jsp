<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Account" class="org.animopts.bean.Account" scope="session"/>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>

<template:register-template pageTitle="Register an Account">
	<jsp:attribute name="body">
	
<section id="register-tutee" class="register-tutee-section">
    <div class="container">
        <h1 class="text-center">Register an Account</h1>
        <div class="row">
            <div class="col-lg-5">
                <h2>Note: Only open for CCS</h2>
                <p>We only accept tutor requests for courses and topics under CCS. For courses and topics not under CCS, please consult the college in which the course or topic would fall under. Thank you!</p>
                <p>For concerns, please contact 09173171215.</p>
            </div>
            <div class="col-lg-7">
                <div class="col-lg-12 well">
                    <div class="row">
                        <form action="register" method="POST" data-toggle="validator">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label>Name</label>
                                    <div class="row">
                                        <div class="col-xs-6 col-md-6">
                                            <input type="text" placeholder="First" name="${Account.COL_FIRSTNAME}" class="form-control" required>
                                    		<div class="help-block with-errors"></div>
                                        </div>
                                        <div class="col-xs-6 col-md-6">
                                            <input type="text" placeholder="Last" name="${Account.COL_LASTNAME}" class="form-control" required>
                                    		<div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-xs-6 col-md-6">
                                        	<div class="input-group">
	                                            <label>ID Number</label>
	                                            <input type="number" placeholder="ID Number" name="${Account.COL_IDNUMBER}" class="form-control" data-error="${FormConstant.REGISTER_ERROR_IDNUMBER}" required>
	                                    		<div class="help-block with-errors"></div>
	                                    			
                                    		</div>
                                        </div>
                                        <div class="col-xs-6 col-md-6" style="margin-top: 22px;">
                                        	<div class="input-group" >
	                                            <select class="selectpicker form-control" name="${Account.COL_DEGREE}" title="Your Degree"  required>
	                                                <option>BSCS</option>
	                                                <option>CS-ST</option>
	                                                <option>CS-NE</option>
	                                                <option>CS-IST</option>
	                                                <option>BSCS-CSE</option>
	                                                <option>BS-INSYS</option>
	                                                <option>BSIT</option>
	                                                <option data-divider="true"></option>
	                                                <option>Other</option>
	                                            </select>
	                                    		<div class="help-block with-errors"></div>
	                                    	</div>
                                        </div>
                                    </div>
<!--                                     <div class="alert alert-dismissible alert-danger"> -->
<!--   														<p>ID Number already exists</p> -->
<!-- 													</div> -->
                                </div>
                                <div class="form-group">
                                    <label>Facebook URL</label>
                                    <input type="text" placeholder="Your Facebook URL Here.." name="${Account.COL_FBURL}" class="form-control" required>
                                    <p class="small note">* We will contact you through this profile.</p>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label>Mobile Number</label>
		                            <div class="input-group">
			                            <span class="input-group-addon">+639</span>
	                                    <input type="number" placeholder="Your Mobile Number Here.." name="${Account.COL_MOBILENUM}" class="form-control" required>
	                                </div>
	                                <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" placeholder="Your Email Here.." name="${Account.COL_EMAIL}" class="form-control" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" placeholder="Your Password Here.." id="${Account.COL_PASSWORD}" name="${Account.COL_PASSWORD}" class="form-control" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label>Confirm Password</label>
                                    <input type="password" placeholder="Type your Password Again" name="confirmPassword" class="form-control" data-match="#${Account.COL_PASSWORD}" data-match-error="${FormConstant.REGISTER_ERROR_CONFIRMPASSWORD}" required>
                                    <div class="help-block with-errors"></div>
                                </div>
<!--                                 	<div class="alert alert-dismissible alert-danger"> -->
<!--   										<p>Password does not match</p> -->
<!-- 									</div> -->
                                <img src="<c:url value="/img/temp_captcha.gif" />" style="width: 300px; height: auto;" />
                                <br><br>
                                 <button type="submit" class="btn btn-default">Submit</button>
                                 
                                <input type="hidden" name="${GlobalConstant.NAME_REDIRECT_PAGE}" value="${redirectpage}">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

	</jsp:attribute>
</template:register-template>