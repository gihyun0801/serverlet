package edu.kh.todoList.member.controller;

import java.io.IOException;

import edu.kh.toList.member.model.dto.Member;
import edu.kh.todoList.member.model.service.MemberService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   
	   RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
	   dis.forward(req, resp);
	   
}
   
   
   
   //회원가입 폼에서 실제 데이터를 가지고 회원가입
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   try {
		   
		   String inputId = req.getParameter("inputId");
		   String inputPw = req.getParameter("inputPw");
		   String inputName = req.getParameter("inputName");
		   
		   Member member = new Member();
		   member.setMemberId(inputId);
		   member.setMemberPw(inputPw);
		   member.setMemberNickname(inputName);
		   
		   MemberService service = new MemberService();
		   
		   int result = service.signUp(member);
		   
		   HttpSession session = req.getSession();
		   
		   if(result > 0) {
			   session.setAttribute("message", "회원가입성공");
			   
			   resp.sendRedirect("/");
		   }else {
			   
			   session.setAttribute("message", "회원가입 오류...");
			   resp.sendRedirect(req.getHeader("referer"));
		   }
		   
	   }catch(Exception e) {
		   System.out.println("[회원가입 중 예외발생]");
		   e.printStackTrace();
	   }
	   
	   
	   
	   
	   
	   
	   
	}
   
}
