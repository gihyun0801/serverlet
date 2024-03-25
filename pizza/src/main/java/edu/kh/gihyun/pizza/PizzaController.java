package edu.kh.gihyun.pizza;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.gihyun.model.dto.Pizza;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizza")
public class PizzaController extends HttpServlet{
  
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 List<Pizza> pizzaList = new ArrayList<Pizza>();
		 
		 pizzaList.add(new Pizza("치즈 피자", 8000));
		 pizzaList.add(new Pizza("콤비네이션 피자", 9000));
		 pizzaList.add(new Pizza("핫치킨 피자", 10000));
		 
		
		 
		 String num = req.getParameter("order");
		 String size = req.getParameter("size");
		 String amount = req.getParameter("amount");
		 
		 Pizza p = pizzaList.get(Integer.parseInt(num));
		 
		 String name = p.getName();
		 int price = p.getPrice();
		 
		 price *= Integer.parseInt(amount) ;
		 
		 if(size.equals("L")) {
			 price += 2000;
		 }
		 
		 req.setAttribute("pizza", name);
		 req.setAttribute("price", price);
		 
		 RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		 
		 dis.forward(req, resp);
		 
		 
	}
	  
	  
	
}
