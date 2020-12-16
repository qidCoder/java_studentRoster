<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to students</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/students/new">Add a new student</a>
		<a href="/contacts/new">Add a new contact</a>
		<a href="/dorms/create">Add a new dorm</a>

		<h1>All Students</h1>
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Dorm</th>

					
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- loop through arraylist -->
				<c:forEach items="${allStudents}" var="student">
					<tr>
						<td>${student.firstName} ${student.lastName}</td>
						<td>${student.age}</td>
						<td>${student.contact.address}</td>
						<td>${student.contact.city}</td>
						<td>${student.contact.state}</td>
						<td>${student.dorm.name}</td>
						
						<td><a href="/delete/${student.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h1>All Dorms</h1>
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>

					
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- loop through arraylist -->
				<c:forEach items="${allDorms}" var="dorm">
					<tr>
						<td><a href="/dorms/${dorm.id}">${dorm.name}</a></td>
						
						<td><a href="/deleteDorm/${dorm.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	
	
	
	
	
	</div>
</body>
</html>