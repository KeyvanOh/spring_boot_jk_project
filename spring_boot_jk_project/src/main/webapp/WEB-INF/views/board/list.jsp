<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



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
	<header>
	</header>
	<main></main>

</body>

<script>




let header = $("header");

let loadList = function() {
	$(".container").remove();
	
	let container = $("<div>");
	//$(".table-row").remove();
	container.addClass("container text-center")
		.appendTo(header);
	let table = $("<table>")
		.addClass("table")
		.attr("border", "1")
		.css("margin-bottom", "0")
		.appendTo(container);
	let trColumn = $("<tr>");
	trColumn.appendTo(table);
	
	$("<td>글번호</td>").appendTo(trColumn)
		.css("width", "60px");
	$("<td>글쓴이</td>").appendTo(trColumn)
		.css("width", "120px");
	$("<td>제목</td>").appendTo(trColumn)
		.css("width", "600px");
	$("<td>작성날짜</td>").appendTo(trColumn)
		.css("width", "240px");
	$("<td>조회수</td>").appendTo(trColumn)
		.css("width", "60px");
	$("<td>추천</td>").appendTo(trColumn)
		.css("width", "60px");
	
	
	$.get("/board/ajax_list", {
	},
	function(board, status) {
		$.each(board, function( index, value ) {
			  let tr = $("<tr>");
			  tr.addClass("table-row")
			  	.appendTo(table);
			  $("<td>").text(value.pnumber)
			  	.appendTo(tr);
			  	//.css("width", "60px");
			  $("<td>").text(value.pid)
			  	.appendTo(tr);
			  	//.css("width", "120px");
			  $("<td>").text(value.ptitle)
			  	.appendTo(tr);
			  	//.css("width", "600px");
			  $("<td>").text(value.pdate)
			  	.appendTo(tr);
			  	//.css("width", "240px");
			  $("<td>").text(value.phit)
			  	.appendTo(tr);
			  	//.css("width", "60px");
			  $("<td>").text(value.plike)
			  	.appendTo(tr);
			  	//.css("width", "60px");
			  tr.children().addClass("border-top");
			  if (index == 19) {
				  return false;
			  };
		});
		
		let writeButton = $("<span>");
		writeButton.text("글쓰기")
			.appendTo(container);
			//.css("position", "fixed")
			//.css("top", "600px");			
	});	
	

};


loadList();
	
setInterval( 
	function() {
		loadList()
	
	}, 1000);
	



console.log("HELLO jQuery");





</script>


</html>