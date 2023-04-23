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
			<a href="SignIn.jsp">Login</a>
			</div>
		</div>
	</nav>
<body>
	<h1 align="center" style="color: #48d1cc;">Update Your Password</h1>
	<div class="container d-lg-flex justify-content-center">
	<form action="updatePassword" method="post">

		<div class="mb-3 mt-3">
			<label for="user" class="form-label">UserId:</label> <input
				type="text" class="form-control" id="user"
				placeholder="Enter your userId" name="userId" onchange="onUserId()">
			<span id="userError" style="color: red;"></span> <span
				id="displayUserName" style="color: red"></span>
		</div>

		<div class="mb-3">
			<label for="word" class="form-label">New Password:</label> <input
				type="password" id="word" class="form-control" name="password"
				placeholder="Enter your password" /> <span id="wordError"
				style="color: red;"></span> <input type="checkbox"
				onclick="myPassword()">Show Password
		</div>

		<div class="mb-3">
			<label for="rword" class="form-label">Confirm Password:</label> <input
				type="password" id="rword" class="form-control"
				name="confirmPassword" placeholder="ReEnter your password" /> <input
				type="checkbox" onblur="validatePassword()" onclick="myPassword1()" />Show
			Confirm Password
		</div>
<div align="center">
		<input type="submit" value="UpdatePassword" class="btn btn-primary" />
</div>
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

		function myPassword1() {
			var pass = document.getElementById('rword');
			if (pass.type == 'password') {
				pass.type = 'text';
			} else {
				pass.type = 'password';
			}

			function validPassword() {
				var Password = document.getElementById('word');
				var confirmPassword = document.getElementById('rword');
				var wordValue = Password.value;
				var confirmWordValue = confirmPassword.value;
				console.log(wordValue);
				if (wordValue != null && wordValue != ""
						&& wordValue.length > 8 && wordValue.length < 16) {
					if (wordValue == confirmWordValue) {
						console.log('Both passwords are matching');
						document.getElementById('rwordError').innerHTML = '';
					} else {
						console.log('Both passwords are not matching');
						document.getElementById('rwordError').innerHTML = 'Password and ConfirmPassword not same';

					}
					console.log('Valid password');
					document.getElementById('wordError').innerHTML = '';
				} else {
					console.log('InValid password');
					document.getElementById('wordError').innerHTML = 'Please Enter valid Password';
				}
			}

		}
	</script>

</body>
</html>