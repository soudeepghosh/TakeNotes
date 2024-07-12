<%@page import="com.soudeep.utility.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
	background: url("images/take-notes-home.jpg");
	width: 100%;
	height: 80vh;
	background-size: contain;
}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	
	
	<div class="container-fluid back-img">
		<div class="text-center">
			<br><br><br><br>
			
			<h1 class="text-white" draggable="true">
				<i class="fa fa-book" aria-hidden="true"></i>
				TakeNotes - <i>Save Your Notes Here</i>
			</h1>
			<br>

			<a href="login.jsp" class="btn btn-light">
			<i class="fa fa-sign-in" aria-hidden="true"></i>
				Login
			</a> 
			
			<a href="register.jsp" class="btn btn-light">
			<i class="fa fa-user-circle-o" aria-hidden="true"></i>
				Register
			</a>
		</div>
	</div>

	<%@ include file="all_component/footer.jsp"%>
</body>
</html>