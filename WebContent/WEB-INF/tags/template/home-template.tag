<%@ tag %>
<%@ attribute name="pageTitle" %>
<%@ taglib prefix="load" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<%@ attribute name="body" fragment="true" %>
<load:load/>
<load:header pageTitle="${pageTitle}" mainStylesheetName="home.css"/>
<jsp:invoke fragment="body"/>
<core:footer/>
