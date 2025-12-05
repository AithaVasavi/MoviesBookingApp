<%@ page import="com.model.User" %>
<%@ page import="com.model.Movie" %>
<%@ page import="com.dao.MovieDAO" %>
<%@ page import="java.util.List" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../Login.jsp");
        return;
    }

    // Fetch movies from the database
    List<Movie> movieList = MovieDAO.getAllMovies();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Ticket - Movie Booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="Css/style.css" rel="stylesheet">
    <style>
    body{
    background-color:lightgreen;
    }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Movie Booking</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Welcome, <%= user.getName() %></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="../LogoutServlet">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container mt-5">
        <h3 class="mb-4">Book Movie Tickets</h3>

        <form action="bookTicketAction.jsp" method="post">
            <!-- Movie Selection -->
            <div class="mb-3">
                <label for="movie" class="form-label">Select Movie</label>
                <select class="form-select" id="movie" name="movieId" required>
                    <option value="">Select a movie</option>
                    <% for (Movie movie : movieList) { %>
						<option value="<%= movie.getId() %>"><%= movie.getTitle() %></option>
                    <% } %>
                </select>
            </div>

            <!-- Number of Tickets -->
            <div class="mb-3">
                <label for="tickets" class="form-label">Number of Tickets</label>
                <input type="number" class="form-control" id="tickets" name="tickets" min="1" required>
            </div>

            <!-- Show Time Selection (Optional) -->
            <div class="mb-3">
                <label for="showtime" class="form-label">Select Show Time</label>
                <input type="datetime-local" class="form-control" id="showtime" name="showtime" required>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Book Tickets</button>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
