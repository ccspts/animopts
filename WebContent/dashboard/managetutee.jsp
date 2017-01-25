<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="managetutee" tagdir="/WEB-INF/tags/core/dashboard/managetutee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:dashboard-template pageTitle="Manage Tutees">
	<jsp:attribute name="body">
	
<div class="col-lg-12">
    <h2>
    Manage Tutees
    </h2>
    <br>
    <!-- Tutee Name Accordion -->
    <div class="panel-group" id="tuteeStateAccordion">
        <!-- Tutee Item -->
        <div class="panel panel-default">
            <!-- Unassigned Tutee Header -->
            <div class="panel-heading" data-toggle="collapse" data-parent="#tuteeStateAccordion" data-target="#panUnassignedTutee">
                <h3 class="panel-title">
                Unassigned Tutees
                </h3>
            </div>
            <!-- List of Unassigned Tutees -->
            <div id="panUnassignedTutee" class="panel-collapse collapse in">
                <div class="panel-body">
                        <managetutee:unassigned-tutee />
                </div>
            </div>
            <!-- Assigned Tutee Header -->
            <div class="panel-heading assigned" data-toggle="collapse" data-parent="#tuteeStateAccordion" data-target="#panAssignedTutee">
                <h3 class="panel-title">
                Assigned Tutees
                </h3>
            </div>
            <!-- List of Assigned Tutees -->
            <div id="panAssignedTutee" class="panel-collapse collapse">
                <div class="panel-body">
                        <managetutee:assigned-tutee />
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery.js"></script>
<script>
	$(document).ready(function(){
		$("#btnAssign").click(function(){
			console.log("clicked");
// 		$("#idnote").val($(this).attr("id"));
// 				$("#toggleNoteForm").submit();

				var dataSplit = $(this).attr("name").split("\\$");
				var reqId = dataSplit[0];
				var tutId = dataSplit[1];

				$.ajax({
					url: "dashboard/managetutee/update",
					method: "post",
					data: {
						requesttutorid : reqId, 
						assignedtutorid : tutId
					},
					dataType: "json",
					success: function(jsonobject)
					{
						console.log("haxer");
						$('div[data-target=#' + jsonobject.id + ']').appendTo('#assignedTutorPane');
						$('div[data-target=#' + jsonobject.id + ']').attr('data-parent', '#assignedAccordion');
						$('div[data-target=#' + jsonobject.id + ']').find("a").attr('data-parent', '#assignedAccordion');
						$('#' + jsonobject.id).appendTo('#assignedTutorPane');
					}
				});
			});
		});
</script>
</jsp:attribute>
</template:dashboard-template>