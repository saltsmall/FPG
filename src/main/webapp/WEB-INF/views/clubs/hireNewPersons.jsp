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
		
		<form action="/clubs/hireNewPersons" method="post">
			
			<input type="text" name="clubId" value="${club.id}" hidden="true"/>
			
			<div class="card">
				<div class="card-header">
					<h3>HIRE NEW PLAYER OR COACH</h3>
				</div>
				<div class="card-body">
					<c:forEach items="${personsForHire}" var="person">
						
						<%-- <div class="input-group mb-3">
						  <div class="input-group-prepend">
						    <div class="input-group-text">
						      <input type="checkbox" name="personsForHire" value="${person.id}"/>${person.nameNick}
						      <!-- <input type="checkbox" aria-label="Checkbox for following text input"> -->
						    </div>
						  </div>
						  <!-- <input type="text" class="form-control" aria-label="Text input with checkbox"> -->
						</div> --%>	
						
						<div class="row mt-1 mb-3 pt-3 border-top">
							<div class="col-sm-1">
								<input type="checkbox" name="personsForHire" value="${person.id}" style="width: 25px; height: 25px"/>
							</div>
							<div class="col-sm">
								<h4>${person.nameNick}</h4>
								<h6>GK (goalkeeping): ${person.goalkeeping}</h6>
								<h6>SH (shooting): ${person.shooting}</h6>
								<h5>Price: ${person.price} $</h5>
							</div>
							<!-- <div class="col-sm">
								<img src="/resources/img/logo-Person-000.png" width="100px" height="100px" alt="PERSON PHOTO"/>
							</div> -->
						</div>
						
					</c:forEach>
				</div>
				<div class="card-footer text-right">
					<input type="submit" class="btn btn-success" value="HIRE"/>
				</div>
			</div>
			
		</form>
	
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>