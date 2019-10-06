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
		<form:form method="POST" action="/clubs/setLogo" modelAttribute="club" enctype="multipart/form-data">
         	<form:hidden path="id"/>
         	<input type="file" name="file" id="file"/>
			<button type="submit" class="btn btn-primary mt-2">SAVE</button>
		</form:form>
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>