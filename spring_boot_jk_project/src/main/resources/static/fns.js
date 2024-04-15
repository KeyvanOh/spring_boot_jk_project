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



let postRegister = function() {
	$.post("/board/ajax_register", {
		'buid': $("#inputId").val(),
		'bupw': $("#inputPw2").val()
	},
	function(result, status) {
		//console.log("success?");
		//console.log(result);
		//console.log(status);
	});					
};


let postIdCheck = function() {
//let postIdCheck = function(String buid) {
	let listFromTheId = [];
	$.ajax({
		type: "post",
		url: "/board/ajax_list_with_buid",
		data: 
		{
			'buid': $("#inputId").val()
			//'buid': buid
		},
		async: false,
		success: function(board, status) {
			
			listFromTheId = board;
			
			/*
			if (board.length > 0) {
				$("#inputId").css("background", "red");
			} else {
				$("#inputId").css("background", "green");
			};
			*/
			
		},
	});
	return listFromTheId;
};


let onOffPostModal = function() {
	
	console.log("updated???");
	
};






console.log("fns.js loaded.");