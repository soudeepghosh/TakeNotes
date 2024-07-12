package com.soudeep.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soudeep.beans.UserDetails;
import com.soudeep.factory.UserFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDetails user = new UserDetails();
		user.setEmail(email);
		user.setPassword(password);
		
		UserDetails loginUser = UserFactory.getUserService().loginUser(user);
		
		if(loginUser != null) {
			session = request.getSession();
			session.setAttribute("user", loginUser);
			response.sendRedirect("home.jsp");
		}else {
			session = request.getSession();
			session.setAttribute("login-failed", "Wrong email or password");
			response.sendRedirect("login.jsp");
		}
	}

}
