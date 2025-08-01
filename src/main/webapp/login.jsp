<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login User</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="images/icons/logo.jpg">


<script src="js/singnup.js"></script>


<style>
body {
	/* background-image: url(Indian-Food-PNG-Image.png); */
	background-image: url("images/icons/delivery.avif");
	background-color: #eeeded;
	background-size: 670px 600px;
	/*670px 600px;  Width = 500px, Height = 300px */
}

#loginform {
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
	max-width: 400px;
	margin: 0 auto;
	text-align: center;
}

h2 {
	margin: 0;
	color: red;
}

#loginform label {
	display: block;
	text-align: left;
	font-size: 17px;
	color: black;
	font-weight: bold;
	cursor: pointer;
	text-transform: capitalize;
}

#loginform input[type=text], #loginform input[type=password] {
	padding: 15px;
	border-radius: 5px;
	/* margin-bottom: 10px; */
	width: 100%;
	height: 40px;
	box-sizing: border-box;
	/* background-color: #e2c9c9; */
	color: #181818;
	font-size: 14px;
	font-weight: bold;
	text-align: left;
	outline: none;
	border: 0.5px solid rgb(37, 36, 36);
}

#loginform input::placeholder {
	color: rgb(26, 25, 25);
}

#loginform input[type=submit] {
	background-color: #fb6d3e;
	width: 130px;
	height: 40px;
	font-size: 15px;
	font-weight: bold;
	border-radius: 10px;
	cursor: pointer;
}

#loginform input[type=submit]:hover {
	background-color: rgb(104, 237, 51);
	box-shadow: 0px 5px 10px #888;
	color: white;
}

#loginform input[type=text]:focus, #loginform input[type=password]:focus
	{
	/*background-color: hsl(53, 100%, 82%);*/
	box-shadow: 0px 5px 15px #900;
	border: 2px solid green;
	color: #0e0e0e;
}

.star-mark {
	color: rgb(243, 22, 22);
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif
}

.custom-error-message1 {
	background-color: #f8d7da;
	color: #721c24;
	padding: 10px;
	border-radius: 5px;
	margin-top: 20px;
	text-align: center;
	font-weight: bold;
}

.custom-error-message2 {
	background-color: #fff3cd;
	color: #856404;
	padding: 10px;
	border-radius: 5px;
	margin-top: 20px; /* 60px  or 17px is good*/
	text-align: center;
	font-weight: bold;
}

.custom-error-message3 {
	background-color: #d4edda;
	color: #155724;
	padding: 10px;
	border-radius: 5px;
	margin-top: 20px;
	text-align: center;
	font-weight: bold;
}
</style>

</head>

<body>

	<%@ include file="main_nav.jsp"%>

	<br>
	<br>



	<%
	String msg4 = "Attempts over. Please contact Admin!";
	String msg5 = "Congrats Succesfully Register ! Login Now";

	String registermsg = (String) request.getAttribute("registermsg");
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null && errorMessage.equals(msg4)) {
	%>
	<div class="custom-error-message1">
		<%=errorMessage%>

	</div>
	<%
	} else if (registermsg != null && registermsg.equals(msg5)) {
	%>
	<div class="custom-error-message3">
		<%=registermsg%>
	</div>
	<%
	} else if (errorMessage != null) {
	%>
	<div class="custom-error-message2">
		<%=errorMessage%>

	</div>
	<%
	}
	%>
	<br>
	<br>
	<br>


	<form action="LoginUser" method="post" onsubmit="return validate()"
		id="loginform">

		<h2>Login User</h2>

		<label for="username">User Name : <span class="star-mark">*</span>
		</label> <span id="msg"
			style="color: red; font-style: italic; font-weight: normal; font-family: sans-serif;"></span>

		<br> <input type="text" id="username"
			placeholder="Enter the Name" name="username"> <br> <br>
		<label for="pwd">Password :<span class="star-mark">*</span>
		</label> <br> <input type="password" id="pwd"
			placeholder="Enter the password" name="password"
			autocomplete="password">
		<!-- An element to toggle between password visibility -->
		<input type="checkbox" onclick="togglePassword()">Show
		Password <br> <br> <input type="checkbox" required>Accept
		the terms and condition <br> <br> <input type="submit"
			value="Log In"> <br>

		<p>Don't have an account ? please SignUp first</p>
		<a href="signup.jsp">SignUp</a> <br>
	</form>

	<br>
	<br>
	<script>
		function togglePassword() {
			var x = document.getElementById("pwd");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>



</body>
</html>