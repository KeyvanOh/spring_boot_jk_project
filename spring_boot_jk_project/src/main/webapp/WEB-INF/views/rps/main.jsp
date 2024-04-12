<!-- code1 -->
<!-- /src/main/webapp/WEB-INF/views/rps/main.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RPS MAIN</title>
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
<header>
</header>
<main></main>
</body>
<script type="text/javascript">
let rpsImage = function(rps) {
	let image = "#";
	switch(rps) {
		case "ROCK": {
			image = "https://i.etsystatic.com/8693398/r/il/4f4844/1045453387/il_570xN.1045453387_12q2.jpg";
			break;
		}
		case "PAPER": {
			image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2TPYR5UJ2pDlLpvpezAaTXRRq7HeiP7t8Xdb2et-8bEkoFb7yCrPJH-J9pKuQQqGlYTM&usqp=CAU";
			break;
		}
		case "SCISSORS": {
			image = "https://qualydesign.com/international/wp-content/uploads/2021/05/TeddyScissorsThumbnail_01.jpg";
			break;
		}
		default: {
		}
	}
	return image;
}
let rpsResultImage = function(result) {
	let image = "#";
	switch(result) {
		case "WIN": {
			image = "https://i.redd.it/pduzqbr8b5i41.jpg";
			break;
		}
		case "LOSE": {
			image = "https://sm.mashable.com/t/mashable_sea/article/t/this-bear-/this-bear-looked-frail-and-weak-look-at-his-transformation_4ttu.1248.jpg";
			break;
		}
		case "TIE": {
			image = "https://i1.adis.ws/i/forzieri/xm010217-003-1x-t?$nlpv$";
			break;
		}
		default: {
		}
	}
	return image;
}
let d = $(document);
d.ready(function() {
	let header = $("header");
	let divRPSClick = $("<div>");
	let imgBear = $('<img src="https://i.icanvas.com/GAD4?d=2&sh=s&p=1&bg=g">');
	imgBear.css("width","300px");
	let container = $('<div class="d-flex justify-content-evenly text-center">');
	header.append(divRPSClick)
		.append(container);
	container.append($('<div id="rps1">'))
	.append($('<div id="result">'))
	.append($('<div id="rps2">'))
	.children().append(imgBear)
		.append("<p>");
	$.get("/rps/ajax_list", {
	},
	function(response, status) {
		for (let i = 0; i < 3; i++) {
			let divRPS = $('<div class="rps">');
			divRPS.text(response[i]);
			divRPSClick.append(divRPS);
		}
		$(".rps").on("click", function() {
			$.post("/rps/ajax", {
				'rps': $(this).text()
			},
			function(response, status) {
				$("#rps1 > p").text("YOU: " + response.rps1);
				$("#rps1 > img").attr("src", rpsImage(response.rps1));
				$("#rps2 > p").text("COMPUTER: " + response.rps2);
				$("#rps2 > img").attr("src", rpsImage(response.rps2));
				$("#result > p").text("RESULT: " + response.result);
				$("#result > img").attr("src", rpsResultImage(response.result));
			});
		});		
	});		
});
</script>
</html>