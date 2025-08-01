<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up user</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="images/icons/logo.jpg">



<style>

/*Signup form CSS */
#signupform {
	display: block;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
	max-width: 400px;
	margin: 0 auto;
	text-align: center;
	background-image: url("images/icons/signup.png");
}

#signupform h2 {
	margin: 0;
	color: rgb(63, 169, 17);
}

#signupform label {
	display: block;
	text-align: left;
	font-size: 17px;
	color: black;
	font-weight: bold;
	cursor: pointer;
}

#signupform input[type=text], #signupform input[type=email], #signupform input[type=password]
	{
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

#signupform input::placeholder {
	color: rgb(26, 25, 25);
}

#signupform input[type=submit] {
	background-color: #4afb3e;
	width: 130px;
	height: 40px;
	font-size: 15px;
	font-weight: bold;
	border-radius: 10px;
	cursor: pointer;
}

#signupform input[type=submit]:hover {
	background-color: rgb(237, 107, 51);
	box-shadow: 0px 5px 10px #888;
}

#signupform input[type=text]:focus, #signupform input[type=email]:focus,
	#signupform input[type=password]:focus {
	box-shadow: 0px 5px 15px #900;
	border: 2px solid black;
	/*background-color: hsl(53, 100%, 82%);*/
	color: #0e0e0e;
}

.star-mark {
	color: rgb(243, 22, 22);
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif
}

.custom-error-message2 {
	background-color: #f8d7da; /* Light red background */
	color: #721c24; /* Dark red text */
	padding: 10px;
	border-radius: 5px;
	text-align: center;
	font-weight: bold;
	margin-top: 20px;
}
</style>

</head>

<body>

	<%@ include file="main_nav.jsp"%>

	<br>
	<br>

	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null) {
	%>
	<div class="custom-error-message2">
		<%=errorMessage%>
	</div>
	<%
	}
	%>



	<form action="SignUpUser" method="post" onsubmit="return validate()"
		id="signupform">

		<h2>Register User</h2>

		<label for="username">User Name : <span class="star-mark">*</span>
		</label> <span id="msg"
			style="color: red; font-style: italic; font-weight: normal; font-family: sans-serif;"></span>

		<br> <input type="text" id="username"
			placeholder="Enter the Name" name="uname"> <br> <br>
		<label for="email">Email :<span class="star-mark">*</span>
		</label><span id="msg2"
			style="color: red; font-style: italic; font-weight: normal; font-family: sans-serif;"></span>
		<br> <input type="email" id="email" placeholder="Enter the email"
			name="emailId" required="required"> <br> <br> <label for="phone">Phone
			:<span class="star-mark">*</span>
		</label><span id="msg3"
			style="color: red; font-style: italic; font-weight: normal; font-family: sans-serif;"></span>
		<br> <input type="text" id="phone"
			placeholder="Enter the phone number" name="phoneNum"> <br>
		<br> <label for="pwd">Password :<span class="star-mark">*</span>
		</label> <br> <input type="password" id="pwd"
			placeholder="Enter the password" name="pwd" required>
		<!-- An element to toggle between password visibility -->
		<input type="checkbox" onclick="togglePassword()">Show
		Password <br> <br> <input type="checkbox" required>Accept
		the terms and condition <br> <br> <input type="submit"
			value="Sign Up"> <br>

		<p>Already have an account ? please LogIn</p>
		<a href="login.jsp">Login</a> <br>
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