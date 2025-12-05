package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDAO;
import com.model.User;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    User user = UserDAO.validateUser(email, password);

	    if (user != null) {
	        // Valid user
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);

	        // Role-based redirect
	        if ("admin".equalsIgnoreCase(user.getRole())) {
	            response.sendRedirect("Admin/home.jsp");
	        } else {
	            response.sendRedirect("User/home.jsp");
	        }

	        System.out.println("Login success");
	    } else {
	        // Invalid login
	        response.sendRedirect("Login.jsp?error=invalid");
	        System.out.println("Login failed");
	    }
	}



}
