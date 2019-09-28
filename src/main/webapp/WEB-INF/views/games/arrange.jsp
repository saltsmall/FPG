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
	
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	
	<div class="container">
		<form:form action="/games/arrange" method="post" modelAttribute="game">
			<form:hidden path="id"/>
			<div class="card">
				<div class="card-header">
					NEW GAME
				</div>
				
				<div class="card-body">
					<div class="row">
						<div class="col-sm">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
    								<label class="input-group-text">HOST:</label>
    							</div>
								<%-- <form:select path="host.id" items="${allClubs}" itemValue="id"/> --%>
								<form:select path="host.id">
									<c:forEach items="${allClubs}" var="club">
										<form:option 
											class="custom-select"
											label="${club.name} ${club.city}" 
											value="${club.id}"
										/>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="col-sm">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
    								<label class="input-group-text">GUEST:</label>
    							</div>
								<%-- <form:select path="guest.id" items="${allClubs}" itemValue="id"/> --%>
								<form:select path="guest.id">
									<c:forEach items="${allClubs}" var="club">
										<form:option 
											class="custom-select"
											label="${club.name} ${club.city}" 
											value="${club.id}"
										/>
									</c:forEach>
								</form:select>
							</div>
						</div>
					</div>
				</div>
				
				<div class="card-footer text-right">
					<button type="submit" class="btn btn-success">ARRANGE</button>
				</div>
			
			</div>
		</form:form>
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"/>
	
</body>
</html>