package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.userDao;
import entities.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		userDao dao=new userDao(ConnectionProvider.getConnection());
		User u=dao.loginUser(email, password);
		
		HttpSession session=request.getSession();
		if(u!=null) {
			//pw.println("User is avl: "+u);
			session.setAttribute("user",u);
			response.sendRedirect("index.jsp");
		}
		else {
			//pw.println("Not user is avl: "+u);
			
			session.setAttribute("invalidMsg", "Invalid email and password !!");
			response.sendRedirect("login.jsp");
		}
	}

}
