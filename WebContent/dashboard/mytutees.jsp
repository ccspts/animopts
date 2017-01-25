<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="mytutees" tagdir="/WEB-INF/tags/core/dashboard/mytutees"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:dashboard-template pageTitle="My Tutees">
	<jsp:attribute name="body">
	
<div class="col-lg-12">
    <h2>
        My Tutees
    </h2>
    <br>
        
            
<mytutees:tutee-list />
        
    <br>
</div>

</jsp:attribute>
</template:dashboard-template>