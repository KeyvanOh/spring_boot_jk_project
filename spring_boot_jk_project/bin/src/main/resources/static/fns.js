let fnInputAllGreen = function() {
	$("#spanRegisterButton").css("color", "yellow");
};
let xfnInputAllGreen = function() {
	$("#spanRegisterButton").css("color", "black");
};

let fnCheckAllGreen = function() {

	//console.log($("#inputId").css("background"));
	//console.log($("#inputPw").css("background"));
	//console.log($("#inputPw2").css("background"));
	if (
		$("#inputId").css("background") == "rgb(0, 128, 0)" &&
		$("#inputPw").css("background") == "rgb(0, 128, 0)" &&
		$("#inputPw2").css("background") == "rgb(0, 128, 0)"
	) {
		fnInputAllGreen();
	} else {
		xfnInputAllGreen();
	};
			
			
			
};




let onOffPostModal = function() {
	if ($("#postModal").css("display") == "none") {
		$("#postModal").css("display", "block");
		$("#backgroundShadow").css("display", "block");
	} else {
		$("#postModal").css("display", "none");
		$("#backgroundShadow").css("display", "none");
	};
};






console.log("fns.js loaded.");