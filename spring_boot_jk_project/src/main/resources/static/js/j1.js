console.log("js/j1.js here.");

$("<h2>").appendTo(".features_items")
	.addClass("title text-center")
	.text("Features Items")
;		

//let pageContext = ${pageContext.request.contextPath};
let pageContext = "http://localhost:8282";
//let pageContext = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
console.log(pageContext);
//console.log(window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)));


let list = [];

$.ajax({
	type: "get",
	//url: "/eshopper/ajax_list",
	//url: "/eshopper/ajaxEmpSalgradelist",
	url: "/eshopper/ajaxEmpSalgradeDeptlist",
	data: 
	{
	},
	async: false,
	success: function(data, status) {
		list = data;
	},
});

console.log(list);



//for (let i = 0; i < 6; i++) {
for (let i = 0; i < list.length; i++) {
	
	
	$("<div>").appendTo(".features_items")
		.attr("id", "divCard" + i)
		.addClass("col-sm-4")
	;
	
	$("<div>").appendTo("#divCard" + i)
		.addClass("product-image-wrapper")
		.attr("id", "divWrapper" + i)
	;
	
	
	
	$("<div>").appendTo("#divWrapper" + i)
		.addClass("single-products")
		.attr("id", "divProduct" + i)
	;
	
	$("<div>").appendTo("#divProduct" + i)
		.addClass("productinfo text-center")
		.attr("id", "divInfo" + i)
	;
	
	$("<img>").appendTo("#divInfo" + i)
		//.attr("src", pageContext + "/images/home/product" + (i + 1) + ".jpg")
		.attr("src", pageContext + "/images/home/product" + Math.floor(Math.random()*6. + 1) + ".jpg")
	;
	
	
	
	
	$("<div>").appendTo("#divInfo" + i)
		.addClass("product-overlay")
		.attr("id", "divOverlay" + i)
	;
	$("<h2>").appendTo("#divInfo" + i)
		//.text("$56")
		.text(list[i].sal)
	;
	$("<p>").appendTo("#divInfo" + i)
		//.text("Easy Polo Black Edition")
		.text(list[i].deptno + " " + list[i].ename)
	;
	
	$("<a>").appendTo("#divInfo" + i)
		.attr("id", "aBtn" + i)
		.addClass("btn btn-default add-to-cart")
		.attr("href", "#")
		//.text("Add to cart")
		.text(list[i].grade)
	;
	$("<i>").appendTo("#aBtn" + i)
		.addClass("fa fa-shopping-cart")
	;
	
	
	
	
	
	
	
	$("<div>").appendTo("#divWrapper" + i)
		.addClass("choose")
		.attr("id", "divChoose" + i)
	;
	
	
	
};

