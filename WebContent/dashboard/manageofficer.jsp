<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="manageofficer" tagdir="/WEB-INF/tags/core/dashboard/manageofficer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:dashboard-template pageTitle="Manage Officers">
	<jsp:attribute name="body">
<script src="./js/jquery.js"> </script>
<script>
	
	$(document).ready(function(){
		$("input#addofficer").click(function(){
			var $li = $(this).closest('li');
			var $ul= $("#tutor-list");
			console.log($('#officerSelect').val());
			console.log($('#positionSelect').val());
			$.ajax({
				url: "dashboard/manageofficer/add",
				method : "post",
				data : {
					idnum : $('#officerSelect').val(),
					pos: $('#positionSelect').val()
				},
				dataType: "json", 	
				success:  function(jsonobject){
					console.log(jsonobject.idNumber + " " + jsonobject.firstName + " " + jsonobject.lastName + " " + jsonobject.degree);
					$("#addOfficerli").prepend(' <div class="row" id = "rowBefore"></div>');
					$("#rowBefore").prepend('<li class="list-group-item info" id = ' + jsonobject.idNumber + '>'
			        		  +' <div class="row"> <div class="col-md-8 well"> <div class="col-xs-2">  <img src="<c:url value="/img/no_avatar.jpg" />" alt="Gaius Ambion" class="img-circle avatar-thumbnail" />' + 
			        		  '</div> <div class="col-md-10">  <span class="name"> '+ jsonobject.firstName + " " + jsonobject.lastName 
			        		  + '<div class="pull-right"> <button type="button" class="btn btn-danger" name="removeOfficerButton"><span class="glyphicon glyphicon-minus"></span></button>'
			        		  + '  </div>  <div class="row"> <div class="col-md-6"> <span class="id">'+ jsonobject.idNumber +'</span> - <span class="degree">'+jsonobject.degree+'</span> </div> </div>' + 
			        		  '<br> <div class="row"> <div class="col-md-6"> <select class="selectpicker form-control" id="positionComboBox">' 
			        		  + '<option value="1">President</option> <option value="2">Vice President</option><option value="3">VP Externals</option>'
			        		  + '<option value="4">VP Internals</option><option value="5">AVP Internals</option><option value="6">VP Publicity</option>'
			        		  + '</select></div></div></div></div> </div> </li>');
					
					$(this).find('[value=' + jsonobject.idNumber +']').remove();

				}
			})
		});
		
		$(".btn.btn-danger").click(function(){
			var $li = $(this).closest('li');
			var id = $(this).closest('li').attr('id');
			$.ajax({
				url: "dashboard/manageofficer/remove",
				method : "post",
				data : {
					idnum : id
				},
				success: function(){
					$li.remove();
				}
			})
		})
		
		$("#positionComboBox").change(function(){
			 var id = $(this).closest('li').attr('id');
			  $.ajax({
				  url : "dashboard/manageofficer/update",
				  method : "post",
				  data : {
					  idnum : id,
					  pos : $(this).val(),
				  },
			  	  success: function(){
			  	  }
			  })
		})
		
	});
</script>
<script src="./js/jquery.js"> </script>
<div class="col-lg-12">
	
	    <h2>
	        Manage Officers
	    </h2>
	    <br>
	        
	        
			<manageofficer:officer-list />
	
	     
	    </br>
</div>

</jsp:attribute>
</template:dashboard-template>