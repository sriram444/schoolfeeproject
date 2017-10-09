package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String adminuser = request.getParameter("aduser");
		String adminpassword = request.getParameter("adpass");
		PrintWriter p = response.getWriter();
		p.println("<html");
		p.println("<head><title>Admin panel</title></head>");
		p.println("<body>");
		if((adminuser.equals("admin@admin"))&&(adminpassword.equals("admin"))){
			request.getRequestDispatcher("navaadmin.html").include(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("admin","true");
			request.getRequestDispatcher("adminhome.html").include(request, response);
		}else{
			p.println("<p>Username or password is wrong</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		p.println("</body>");
		p.println("</html>");
		p.close();
	}

}
