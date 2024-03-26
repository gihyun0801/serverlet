package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/student/selectOne")
public class selectOne extends HttpServlet{
 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 StudentService service = new StudentService();
		 try {
			 String deptName = req.getParameter("deptName");
			 
			 List<Student> std =  service.selectOne(deptName);
			 
			 
			 req.setAttribute("stdList", std);
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/student/selectOne.jsp");
		 dis.forward(req, resp);
		 
	}
	 
}
