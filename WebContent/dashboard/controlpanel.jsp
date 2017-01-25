<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:dashboard-template pageTitle="Control Panel">
	<jsp:attribute name="body">
	
	<div class="col-lg-12">
		<div class="col-lg-6">
    <h2>
    Control Panel
    </h2>
    <br><div class="col-lg-12 well">
       <div class="col-lg-12">
       		<div class="col-lg-6">
            	<h3>3rd Term 15-16 </h3>
       		</div>
       		<div class ="pull-right btn-group-sm">
				<button type="button" class=" btn btn-default btn-fab"><i class="material-icons"></i></button>     		
				</div>
				
				<br><br><br>
       		<!-- ADDING CODE FOR GETTING CURR YEAR TERM. WILL  -->
       		
        </div>
        <div class="col-lg-12">
        	<div class=" col-lg-5 togglebutton">
        		<label>Tutor Application:</label>
        	</div>
        	<div class=" col-lg-7 togglebutton">
              <label>
                 
                <input type="checkbox" checked="true">
              </label>
         	</div>
         	<br><br>
            <div class=" col-lg-5 togglebutton">
        		<label>Tutor Application:</label>
        	</div>
        	<div class=" col-lg-7 togglebutton">
              <label>
                 
                <input type="checkbox" checked="true">
              </label>
         	</div>
            </div>
         <div class="col-lg-12">
         <br>
         	<button type="submit" class="btn btn-default btn-lg btn-block btn-info btn-raised">Start a new term</button>
         </div>
       </div></div>
   
    </br>
</div>
	</div>
	
</jsp:attribute>
</template:dashboard-template>