<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Phone Book</title>
<!-- -----Css and JavaScript----- -->
<%@include file="component/allCss.jsp" %>
<style>
	.back-img{
		background: url("img/img.jpg");
		width:100%;
		height:80vh;
		background-repeat:no-repeat;
		background-size:cover;
	}
</style>

</head>
<body>
	<!-- -----Navbar----- -->
	<%@include file="component/navbar.jsp" %>
		
	<!-- -----Background image----- -->
	<div class="back-img container-fluid text-center text-danger">
		<h1>Welcome To PhoneBook App</h1>		
	</div>
		
	<!-- -----Footer----- -->
	<%@include file="component/footer.jsp" %>
</body>
</html>