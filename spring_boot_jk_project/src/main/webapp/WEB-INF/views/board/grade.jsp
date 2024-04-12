<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%-- 	<h1>grade</h1>
	<h1>국어: ${kor}</h1>
	<h1>영어: ${eng}</h1>
	<h1>수학: ${math}</h1>
	<h1>총점: ${sum}</h1>
	<h1>평균: ${avg}</h1>
	<h1>등급: ${grade}</h1> --%>
</body>
<script>
	let d1 = $(document);
	d1.ready(function() {
		let body = $("body");
		let header = $("<header>");
		header.appendTo(body)
		.css("background","yellow")
		.css("color","purple")
		.append($("<h1>grade</h1>"))
		.append($("<h1>국어: ${kor}</h1>"))
		.append($("<h1>영어: ${eng}</h1>"))
		.append($("<h1>수학: ${math}</h1>"))
		.append($("<h1>총점: ${sum}</h1>"))
		.append($("<h1>평균: ${avg}</h1>"))
		.append($("<h1>등급: ${grade}</h1>"));
		let main = $("<main>");
		main.appendTo(body)
		
		//$("<div><h1>grade</h1><h1>국어: ${kor}</h1><h1>영어: ${eng}</h1><h1>수학: ${math}</h1><h1>총점: ${sum}</h1><h1>평균: ${avg}</h1><h1>등급: ${grade}</h1></div>").appendTo(body);
	});
</script>

<script src="https://cdn.jsdelivr.net/gh/KeyvanOh/kdt@latest/test8.js"></script>

</html>