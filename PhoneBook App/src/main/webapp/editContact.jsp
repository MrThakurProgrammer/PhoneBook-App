<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.contactDao"%>
<%@page import="DatabaseConnection.ConnectionProvider"%>
<%@page import="java.util.*"%>
<%@page import="entities.Contact"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact Page</title>
<!-- -----Css and JavaScript----- -->
<%@include file="component/allCss.jsp" %>

</head>
<body>
	<!-- -----Navbar----- -->
	<%@include file="component/navbar.jsp" %>
	
	<%
		if(user==null)
		{
			session.setAttribute("invalidMsg", "Pls Login !!");
			response.sendRedirect("login.jsp");  	
		}
	%>
	<!-- Form -->
	<div class="container-fluid">
		<div class="row py-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Edit Contact No</h4>
					<%
						String successMsg=(String)session.getAttribute("successMsg");
						String failedMsg=(String)session.getAttribute("failedMsg");
							
						if(successMsg!=null){
						%>
						<p class="text-success text-center"><%=successMsg %></p>
						<% 
						session.removeAttribute("successMsg");
						}
						if(failedMsg !=null){
						%>
						<p class="text-danger text-center"><%=failedMsg %></p>
						<% 
						}
						%>												
						<form action="editServlet" action="post">							
						<%
						int cid=Integer.parseInt(request.getParameter("cid"));
						contactDao dao=new contactDao(ConnectionProvider.getConnection());
						Contact c=dao.getContactById(cid);
						%>
							<input type="hidden" value="<%=cid%>" name="cid"/>
							
							<div class="form-group">
					    	  <label for="exampleInputName1">Name</label>
						  	  <input type="text" class="form-control" value="<%=c.getName()%>" id="exampleInputName1" aria-describedby="nameHelp" name="name">
						  	</div>
							<div class="form-group">
							  <label for="exampleInputEmail1">Email address</label>
							  <input type="email" class="form-control" value="<%=c.getEmail()%>" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
							</div>
							<div class="form-group">
							  <label for="exampleInputPhone1">Phone No</label>
							  <input type="number" class="form-control" value="<%=c.getPhno()%>" id="exampleInputPhone1" name="phone">
							</div>
							
							<div class="form-group">
							  <label for="exampleInputAbout1">About</label>
							  <textarea rows="4" class="form-control" id="exampleInputAbout1" name="about"><%=c.getAbout() %></textarea>
							</div>
							
						    <div class="text-center">
						      <button type="submit" class="btn btn-primary">Update Contact</button>
						    </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>