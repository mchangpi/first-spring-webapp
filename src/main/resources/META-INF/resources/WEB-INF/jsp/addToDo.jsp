
  	<%@ include file="common/header.jspf" %>
  	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h4>Enter ToDo Details</h4>
		<hr>
		<form:form method = "post" modelAttribute = "toDo"><!-- 2 way binding -->
			<fieldset>
				<form:label path = "description">Description:</form:label>
				<form:input type = "text" path = "description" required="required"/>	
				<br>
				<form:errors path="description" cssClass = "text-danger"/>
			</fieldset>
			<br>
			<fieldset>
				<form:label path = "targetDate">Target Date:</form:label>
				<form:input type = "text" path = "targetDate" required="required"/>	
				<br>
				<form:errors path="targetDate" cssClass = "text-danger"/>
			</fieldset>
			<form:input type = "hidden" path = "id" />	
			<form:input type = "hidden" path = "done" />	
			<br>
			<input type = "submit" class = "btn btn-success"/>
		</form:form>
	</div>
	<%@ include file="common/footer.jspf" %>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		});
	</script>