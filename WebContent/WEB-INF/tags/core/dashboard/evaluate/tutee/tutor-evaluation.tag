<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tuteeEvaluation" tagdir="/WEB-INF/tags/core/dashboard/evaluate/tutee"%>
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
					/* $("#freq").text("Frequency : " + eval.freq);
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
					$("#cs").text(eval.comment); */
				},
				dataType: "json",
				success: function(eval){
					fName = eval.requestTutor.tutor.firstName;
					lName = eval.requestTutor.tutor.lastName;
					term = eval.requestTutor.term;
					year = eval.requestTutor.year;
					console.log(fName);
					$(".modal-title").text(fName + " " + lName + " | Term : " + term + " | Year : " + year);
					
				}
				
			});
		});
	});		
</script>
<div class="col-lg-6">
    <h2>
    Tutor Evaluation
    </h2>
    <br>
        <ul class="list-group" id="tutor-list">
        <c:forEach var="tutor" items="${tutorEval}">
            <li class="list-group-item info">
                <div class="col-lg-12 eval-mar-edit well ">
                    <div class="col-md-12">
                        <div class="col-xs-2">
                            <img src="<c:url value="${GlobalConstant.NO_AVATAR}" />" alt="${tutor.requestTutor.tutor.firstName} ${tutor.requestTutor.tutor.lastName}" class="img-circle avatar-small" />
                        </div>
                        <div class="col-xs-6">
                            <span class="name">${tutor.requestTutor.tutor.firstName} ${tutor.requestTutor.tutor.lastName}</span>
                            <br>
                            <span class="label label-pill label-info">${tutor.requestTutor.subj.name}</span>
                        </div>
                        <div class="pull-right">
                            <span>
                            <button type="button" id= "${tutor.requestTutor.tutor.idNumber }" class="btn btn-raised btn-sm" data-toggle="modal" data-target="#dlgEvaluate">Evaluate</button></span>
                            
                        </div>
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>
   
    </br>
</div>

<!-- Modal Dialog -->
<tuteeEvaluation:form-evaluation />