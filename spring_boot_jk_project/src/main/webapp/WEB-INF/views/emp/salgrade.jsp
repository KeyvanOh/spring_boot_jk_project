<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
  crossorigin="anonymous"
/>
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
  crossorigin="anonymous"
></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- <style type="text/css">
	*, table {
		margin: 0;
		margin-bottom: 0;
	}
</style> -->
</head>
<body>
	<header>
		<div class="container">
			<table border="1" class="table" style="margin-bottom: 0">
				<tr>
					<td>이름</td>
					<td>월급</td>
					<td>월급등급</td>
				</tr>
				
				
<!-- 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)    
Name     Null?    Type       		
	
 -->				
 
<!-- code1 -->
				<c:forEach var="empSalgrade" items="${empSalgrades }">
					<tr>
						<td>${empSalgrade.ename }</td>
						<td>${empSalgrade.sal }</td>
						<td>${empSalgrade.grade }</td>
					</tr>
				</c:forEach>
			</table>
			
			<p style="margin-bottom: 0"><a href="${pageContext.request.contextPath}/emp/insert_view">사원 번호 입력</a></p>
		</div>
	</header>
	<main></main>

</body>
<script src="https://cdn.jsdelivr.net/gh/ahn9282/middleProject@dev_ojh/jk_src/online_avatar_chat.js"></script>
</html>