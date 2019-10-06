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
					<h2>${club.name} ${club.city}</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div style="col">
							<c:if test="${club.logo eq null}">
								<img src="/resources/img/football_club_logo_000.jpg" width="200px" height="200px"/>
							</c:if>
							<c:if test="${club.logo ne null}">
								<img src="/clubs/logo/${club.id}.jpg" width="200px" height="200px" alt="LOGO FROM DB"/>
							</c:if>
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
					<a href="/clubs/${club.id}/details" class="btn btn-primary">
						DETAILS
					</a>
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