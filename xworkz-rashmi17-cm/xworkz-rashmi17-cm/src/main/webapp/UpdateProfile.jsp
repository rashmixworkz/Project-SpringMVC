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
		     <img  src="download?fileName=${picture}" height="40" width="30" > 
	   </div>	
				
	</div>
	</nav>
	<h1>Update Profile</h1>
	<div class="container d-lg-flex justify-content-center">
	<form action="profile" method="post" enctype="multipart/form-data">
	
	<div class="mb-3 mt-3">

				<label for="emailId" class="form-label">Email:</label> 
				<input	type="email" class="form-control" id="emailId"
				placeholder="Enter your emailId" name="email" onchange="onEmail()"  value="${userDto.email}" readonly="readonly"/>
				<span id="emailerror" style="color: red;"></span> 
				<span id="displayEmail" style="color: red"></span>
          </div>
	
	<div class="mb-3 mt-3">
				<label for="user" class="form-label">UserId:</label> 
				<input	type="text" class="form-control" id="user"
				placeholder="Enter your userId" name="userId" onchange="onUserId()" value="${userDto.userId}"/>
				<span id="userError" style="color: red;"></span> 
				<span id="displayUserName" style="color: red"></span>
			</div>
			
    <div class="mb-3 mt-3">

				<label for="mnumber" class="form-label">Mobile Number:</label>
				 <input	type="number" class="form-control" id="mnumber" name="mobile"
					placeholder="Enter your MobileNo" onchange="validMobile()" value="${userDto.mobile}"/> 
				<span id="mnumberErropr" style="color: red;"></span> 
				<span id="displayNumber" style="color: red"></span>
</div>
	
	
	Set Profile Picture: <input type="file" name="chitra"> 
	<div> <button type="submit" class="btn btn-primary">Update</button> </div>
	
	
	
	</form>
	</div>
	
	<script>
	function onUserId() {
		console.log('Running onUserId');
		var userInput = document.getElementById('user');
		var userValue = userInput.value;
		console.log(userValue);
		if (userValue != null && userValue != "" && userValue.length > 3
				&& userValue.length < 20) {
			console.log('Valid UserId');
			var agree = document.getElementById('acceptAgrement');
			if (agree.checked) {
				document.getElementById('submitId').disabled = false;
			}
			document.getElementById('userError').innerHTML = '';
		} else {
			console.log('InValid UserId');
			document.getElementById('submitId').disabled = 'disabled';
			document.getElementById('userError').innerHTML = 'Invalid userId,Please enter userId min 3 or max 20';
		}
		const xhttp = new XMLHttpRequest();
		console.log('Running in Ajax');
		console.log(userValue);
		xhttp.open("GET",
				"http://localhost:8089/xworkz-rashmi17-cm/userName/"
						+ userValue);
		xhttp.send();
		xhttp.onload = function() {
			console.log(this);
			document.getElementById("displayUserName").innerHTML = this.responseText
		}
	}

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
		const xhttp = new XMLHttpRequest();
		console.log('Running in ajax');
		console.log(emailValue);
		xhttp.open("GET",
				"http://localhost:8089/xworkz-rashmi17-cm/emailId/"
						+ emailValue);
		xhttp.send();
		xhttp.onload = function() {
			console.log(this);
			document.getElementById("displayEmail").innerHTML = this.responseText

		}
	}

	function validMobile() {
		var mobileInput = document.getElementById('mnumber');
		var mobileValue = mnumber.value;
		console.log(mobileValue);
		if (mobileValue != null && mobileValue != ""
				&& mobileValue.length == 10) {
			console.log('Valid Mobile number');

			const xhttp = new XMLHttpRequest();
			console.log('Running in ajax');
			console.log(mobileValue);
			xhttp.open("GET",
					"http://localhost:8089/xworkz-rashmi17-cm/randomNumber/"
							+ mobileValue);
			xhttp.send();
			xhttp.onload = function() {
				console.log(this);
				document.getElementById("displayNumber").innerHTML = this.responseText
			}
			document.getElementById('mnumberErropr').innerHTML = '';
		} else {
			console.log('InValid Mobile Number');
			document.getElementById('mnumberErropr').innerHTML = 'please enter valid mobile number';
		}
	}

	</script>
	


</body>
</html>