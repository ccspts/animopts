<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="ActivatedTutor" class="org.animopts.bean.ActivatedTutor" scope="session"/>
<jsp:useBean id="Subject" class="org.animopts.bean.Subject" scope="session"/>
<template:dashboard-template pageTitle="Update Term Details">
	<jsp:attribute name="body">

<div class="col-lg-12">
  <h2>
  Update Term Details
  </h2>
  <br>
  <div class="col-lg-7 well">
    <form id="formUpdateDetail" action="dashboard/update/submit" method="POST" data-toggle="validator">
    <form-group>
      <label>Types of tutorials</label>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="${ActivatedTutor.TABLE_PREFTUTORIAL_NAME}" value="${ActivatedTutor.COL_PREFTUTORIAL_SOLO}"> One-on-one
        </label>
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="${ActivatedTutor.TABLE_PREFTUTORIAL_NAME}" value="${ActivatedTutor.COL_PREFTUTORIAL_PAIR}"> Pair
        </label>
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="${ActivatedTutor.TABLE_PREFTUTORIAL_NAME}" value="${ActivatedTutor.COL_PREFTUTORIAL_GROUP}"> Large group (3-9)
        </label>
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="${ActivatedTutor.TABLE_PREFTUTORIAL_NAME}" value="${ActivatedTutor.COL_PREFTUTORIAL_CLASSROOM}"> Classroom (min. 10)
        </label>
      </div>
	  <div class="help-block with-errors"></div>
	  </form-group>
      
      <label>Maximum Number of Tutees</label><br>
      <select class="selectpicker form-control" data-dropupAuto="false" name="${ActivatedTutor.COL_MAXTUTEECOUNT}" title="Maximum number of tutees" style = "width : 100px" required>
        <option selected>0</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
      </select>
      <div class="help-block with-errors"></div>
      <br>
      <div class="form-group">
        <label for="topic">Topics</label>
        <select name="${ActivatedTutor.COL_PREFSUBJECT_SUBJECTID}" class="selectpicker" data-width="100%" data-live-search="true" title="Choose a Subject/Language/Concept" multiple required>
                                        	<c:forEach items="${subjectList}" var="subject">
												<option data-tokens="
													<c:forEach items="${subject.tagList}" var="tag">
														${tag.name}&nbsp;
													</c:forEach>
												" value="${subject.id}">${subject.name}</option>
											</c:forEach>
										</select>
										
      <div class="help-block with-errors"></div>
      </div>
      
      <div class="form-group">
        <label>Available Tutoring Schedule</label><br>
		<table class="sched-table table-bordered table col-fluid">
		      <tr>
		        <th></th>
		        <th>M</th>
		        <th>T</th>
		        <th>W</th>
		        <th>H</th>
		        <th>F</th>
		        <th>S</th>
		      </tr>
		      <tr>
		        <td class="time"> 7:30 AM-9:00 AM</td>
		        <td class="schedule sched-11"></td>
		        <td class="schedule sched-21"></td>
		        <td class="schedule sched-31"></td>
		        <td class="schedule sched-41"></td>
		        <td class="schedule sched-51"></td>
		        <td class="schedule sched-61"></td>
		      </tr>
		      <tr>
		        <td class="time">9:15 AM-10:45 AM</td>
		        <td class="schedule sched-12"></td>
		        <td class="schedule sched-22"></td>
		        <td class="schedule sched-32"></td>
		        <td class="schedule sched-42"></td>
		        <td class="schedule sched-52"></td>
		        <td class="schedule sched-62"></td>
		      </tr>
		      <tr>
		        <td class="time">11:00 AM-12:30 PM</td>
		        <td class="schedule sched-13"></td>
		        <td class="schedule sched-23"></td>
		        <td class="schedule sched-33"></td>
		        <td class="schedule sched-43"></td>
		        <td class="schedule sched-53"></td>
		        <td class="schedule sched-63"></td>
		      </tr>
		      <tr>
		        <td class="time">12:45 PM-2:15 PM</td>
		        <td class="schedule sched-14"></td>
		        <td class="schedule sched-24"></td>
		        <td class="schedule sched-34"></td>
		        <td class="schedule sched-44"></td>
		        <td class="schedule sched-54"></td>
		        <td class="schedule sched-64"></td>
		      </tr>
		      <tr>
		        <td class="time">2:30 PM-4:00 PM</td>
		        <td class="schedule sched-15"></td>
		        <td class="schedule sched-25"></td>
		        <td class="schedule sched-35"></td>
		        <td class="schedule sched-45"></td>
		        <td class="schedule sched-55"></td>
		        <td class="schedule sched-65"></td>
		      </tr>
		      <tr>
		        <td class="time">4:15 PM-5:45 PM</td>
		        <td class="schedule sched-16"></td>
		        <td class="schedule sched-26"></td>
		        <td class="schedule sched-36"></td>
		        <td class="schedule sched-46"></td>
		        <td class="schedule sched-56"></td>
		        <td class="schedule sched-66"></td>
		      </tr>
		      <tr>
		        <td class="time">6:00 PM-7:30 PM</td>
		        <td class="schedule sched-17"></td>
		        <td class="schedule sched-27"></td>
		        <td class="schedule sched-37"></td>
		        <td class="schedule sched-47"></td>
		        <td class="schedule sched-57"></td>
		        <td class="schedule sched-67"></td>
		      </tr>
		</table>
		</div>
		
		<input type="hidden" id="${GlobalConstant.NAME_SCHEDULE}" name="${GlobalConstant.NAME_SCHEDULE}" class="form-control" required>
                                    
      
      <br>
      <button id="btnUpdateDetail" type="button" class="btn btn-raised btn-info">Submit</button>
    </form>
  </div>
  </br>
</div>

</jsp:attribute>
</template:dashboard-template>