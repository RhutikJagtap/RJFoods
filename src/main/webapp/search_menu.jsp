<%@page import="com.rjfoods.model.Restaurant"%>
<%@page import="com.rjfoods.model.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
body {
	font-family: Arial, sans-serif;
}

/* Menu Card Section */
.card-section {
	margin-left: 150px;
	margin-right: 80px;
}

h2 {
	text-align: center;
	margin-bottom: 30px;
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	gap: 5px;
}

/* Card Styling */
.card {
	border: 1px solid rgb(30, 29, 27);
	background-color: rgb(250, 248, 247);
	width: 300px; /* Keeping original width */
	height: 400px; /* Increased to allow space for content */
	border-radius: 1rem;
	margin-left: 1.5rem;
	margin-top: 2rem;
	padding: 15px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	transition: all 0.3s ease;
}

.card:hover {
	background-color: #dfd7d7;
	box-shadow: 10px 10px 20px rgb(9, 5, 5);
}

/* Card Image */
.card-img {
	max-width: 150px;
	height: auto; /*120 Fixed image height to maintain layout */
	object-fit: cover; /* Ensures image fits well */
	border-radius: 1rem;
	margin-bottom: 15px;
}

/* Text and Info */
.card-title {
	font-weight: 600;
	margin-bottom: 10px;
	font-size: 1.2rem;
}

.card-info {
	font-size: 1rem;
	color: #555;
	margin-bottom: 10px;
	flex-grow: 1; /* Makes sure the text area doesn't overflow */
}

/* Price and Rating in the same line */
.price-rating {
	display: flex; /* Align items in a row */
	justify-content: space-between; /* Space them apart */
	margin-bottom: 15px; /* Add space between the quantity input */
}

.card span {
	display: block;
	margin-bottom: 8px;
}

.card button {
	width: 40%;
	padding: 5px;
	background-color: #28a745;
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 1rem;
	cursor: pointer;
	transition: background-color 0.3s;
}

.card button:hover {
	background-color: #218838;
}

#quantityBox {
	width: 70px
}
</style>
</head>

<body>

	<jsp:include page="menu_nav.jsp" />

	<br>
	<br>
	<br>
	<br>
	<br>

	<%
	Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
	%>

	<div>
		<h2 style="text-align: center">
			Welcome to <span style="color: red;"><%=restaurant.getName()%></span>
			Restaurant
		</h2>

	</div>

	<%
	List<Menu> searchMenu = (List<Menu>) session.getAttribute("searchMenu");
	%>
	<div class="card-section">
		<h3>Searched menu</h3>
		<%
		if (searchMenu != null && !(searchMenu.isEmpty())) {
		%>
		<div class="card-container">

			<%
			for (Menu menu : searchMenu) {
			%>
			<div class="card">
				<img src="<%=menu.getImagePath()%>" alt="Image not found"
					class="card-img">
				<p class="card-title"><%=menu.getName()%></p>
				<p class="card-info">A delicious mix of rice and vegetables,
					perfect for lunch or dinner.</p>
				<!-- Price and Rating in the same line -->
				<div class="price-rating">
					<span>Price: <%=menu.getPrice()%></span> <span>&#9733;
						Rating: <%=menu.getRatings()%></span>
				</div>
				<span>Quantity</span>

				<form action="Cart" method="post">
					<input type="number" name="quantity" min="1" max="10" value="1"
						id="quantityBox"> <input type="hidden" name="itemId"
						value="<%=menu.getMenuId()%>"> <input type="hidden"
						name="restaurantid" value="<%=menu.getRestaurantId()%>"> <br>
					<br>
					<button type="submit">ADD</button>
				</form>

			</div>
			<%
			}
			%>
		</div>
		<%
		} else {
		%>

		<div>
			<h2>Search Menu Not found</h2>
		</div>

		<%
		}
		%>
	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

</body>
</html>
