<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="ActivatedTutor" class="org.animopts.bean.ActivatedTutor" scope="session"/>


        <!-- Sidebar -->
        <div id="sidebar-wrapper">
    <nav class="sidebar-nav navbar" role="navigation">
            <ul class="sidebar-nav nav-stacked nav " id="menu">
 
                <li ${pageContext.request.servletPath == GlobalConstant.DASHBOARD ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.DASHBOARD}" />">
                    <i aria-hidden="true" class="fa fa-home">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Home
                    </span>
                </a>
            </li>
            <li ${pageContext.request.servletPath == GlobalConstant.MYPROFILE ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MYPROFILE}" />">
                    <i aria-hidden="true" class="fa fa-tasks">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        My Profile
                    </span>
                </a>
            </li>
            
            <li class="divider">
            </li>
            <li ${pageContext.request.servletPath == GlobalConstant.MYTUTORS ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MYTUTORS}" />">
                    <i aria-hidden="true" class="fa fa-lightbulb-o">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        My Tutors
                    </span>
                </a>
            </li>
            
	    	<c:if test="${accountlevel >= 2}">
	            <li ${pageContext.request.servletPath == GlobalConstant.MYTUTEES ? 'class="active"' : ''}>
	                <a href="<c:url value="${GlobalConstant.MYTUTEES}" />">
	                    <i aria-hidden="true" class="fa fa-user">
	                    </i>
	                    <span class="hidden-xs hidden-sm">
	                        My Tutees
	                    </span>
	                </a>
	            </li>
            </c:if>
            
	    	<c:if test="${accountlevel >= 1}">
            <li class="divider"></li>
            <li ${pageContext.request.servletPath == GlobalConstant.EVALUATION ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.EVALUATION}" />">
                    <i aria-hidden="true" class="glyphicon glyphicon-list-alt">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Evaluation
                    </span>
                </a>
            </li>
            </c:if>
            
	    	<c:if test="${accountlevel >= 2}">
            <li ${pageContext.request.servletPath == GlobalConstant.MYEVALUATION ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MYEVALUATION}" />">
                    <i aria-hidden="true" class="glyphicon glyphicon-list-alt">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        My Evaluation
                    </span>
                </a>
            </li>
            </c:if>
            
	    	<c:if test="${accountlevel >= 2}">
            <c:if test="${updated == 0}">
            <li class="divider"></li>
            <li ${pageContext.request.servletPath == GlobalConstant.UPDATETUTOR ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.UPDATETUTOR}" />">
                    <i aria-hidden="true" class="glyphicon glyphicon-pencil">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Update Details
                    </span>
                </a>
            </li>
            </c:if>
            </c:if>
            
            <c:if test="${accountlevel >= 3}">
            <li class="divider"></li>
            <li ${pageContext.request.servletPath == GlobalConstant.MANAGETUTEE ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MANAGETUTEE}" />">
                    <i aria-hidden="true" class="fa fa-group">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Manage Tutees
                    </span>
                </a>
            </li>
            <li ${pageContext.request.servletPath == GlobalConstant.MANAGETUTOR ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MANAGETUTOR}" />">
                    <i aria-hidden="true" class="fa fa-graduation-cap">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Manage Tutors
                    </span>
                </a>
            </li>
            <li ${pageContext.request.servletPath == GlobalConstant.MANAGEOFFICER ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MANAGEOFFICER}" />">
                    <i aria-hidden="true" class="fa fa-user-plus">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Manage Officers
                    </span>
                </a>
            </li>
            <li ${pageContext.request.servletPath == GlobalConstant.MANAGEEVALUATION ? 'class="active"' : ''}>
                <a href="<c:url value="${GlobalConstant.MANAGEEVALUATION}" />">
                    <i aria-hidden="true" class="fa fa-bars">
                    </i>
                    <span class="hidden-xs hidden-sm">
                        Manage Evaluation
                    </span>
                </a>
            </li>
            </c:if>
            </ul>
            </nav>
        </div><!-- /#sidebar-wrapper -->








