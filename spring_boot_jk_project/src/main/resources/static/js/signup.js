




$("<h2>").appendTo($(".signup-form"))
	.text("New User Signup!")
;
$("<form>").appendTo($(".signup-form"))
	.attr("id", "formSignup")
	.attr("action", "#")
;
$("<input>").appendTo($("#formSignup"))
	.attr("id", "inputSignupName")
	.attr("type", "text")
	.attr("placeholder", "Name")
;
$("<input>").appendTo($("#formSignup"))
	.attr("id", "inputSignupEmail")
	.attr("type", "email")
	.attr("placeholder", "Email Address")
;
$("<input>").appendTo($("#formSignup"))
	.attr("id", "inputSignupPassword")
	.attr("type", "password")
	.attr("placeholder", "Password")
;
$("<button>").appendTo($("#formSignup"))
	.attr("id", "buttonSignupSubmit")
	.attr("type", "submit")
	.addClass("btn btn-default")
	.text("Signup")
	.on("click", function() {
		
		console.log("button clicked");
		
		
		//console.log($("#inputSignupName").val());
		
		let username = $("#inputSignupName").val();
		let password = $("#inputSignupPassword").val();
		
		if (username != "" && password != "") {
			console.log(username);
			console.log(password);
			
			
			$.ajax({
				type: "post",
				url: "/eshopper/ajaxSignup",
				data: 
				{
					'username': username,
					'password': password
				},
				//async: false,
				success: function(data, status) {
				},
			});
			
		};
		
		$("#inputSignupName").val("");
		$("#inputSignupPassword").val("");
		
	})
	
;






console.log("js/signup.js here.");
