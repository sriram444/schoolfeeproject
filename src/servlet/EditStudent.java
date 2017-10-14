package servlet;

import java.io.IOException;

import dao.StudentDeo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.StudentBeans;
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rollno = request.getParameter("rollno");
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String fee1 = request.getParameter("fee");
		int fee = Integer.parseInt(fee1);
		String paid1 = request.getParameter("paid");
		int paid = Integer.parseInt(paid1);
		String due1 = request.getParameter("due");
		int due = Integer.parseInt(due1);
		StudentBeans beans = new StudentBeans(rollno,name,course,fee,paid,due);
		StudentDeo.edit(beans);
		response.sendRedirect("ViewStudent");
	}

}
