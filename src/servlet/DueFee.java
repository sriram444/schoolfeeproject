package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.StudentBeans;
import dao.StudentDeo;
@WebServlet("/DueFee")
public class DueFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>due student view</title></head><body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		pw.println("<table>");
		pw.println("<tr><th>roll no</th><th>name</th><th>course</th><th>fee</th><th>paid</th><th>Due</th></tr>");
		List<StudentBeans> list = StudentDeo.getDue();
		for(StudentBeans l:list){
			pw.println("<tr><td>"+l.getRollno()+"</td><td>"+l.getName()+"</td><td>"+l.getCourse()+"</td><td>"+l.getFee()+"</td><td>"+l.getPaid()+"</td><td>"+l.getDue()+"</td></tr>");
		}
		pw.println("</table>");
		pw.println("</body></html>");
	}

}
