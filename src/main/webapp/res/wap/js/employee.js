function worktable1td1(index) {
	var name = $("#worktable1td1font1" + index).html();
	var price = $("#worktable1td1font2" + index).html();
	var one_list_assemble_length = $("#one_list_assemble_length").html();
	var j=$("#workwuxianbanner font").html();
	var z;
	for (var int = 1; int <= one_list_assemble_length; int++) {
		var nameli1 = $("#workul1li1fontname" + int).html();
		if (name == nameli1) {
			//增加份数
			var fen=$("#workul1li1font1name"+int).html();
			var f=Math.abs(fen)+1;
			$("#workul1li1font1name"+int).html(f);
			$("#workul1li1font2name"+int).html(f*price);
			$("#workul1li1" + int).show();
			var prices=$('#work0price').html();
			var pr=Math.abs(prices)+Math.abs(price);
			$('#work0price').html(pr);
			z=Math.abs(j)+1;
			$("#workwuxianbanner font").html(z);
		}

	}

}
function worktable1td2(index) {
	var nameone = $("#worktable1td2font1" + index).html();
	var priceone = $("#worktable1td2font2" + index).html();
	var one_list_assemble_length = $("#one_list_assemble_length").html();
	var js=$("#workwuxianbanner font").html();
	var zs;
	for (var int = 1; int <= one_list_assemble_length; int++) {
		var nameli2 = $("#workul1li2fontname" + int).html();
		if (nameone == nameli2) {
			//增加份数
			var fens=$("#workul1li2font1name"+int).html();
			var fs=Math.abs(fens)+1;
			$("#workul1li2font1name"+int).html(fs);
			$("#workul1li2font2name"+int).html(fs*priceone);
			$("#workul1li2" + int).show();
			var pricess=$('#work0price').html();
			var pr=Math.abs(pricess)+Math.abs(priceone);
			$('#work0price').html(pr);
			zs=Math.abs(js)+1;
			$("#workwuxianbanner font").html(zs);
		}
	}

}
//开台信息
function workkaitai() {
	var one_list_assemble_length = $("#one_list_assemble_length").html();
	for (var int = 1; int <= one_list_assemble_length; int++) {
		$("#workli1" + int + "li1div").hide();
		$("#workli2" + int + "li1div").hide();
	}
}
//人数
function workrenshu() {
	var one_list_assemble_length = $("#one_list_assemble_length").html();
	for (var int = 1; int <= one_list_assemble_length; int++) {
		$("#workli1" + int + "li1div").hide();
		$("#workli2" + int + "li1div").hide();
	}
}

function workul1li1(intdex) {
	var one_list_assemble_length = $("#one_list_assemble_length").html();
	for (var int = 1; int <= one_list_assemble_length; int++) {
		if (intdex == int) {
			$("#workli1" + intdex + "li1div").show();

		} else {
			$("#workli1" + int + "li1div").hide();
			$("#workli2" + int + "li1div").hide();
		}

	}

}
function workul1li2(intdex) {
	var one_list_assemble_length = $("#one_list_assemble_length").html();
	for (var int = 1; int <= one_list_assemble_length; int++) {
		if (intdex == int) {
			$("#workli2" + intdex + "li1div").show();

		} else {
			$("#workli1" + int + "li1div").hide();
			$("#workli2" + int + "li1div").hide();
		}

	}

}
// 修改订单
function workli1click_plus(int){
	// 单价
	var num = $("#workul1li1font1name" + int).html()
		var price = $("#workul1li1font2name" + int).html();
		var sigleprice = Math.abs(price) / Math.abs(num);
		var max = Math.abs(num) + 1;
		$("#workul1li1font1name" + int).html(Math.abs(max));
		var value = Math.abs(price) + Math.abs(sigleprice);
		$("#workul1li1font2name" + int).html(value);
		var prices = $("#work0price").html();
		var pri=Math.abs(prices) + Math.abs(sigleprice);
		$("#work0price").html(pri);

}
function workli2click_plus(int){
	 var num = $("#workul1li2font1name" + int).html()
		var price = $("#workul1li2font2name" + int).html();
	 var sigleprice = Math.abs(price) / Math.abs(num);
		var max = Math.abs(num) + 1;
		$("#workul1li2font1name" + int).html(max);
		var value = Math.abs(price) + Math.abs(sigleprice);
		$("#workul1li2font2name" + int).html(value);
		var prices = $("#work0price").html();
		var pri=Math.abs(prices) + Math.abs(sigleprice);
		$("#work0price").html(pri);
}

function workli2click_min(int) {

	// 单价
	var num = $("#workul1li2font1name" + int).html()
	if (num != 0) {
		var price = $("#workul1li2font2name" + int).html();
		var sigleprice = price / num;
		var min = num - 1;
		$("#workul1li2font1name" + int).html(min);
		var value = price - sigleprice;
		$("#workul1li2font2name" + int).html(value);
		var prices = $("#work0price").html();
		var pri=prices - sigleprice;
		$("#work0price").html(pri);

	}
}
function workli1click_min(int) {
	// 单价
	var num = $("#workul1li1font1name" + int).html()
	if (num != 0) {
		var price = $("#workul1li1font2name" + int).html();
		var sigleprice = price / num;
		var min = num - 1;
		$("#workul1li1font1name" + int).html(min);
		var value = price - sigleprice;
		$("#workul1li1font2name" + int).html(value);
		var prices = $("#work0price").html();
		var pri=prices - sigleprice;
		$("#work0price").html(pri);
	}
}
function workul1li1click_del(int){
	
	var price = $("#workul1li1font2name"+int).html();
	var pricess = $("#work0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#work0price").html(li1divrange1nums);
	$("#workul1li1"+int).hide();
}

function workul1li2click_del(int){
	var price = $("#workul1li2font2name"+int).html();
	var pricess = $("#work0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#work0price").html(li1divrange1nums);
	$("#workul1li2"+int).hide();
}
//就餐人数
function workrensuminus(){
	
	var min=$("#workaddrensu").html();
	if(min==0){
		return;
	}
	$("#workaddrensu").html(Math.abs(min) - 1)
	
}
function workrensuplus(){
	var plus=$("#workaddrensu").html();
	$("#workaddrensu").html(Math.abs(plus) + 1)
	
}
function workkaitaiplus(){
	var plus=$("#workaddkaitai").html();
	$("#workaddkaitai").html(Math.abs(plus) + 1)
	
}

function workkaitaiminus(){
	var min=$("#workaddkaitai").html();
	if(min==0){
		return;
	}
	$("#workaddkaitai").html(Math.abs(min) - 1)
}

$(document).ready(
		function() {
			$("#workworkwuxianmoveBar").css("top", $(document).scrollTop()+150 );
			$("#workwuxianmoveBar").css("position","fixed" );
			$("#workwuxianmoveBar").css("bottom","0" );
			$("#workwuxianmoveBar").css("right","0" );
			$("#workwuxianbanner").css("font-size","18" );
			$('#workwuxianbanner').mousedown(
				function(event) {
					var isMove = true;
					var abs_x = event.pageX - $('div.workwuxianmoveBar').offset().left;
					var abs_y = event.pageY - $('div.workwuxianmoveBar').offset().top;
					$(document).mousemove(function(event) {
						if (isMove) {
							var obj = $('div.workwuxianmoveBar');
							obj.css({
								'left': event.pageX - abs_x,
								'top': event.pageY - abs_y
							});
						}
					}).mouseup(
						function() {
							isMove = false;
						}
					);
				}
			);
		}
	);