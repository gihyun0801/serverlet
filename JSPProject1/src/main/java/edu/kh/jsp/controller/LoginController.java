package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{
   
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		String message = null;
		if(id.equals("user01") && pw.equals("pass01")) {
			message = "로그인 성공";
		}else {
			message = "아이디 또는 비밀번호가 일치하지 않습니다";
		}	
		
		
		
RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");




req.setAttribute("msg", message);
                  //속성을 추가하겟다 key:value 형식 key는 아무이름이나 들어와도됨


		dispatcher.forward(req, resp);
		
		//forward
		//전송하다, 전달하다, 보내다
		//forward를 하면
		//주소창이 요청 주소로 바뀌고
		//그 요청에 맞는 화면으로 변함
		//요청에 맞는 응답을 했기 때문에..
		//Servlet이 가지고 있던 req,resp 객체를
		//JSP 에게 전달하여 요청을 위임
		
		
		
		
		
	}
	
}
