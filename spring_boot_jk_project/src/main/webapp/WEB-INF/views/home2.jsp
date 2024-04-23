<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
홈입니다.(홈파일 입니다.) gewg

<!-- <p>principal: <sec:authentication property="principal"/></p> -->

<%-- <p>EmpVO: <sec:authentication property="principal.emp"/></p>
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> --%>

<p><a href="<c:url value="/" />">홈</a></p>

</body>
<script>
console.log("dd");

$("<h1>").appendTo("body")
	.text("메인페이지")
;
<h1>유저 페이지 입니다.</h1>


</script>
</html>