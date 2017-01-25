<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="managetutor" tagdir="/WEB-INF/tags/core/dashboard/managetutor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="FormConstant" class="org.animopts.bean.FormConstant" scope="session"/>
<template:dashboard-template pageTitle="Manage Tutors">
	<jsp:attribute name="body">
	
<div class="col-lg-12">
    <h2>
    Manage Tutors
    </h2>
    <br>
    <!-- Tutee Name Accordion -->
    <div class="panel-group" id="tutorStateAccordion">
        <!-- Tutee Item -->
        <div class="panel panel-default">
            <!-- Pending Tutors Header -->
            <div class="panel-heading" data-toggle="collapse" data-parent="#tutorStateAccordion" data-target="#panPendingTutor">
                <h3 class="panel-title">
                Pending Tutors
                </h3>
            </div>
            <!-- List of Tutors -->
            <div id="panPendingTutor" class="panel-collapse collapse in">
                <div class="panel-body">
                        <managetutor:pending-tutor />
                </div>
            </div>
            <!-- Available Tutors Header -->
            <div class="panel-heading available" data-toggle="collapse" data-parent="#tutorStateAccordion" data-target="#panAvailableTutor">
                <div class="row">
                    <div class="col-lg-8">
		                <h3 class="panel-title">
		                Available Tutors
		                </h3>
                    </div>
                    <div class="col-lg-4">
                        <div class="pull-right" style="position: relative;">
<!--                             <button type="button" class="acc-header-btn btn btn-success btn-raised btn-xs" id="requestDetails">Request Details to All</button> -->
                        </div>
                    </div>
                </div>
                
            </div>
            <!-- List of Tutors -->
            <div id="panAvailableTutor" class="panel-collapse collapse">
                <div class="panel-body">
                        <managetutor:available-tutor />
                </div>
            </div>
            <!-- Deactivated Tutors Header -->
            <div class="panel-heading deactivated" data-toggle="collapse" data-parent="#tutorStateAccordion" data-target="#panDeactivatedTutor">
                <h3 class="panel-title">
                Deactivated Tutors
                </h3>
            </div>
            <!-- List of Tutors -->
            <div id="panDeactivatedTutor" class="panel-collapse collapse">
                <div class="panel-body">
                        <managetutor:deactivated-tutor />
                </div>
            </div>
            <!-- Rejected Tutors Header -->
            <div class="panel-heading rejected" data-toggle="collapse" data-parent="#tutorStateAccordion" data-target="#panRejectedTutor">
                <h3 class="panel-title">
                Rejected Tutors
                </h3>
            </div>
            <!-- List of Tutors -->
            <div id="panRejectedTutor" class="panel-collapse collapse">
                <div class="panel-body">
                        <managetutor:rejected-tutor />
                </div>
            </div>
        </div>
    </div>
    
	<form id="${FormConstant.MANAGETUTOR_ID}" action="dashboard/managetutor/update" method="POST">
		<input type="hidden" id="${FormConstant.MANAGETUTOR_NAME_ACTION}" name="${FormConstant.MANAGETUTOR_NAME_ACTION}" value="" />
	</form>
</div>

</jsp:attribute>
</template:dashboard-template>