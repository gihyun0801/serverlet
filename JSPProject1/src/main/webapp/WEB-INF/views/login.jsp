<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
        <h1>로그인 결과</h1>
     
     <ul>
     
     
     <li>아이디 : <%=request.getParameter("id") %> </li><br>
     <li>비밀번호 : <%= request.getParameter("pw") %> <br></li>
     
        </ul>
       
       
       
     <h2>   <%= request.getAttribute("msg") %></h2>
    

       <button type="button" onclick="history.back()">돌아가기</button>
     
  
    
</body>
</html>