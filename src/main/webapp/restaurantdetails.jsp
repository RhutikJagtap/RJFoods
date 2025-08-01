<%@page import="com.rjfoods.model.Restaurant"%>
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

.add-btn {
	background-color: #28a745; /* green */
	color: white;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 8px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.add-btn:hover {
	background-color: #218838;
}
/*

tr:nth-child(even) {
    background-color: orange;
}
*/
.custom-error-message1 {
	background-color: #f8d7da;
	color: #721c24;
	padding: 10px;
	border-radius: 5px;
	/*margin-top: 5px;*/
	text-align: center;
	font-weight: bold;
}

.custom-success-message {
	background-color: #d4edda;
	color: #155724;
	padding: 10px;
	border-radius: 5px;
	/*margin-top: 10px;*/
	text-align: center;
	font-weight: bold;
}
</style>
</head>

<body>

	<%@ include file="admindash.html"%>

	<%
	Integer added = (Integer) request.getAttribute("added");

	if (added == null) {

	} else if (added != null && added == 1) {
	%>
	<div class="custom-success-message">
		<h2>Restaurant added successfully</h2>
	</div>
	<%
	} else {
	%>
	<div class="custom-error-message1">
		<h2>Restaurant not added successfully</h2>
	</div>
	<%
	}
	%>

	<%
	Integer deleted = (Integer) request.getAttribute("deleted");
	if (deleted == null) {

	} else if (deleted != null && deleted == 1) {
	%>
	<div class="custom-success-message">
		<h2>Restaurant Deleted successfully</h2>
	</div>
	<%
	} else {
	%>
	<div class="custom-error-message1">
		<h2>Restaurant not Deleted successfully</h2>
	</div>
	<%
	}
	%>
	
		<%
	Integer updated = (Integer) request.getAttribute("updated");
	if (updated == null) {

	} else if (updated != null && updated == 1) {
	%>
	<div class="custom-success-message">
		<h2>Restaurant Updated successfully</h2>
	</div>
	<%
	} else {
	%>
	<div class="custom-error-message1">
		<h2>Restaurant not Updated successfully</h2>
	</div>
	<%
	}
	%>

	<br>
	<div style="padding-left: 300px">
		<a href="addrestaurant.jsp"><button class="add-btn">ADD
				NEW</button></a>
		<h2>All Registered Restaurant</h2>
		<h2>manage all the registered restaurant</h2>
		<table>

			<thead>
				<tr>
					<th>RestaurantId</th>
					<th>Name</th>
					<th>Rating</th>
					<th>Address</th>
					<th>Cuisine Type</th>
					<th>ETA</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
			</thead>
			<tbody>
				<%
				List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("allrestaurant");
				if (restaurantList != null && !restaurantList.isEmpty()) {
					for (Restaurant restaurant : restaurantList) {
				%>
				<tr>
					<td><%=restaurant.getRestaurantId()%></td>
					<td><%=restaurant.getName()%></td>
					<td><%=restaurant.getRatings()%></td>
					<td><%=restaurant.getAddress()%></td>
					<td><%=restaurant.getCuisineType()%></td>
					<td><%=restaurant.getEta()%></td>
					<td><a
						href="EditRestaurant?restaurantId=<%=restaurant.getRestaurantId()%>"><i
							class='far fa-edit' style='font-size: 36px'></i></a></td>
					<td><a
						href="DeleteRestaurant?restaurantId=<%=restaurant.getRestaurantId()%>"><i
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


	<br>
	<br>
	<br>
	<br>


</body>

</html>
