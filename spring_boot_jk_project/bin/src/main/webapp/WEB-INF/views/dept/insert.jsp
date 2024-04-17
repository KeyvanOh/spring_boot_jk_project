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
		<h1>부서입력 페이지</h1>
		<form action="${pageContext.request.contextPath}/dept/register" method="post">
			부서번호 : <input type="text" name="deptno" size="20"><br>
			부서이름 : <input type="text" name="dname" size="20"><br>
			부서위치 : <input type="text" name="loc" size="20"><br>
			<input type="submit" value="SUBMIT">
			<input type="reset" value="RESET">
		</form>
		
		
	
		<div class="container">
			<table border="1" class="table" style="margin-bottom: 0">
				<tr>
					<td>부서번호</td>
					<td>부서이름</td>
					<td>지역</td>
				</tr>
				<c:forEach var="dept" items="${depts }">
					<tr>
						<td>${dept.deptno }</td>
						<td>${dept.dname }</td>
						<td>${dept.loc }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</header>
	<main></main>

</body>
<script src="https://cdn.jsdelivr.net/gh/ahn9282/middleProject@dev_ojh/jk_src/online_avatar_chat.js"></script>
</html>