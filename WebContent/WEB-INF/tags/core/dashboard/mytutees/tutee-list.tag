<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<ul class="list-group" id="tutor-list">
	<c:if test="${empty myTutees}">
		<center>
		<h4>You have no tutee as of the moment.</h4>
		<br>
		<p>We will keep you updated as soon as you have been assigned!</p>
		</center>
	</c:if>
        <c:forEach var="tutee" items="${myTutees}">
        <li class="list-group-item info tutor-list-margin">
            <div class="row">
                <div class="col-lg-12 well">
                    <div class="col-xs-2">
                        <img src="${GlobalConstant.NO_AVATAR}" alt="${tutee.tutee.firstName} ${tutee.tutee.lastName}" class="img-circle avatar-thumbnail" />
                    </div>
                    <div class="col-xs-7">
                        <span class="name">${tutee.tutee.firstName} ${tutee.tutee.lastName}</span>
                        <div class="row col-md-12">
                            <ul class="social">
                                <li> <a href= "${tutee.tutee.fbUrl}" target="_blank"> <i class=" fa fa-facebook"></i> </a> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <span class="subject label label-info">${tutee.subj.name}</span>
                    </div>
                </div>
            </div>
        </li>
        </c:forEach>
</ul>