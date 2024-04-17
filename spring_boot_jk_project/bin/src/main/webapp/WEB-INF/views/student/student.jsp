<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- student id is ${ studentId }<br> --%>
<h1>INPUT YOUR STUDENT ID NUMBER</h1>
<form action="${pageContext.request.contextPath}/studentView" method="post">
	NAME: <input type="text" name="name"><br>
	ID: <input type="text" name="id"><br>
	PASSWORD: <input type="password" name="pw"><br>
	EMAIL: <input type="text" name="email"><br>
	AGE: <input type="number" name="age"><br>
	<input type="submit" value="SUBMIT">
	<input type="reset" value="RESET">
</form>
<h1>REDIRECT CHECK INPUT</h1>
<form action="${pageContext.request.contextPath}/redirect/check" method="post">
	ID: <input type="text" name="id"><br>
	<input type="submit" value="SUBMIT">
	<input type="reset" value="RESET">
	
</form>
</body>
</html>