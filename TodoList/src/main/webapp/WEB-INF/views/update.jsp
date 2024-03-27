<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/resources/css/main.css">

<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>

<main>
 <h1>To do 수정하기</h1>
   
   <form action="/update?todoNo=${todo.todoNo }" method="post" >
    
        <p>제목</p>
        <input type="text" name="title" required value="${todo.todoTitle }">
        
        <p>메모</p>
        <textarea name="memo" style="resize:none; font-size:18px;" cols="20" rows="5">${todo.todoMemo }</textarea>
        <br>
        
        <button class="insert-btn">수정하기</button>
    </form> 
</main>
  
     
</body>
</html>