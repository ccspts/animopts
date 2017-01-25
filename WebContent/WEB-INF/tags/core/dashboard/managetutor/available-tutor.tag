<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="ActivatedTutor" class="org.animopts.bean.ActivatedTutor" scope="session"/>
<div class="list-group">
    <ul class = "list-divider">
    	<c:forEach items="${activatedList}" var="activated">
	        <li class="col-lg-12" style = "margin-bottom: 1%">
	            <img class="avatar-small" src="<c:url value="${GlobalConstant.NO_AVATAR}" />"> ${activated.firstName} ${activated.lastName}
	            <div class="pull-right">
<%-- 	                <button  id="${FormConstant.MANAGETUTOR_ACTIVATEDPREFIX}$${FormConstant.MANAGETUTOR_ACTION_DEACTIVATE}$${activated.idNumber}" type="button" class="btn btn-primary btn-raised btn-xs">Request Details</button> --%>
	                <button  id="${FormConstant.MANAGETUTOR_ACTIVATEDPREFIX}$${FormConstant.MANAGETUTOR_ACTION_DEACTIVATE}$${activated.idNumber}" type="button" class="btn btn-warning btn-raised btn-xs">Deactivate</button>
	            </div>
	        </li>
    	</c:forEach>
    </ul>
</div>