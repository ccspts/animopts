<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="FormConstant" class="org.animopts.bean.FormConstant" scope="session"/>
<script type="text/javascript">
	$(document).ready(function()
			{
				$("button").click(function()
						{
							var buttonId = $(this).attr("id");
							$("#${FormConstant.MANAGETUTOR_NAME_ACTION}").val(buttonId);
							$("#${FormConstant.MANAGETUTOR_ID}").submit();
						});
			});
</script>