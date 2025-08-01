<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Delivery</title>
<link rel="icon" href="images/icons/success.png">

<style type="text/css">
.msg {
	margin-left: 470px;
	font-weight: bold;
	font-size: 30px;
}
</style>

</head>
<body>
	<%@ include file="without_searchbar_navbar.jsp"%>

	<br>
	<br>

	<div class="container">
		<h2></h2>
		<div class="msg">
			<span style="color: red">Chill ,</span> <span style="color: green">Relax
			</span> <br> <span>Food is On Your Way.....</span>
		</div>
		<!--   to scrollamount is use to control speed -->
		<marquee behavior="" direction="right" scrollamount="20">
			<img alt="" src="images/giphy.gif">
		</marquee>
	</div>

</body>
</html>
