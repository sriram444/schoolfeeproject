package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDeo;
import beans.StudentBeans;
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollno = request.getParameter("rollno");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>student with rollno</title></head><body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		pw.println("<table>");
		pw.println("<tr><th>rollno</th><th>name</th><th>course</th><th>fee</th><th>padi</th><th>Due</th></tr>");
		StudentBeans beans = StudentDeo.getStudentById(rollno);
		pw.println("<tr><td>"+beans.getRollno()+"</td><td>"+beans.getName()+"</td><td>"+beans.getCourse()+"</td><td>"+beans.getFee()+"</td><td>"+beans.getPaid()+"</td><td>"+beans.getDue()+"</td></tr>");
		pw.println("</table></body></html>");
		pw.close();
	}

}
