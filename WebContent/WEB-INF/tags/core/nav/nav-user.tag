<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>

<ul class="nav navbar-nav navbar-right">
    <li>
        <p class="navbar-btn">
            <a href="<c:url value="${GlobalConstant.REQUEST_TUTOR}" />" class="btn btn-info btn-raised navbar-btn" role="button">
                <span aria-hidden="true" class="glyphicon glyphicon-user">
                </span>
                Request a Tutor
            </a>
        </p>
    </li>
	<c:if test="${idnumber == null || accountlevel <= 1}">
	    <li>
	        <p class="navbar-btn">
	            <a href="<c:url value="${GlobalConstant.APPLY_TUTOR}" />" class="btn btn-raised btn-info" role="button">
	                <span aria-hidden="true" class="glyphicon glyphicon-user">
	                </span>
	                Apply
	            </a>
	        </p>
	    </li>
    </c:if>
    <li class="dropdown">
    	<c:choose>
    	<c:when test="${idnumber != null}">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	            <img class="avatar-small" alt="user" src="<c:url value="${GlobalConstant.NO_AVATAR}" />">
	            <b>
	            <span id="nav-name">
	                ${firstname} ${lastname}
	            </span>
	            </b>
	            <span class="caret">
	            </span>
	            </img>
	        </a>
	        <ul class="dropdown-menu">
	    		<c:if test="${accountlevel >= 1}">
		            <li>
		                <a href="<c:url value="${GlobalConstant.MYPROFILE}" />">
		                    View Profile
		                </a>
		            </li>
		            <li class="divider"></li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.MYTUTORS}" />">
		                    My Tutors
		                </a>
		            </li>
	            </c:if>
	            
	    		<c:if test="${accountlevel >= 2}">
		            <li>
		                <a href="<c:url value="${GlobalConstant.MYTUTEES}" />">
		                    My Tutees
		                </a>
		            </li>
	            </c:if>
	            
	            
	    		<c:if test="${accountlevel >= 1}">
		        	<li class="divider"></li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.EVALUATION}" />">
		                    Evaluation
		                </a>
		            </li>
	            </c:if>
	            
	            
	    		<c:if test="${accountlevel >= 2}">
		            <li>
		                <a href="<c:url value="${GlobalConstant.MYEVALUATION}" />">
		                    My Evaluation
		                </a>
		            </li>
	            </c:if>
	            
	    		<c:if test="${accountlevel >= 2}">
            	<c:if test="${updated == 0}">
		        	<li class="divider"></li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.UPDATETUTOR}" />">
		                    Update Details
		                </a>
		            </li>
	            </c:if>
	            </c:if>
	            
	    		<c:if test="${accountlevel >= 3}">
		        	<li class="divider"></li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.MANAGETUTEE}" />">
		                    Manage Tutees
		                </a>
		            </li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.MANAGETUTOR}" />">
		                    Manage Tutors
		                </a>
		            </li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.MANAGEOFFICER}" />">
		                    Manage Officers
		                </a>
		            </li>
		            <li>
		                <a href="<c:url value="${GlobalConstant.MANAGEEVALUATION}" />">
		                    Manage Evaluation
		                </a>
		            </li>
	            </c:if>
	            <li class="divider">
	            </li>
	            <li>
	                <a href="<c:url value="${GlobalConstant.LOGOUT}" />">
	                    Sign Out
	                </a>
	            </li>
	        </ul>
        </c:when>
        <c:otherwise>
        	<a href="<c:url value="${GlobalConstant.LOGIN}" />">
	            <span class="glyphicon glyphicon-log-in">
	            </span>
	            Sign In
	        </a>
        </c:otherwise>
        </c:choose>
    </li>
</ul>