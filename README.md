# 🎬 MoviesBookingApp

A complete JSP–Servlet based movie ticket booking system with user authentication, dynamic movie listings, poster gallery, booking management, admin controls, and MySQL database integration.  
Built as a full-stack Java web application following MVC architecture with DAOs, Servlets, JSP views, and JDBC connectivity.  

------

# 🚀 Features  

# 👤 User Features  

1.🔐 User Registration & Login  

2.🎞️ View Now Showing & Upcoming Movies  

3.🖼️ High-quality Movie Posters Gallery  

4.🎟️ Book Tickets with date/seat selection  

5.📜 View My Bookings  

6.❌ Cancel Bookings  

# 🛠️ Admin Features  

1.➕ Add New Movies  

2.✏️ Update Movie Details (title, description, poster, rating)  

3.🎬 Manage Upcoming Movies  

# 💾 Backend Features  

1.🧱 DAO Layer (User, Movie, Booking)  

2.🔗 Secure JDBC-based DB connection  

3.📦 MVC Folder Structure  

4.🎯 Prepared Statements to prevent SQL injection  

-----

# 🧱 Project Structure  

📁 MovieBookingApp/  
│
├── 📁 src/main/java/com/model/          # Model classes  
│     ├── User.java  
│     ├── Movie.java  
│     └── Booking.java  
│
├── 📁 src/main/java/com/dao/            # Data Access Objects  
│     ├── UserDAO.java  
│     ├── MovieDAO.java  
│     └── BookingDAO.java  
│
├── 📁 src/main/java/com/controller/     # Servlets (Controllers)  
│     ├── LoginServlet.java  
│     ├── RegisterServlet.java  
│     ├── LogoutServlet.java  
│     ├── BookTicketServlet.java  
│     ├── changeMoviesServlet.java  
│     └── changeUpcomingServlet.java  
│
├── 📁 src/main/java/com/util/  
│     └── DBConnection.java  
│
├── 📁 webapp/  
│     ├── home.jsp  
│     ├── Login.jsp  
│     ├── Register.jsp  
│     ├── bookTicket.jsp  
│     ├── upcomingMovies.jsp  
│     ├── myBookings.jsp  
│     ├── cancelBooking.jsp  
│     ├── 📁 images/         # Posters  
│     ├── 📁 css/style.css  
│     └── 📁 WEB-INF/web.xml  
│
└── README.md  

-----

# 🛠️ Technologies Used  

# Backend  

1.☕ Java (JSP + Servlet)    

2.🌐 Tomcat Server  

3.🗄️ MySQL Database  

4.🔌 JDBC  

# Frontend  

1.🎨 JSP  

2.🌈 HTML, CSS  

3.🖼️ Responsive Movie Poster Grid  

-----

# 🧩 How It Works  
# 1️⃣ User visits home page → sees movie posters  

Movies are loaded from the database using MovieDAO.  

# 2️⃣ User logs in / registers  

Handled by UserDAO and LoginServlet.  

# 3️⃣ User selects a movie → opens booking page  

BookTicketServlet loads movie details.  

# 4️⃣ User books ticket  

Booking saved via BookingDAO.  

# 5️⃣ User can view / cancel bookings  

At myBookings.jsp and cancelBooking.jsp.  

# 6️⃣ Admin manages movies  

Admin features modify DB using MovieDAO.  

-----

# ⚙️ Setup Instructions  
# 📥 Clone the Repository  
git clone https://github.com/<your-username>/MovieBookingApp.git  
cd MovieBookingApp  
# 📦 Configure MySQL Database  
Import the SQL schema above and update credentials inside:  
/src/main/java/com/util/DBConnection.java  
# ▶️ Run on Tomcat  
1.Build WAR or run via Eclipse/IntelliJ  

2.Deploy to Tomcat /webapps/  

3.Open browser:  
http://localhost:8080/MoviesBookingApp/  

-----

# 📊 Results 
# 🔐 1. Login / Register Page  

![Login Page](Screenshot%20(168).png)  

# 🎞️ 2. Dashboard Page  

![Dashboard](Screenshot%20(169).png)  

# 📝 3. Booking Ticket Page  

![Book Tickets](Screenshot%20(170).png)  

# 📜 4. My Bookings Page  

![My Bookings](Screenshot%20(171).png)  

# 🛠️ 5. Upcoming Movies Page    

![Upcoming Movies](Screenshot%20(172).png)  

-----

# 🛡️ Notes & Limitations  

1.Passwords stored as plain text in basic version → use hashing (BCrypt) for production  

2.DAO layer is simple JDBC → can upgrade to Hibernate or Spring Data  

3.No role-based authorization (Admin/User) unless implemented manually  

4.Session handling is basic — extend for security  

-----

# 📜 License  

MIT License — free to use, modify, distribute.  

-----

# 👨‍💻 Developed By  

Vasavi   
📧 vasavi9354@gmail.com  
