<%@page import="com.rjfoods.model.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Restaurant</title>

<style type="text/css">
/*Signup form CSS */
#signupform {
	display: block;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
	max-width: 550px;
	margin: 0 auto;
	text-align: center;
}

#signupform h2 {
	margin: 0;
	color: rgb(63, 169, 17);
}

#signupform label {
	display: block;
	text-align: left;
	font-size: 17px;
	color: black;
	font-weight: bold;
	cursor: pointer;
}

#signupform input[type=text], #signupform input[type=email], #signupform input[type=password]
	{
	padding: 15px;
	border-radius: 5px;
	/* margin-bottom: 10px; */
	width: 100%;
	height: 40px;
	box-sizing: border-box;
	/* background-color: #e2c9c9; */
	color: #181818;
	font-size: 14px;
	font-weight: bold;
	text-align: left;
	outline: none;
	border: 0.5px solid rgb(37, 36, 36);
}

#signupform input::placeholder {
	color: rgb(26, 25, 25);
}

#signupform input[type=submit] {
	background-color: #4afb3e;
	width: 130px;
	height: 40px;
	font-size: 15px;
	font-weight: bold;
	border-radius: 10px;
	cursor: pointer;
}

#signupform input[type=submit]:hover {
	background-color: rgb(237, 107, 51);
	transform: translateY(-2px);
	box-shadow: 0px 5px 10px #888;
}

#signupform input[type=text]:focus, #signupform input[type=email]:focus,
	#signupform input[type=password]:focus {
	box-shadow: 0px 5px 15px #900;
	border: 2px solid black;
	/*background-color: hsl(53, 100%, 82%);*/
	color: #0e0e0e;
}
</style>

</head>
<body>

	<%@ include file="admindash.html"%>

	<br>


	<%Restaurant restaurant= (Restaurant)request.getAttribute("restaurant");%>

	<form action="UpdateRestaurant" method="post"
		onsubmit="return validate()" id="signupform">

		<h2>Edit Restaurant</h2>
		<input type="hidden" name="restaurantId" value="<%=restaurant.getRestaurantId()%>">

		<label for="restaurantname">Restaurant Name : </label>
		 <input type="text" id="restaurantname" placeholder="Enter the Name" name="restaurantname" value="<%=restaurant.getName()%>">
		  <br> <br>
		   <label for="rating">Rating : </label>
		    <input type="text" id="rating" placeholder="Enter the rating" name="rating"
			value="<%=restaurant.getRatings()%>"> <br> <br>
			
			 <label for="eta">ETA : </label>
			  <input type="text" id="eta" placeholder="Enter the eta" name="eta"
			value="<%=restaurant.getEta()%>"> <br> <br>
			
			 <label for="cuisinetype">Cuisine Type : </label>
			  <input type="text" id="cuisineType" placeholder="Enter the cuisinetype"
			name="cuisinetype" value="<%=restaurant.getCuisineType()%>" required>
		<br> <br>
		
		 <label for="address">Address : </label>
		  <input
			type="text" id="address" placeholder="Enter the address"
			name="address" value="<%=restaurant.getAddress()%>"> <br>
		<br>
		
		 <label for="isActive">Is Active </label> <input type="text"
			id="isActive" placeholder="Enter the isActive" name="isActive"
			value="<%=restaurant.isActive()%>" required> <br> <br>

		<label for="image">Image : </label> <input type="file" id="image"
			name="imagePath"> <br> <br>
		<!-- An element to toggle between password visibility -->
		<br> <input type="checkbox" required>Accept the terms and
		condition <br> <br> <input type="submit" value="Edit">
		<br>

	</form>



</body>
</html>