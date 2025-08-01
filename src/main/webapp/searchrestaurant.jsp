<%@page import="java.util.Iterator"%>
<%@page import="com.rjfoods.model.Restaurant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Restaurant</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="icon" href="images/icons/logo.jpg">


<style>
* {
	font-family: cursive;
	margin: 0;
	padding: 0;
}

.banner {
	border: 2px solid red;
	border-radius: 10px;
	margin-left: 110px;
	margin-right: 170px;
	height: 230px;
	display: flex; /* Using flexbox to align items horizontally */
	justify-content: space-between;
	/* To ensure space between left, middle, and right */
	align-items: center; /* Align items vertically at the center */
	background-color: #333; /*rgb(74, 74, 74);*/
}

.leftslogan {
	padding-left: 10px;
}

.leftslogan h2 {
	font-weight: 30px;
	line-height: 1.5;
	/* Adjust the line height to control vertical spacing */
	color: white;
}

.middle-content {
	display: flex;
	align-items: center; /* To align the text and image vertically */
}

.rightslogan {
	padding-right: 30px;
	color: white;
}

.rightslogan h2 {
	line-height: 1.5;
}

.middle-content img {
	margin-left: 10px; /* Adds space between "RJ Foods" and the image */
	margin-right: 10px; /* Adds space between image and "Foods" */
}

/* card css */
.card-section {
	margin-left: 80px;
	margin-right: 50px;
}

.card {
	border: 1px solid black;
	background-color: rgb(250, 248, 247);
	width: 350px;
	border-radius: 1rem;
	margin-left: 1.5rem;
	margin-top: 2rem;
}

.card-container {
	display: flex;
	flex-wrap: wrap;
}

.card-img {
	/* padding-left: 40px; */
	width: 100%;
	border-radius: 1rem;
}

.card-title {
	font-weight: 600;
	padding-left: 10px;
}

.card-info {
	font-size: 1rem;
	padding-left: 10px;
}

.card:hover {
	background-color: #dfd7d7;
	box-shadow: 10px 10px 20px rgb(9, 5, 5);
}

p {
	padding: 10px;
}

.footer {
	display: flex;
	flex-direction: column; /* Stack the text vertically */
	justify-content: center;
	align-items: center;
	height: 200px; /* Adjust height as needed */
	background-color: #333; /* Optional: background color */
	color: white;
	text-align: center; /* Ensure both texts are centered */
}

.footer-text {
	font-size: 30px; /* Adjust font size for @RJ text */
	margin-bottom: 5px; /* Space between @RJ and copyright */
}

.copyright-text {
	font-size: 14px; /* Adjust font size for copyright text */
}
</style>
</head>

<body>

	<%@ include file="main_nav.jsp"%>

	<br>
	<br>
	<br>
	<br>

	<div class="banner">
		<span class="leftslogan"> <img width="70px" alt="Image Not found"
			src="https://cdn.pixabay.com/photo/2021/05/25/02/03/restaurant-6281067_1280.png">
			<h2>What's</h2>
			<h2 style="padding-left: 40px">on</h2>

			<h2 style="padding-left: 60px">your</h2>
			<h2 style="padding-left: 80px">Mind ?</h2>


		</span> <span class="middle-content"> <span
			style="font-size: 50px; color: white;">RJ </span> <span><img
				style="width: 200px" alt="RJFOODS" src="images/icons/banner.png"></span> <span
			style="font-size: 50px; color: white;">Foods</span>
		</span> <span class="rightslogan">
			<h2>From</h2>
			<h2 style="padding-right: 80px">Kitchen</h2>

			<h2 style="padding-left: 50px">TO</h2>
			<h2 style="padding-left: 70px">Home !</h2> <img alt="" src="">

		</span>
	</div>



	<!-- Searched restaurant -->
	<%
	List<Restaurant> list1 = (List<Restaurant>) request.getAttribute("searchRestaurant");
	%>

	<div class="card-section">
		<h2>Searched Restaurant</h2>
		<%
		if (list1 != null && !(list1.isEmpty())) {
		%>
		<div class="card-container">
			<%
			for (Restaurant toprestaurant : list1) {
			%>
			<div class="card">

				<a href="login.jsp"><img src="<%=toprestaurant.getImagePath()%>"
					alt="Image Not Found" class="card-img"></a>
				<p class="card-title"><%=toprestaurant.getName()%></p>
				&nbsp;<span><i class="fas fa-star" style="color: gold;"></i>
					Rating <%=toprestaurant.getRatings()%> </span> &nbsp; &nbsp; &nbsp; <span><i
					class="far fa-clock" style="font-size: 20px; color: black;"></i>

					ETA <%=toprestaurant.getEta()%> </span> &nbsp;
				<p class="card-info">
					<i class="fas fa-utensils" style="font-size: 20px; color: #ff6347;"></i>
					Cuisine Type :
					<%=toprestaurant.getCuisineType()%></p>

				&nbsp; <span><i class='fas fa-map-marker-alt'
					style='font-size: 20px; color: red'></i> Address : <%=toprestaurant.getAddress()%></span>

			</div>
			<%
			}
			%>
		</div>
		<%
		} else {
		%>
		<div>
			<h2>Your search Restaurant is Not found</h2>
		</div>

		<%
		}
		%>
	</div>


	<br>
	<br>


	<!-- All restaurant -->

	<%
	List<Restaurant> list = (List<Restaurant>) request.getAttribute("restaurant");
	%>

	<div class="card-section">
		<h2>All Restaurant</h2>
		<%
		if (list != null && !(list.isEmpty())) {
		%>
		<div class="card-container">
			<%
			for (Restaurant restaurant : list) {
			%>
			<div class="card">

				<a href="login.jsp"><img src="<%=restaurant.getImagePath()%>"
					alt="Image Not found" class="card-img"></a>
				<p class="card-title"><%=restaurant.getName()%></p>
				&nbsp;<span><i class="fas fa-star" style="color: gold;"></i>
					Rating <%=restaurant.getRatings()%> </span> &nbsp; &nbsp; &nbsp; <span><i
					class="far fa-clock" style="font-size: 20px; color: black;"></i>

					ETA <%=restaurant.getEta()%> </span> &nbsp;
				<p class="card-info">
					<i class="fas fa-utensils" style="font-size: 20px; color: #ff6347;"></i>
					Cuisine Type :
					<%=restaurant.getCuisineType()%></p>

				&nbsp; <span><i class='fas fa-map-marker-alt'
					style='font-size: 20px; color: red'></i> Address : <%=restaurant.getAddress()%></span>

			</div>
			<%
			}
			%>
		</div>
		<%
		} else {
		%>
		<div>
			<h2>No Restaurant found</h2>
		</div>

		<%
		}
		%>
	</div>


	<br>
	<br>

	<!-- footer section -->
	<footer class="footer">
		<div class="footer-content">
			<p class="footer-text">Developed by @RJ</p>
			<p class="copyright-text">copyright © 2024 RJ foods</p>
			<p>All rights reserved</p>
		</div>
	</footer>




</body>
</html>