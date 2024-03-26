package edu.kh.todoList.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.toList.member.model.dto.Member;
import edu.kh.toList.todo.model.dto.Todo;
import edu.kh.todoList.member.model.service.MemberService;
import edu.kh.todoList.todo.model.service.TodoService;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 try {
			 String inputId = req.getParameter("inputId");
			 String inputPw = req.getParameter("inputPw");
			 
			 // 2. 서비스 객체 생성
			 MemberService service = new MemberService();
			 
			 // 3. 로그인 서비스 호출 후 결과 반환받기
			 
			 Member loginMember = service.login(inputId,inputPw);
			 
			 
			 // 4 . Session 객체 생성
			 
			 HttpSession session = req.getSession();
			 
			 
			 if(loginMember == null) {
				 
				 session.setAttribute("message", "아이디 또는 비밀번호 불일치");
				 
				  
				  //이전 페이지로 redirect 
				  String referer = req.getHeader("referer");
				  
				  //-> 각 페이지 방문 시 남는 흔적 :referer
				  // referer 을 쓰면 바로 이전에 방문했던 페이지를 뱉어낸다
				  
				  //request.getHeader() : 파라미터로 referer 키 전달 시 이전페이지 주소값 반환
				  
				  //http://localhost:8080/
				  
				  
				  resp.sendRedirect(referer);
				  
			  
				 
			 }else {
				 
				 
				 
				 // 5. 로그인 성공시 session 로그인한 회원 정보 세팅
				 session.setAttribute("loginMember", loginMember);
				 
				 session.setMaxInactiveInterval(60 * 60); //테스트 후 1시간으로 변경
				 
				 //-------------------------------------------------------
				 
				 
				 //현재 로그인한 회원이 등록한 todoList 목록 조회하기
				 
				 TodoService todoService = new TodoService();
				 
				 List<Todo> todoList = todoService.selectAll(loginMember.getMemberNo());
				 
				 session.setAttribute("todoList", todoList);
				 
				 
				 //-------------------------------------------------------
				 
				 //메인 페이지로 이동 재요청("/")
				 
				 resp.sendRedirect("/");
				 
			 }
			 
			 //forward : 요청 처리 후 자체적인 화면(위임받은 jsp 포함)이 존재하여
			 // 이를 이용해서 응답
			 
			 
			 //redirect : 요청 처리 후 자체적인 화면이 없어서 
			 //				화면이 있는 다른 요청을 다시 호출(재요청)
			 
			 
			 
		 }catch(Exception e) {
			 System.out.println("\n[로그인 중 예외 발생]\n");
			e.printStackTrace();
		 }
		 
	}
	 
}
