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

let ajaxDelete = function(pnumber) {
	$.ajax({
		//type: "post",
		type: "delete",
		url: "/board/ajax_delete",
		data: 
		{
			'pnumber': pnumber
		},
		async: false,
		success: function(data, status) {
		},
	});
};

let teststs = function() {
	
	console.log("teststs()..");
	
}

let ajaxGetViewfromPnumber = function(pnumber) {
	let view = 0;
	$.ajax({
		type: "post",
		url: "/board/ajax_get_view_from_pnumber",
		data: 
		{
			'pnumber': pnumber
		},
		async: false,
		success: function(data, status) {
			view = data.length;
		},
	});
	return view;
};

let ajaxGetViewfromBuid = function(pnumber, buid) {
	$.ajax({
		type: "post",
		url: "/board/ajax_get_view_from_buid",
		data: 
		{
			'pnumber': pnumber,
			'buid': buid
		},
		async: false,
		success: function(data, status) {
			console.log(data);
			if (data.length == 0) {
				ajaxView(pnumber, buid);
			} else {
			};				
		},
	});
};

let ajaxView = function(pnumber, buid) {
	$.ajax({
		type: "post",
		url: "/board/ajax_view",
		data: 
		{
			'pnumber': pnumber,
			'buid': buid
		},
		async: false,
		success: function(data, status) {
		},
	});
};

let ajaxUpdatePhit = function(pnumber, phit) {
	$.ajax({
		type: "post",
		url: "/board/ajax_update_phit",
		data: 
		{
			'pnumber': pnumber,
			'phit': phit
		},
		async: false,
		success: function(data, status) {
		},
	});
};










let ajaxUpdatePlike = function(pnumber, plike) {
	$.ajax({
		type: "post",
		url: "/board/ajax_update_plike",
		data: 
		{
			'pnumber': pnumber,
			'plike': plike
		},
		async: false,
		success: function(data, status) {
		},
	});
};








console.log("sqlquery.js loaded.");