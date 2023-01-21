<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"></link>
    <title>List ToDos Page</title>
  </head>
  <body>
  	<div class="container">
		<h4>Welcome ${name}</h4>
		<hr>
		<h5>Your ToDo List are</h5>
			<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>		
				<c:forEach items="${toDos}" var="toDo">
					<tr>
						<td>${toDo.id}</td>
						<td>${toDo.description}</td>
						<td>${toDo.targetDate}</td>
						<td>${toDo.done}</td>
						<td><a href="deletetodo?id=${toDo.id}" class="btn btn-warning">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<a href="addtodo" class="btn btn-success">Add ToDo</a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>