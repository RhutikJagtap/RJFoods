<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Payment</title>
<link rel="icon" href="images/icons/debitcard.png">
<style>
/* General body styling */
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

/* Container for form elements */
.form-container {
	background-color: #ffffff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 400px;
}

/* Heading Styling */
h1 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
	font-size: 24px;
}

/* Form element styling */
label {
	font-size: 16px;
	color: #555;
	margin-bottom: 8px;
	display: block;
}

input[type="text"], select {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 16px;
}

input[type="text"]:focus, select:focus {
	outline: none;
	border-color: #4CAF50;
}

/* Button styling */
button {
	width: 100%;
	padding: 12px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: #45a049;
}

/* Styling for the "Confirm" button link */
a {
	text-decoration: none;
}
</style>
</head>
<body>

	<%@ include file="without_searchbar_navbar.jsp"%>


	<br>
	<br>

	<div>
		<img alt="" src="images/icons/payment_icon.png">
	</div>

	<div class="form-container">
		<h1>Order Payment</h1>

		<form action="OrderConfirm" method="post">
			<!-- Address Input -->
			<label for="addr">Address</label> <input type="text" id="addr"
				name="address" placeholder="Enter your delivery address" required>

			<!-- Payment Mode Selection -->
			<label for="payment-mode">Payment Mode</label> <select
				id="payment-mode" name="payment_mode" required>
				<option value="">Select Payment Mode</option>
				<option value="cash">cash on delivery</option>
				<option value="UPI">UPI</option>
				<option value="Debit">Debit Card</option>
				<option value="Credit">Credit Card</option>
			</select>

			<!-- Confirm Button -->
			<button type="submit">Confirm</button>
		</form>

	</div>


</body>
</html>