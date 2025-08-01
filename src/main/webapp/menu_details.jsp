<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.rjfoods.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

<!-- Add Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style>
/* Adjusted table to fit beside the sidebar */
body {
    background-color: #f5f5f5;
    font-family: Arial, sans-serif;
}

h2 {
    margin-left: 270px;
    margin-top: 30px;
    color: #333;
    text-align: left;
}

.table-wrapper {
    margin-left: 270px; /* space for sidebar */
    padding: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: center;
}

th {
    background-color: #fb6d3e;
    color: white;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f1f1f1;
}

img {
    border-radius: 5px;
}
</style>
</head>
<body>

<%@ include file="restaurantOwnerNav.jsp" %>

<h2>Menu Items</h2>

<div class="table-wrapper">
    <table>
        <tr>
            <th>Menu ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Image</th>
            <th>Available</th>
            <th>Ratings</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <%
            List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menu : menuList) {
        %>
        <tr>
            <td><%= menu.getMenuId() %></td>
            <td><%= menu.getName() %></td>
            <td>₹<%= menu.getPrice() %></td>
            <td><%= menu.getDescription() %></td>
            <td><img src="<%= menu.getImagePath() %>" alt="Image" width="80" height="60"></td>
            <td><%= menu.isAvailable() ? "Yes" : "No" %></td>
            <td><%= menu.getRatings() %> ⭐</td>
            <td><a
						href="EditMenu?menuId=<%=menu.getMenuId()%>"><i
							class='far fa-edit' style='font-size: 36px'></i></a></td>
					<td><a
						href="DeleteMenu?menuId=<%=menu.getMenuId()%>"><i
							class='far fa-trash-alt' style='font-size: 36px'></i></a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">No menu items available.</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
