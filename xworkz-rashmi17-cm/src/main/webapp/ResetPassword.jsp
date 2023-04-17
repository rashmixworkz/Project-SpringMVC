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
			</a> <a href="SignIn.jsp">Login</a>
		</div>
	</nav>

	<h1 align="center">ResetPassword Page</h1>
	<span style="color: blue;">${message}</span>
	<div class="container d-lg-flex justify-content-center">
		<form action="reset" method="post">

			<div class="mb-3 mt-3">
				<label for="emailId" class="form-label">Email:</label> <input
					type="email" class="form-control" id="emailId"
					placeholder="Enter your emailId" name="email" onchange="onEmail()" />
				<span id="emailerror" style="color: red;"></span>
			</div>

			<div align="center">
				<input type="submit" value="ResetPassword" class="btn btn-success" />
			</div>
		</form>

	</div>




	<script>
		function onEmail() {
			var emailInput = document.getElementById('emailId');
			var emailValue = emailInput.value;
			console.log(emailValue);
			if (emailValue != null && emailValue != "" && emailValue.length > 3
					&& emailValue.length < 40) {
				console.log('Valid EmailId');
				document.getElementById('emailerror').innerHTML = '';
			} else {
				console.log('InValid EmailId');
				document.getElementById('emailerror').innerHTML = 'Please Enter valid Email';
			}

		}
	</script>
</body>
</html>