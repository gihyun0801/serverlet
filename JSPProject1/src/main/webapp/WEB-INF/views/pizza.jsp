<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 결과</title>
</head>
<body>
  <h1>피자 종류 :  <%= request.getAttribute("pizza") %> 
  
        (<%= request.getParameter("size") %>)
  
  </h1>
 
  <h1>    수량 : <%= request.getParameter("amount") %>     </h1>  
  
  <h3>    총가격 : <%= request.getAttribute("price") %>    </h3>
  
  
</body>
</html>