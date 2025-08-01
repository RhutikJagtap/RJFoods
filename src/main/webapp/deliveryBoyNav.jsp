<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Delivery Boy Dashboard</title>
	<style type="text/css">
		* {
			box-sizing: border-box;
		}

		body {
			margin: 0;
			font-family: Arial, sans-serif;
			font-size: 16px;
			line-height: 1.5;
		}
		
		.dash{
			position: sticky;
            top: 0;
		}

		nav {
			background-color: #0e0a0ae2;
			color: #fff;
			display: flex;
			justify-content: space-between;
			align-items: center;
			padding: 10px;
		}

		nav ul {
			list-style: none;
			margin: 0;
			padding: 0;
			display: flex;
		}

		nav ul li {
			margin-right: 20px;
		}

		nav ul li:last-child {
			margin-right: 0;
		}

		nav a {
			color: #fff;
			text-decoration: none;
			font-weight: bold;
		}

		nav a:hover {
			color: #ccc;
		}

		h1 {
			text-align: center;
			margin-top: 50px;
		}

		p {
			text-align: center;
			font-size: 18px;
		}

		.sidebar {
			background-color: #bebcbc;
			height: 100%;
			position: fixed;
			left: 0;
			top: 39;
			width: 250px;
		}

		.sidebar ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}

		.sidebar ul li {
			border-bottom: 1px solid #ccc;
			position: relative;
		}

		.sidebar ul li:last-child {
			border-bottom: none;
		}

		.sidebar ul li a {
			color: #333;
			display: block;
			padding: 12px 16px;
			text-decoration: none;
		}

		.sidebar ul li a:hover {
			background-color: #ddd;
		}

		.sidebar ul li ul {
			display: none;
			position: absolute;
			left: 200px;
			top: 0;
			background-color: #fff;
			width: 200px;
			z-index: 1;
		}

		.sidebar ul li:hover ul {
			display: block;
		}

		.sidebar ul li ul li a {
			color: #333;
			display: block;
			padding: 8px 16px;
			text-decoration: none;
		}

		.sidebar ul li ul li a:hover {
			background-color: #ddd;
		}

		.image-container {
			text-align: center;
			margin-top: 50px;
		}

		.heading {
			font-size: 36px;
			color: #333;
		}

		li {
			display: block;
			margin-bottom: 10px;
			font-weight: bold;
			color: #333;
			text-transform: uppercase;
			font-size: 15px;
			text-align: left;
		}

		h3 {
			display: block;
			margin-bottom: 10px;
			font-weight: bold;
			color: #fff;
			text-transform: uppercase;
			font-size: 20px;
			text-align: left;
		}
	</style>
</head>

<body>
	<div class="dash">
		<nav>
			<h3>Delivery Boy</h3>
			<ul>
				<li style="margin-top: 10px;"><a href="http://localhost:8080/RJFoods/">Logout</a></li>
				<li style="margin-left: 80px" id="google_translate_element"></li>
			</ul>
		</nav>

	</div>
	<div class="sidebar">
		<ul>
			<li><a href="#">View Order</a>
			</li>

			<li><a href="UpdateOrderStatus">Update Order status</a> <!--  -->

			</li>
			<li><a href="#">Feedback</a>
				<ul>
					<li><a href="#"> Feedback </a></li>
				</ul>
			</li>

		</ul>
	</div>


</body>

</html>