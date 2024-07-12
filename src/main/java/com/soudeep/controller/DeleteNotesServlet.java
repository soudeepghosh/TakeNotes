package com.soudeep.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soudeep.beans.UserDetails;
import com.soudeep.factory.NotesFactory;

/**
 * Servlet implementation class DeleteNotesServlet
 */
@WebServlet("/deleteNotes")
public class DeleteNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNotesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Integer notesId = Integer.parseInt(request.getParameter("note_id"));
		
		
		
		String status = NotesFactory.getNotesService().deleteNote(notesId);
		
		if(status.equalsIgnoreCase("success")) {
			session.setAttribute("deleteMsg", "Notes deleted successfully...");
			response.sendRedirect("./viewNotes.jsp");
		}else {
			System.out.println("Something went wrong :: "+status);
		}
	}

}
