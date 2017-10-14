package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchStudentForm")
public class SearchStudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Search student with rollno</title></head><body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		pw.println("<form method='get' action='SearchStudent'>");
		pw.println("rollno : <input type='text' name='rollno' /><br>");
		pw.println("<input type='submit' value='search student'/>");
		pw.println("</form>");
		pw.println("</body></html>");
		pw.close();
	}

}
