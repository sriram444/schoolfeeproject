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
@WebServlet("/EditAccountant")
public class EditAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		AccountantBeans beans = new AccountantBeans(id,name,password,contact);
		AccountantDao.update(beans);
		request.getRequestDispatcher("ViewAccountant").include(request, response);
	}

}
