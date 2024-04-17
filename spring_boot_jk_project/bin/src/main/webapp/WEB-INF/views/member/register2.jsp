<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/member/register" method="post">
<%-- <form action="${pageContext} }/shape/circle2" method="post"> --%>
<!-- 	게시판
	아이디: <input type="text" name="id"><br>
	패스워드: <input type="text" name="pw"><br>
	이름: <input type="text" name="name"><br>
	이메일: <input type="text" name="email"><br>
	나이: <input type="text" name="age"><br>
	<input type="submit" value="전송">
	<input type="reset" value="리셋"> -->
<%-- 	${request.getParameter("id") }
 --%>	
 
	아이디: <input type="text" name="id" value="" readonly><br>
	패스워드: <input type="text" name="pw" value="" readonly><br>
	이름: <input type="text" name="name" value="" readonly><br>
	이메일: <input type="text" name="email" value="" readonly><br>
	나이: <input type="text" name="age" value="" readonly><br>
	<input type="submit" value="전송">
	<input type="reset" value="리셋">
</form>
</body>
</html>