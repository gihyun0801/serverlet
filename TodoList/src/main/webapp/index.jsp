<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/main.css">
<title>To do List</title>
</head>
<body>
  
  
  <main>
  
      <c:choose>
        <c:when test="${empty sessionScope.loginMember}">
        
        
           <h1>투 두 리스트 로그인</h1>
           
           <form action="/login" method="post" class="login-form">
           <div>
            <p>아이디</p>
             <input type="text" name="inputId"> 
           </div>
            
            <div>
             <p>패스워드</p>
             <input type="password" name="inputPw">
            
            </div>
             
             <button>로그인</button>
             
           </form>
        
        </c:when>
        
 		 
 		 
 		 
        <c:otherwise>
        
       
        <h1>${sessionScope.loginMember.memberNickname }의 투두리스트</h1>
        
        
        <%--  --%>
        
        <c:choose>
         
           <c:when test="${empty todoList }">
           
             <h2>할일이 하나도 없습니다</h2>
            
           </c:when>
           
           
           <c:otherwise>
            
              <c:forEach var="todo" items="${todoList}">
                <table>
                
                 <tr>
                   <td>${todo.todoTitle }</td>
                   <td>${todo.todoMemo }</td>
                   <td>${todo.todoDate }</td>
                   <td><a class="upadate-btn">수정</a></td>
                   <td><a class="delete-btn">삭제</a></td>
                 
                 </tr>
                </table>
                
              
              </c:forEach>
             
           
           </c:otherwise>
          
        
        </c:choose>
        
        
         <div class="button-div">
         
            <a class="insert-btn">등록하기</a>
            <a href="/logout" class="logout-btn">로그아웃</a>
         </div>
        
        
        
        </c:otherwise>
         
        
      
      </c:choose>
  
  </main>
  

  <%-- sessionScope 에 message가 존재할 경우--%>
  
  <c:if test="${not empty sessionScope.message}">
  
       <script>
       
        alert("${sessionScope.message}");
       </script>
       
       <%--
        session에 message를 추가하면
        브라우저 종료 또는 만료전까지 계속 메시지가 출력된다
        
         
        --%>
   
    
     <c:remove var="message" scope="session"/>
  </c:if>
  
  
  
  
  
  
  
</body>
</html>