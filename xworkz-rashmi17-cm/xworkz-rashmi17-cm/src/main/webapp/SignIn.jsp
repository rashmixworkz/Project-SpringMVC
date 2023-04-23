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
				<a href="index.jsp">Home</a> <a
					href="UpdatePassword.jsp">Update</a>
			</div>
		</div>
	</nav>
	<h1 class="text-center" style="color: orange;">	Login To Your Account</h1>

	<h5 class="text-center" style="color: red;">${errorMsg}</h5>
	<h6 class="text-center" style="color: red;">${message}</h6>
	<h5 class="text-center" style="color: red;">${alert}</h5>
	<div class="container d-lg-flex justify-content-center">
		<form action="signin" method="post">

			<div class="mb-3 mt-3">
				<label for="user" class="form-label">UserId:</label> <input
					type="text" class="form-control" id="user"
					placeholder="Enter your userId" name="userId" onchange="onUserId()" />
				<span id="userError" style="color: red;"></span> <span
					id="displayUserName" style="color: red"></span>
			</div>


			<div class="mb-3">
				<label for="word" class="form-label">Password:</label> <input
					type="password" id="word" class="form-control" name="password"
					placeholder="Enter your password" /> <span id="wordError"
					style="color: red;"></span> <input type="checkbox"
					onclick="myPassword()" />Show Password
			</div>

			
		
			<div align="center">
				<input type="submit" class="btn btn-primary" value="Login"/>
			</div>
			<div align="center">
	       Forgot <a href="ResetPassword.jsp">Password?</a>
	        </div>
	        Don't have Account? <a href="index.jsp">SignUp</a> 
		</form>
	</div>


	<script>
		function myPassword() {
			var pass = document.getElementById('word');
			if (pass.type == 'password') {
				pass.type = 'text';
			} else {
				pass.type = 'password';
			}

		}
	</script>

</body>
</html>
