<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

.location-div .arrow-down {
	position: absolute;
	top: 50%;
	right: -6%;
	transform: translateY(-50%);
	font-size: 15px;
	color: #fc8019;
	font-weight: 700;
}

.location-div .right {
	position: relative;
}

.right .items {
	display: flex;
	align-items: center;
	padding-left: 350px;
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
	color: #3d4152;
	font-size: 16px;
	font-weight: 400;
}

.items .nav-item a span {
	padding-left: 11px;
}

/* Responsive Design */
@media ( max-width : 768px) {
	.nav {
		flex-direction: column;
		align-items: flex-start;
		padding: 10px 20px;
	}
	.right .items {
		flex-direction: column;
		align-items: flex-start;
		margin-top: 10px;
	}
	.right .items li {
		margin-right: 0;
		margin-bottom: 10px;
	}
	.location-div {
		margin-left: 0;
		margin-bottom: 10px;
	}
	.searchbar {
		width: 100%;
		margin-bottom: 10px;
	}
	button {
		margin-left: 0;
	}
}

@media ( max-width : 480px) {
	.nav .left .logo img {
		width: 60px;
		height: 40px;
	}
	.location-div {
		font-size: 12px;
	}
	.searchbar {
		width: 100%;
		font-size: 12px;
	}
	.right .items li {
		font-size: 14px;
	}
}
</style>
</head>

<body>
	<header class="navbar">

		<div class="nav">
			<div class="left">
				<a href="http://localhost:8080/RJFoods/RestaurantServlet"
					class="logo"> <img src="images/logo.jpg" alt="Logo">
				</a>
				<div class="location-div">
					<span class="other">Other </span> <span class="location">pune,
						maharashtra, India</span> </span>
				</div>

			</div>

			<div class="right">
				<ul class="items">


					<li>
						<div class="nav-item">
							<a href="logOutUser"><i class="fa fa-sign-out"
								style="font-size: 30px; color: red"></i> <span>Sign Out</span> </a>
						</div>
					</li>

					<li>
						<div class="nav-item">
							<a href="Profile"> <i class="fa fa-user-circle"
								style="font-size: 30px; color: red"></i> <span>Profile</span>
							</a>
						</div>
					</li>

<% Integer count= (Integer)request.getAttribute("countCartItems");%>

					<li>
						<div class="nav-item">
							<a href="viewcart"> <!-- <i class="fa fa-shopping-cart" style="font-size:36px"></i> -->
								<i class="fa fa-shopping-basket"
								style="font-size: 30px; color: red"></i> <span>Cart <%= count==null?0:count %></span>
							</a>
						</div>
					</li>

				</ul>

			</div>

		</div>


	</header>

	<br>
	<br>

</body>

</html>