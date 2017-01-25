<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:dashboard-template pageTitle="Home">
	<jsp:attribute name="body">
	
<h1>Hello, ${firstname}!</h1>
<h4>You have no updates at this time.</h4>


</jsp:attribute>
</template:dashboard-template>