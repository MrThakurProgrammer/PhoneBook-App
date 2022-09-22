<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<!-- -----Css and JavaScript----- -->
<%@include file="component/allCss.jsp" %>
</head>
<body>
	<!-- -----Navbar----- -->
	<%@include file="component/navbar.jsp" %>
	
	<!-- Form -->
	<div class="container-fluid">
		<div class="row py-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Registration Page</h4>
					
						<%
						String successMsg=(String)session.getAttribute("successMsg");
						String errorMsg=(String)session.getAttribute("errorMsg");
							
						if(successMsg!=null){
						%>
						<p class="text-success text-center"><%=successMsg %></p>
						<% 
						session.removeAttribute("successMsg");
						}
						if(errorMsg!=null){
						%>
						<p class="text-danger text-center"><%= errorMsg%></p>
						<% 
						session.removeAttribute("errorMsg");
						}
						%>
						
					
						<form action="RegisterServlet" method="post">
							<div class="form-group">
					    	  <label for="exampleInputName1">Name</label>
						  	  <input type="text" class="form-control" name="name" id="exampleInputName1" aria-describedby="nameHelp">
						  	</div>
							<div class="form-group">
							  <label for="exampleInputEmail1">Email address</label>
							  <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
							  <label for="exampleInputPassword1">Password</label>
							  <input type="password" class="form-control" name="password" id="exampleInputPassword1">
							</div>
						    <div class="text-center">
						      <button type="submit" class="btn btn-primary">Register</button>
						    </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>