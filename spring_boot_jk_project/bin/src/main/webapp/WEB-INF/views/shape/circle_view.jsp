<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/shape/circle3" method="post">
<%-- <form action="${pageContext} }/shape/circle2" method="post"> --%>
	CIRCLE <br>
	RADIUS: <input type="text" name="radius"><br>
	<input type="submit" value="전송">
	<input type="reset" value="리셋">
</form>
</body>
</html>