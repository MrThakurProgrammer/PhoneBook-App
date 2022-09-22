package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DatabaseConnection.ConnectionProvider;
import dao.contactDao;
import entities.Contact;

@WebServlet("/addContactServlet")
public class addContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String about=request.getParameter("about");
		
		Contact contact=new Contact(name, email, phone, about, userId);
		contactDao dao=new contactDao(ConnectionProvider.getConnection());		
		
		boolean f=dao.saveContact(contact);
		
		HttpSession session=request.getSession();
		if(f) {
			session.setAttribute("successMsg", "Your Contact Saved !!");
			response.sendRedirect("addContact.jsp");
		}
		else {
			session.setAttribute("failedMsg", "Something wrong On Server !!");
			response.sendRedirect("addContact.jsp");
		}
	}

}
