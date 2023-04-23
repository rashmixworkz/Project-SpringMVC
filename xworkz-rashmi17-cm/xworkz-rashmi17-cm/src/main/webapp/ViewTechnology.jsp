<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>X-workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<nav class="navbar navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="90" height="30">
			</a>
			<div>
			
				<a href="index.jsp">Home</a> 
			
		        <a href="SignIn.jsp">SignIn</a>
		        
			    <span style="color: orange;">Welcome,${userID}</span>
			<img  src="download?fileName=${picture}" height="40"  width="30" > 
			</div>
			</div>
	</nav>
	
	<form action="view" method="get">
	<table>
	<tr>
	<th>TechName</th>
	<th>language</th>
	<th>owner</th>
	<th>supportFrom</th>
	<th>supportTo</th>
	<th>license</th>
	<th>openSource</th>
	<th>osType</th>
	</tr>
	<c:forEach items="${viewer}" var="v">
	
	<tr>
	<td>${v.techName}</td>
	<td>${v.language}</td>
	<td>${v.owner}</td>
	<td>${v.supportFrom}</td>
	<td>${v.supportTo}</td>
	<td>${v.license}</td>
	<td>${v.openSource}</td>
	<td>${v.osType}</td>
	
	</tr>
	</c:forEach>
	
	
	
	
	
	
	</table>
	</form>
	</body>
	</html>