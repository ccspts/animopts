<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="tutorEvaluation" tagdir="/WEB-INF/tags/core/dashboard/evaluate/tutor"%>
<%@ taglib prefix="tuteeEvaluation" tagdir="/WEB-INF/tags/core/dashboard/evaluate/tutee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:dashboard-template pageTitle="Evaluations">
	<jsp:attribute name="body">
	

    <tutorEvaluation:myevaluation />
    


</jsp:attribute>
</template:dashboard-template>