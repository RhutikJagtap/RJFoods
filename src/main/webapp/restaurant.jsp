<%@page import="com.rjfoods.model.User"%>
<%@page import="com.rjfoods.model.Restaurant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="icon" href="images/icons/logo.jpg">


<style type="text/css">
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
	border-radius: 20px;
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
	border-top-left-radius: 20px;
	border-top-right-radius: 20px;
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
	color: white; /* Optional: text color */
	text-align: center; /* Ensure both texts are centered */
}

.footer-text {
	font-size: 30px; /* Adjust font size for @RJ text */
	margin-bottom: 5px; /* Space between @RJ and copyright */
}

.copyright-text {
	font-size: 14px; /* Adjust font size for copyright text */
}

.custom-error-message2 {
	background-color: #d4edda;
	color: #155724;
	padding: 10px;
	border-radius: 5px;
	text-align: center;
	font-weight: bold;
}

.wrapper {
  border: 2px solid white;
  position: fixed; /* Fixed position to stay on screen */
  bottom: 20px;
  left: 70%; /* Center horizontally */
  max-width: 365px;
  background: #252627;
  padding: 25px 25px 30px 25px;
  border-radius: 15px;
  box-shadow: 1px 7px 14px -5px rgba(0,0,0,0.15);
  text-align: center;
  opacity: 1; /* Always visible */
  pointer-events: auto; /* Interactions allowed */
  z-index: 9999; /* Ensure it's above other content */
}

::selection {
  color: #fff;
  background: #FCBA7F;
}

.wrapper img {
  max-width: 90px;
}

.content header {
  color: white;
  font-size: 25px;
  font-weight: 600;
}

.content {
  margin-top: 10px;
}

.content p {
  color: white;
  margin: 5px 0 20px 0;
}

.content .buttons {
  display: flex;
  align-items: center;
  justify-content: center;
}

.buttons button {
  padding: 10px 20px;
  border: none;
  outline: none;
  color: #fff;
  font-size: 16px;
  font-weight: 500;
  border-radius: 5px;
  background: #FCBA7F;
  cursor: pointer;
  transition: all 0.3s ease;
}

.buttons button:hover {
  transform: scale(0.97);
}

.buttons .item {
  margin: 0 10px;
}

.buttons a {
  color: #FCBA7F;
}



</style>
</head>


<body>

	<jsp:include page="loginnav.html" />
	<br>
	<br>
	
	<%-- Show the cookie consent box only if the cookie is not set --%>
