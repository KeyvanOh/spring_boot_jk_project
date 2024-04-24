<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
USER HOME HERE

<!-- <p>principal: <sec:authentication property="principal"/></p> -->

<%-- <p>EmpVO: <sec:authentication property="principal.emp"/></p>
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> --%>

<p><a href="<c:url value="/" />">홈</a></p>

<p>principal: <sec:authentication property="principal"/></p>
<p>Welcome, <sec:authentication property="principal.username"/>.</p>
<p>your password is <sec:authentication property="principal.password"/>.</p>

<sec:authorize access="isAnonymous()">
	<p><a href="<c:url value="/user/login"/>"></a></p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<%-- <p><a href="<c:url value="/user/login"/>"></a></p> --%>
	<p>Welcome, <sec:authentication property="principal.username"/>.</p>
</sec:authorize>

   <h3>
       [<a href="<c:url value="/add/addForm" />">회원가입</a>]
       [<a href="<c:url value="/user/userHome" />">유저 홈</a>]
       [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
   </h3>

</body>
<script>
console.log("dd");

$("<h1>").appendTo("body")
	.text("메인페이지")
;



</script>
</html>