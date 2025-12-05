<%@ page import="com.model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../Login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Home - Movie Booking</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	h3 {
    	    
    		text-align: center;
		}
		
    </style>
</head>
<body class="bg-light">

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="#">Movie Booking</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarUser" aria-controls="navbarUser" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarUser">
                <ul class="navbar-nav ms-auto align-items-center gap-3">
                    <li class="nav-item">
                        <a class="nav-link disabled fw-semibold" href="#" tabindex="-1" aria-disabled="true">Welcome, <%= user.getName() %></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger fw-semibold" href="../LogoutServlet">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container mt-5" style="max-width: 400px;">
        <h3 class="mb-4 fw-bold border-bottom pb-2">User Dashboard</h3>
        
        <div class="d-grid gap-3">
            <a href="bookTicket.jsp" class="btn btn-primary btn-lg">Book Tickets</a>
            <a href="upcomingMovies.jsp" class="btn btn-success btn-lg">Upcoming Movies</a>
            <a href="cancelBooking.jsp" class="btn btn-danger btn-lg">Cancel Tickets</a>
            <a href="<%=request.getContextPath()%>/changeCredentials.jsp" class="btn btn-warning btn-lg text-dark">Change Credentials</a>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
