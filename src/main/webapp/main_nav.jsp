<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main nav</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="images/icons/logo.jpg">



<style>
* {
	font-family: cursive;
	margin: 0;
	padding: 0;
}

.navbar {
	box-shadow: 0 15px 40px -20px rgb(40 44 63/ 15%);
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	height: 80px;
	background-color: #fff;
	z-index: 1000;
	padding: 0px 0px;
	border: 1px solid black;
}

.navbar .nav {
	max-width: 1400px;
	margin-left: 90px;
	display: flex;
	position: relative;
	height: 80px;
	/* justify-content: space-between; */
}

.nav .left {
	display: flex;
	align-items: center;
}

.nav .left .logo {
	display: block;
	height: 49px;
	margin-right: 10px;
}

.nav .left .logo img {
	width: 80px;
	height: 60px;
}

.navbar .location-div {
	display: flex;
	position: relative;
	margin-bottom: -1px;
	height: 30px;
	cursor: pointer;
	align-items: center;
	margin-left: 30px;
	padding-right: 10px;
	font-size: 14px;
}

.location-div .other {
	font-weight: 500;
	color: #3d4152;
	float: left;
	padding-bottom: 2px;
	border-bottom: 2px solid #3d4152;
}

.location-div .location {
	display: block;
	font-weight: 300;
	padding-left: 5px;
	margin-left: 5px;
	color: #686b78;
}

.location-div .right {
	position: relative;
}

.right .items {
	display: flex;
	align-items: center;
}

.right .items li {
	list-style-type: none;
	margin-right: 36px;
	color: #3d4152;
	font-size: 16px;
	font-weight: 500;
}

.items .nav-item {
	display: flex;
	position: relative;
	align-items: center;
	padding-left: 28px;
	height: 80px;
	cursor: pointer;
}

.items .nav-item a {
	display: flex;
	align-items: center;
	text-decoration: none;
	color: black;
	font-size: 16px;
	font-weight: 400;
}

.items .nav-item a span {
	padding-left: 11px;
}

/* Styling the form */
.searchform {
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 20px;
}

/* Styling the search bar */
.searchbar {
	width: 300px;
	height: 18px;
	padding: 10px;
	border: 2px solid black;
	border-radius: 20px;
	font-size: 16px;
	outline: none;
	transition: all 0.3s ease;
}

.searchbar:focus {
	border-color: #007bff;
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

/* Styling the button */
.searchbtn {
	background-color: transparent;
	border: none;
	cursor: pointer;
	margin-left: -40px;
	/* Adjust button positioning */
	padding: 0;
	outline: none;
}

.searchbtn i {
	transition: transform 0.2s ease;
}

.searchbtn:hover i {
	transform: scale(1.2);
}
</style>

</head>

<body>
	<header class="navbar">

		<div class="nav">
			<div class="left">
				<a href="http://localhost:8080/RJFoods/" class="logo"> <img
					src="images/logo.jpg" alt="Logo">
				</a>
				<div class="location-div">
					<span class="other">Other </span> <span class="location">pune,
						maharashtra, India</span>

				</div>

			</div>

			<div class="right">
				<ul class="items">

					<li>
						<div class="nav-item">
							<span>
								<form action="SearchRestaurant" class="searchform" method="post">
									<input type="text" class="searchbar"
										placeholder="search restaurant here" name="query">
									<button class="searchbtn">
										<i class="fa fa-search" style="font-size: 30px; color: red"></i>
									</button>

								</form>
							</span> <span>Search</span>
						</div>
					</li>

					<li>
						<div class="nav-item">
							<a href="http://localhost:8080/RJFoods/"> <i
								class="fa fa-home" style="font-size: 30px; color: red"></i> <span>Home</span>
							</a>
						</div>
					</li>

					<li>
						<div class="nav-item">
							<a href="login.jsp"> <i class="fa fa-sign-in"
								style="font-size: 30px; color: red"></i> <span>Sign In</span>
							</a>
						</div>
					</li>


					<li>
						<div class="nav-item">
							<a href="view_cart_nav.jsp"> <!-- <i class="fa fa-shopping-cart" style="font-size:36px"></i> -->
								<i class="fa fa-shopping-basket"
								style="font-size: 30px; color: red"></i> <span>Cart</span>
							</a>
						</div>
					</li>

				</ul>

			</div>

		</div>


	</header>

	<br>



</body>
</html>