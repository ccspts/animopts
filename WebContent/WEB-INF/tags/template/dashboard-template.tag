<%@ tag %>
<%@ attribute name="pageTitle" %>
<%@ taglib prefix="load" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="core" tagdir="/WEB-INF/tags/core" %>
<%@ taglib prefix="dashboard" tagdir="/WEB-INF/tags/core/dashboard" %>
<%@ attribute name="body" fragment="true" %>
<load:load/>
<load:header pageTitle="${pageTitle} - Dashboard" mainStylesheetName="dashboard.css"/>
<dashboard:dashboard-header />
<jsp:invoke fragment="body"/>
<dashboard:dashboard-footer />
<core:footer/>
