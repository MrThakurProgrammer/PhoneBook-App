<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="dao.contactDao"%>
<%@page import="DatabaseConnection.ConnectionProvider"%>
<%@page import="java.util.*"%>
<%@page import="entities.Contact"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contact Page</title>
<!-- -----Css and JavaScript----- -->
<%@include file="component/allCss.jsp" %>

<style>
	.crd-ho:hover{
		background-color:#f7f7f7;
	}
</style>
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
	
	<%
	String successMsg=(String)session.getAttribute("successMsg");
	String failedMsg=(String)session.getAttribute("failedMsg");
	
	if(successMsg!=null){
	%>
	<div class="alert alert-success" role="alert"><%=successMsg %></div>
	<% 
	session.removeAttribute("successMsg");
	}
	if(failedMsg !=null){
	%>
	<p class="text-danger text-center"><%=failedMsg %></p>
	<% 
	}
	%>	
	
	<form action="addContactServlet" action="post">	
	
	<%
		if(user!=null)
		{%>
			<input type="hidden" value="<%=user.getId()%>" name="userid"/>
		<%}
	%>
	
	<div class="container">
		<div class="row p-5">
			
			<%
			if(user != null)
			{	
				contactDao dao=new contactDao(ConnectionProvider.getConnection());
				List<Contact> contact=dao.getAllContact(user.getId());
			
				for(Contact c:contact)
				{
				%>
					<div class="col-4">
						<div class="card crd-ho">
							<div class="card-body">
								<h6>Name : <%=c.getName() %> </h6>
								<p>Email :  <%=c.getEmail() %></p>
								<p>Phone No : <%=c.getPhno() %></p>
								<p>About : 	<%=c.getAbout() %></p>
								<div class="text-center">
									<a href="editContact.jsp?cid=<%=c.getId()%>" class="btn btn-success btn-sm"> Edit</a>
									<a href="deleteContact?cid=<%=c.getId()%>" class="btn btn-danger btn-sm"> Delete</a>
								</div>
							</div>
						</div>
					</div>
				<%
				}
			}
			%>
	
		</div>
	</div>	
	</form>
</body>
</html>