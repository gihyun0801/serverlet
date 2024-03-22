package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Pizza;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("pizzaOrder")
public class pizzaController extends HttpServlet{
  
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
List<Pizza> pizzaList = new ArrayList<Pizza>();
		
		pizzaList.add(new Pizza("치즈 피자", 8000));
		pizzaList.add(new Pizza("콤보네이션 피자", 9000));
		pizzaList.add(new Pizza("핫치킨 피자", 10000));
		
		
		String pizza = req.getParameter("pizza"); // 1, 2 , 3중 하나
		String size = req.getParameter("size");
		String amount = req.getParameter("amount");
		
		// L 사이즈는 2천원 추가
		
		// 피자 종류 : 핫치킨 피자(L)
		// 수량 : 2
		// 24000원
		
		// 피자 종류 파악
		// -> pizza는 "1" 처럼 문자열 -> 정수로 형변환
		
		Pizza p = pizzaList.get( Integer.parseInt(pizza)  - 1 );
		
		String pizzaName = p.getName();
		int price = p.getPrice();
		
		//L사이즈면 2천원 추가
		if(size.equals("L")) price += 2000;
		
		//price amount 값 곱하기
		
		price *= Integer.parseInt(amount);
		
		//req에 속성 추가하기
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/pizza.jsp");
		
		req.setAttribute("pizza", pizzaName);
		req.setAttribute("price", price);
		
		dispatcher.forward(req, resp);
		
	}
	 
	
	
	
}
