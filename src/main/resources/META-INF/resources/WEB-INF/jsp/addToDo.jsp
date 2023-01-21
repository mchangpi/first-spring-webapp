<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
  	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"></link>
    <title>Add ToDo Page</title>
  </head>
  <body>
  	<div class="container">
		<h4>Enter ToDo Details</h4>
		<hr>
		<form:form method = "post" modelAttribute = "toDo">
			Description:<form:input type = "text" path = "description" required="required"/>	
			<form:input type = "hidden" path = "id" />	
			<form:input type = "hidden" path = "done" />	
			<input type = "submit" class = "bnt bnt-success"/>
			<br>
			<form:errors path="description" cssClass = "text-danger"/>
		</form:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>