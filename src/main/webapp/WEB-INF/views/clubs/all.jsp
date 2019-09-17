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
	
		
		
		<c:forEach items="${clubsAll}" var="club">
			<div class="card d-inline-block mb-5 mx-1" style="width: 500px">
				<div class="card-header">
					<h2>${club.name}</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div style="col">
							<img src="/resources/img/logo-Club-001.png" width="200px" height="200px"/>
						</div>
						<div style="col">
							<ul>
								<c:forEach items="${club.persons}" var="person">
									<li>${person.nameFirst} ${person.nameLast}</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="card-footer text-right">
					<button class="btn btn-primary disabled" type="submit" disabled="true">
						DETAILS
					</button>
					<button class="btn btn-danger disabled" type="submit" disabled="true">
						DELETE
					</button>
				</div>
			</div>
		</c:forEach>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>