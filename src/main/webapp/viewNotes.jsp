<%@page import="com.soudeep.factory.NotesFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.soudeep.service.NotesServiceImpl"%>
<%@page import="com.soudeep.service.INotesService"%>
<%@page import="com.soudeep.beans.Notes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	UserDetails currentUser = (UserDetails)session.getAttribute("user");
    	
    if(currentUser == null){
    	response.sendRedirect("login.jsp");
    	session.setAttribute("login-error", "Please login to view notes");
    }
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Notes</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
	<%@include file="all_component/navbar.jsp" %>
	
	
	<% 
		String notesAddedMsg = (String)session.getAttribute("notesAddedMsg");
		if(notesAddedMsg != null){
	%>
	
	<div class="alert alert-success alert-dismissible fade show text-center" role="alert">
  		 <%=notesAddedMsg %>
 		 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		<span aria-hidden="true">&times;</span>
  		</button>
	</div>
	
	<%	
			session.removeAttribute("notesAddedMsg");
		}
	%>
	
	
	<% 
		String updateMsg = (String)session.getAttribute("updateMsg");
		if(updateMsg != null){
	%>
	
	<div class="alert alert-success alert-dismissible fade show text-center" role="alert">
  		 <%=updateMsg %>
 		 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		<span aria-hidden="true">&times;</span>
  		</button>
	</div>
	
	<%	
			session.removeAttribute("updateMsg");
		}
	%>
	
	<% 
		String deleteMsg = (String)session.getAttribute("deleteMsg");
		if(deleteMsg != null){
	%>
	
	<div class="alert alert-warning alert-dismissible fade show text-center" role="alert">
  		 <%=deleteMsg %>
 		 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		<span aria-hidden="true">&times;</span>
  		</button>
	</div>
	
	<%	
			session.removeAttribute("deleteMsg");
		}
	%>
	
	<div class="container">
	
		<h2 class="text-center">All Notes</h2>
		
		<div class="row">
			<div class="col-md-12">
				
			<% 
					if(currentUser!=null){
						List<Notes> notesList = NotesFactory.getNotesService().getNotes(currentUser.getId());
						
						for(Notes notes: notesList){
			%>
			
			
			 <div class="card mt-3">
				<img alt="" src="images/paper.png" class="card-img-top mt-2 mx-auto"
				 style="max-width: 50px;">
			
				<div class="card-body p-4">
				
				  <h5 class="card-title"><%=notes.getTitle() %></h5>
					<h5 class="card-title"></h5>
					<p><%= notes.getContent()%></p>
					
					<p>
					
					<b class="text-success">Published By: </b> 
					<b class="text-secondary"><%= currentUser.getName() %></b>
					
					</p>
					
					<p>
					
					<b class="text-success">Published Date: </b>
					<b class="text-info"><%= notes.getDate()%></b>
					
					</p>
				
					<div class="container text-center mt-2">
					
						<a href="./deleteNotes?note_id=<%=notes.getId() %>" class="btn btn-danger">Delete</a>
						<a href="editNotes.jsp?note_id=<%=notes.getId() %>" class="btn btn-primary">Edit</a>			
					</div>
				</div>	
				</div>
			
			
			
			<% 				
							
						}
					}
			%>
				
			 
			</div>
		</div>
	</div>
	
	<%@include file="all_component/footer.jsp" %>
	
</body>
</html>