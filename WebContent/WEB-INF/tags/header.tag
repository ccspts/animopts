<%@ tag %>
<%@ attribute name="pageTitle" %>
<%@ attribute name="mainStylesheetName" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="load" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!DOCTYPE html>
<html lang="en">
    <head>
    	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>${pageTitle} - Animo PTS</title>
        <load:load-css>
        	<jsp:attribute name="maincss">
				<link href="css/${mainStylesheetName}" rel="stylesheet"/>
        	</jsp:attribute>
        </load:load-css>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
        <core:navigation/>
        <!-- Intro Section -->