<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
        <!-- Eval form -->
        <div class="container">
          <div class="row">
            <div class="col-lg-6 eval-msg">
             
                <div class="row">
                    <div class="col-sm-12">
                      <br>
                      <!--div for each thingy -->
                      
                      <div class="row">
	                      
	                      	<div class="col-lg-6">
	                            <h4 id = "freq">Frequency : ${eval.freq}</h4>
	                            <h4 id = "prep">Preparedness : ${eval.prep}</h4>
	                            <h4 id = "exp">Explanation : ${eval.exp}</h4>
	                            <h4 id = "exc">Exercises : ${eval.exc}</h4>
	                            <h4 id = "rel">Relevance : ${eval.rel}</h4>
	                            <h4 id = "ent">Enthusiasm : ${eval.ent}</h4>
	                            <h4 id = "con">Confidence : ${eval.con}</h4>        
	                   		 </div>
	                      <div class = "col-lg-6"> 
	                            <h4 id = "kno">Knowledge : ${eval.kno}</h4>
	                            <h4 id = "voc">Vocal : ${eval.voc}</h4> 
	                            <h4 id = "que">Question & Answer : ${eval.que}</h4>
	                            <h4 id = "enc">Encouraging : ${eval.ebc}</h4>
	                            <h4 id = "pas">Passion : ${eval.pas}</h4>
	                            <h4 id = "eff">Effectiveness : ${eval.eff}</h4>
	                        </div>
	                    
                     </div>
                    
                      <hr>
                     
                      <div>
                        <br><br>
                        <label>Personal Message</label>
                        <p id = "pm"></p>
                      </div>
                      
                      <div id = "cs">
                        <label>Comments & Suggestion</label>
                        <p></p>
                      </div>
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