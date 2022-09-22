<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- -----Css and JavaScript----- -->
<%@include file="component/allCss.jsp" %>
</head>
<body>
	<!-- -----Navbar----- -->
	<%@include file="component/navbar.jsp" %>
	
	<!-- Form -->
	<div class="container-fluid">
		<div class="row py-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Login Page</h4>
					
					<%
						String invalidMsg=(String)session.getAttribute("invalidMsg");
							
						if(invalidMsg!=null){
						%>
						<p class="text-danger text-center"><%=invalidMsg %></p>
						<% 
						session.removeAttribute("invalidMsg");
						}
					%>
					
					<%
						String logMsg=(String)session.getAttribute("logMsg");
							
						if(logMsg!=null){
						%>
						<p class="text-success text-center"><%=logMsg %></p>
						<% 
						session.removeAttribute("logMsg");
						}
					%>
						<form action="LoginServlet" method="post">
							<div class="form-group">
							  <label for="exampleInputEmail1">Email address</label>
							  <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
							  <label for="exampleInputPassword1">Password</label>
							  <input type="password" class="form-control" name="password" id="exampleInputPassword1">
							</div>
						    <div class="text-center">
						      <button type="submit" class="btn btn-primary">Login</button>
						    </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>