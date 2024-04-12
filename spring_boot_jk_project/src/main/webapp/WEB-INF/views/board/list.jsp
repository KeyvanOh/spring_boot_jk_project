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

</head>
<body>
	<header>
		<div class="container">
			<table border="1" class="table" style="margin-bottom: 0">
				<tr>
					<td>글번호</td>
					<td>글쓴이</td>
					<td>제목</td>
					<td>작성날짜</td>
					<td>조회수</td>
					<td>추천</td>
				</tr>
				
				
<!-- 
PNUMBER  NOT NULL NUMBER(4)      
PID               VARCHAR2(12)   
PTITLE            VARCHAR2(30)   
PCONTENT          VARCHAR2(3000) 
PIMAGE            VARCHAR2(1000) 
PHIT              NUMBER(5)      
PLIKE             NUMBER(5)     	
 -->				
				<c:forEach var="board" items="${boards }">
					<tr>
						<td>${board.pnumber }</td>
						<td>${board.pid }</td>
						<td>${board.ptitle }</td>
						<td>${board.pdate }</td>
						<td>${board.phit }</td>
						<td>${board.plike }</td>
					</tr>
				</c:forEach>
			</table>
			
			<p style="margin-bottom: 0"><a href="${pageContext.request.contextPath}/emp/insert_view">글쓰기</a></p>
		</div>
	</header>
	<main></main>

</body>
</html>