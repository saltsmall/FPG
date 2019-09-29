<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
		<div class="card">
			<div class="card-header">
				<h3>PLAYERS AND COACHES FOR HIRE</h3>
			</div>
			
			<div class="card-body">
				<c:forEach items="${persons}" var="person">
					<div class="row">
						${person.nameNick}
					</div>
				</c:forEach>			
			</div>
			
			<div class="card=footer">
			</div>	
		</div>
		
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"/>
	
</body>
</html>