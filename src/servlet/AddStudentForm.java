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
@WebServlet("/AddStudentForm")
public class AddStudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollno = request.getParameter("rollno");
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String fee1 = request.getParameter("fee");
		int fee = Integer.parseInt(fee1);
		String paid1 = request.getParameter("paid");
		int paid = Integer.parseInt(paid1);
		String due1 = request.getParameter("due");
		int due = Integer.parseInt(due1);
		PrintWriter pw = response.getWriter();
		StudentBeans beans = new StudentBeans(rollno,name,course,fee,paid,due);
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		int status = StudentDeo.save(beans);
		if(status==1){
			
			pw.println("<h1>Student added</h2>");
		}else{
			pw.println("<h1>student not added</h1>");
		}
	}

}
