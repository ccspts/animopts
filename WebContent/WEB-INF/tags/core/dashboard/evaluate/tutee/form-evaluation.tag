<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BUGGY -->

<!-- Modal -->
<div id="dlgEvaluate" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">${tutor.requestTutor.tutor.firstName} ${tutor.requestTutor.tutor.lastName} (${tutor.requestTutor.subj.name})</h4>
      </div>
      <div class="modal-body">
        <!-- Eval form -->
        <div class="container">
          <div class="row">
            <div class="col-lg-6">
              <h1 class="text-center">Evaluate Tutor</h1>
              <div class="col-lg-12 ">
                <div class="row">
                  <form>
                    <div class="col-sm-12">
                      <br>
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Frequency</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="freq0">
                                  <input type="radio" name="radios" id="freq0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="freq1">
                                  <input type="radio" name="radios" id="freq1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="freq2">
                                  <input type="radio" name="radios" id="freq2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="freq3">
                                  <input type="radio" name="radios" id="freq3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="freq4">
                                  <input type="radio" name="radios" id="freq4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="freq5">
                                  <input type="radio" name="radios" id="freq5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="freq6">
                                  <input type="radio" name="radios" id="freq6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="freq7">
                                  <input type="radio" name="radios" id="freq7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="freq8">
                                  <input type="radio" name="radios" id="freq8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="freq9">
                                  <input type="radio" name="radios" id="freq9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                      <br>
                        <p class="small note">* Did you frequently had a session especially when you needed it?</p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Preparedness</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="prep0">
                                  <input type="radio" name="radios" id="prep0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="prep1">
                                  <input type="radio" name="radios" id="prep1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="prep2">
                                  <input type="radio" name="radios" id="prep2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="prep3">
                                  <input type="radio" name="radios" id="prep3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="prep4">
                                  <input type="radio" name="radios" id="prep4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="prep5">
                                  <input type="radio" name="radios" id="prep5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="prep6">
                                  <input type="radio" name="radios" id="prep6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="prep7">
                                  <input type="radio" name="radios" id="prep7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="prep8">
                                  <input type="radio" name="radios" id="prep8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="prep9">
                                  <input type="radio" name="radios" id="prep9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* How prepared was your tutor during sessions?    </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Explanation</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="exp0">
                                  <input type="radio" name="radios" id="exp0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="exp1">
                                  <input type="radio" name="radios" id="exp1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="exp2">
                                  <input type="radio" name="radios" id="exp2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="exp3">
                                  <input type="radio" name="radios" id="exp3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="exp4">
                                  <input type="radio" name="radios" id="exp4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="exp5">
                                  <input type="radio" name="radios" id="exp5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="exp6">
                                  <input type="radio" name="radios" id="exp6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="exp7">
                                  <input type="radio" name="radios" id="exp7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="exp8">
                                  <input type="radio" name="radios" id="exp8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="exp9">
                                  <input type="radio" name="radios" id="exp9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Does your tutor explain clearly and can easily be understood?    </p>
                      </div>
                      <!-- End of div -->
                      
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Exercises</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="ex0">
                                  <input type="radio" name="radios" id="ex0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="ex1">
                                  <input type="radio" name="radios" id="ex1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="ex2">
                                  <input type="radio" name="radios" id="ex2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="ex3">
                                  <input type="radio" name="radios" id="ex3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="ep4">
                                  <input type="radio" name="radios" id="ex4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="ex5">
                                  <input type="radio" name="radios" id="ex5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="ex6">
                                  <input type="radio" name="radios" id="ex6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="ex7">
                                  <input type="radio" name="radios" id="ex7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="ex8">
                                  <input type="radio" name="radios" id="ex8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="ex9">
                                  <input type="radio" name="radios" id="ex9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Does your tutor provide sufficient exercises for you?    </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Relevance</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="rel0">
                                  <input type="radio" name="radios" id="rel0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="rel1">
                                  <input type="radio" name="radios" id="rel1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="rel2">
                                  <input type="radio" name="radios" id="rel2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="rel3">
                                  <input type="radio" name="radios" id="rel3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="rel4">
                                  <input type="radio" name="radios" id="rel4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="rel5">
                                  <input type="radio" name="radios" id="rel5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="rel6">
                                  <input type="radio" name="radios" id="rel6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="rel7">
                                  <input type="radio" name="radios" id="rel7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="rel8">
                                  <input type="radio" name="radios" id="rel8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="rel9">
                                  <input type="radio" name="radios" id="rel9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Did your tutor teach topics that were relevant in your lessons and projects?    </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Enthusiasm</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="ent0">
                                  <input type="radio" name="radios" id="ent0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="ent1">
                                  <input type="radio" name="radios" id="ent1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="ent2">
                                  <input type="radio" name="radios" id="ent2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="ent3">
                                  <input type="radio" name="radios" id="ent3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="ent4">
                                  <input type="radio" name="radios" id="ent4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="ent5">
                                  <input type="radio" name="radios" id="ent5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="ent6">
                                  <input type="radio" name="radios" id="ent6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="ent7">
                                  <input type="radio" name="radios" id="ent7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="ent8">
                                  <input type="radio" name="radios" id="ent8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="ent9">
                                  <input type="radio" name="radios" id="ent9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Did your tutor teach topics beyond the curriculum to further your learning?    </p>
                      </div>
                      <!-- End of div -->
                      
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Confidence</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="con0">
                                  <input type="radio" name="radios" id="con0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="con1">
                                  <input type="radio" name="radios" id="con1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="con2">
                                  <input type="radio" name="radios" id="con2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="con3">
                                  <input type="radio" name="radios" id="con3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="con4">
                                  <input type="radio" name="radios" id="con4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="con5">
                                  <input type="radio" name="radios" id="con5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="con6">
                                  <input type="radio" name="radios" id="con6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="con7">
                                  <input type="radio" name="radios" id="con7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="con8">
                                  <input type="radio" name="radios" id="con8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="con9">
                                  <input type="radio" name="radios" id="con9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Did your tutor exhibit confidence?   </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Knowledge</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="know0">
                                  <input type="radio" name="radios" id="know0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="know1">
                                  <input type="radio" name="radios" id="know1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="know2">
                                  <input type="radio" name="radios" id="know2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="know3">
                                  <input type="radio" name="radios" id="know3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="know4">
                                  <input type="radio" name="radios" id="know4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="know5">
                                  <input type="radio" name="radios" id="know5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="know6">
                                  <input type="radio" name="radios" id="know6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="know7">
                                  <input type="radio" name="radios" id="know7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="know8">
                                  <input type="radio" name="radios" id="know8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="know9">
                                  <input type="radio" name="radios" id="know9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Is your tutor knowledgeable of the topic?   </p>
                      </div>
                      <!-- End of div -->
                      
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Vocal</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="voc0">
                                  <input type="radio" name="radios" id="voc0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="voc1">
                                  <input type="radio" name="radios" id="voc1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="voc2">
                                  <input type="radio" name="radios" id="voc2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="voc3">
                                  <input type="radio" name="radios" id="voc3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="voc4">
                                  <input type="radio" name="radios" id="voc4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="voc5">
                                  <input type="radio" name="radios" id="voc5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="voc6">
                                  <input type="radio" name="radios" id="voc6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="voc7">
                                  <input type="radio" name="radios" id="voc7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="voc8">
                                  <input type="radio" name="radios" id="voc8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="voc9">
                                  <input type="radio" name="radios" id="voc9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Is your tutor's voice clear and loud enough?   </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Question & Answer</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="qa0">
                                  <input type="radio" name="radios" id="qa0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="qa1">
                                  <input type="radio" name="radios" id="qa1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="qa2">
                                  <input type="radio" name="radios" id="qa2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="qa3">
                                  <input type="radio" name="radios" id="qa3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="qa4">
                                  <input type="radio" name="radios" id="qa4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="qa5">
                                  <input type="radio" name="radios" id="qa5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="qa6">
                                  <input type="radio" name="radios" id="qa6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="qa7">
                                  <input type="radio" name="radios" id="qa7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="qa8">
                                  <input type="radio" name="radios" id="qa8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="qa9">
                                  <input type="radio" name="radios" id="qa9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Does your tutor respond quickly and appropriately when asked a question?   </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Effectiveness</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="eff0">
                                  <input type="radio" name="radios" id="eff0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="eff1">
                                  <input type="radio" name="radios" id="eff1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="eff2">
                                  <input type="radio" name="radios" id="eff2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="eff3">
                                  <input type="radio" name="radios" id="eff3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="eff4">
                                  <input type="radio" name="radios" id="eff4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="eff5">
                                  <input type="radio" name="radios" id="eff5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="eff6">
                                  <input type="radio" name="radios" id="eff6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="eff7">
                                  <input type="radio" name="radios" id="eff7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="eff8">
                                  <input type="radio" name="radios" id="eff8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="eff9">
                                  <input type="radio" name="radios" id="eff9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Is your tutor's method of teaching effective in your learning?  </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Encouraging</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="enc0">
                                  <input type="radio" name="radios" id="enc0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="enc1">
                                  <input type="radio" name="radios" id="enc1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="enc2">
                                  <input type="radio" name="radios" id="enc2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="enc3">
                                  <input type="radio" name="radios" id="enc3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="enc4">
                                  <input type="radio" name="radios" id="enc4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="enc5">
                                  <input type="radio" name="radios" id="enc5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="enc6">
                                  <input type="radio" name="radios" id="enc6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="enc7">
                                  <input type="radio" name="radios" id="enc7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="enc8">
                                  <input type="radio" name="radios" id="enc8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="enc9">
                                  <input type="radio" name="radios" id="enc9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Is your tutor encouraging to do your best and is proud of your achievements?  </p>
                      </div>
                      <!-- End of div -->
                      <!--div for each thingy -->
                      <div>
                        <form class="form-horizontal">
                          <fieldset>
                            <!-- Form Name -->
                            <legend>Passion</legend>
                            <!-- Multiple Radios (inline) -->
                            <div>
                              <div class="col-md-12" style = "margin-left: -5%">
                                <label class="radio-inline" for="pas0">
                                  <input type="radio" name="radios" id="pas0" value="1" checked="checked">
                                  1
                                </label>
                                <label class="radio-inline" for="pas1">
                                  <input type="radio" name="radios" id="pas1" value="2">
                                  2
                                </label>
                                <label class="radio-inline" for="pas2">
                                  <input type="radio" name="radios" id="pas2" value="3">
                                  3
                                </label>
                                <label class="radio-inline" for="pas3">
                                  <input type="radio" name="radios" id="pas3" value="4">
                                  4
                                </label>
                                <label class="radio-inline" for="pas4">
                                  <input type="radio" name="radios" id="pas4" value="5">
                                  5
                                </label>
                                <label class="radio-inline" for="pas5">
                                  <input type="radio" name="radios" id="pas5" value="6">
                                  6
                                </label>
                                <label class="radio-inline" for="pas6">
                                  <input type="radio" name="radios" id="pas6" value="7">
                                  7
                                </label>
                                <label class="radio-inline" for="pas7">
                                  <input type="radio" name="radios" id="pas7" value="8">
                                  8
                                </label>
                                <label class="radio-inline" for="pas8">
                                  <input type="radio" name="radios" id="pas8" value="9">
                                  9
                                </label>
                                <label class="radio-inline" for="pas9">
                                  <input type="radio" name="radios" id="pas9" value="10">
                                  10
                                </label>
                              </div>
                            </div>
                          </fieldset>
                        </form>
                        <br>
                        <p class="small note">* Is your tutor passionate in tutoring you?s  </p>
                      </div>
                      <!-- End of div -->
                      <br><br>
                      <div class = "eval-msg">
                        <label>Personal Message</label>
                        <input type="text" placeholder="   Have something to say to your tutor?" name="pMsg" class="form-control">
                      </div>
                      <div class = "eval-msg">
                        <label>Comments & Suggestion</label>
                        <input type="text" placeholder="   How can we improve our services to you?" name="cmnt" class="form-control">
                      </div>
                      <br>
                      <button type="submit" class="btn btn-lg btn-info">Submit</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- end ng form -->
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
  </div>
</div>
</div>