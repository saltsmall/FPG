<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FOOTBALL PENALTY GAME</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>

	<div class="container">
		<form:form action="/clubs/save" method="post" modelAttribute="club" enctype="multipart/form-data">
			<div class="card">
				<div class="card-header">
					NEW CLUB CREATOR
				</div>
				<div class="card-body">
					
						<form:hidden path="id"/>
						<div class="row">
							<div class="col">
								NAME:
							</div>
							<div class="col">
								<form:input path="name"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="name"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								CITY:
							</div>
							<div class="col">
								<form:input path="city"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="city"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								COUNTRY:
							</div>
							<div class="col">
								<form:input path="country"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="country"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								SHORT NAME:
							</div>
							<div class="col">
								<form:input path="shortName"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="shortName"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								FULL NAME:
							</div>
							<div class="col">
								<form:input path="fullName"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="fullName"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								DATE OF CREATION:
							</div>
							<div class="col">
								<form:input type="date" path="created"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="created"/>
							</div>
						</div>
						<div class="row">
							<div class="col">
								BUDGET:
							</div>
							<div class="col">
								<form:input type="number" step="0.01" min="0" path="budget"/>
							</div>
							<div class="col text-danger font-italic">
								<form:errors path="budget"/>
							</div>
						</div>
				</div>
				<div class="card-footer text-right">
					<button class="btn btn-primary" type="submit">SAVE >></button>
				</div>
			</div>
		</form:form>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>