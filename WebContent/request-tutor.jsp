<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<jsp:useBean id="RequestTutor" class="org.animopts.bean.RequestTutor" scope="session"/>
<template:register-template pageTitle="Request Tutor">
	<jsp:attribute name="body">

    <section id="register-tutee" class="register-tutee-section">
        <div class="container">
            <h1 class="text-center">Request a Tutor</h1>
            <div class="row">
                <div class="col-lg-6">
                    <h2>Need help in your studies, <span id="lblName"></span>${firstname}?</h2>
                    <p>We will try our best to find a tutor for the topics you need help with!</p>
                    <br>
                    <h2>Note: Only open for CCS</h2>
                    <p>We only accept tutor requests for courses and topics under CCS. For courses and topics not under CCS, please consult the college in which the course or topic would fall under. Thank you!</p>
                    <p>For concerns, please contact 09173171215.</p>
                    <br>
                </div>
                <div class="col-lg-6">
                    <div class="col-lg-12 well">
                        <div class="row">
                            <form id="requesttutorform" action="request" method="POST">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label>Subject/Language/Concept</label><br>
                                        <select name="${RequestTutor.COL_SUBJECTID}" class="selectpicker" data-width="100%" data-live-search="true" title="Choose a Subject/Language/Concept">
                                        	<c:forEach items="${subjectList}" var="subject">
												<option data-tokens="
													<c:forEach items="${subject.tagList}" var="tag">
														${tag.name}&nbsp;
													</c:forEach>
												" value="${subject.id}">${subject.name}</option>
											</c:forEach>
										</select>
                                    </div>
                                    <div class="form-group">
                                        <label>Type of Tutorial</label>
                                        <div class="radio">
                                            <label><input type="radio" name="${RequestTutor.COL_TUTORIALTYPE}" value="1">I prefer strictly one-on-one tutorials</label>
                                        </div>
                                        <div class="radio">
                                            <label><input type="radio" name="${RequestTutor.COL_TUTORIALTYPE}" value="2">I'm fine having a tutorial with other students (+2 max)</label>
                                        </div>
                                        <div class="radio">
                                            <label><input type="radio" name="${RequestTutor.COL_TUTORIALTYPE}" value="3">I have some friends I want to have the tutorial with (+2 max)</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Preferred Tutor</label><br>
                                        <select class="selectpicker form-control" width="auto" title="Choose your Preferred Tutor" name="${RequestTutor.COL_PREFTUTORID}">
                                            <option selected value="0">Anyone</option>
                                            <!-- <option data-divider="true"></option> -->
                                            <c:forEach items="${tutorList}" var="tutor">
                                            	<option value="${tutor.idNumber}">${tutor.lastName}, ${tutor.firstName}</option>
                                            </c:forEach>
                                        </select>
                                        <p class="small note">* If you'd like to request your tutor from last term, this is the way. NOTE! Preferred tutor not guaranteed as it will still depend on tutor's availability and specialty.</p>
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
                                    
                                    <img src="<c:url value="/img/temp_captcha.gif" />" style="width: 300px; height: auto;" />
                                    <br><br>
                                	<button id="submit" type="submit" class="btn btn-default">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </section>
    
</jsp:attribute>
</template:register-template>