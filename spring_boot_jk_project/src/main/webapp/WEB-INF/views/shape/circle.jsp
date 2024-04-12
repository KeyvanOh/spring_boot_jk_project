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
</body>
<script>
	let d1 = $(document);
	d1.ready(function() {
		let body = $("body");
		let header = $("<header>");
		header.appendTo(body)
		.css("background","purple")
		.css("color","yellow")
		.css("text-align","center")
		.append($("<h1>CIRCLE</h1>"))

		.append($("<h1>Radius: ${circle.getRadius()}</h1>"))
		.append($("<h1>Area: ${circle.getArea()}</h1>"));
		
		$("*").css("margin","0").css("padding","0");
		
		let main = $("<main>");
		main.appendTo(body)
	});
</script>

<script src="https://cdn.jsdelivr.net/gh/KeyvanOh/kdt@latest/test8.js"></script>

</html>