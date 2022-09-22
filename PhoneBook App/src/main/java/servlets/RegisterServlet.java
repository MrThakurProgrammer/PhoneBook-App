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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User user=new User(name, email, password);
		userDao dao=new userDao(ConnectionProvider.getConnection());		
		boolean f=dao.userRegister(user);
		
		HttpSession session=request.getSession();
		if(f) {
			//pw.println("User Register Successfully");
			session.setAttribute("successMsg", "Register Successfully !!");
			response.sendRedirect("register.jsp");
		}
		else {
			//pw.println("Something worng on server..");
			session.setAttribute("errorMsg", "Something Worng On Server..");
			response.sendRedirect("register.jsp");
		}
	}

}
