package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountantDao;
import beans.AccountantBeans;

@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("acname");
		String password = request.getParameter("acpass");
		String contact = request.getParameter("accontact");
		String id1 = request.getParameter("acid");
		int id = Integer.parseInt(id1);
		PrintWriter pw = response.getWriter();
		pw.println("<html");
		pw.println("<head><title>Admin panel</title></head>");
		pw.println("<body>");
		request.getRequestDispatcher("navaadmin.html").include(request, response);
		pw.println("<h1>Add new accountant</h1>");
		AccountantBeans beans = new AccountantBeans(id,name,password,contact);
		int status = AccountantDao.save(beans);
		if(status==1){
			pw.println("<h2>Accountant is successully inserted</h2>");
		}else{
			pw.println("<h2>Accountant is not inserted</h2>");
		}	
		request.getRequestDispatcher("addaccountform.html").include(request, response);
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
