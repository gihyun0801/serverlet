package edu.kh.serverlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 서버 관련 코드는 httpServlet을 상속받는다 무조건

/*
 * @Override
 * 어노테이션 : 컴파일러가 읽는 주석
 * 
 * @WebServlet 어노테이션
 * - > 해당 클래스를 Servlet으로 등록하고
 *  		매핑할 주소를 연결하라고 지시하는 어노테이션
 * */


@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{
 
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	// 원래 tomcat 9 버전에는
	
	// vscode 에서 요청한 파일이 깨져서 문제가 발생햇는데
	// 해결방법 : 전달받은 데이터의 문자인 코딩을 서버에 맞게 변경
	
	//tomcat10 부터는 인코딩 처리를 자동으로 해준다
	
	String id = req.getParameter("inputId");
	String pw = req.getParameter("inputPw");
    String name = req.getParameter("inputName");
    String textArea = req.getParameter("intro");
    
    System.out.println(id);
    System.out.println(pw);
    System.out.println(name);
    System.out.println(textArea);
	
	
	//응답화면 만들기
    // -> java 에서 작성하기 너무 귀찮고 힘들다
    // 누가 이것좀 대신 만들어줘라
    // -> JSP 한테 넘긴다 
    
    // jsp 가 대신 화면을 만들어 주기 위해선
    //servlet이 어떤 요청을 받았는지 알아야한다!!
    
    RequestDispatcher dispacther =  req.getRequestDispatcher("/WEB-INF/views/result.jsp");
	                     //(wepapp) 이 생략되어있따 
    
    dispacther.forward(req, resp);
              //요청을 위임 할때 쓰는 게 forward
    
}	
	
}
