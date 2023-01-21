<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>List ToDos Page</title>
  </head>
  <body>
    <div>Welcome ${name}</div>
    <hr>
    <h4>Your ToDos are</h4>
    	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${toDos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
  </body>
</html>