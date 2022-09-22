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

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String about=request.getParameter("about");
		
		Contact contact=new Contact();
		contact.setId(cid);
		contact.setName(name);
		contact.setEmail(email);
		contact.setPhno(phone);
		contact.setAbout(about);
		
		contactDao dao=new contactDao(ConnectionProvider.getConnection());		

		HttpSession session=request.getSession();
		boolean f=dao.updateContact(contact); 		
		if(f) {
			session.setAttribute("successMsg", "Your Contact Updated !!");
			response.sendRedirect("viewContact.jsp");
		}
		else {
			session.setAttribute("failedMsg", "Something Wrong On Server !!");
			response.sendRedirect("editContact.jsp?cid="+cid);
		}
	}

}