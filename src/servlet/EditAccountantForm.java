package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.AccountantBeans;
import dao.AccountantDao;
@WebServlet("/EditAccountantForm")
public class EditAccountantForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		//AccountantBeans beans = new AccountantBeans();
		AccountantBeans beans = AccountantDao.getRecordsById(id1);
		pw.println("<html>");
		pw.println("<head><title>Edit accountant</title></head>");
		pw.println("<body>");
		request.getRequestDispatcher("navaadmin.html").include(request, response);
		pw.println("<h1>Edit accountant</h1>");
		pw.println("<form method='get' action='EditAccountant'>");
		pw.println("id : <input type='number' name='id' value='"+beans.getId()+"'/><br>");	
		pw.println("Name : <input type='text' name ='name' value='"+beans.getName()+"'/><br>");	
		pw.println("password : <input type='text' name ='password' value='"+beans.getPassword()+"' /><br>");	
		pw.println("contact : <input type='text' name ='contact' value='"+beans.getContact()+"'/><br>");	
		pw.println("<input type='submit' value='update accountant' />");	
		pw.println("</form>");
	}
}
