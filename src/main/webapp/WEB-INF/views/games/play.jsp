<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			var goalsHost = document.getElementById("goalsHost");
			var goalsGuest = document.getElementById("goalsGuest");
			var formGameGoalsHost = document.getElementById("formGameGoalsHost");
			var formGameGoalsGuest = document.getElementById("formGameGoalsGuest");
			
			var randomScore = document.getElementById("randomScore");
			var finishGame = document.getElementById("finishGame");
			
			randomScore.addEventListener("click", function() {
				goalsHost.style.color = "blue";
				var goalsHostNo = Math.floor(Math.random()*10)
				goalsHost.innerText = goalsHostNo;
				goalsGuest.style.color = "blue";
				var goalsGuestNo = Math.floor(Math.random()*10)
				goalsGuest.innerText = goalsGuestNo;
 				formGameGoalsHost.value = goalsHostNo;
				formGameGoalsGuest.value = goalsGuestNo;
				randomScore.disabled = true;
				finishGame.disabled = false;
			});
			
		});
	</script>
</head>
<body>

	<jsp:include page="../header.jsp"/>
	
	<div class="container">
	
		<table class="table">
			<thead>
				<tr>
					<th class="border text-left" style="width: 200px">${game.host.name}</th>
					<th id="goalsHost" class="border text-center" style="width: 20px">${game.goalsHost}</th>
					<th class="border text-center" style="width: 10px">:</th>
					<th id="goalsGuest" class="border text-center"style="width: 20px">${game.goalsGuest}</th>
					<th class="border text-right" style="width: 200px">${game.guest.name}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">
						<table class="table">
						<c:forEach items="${game.host.persons}" var="person">
							<tr>
								<td class="text-left">${person.nameFirst} ${person.nameLast}</td>
							</tr>
						</c:forEach>
						</table>
					</td>
					<td>
					</td>
					<td colspan="2">
						<table class="table">
						<c:forEach items="${game.guest.persons}" var="person">
							<tr>
								<td class="text-right">${person.nameFirst} ${person.nameLast}</td>
							</tr>
						</c:forEach>
						</table>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" class="text-right">
						<button disabled>kick penalty</button>
						<button id="randomScore">random score</button>
						<form:form method="post" action="/games/play/save" modelAttribute="game">
							<form:hidden id="formGameId" path="id"/>
							<form:hidden id="formGameHost" path="host.id"/>
							<form:hidden id="formGameGuest" path="guest.id"/>
							<form:hidden id="formGameGoalsHost" path="goalsHost"/>
							<form:hidden id="formGameGoalsGuest" path="goalsGuest"/>
							<button id="finishGame" type="submit" disabled>finish game</button>
						</form:form>
					</td>
				</tr>
			</tfoot>
		</table>
	
	</div>
	
	<jsp:include page="../footer.jsp"/>

</body>
</html>