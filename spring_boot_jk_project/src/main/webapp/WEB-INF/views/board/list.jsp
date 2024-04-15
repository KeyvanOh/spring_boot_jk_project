<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
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

<script src="${pageContext.request.contextPath}/fns.js" ></script>

<script>

//$session.set("id", "cutiepie");


//console.log($.session.get("id"));

//$.session.set('some key', value);
//console.log($.session.get('mobile_no'));


/* $(function() {
 $.session.set("myVar", "Hello World!");
});
alert($.session.get("myVar"));
*/

//$.session.set('some key', 'a value');
//localStorage.setItem('lastname','Smith');
//alert(localStorage.getItem('lastname'));

//sessionStorage.setItem('lastname','Smith');

//alert(sessionStorage.getItem('lastname'));

//sessionStorage.setItem('id','jk');

console.log(sessionStorage.getItem('buid'));

let sceneNumber = 0;
//let sceneNumber = 1;

let openedCnumber = new Set();

//console.log(openedCnumber);


let header = $("header");




let addLoginModal =  function() {
	let backgroundShadow = $("<div>");
	backgroundShadow.attr("id", "backgroundShadow")
		.appendTo($("#container"))
		.css("position", "fixed")
		.css("left", "0")
		.css("top", "0")
		.css("width", "100vw")
		.css("height", "100vh")
		.css("background", "red")
		.css("opacity", "0.5")
		.css("display", "none");
	let divLogin = $("<div>");
	divLogin.attr("id", "loginModal")
		.appendTo($("#container"))
		//.css("position", "absolute")
		.css("position", "fixed")
		//.css("left", "50vw")
		//.css("left", document.documentElement.clientWidth / 2)
		.css("left", document.documentElement.clientWidth / 2 - 250 + "px")
		//.css("left", "50vw - 250px")
		.css("top", "2rem")
		.css("width", "500px")
		//.css("height", "600px")
		.css("height", "285px")
		.css("background", "white")
		.css("border", "1px solid black")
		.css("display", "none")
		.on("keyup", function() {
			fnCheckAllGreen();
		});	
	
	let closeButton = $("<span>");
	closeButton.appendTo(divLogin)
		.text("x")
		.css("position", "absolute")
		.css("right", "1rem")
		.on("click", function() {
			onOffLoginModal();
		})
		;
	
	let titleLogin = $("<h1>");
	titleLogin.attr("id", "titleLogin")
		.text("로그인")
		.appendTo(divLogin)
		.css("position", "absolute")
		.css("left", "12rem")
		.css("top", "1rem");
	
	let divID = $("<div>")
		.appendTo(divLogin)
		.css("position", "absolute")
		.css("top", "6rem");
	$("<span>ID</span>").appendTo(divID)
		.css("position", "absolute")
		.css("left", "8.5rem");
	let inputId = $("<input>")
		.attr("id", "inputId")
		.attr("type", "text")
		.appendTo(divID)
		.css("position", "absolute")
		.css("left", "10rem")
		.on("keyup", function() {
			if ($("#divPw2").css("display") == "none") {
			} else {
				if ($(this).val() != "") {
					
					
					/*
					$.post("/board/ajax_list_with_buid", {
						//'buid': $(this).val()
						'buid': $("#inputId").val()
					},
					//async(false),
					function(board, status) {
						if (board.length > 0) {
							$("#inputId").css("background", "red");
						} else {
							$("#inputId").css("background", "green");
						};
					});
					*/
					
					/*
					$.ajax({
						type: "post",
						url: "/board/ajax_list_with_buid",
						data: 
						{
							'buid': $("#inputId").val()
						},
						async: false,
						success: function(board, status) {
							if (board.length > 0) {
								$("#inputId").css("background", "red");
							} else {
								$("#inputId").css("background", "green");
							};
						},
						//dataType: dataType
					});
					*/
					
					
					//postIdCheck();
					
					let listFromTheId = postIdCheck();
					//let listFromTheId = postIdCheck($("#inputId").val());
					if (listFromTheId.length > 0) {
						$("#inputId").css("background", "red");
					} else {
						$("#inputId").css("background", "green");
					};
					
					
				} else {
					$("#inputId").css("background", "none");
				};				
			};
			//fnCheckAllGreen();
		});
	
	
	
	
	let divPw = $("<div>")
		.attr("id", "divPw")
		.appendTo(divLogin)
		.css("position", "absolute")
		.css("top", "9rem");
	$("<span>PW</span>").appendTo(divPw)
		.css("position", "absolute")
		.css("left", "8rem");
	let inputPw = $("<input>")
		.attr("id", "inputPw")
		.attr("type", "password")
		.appendTo(divPw)
		.css("position", "absolute")
		.css("left", "10rem")
		.on("keyup", function() {
			if ($("#divPw2").css("display") == "none") {
			} else {
				if ($(this).val() != "") {
					if ($("#inputPw").val() == $("#inputPw2").val()) {
						$("#inputPw").css("background", "green");
						$("#inputPw2").css("background", "green");
					} else {
						$("#inputPw").css("background", "red");
						$("#inputPw2").css("background", "red");
					};
				} else {
					$("#inputPw").css("background", "none");
					$("#inputPw2").css("background", "none");
				};				
			};
			//fnCheckAllGreen();
		});
	
	
	let spanLoginButton = $("<span>")
		.attr("id", "spanLoginButton")
		.text("로그인")
		.appendTo(divLogin)
		.css("position", "absolute")
		.css("top", "13rem")
		.css("left", "14.5rem")
		.on("click", function() {
			
			if ($("#inputId").val() != "" && $("#inputPw").val() != "") {
				
				//console.log("Go LOGIN.");
				
				
				
				let listFromTheId = postIdCheck();
				if (listFromTheId.length > 0) {
					//$("#inputId").css("background", "red");
					
					//console.log(listFromTheId[0]);
					//console.log(listFromTheId[0].bupw);
					
					
					
					if (listFromTheId[0].bupw == $("#inputPw").val()) {
						console.log("Go LOGIN.");
						
						//sessionStorage.setItem('buid', $("#inputPw").val());
						sessionStorage.setItem('buid', $("#inputId").val());
						
						
						console.log("session buid : " + sessionStorage.getItem('buid'));
						
						//$("#spanLogin").text(sessionStorage.getItem('buid'));
						$("#spanLogin").css("display", "none");
						
						onOffLoginModal();
						
					} else {
						console.log("Wrong PW.");
					};
					
					
					
					
					
					
				} else {
					//$("#inputId").css("background", "green");
				};				
				
				
				
			};
			
			
			
			
		})
		
		
	;
	
	let divPw2 = $("<div>")
		.attr("id", "divPw2")
		.appendTo(divLogin)
		.css("position", "absolute")
		.css("top", "12rem")
		.css("display", "none");
	let spanPw2 = $("<span>PW2</span>")
	//spanPw2.attr("id", "spanPw2")
		.appendTo(divPw2)
		.css("position", "absolute")
		.css("left", "7.5rem");
	let inputPw2 = $("<input>")
		.attr("id", "inputPw2")
		.attr("type", "password")
		.appendTo(divPw2)
		.css("position", "absolute")
		.css("left", "10rem")
		.on("keyup", function() {
			if ($("#divPw2").css("display") == "none") {
			} else {
				if ($(this).val() != "") {
					if ($("#inputPw").val() == $("#inputPw2").val()) {
						$("#inputPw").css("background", "green");
						$("#inputPw2").css("background", "green");
					} else {
						$("#inputPw").css("background", "red");
						$("#inputPw2").css("background", "red");
					};
				} else {
					$("#inputPw").css("background", "none");
					$("#inputPw2").css("background", "none");
				};				
			};
			//fnCheckAllGreen();
		});	
	
	
	let spanRegisterButton = $("<span>")
		.attr("id", "spanRegisterButton")
		.text("회원가입")
		.appendTo(divLogin)
		.css("position", "absolute")
		.css("top", "15rem")
		.css("left", "14rem")
		.on("click", function() {

			
			
			if ($("#spanRegisterButton").css("color") == "rgb(255, 255, 0)") {
				xfnInputAllGreen();
				
				console.log("Go Register");
				
				postRegister();
				
				
				onOffLoginModal();
				
				
				
			} else {
				
				
				$("#titleLogin").text("회원가입")
					.css("left", "11rem");
				$("#spanLoginButton").css("display", "none");
				
				$("#divPw2").css("display", "block");
				
				$("#inputId").css("background", "none")
				.val("");
				
				$("#inputPw").css("background", "none")
					.val("");
				$("#inputPw2").css("background", "none")
					.val("");				
				
				
			};
			
			
			
		})
		;
	
	
	
	
	
	
		
	
};



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