<%
    String cookieConsent = request.getParameter("cookieConsent");
    if (cookieConsent == null || !cookieConsent.equals("true")) {
%>
    <div class="wrapper" id="cookieBanner">
    <img src="data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='96' height='96' viewBox='0 0 96 96'%3E%3Cpath d='M35 45.5a7.5 7.5 0 11-15 0 7.5 7.5 0 0115 0zM63.5 63a7.5 7.5 0 100-15 7.5 7.5 0 000 15zm-19 19a7.5 7.5 0 100-15 7.5 7.5 0 000 15z' opacity='.2' fill='%23379fef'%3E%3C/path%3E%3Cpath d='M56.99 2.53a23.1 23.1 0 0114.66 6.15h.01l.01.02c.57.55.61 1.27.5 1.74v.07a10.95 10.95 0 01-3.07 4.77 9 9 0 01-6.9 2.5 10.34 10.34 0 01-9.72-10.44v-.08a10 10 0 011.03-3.74l.01-.03.02-.02c.28-.5.82-.92 1.52-.95.63-.02 1.27-.02 1.93.01zm12.04 7.83a20.1 20.1 0 00-12.2-4.83l-.92-.03c-.23.6-.38 1.25-.43 1.94a7.34 7.34 0 006.95 7.34 6 6 0 004.64-1.7c.94-.88 1.6-1.9 1.96-2.72zm15.3 8.76a6.84 6.84 0 00-5.09-.24 7.9 7.9 0 00-3.28 2.05 1.8 1.8 0 00-.3 1.95l.02.02v.02a15.16 15.16 0 008.74 7.47c.64.23 1.32.08 1.8-.33a6.63 6.63 0 001.63-1.97l.01-.03.01-.03c1.67-3.5-.12-7.32-3.54-8.91zm-5.5 3.28c.36-.25.82-.5 1.35-.67.92-.3 1.92-.35 2.89.1 2.14 1 2.92 3.14 2.11 4.88-.12.21-.26.41-.43.6l-.26-.1a12.29 12.29 0 01-5.66-4.81zM32 24a2 2 0 11-4 0 2 2 0 014 0zm12 21a2 2 0 11-4 0 2 2 0 014 0zm36 4a2 2 0 11-4 0 2 2 0 014 0zm-7 21a2 2 0 11-4 0 2 2 0 014 0zM59 81a2 2 0 11-4 0 2 2 0 014 0zM22 63a2 2 0 11-4 0 2 2 0 014 0zm27 7a9 9 0 11-18 0 9 9 0 0118 0zm-3 0a6 6 0 10-12 0 6 6 0 0012 0zM33 41a9 9 0 11-18 0 9 9 0 0118 0zm-15 0a6 6 0 1012 0 6 6 0 00-12 0zm50 11a9 9 0 11-18 0 9 9 0 0118 0zm-3 0a6 6 0 10-12 0 6 6 0 0012 0zM44.08 4.24c.31.48.33 1.09.05 1.58a17.46 17.46 0 00-2.36 8.8c0 9.55 7.58 17.24 16.85 17.24 2.97 0 5.75-.78 8.16-2.15a1.5 1.5 0 012.1.66 12.08 12.08 0 0011 6.74 12.4 12.4 0 007.85-2.75 1.5 1.5 0 012.38.74A45.76 45.76 0 0192 48.16c0 24.77-19.67 44.9-44 44.9S4 72.93 4 48.16C4 25.23 20.84 6.28 42.64 3.58a1.5 1.5 0 011.44.66zM40.22 7C21.32 10.71 7 27.7 7 48.16c0 23.17 18.39 41.9 41 41.9s41-18.73 41-41.9c0-3.52-.42-6.93-1.22-10.2a15.5 15.5 0 01-7.9 2.15c-5.5 0-10.36-2.83-12.97-7.1a19.46 19.46 0 01-8.28 1.85c-11 0-19.86-9.1-19.86-20.24 0-2.7.52-5.26 1.45-7.62zM92 91a2 2 0 100-4 2 2 0 000 4zM7 8.5a2.5 2.5 0 11-5 0 2.5 2.5 0 015 0zM82.5 90a1.5 1.5 0 100-3 1.5 1.5 0 000 3zm9.5-7.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM13.5 8a1.5 1.5 0 100-3 1.5 1.5 0 000 3zM80 14.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM53.5 20a1.5 1.5 0 100-3 1.5 1.5 0 000 3z' fill='%23379fef'%3E%3C/path%3E%3C/svg%3E" alt="Image not found">
    <div class="content">
        <header>Cookies Consent</header>
        <p>This website uses cookies to ensure you get the best experience on our website.</p>
        <div class="buttons">
            <form action="CookieServlet" method="POST">
                <button class="item" type="submit" id="acceptBtn">I understand</button>
            </form>
            <a href="#" class="item">Learn more</a>
        </div>
    </div>
</div>

<% 
    }
%>

	<%
	String successmsg = (String) request.getAttribute("successmsg");
	if (successmsg != null) {
	%>
	<div class="custom-error-message2">
		<%=successmsg%>
	</div>
	<%
	}
	%>

	<!-- get UserName for welcome message -->

	<%
	User user = (User) session.getAttribute("user");
	%>

	<div class="banner">

		<span class="leftslogan"> <img width="70px" alt=""
			src="https://cdn.pixabay.com/photo/2021/05/25/02/03/restaurant-6281067_1280.png">
			<span
			style="padding-left: 50px; font-weight: bold; color: white; font-size: 30px">
				Welcome <span style="color: red"><%=user.getName()%></span>
		</span>
			<h2>RJ Foods</h2>
			<h2 style="padding-left: 40px">is waiting</h2>

			<h2 style="padding-left: 60px">for</h2>
			<h2 style="padding-left: 80px">you.....</h2>


		</span> <span class="middle-content"> <span
			style="font-size: 50px; color: white;">RJ </span> <span><img
				style="width: 200px" alt="" src="images/icons/banner.png"></span> <span
			style="font-size: 50px; color: white;">Foods</span>
		</span> <span class="rightslogan">
			<h2>From</h2>
			<h2 style="padding-right: 80px">Kitchen</h2>

			<h2 style="padding-left: 50px">TO</h2>
			<h2 style="padding-left: 70px">Home !</h2> <img alt="" src="">

		</span>
	</div>

	<br>
	<br>

	<!-- top restaurant -->

	<%
	List<Restaurant> list1 = (List<Restaurant>) request.getAttribute("toprestaurant");
	%>

	<div class="card-section">
		<h2>Top Restaurant</h2>
		<%
		if (list1 != null && !(list1.isEmpty())) {
		%>
		<div class="card-container">
			<%
			for (Restaurant toprestaurant : list1) {
			%>
			<div class="card">

				<a href="Menu?restaurantId=<%=toprestaurant.getRestaurantId()%>"><img
					src="<%=toprestaurant.getImagePath()%>" alt="" class="card-img"></a>
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
			<h2>No Top Restaurant found</h2>
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

				<a href="Menu?restaurantId=<%=restaurant.getRestaurantId()%>"><img
					src="<%=restaurant.getImagePath()%>" alt="" class="card-img"></a>
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