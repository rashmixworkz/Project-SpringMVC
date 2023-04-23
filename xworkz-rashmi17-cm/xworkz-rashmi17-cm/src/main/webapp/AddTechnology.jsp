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
				alt="" width="90" height="30"></a>
				<div>
				<a href="index.jsp">Home</a> 
			
		        <a href="SignIn.jsp">SignIn</a>
				<span style="color: orange;">Welcome,${userID}</span>
			<img  src="download?fileName=${picture}" height="40"  width="30" > 
			</div>
		</div>
	</nav>
	
	<span style="color: Green">${added}</span>
	
<div align="center">
<form action="addTech" method="post">
<pre>
user <input value="${userID}" readonly="readonly" name="userId">
techName   <input type="text" name="techName" value="${technologyEntity.techName}"/>
language   <input type="text" name="language" value="${technologyEntity.language}"/>
owner      <input type="text" name="owner" value="${technologyEntity.owner}"/>
supportFrom<input type="text" name="supportFrom" value="${technologyEntity.supportFrom}"/>
supportTo  <input type="text" name="supportTo" value="${technologyEntity.supportTo}"/>
license	   <input type="text" name="license" value="${technologyEntity.license}"/>
openSource <input type="text" name="openSource" value="${technologyEntity.openSource}"/>
osType     <input type="text" name="osType" value="${technologyEntity.osType}"/>
<input type="submit" value="ADD">
           
</pre>
</form>
</div>

</body>
</html>