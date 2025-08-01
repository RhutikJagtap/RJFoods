<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Menu</title>
<style>
#menuForm {
    background-color: #f9f9f9;  /* Lighter background for a modern look */
    padding: 35px;
    border-radius: 12px;
    box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.1);  /* Softer shadow */
    max-width: 600px;  /* Increased width for more space */
    margin: 0 auto;
    text-align: left;
    font-family: 'Arial', sans-serif;
}

#menuForm h2 {
    text-align: center;
    color: #28a745;  /* Matching green theme */
    margin-bottom: 20px;
    font-size: 24px;
}

#menuForm label {
    font-size: 16px;
    color: #333;
    font-weight: bold;
    margin-bottom: 8px;
    display: block;
    text-align: left;
}

#menuForm input,
#menuForm textarea,
#menuForm select {
    width: 100%;
    padding: 12px;
    margin-bottom: 18px;  /* More spacing between fields */
    border-radius: 6px;
    border: 1px solid #ccc;
    font-size: 14px;
    box-sizing: border-box;
}

#menuForm input[type="text"],
#menuForm input[type="number"],
#menuForm input[type="url"],
#menuForm select {
    background-color: #fff;  /* Clean background */
}

#menuForm textarea {
    background-color: #fff;
    resize: vertical;  /* Allow vertical resize for the description */
}

#menuForm input:focus,
#menuForm textarea:focus,
#menuForm select:focus {
    border-color: #28a745;  /* Green focus border */
    background-color: #f0f8f3;  /* Slightly different background on focus */
    outline: none;
}

#menuForm input[type="submit"] {
    background-color: #28a745;  /* Green button */
    color: white;
    font-weight: bold;
    font-size: 16px;
    padding: 15px 25px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: all 0.3s ease;
    width: 100%;
}

#menuForm input[type="submit"]:hover {
    background-color: #218838;  /* Darker green on hover */
    box-shadow: 0px 6px 12px rgba(0, 0, 0, 0.1);
    transform: translateY(-2px);
}

.star-mark {
    color: red;  /* Red star mark */
}

#menuForm select {
    background-color: white;
    appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    background-image: url("data:image/svg+xml;charset=US-ASCII,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='%23666'%3E%3Cpath d='M4 6l4 4 4-4H4z'/%3E%3C/svg%3E");
    background-repeat: no-repeat;
    background-position: right 12px center;
    background-size: 12px;
}

#menuForm input::placeholder {
    color: #888;  /* Softer placeholder color */
}

@media (max-width: 768px) {
    #menuForm {
        padding: 25px;  /* Reduce padding for smaller screens */
        max-width: 90%;  /* Allow for responsiveness */
    }

    #menuForm h2 {
        font-size: 20px;
    }
}

</style>
</head>
<body>

<%@ include file="restaurantOwnerNav.jsp"%>
<br>

<form id="menuForm" action="SaveMenu" method="post">
		<h2>Add Menu Item</h2>

		<label for="name">Name <span class="star-mark">*</span></label>
		<input type="text" id="name" name="name" placeholder="Enter dish name" required>

		<label for="price">Price <span class="star-mark">*</span></label>
		<input type="number" id="price" name="price" step="0.01" placeholder="Enter price" required>

		<label for="description">Description <span class="star-mark">*</span></label>
		<textarea id="description" name="description" rows="4" placeholder="Enter description" required></textarea>

		<label for="imagePath">Image URL <span class="star-mark">*</span></label>
		<input type="url" id="imagePath" name="imagePath" placeholder="Enter image URL" required>

		<label for="available">Available <span class="star-mark">*</span></label>
		<select id="available" name="available" required>
			<option value="" disabled selected>Select availability</option>
			<option value="true">Yes</option>
			<option value="false">No</option>
		</select>

		<label for="ratings">Ratings <span class="star-mark">*</span></label>
		<select id="ratings" name="ratings" required>
			<option value="" disabled selected>Select rating</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>

		<input type="submit" value="Add Menu Item">
	</form>

<br>
<br>

</body>
</html>