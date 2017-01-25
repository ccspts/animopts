<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Tutor Profile</h4>
      </div>
      <div class="modal-body">
        <div class="row">
            <div class="col-md-10">
                <div class="col-xs-4">
                    <img src="<c:url value="/img/no_avatar.jpg" />" alt="Gaius Ambion" class="img-circle avatar-thumbnail" />
                </div>
                <div class="col-xs-7">
                    <h3 id = "name"></h3>
                    <h4 id = "tutor-details"></h4>
                    <h5><b>Preferred Subject/s</b></h5>
                    <ul id = "prefSub">
                    	

                    </ul>
                    <br>
                   
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