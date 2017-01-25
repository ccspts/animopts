 <%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="js" tagdir="/WEB-INF/tags/js"%>
<jsp:useBean id="FormConstant" class="org.animopts.bean.FormConstant" scope="session"/>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
 <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Scrolling Nav JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/scrolling-nav.js"></script>
    <script src="js/dashboard.js"></script>
    <script src="js/bootbox.min.js"></script>
    <script src="js/dialog.js"></script>
    <script src="js/searchBar.js"></script>
    <script src="js/jquery.searchable-1.0.0.min.js"></script>
    <script src="js/bootstrap-select.min.js"></script>
    <script src="js/validator.min.js"></script>
    <script src="js/material.min.js"></script>
    <script src="js/ripples.min.js"></script>
    <script src="js/jquery.imageScroll.min.js"></script>
    <script src="js/init.js"></script>
    <js:managetutor />
    <js:updatetutor />
  <!--  Scripts-->
  
    <script type="text/javascript">
    $.material.init();

    var schedList = [];
    
    function ScheduleSlot(day, time) {
        this.day = day;
        this.time = time;
        this.toString = function() {
            return this.day + '$' + this.time;
        };
    }

	$(document).ready(function(){
		$('td').click( function() {
	        $(this).toggleClass('selected');
	        
	        var isSelected = $(this).is('.selected');
	        
        	var classList = $(this).attr('class').split(/\s+/);
        	$.each(classList, function(index, item) {
        		console.log(item + ' ' + item.startsWith('sched') + ' ' + isSelected);
        	    if (item.startsWith('sched-')) {
        	    	var currSched = new ScheduleSlot(item.charAt(6), item.charAt(7));
        	    	
        	    	if (isSelected)
    	        		schedList.push(currSched);
        	    	else
        	    		schedList.splice(index, 1);
        	    		
        	    	return;
        	    }
        	});
	    });
		
		$('#requesttutorform').submit( function(event) {
			$(this).find("input[name=${GlobalConstant.NAME_SCHEDULE}]").val(schedList);
		});
	});
	
	
	// Dialog
	$('#sendEval').on('click', function(){
    bootbox.confirm("Are you sure you want to send the evaluation forms to all of the tutees?", function(result) {
  	// Send
	}); 
	});
	
	$('#forwardEval').on('click', function(){
	    bootbox.confirm("Are you sure you want to forward the evaluations to all respective tutors?<br>This will also end the evaluation period.", function(result) {
	  	// Forward
	}); 
	});
	
	$('#btnUpdateDetail').on('click', function(){
	    bootbox.confirm("Are you sure about the term details that you have indicated? You cannot change this information until the end of the term.", function(result) {
	    	if (result)
    		{
				$("#formUpdateDetail").find("input[name=${GlobalConstant.NAME_SCHEDULE}]").val(schedList);
    			$("#formUpdateDetail").submit();
    		}
	}); 
	});
    
    </script>