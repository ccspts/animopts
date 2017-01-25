<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div id="dlgAdd" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add New Officer</h4>
      </div>
      <div class="modal-body">
          <div class="row">
            
              <div class="col-sm-12">
                <div class="form-group">
                  <label>Name</label><br>
                  <select class="selectpicker form-control" name="name" title="Officer's Name" id="officerSelect">
                  	<c:forEach items="${tutorList}" var="tutor">
                    	<option value="${tutor.idNumber}">${tutor.lastName}, ${tutor.firstName}</option>
                    </c:forEach>
                    <option value="" disabled selected>Select Officer's Name</option>
                  </select>
                </div>
                
                <div class="form-group">
                  <label>Position</label><br>
                  <select class="selectpicker form-control" name="position" title="Officer's Position" id="positionSelect">
                    <option value="" disabled selected>Select Officer's Position</option>
                    <option value = "1">President</option>
                    <option value= "2">Vice President</option>
                    <option value = "3">VP Externals</option>
                    <option value = "4">VP Internals</option>
                    <option value = "5">AVP Internals</option>
                    <option value = "6">VP Publicity</option>
                  </select>
                </div>
                <br>
                <input id="addofficer" data-dismiss="modal" type="submit" class="btn btn-lg btn-info" value="Submit"/>
              </div>
            
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
