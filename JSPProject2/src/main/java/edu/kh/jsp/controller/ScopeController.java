package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeController extends HttpServlet{
    
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp");
		
		
		// 1. page scope -> 한 페이지만 사용 가능 jsp 파일내에서만
		
		// 2. request scope -> 요청받은곳 + 위임받은페이지
		req.setAttribute("reqValue", "1234");
		
		// 3. Session scope -> 브라우저당 1개
		//                  -> 브라우저 종료, Session 만료까지 유지
		
		// Session 만료를 임의적으로 설정할 수 있다
		
		// Session 객체 얻어오는 방법
	HttpSession session = 	req.getSession();
	session.setAttribute("sessionValue", "9999");
	
	 // 4. application scope -> 서버가 켜져있는 동안 유지
	 
	 // application 객체
	
	
	
	 // -> request , Session 객체에서 얻어오기 가능함
	
	 ServletContext applications= req.getServletContext();
	 applications.setAttribute("appValue", 100000);
	
	 
	 // 우선 순위 확인 & scope 생명주기 확인
	 
	 //모든 범위에 같은 key로 속성 세팅
	 
	 req.setAttribute("str", "request 범위에 세팅된 문자열");
	 
	 session.setAttribute("str", "session 범위에 세팅된 문자열");
	 
	 applications.setAttribute("str", "application 범위에 세팅된 문자열");
	 
	 
	 
		//scope.jsp로 위임중
	 
	 dispatcher.forward(req, resp);
		
	}
	
}
