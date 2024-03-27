package edu.kh.todoList.todo.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.toList.member.model.dto.Member;
import edu.kh.toList.todo.model.dto.Todo;
import edu.kh.todoList.todo.model.service.TodoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/insert")
public class InsertController extends HttpServlet{
 
	 //Todo 등록 화면 전환 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/insert.jsp");
		dis.forward(req, resp);
		
	}
	
	
	//Todo 등록할 서비스 호출 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
		    String title = req.getParameter("title");
		    String memo = req.getParameter("memo");
		    
		    Member member = (Member)session.getAttribute("loginMember");
		    
		   
			
		    TodoService service = new TodoService();
			
			int result = service.insert(title,memo,member.getMemberNo());
			
			if(result > 0) {
				session.setAttribute("message", "할 일 추가 완료");
				
				List<Todo> todoList = service.selectAll(member.getMemberNo());
				session.setAttribute("todoList", todoList);
				
				resp.sendRedirect("/");
			}else {
				session.setAttribute("message", "할 일 추가 실패");
				
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
				
				
			}
			
		}catch(Exception e) {
			System.out.println("[Todo 등록 중 예외 발생]");
			e.printStackTrace();
		}
		
		
	}
	
}
