<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL(Jsp Standard Tag Library)</title>
</head>
<body>
   
   
     <h1>JSTL(Jsp Standard Tag Library, JSP 표준 태그 라이브러리)</h1>
   
   <pre>
   
        JSP에서 자주 사용되거나 공통적으로 사용되는
        Java코드 (if, for, 변수 선언, 형변환)을 쉽게 쓰게 하고싶은거
   </pre>
   
   <h3>JSTL 라이브러리 사용 방법</h3>
   
   <ol>
   
     <li>
         /webapp/WEB-INF/lib 폴더에 jstl 라이브러리 파일 추가
       
     </li>
     
     <li>
         JSTL 라이브러리를 사용하고자 하는 jsp 파일 상단에
         taglib JSP 지시자 태그 추가
     </li>
     
     <hr>
     
     <h1>1.변수 선언 (c:set 태그)</h1>
     
     <pre>
        
        - 변수 선언 위한 태그
        - c:set 에 작성 가능한 속성
        1) var : 변수명(속성 key)
        2) value : 대입할 값
        3) scope : pageContext,request,session,application
        
     </pre>
     
     
     <%
      
     //스크립틀릿으로 page scope 에 속성 세팅하는법
     
     pageContext.setAttribute("num1",10);
      
     %>
     
     jstl 로 똑같이 pageScope에 속성 세팅하는 법
     
     <c:set var="num2"  value="20" scope="page"/>
     
    
    
   </ol>
   
    num1 : ${num1 }
     <br>
     num2 : ${num2 }
     
     <hr>
     
     <h1>2.변수 제거 (c:remove)</h1>
     
     <pre>
     
       - 변수 제거 : 내장 객체에 세팅된 속성을 제거
       (jsp 방법 : removeAttribute("num1"))
       
       - c : remove 속성
       
       1)var : 삭제할 변수명
       2)scope : 내장 객체 범위(기본값 : 모든 scope)
     </pre>
     
     <%
        pageContext.removeAttribute("num1");
      
     %>
     
     num1 제거 확인 : ${num1}
     
     
     <br>
     
     c : remove 태그 이용하기  <br>
     
     <c:remove var="num2"/>
     
     num2 제거 확인 : ${num2}
     
     <hr>
     
     
     <h1>3.변수 출력 (c:out 태그)</h1>
     
     <pre>
      
       \${key } EL 구문 비슷함
       
       -단, escapeXml="true"  이거는 기본값 이거를 설정 시
        html 태그가 해석이 안됀다
        
        -escapeXml = "false" : html 태그 해석 O
        
       
     </pre>
     
     <c:set var="temp" value="<h1>배부르네요</h1>"/>
     
     html 태그 해석 x : <c:out value="${temp}"/> <br>
     html 태그 해석될때 : <c:out value="${temp }" escapeXml="false"/>
     
     <hr><hr><hr>
     
     상대경로 <br>
     
     <a href="condition">JSTL을 이용한 조건문(if / choose , when, otherwise)</a>
     <br>
     <a href="loop">JSTL을 이용한 반복문</a>
     
     <hr><hr><hr>
     
     <%-- 현재 경로 : localhost : 8080/jstl/main --%>
     <%-- 목표 경로 : jstl/student/selectAll --%>
     
     <a href="student/selectAll">workbook에서 학생 전체 조회하기</a>
     
    <a href="student/selectGun">workbook에서 건축공학과인 학생만 찾기</a>  
    
    
    <form action="student/selectOne" method="post">
     
     <%-- input에다가 학과명 작성하면 거기있는 학생들 조회 --%>
      <input type="text" name="deptName">
      <button>찾기</button>
    
    </form>   
     
</body>
</html>