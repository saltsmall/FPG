<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	

	<script src="/resources/js/gameCalculation.js" type="text/javascript"></script>
	
</head>
<body>

	<jsp:include page="../header.jsp"/>
	
	<div class="container">
	
		<table id="tableGame" class="table">
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
						<table id="tableTeamHost" class="table">
						<c:forEach items="${game.host.persons}" var="person">
							<tr>
								<td class="text-left">${person.nameFirst} ${person.nameLast}</td>
								<td style="font-size: 10px">GK:</td>
								<td style="font-size: 10px">${person.goalkeeping}</td>
								<td style="font-size: 10px">SH:</td>
								<td style="font-size: 10px">${person.shooting}</td>
							</tr>
						</c:forEach>
						</table>
					</td>
					<td>
					</td>
					<td colspan="2">
						<table id="tableTeamGuest" class="table">
						<c:forEach items="${game.guest.persons}" var="person">
							<tr>
								<td class="text-right">${person.nameFirst} ${person.nameLast}</td>
								<td style="font-size: 10px">GK:</td>
								<td style="font-size: 10px">${person.goalkeeping}</td>
								<td style="font-size: 10px">SH:</td>
								<td style="font-size: 10px">${person.shooting}</td>
							</tr>							
						</c:forEach>
						</table>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" class="text-right">
						<button id="randomPenalty">random penalty</button>
						<button id="calculatePenalty">calculate penalty</button>
						<button id="randomScore">random score/result</button>
						<form:form method="post" action="/games/play/save" modelAttribute="game">
							<form:hidden id="formGameId" path="id"/>
							<form:hidden id="formGameHost" path="host.id"/>
							<form:hidden id="formGameGuest" path="guest.id"/>
							<form:hidden id="formGameGoalsHost" path="goalsHost"/>
							<form:hidden id="formGameGoalsGuest" path="goalsGuest"/>
							<button id="finishGame" type="submit" disabled>finish save/game</button>
						</form:form>
					</td>
				</tr>
			</tfoot>
		</table>
	
	</div>
	
	<jsp:include page="../footer.jsp"/>

</body>
</html>