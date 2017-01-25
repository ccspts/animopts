<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="FormConstant" class="org.animopts.bean.FormConstant" scope="session"/>
<jsp:useBean id="PendingTutor" class="org.animopts.bean.PendingTutor" scope="session"/>
<div class="list-group">
    <ul class = "list-divider">
    	<c:forEach items="${pendingList}" var="pending">
	        <li class="col-lg-12" style = "margin-bottom: 1%">
	            <img class="avatar-small" src="<c:url value="${GlobalConstant.NO_AVATAR}" />"> ${pending.firstName} ${pending.lastName}
	            <div class="pull-right">
	                <button id="${FormConstant.MANAGETUTOR_PENDINGPREFIX}$${FormConstant.MANAGETUTOR_ACTION_ACCEPT}$${pending.idNumber}" type="button" class="btn btn-success btn-raised btn-xs">Accept</button>
	                <button id="${FormConstant.MANAGETUTOR_PENDINGPREFIX}$${FormConstant.MANAGETUTOR_ACTION_REJECT}$${pending.idNumber}" type="button" class="btn btn-danger btn-raised btn-xs">Reject</button>
	            </div>
	        </li>
        </c:forEach>
    </ul>
</div>