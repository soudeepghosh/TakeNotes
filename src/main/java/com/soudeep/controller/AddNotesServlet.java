package com.soudeep.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soudeep.beans.Notes;
import com.soudeep.factory.NotesFactory;

/**
 * Servlet implementation class AddNotesServlet
 */
@WebServlet("/addNotes")
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotesServlet() {
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
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("user") == null) {
	  	    response.sendRedirect("./login.jsp");
	  	    return;
	  	}
		
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		
		Notes notes = new Notes();
		notes.setTitle(title);
		notes.setContent(content);
		notes.setuId(uid);
		
		String status = NotesFactory.getNotesService().addNotes(notes);
		
		if(status.equalsIgnoreCase("success")) {
			System.out.println("Successfully notes inserted..");
			session.setAttribute("notesAddedMsg", "Notes added successfully...");
			response.sendRedirect("viewNotes.jsp");
		} 
		else {
			System.out.println("Something went wrong");
		}
		
	}

}
