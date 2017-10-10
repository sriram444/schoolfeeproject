package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AccountantBeans;
import dao.AccountantDao;

@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html");
		pw.println("<head><title>Admin panel</title></head>");
		pw.println("<body>");
		request.getRequestDispatcher("navaadmin.html").include(request, response);
		pw.println("<h1>View Accountant</h1>");
		List<AccountantBeans> list = AccountantDao.getAllRecords();
		pw.println("<table>");
		pw.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>contact</th><th>Edit</th><th>Delete</th>");
		for(AccountantBeans l:list){
			pw.println("<tr><td>"+l.getId()+"</td><td>"+l.getName()+"</td><td>"+l.getPassword()+"</td><td>"+l.getContact()+"</td><td><a href='EditAccountantForm?id="+l.getId()+"'>Edit</a></td><td><a href='DeleteAccountant?id="+l.getId()+"'>Delete</a></td>");
		}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

}
