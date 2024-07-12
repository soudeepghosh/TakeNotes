<%@page import="com.soudeep.factory.NotesFactory"%>
<%@page import="com.soudeep.beans.Notes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	UserDetails currentUser = (UserDetails)session.getAttribute("user");
    	
    if(currentUser == null){
    	response.sendRedirect("login.jsp");
    	session.setAttribute("login-error", "Please login to add notes");
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp" %>
<style>
#div-background {
	height: 80vh;
	
	background: linear-gradient(90deg, rgb(131, 58, 180) 0%, 
		rgb(253, 29, 29) 50%, rgb(252, 176, 69) 100%)
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<%
		Integer noteId = Integer.parseInt(request.getParameter("note_id"));
	%>

	<div class="container-fluid " id="div-background">
		<br>
		<br>
		<h1 class="text-center">Edit Notes</h1>
		<div class="container">



			<div class="row">
				<div class="col-md-12">

					<form action="./edit" method="post">
					
						<input type="hidden" value =<%=noteId %> name="noteId">
						<% Notes notes = NotesFactory.getNotesService().getNoteById(noteId); %>
					
						<div class="form-group">

							<label for="exampleInputEmail1">Title</label> <input type="text"
								name="title" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp"
								value = <%=notes.getTitle() %>
							>

						</div>

						<div class="form-group">
							<label for="exampleFormControlTextarea1">Notes</label>
							<textarea name="content" class="form-control"
								id="exampleFormControlTextarea1" rows="7"

						    ><%=notes.getContent() %>
						    </textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Update Notes</button>
						</div>

					</form>

				</div>
				<!-- end of col-md-12 -->
			</div>
			<!-- end of row -->



		</div>
		<!-- end of container -->

	</div>

	<%@include file="all_component/footer.jsp"%>


</body>
</html>