<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<template:home-template pageTitle="Home">
	<jsp:attribute name="body">
	
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
			    <h2>
			        Thank You for Applying!
			    </h2>
			    <br>
			        <div class="col-lg-6 well">
			            <div class="col-xs-10">
			    		<c:if test="${status == GlobalConstant.VALUE_TUTOR_STATUS_PENDING}">
				            <h3>Reminder!</h3>
				            
				            <p>Application will now be processed by the administration. There will be an upcoming interview. Please wait to be contacted by one of the officers of PTS. Thank you!</p>
			        	</c:if>
			    		<c:if test="${status == GlobalConstant.VALUE_TUTOR_STATUS_REJECTED}">
				            <p>We regret to inform you that your application does not meet our requirements for the current term.</p>
				            <br>
				            <p>We hope to see you apply again for the next term. Thank you!</p>
			        	</c:if>
			            </div>
			        </div>
			    </br>
            </div>
        </div>
    </div>
</section>

	</jsp:attribute>
</template:home-template>