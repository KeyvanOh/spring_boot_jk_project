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
let ajaxWrite = function() {
	$.ajax({
		type: "post",
		url: "/board/ajax_posting",
		data: 
		{
			'pid': sessionStorage.getItem('buid'),
			'ptitle': $("#inputPtitle").val(),
			'pcontent': $("#textareaPcontent").val(),
			'pimage': $("#inputPimage").val()
		},
		async: false,
		success: function(board, status) {
		},
	});
};

let ajaxGetPostsSize = function() {
	let result = 0;
	$.ajax({
		type: "post",
		url: "/board/ajax_posts_size",
		data: 
		{
		},
		async: false,
		success: function(size, status) {
			console.log(size);
			result = size;
		},
	});
	return result;
};


let ajaxGetComments = function(pnumber) {
	
	let comments = [];
	
	$.ajax({
		type: "post",
		url: "/board/ajax_commentList",
		data: 
		{
			//'pnumber': value.pnumber,
			'pnumber': pnumber,
		},
		async: false,
		success: function(data, status) {
			
			//console.log(data);
			
			comments = data;
		},
	});
	
	return comments;
	
};


let ajaxPostComment = function(pnumber, cid, ccontent) {
	
	$.ajax({
		type: "post",
		url: "/board/ajax_comment",
		data: 
		{
			//'pnumber': value.pnumber,
			'pnumber': pnumber,
			//'cnumber': comment_sequence,
			//'parentcnumber': null,
			//'cid': sessionStorage.getItem('buid'),
			'cid': cid,
			//'ccontent': ccontent
			'ccontent': ccontent
			//'cdate': sysdate
		},
		async: false,
		success: function(board, status) {
		},
	});
	
};













console.log("sqlquery.js loaded.");