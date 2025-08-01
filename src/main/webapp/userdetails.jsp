<%@page import="com.rjfoods.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

<!-- Add Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style type="text/css">
table {
	width: 90%; /* Makes the table take the full width of its container */
	border-collapse: collapse;
	/* Ensures no space between the borders of the cells */
}

tr, td, th {
	border: 2px solid red; /* Keeps the table borders visible */
	padding: 8px; /* Adds some padding for better readability */
	font-weight: bold;
}

th {
	background-color: black;
	color: white;
}


tr:nth-child(even) {
    background-color: rgba(2, 6, 12, 0.45);;
}

</style>
</head>

<body>

	<%@ include file="admindash.html"%>

	<%
	int user_count = (int) session.getAttribute("userCount");
	%>
	<%
	int restaurant_count = (int) session.getAttribute("restaurantCount");
	%>




	<div style="padding-left: 300px">
		<h2>All Registered User</h2>
		<h2>manage all the registered user</h2>
		<table>

			<thead>
				<tr>
					<th>UserId</th>
					<th>Name</th>
					<th>Email</th>
					<th>phone No</th>
					<th>address</th>
					<th>Last Login</th>
					<th>Delete User</th>

				</tr>
			</thead>
			<tbody>
				<%
					List<User> userList = (List<User>) session.getAttribute("allUser");
					if (userList != null && !userList.isEmpty()) {
						for (User user : userList) {
					%>
				<tr>
					<td><%=user.getUserId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getEmail()%></td>
					<td><%=user.getPhoneNo()%></td>
					<td><%=user.getAddress()%></td>
					<td><%=user.getLastLogin()%></td>
					<td><a href="DeleteUser?userId=<%=user.getUserId()%>"><i
							class='far fa-trash-alt' style='font-size: 36px'></i></a></td>
				</tr>
				<%
					}
					} else {
					%>
				<tr>
					<td colspan="4">No users found</td>
				</tr>
				<%
					}
					%>
			</tbody>


		</table>

	</div>




</body>

</html>
