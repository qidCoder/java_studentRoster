<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!-- in order to use validations via JSTL -->
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Add new Contact</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
					rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
					crossorigin="anonymous">
			</head>

			<body>

				<div class="container">
					<h1>New Contact</h1>
					<a href="/dashboard">Dashboard</a>

					<form:form method="POST" action="/contacts/create" modelAttribute="contact">
						<div class="form-group row">
							<form:label path="student" class="col-sm-2 col-form-label">Student:
								<form:errors path="student" />
								<div class="col-sm-10">
									<select class="form-control" name="student" path="student">
										<c:forEach items="${allStudents}" var="student">
											<option value="${student.id}">${student.firstName} ${student.lastName}</option>								
										</c:forEach>
									</select>
									<!-- <form:input path="state" class="form-control" />	 -->
								</div>
							</form:label>
						</div>

						<div class="form-group row">
							<form:label path="address" class="col-sm-2 col-form-label">Address:
								<form:errors path="address" />
								<div class="col-sm-10">
									<form:input path="address" class="form-control" />
								</div>
							</form:label>
						</div>
						<div class="form-group row">
							<form:label path="city" class="col-sm-2 col-form-label">City:
								<form:errors path="city" />
								<div class="col-sm-10">
									<form:input path="city" class="form-control" />
								</div>
							</form:label>
						</div>
						<div class="form-group row">
							<form:label path="state" class="col-sm-2 col-form-label">State:
								<form:errors path="state" />
								<div class="col-sm-10">
									<form:input path="state" class="form-control" />
								</div>
							</form:label>
						</div>



						<button>Create</button>

					</form:form>

				</div>


			</body>

			</html>