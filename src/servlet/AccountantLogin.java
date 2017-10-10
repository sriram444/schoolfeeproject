package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountantDao;
@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("acuser");
		String password = request.getParameter("acpass");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Accountant Login</title></head><body>");
		boolean status = AccountantDao.validate(name, password);
		if(status){
			request.getRequestDispatcher("navaccountant.html").include(request, response);
			pw.print("<h1>welcome "+name+"</h1>");
		}else{
			request.getRequestDispatcher("index.html").include(request, response);
		}
		pw.println("</body></html>");
		
	}

}
