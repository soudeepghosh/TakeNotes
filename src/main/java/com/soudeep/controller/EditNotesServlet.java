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
 * Servlet implementation class EditNotesServlet
 */
@WebServlet("/edit")
public class EditNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNotesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer noteId = Integer.parseInt(request.getParameter("noteId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String status = NotesFactory.getNotesService().editNote(noteId, title, content);
		
		if(status.equalsIgnoreCase("success")) {
			System.out.println("Note updated successfully...");
			HttpSession session = request.getSession();
			session.setAttribute("updateMsg", "Notes updated successfully...");
			response.sendRedirect("viewNotes.jsp");
		}else {
			System.out.println("Something went wrong");
		}
		
	}

}
