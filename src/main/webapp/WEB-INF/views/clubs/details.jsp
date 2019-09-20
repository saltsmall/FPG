<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<jsp:include page="../header.jsp"/>

	<div class="container">
		<div class="card">
			<div class="card-header">
				<div class="row">
					<div class="col">
						<h2>${club.name} ${club.city }</h2>
					</div>
					<div class="col text-right">
						<h2>${club.country}</h2>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<h5>
							Date of creation:
							<fmt:setLocale value="en_US" scope="session"/>
							<fmt:formatDate
								type="date"
								pattern="yyyy MMM dd"
								value="${club.created}"
							/>
						</h5>
						<h5>
							Budget:
							<fmt:formatNumber 
								type="currency"
								minFractionDigits="2"
								maxFractionDigits="2"
								currencySymbol="$"
								value="${club.budget}"
							/> 
						</h5>
					</div>
				</div>
				<div class="row border-top pt-2">
					<div class="col text-right">
						<a href="/clubs/${club.id}/edit" class="btn btn-primary">
							EDIT CLUB INFO
						</a>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col border-right" style="max-width: 250px">
						<img src="/resources/img/logo-Club-001.png"  
							alt="CLUB LOGO"
							width="200px" height="200px"
						/>
					</div>
					<div class="col">
						<div class="row mx-2 border-bottom">
							<div class="col">
								COACH:
							</div>
							<div class="col">
								... lorem ipsum
							</div>
						</div>
						<div class="row mx-2 border-bottom">
							<div class="col">
								GOALKEEPER:
							</div>
							<div class="col">
								<c:forEach 
									begin="0" end="0"
									items="${club.persons}"
									var="person"
								>
									${person.nameFirst} ${person.nameLast}
								</c:forEach>
							</div>
						</div>
						<div class="row mx-2">
							<div class="col">
								SHOOTERS:
							</div>
						</div>
						<c:forEach 
							begin="1" end="5"
							items="${club.persons}"
							var="person"
						>
							<div class="row">
								<div class="col"></div>
								<div class="col">
									${person.nameFirst} ${person.nameLast}
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="card-footer text-right">
				<a href="/clubs/${club.id}/setPlayersPos" class="btn btn-primary disabled">
					SET PLAYERS POSITIONS
				</a>
			</div>
		</div>
	</div>

	<jsp:include page="../footer.jsp"/>

</body>

</html>