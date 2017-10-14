package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.StudentBeans;
import dao.StudentDeo;
@WebServlet("/EditStuentForm")
public class EditStuentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String roll = request.getParameter("rollno");
		StudentBeans beans = StudentDeo.getRecordsById(roll);
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Edit student</title></head><body><h1>Edit student</h1>");
		request.getRequestDispatcher("navaccountant.html").include(request,response);
		pw.println("<form method='get' action='EditStudent'>");
		pw.println("roll no : <input type='text' name='rollno' value='"+beans.getRollno() +"'><br>");
		pw.println("Name : <input type='text' name='name' value='"+beans.getName()+"'><br>");
		pw.println("course : <input type='text' name='course'  value='"+beans.getCourse()+"'><br>");
		pw.println("fee : <input type='number' name='fee'  value='"+beans.getFee()+"'><br>");
		pw.println("paid : <input type='number' name='paid'  value='"+beans.getPaid()+"'><br>");
		pw.println("due : <input type='number' name='due'  value='"+beans.getDue()+"'><br>");
		pw.println("<input type='submit' value=update student>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
		
	}

}
