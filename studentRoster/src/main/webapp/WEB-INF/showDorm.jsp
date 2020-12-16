<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ page isErrorPage="true" %>  <!--in order to edit or update. allow us to render this view on a PUT request.-->
			<!-- in order to use validations via JSTL -->
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>View Dorm</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
					rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
					crossorigin="anonymous">
			</head>

			<body>

				<div class="container">
					<h1>${dorm.name} Dorm</h1>
					<a href="/dashboard">Dashboard</a>

					<form:form method="POST" action="/dorms/${dorm.id}/add" modelAttribute="dorm">
						<div class="form-group row">
							<form:label path="student" class="col-sm-2 col-form-label">Student:
								<form:errors path="student" />
								<div class="col-sm-10">
									<select class="form-control" name="student" path="student">
										<c:forEach items="${allStudents}" var="student">
											<option value="${student.id}">${student.firstName} ${student.lastName}
											</option>
										</c:forEach>
									</select>
								</div>
							</form:label>
						</div>

						<button>Add</button>

					</form:form>


					<table class="table table-dark">
						<thead>
							<tr>
								<th>Name</th>


								<th>Actions</th>
							</tr>
						</thead>

						<tbody>
							<!-- loop through arraylist -->
							<c:forEach items="${dorm.student}" var="student">
								<tr>
									<td>${student.firstName} ${student.lastName}</td>
									
									<td><a href="/dorms/${dorm.id}/remove?student=${student.id}">Delete</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>


			</body>

			</html>