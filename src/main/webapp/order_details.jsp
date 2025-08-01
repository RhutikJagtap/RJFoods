<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.rjfoods.model.Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order</title>
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

<h2>View Order</h2>

<div class="table-wrapper">
    <table>
        <tr>
            <th>order ID</th>
            <th>user Id</th>
            <th>total amount</th>
            <th>mode of payment</th>
            <th>status</th>
            <th>address</th>
        </tr>

        <%
            List<Order> orderList = (List<Order>) request.getAttribute("orderlist");
            if (orderList != null && !orderList.isEmpty()) {
                for (Order order : orderList) {
        %>
        <tr>
            <td><%= order.getOrderId()%></td>
            <td><%= order.getUserId()%></td>
            <td>₹<%= order.getTotalAmount() %></td>
            <td><%= order.getModeOfPayment()%></td>
            <td><%=order.getStatus() %></td>
            <td><%= order.getAddress() %></td>            
         </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">No Order  available.</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
