//提交订单
function worksubmit(){
	var onetext="" ;
	
	//肉类商品信息
	var one = $("#one_list_assemble_length").html();//获取列表数量
		
	//肉类左边商品信息
	for (var int = 1; int <= one; int++) {
		var value = $("#workul1li1font1name"+int).html();//肉类1商品份数
		
		 //辣椒
		 var lajiao=$("input[name='workli1radio-choice-dh-1-"+int+"'][checked]").val();//味道
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#workul1li1font1name"+int).html()+", goodName:" + $("#workul1li1fontname"+int).html()
					+ ",goodNum:" + $("#workul1li1font1name"+int).html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#workul1li1font2name"+int).html() + "},";
		}

	}
	//肉类右边商品信息
	for (var int = 1; int <= one; int++) {
		var value = $("#workul1li2font1name"+int).html();//份数
		 //辣椒
		 var lajiao=$("input[name='workli2radio-choice-dh-1-"+int+"'][checked]").val();
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#workul1li2font1name"+int).html()+", goodName:" + $("#workul1li2fontname"+int).html()
					+ ",goodNum:" + $("#workul1li2font1name"+int).html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#workul1li2font2name"+int).html() + "},";
		}

	}
	
	//蔬菜类商品信息-----------------------------------------------------------------------
	var greens = $("#one_list_greens_length").html();//获取列表数量
	
	//蔬菜左边商品信息
	for (var int = 1; int <= greens; int++) {
		var value = $("#workul1li1font1name3"+int).html();//蔬菜1商品份数
		
		 //辣椒
		 var lajiao=$("input[name='workli1radio-choice-dh-1-"+int+"'][checked]").val();//味道
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#workul1li1font1name3"+int).html()+", goodName:" + $("#workul1li1fontname3"+int).html()
					+ ",goodNum:" + $("#workul1li1font1name3"+int).html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#workul1li1font2name3"+int).html() + "},";
		}

	}
	//蔬菜右边商品信息
	for (var int = 1; int <= greens; int++) {
		var value = $("#workul1li2font1name4"+int).html();//份数
		 //辣椒
		 var lajiao=$("input[name='workli2radio-choice-dh-1-"+int+"'][checked]").val();
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#workul1li2font1name4"+int).html()+", goodName:" + $("#workul1li2fontname4"+int).html()
					+ ",goodNum:" + $("#workul1li2font1name4"+int).html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#workul1li2font2name4"+int).html() + "},";
		}

	}
	
	//酒水类商品信息-----------------------------------------------------------------------
	var drinks = $("#one_list_drinks_lengthsize").html();//获取列表数量
	
	//酒水左边商品信息
	for (var int = 1; int <= drinks; int++) {
		var value = $("#workul1li1font1name5"+int).html();//酒水1商品份数
		
		 //辣椒
		 var lajiao=$("input[name='workli1radio-choice-dh-1-"+int+"'][checked]").val();//味道
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#workul1li1font1name5"+int).html()+", goodName:" + $("#workul1li1fontname5"+int).html()
					+ ",goodNum:" + $("#workul1li1font1name5"+int).html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#workul1li1font2name5"+int).html() + "},";
		}

	}
	//酒水右边商品信息
	for (var int = 1; int <= drinks; int++) {
		var value = $("#workul1li2font1name6"+int).html();//份数
		 //辣椒 1不辣
		 var lajiao=$("input[name='workli2radio-choice-dh-1-"+int+"'][checked]").val();
		
		if (value > 0) {
			onetext = onetext + "{ goodId:"+$("#workul1li2font1name6"+int).html()+", goodName:" + $("#workul1li2fontname6"+int).html()
					+ ",goodNum:" + $("#workul1li2font1name6"+int).html()+", goodTaste:"+lajiao
					+ ",goodprice:" + $("#workul1li2font2name6"+int).html() + "},";
		}

	}
	
	
	alert(onetext);
	
	var addrensu=$("#workaddrensu").html();//就餐人数
	
	var addkaitai=$("#workaddkaitai").html();//桌号
	var deskNo =addkaitai;
	var orderjosn = {
		"deskNo" : deskNo,
		"addrensu":addrensu,
		"totalPrice" : $("#work0price").text(),
		"rows" : onetext,
		};
	var tol = $("#work0price").text();
	if (tol == 0) {
		alert("淘气！！请点菜！");
		return;
	}
	if (deskNo == 0) {
		alert("淘气！！请输入桌号！+");
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