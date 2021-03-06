<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
</head>

<body>
	<div class="container">
		<nav class="nav">
	        <a class="nav-link" href="<c:url value="/startDB"/>">START DB</a>
	        <a class="nav-link" href="<c:url value="/home"/>">HOME</a>
	        <a class="nav-link" href="<c:url value="/games/all"/>">GAMES</a>
	        <%-- <a class="nav-link" href="<c:url value="/games/randomplay"/>">PLAY RANDOM MATCH</a> --%>
	        <a class="nav-link" href="<c:url value="/clubs/all"/>">CLUBS</a>
	        <a class="nav-link" href="<c:url value="/clubs/new"/>">NEW CLUB</a>
	        <a class="nav-link" href="<c:url value="/persons/forHire"/>">PERSONS</a>
	    </nav>
    </div>
</body>

</html>