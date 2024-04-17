<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	CIRCLE <br>
	RADIUS: <%=request.getParameter("radius") %><br>
	AREA: ${circle.getArea()}<br>
</body>
</html>