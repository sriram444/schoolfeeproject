package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Admin logout</title></head><body>");
		request.getRequestDispatcher("navaadmin.html").include(request, response);
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("index.html").include(request, response);
		pw.println("</body></html>");
		pw.close();
		
	}

}
