let addLoginModal = function() {
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
	let divLogin = $("<div>")
		.attr("id", "loginModal")
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
		})
	;	
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
		.css("top", "1rem")
	;
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
		})
	;
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
				let listFromTheId = postIdCheck();
				if (listFromTheId.length > 0) {
					if (listFromTheId[0].bupw == $("#inputPw").val()) {
						console.log("Go LOGIN.");
						
						sessionStorage.setItem('buid', $("#inputId").val());
						console.log("session buid : " + sessionStorage.getItem('buid'));
						
						$("#spanLogin").css("display", "none");
						$("#spanLogout").css("display", "block");
						
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
let buildPostModal = function() {
	
	$("<div>").appendTo($("#container"))
		.attr("id", "postModal")
		.css("position", "fixed")
		.css("left", document.documentElement.clientWidth / 2 - 250 + "px")
		.css("top", "2rem")
		.css("width", "500px")
		//.css("height", "285px")
		//.css("height", "553px")
		//.css("height", "600px")
		.css("height", "630px")
		//.css("height", "636px")
		.css("background", "white")
		.css("border", "1px solid black")
		.css("display", "none")
		.on("keyup", function() {
			
		})
	;
	$("<span>").appendTo($("#postModal"))
		.text("x")
		.css("position", "absolute")
		.css("right", "1rem")
		.on("click", function() {
			//onOffLoginModal();
			onOffPostModal();
		})
	;	
	$("<div>").appendTo($("#postModal"))
		.attr("id", "divPtitle")
		.css("position", "absolute")
		.css("top", "1rem")
	;
	$("<span>").appendTo($("#divPtitle"))
		//.text("TITLE")
		.text("제목")
		//.css("width", "100px")
		.css("width", "50px")
		.css("position", "absolute")
		.css("left", "1rem")
		//.css("left", "10rem")
	;
	$("<input>").appendTo($("#divPtitle"))
		.attr("id", "inputPtitle")
		.attr("type", "text")
		.css("position", "absolute")
		.css("left", "4rem")
		//.css("left", "6rem")
		.css("width", "400px")
	;
	$("<textarea>").appendTo($("#postModal"))
		.attr("id", "textareaPcontent")
		.css("position", "absolute")
		.css("left", "1rem")
		.css("top", "4rem")
		.css("width", "468px")
		//.css("height", "200px")
		.css("height", "468px")
		.css("resize", "none")
	;
	$("<div>").appendTo($("#postModal"))
		.attr("id", "divPimage")
		.css("position", "absolute")
		//.css("top", "33.5rem")
		.css("top", "34rem")
	;
	$("<span>").appendTo($("#divPimage"))
		.text("이미지")
		.css("width", "50px")
		.css("position", "absolute")
		.css("left", "1rem")
	;
	$("<input>").appendTo($("#divPimage"))
		.attr("id", "inputPimage")
		.attr("type", "text")
		.css("position", "absolute")
		.css("left", "4.5rem")
		.css("width", "412px")
	;
	$("<span>").appendTo($("#postModal"))
		.text("포스트")
		.css("position", "absolute")
		//.css("top", "36.5rem")
		//.css("top", "37rem")
		//.css("top", "36.6rem")
		.css("top", "36.65rem")
		//.css("left", "0")
		.css("left", "14rem")
		.on("click", function() {
			
			console.log("I am Post Button.");
			
			
			/*
			if ($("inputPtitle").text() != "") {
			};
			*/
			
			//console.log($("#inputPtitle").val());
			//console.log($("#textareaPcontent").text());
			//console.log($("#textareaPcontent").val());
			//console.log($("#inputPimage").val());
			
			
			if (
				$("#inputPtitle").val() != "" &&
				$("#textareaPcontent").val() != ""
			) {
				console.log($("#inputPtitle").val());
				console.log($("#textareaPcontent").val());
				console.log($("#inputPimage").val());
			};
			
			
			
			
			
			
			onOffPostModal();
			$("#inputPtitle").val("");
			$("#textareaPcontent").val("");
			$("#inputPimage").val("");
			
		})
	;
	
	
	
	
	
};



console.log("modal.js loaded.");