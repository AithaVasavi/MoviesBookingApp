<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Movie Booking App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="Css/style.css" rel="stylesheet">
	<style>
	h2 {
	        
            font-size: 50px;
            color: white; /* Text color stays white */
            padding: 10px 20px;
            text-align: center;
            display: inline-block;
            animation: backgroundChange 5s infinite;
             /* Rounded corners */
            
           
        }

        @keyframes backgroundChange {
            0% { background-color: red; }
            20% { background-color: orange; }
            40% { background-color: yellow; }
            60% { background-color: green; }
            80% { background-color: blue; }
            100% { background-color: violet; }
        }
        </style>
</head>
<body>
<h2>Welcome To MovieBooking</h2>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg">
                <div class="card-header text-center bg-primary text-white">
                    <h4>Login</h4>
                </div>
                <div class="card-body">
                    <form action="LoginServlet" method="post">
                        <div class="mb-3">
                            <label>Email:</label>
                            <input type="text" name="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Password:</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-center">
                    New user? <a href="Register.jsp">Register here</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
