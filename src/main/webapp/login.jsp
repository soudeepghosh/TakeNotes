<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@ include file="all_component/allcss.jsp" %>
</head>
<body>

	<%@ include file="all_component/navbar.jsp" %>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5 ">
					<div class="card-header text-center text-white bg-custom">
					<i class="fa fa-sign-in fa-4x" aria-hidden="true"></i>
						<h4>Login</h4>
					</div>
					
						
						<%
							String loginFailedMsg = (String)session.getAttribute("login-failed");
							if(loginFailedMsg!=null){ 
						%>
						<div class="alert alert-danger alert-dismissible fade show text-center" role="alert">
  		 					<%=loginFailedMsg %>
 		 					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    							<span aria-hidden="true">&times;</span>
  							</button>
						</div>
						<%
								session.removeAttribute("login-failed");
							}
						%>
						
						<%
						 String withoutLoginMsg = (String)session.getAttribute("login-error");
  						 if(withoutLoginMsg!=null){
						%>
						<div class="alert alert-danger alert-dismissible fade show text-center" role="alert">
  		 					<%= withoutLoginMsg %>
 		 					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    							<span aria-hidden="true">&times;</span>
  							</button>
						</div>
						<%
								session.removeAttribute("login-error");
							}
						%>
						
						
						<%
						 String logoutMsg = (String)session.getAttribute("logout-msg");
  						 if(logoutMsg!=null){
						%>
						<div class="alert alert-warning alert-dismissible fade show text-center" role="alert">
  		 					<%=logoutMsg %>
 		 					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    							<span aria-hidden="true">&times;</span>
  							</button>
						</div>
						<%
								session.removeAttribute("logout-msg");
							}
						%>
						
						<div class="card-body">
						
						<form action="./LoginServlet" method="post">
						
							<div class="form-group">
								<label >Enter Email ID</label> 
								<input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email" placeholder="Enter your registered email id">
							</div>
							<div class="form-group">
								<label>Enter Password</label> 
								<input type="password" class="form-control" id="exampleInputPassword1"
									name="password" placeholder="Enter your password">
							</div>
							
							<button type="submit" class="btn btn-primary badge-pill btn-block bg-custom">Login</button>
						</form>
						
						</div> <!-- end of card-body -->
						<p class="text-center">Don't have account? <a href="register.jsp">Register Here</a></p>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="all_component/footer.jsp" %>
	
</body>
</html>