<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<%@ include file="all_component/allcss.jsp" %>
</head>
<body>
	<%@ include file="all_component/navbar.jsp" %>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-3">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-circle fa-3x" aria-hidden="true"></i>
						<h4>Register Here</h4>
					</div>

					
					<%
						String regMsg = (String)session.getAttribute("reg-success");
						if(regMsg!=null){ 
					%>
						<div class="alert alert-success" role="alert">
						Registration successful.. <a href="login.jsp" class="alert-link">Login here</a>
						</div>	
					<%
							session.removeAttribute("reg-success");
						}
					%>
					
					<%
						String regFailedMsg = (String)session.getAttribute("reg-failed");
						if(regFailedMsg!=null){ 
					%>
						<div class="alert alert-danger" role="alert">
  							<%= regFailedMsg %>..Please try again!
						</div>
					<%
							session.removeAttribute("reg-failed");
						}
					%>

					<div class="card-body">
						
						<form action="./UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label> 
								<input type="text" class="form-control" id="exampleInputPassword1"
									placeholder="eg. John Doe" name="name" required>
							</div>
							<div class="form-group">
								<label >Enter Email ID</label> 
								<input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email" placeholder="eg. john_unique_doe@email.in" required> 
							</div>
							<div class="form-group">
								<label>Enter Password</label> 
								<input type="password" class="form-control" id="exampleInputPassword1"
									name="password" placeholder="eg. UniqueJohn@3373Doe" required>
							</div>
							
							<button type="submit" class="btn btn-primary badge-pill btn-block bg-custom">Register</button>
						</form>
						
						</div> <!-- Card-body -->
						<p class="text-center">Already have account? <a href="login.jsp">Login Here</a></p>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="all_component/footer.jsp" %>
</body>
</html>