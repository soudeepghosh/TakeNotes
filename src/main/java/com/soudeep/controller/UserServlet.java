package com.soudeep.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.soudeep.beans.UserDetails;
import com.soudeep.factory.UserFactory;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDetails user = new UserDetails();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		String status = null;
		try {
			status = UserFactory.getUserService().insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(status.equals("success")) {
			session = request.getSession();
			session.setAttribute("reg-success","Registration successful");
			response.sendRedirect("register.jsp");
		}else {
			session = request.getSession();
			session.setAttribute("reg-failed",status);
			response.sendRedirect("register.jsp");
		}
		out.close();
	}

}
