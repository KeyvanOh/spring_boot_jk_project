<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/member/register3" method="post">
<%-- <form action="${pageContext} }/shape/circle2" method="post"> --%>
	게시판
	아이디: <input type="text" name="id"><br>
	패스워드: <input type="password" name="pw"><br>
	이름: <input type="text" name="name"><br>
	이메일: <input type="text" name="email"><br>
	나이: <input type="text" name="age"><br>
	<input type="submit" value="전송">
	<input type="reset" value="리셋">
</form>
</body>
</html>