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
@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Student view</title></head><body><table>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		List<StudentBeans> beans = StudentDeo.getAllStudents();
		pw.println("<h1>View Students</h1>");
		pw.println("<tr><th>roll no</th><th>Name</th><th>Course</th><th>Fee</th><th>Paid</th><th>Due</th><th>Edit</th><th>delete</th></tr><br>");
		for(StudentBeans l:beans){
			pw.println("<tr><td>"+l.getRollno()+"</td><td>"+l.getName()+"</td><td>"+l.getCourse()+"</td><td>"+l.getFee()+"</td><td>"+l.getPaid()+"</td><td>"+l.getDue()+"</td><td><a href='EditStuentForm?rollno="+l.getRollno()+"'>Edit</a></td><td><a href='DeleteStudent?rollno="+l.getRollno()+"'>delete</a></td></tr><br>");
		}
		pw.println("</table></body></html>");
	}

}
