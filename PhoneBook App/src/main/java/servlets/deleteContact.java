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

@WebServlet("/deleteContact")
public class deleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		contactDao dao=new contactDao(ConnectionProvider.getConnection());		
		
		HttpSession session=request.getSession();
		boolean f=dao.deleteContact(cid); 		
		if(f) {
			session.setAttribute("successMsg", "Your Contact Delete Successfully !!");
			response.sendRedirect("viewContact.jsp");
		}
		else {
			session.setAttribute("failedMsg", "Something Wrong On Server !!");
			response.sendRedirect("editContact.jsp?cid="+cid);
		}
	}

}
