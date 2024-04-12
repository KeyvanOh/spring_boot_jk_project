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
		<h1>사원등록 페이지</h1>
		
<%-- 						
					<td>사원번호</td>
					<td>이름</td>
					<td>직무</td>
					<td>매니저 번호</td>
					<td>입사일</td>
					<td>급여</td>
					<td>보너스</td>
					<td>부서번호</td>
 --%>		
		
		<form action="${pageContext.request.contextPath}/emp/register" method="post">
			사원번호 : <input type="number" name="empno"><br>
			이름 : <input type="text" name="ename" size="20"><br>
			직급 : 
			  <select name="job">
			  	<c:forEach var="job" items="${jobs}">
			  		<option value="${job}">${job}</option>
			  	</c:forEach>
			  </select><br>
			<!-- <input type="text" name="job" size="20"><br> -->
			매니저 : 
			  <select name="mgr">
			  	<c:forEach var="mgrVO" items="${mgrs}">
			  		<option value="${mgrVO.mgr}">${mgrVO.ename}</option>
			  	</c:forEach>
			  </select><br>
			입사일 : <input type="date" name="hiredate"><br>
			급여 : <input type="number" name="sal"><br>
			보너스 : <input type="number" name="comm"><br>
			부서명 : 
			  <select name="deptno">
<%-- 			  	<c:forEach var="deptno" items="${deptnos}">
			  		<option value="${deptno}">${deptno}</option>
			  	</c:forEach>
 --%>			  	<c:forEach var="dept" items="${depts}">
			  		<option value="${dept.deptno}">${dept.dname}</option>
			  	</c:forEach>
			  </select><br>
			<input type="submit" value="SUBMIT">
			<input type="reset" value="RESET">
		</form>
	</header>
	<main></main>

</body>
<script src="https://cdn.jsdelivr.net/gh/ahn9282/middleProject@dev_ojh/jk_src/online_avatar_chat.js"></script>
</html>