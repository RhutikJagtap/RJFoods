<%@page import="com.rjfoods.model.Menu"%>
<%@page import="com.rjfoods.model.OrderItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order History</title>
<link
	href="https://fonts.googleapis.com/css2?family=Segoe+UI:wght@400;600&display=swap"
	rel="stylesheet">
<style>
/* General Body Styling */
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #fafafa;
	margin: 0;
	padding: 0;
	color: #333;
}

/* Container Styling */
.container {
	max-width: 900px;
	margin: 30px auto;
	padding: 30px;
	background-color: #ffffff;
	border-radius: 12px;
	box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
}

/* Heading Styling */
h1 {
	text-align: center;
	color: #2e3b4e;
	font-size: 28px;
	font-weight: 600;
	margin-bottom: 30px;
}

/* Order History Styling */
.order-header {
	display: grid;
	grid-template-columns: 2fr 1fr 1fr 1fr 1fr;
	gap: 20px;
	background-color: #f1f1f1;
	padding: 12px 15px;
	font-size: 18px;
	color: #495057;
	font-weight: bold;
	border-radius: 8px;
}

.order-item {
	display: grid;
	grid-template-columns: 2fr 1fr 1fr 1fr 1fr;
	gap: 20px;
	padding: 12px 15px;
	background-color: #ffffff;
	border-bottom: 1px solid #e0e0e0;
}

.order-item-image img {
	width: 50px;
	height: 50px;
	object-fit: cover;
	border-radius: 8px;
}

.order-item-name {
	font-size: 16px;
	color: #333;
}

.order-item-price, .order-item-quantity, .order-item-reorder {
	text-align: center;
	font-size: 16px;
	color: #666;
}

.order-item-reorder a {
	text-decoration: none;
}

.reorder-btn {
	background-color: #007bff;
	color: white;
	padding: 8px 16px;
	border-radius: 5px;
	font-size: 14px;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.reorder-btn:hover {
	background-color: #0056b3;
}

.no-order {
	text-align: center;
	margin-top: 30px;
	color: #f44336;
	font-size: 18px;
	font-weight: bold;
}

.explore-restaurants-btn {
	background-color: #007bff;
	color: white;
	padding: 12px 30px;
	border-radius: 5px;
	font-size: 16px;
	text-decoration: none;
	margin-top: 20px;
	display: inline-block;
}

.explore-restaurants-btn:hover {
	background-color: #0056b3;
}

/* Responsive Design */
@media ( max-width : 768px) {
	.order-header, .order-item {
		grid-template-columns: 1fr 1fr 1fr 1fr;
		gap: 15px;
	}
	.order-item-name, .order-item-price, .order-item-quantity,
		.order-item-reorder {
		text-align: left;
		font-size: 14px;
	}
	.order-item-image img {
		width: 40px;
		height: 40px;
	}
	.order-item-reorder {
		margin-top: 10px;
		text-align: center;
	}
}
</style>
</head>

<body>

	<%@ include file="without_searchbar_navbar.jsp"%>

	<div class="container">
		<h1>Your Order History</h1>

		<div class="order-history">
			<div class="order-header">
				<div>Item Name</div>
				<div>Item Image</div>
				<div>Price</div>
				<div>Quantity</div>
				<div>Actions</div>
			</div>

			<%
                List<OrderItem> allOrderItems = (List<OrderItem>) request.getAttribute("allOrderItems");
			
		
                if (allOrderItems != null && !allOrderItems.isEmpty()) {
                    for (OrderItem orderItem : allOrderItems) {
            %>

			<div class="order-item">
				<div class="order-item-name">
					<%= orderItem.getItemName() %>
				</div>
				<div class="order-item-image">
					<img src="<%= orderItem.getImagePath() %>" alt="<%= orderItem.getItemName() %>">
				</div>
				<div class="order-item-price">
					<%= orderItem.getPrice() %>
				</div>
				<div class="order-item-quantity">
					<%= orderItem.getQuantity() %>
				</div>
				<div class="order-item-reorder">
					<!--  <a
						href="callcart?itemId=<%= orderItem.getMenuId() %>&itemName=<%= orderItem.getItemName() %>&price=<%= orderItem.getPrice() %>&restaurantid=<%= orderItem.getRestaurantId() %>">
						<button class="reorder-btn">Re-Order</button>
					</a>-->
					
					  <a
						href="Cart?itemId=<%= orderItem.getMenuId()%>&quantity=<%=orderItem.getQuantity()%> ">
						<button class="reorder-btn">Re-Order</button>
					</a>
					
				</div>
			</div>

			<%
                    }
                } else {
                	 %>

			<div class="no-order">
				<p>It looks like you haven't ordered anything yet. Explore the
					restaurants and place your first order!</p>
				<a href="RestaurantServlet">
					<button class="explore-restaurants-btn">See Restaurants
						&#10140;</button>
				</a>
			</div>

			<% 
                }
            %>
		</div>
	</div>

</body>

</html>
