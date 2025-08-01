<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order Tracking</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Link for Font Awesome Icons -->
  <style type="text/css">
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      width: 80%;
      max-width: 800px;
      margin: 50px auto;
      background-color: #fff;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #fb6d3e;
      text-align: center;
      margin-bottom: 20px;
    }

    .order-status {
      display: flex;
      justify-content: space-between;
      align-items: center;
      font-size: 16px;
      margin-bottom: 20px;
    }

    .status {
      color: #4CAF50;
      font-weight: bold;
    }

    .status.pending {
      color: #FF9800;
    }

    .status.cancelled {
      color: #F44336;
    }

    /* Horizontal Tracking Steps */
    .tracking-steps {
      display: flex;
      justify-content: space-between;
      margin-top: 30px;
      border-top: 2px solid #ddd;
      padding-top: 20px;
    }

    .tracking-step {
      text-align: center;
      font-size: 14px;
      width: 25%;
    }

    .tracking-step i {
      font-size: 30px;
      color: #ddd;
    }

    .tracking-step.completed i {
      color: #4CAF50;
    }

    .tracking-step.pending i {
      color: #FF9800;
    }

    .tracking-step.cancelled i {
      color: #F44336;
    }

    .tracking-step .status-label {
      font-size: 14px;
      font-weight: bold;
    }

    .tracking-step .status-text {
      font-size: 14px;
    }

    .btn-track {
      background-color: #fb6d3e;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      margin: 20px 0;
      width: 100%;
    }

    .btn-track:hover {
      background-color: #ff7f00;
    }
  </style>
</head>
<body>

<%@ include file="without_searchbar_navbar.jsp"%>

  <div class="container">
    <h2>Track Your Order</h2>
    
    <!-- Order Status (Updated Dynamically on the Back-end) -->
    <div class="order-status">
      <span>Order Status:</span>
      <span class="status completed">Delivered</span>
    </div>

    <!-- Horizontal Tracking Steps with Icons -->
    <div class="tracking-steps">
      <div class="tracking-step completed">
        <i class="fas fa-check-circle"></i>
        <div class="status-label">Confirmed</div>
        <div class="status-text">Completed</div>
      </div>
      <div class="tracking-step completed">
        <i class="fas fa-truck"></i>
        <div class="status-label">Dispatch</div>
        <div class="status-text">Completed</div>
      </div>
      <div class="tracking-step completed">
        <i class="fas fa-box"></i>
        <div class="status-label">Delivered</div>
        <div class="status-text">Completed</div>
      </div>
    </div>
  </div>

</body>
</html>
