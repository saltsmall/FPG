<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<form:form method="post" action="/clubs/update" modelAttribute="club">
		<div class="card">
			<div class="card-header">
				<div class="row">
					<div class="col">
						<form:hidden path="id"/>
						<h6 class="d-inline-block"><form:input path="name"/></h6>
						<h6 class="d-inline-block"><form:input path="city"/></h6>
					</div>
					<div class="col text-right">
						<h6 class="d-inline-block"><form:input class="text-right" path="country"/></h6>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<h5>
							Date of creation:
							<fmt:setLocale value="en_US" scope="session"/>
							<%-- <fmt:formatDate
								type="date"
								pattern="yyyy MMM dd"
								value="${club.created}"
							/> --%>
							<form:input type="date" path="created"/>
						</h5>
						<h5>
							Budget:
							<%-- <fmt:formatNumber 
								type="currency"
								minFractionDigits="2"
								maxFractionDigits="2"
								currencySymbol="$"
								value="${club.budget}"
							/> --%>
							<form:input type="number" step="0.01" path="budget"/>
						</h5>
					</div>
				</div>
				<div class="row border-top pt-2">
					<div class="col text-right">
						<%-- <a href="/clubs/${club.id}/edit" class="btn btn-success">
							SAVE >>
						</a> --%>
						<button type="submit" class="btn btn-success">
							SAVE >>
						</button>
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
								<%-- <form:input path="coachFirst" value="no coach" disabled="true"/> --%>
								<%-- <form:select items="${club.persons}"
									itemLabel="nameNick" 
									itemValue="id"
									path="coachFirst"
								/> --%>
								<form:select class="float-right" path="coachFirst">
									<form:option value="${club.coachFirst.id}"
										label="${club.coachFirst.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="row mx-2 border-bottom">
							<div class="col">
								GOALKEEPER:
								<%-- <form:hidden path="persons"/> --%>
								<form:select class="float-right" path="goalkeeper">
									<form:option value="${club.goalkeeper.id}"
										label="${club.goalkeeper.nameNick}"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						
						<div class="row mx-2 border-top">
							<div class="col">
								SHOOTERS:
							</div>
						</div>
						<div class="row">
							<div class="col"></div>
							<div class="col">
								<%-- 1. ${club.shooter01} --%>
								<form:select class="float-right" path="shooter01">
									<form:option value="${club.shooter01.id}"
										label="${club.shooter01.nameNick} | GK:${club.shooter01.goalkeeping} SH:${club.shooter01.shooting}"
									/>
									<form:option value="" disabled="true"
										label="---"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="row">
							<div class="col"></div>
							<div class="col">
								<%-- 2. ${club.shooter02} --%>
								<form:select class="float-right" path="shooter02">
									<form:option value="${club.shooter02.id}"
										label="${club.shooter02.nameNick} | GK:${club.shooter02.goalkeeping} SH:${club.shooter02.shooting}"
									/>
									<form:option value="" disabled="true"
										label="---"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="row">
							<div class="col"></div>
							<div class="col">
								<%-- 3. ${club.shooter03} --%>
								<form:select class="float-right" path="shooter03">
									<form:option value="${club.shooter03.id}"
										label="${club.shooter03.nameNick} | GK:${club.shooter03.goalkeeping} SH:${club.shooter03.shooting}"
									/>
									<form:option value="" disabled="true"
										label="---"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="row">
							<div class="col"></div>
							<div class="col">
								<%-- 4. ${club.shooter04} --%>
								<form:select class="float-right" path="shooter04">
									<form:option value="${club.shooter04.id}"
										label="${club.shooter04.nameNick} | GK:${club.shooter04.goalkeeping} SH:${club.shooter04.shooting}"
									/>
									<form:option value="" disabled="true"
										label="---"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="row">
							<div class="col"></div>
							<div class="col">
								<%-- 5. ${club.shooter05} --%>
								<form:select class="float-right" path="shooter05">
									<form:option value="${club.shooter05.id}"
										label="${club.shooter05.nameNick} | GK:${club.shooter05.goalkeeping} SH:${club.shooter05.shooting}"
									/>
									<form:option value="" disabled="true"
										label="---"
									/>
									<c:forEach items="${club.persons}" var="person">
										<form:option value="${person.id}" 
											label="${person.nameNick} | GK:${person.goalkeeping} SH:${person.shooting}"
										/>								
									</c:forEach>
								</form:select>
							</div>
						</div>
						
						<div class="row mx-2">
							<div class="col">
								ALL TEAM:
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
	</form:form>
	</div>
	
	
	<jsp:include page="../footer.jsp"/>

</body>
</html>