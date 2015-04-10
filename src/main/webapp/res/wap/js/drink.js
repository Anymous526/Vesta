

//酒水类
function worktable1td5(index) {
	
	var name = $("#worktable1td1font5" + index).html();
	
	var price = $("#worktable2td1font5" + index).html(); 
	
	var one_list_drinks_lengthsize= $("#one_list_drinks_lengthsize").html();//每页纵排数
	
	var j=$("#workwuxianbanner font").html();
	
	var z;
	for (var int = 1; int <= one_list_drinks_lengthsize; int++) {
		var nameli1 = $("#workul1li1fontname5" + int).html();//获取隐藏的菜品名
		
		if (name == nameli1) {
			//增加份数
			var fen=$("#workul1li1font1name5"+int).html();//获取隐藏的菜品份数
			
			var f=Math.abs(fen)+1;//添加一份
			
			$("#workul1li1font1name5"+int).html(f);
			$("#workul1li1font2name5"+int).html(f*price);
			$("#workul1li5" + int).show();//设置订单显示
			var prices=$('#work0price').html();//订单总计
			var pr=Math.abs(prices)+Math.abs(price);
			$('#work0price').html(pr);
			z=Math.abs(j)+1;
			
			$("#workwuxianbanner font").html(z);//在note添加数量
		}

	}

}



//订单-->酒水类
function worktable1td6(index) {
	var nameone = $("#worktable1td2font6" + index).html();//各选定商品数量
	
	var priceone = $("#worktable1td2font6d" + index).html();//选定各商品价格
	
	var one_list_drinks_lengthsize = $("#one_list_drinks_lengthsize").html();
	
	var js=$("#workwuxianbanner font").html();
	
	var zs;
	for (var int = 1; int <= one_list_drinks_lengthsize; int++) {
		var nameli2 = $("#workul1li2fontname6" + int).html();//获取订单商品名
		if (nameone == nameli2) {
			//增加份数
			var fens=$("#workul1li2font1name6"+int).html();
			var fs=Math.abs(fens)+1;
			$("#workul1li2font1name6"+int).html(fs);
			$("#workul1li2font2name6"+int).html(fs*priceone);
			$("#workul1li6" + int).show();
			var pricess=$('#work0price').html();
			var pr=Math.abs(pricess)+Math.abs(priceone);
			$('#work0price').html(pr);
			zs=Math.abs(js)+1;
			$("#workwuxianbanner font").html(zs);
		}
	}

}
//控制order中div的显示
function workul1li5(intdex) {
	var one_list_drinks_lengthsize = $("#one_list_drinks_lengthsize").html();
	for (var int = 1; int <= one_list_drinks_lengthsize; int++) {
		if (intdex == int) {
			$("#workli1" + intdex + "li1div5").show();

		} else {
			$("#workli1" + int + "li1div5").hide();//酒水
			$("#workli2" + int + "li1div6").hide();//订单-酒水
		}

	}

}

//控制order中div
function workul1li6(intdex) {
	var one_list_drinks_lengthsize = $("#one_list_drinks_lengthsize").html();
	for (var int = 1; int <= one_list_drinks_lengthsize; int++) {
		if (intdex == int) {
			$("#workli2" + intdex + "li1div6").show();

		} else {
			$("#workli1" + int + "li1div5").hide();
			$("#workli2" + int + "li1div6").hide();
		}

	}

}

//--------------------------------------------------------------

//修改订单中酒水的信息之添加
function workli1click_plus2(int){
	// 单价
	var num = $("#workul1li1font1name5" + int).html();//获取酒水1中的份数
		
		var price = $("#workul1li1font2name5" + int).html();//获取价格
		var sigleprice = Math.abs(price) / Math.abs(num);
		var max = Math.abs(num) + 1;
		$("#workul1li1font1name5" + int).html(Math.abs(max));
		var value = Math.abs(price) + Math.abs(sigleprice);
		$("#workul1li1font2name5" + int).html(value);
		var prices = $("#work0price").html();
		var pri=Math.abs(prices) + Math.abs(sigleprice);
		$("#work0price").html(pri);

}

//修改酒水列表之右边商品中订单商品数量
function workli2click_plus2(int){
	
	 var num = $("#workul1li2font1name6" + int).html();//获取右边选定商品份数
	  
		var price = $("#workul1li2font2name6" + int).html();//获取右边选定商品单价
		
	 var sigleprice = Math.abs(price) / Math.abs(num);
		var max = Math.abs(num) + 1;
		$("#workul1li2font1name6" + int).html(max);
		var value = Math.abs(price) + Math.abs(sigleprice);
		$("#workul1li2font2name6" + int).html(value);
		var prices = $("#work0price").html();
		var pri=Math.abs(prices) + Math.abs(sigleprice);
		$("#work0price").html(pri);
}

//酒水1中 订单商品数量减少
function workli1click_min2(int) {
	// 单价
	var num = $("#workul1li1font1name5" + int).html()
	if (num != 0) {
		var price = $("#workul1li1font2name5" + int).html();
		var sigleprice = price / num;
		var min = num - 1;
		$("#workul1li1font1name5" + int).html(min);
		var value = price - sigleprice;
		$("#workul1li1font2name5" + int).html(value);
		var prices = $("#work0price").html();
		var pri=prices - sigleprice;
		$("#work0price").html(pri);
	}
}



//订单-酒水之减少 右边商品
function workli2click_min2(int) {
	
	// 单价
	var num = $("#workul1li2font1name6" + int).html()
	if (num != 0) {
		var price = $("#workul1li2font2name6" + int).html();
		var sigleprice = price / num;
		var min = num - 1;
		$("#workul1li2font1name6" + int).html(min);
		var value = price - sigleprice;
		$("#workul1li2font2name6" + int).html(value);
		var prices = $("#work0price").html();
		var pri=prices - sigleprice;
		$("#work0price").html(pri);

	}
}

//商品的删除
function workul1li1click_deld(int){
	
	var price = $("#workul1li1font2name5"+int).html();
	var pricess = $("#work0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#work0price").html(li1divrange1nums);
	$("#workul1li5"+int).hide();
}

//删除商品--商品列表的右边商品
function workul1li2click_deld(int){
	var price = $("#workul1li2font2name6"+int).html();
	var pricess = $("#work0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#work0price").html(li1divrange1nums);
	$("#workul1li6"+int).hide();
}





