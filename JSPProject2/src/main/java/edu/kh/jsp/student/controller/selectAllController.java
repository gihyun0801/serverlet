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

@WebServlet("/jstl/student/selectAll")
public class selectAllController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//서비스 객체 생성
		StudentService service = new StudentService();
		
		
		try {
			
			// 학생 전체 조회 서비스 호출
			List<Student> stdList = service.selectAll();
			
			req.setAttribute("stdList", stdList);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/student/selectAll.jsp");
		dis.forward(req, resp);
		
		
	}
	
}
