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
<title>Add Notes</title>
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
<%@include file="all_component/navbar.jsp" %>
<div class="container-fluid " id="div-background" >
	<br><br>
 	<h1 class="text-center">Add Notes</h1>
 	<div class="container">
 	
 		
 		
 		<div class="row">
 		<div class="col-md-12">
 		
		 <form action="./addNotes" method="post">
			  <div class="form-group">
			  	<%--
			  	if(session == null || session.getAttribute("user") == null) {
			  	    response.sendRedirect("./login.jsp");
			  	    return;
			  	}
			  	--%>
			  	<%
			  		UserDetails ud = (UserDetails)session.getAttribute("user");
			  		if(ud != null){
			  			
			  	%>
			  
			  	<input type="hidden" value="<%= ud.getId()%>" name="uid">
			  
			  	<% 
			  		}
				%>
			  
			    <label for="exampleInputEmail1">Title</label>
			    <input type="text" name="title" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Write your idea name here"  required>
			    
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Notes</label>
			    <textarea name="content" class="form-control" id="exampleFormControlTextarea1" rows="7" placeholder="Write your thoughts here :)" required></textarea>
  			  </div>
			  	
			  <div class="container text-center">
			  	<button type="submit" class="btn btn-primary">Save Notes</button>
			  </div>	
			  
		</form>
 		
 		</div><!-- end of col-md-12 -->
 	</div><!-- end of row -->
 		
 		
 	
 	</div><!-- end of container -->
 	
 </div>
 	 
<%@include file="all_component/footer.jsp" %>

 
</body>
</html>