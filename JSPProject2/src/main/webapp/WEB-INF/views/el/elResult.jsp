<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 결과</title>
</head>
<body>


  <h1>EL을 이용해서 출력하기</h1>
  
  <h3>파라미터</h3>
  
  <ul>
  
    <li>\${param.name속성값} : request에 담긴 파라미터 얻어오기 (1개)</li>
    <li>\${paramValues.name속성값[인덱스]} : name이 일치하는 파라미터 중 지정된 인덱스 번째 value를 얻어옴 </li>
  </ul>

<p>
       이름 : ${param.inputName} <br>
       나이 : ${param.inputAge} <br>
       
       opt : ${param.opt} <br>
       
       opt[0] : ${ paramValues.opt[0] } <br>
       opt[1] : ${ paramValues.opt[1] } <br>
	   opt[2] : ${ paramValues.opt[2] } <br>
</p>

<hr>

<h3>세팅된 속성(attribute) 출력하기</h3>

<ul>

   <li>  기본 : \%{key}  (key는 세팅한 속성의 키값)           </li>
   <li>  배열 또는 List : \${key[index]}                          </li>
   <li>  DTO 또는 MAP : \${필드명} 								</li>
   
</ul>

<p>
   address(JSP) : <%= request.getAttribute("address") %> <br>
   address(EL) : ${requestScope.address} <br>
   
   score : ${score} <br>
   ${str}<br>
   strList[0] : ${str[0]}<br>
   strList[1] : ${str[1]}<br>
   strList[2] : ${str[2]}<br>
   
  book : ${book} <br>
  
  book의 title : ${book.title} <br>
  book의 writer : ${book.writer} <br>
  book의 price : ${book.price}  <br>

</p>

<hr>

<h1>EL은 null, 비어있다를 같은 것으로 생각한다</h1>

<ul>
   <li> list1 :  ${list1}   </li>
   <li> list2 :  ${list2}   </li>

</ul>

<h4>empty 연산자</h4>

${empty list } / ${empty list2 }

</body>
</html>