let onOffLoginModal = function() {
	
	//console.log($(this).text());
	
	let loginModal = $("#loginModal");

	let backgroundShadow = $("#backgroundShadow");
	if (loginModal.css("display") == "none") {
		loginModal.css("display", "block");
		backgroundShadow.css("display", "block");
		
		/*
		$("#titleLogin").text("로그인")
			.css("left", "12rem");
		$("#spanPw2").display(none);
		*/
		
		$("#titleLogin").text("로그인")
			.css("left", "12rem");
		$("#spanLoginButton").css("display", "block");
		$("#divPw2").css("display", "none");
		
		$("#inputId").css("background", "none")
			.val("");
		$("#inputPw").css("background", "none")
			.val("");
		$("#inputPw2").css("background", "none")
			.val("");
		
		
		//$("#spanRegisterButton").css("color", "black");
		xfnInputAllGreen();
		
		
	} else {
		loginModal.css("display", "none");
		backgroundShadow.css("display", "none");
	};	
}

let loadList = function() {
	//$(".container").remove();
	
	let container = $("<div>");
	container.addClass("container text-center")
		.attr("id", "container")
		.appendTo(header)
		.css("position", "relative");
	
	let spanPost = $("<span>");
	spanPost.text("글쓰기")
		.appendTo(container)
		.css("position", "absolute")
		.css("left", "0")
		.on("click", function() {
			console.log($(this).text());
		});

	
	let spanLogin = $("<span>")
		.attr("id", "spanLogin")
		.text("로그인")
		.appendTo(container)
		.css("position", "absolute")
		.css("right", "0")
		.css("display", "none")
		.on("click", function() {
			onOffLoginModal()
		});
		
	let spanLogout = $("<span>")
		.attr("id", "spanLogout")
		.text("로그아웃")
		.appendTo(container)
		.css("position", "absolute")
		.css("right", "0")
		.css("display", "none")
		.on("click", function() {
			//onOffLoginModal()
			console.log("logout button");
			sessionStorage.removeItem('buid');
			$("#spanLogout").css("display", "none");
			$("#spanLogin").css("display", "block");
		})
	;
	
	if (sessionStorage.getItem('buid') == "") {
		$("#spanLogin").css("display", "block");
	} else {
		$("#spanLogout").css("display", "block");
	};
	
	
	let table = $("<table>")
		.addClass("table")
		.attr("border", "1")
		.appendTo(container)
		.css("position", "absolute")
		.css("left", "0")
		.css("top", "2rem");
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
		//console.log(board);
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
		/*
		let writeButton = $("<span>");
		writeButton.text("글쓰기")
			.appendTo(container)
			.on("click", function() {
				//console.log("글쓰기");
				sceneNumber = 1;
				showScene(sceneNumber);	
			});
			//.css("position", "fixed")
			//.css("top", "600px");		
		*/
	});	
	
	
	addLoginModal();

};


let showScene = function(sn) {
	//sessionStorage.setItem('openedCnumber', openedCnumber);
	$(".container").remove();
	//console.log(sn);
	switch(sn) {
		case 0: {
			loadList();
			break;
		}
		case 1: {
			let container = $("<div>");
			container.addClass("container text-center border")
				.text("eswgewg")
				.appendTo(header);
			
			
			
			break;
		}
		default: {
			
			
		}
	};
	//console.log(sessionStorage.getItem("id"));
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
	function() {
		showScene(sceneNumber)
	},
	60000
);
setInterval( 
	function() {
		let loginModal = $("#loginModal");
		loginModal.css("left", document.documentElement.clientWidth / 2 - 250 + "px");
	},
	100
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