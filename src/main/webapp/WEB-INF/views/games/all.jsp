<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>

<head>
	<meta charset="UTF-8">
	<title>FOOTBALL PENALTY GAME</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

	<jsp:include page="../header.jsp"/>

	<!-- list of all games -->
	<div class="container">
		<c:forEach items="${gamesAll}" var="game">
			<div class="row border">
			  <div class="col-sm">
			    ${game.id}
			  </div>
			  <div class="col-sm">
			    ${game.host.name}
			  </div>
			  <div class="col-sm">
			    ${game.goalsHost}
			  </div>
			  <div class="col-sm">
			    :
			  </div>
			  <div class="col-sm">
			    ${game.goalsGuest}
			  </div>
			  <div class="col-sm">
			    ${game.guest.name}
			  </div>
			</div>
		</c:forEach>
	</div>

	<jsp:include page="../footer.jsp"/>

</body>

</html>