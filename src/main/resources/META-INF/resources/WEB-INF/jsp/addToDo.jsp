<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
  	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"></link>
  	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
    <title>Add ToDo Page</title>
  </head>
  <body>
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
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		});
	</script>
  </body>
</html>