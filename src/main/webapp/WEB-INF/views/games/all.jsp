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
		<div class="card">
			<div class="card-header text-right">
				<a class="btn btn-primary" href="/games/randomplay">PLAY RADNOM MATCH</a>
				<a class="btn btn-primary" href="/games/arrange">ARRANGE MATCH</a>
			</div>
			<div class="card-body">
				<c:forEach items="${gamesAll}" var="game">
					<div class="row mt-2 mb-3">
					  <div class="col-sm border text-left">
					    ID: ${game.id}
					  </div>
					  <div class="col-sm border text-right">
					    ${game.host.name}
					  </div>
					  <div class="col-sm border text-right">
					    ${game.goalsHost}
					  </div>
					  <div class="col-sm border text-center">
					    :
					  </div>
					  <div class="col-sm border text-left">
					    ${game.goalsGuest}
					  </div>
					  <div class="col-sm border text-left">
					    ${game.guest.name}
					  </div>
					</div>
				</c:forEach>
			</div>
			<div class="card-footer">
			</div>
		</div>
	</div>

	<jsp:include page="../footer.jsp"/>

</body>

</html>