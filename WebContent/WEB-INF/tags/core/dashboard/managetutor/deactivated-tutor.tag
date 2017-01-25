<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="DeactivatedTutor" class="org.animopts.bean.DeactivatedTutor" scope="session"/>
<div class="list-group">
    <ul class = "list-divider">
    	<c:forEach items="${deactivatedList}" var="deactivated">
	        <li class="col-lg-12" style = "margin-bottom: 1%">
	            <img class="avatar-small" src="<c:url value="${GlobalConstant.NO_AVATAR}" />"> ${deactivated.firstName} ${deactivated.lastName}
	            <div class="pull-right">
	                <button id="${FormConstant.MANAGETUTOR_DEACTIVATEDPREFIX}$${FormConstant.MANAGETUTOR_ACTION_ACTIVATE}$${deactivated.idNumber}" type="button" class="btn btn-success btn-raised btn-xs">Activate</button>
	            </div>
	        </li>
        </c:forEach>
    </ul>
</div>