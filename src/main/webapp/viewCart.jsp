<%@page import="com.rjfoods.model.CartItem"%>
<%@page import="com.rjfoods.model.Menu"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cart</title>
<link rel="icon" href="images/icons/empty_cart.png">
<!-- Add your CSS styles here -->
<style>
/* General body styling */
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

/* Container for the whole page */
.container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
}

/* Header Styling */
h4 {
	text-align: center;
	color: #333;
	font-size: 24px;
	margin-bottom: 30px;
}

/* Cart item card styling */
.cart-item-card {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-bottom: 20px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
}

/* Cart item card details */
.cart-item-card .details {
	flex: 1;
	padding-right: 20px;
}

.cart-item-card p {
	font-size: 16px;
	color: #555;
	margin: 5px 0;
}

.cart-item-card p span {
	font-weight: bold;
}

/* Styling for the cart image */
.cart-item-card img {
	max-width: 150px;
	height: auto;
	border-radius: 5px;
	margin-left: 20px;
}

/* Form and button styling */
.cart-item-card form {
	margin: 10px 0;
}

.cart-item-card input[type="number"] {
	width: 60px;
	padding: 5px;
	font-size: 14px;
	margin-right: 10px;
}

.cart-item-card button {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 8px 15px;
	font-size: 14px;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.cart-item-card button:hover {
	background-color: #0056b3;
}

/* Action buttons (Update/Delete) */
.cart-item-card .button-container {
	margin-top: 15px;
	display: flex;
	gap: 10px;
}

/* Styling for "Proceed to Checkout" and "Add More Items" */
.action-buttons {
	display: flex;
	justify-content: space-between;
	margin-top: 20px;
}

.action-buttons a, .action-buttons button {
	text-decoration: none;
	background-color: #28a745;
	color: white;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.action-buttons a:hover, .action-buttons button:hover {
	background-color: #218838;
}

/* Empty cart message */
.empty-cart {
	text-align: center;
	font-size: 18px;
	color: black;
	margin-top: 50px;
}
</style>
</head>
<body>

	<jsp:include page="without_searchbar_navbar.jsp" />

	<br>
	<br>


	<div class="container">
		<h4>Cart Items</h4>


		<% 
    // Retrieve the cart list from the session
    Map<Integer, CartItem> cartList = (Map<Integer, CartItem>) session.getAttribute("cartList");

    // Check if the cart list is not null and contains items
    if (cartList != null && !cartList.isEmpty()) {
        // Iterate over the map entries
        for (Map.Entry<Integer, CartItem> entry : cartList.entrySet()) {
            Integer itemId = entry.getKey();
            CartItem cartItem = entry.getValue();
    %>

		<!-- Cart item card -->
		<div class="cart-item-card">
			<!-- Cart item details -->
			<div class="details">

				<p>
					<span>Item Name:</span>
					<%= cartItem.getName() %></p>
				<p>
					<span>Quantity:</span>
					<%= cartItem.getQuantity() %></p>
				<p>
					<span>Price:</span>&#8377;
					<%= cartItem.getPrice() %></p>

				<!-- Update and Delete buttons -->
				<div class="button-container">
					<!-- Update Form -->
					<form method="post" action="UpdateCart">
						<input type="hidden" name="itemId" value="<%= itemId %>">
						<input type="number" name="quantity"
							value="<%= cartItem.getQuantity() %>" min="1">
						<button type="submit" name="action" value="update">Update</button>
					</form>

					<!-- Delete Form -->
					<form method="post" action="DeleteCart">
						<input type="hidden" name="itemId" value="<%= itemId %>">
						<button type="submit" name="action" value="delete">Delete</button>
					</form>

				</div>
			</div>

			<!-- Cart item image on the right side -->
			<img src="<%= cartItem.getImagePath() %>" alt="Item Image">
		</div>

		<% 
        }
    } else {
    %>

		<p class="empty-cart">
			Your cart is empty. <img style="width: 100px; height: 100px" alt=""
				src="images/icons/empty_cart.png">
		</p>

		<% 
    }
    %>
	</div>

</body>
</html>