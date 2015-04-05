/** **订单** */

function page2submit() {
	var one = $("#one_list_length").html();
	var two = $("#two_list_length").html();
	var three = $("#three_list_length").html();
	var onetext="" ;
	var addrensu=$("#addrensu").html();
	
	for (var int = 1; int <= one; int++) {
		var value = $("#d" + int + "font1").html();
		 //辣椒
		 var lajiao=$("input[name='radio-choice-h-1-"+int+"'][checked]").val();
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#pdid"+int).html()+", goodName:" + $("#pd" + int + " h1").html()
					+ ",goodNum:" + $("#d" + int + "font1").html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#d" + int + "font2").html() + "},";
		}

	}
	for (var int = 1; int <= two; int++) {
		var value = $("#2d" + int + "font1").text();
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#p2did"+int).html()+", goodName:" + $("#p2d" + int + " h1").html()
					+ ",goodNum:" + $("#2d" + int + "font1").html()+", goodTaste:"+4
					+ ",goodprice:" + $("#2d" + int + "font2").html() + "},";
		}
	}
	for (var int = 1; int <= three; int++) {
		var value = $("#3d" + int + "font1").text();
		var lajiao3=$("input[name='radio-choice-h-3-"+int+"'][checked]").val();
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#p3did"+int).html()+", goodName:" + $("#p3d" + int + " h1").html()
					+ ",goodNum:" + $("#3d" + int + "font1").html()+", goodTaste:"+lajiao3
					+ ",goodprice:" + $("#3d" + int + "font2").html() + "},";
		}
	}
	var url = location.search;
	var deskNo;
	if (url.indexOf("?") != -1) {
		var str = url.substr(1) // 去掉?号
		var strs = str.split("&");
		deskNo = unescape(strs[0].split("=")[1]);
	}
	$("#deskNo").html(deskNo);
	var deskNo = $("#deskNo").html();
	var orderjosn = {
		"deskNo" : deskNo,
		"addrensu":addrensu,
		"totalPrice" : $("#d0price").text(),
		"rows" : onetext,
		};
	var tol = $("#d0price").text();
	if (tol == 0) {
		alert("淘气！！请点菜！");
		return;
	}
	if (addrensu == 0) {
		alert("淘气！！请输入人数！+");
		return;
	}
	// $.ajax带json数据的异步请求
	$.ajax({
		url : '../wap/order',// 跳转到 action
		data : orderjosn,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if (data == "true") {
				// view("修改成功！");
				// alert("修改成功！");
				// window.location.reload();
				alert("已提交订单，客官稍等...");
			} else {
				alert("已提交订单，客官稍等...");
			}
		},
		error : function() {
			// view("异常！");
			alert("支付后，开放此功能！");
		}
	});
}
/** **呼叫*** */
function onepage3() {
	$.ajax({
		url : '../wap/call',// 跳转到 action
		data : {},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if (data == "true") {
				// view("修改成功！");
				// alert("修改成功！");
				// window.location.reload();
				alert("店小二马上到..请稍等.....");
			} else {
				alert("店小二马上到..请稍等.....");
			}
		},
		error : function() {
			// view("异常！");
			alert("异常！");
		}
	});
}
function onepage4() {
	$.ajax({
		url : '../wap/bill',// 跳转到 action
		data : {},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if (data == "true") {
				// view("修改成功！");
				// alert("修改成功！");
				// window.location.reload();
				alert("客官销等..老板娘再穿衣服.....");
			} else {
				alert("客官销等..老板娘再穿衣服.....");
			}
		},
		error : function() {
			// view("异常！");
			alert("异常！");
		}
	});
}
function twopage3() {
	$.ajax({
		url : '../wap/call',// 跳转到 action
		data : {},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if (data == "true") {
				// view("修改成功！");
				// alert("修改成功！");
				// window.location.reload();
				alert("店小二马上到..请稍等.....");
			} else {
				alert("店小二马上到..请稍等.....");
			}
		},
		error : function() {
			// view("异常！");
			alert("异常！");
		}
	});
}
function twopage4() {
	$.ajax({
		url : '../wap/bill',// 跳转到 action
		data : {},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if (data == "true") {
				// view("修改成功！");
				// alert("修改成功！");
				// window.location.reload();
				alert("客官销等..老板娘再穿衣服.....");
			} else {
				alert("客官销等..老板娘再穿衣服.....");
			}
		},
		error : function() {
			// view("异常！");
			alert("异常！");
		}
	});
}

function rensuminus(){
	
	var min=$("#addrensu").html();
	if(min==0){
		return;
	}
	$("#addrensu").html(Math.abs(min) - 1)
	
}
function rensuplus(){
	var plus=$("#addrensu").html();
	$("#addrensu").html(Math.abs(plus) + 1)
	
}

function twopage1(){
	$("#d0price").html(0);
}
