<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Restaurant</title>
<style type="text/css">
#restaurantForm {
    background-color: #f9f9f9;  /* Lighter background */
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.1);  /* Slightly softer shadow */
    max-width: 600px;  /* Increased width */
    margin: 0 auto;
    text-align: center;
}

h2 {
    margin: 0;
    color: #ff7f50;  /* Soft orange */
}

#restaurantForm label {
    display: block;
    text-align: left;
    font-size: 17px;
    color: #333;  /* Darker text color */
    font-weight: bold;
    cursor: pointer;
    text-transform: capitalize;
}

#restaurantForm input[type=text], 
#restaurantForm input[type=number],
#restaurantForm input[type=password] {
    padding: 14px;
    border-radius: 6px;
    width: 100%;
    height: 45px;  /* Slightly taller input fields */
    box-sizing: border-box;
    font-size: 15px;  /* Larger text size */
    font-weight: 500;
    text-align: left;
    outline: none;
    border: 1px solid #ddd;  /* Lighter border */
    margin-bottom: 12px;  /* Increased space between inputs */
}

#restaurantForm input::placeholder {
    color: #aaa;  /* Softer placeholder color */
}

#restaurantForm input[type=submit] {
    background-color: #ff7f50;  /* Matching submit button color */
    width: 140px;  /* Slightly wider button */
    height: 45px;  /* Taller button */
    font-size: 16px;  /* Larger font size */
    font-weight: bold;
    border-radius: 8px;
    cursor: pointer;
}

#restaurantForm input[type=submit]:hover {
    background-color: #28c76f;
    transform: translateY(-2px);
    box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
    color: white;
}

#restaurantForm input[type=text]:focus, 
#restaurantForm input[type=password]:focus,
#restaurantForm select:focus {
    background-color: #fff8f7;  /* Soft background on focus */
    color: #333;
    border-color: #ff7f50;  /* Highlight border color */
}

#restaurantForm select {
    padding: 12px;
    width: 100%;
    height: 45px;
    border-radius: 6px;
    font-size: 15px;
    font-weight: 500;
    border: 1px solid #ddd;
    box-sizing: border-box;
    margin-bottom: 12px;
    outline: none;
    background-color: white;
    color: #333;
    appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    background-image: url("data:image/svg+xml;charset=US-ASCII,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='%23666'%3E%3Cpath d='M4 6l4 4 4-4H4z'/%3E%3C/svg%3E");
    background-repeat: no-repeat;
    background-position: right 12px center;
    background-size: 12px;
}

.star-mark {
    color: #f44336;  /* Red star color */
    font-family: 'Arial', sans-serif;
}

</style>
</head>

<body>

	<%@ include file="admindash.html"%>

	<br>
	<br>
	
	


	<form action="AddRestaurant" method="post" id="restaurantForm">
		<h2>Add New Restaurant</h2>

		<!-- Hidden field for restaurant ID if updating an existing restaurant -->
		 <label for="restaurantName">Restaurant Name: <span class="star-mark">*</span></label>
		<input type="text" id="restaurantName" name="restaurantName" placeholder="Enter restaurant name"> <br> <br>
		
		 <label for="address">Address: <span class="star-mark">*</span></label>
		  <input type="text" id="address" name="address" placeholder="Enter restaurant address"> <br> <br>
		  
		  <label for="cuisineType">Cuisine Type: <span class="star-mark">*</span></label>
		  <input type="text" id="cuisineType" name="cuisineType" placeholder="Enter Cuisine Type"> <br> <br>
		  
			 <label for="rating">Rating: <span class="star-mark">*</span></label> 
			 <select id="rating" name="rating" required>
			<option>Select Rating</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select> <br> <br>
		
		 <label for="status">Status: <span class="star-mark">*</span></label> 
		 <select id="status" name="status" required>
			<option>Select Status</option>
			<option value="Active">Active</option>
			<option value="Inactive">Inactive</option>
		</select> <br> <br>
		
		 <label for="eta">ETA (Estimated Time of Arrival): <span class="star-mark">*</span>
		</label> <input type="text" id="eta" name="eta" placeholder="Enter ETA (e.g., 30 mins)"><br><br>
		
		  <label for="restaurantimage">Restaurant Image: <span class="star-mark">*</span></label>
		  <input type="text" id="restaurantimage" name="restaurantimage" placeholder="Enter Restaurant Image Url"> <br> <br>
		  
		  
		 <input type="submit" value="ADD">
	</form>
	
	<br>
	<br>

</body>
</html>
