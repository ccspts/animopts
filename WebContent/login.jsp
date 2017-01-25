<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Account" class="org.animopts.bean.Account" scope="session"/>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="FormConstant" class="org.animopts.bean.FormConstant" scope="session"/>

<template:register-template pageTitle="Login">
	<jsp:attribute name="body">
	
<section id="login" class="register-tutee-section">
    <div class="container">
        <h1 class="text-center">Login to Animo PTS</h1>
        <div class="row">
            <div class="col-lg-6">
                <h2>Don't have an account?</h2>
                <h4>Having difficulty in your studies?</h4>
                <p>The Peer Tutors Society is an initiative under the Office of the College of Computer Studies
                    Vice Dean which aims to select, train, qualify and deploy a group of students in order to 
                    conduct individualized (one-on-one) or group tutoring sessions for students in various 
                    subjects. Any tutoring session will primarily be characterized by individualized 
                    instruction (explaining and / or reviewing constructs, discussing solutions to sample 
                    programs) and remediation (providing corrections, giving hints and / or advice, coaching).</p>
                <a href="<c:url value="${GlobalConstant.REQUEST_TUTOR}" />" role="button" class="btn btn-primary">Request a Tutor</a>
                <br>
                <br>
                <h4>Want to be a Tutor?</h4>
                <p>Are you bored of just sitting around and doing nothing? Join PTS and make an impact in 
					this beautiful university. Not only will you be able to help
					others with their studies, it is also a great opportunity to make new friends. Join us now
					and unlock that potential that you have inside.</p>
                <a href="<c:url value="${GlobalConstant.APPLY_TUTOR}" />" role="button" class="btn btn-primary">Apply as Tutor</a>
            </div>
            <div class="col-lg-6">
                <div class="col-lg-12 well">
                    <div class="row">
                        <form action="login" data-toggle="validator" method="POST">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label>ID Number</label><br>
                                    <input type="number" placeholder="ID Number" name="${Account.COL_IDNUMBER}" class="form-control" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label>Password</label><br>
                                    <input type="password" placeholder="Password" name="${Account.COL_PASSWORD}" class="form-control" required>
                                    <div class="help-block with-errors"></div>
                                </div>
<!--                                 <div class="alert alert-dismissible alert-danger"> -->
<!--   									<p>Incorrect ID number or password.</p> -->
<!-- 								</div>  -->
                                <input type="hidden" name="${GlobalConstant.NAME_REDIRECT_PAGE}" value="${redirectpage}">
                                 <button type="submit" class="btn btn-default">Submit</button>
                                
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