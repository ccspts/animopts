<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tutorEvaluation" tagdir="/WEB-INF/tags/core/dashboard/evaluate/tutor"%>
<jsp:useBean id="Account" class="org.animopts.bean.Account" scope="session"/>
<script src="./js/jquery.js"> </script>
<script>
	var $title = $('.modal-header')
	var fName, lName, term, yaer;
	$(document).ready(function(){
		$(".btn" ).click(function(){
			$.ajax({
				url: "dashboard/evaluation/view",
				method : "get",
				data:{
					"${Account.COL_IDNUMBER}" : $(this).attr("id")
				},
				dataType: "json",
				success: function(eval){
					fName = eval.requestTutor.tutor.firstName;
					lName = eval.requestTutor.tutor.lastName;
					term = eval.requestTutor.term;
					year = eval.requestTutor.year;
					$(".modal-title").text(fName + " " + lName + " | Term : " + term + " | Year : " + year);
					$("#freq").text("Frequency : " + eval.freq);
					$("#prep").text("Preparedness : " + eval.prep);
					$("#exp").text("Explanation : " + eval.exp);
					$("#exc").text("Exercises : " + eval.exc);
					$("#rel").text("Relevance : " + eval.rel);
					$("#ent").text("Enthusiasm : " + eval.ent);
					$("#con").text("Confidence : " + eval.con);
					$("#kno").text("Knowledge : " + eval.kno);
					$("#voc").text("Vocal : " + eval.voc);
					$("#que").text("Question & Answer : " + eval.que);
					$("#pas").text("Passion : " + eval.pas);
					$("#eff").text("Effectiveness : " + eval.eff);
					$("#enc").text("Encouraging : " + eval.enc);
					$("#pm").text(eval.message);
					$("#cs").text(eval.comment);
				}
				
			});
		});
	});		
</script>

<div class="col-lg-12">
    <h2>
    My Evaluations
    </h2>
    <br>
    <div class="col-lg-12 well"> 
        <div class="col-lg-6">
            <h3>Term-End Evaluations</h3>
            <hr>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">3rd Term '15-'16</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <div class="panel-body">
                        <ul class="list-group eval-list-divider" id="tutor-list">
                            <c:forEach var="tutor" items="${myEval}">
                            <li class="list-group-item info">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="col-xs-2">
                                            <img src="<c:url value="${GlobalConstant.NO_AVATAR}" />" alt="${tutor.requestTutor.tutee.firstName} ${tutee.requestTutor.tutee.lastName}" class="img-circle avatar-small" />
                                        </div>
                                        <div class="col-xs-8">
                                            <span  class="name">${tutor.requestTutor.tutor.firstName} ${tutor.requestTutor.tutor.lastName}</span>
                                            <br>
                                            <span class="label label-pill label-info">${tutor.requestTutor.subj.name}</span>
                                        </div>
                                        <div class="pull-right">
                                            <span>
                                                <button id = "${tutor.requestTutor.tutor.idNumber}" type="button" class="btn btn-raised btn-xs" data-toggle="modal" data-target="#myModal">View</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                      </ul>
                     </div>
                   </div>
                </div>
                </div>
            </div>
            <div class="col-lg-6 performance">
                <h3>Average Performance</h3>
                <hr>
                <ul>
                    <li> Frequency : 8.5 <span class="glyphicon glyphicon-arrow-down degraded"></span></li>
                    <li> Preparedness : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Explanation : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Exercises : 3  <span class="glyphicon glyphicon-arrow-down degraded"></span></li>
                    <li> Relevance : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Enthusiasm : 9.99</li>
                    <li> Confidence : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Knowledgeable : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Vocal : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Question & Answer : 9.99 <span class="glyphicon glyphicon-arrow-down degraded"></span></li>
                    <li> Effectiveness : 9.99</li>
                    <li> Encouraging : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                    <li> Passion : 9.99 <span class="glyphicon glyphicon-arrow-up improved"></span></li>
                </ul>
            </div>
        </div>
        </br>
    </div>
    <!-- Modal Dialog -->
    <tutorEvaluation:show-evaluation />