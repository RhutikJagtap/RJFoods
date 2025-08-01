<%@page import="com.rjfoods.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="icon" href="images/icons/profile.png">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 50%;
	max-width: 450px;
	margin: 50px auto;
	background-color: #ffffff;
	padding: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

h3 {
	text-align: center;
	color: #333;
}

.profile-info {
	margin: 20px 0;
}

.profile-image {
	width: 100px;
	height: 100px;
	border-radius: 50%;
	object-fit: cover;
	margin: 10px 170px;
	border: 3px solid red;
}

.profile-info p {
	font-size: 16px;
	margin: 10px 0;
	color: #555;
}

.profile-info strong {
	color: #333;
}

.profile-info .label {
	font-weight: bold;
	margin-right: 5px;
	color: #333;
}

.btn-edit {
	display: inline-block;
	margin: 20px 0;
	padding: 10px 20px;
	background-color: #007BFF;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	text-align: center;
}

.btn-edit:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%@ include file="without_searchbar_navbar.jsp"%>

	<%
	User user = (User) session.getAttribute("user");
	%>


	<div class="container">
		<h3>Profile Details</h3>
		<img src="images/icons/profile.png" alt="User Image"
			class="profile-image">

		<div class="profile-info">
			<p>
				<span class="label">Name:</span> <strong><%=user.getName()%></strong>
			</p>
			<p>
				<span class="label">Email:</span> <strong><%=user.getEmail()%></strong>
			</p>
			<p>
				<span class="label">Phone:</span> <strong><%=user.getPhoneNo()%></strong>
			</p>
			<p>
				<span class="label">Address:</span> <strong><%=user.getAddress()%></strong>
			</p>
		</div>

		<a href="#" class="btn-edit">Edit Profile</a>
		<a href="OrderHistory?userId=<%= user.getUserId()%>"  class="btn-edit">Order History</a>
		<a href="orderTrack.jsp"  class="btn-edit">Track Order</a>
	</div>

</body>
</html>