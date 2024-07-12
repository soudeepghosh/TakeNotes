<%@page import="org.apache.tomcat.util.http.fileupload.InvalidFileNameException"%>
<%@page import="com.soudeep.beans.UserDetails"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
  <a class="navbar-brand" href="home.jsp"> <i class="fa fa-book" aria-hidden="true"></i> TakeNotes</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

	<%
	UserDetails user = (UserDetails)session.getAttribute("user");
	%>
	
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    
    
    
	<ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp"> <i class="fa fa-home" aria-hidden="true"></i> Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="addNotes.jsp"> <i class="fa fa-pencil" aria-hidden="true"></i> Add Notes</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="viewNotes.jsp"> <i class="fa fa-eye" aria-hidden="true"></i> View Notes</a>
      </li>
    </ul>
    
	
	
	
	<%
	if(user != null){
	%>
		<a class="btn btn-light my-2 my-sm-0 mr-2" 
		data-toggle="modal" data-target="#exampleModal"
		type="submit" href=""> <i class="fa fa-user" aria-hidden="true"></i> <%= user.getName()%></a>
      <a class="btn btn-light my-2 my-sm-0" type="submit" href="./logout"> <i class="fa fa-sign-out" aria-hidden="true"></i> Logout</a>
		
	<%
	}else{%>
	
	<a class="btn btn-light my-2 my-sm-0 mr-2" type="submit" href="login.jsp"> <i class="fa fa-sign-in" aria-hidden="true"></i> Login</a>
      <a class="btn btn-light my-2 my-sm-0" type="submit" href="register.jsp"> <i class="fa fa-user-circle-o" aria-hidden="true"></i>Register</a>
	
	<%
	}
	%>   
  
  </div>
  
  
  
  

 
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <% if(user != null) { %>
        <h5 class="modal-title" id="exampleModalLabel">Hello , <%=user.getName() %></h5>
      <%} %>  
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body"> <!-- modal body start -->
        <% if(user != null) { %> 
		<div class="container text-center">
			<i class="fa fa-user-circle fa-4x" aria-hidden="true"></i>
			<h5></h5>
			<table class="table">
				<tbody>
					<tr>
						<th>User Id</th>
						<td><%=user.getId() %></td>
					</tr>
					<tr>
						<th>Name</th>
						<td><%= user.getName() %></td>
					</tr>
					<tr>
						<th>Email </th>
						<td><%=user.getEmail() %></td>
					</tr>
					
				</tbody>
			</table>
		</div>
		
      </div> <!-- modal body end -->
      <%} %>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
    
      </div>
    </div>
  </div>
</div>


</nav>