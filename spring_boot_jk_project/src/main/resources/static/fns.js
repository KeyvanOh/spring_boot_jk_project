let fnInputAllGreen = function() {
	$("#spanRegisterButton").css("color", "yellow");
};
let xfnInputAllGreen = function() {
	$("#spanRegisterButton").css("color", "black");
};

console.log("here is test");


let postRegister = function() {
	$.post("/board/ajax_register", {
		'buid': $("#inputId").val(),
		'bupw': $("#inputPw2").val()
	},
	function(result, status) {
		console.log("success?");
		console.log(result);
		console.log(status);
	});					
};