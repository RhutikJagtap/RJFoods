<%@page import="com.rjfoods.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Confirmation</title>
<link rel="icon" href="images/icons/order_confirm.png">

<style>
/* General Body Styling */
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

/* Container for the order details */
.container {
	max-width: 800px;
	margin: 30px auto;
	padding: 20px;
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
	font-size: 24px;
	margin-bottom: 20px;
}

h2 {
	color: #444;
	font-size: 20px;
}

.order-details, .total-price {
	margin-top: 20px;
}

.order-details table, .total-price table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

.order-details th, .total-price th {
	text-align: left;
	background-color: #f1f1f1;
	padding: 8px;
}

.order-details td, .total-price td {
	padding: 8px;
	border-bottom: 1px solid #ddd;
}

.total-price {
	font-size: 18px;
	font-weight: bold;
	margin-top: 20px;
	color: #333;
}

.confirm-button {
	display: inline-block;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	font-size: 16px;
	text-align: center;
	border-radius: 5px;
	text-decoration: none;
	margin-top: 20px;
}

.confirm-button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<jsp:include page="without_searchbar_navbar.jsp" />
	<br>
	<br>



	<div class="container">
		<h1>Thank You For Your Order!</h1>




		<div class="order-details">
			<h2>Order Details:</h2>
			<table>
				<tr>
					<th>Item Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Amount</th>
				</tr>

				<!-- Example row, replace with dynamic content from session or database -->
				<%
				double totalAmount = 0.0;

				// Retrieve the cart list from the session
				Map<Integer, CartItem> cartList = (Map<Integer, CartItem>) session.getAttribute("cartList");

				// Check if the cart list is not null and contains items
				if (cartList != null && !cartList.isEmpty()) {
					// Iterate over the map entries
					for (Map.Entry<Integer, CartItem> entry : cartList.entrySet()) {
						Integer itemId = entry.getKey();
						CartItem cartItem = entry.getValue();

						double price = cartItem.getPrice();
						int quantity = cartItem.getQuantity();

						double totalCostOfItems = price * quantity;
						totalAmount = totalAmount + totalCostOfItems;
				%>
				<tr>
					<td><%=cartItem.getName()%></td>
					<td><%=cartItem.getPrice()%></td>
					<td><%=cartItem.getQuantity()%></td>
					<td><%=totalCostOfItems%></td>
				</tr>

				<%
				}
				%>
			</table>
		</div>


		<div class="total-price">
			<h2>Total Amount:</h2>
			<table>
				<tr>
					<td><strong>Total Amount</strong></td>
					<td><strong><%=totalAmount%></strong></td>
				</tr>
			</table>
		</div>

		<!-- Confirmation Button -->
		<a href="Success" class="confirm-button">Confirm Order</a>
	</div>

	<%
	} else {
	%>

	<p class="empty-cart">Your cart is empty.</p>

	<%
	}
	%>
</body>
</html>



