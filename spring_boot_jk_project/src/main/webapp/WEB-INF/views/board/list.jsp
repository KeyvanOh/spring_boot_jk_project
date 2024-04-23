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

<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<!-- ... -->
</head>
<body>
	<header>
	</header>
	<main></main>

</body>

<script src="${pageContext.request.contextPath}/fns.js" ></script>

<script src="${pageContext.request.contextPath}/modal.js" ></script>

<script src="${pageContext.request.contextPath}/sqlquery.js" ></script>

<script>

console.log("23543");

let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");

console.log("token: " + token);
console.log("header: " + header);

$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

//buildPostModal();

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

if (sessionStorage.getItem('page') == null) {
	sessionStorage.setItem('page', 1)
};
console.log(sessionStorage.getItem('page'));

let sceneNumber = 0;
//let sceneNumber = 1;

let openedCnumber = new Set();

//console.log(openedCnumber);


//let header = $("header");

let showPost = function(value) {
	let tdPtitle = $("#" + value.pnumber + " > .ptitle");
	let divPost = $("<div>");
	divPost.appendTo(tdPtitle);
	$("<h1>").text(value.ptitle)
		.appendTo(divPost);
	$("<img>").attr("src", value.pimage)
		.css("max-width", "100%")
		.on("error", function() {
			$(this).remove();
		})
		.appendTo(divPost)
	;
	
	//console.log(value.pcontent);
	//console.log(value.pcontent.split(/\r?\n/));
	
	$.each(value.pcontent.split(/\r?\n/), function( index, value2 ) {
		$("<p>").text(value2)
			.appendTo(divPost)
			//.css("text-align", "left")
		;
	});
	
	//$("<p>").text(value.pcontent)
	//	.appendTo(divPost)
	//;
		
	$("<p>").text("v")
		.appendTo(divPost)
		.css("margin-bottom", "0")
		.css("margin-top", "1rem")
		.on("click", function() {
			//console.log("comment here.");
			
			if (sessionStorage.getItem('buid') != null) {
				console.log("comment here.");
				//console.log("title clicked");
				
				//$("<input>").attr("type", "text")
				//	.appendTo($(this).parent())
				//;
				
				let divComment = $(this).parent().children(".divComment");
				if (divComment.css("display") == "none") {
					divComment.css("display", "block")
					
					
					console.log("show the comments.");
					
					/*
					$.ajax({
						type: "post",
						url: "/board/ajax_commentList",
						data: 
						{
							'pnumber': value.pnumber,
						},
						async: false,
						success: function(data, status) {
							
							console.log(data);
							
							
						},
					});
					*/
					
					
					//ajaxGetComments(value.pnumber);
					console.log(ajaxGetComments(value.pnumber));
					
					
				} else {
					divComment.css("display", "none")
				};
				
				
				
			};
			//console.log(sessionStorage.getItem('buid'));
			
			
			
			
			
			
		})
		//.css("border-top", "1px solid yellow")
	;
	
	
	let divComment = $("<div>").appendTo(divPost)
		.addClass("divComment")
		.css("display", "none")
	;
	
	$("<input>").attr("type", "text")
		.appendTo(divComment)
		.css("width", "100%")
		.on("keypress", function(e) {
			let ccontent = $(this).val();
			if (ccontent != "" && e.which == 13) {
				/*
					PNUMBER                NUMBER(4)    
					CNUMBER       NOT NULL NUMBER(6)    
					PARENTCNUMBER          NUMBER(2)    
					CID                    VARCHAR2(12) 
					CCONTENT               VARCHAR2(30) 
					CDATE                  DATE         
				*/
				console.log("pnumber: " + value.pnumber);
				//console.log("cnumber: " + divComment.children().length);
				console.log("cnumber: " + "comment_sequence");
				console.log("parentcnumber: " + null);
				console.log("cid: " + sessionStorage.getItem('buid'));
				console.log("ccontent: " + ccontent);
				console.log("cdate: " + "sysdate");
				/*
				$.ajax({
					type: "post",
					url: "/board/ajax_comment",
					data: 
					{
						'pnumber': value.pnumber,
						//'cnumber': comment_sequence,
						//'parentcnumber': null,
						'cid': sessionStorage.getItem('buid'),
						'ccontent': ccontent
						//'cdate': sysdate
					},
					async: false,
					success: function(board, status) {
					},
				});
				*/
				
				ajaxPostComment(value.pnumber, sessionStorage.getItem('buid'), ccontent);
				
				$(this).val("");
				
				//let date = new Date();
				
				let divCommentOne = $("<div>").appendTo(divComment)
					.addClass("d-flex justify-content-between");
				;

				$("<span>").appendTo(divCommentOne)
					//.text(value2.cid)
					.text(sessionStorage.getItem('buid'))
				;
				$("<span>").appendTo(divCommentOne)
					//.text(value2.ccontent)
					.text(ccontent)
				;
				$("<span>").appendTo(divCommentOne)
					//.text(value2.cdate)
					//.text("cdate")
					//.text(Date.now())
					.text(new Date())
					//.text(date.getTime())
					//.text(date)
					//.text(Date.now().getTime())
				;
				
				
				
			};
		})
	;
	//console.log("c1");
	
	let comments = ajaxGetComments(value.pnumber);
	console.log(comments);
	
	
	console.log("list title clicked.");
	console.log(value.pnumber);
	
	let buid = sessionStorage.getItem('buid');
	//console.log(sessionStorage.getItem('buid'));
	if (buid != null) {
		
		console.log(buid);
		//console.log("234");
		
		//console.log(ajaxGetView());
		
		//ajaxGetView(value.pnumber, buid);
		ajaxGetViewfromBuid(value.pnumber, buid);
		//teststs();
		
		//console.log("ajaxGetView()wefewf..");
		
		
		//console.log(value.phit);
		//console.log(ajaxGetViewfromPnumber(value.pnumber));
		
		let phit = ajaxGetViewfromPnumber(value.pnumber);
		if (value.phit != phit) {
			console.log(phit);
			
			ajaxUpdatePhit(value.pnumber, phit);
			
			$("#tdPhit" + value.pnumber).text(phit);
			
			
//.attr("id", "td" + value.pnumber)			
			
			console.log("444234");
		};
		
		
		
		
		
		
		/*
		let ableToLike = ajaxGetLikefromBuid(value.pnumber, buid);
		console.log(ableToLike);
		if (ableToLike == true) {
		};
		*/

		
		console.log("23777253");
	};
	
	
	
	
	$.each(comments, function( index, value2 ) {
	  //alert( index + ": " + value );
	  //alert( index + ": " + value.ccontent );
	  //alert(value.ccontent);

		let divCommentOne = $("<div>").appendTo(divComment)
			.addClass("d-flex justify-content-between");
		;

		$("<span>").appendTo(divCommentOne)
			.text(value2.cid)
		;
		$("<span>").appendTo(divCommentOne)
			.text(value2.ccontent)
			//.css("margin-bottom", "0")
			//.css("text-align", "left")
		;
		$("<span>").appendTo(divCommentOne)
			.text(value2.cdate)
		;
		
		
	});	
	
	
	//console.log("c2");
	
	
	
	
	
	
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
		//.appendTo(header)
		.appendTo($("header"))
		.css("position", "relative");
	
	let spanPost = $("<span>")
		.attr("id", "spanPost")
		.text("글쓰기")
		.appendTo(container)
		.css("position", "absolute")
		.css("left", "0")
		.on("click", function() {
			//console.log($(this).text());
			
			if (sessionStorage.getItem('buid') == null) {
				onOffLoginModal();
			} else {
				//console.log($(this).text());
				
				onOffPostModal();
			};
			
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
			//sessionStorage.removeItem('buid');
			sessionStorage.clear();
			$("#spanLogout").css("display", "none");
			$("#spanLogin").css("display", "block");
			openedCnumber.clear();
			showScene(sceneNumber);
			
			//here here
			//$(".pPtitle").text($(".pPtitle").children("h1").text());
			//$(".pPtitle").text($(this).children("h1").text());
			//console.log($(".pPtitle").children("h1").text());
			//$(".pPtitle").parent().children("div").remove();
			
			//let classPPtitle = $(".pPtitle");
		})
	;
	
	//if (sessionStorage.getItem('buid') == "") {
	if (sessionStorage.getItem('buid') == null) {
		$("#spanLogin").css("display", "block");
	} else {
		$("#spanLogout").css("display", "block");
	};
	
	
	let table = $("<table>")
		.addClass("table")
		.attr("border", "1")
		.appendTo(container)
		//.css("position", "absolute")
		.css("position", "relative")
		//.css("left", "0")
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
		'page': sessionStorage.getItem('page'),
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
				.addClass("pPtitle")
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
				})
			;
			
			
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
					.appendTo(tr)
					.on("click", function() {
						//console.log(value.pid);
						//console.log(sessionStorage.getItem('buid'));
						
						if (value.pid == sessionStorage.getItem('buid')) {
							
							console.log("the write is here");
							//alert("wanna delete?");
							//confirm("wanna delete?");
							if (confirm("wanna delete?") == true) {
								//console.log("delete it");
								console.log("delete the post" + value.pnumber);
								
								//$.ajax
								ajaxDelete(value.pnumber);
								//loadList();
								showScene(sceneNumber);
								
							} else {
								//console.log("ok whatever");
							};
							
							
						};
						
						
					})
				;
			  $("<td>").text(value.phit)
			  	.appendTo(tr)
				//.attr("id", "td" + value.pnumber)
				.attr("id", "tdPhit" + value.pnumber)
			;
			  $("<td>").text(value.plike)
			  	.appendTo(tr)
				.attr("id", "tdPlike" + value.pnumber)
				.on("click", function() {
					
					if (openedCnumber.has(value.pnumber)) {
						
						let buid = sessionStorage.getItem('buid');
						//if (sessionStorage.getItem('buid') != null) {
						if (buid != null) {
							
							
							
							
							
							let ableToLike = ajaxGetLikefromBuid(value.pnumber, buid);
							console.log(ableToLike);
							if (ableToLike == true) {
								if (confirm("Do you like this post?") == true) {
									
									
									
									//ajaxLike(pnumber, buid);
									ajaxLike(value.pnumber, buid);
									
									
									
									let plike = ajaxGetLikefromPnumber(value.pnumber);
									if (value.plike != plike) {
										console.log(plike);
										
										//ajaxUpdatePhit(value.pnumber, phit);
										ajaxUpdatePlike(value.pnumber, plike);
										
										//$("#tdPhit" + value.pnumber).text(phit);
										$("#tdPlike" + value.pnumber).text(plike);
										
									};
									
									
									
									
									console.log("like up the post" + value.pnumber);
									
								} else {
									console.log("ok whatever");
								};
								
							};
							
							
							
							
							
							
							
						};
						
						
					};
					
					
					
					
				})
			;
			  tr.children().addClass("border-top");
			  //if (index == 19) {
			//	  return false;
			  //};
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
	
	
	
	
	let size = ajaxGetPostsSize();
	
	
	$("<div>").appendTo("#container")
		.attr("id", "divPages")
		//.css("position", "absolute")
		.css("position", "relative")
		//.css("top", "620px")
		.css("top", "2rem")
	;
	
	let page = sessionStorage.getItem('page');
	//if (sessionStorage.getItem('page') > 10) {
	if (page > 10) {
		
		//console.log(sessionStorage.getItem('page'));
		//console.log(page);
		//console.log(parseInt(page) + 10);
		
		//for (let i = sessionStorage.getItem('page') - 10; i <= sessionStorage.getItem('page') + 10; i++) {
		//for (let i = page - 10; i <= page + 10; i++) {
		for (let i = page - 9; i <= parseInt(page) + 10; i++) {
			//console.log(i);
			
			//console.log(size);
			console.log(size / 20 + 1);
			
			
			if (i <= (size / 20 + 1)) {
				
				$("<span>").appendTo($("#divPages"))
					.attr("id", "spanPage" + i)
					.text(i)
					.css("position", "absolute")
					//.css("left", "0")
					//.css("left", i * 60 + "px")
					.css("left", (i - page + 10) * 60 + "px")
					.on("click", function() {
						
						//console.log(i * 20);
						sessionStorage.setItem('page', i);
						showScene(sceneNumber);
					})
				;
				
				if (i == page) {
					$("#spanPage" + page).css("font-weight", "bold");
				};
				
			};
			
		};
		
		
		
		
	} else {
		for (let i = 1; i <= 20; i++) {
			$("<span>").appendTo($("#divPages"))
				.attr("id", "spanPage" + i)
				.text(i)
				.css("position", "absolute")
				//.css("left", "0")
				.css("left", i * 60 + "px")
				.on("click", function() {
					
					console.log(i * 20);
					sessionStorage.setItem('page', i);
					showScene(sceneNumber)
				})
			;
			
			if (i == page) {
				$("#spanPage" + page).css("font-weight", "bold");
			};
			
		};
	};
	
	
	
	
	addLoginModal();
	buildPostModal();
	
	

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
				//.appendTo(header);
				.appendTo($("header"));
			
			
			
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
		
		if ($("#postModal").css("display") == "none") {
			showScene(sceneNumber);
		};
		//console.log($("#postModal").css("display"));
		//showScene(sceneNumber)
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