<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("orderer") %> 님의 주문 결과</title>
</head>
<body>
 
  
  		  <h1>주문자 : <%= request.getParameter("orderer")  %></h1>    
        <br>
        
        <h3>주문한 커피 : <% if(request.getParameter("type").equals("ice")){ %>
           차가운
         <% } else { %>
           따뜻한
         <% } %> 
</h3>
         
        <h3><%= request.getParameter("coffee") %></h3> 
         
              
        <br>
        
        타입 : <%= request.getParameter("type") %>
        <br>
        
        <% String[] arr = request.getParameterValues("opt"); %>
        
         <%  if(request.getParameterValues("opt") != null) { %>
                  
                  <ul>
                  
                  <%  for(String opt : arr) {   %>
                  
                       <li> <%= opt %>     </li>
                  
                 <% }%> 
                  </ul>       
        
         <%} %> 
      
       
        
        
         
</body>
</html>