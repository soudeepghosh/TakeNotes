<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
		<%--
			  	if(session == null || session.getAttribute("user") == null) {
			  	    response.sendRedirect("./login.jsp");
			  	    return;
			  	}
	    --%>


	<%
	UserDetails currentUser = (UserDetails) session.getAttribute("user");

	if (currentUser == null) {
		response.sendRedirect("index.jsp");
	}
	%>

	<div class="container-fluid " style="padding-top: 0px; padding-left: 0px; padding-right: 0px;">
	<%@include file="all_component/navbar.jsp" %>
		<div class="card py-5">
			<div class="card-body text-center">
				<img class="img-fluid mx-auto" style="max-width: 420px;" alt="" src="images/img-pen-paper.jpg">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>