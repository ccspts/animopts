<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="manageofficer" tagdir="/WEB-INF/tags/core/dashboard/manageofficer"%>
<ul class="list-group" id="tutor-list">
	<c:forEach var="officers" items="${officers}">
	    <li class="list-group-item info" id = "${officers.idNumber}" style = "margin-bottom: -1%">
	        <div class="row">
	            <div class="col-md-8 well">
	                <div class="col-xs-2">
	                    <img src="<c:url value="/img/no_avatar.jpg" />" alt="Gaius Ambion" class="img-circle avatar-thumbnail" />
	                </div>
	                <div class="col-md-10">
	                
	                	<!-- Need to add list of officers  -->
	                    <span class="name">${officers.firstName} ${officers.lastName}</span>
	                    <div class="pull-right">
	                        <button type="button" class="btn btn-danger" name="removeOfficerButton"><span class="glyphicon glyphicon-minus"></span></button>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-6">
	                            <span class="id">${officers.idNumber}</span> - <span class="degree">${officers.degree}</span>
	                        </div>
	                    </div>
	                    <br>
	                    <div class="row">
	                        <div class="col-md-6">
	                            <select class="selectpicker form-control" id="positionComboBox">        
		                                <option value="1" <c:if test="${officers.officerpositionid == 1}">selected</c:if>>President</option>
		                                <option value="2" <c:if test="${officers.officerpositionid == 2}">selected</c:if>>Vice President</option>
		                                <option value="3" <c:if test="${officers.officerpositionid == 3}">selected</c:if>>VP Externals</option>
		                                <option value="4" <c:if test="${officers.officerpositionid == 4}">selected</c:if>>VP Internals</option>
		                                <option value="5" <c:if test="${officers.officerpositionid == 5}">selected</c:if>>AVP Internals</option>
		                                <option value="6" <c:if test="${officers.officerpositionid == 6}">selected</c:if>>VP Publicity</option>
		                                
		                                <!-- <option value="2">Vice President</option>
		                                <option value="3">VP Externals</option>
		                                <option value="4">VP Internals</option>
		                                <option value="5">AVP Internals</option>
		                                <option value="6">VP Publicity</option>     -->  
	                            </select>
	                            <c:if test="${officers.officerpositionid}"></c:if>	                            
	                        </div>
	                    </div>
	                    <!--                         <div class="col-md-3">
	                        <ul class="social"> 
	                            <li>
	                                <a href="http://www.facebook.com/pts.dlsu" target="_blank"> <i class=" fa fa-facebook">   </i> </a>
	                            </li>
	                        </ul>
	                    </div> -->
	                </div>
	            </div>
	        </div>
	    </li>
    </c:forEach>
    <li class="list-group-item info" id="addOfficerli" style = "margin-bottom: -1%">
            
            <div class="row">
	            <div class="col-md-8 well">
	                <div class="col-md-12">
	                	<button type="button" class="btn btn-large btn-block btn-primary input-block-level" data-toggle="modal" data-target="#dlgAdd">
                 	    <span class="glyphicon glyphicon-plus"></span> Add Officers</button>  
	                </div>
	            </div>
	        </div>

    </li>
</ul>

<manageofficer:add-officer />