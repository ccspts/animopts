<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="PendingTutor" class="org.animopts.bean.PendingTutor" scope="session"/>

<template:register-template pageTitle="Register Tutor">
	<jsp:attribute name="body">
	
<section id="register-tutee" class="register-tutee-section">
    <div class="container">
        <h1 class="text-center">Apply as Tutor</h1>
        <div class="row">
            <div class="col-lg-6">
                <h2>Want to be a Tutor?</h2>
                <p>Are you bored of just sitting around and doing nothing? Join PTS and make an impact in this beautiful university. Not only will you be able to help others with their studies, it is also a great opportunity to make new friends. Join us now and unlock that potential that you have inside.</p>
            </div>
            <div class="col-lg-6">
                <div class="col-lg-12 well">
                    <div class="row">
                        <form action="apply" method="POST">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="involvements">Current Extracurricular Involvements:</label>
                                    <textarea name="${PendingTutor.COL_CURRINVOLVEMENT}" class="form-control" rows="5" id="${PendingTutor.COL_CURRINVOLVEMENT}"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="reason">Why do you wish to be a part of Peer Tutors Society?</label>
                                    <textarea name="${PendingTutor.COL_REASONFORJOINING}" class="form-control" rows="5" id="${PendingTutor.COL_REASONFORJOINING}"></textarea>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> I hereby declare that all statements contained in this application are true and correct and understand that false or inaccurate information in the application will lead to my disqualification.
                                    </label>
                                </div>
                                <img src="<c:url value="/img/temp_captcha.gif" />" style="width: 300px; height: auto;" />
                                <br><br>
                                <button type="submit" class="btn btn-primary btn-raised">Submit</button>
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