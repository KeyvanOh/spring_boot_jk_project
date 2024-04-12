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

let sceneNumber = 0;
//let sceneNumber = 1;

let openedCnumber = new Set();

console.log(openedCnumber);


let header = $("header");


let showPost = function(value) {
	let tdPtitle = $("#" + value.pnumber + " > .ptitle");
	//console.log(tdPtitle);
	let divPost = $("<div>");
	divPost.appendTo(tdPtitle);
	$("<h1>").text(value.ptitle)
		//.appendTo(tdPtitle);
		.appendTo(divPost);
	$("<img>").attr("src", value.pimage)
		.css("max-width", "100%")
		.on("error", function() {
			$(this).remove();
		})
		//.appendTo(tdPtitle);
		.appendTo(divPost);
	$("<p>").text(value.pcontent)
		//.appendTo(tdPtitle);				
		.appendTo(divPost);				
};


let loadList = function() {
	$(".container").remove();
	
	let container = $("<div>");
	//$(".table-row").remove();
	container.addClass("container text-center")
		//.css("margin", "1rem")
		.appendTo(header);
	let table = $("<table>")
		.addClass("table")
		.attr("border", "1")
		//.css("margin-bottom", "0")
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
		console.log(board);
		$.each(board, function( index, value ) {
			  let tr = $("<tr>");
			  tr
			  	.attr("id", value.pnumber)
			  	.appendTo(table);
			  $("<td>").text(value.pnumber)
			  	//.addClass("pnumber")
			  	.appendTo(tr);
			  $("<td>").text(value.pid)
			  	.appendTo(tr);
			  let pPtitle = $("<p>");
			  pPtitle.text(value.ptitle)
			  	.css("padding", "0px")
			  	.css("margin", "0px")
			  	.on("click", function() {
			  		if (openedCnumber.has(value.pnumber) == false) {
				  		openedCnumber.add(value.pnumber);
				  		
				  		showPost(value);
				  		$(this).text("x");
			  		} else {
			  			openedCnumber.delete(value.pnumber);
			  			
			  			//$(this).children().remove();
			  			$(this).parent().children("div").remove();
			  			$(this).text(value.ptitle);
			  		};
			  	});
			  $("<td>")
			  	.addClass("ptitle")
			  	//.text(value.ptitle)
			  	//.append("<p>" + value.ptitle)
			  	.append(pPtitle)
			  	.appendTo(tr);
			  	/*
			  	.on("click", function() {
			  		if (openedCnumber.has(value.pnumber) == false) {
				  		openedCnumber.add(value.pnumber);
				  		
				  		showPost(value);
			  		} else {
			  			openedCnumber.delete(value.pnumber);
			  			
			  			//$(this).children().remove();
			  			$(this).children("div").remove();
			  		};
			  	});
			  	*/
			  if (openedCnumber.has(value.pnumber)) {
				  	pPtitle.text("x")
			  		showPost(value);
			  };
			  $("<td>").text(value.pdate)
			  	.appendTo(tr);
			  $("<td>").text(value.phit)
			  	.appendTo(tr);
			  $("<td>").text(value.plike)
			  	.appendTo(tr);
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


let showScene = function(sn) {
	switch(sn) {
		case 0: {
			loadList();
			break;
		}
		default: {
		}
	};
};



//loadList();
showScene(sceneNumber);	
setInterval( 
	/*
	function() {
		switch(sceneNumber) {
			case 0: {
				loadList();
				break;
			}
			default: {
			}
		};
	},
	*/
	showScene(sceneNumber),
	10000
);
	



console.log("HELLO jQuery");





</script>

<!-- <style>
* {
	margin: 0;
	padding: 0;
	border: 0;
}
p {
	margin: 0;
	padding: 0;
	padding-bottom: 0;
	border: 0;
}
</style>
 -->
</html>