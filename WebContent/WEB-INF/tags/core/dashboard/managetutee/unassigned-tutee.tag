<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel-group" id="unassignedAccordion">
    <!-- Tutee Item -->
    <div class="panel panel-default">
    	
        <c:forEach var="requestTutor" items="${unassignedList}">
        <div class="panel-heading" data-toggle="collapse" data-parent="#unassignedAccordion" data-target="#${requestTutor.id}">
            <h4 class="panel-title">
            <img class="avatar-small" src="<c:url value="/img/no_avatar.jpg" />">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#unassignedAccordion" href="#collapse1">
                <span class="lblName">${requestTutor.tutee.firstName} ${requestTutor.tutee.lastName}</span>
                <div class="pull-right">
                    <span class="subject label label-info ">${requestTutor.subj.name}</span></a>
                </div>
                </h4>
            </div>
            <!-- Possible Tutors -->
            <div id="${requestTutor.id}" class="panel-collapse collapse">
                <div class="panel-body">
                    <h3>Possible Tutors</h3>
					<br>
                    <div class="list-group">
                        <ul class = "list-divider">
        					<c:forEach var="possibleTutor" items="${requestTutor.possibleTutor}">
                            <li class="col-lg-12 " >
                                <img class="avatar-small" src="<c:url value="/img/no_avatar.jpg" />"> ${possibleTutor.firstName} ${possibleTutor.lastName} 
                                
                                <div class="pull-right">
                                    <button id="btnAssign" name="${requestTutor.id}\$${possibleTutor.idNumber}" type="button" class="btn btn-primary btn-raised btn-xs">Assign</button>
                                </div>
                                   <br>
                                <div class = "col-lg-12">
                                	<ul class = "day-list">
        								<c:forEach var="scheduleList" items="${possibleTutor.schedule}">
	                                		<li>
	                                			<div class = "col-lg-1">
		                                			${scheduleList.day}
			                                	</div>
		                                		<div class = "col-xs-11">
			                                		${scheduleList.time}
			                                	</div>
	                                		</li>
	                                	</c:forEach>
                                	</ul>
                                </div>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
        </div>