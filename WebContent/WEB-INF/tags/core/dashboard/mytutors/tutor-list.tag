<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="Account" class="org.animopts.bean.Account" scope="session"/>
<%@ taglib prefix="tutorEvaluation" tagdir="/WEB-INF/tags/core/dashboard/mytutors"%>
<script src="./js/jquery.js"> </script>
<script>
	$(document).ready(function(){
		$('.name-button').click(function(){
			$.ajax({
				 url : "dashboard/mytutor/view",
				 method : "get",
				 data:{
					 "${Account.COL_IDNUMBER}" : $(this).attr("id")
				 },
				 dataType: "json",
				 success: function(tutor){
					 console.log(tutor[0].tutor.firstName);
					 $("#name").text(tutor[0].tutor.firstName + " " + tutor[0].tutor.lastName);
					 $("#tutor-details").text(tutor[0].tutor.idNumber + " | " +tutor[0].tutor.degree );
					 for(var i = 0; i<tutor.length; i++){
						 console.log(tutor[i].subj.name);
						 $("#prefSub").append('<li>'+ tutor[i].subj.name + '</li>');
						 
					 }
					 			 
				 }
			});
		});
	});
</script>
<ul class="list-group" id="tutor-list">
    <c:forEach var="tutor" items="${myTutors}">
        <li class="list-group-item info tutor-list-margin">
            <div class="row">
                <div class="col-lg-12 well">
                    <div class="col-xs-2">
                        <img src="${GlobalConstant.NO_AVATAR}" alt="${tutor.tutor.firstName} ${tutor.tutor.lastName}" class="img-circle avatar-thumbnail" />
                    </div>
                    <div class="col-xs-7">
                        <span class="<c:if test="${tutor.tutor == null}">pending </c:if>name">
                        <c:choose>
						  <c:when test="${tutor.tutor == null}">
						    Pending
						  </c:when>
						  <c:otherwise>
						  <a href="#" id="${tutor.tutor.idNumber}" class = "name-button" data-toggle="modal" data-target="#myModal" style = "color: black"><b>${tutor.tutor.firstName} ${tutor.tutor.lastName}</b></a>
						  </c:otherwise>
						</c:choose>
                        </span>
                        <div class="row col-md-12">
                            <ul class="social">
                                <li> <a href= "${tutor.tutor.fbUrl}" target="_blank"> <i class=" fa fa-facebook"></i> </a> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <span class="subject label label-info">${tutor.subj.name}</span>
                    </div>
                </div>
            </div>
    	</li>
    </c:forEach>
</ul>

<!-- Modal Dialog -->
    <tutorEvaluation:show-evaluation />