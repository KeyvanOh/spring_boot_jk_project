$("<h2>").appendTo($(".login-form"))
	.text("Login to your account")
;
$("<form>").appendTo($(".login-form"))
	.attr("id", "formLogin")
	.attr("action", "#")
;
$("<input>").appendTo($("#formLogin"))
	.attr("id", "inputLoginName")
	.attr("type", "text")
	.attr("placeholder", "Name")
;
$("<input>").appendTo($("#formLogin"))
	.attr("id", "inputLoginPassword")
	.attr("type", "password")
	.attr("placeholder", "Password")
;
$("<span>").appendTo($("#formLogin"))
	.attr("id", "spanLoginCheckbox")
;
$("<input>").appendTo($("#spanLoginCheckbox"))
	.attr("id", "inputLoginCheckbox")
	.attr("type", "checkbox")
	.addClass("checkbox")
;
$("<span>").appendTo($("#spanLoginCheckbox"))
	.attr("id", "spanLoginCheckboxText")
	.text("Keep me signed in")
;
$("<button>").appendTo($("#formLogin"))
	.attr("id", "buttonLoginSubmit")
	.attr("type", "submit")
	.addClass("btn btn-default")
	.text("Login")
	.on("click", function() {
		let username = $("#inputLoginName").val();
		let password = $("#inputLoginPassword").val();
		if (username != "" && password != "") {
			$.ajax({
				type: "post",
				url: "/eshopper/ajaxLogin",
				data: 
				{
					'username': username,
					'password': password
				},
				success: function(data, status) {
					if (data.length > 0) {
						sessionStorage.setItem('username', data[0]);
						console.log(sessionStorage.getItem('username'));
						window.location.replace("/eshopper/main");
					};
				},
			});
		};
		$("#inputLoginName").val("");
		$("#inputLoginPassword").val("");
	})
;
console.log("js/Login.js here.");