
function click_hidden(index){
		var one_index_value=$("#one_list_length").html();	
		for (var int = 1; int <= one_index_value; int++) {
			if(index==int){
				$("#li"+int+"div").show();
			}else{
				$("#li"+int+"div").hide();
			}
		}

}


function click_hidden2(index){
	var two_list_length=$("#two_list_length").html();	
	for (var int = 1; int <= two_list_length; int++) {
		if(index==int){
			$("#2li"+int+"div").show();
		}else{
			$("#2li"+int+"div").hide();
		}
	}
	

}
function click_hidden3(index){
	var three_list_length=$("#three_list_length").html();	
	for (var int = 1; int <= three_list_length; int++) {
		if(index==int){
			$("#3li"+int+"div").show();
		}else{
			$("#3li"+int+"div").hide();
		}
	}
	

}
/***
 * 删除按钮
 * **/

function click_del(int){
	
	var price = $("#d"+int+"font2").html();
	$("#d"+int+"font1").html(0)
	$("#li"+int+"divrange"+int).html(0);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#d0price").html(li1divrange1nums);
	$("#pd"+int).hide();
	
}
function click_del2(int){
	var price = $("#2d"+int+"font2").html();
	$("#2d"+int+"font1").html(0);
	$("#2li"+int+"divrange"+int).html(0);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#d0price").html(li1divrange1nums);
	$("#p2d"+int).hide();
	
}
function click_del3(int){
	var price = $("#3d"+int+"font2").html();
	$("#3d"+int+"font1").html(0);
	$("#3li"+int+"divrange"+int).html(0);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#d0price").html(li1divrange1nums);
	$("#p3d"+int).hide();
	
}


/**订单显示隐藏***/
function  pclick_hidden(index){
	var one=$("#one_list_length").html();
	var two=$("#two_list_length").html();
	var three=$("#three_list_length").html();
	for (var int = 1; int <= one; int++) {
		 if(index==int){
			 $("#d"+int+"li1div").show();
		 }else{
			 $("#d"+int+"li1div").hide();
		 }
	}
	for (var int = 1; int <= two; int++) {
		$("#2d"+int+"li1div").hide();
	}
	for (var int = 1; int <= three; int++) {
		 $("#3d"+int+"li1div").hide();
	}
	
}
function  pclick_hidden2(index){
	var one=$("#one_list_length").html();
	var two=$("#two_list_length").html();
	var three=$("#three_list_length").html();
	for (var int = 1; int <= one; int++) {
		$("#d"+int+"li1div").hide();
	}
	for (var int = 1; int <= two; int++) {
		 if(index==int){
			 $("#2d"+int+"li1div").show();
		 }else{
			 $("#2d"+int+"li1div").hide();
		 }
	}
	for (var int = 1; int <= three; int++) {
		 $("#3d"+int+"li1div").hide();
	}
	
}

function  pclick_hidden3(index){
	var one=$("#one_list_length").html();
	var two=$("#two_list_length").html();
	var three=$("#three_list_length").html();
	for (var int = 1; int <= one; int++) {
		$("#d"+int+"li1div").hide();
	}
	for (var int = 1; int <= two; int++) {
		 $("#2d"+int+"li1div").hide();
	}
	for (var int = 1; int <= three; int++) {
		 if(index==int){
			 $("#3d"+int+"li1div").show();
		 }else{
			 $("#3d"+int+"li1div").hide();
		 }
	}
	
}
/***增加、减少按钮***/
function click_min(int){
	var min=$("#d"+int+"font1").html()-1;
	if(min==0){
		return;
	}
	$("#d"+int+"font1").html(min);
	var value=$("#d"+int+"font2").html();
	var price = $("#d"+int+"font3").html();
	$("#d"+int+"font2").html(Math.abs(value) - Math.abs(price))
	$("#li"+int+"divrange"+int).html(min);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#d0price").html(li1divrange1nums);
	
	
}
function click_min2(int){
	var min=$("#2d"+int+"font1").html()-1;
	if(min==0){
		return;
	}
	$("#2d"+int+"font1").html(min);
	var value=$("#2d"+int+"font2").html();
	var price = $("#2d"+int+"font3").html();
	$("#2d"+int+"font2").html(Math.abs(value) - Math.abs(price))
	$("#2li"+int+"divrange"+int).html(min);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#d0price").html(li1divrange1nums);
}
function click_min3(int){
	var min=$("#3d"+int+"font1").html()-1;
	if(min==0){
		return;
	}
	$("#3d"+int+"font1").html(min);
	var value=$("#3d"+int+"font2").html();
	var price = $("#3d"+int+"font3").html();
	$("#3d"+int+"font2").html(Math.abs(value) - Math.abs(price))
	$("#3li"+int+"divrange"+int).html(min);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) - Math.abs(price);
	$("#d0price").html(li1divrange1nums);
}
function click_plus(int){

	
	//-----------------------------------
	var add = $("#d"+int+"font1").html();
	$("#d"+int+"font1").html(++add);
	var value=$("#d"+int+"font2").html();
	var price = $("#d"+int+"font3").html();
	$("#d"+int+"font2").html(Math.abs(value) + Math.abs(price))
	$("#li"+int+"divrange"+int).html(++add);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess) + Math.abs(price);
	$("#d0price").html(li1divrange1nums);
}
function click_plus2(int){
	var add=$("#2d"+int+"font1").html();
	$("#2d"+int+"font1").html(++add);
	var value=$("#2d"+int+"font2").html();
	var price = $("#2d"+int+"font3").html();
	$("#2d"+int+"font2").html(Math.abs(value) + Math.abs(price))
	$("#2li"+int+"divrange"+int).html(++add);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess)  + Math.abs(price);
	$("#d0price").html(li1divrange1nums);

}
function click_plus3(int){
	var add=$("#3d"+int+"font1").html();
	$("#3d"+int+"font1").html(++add);
	var value=$("#3d"+int+"font2").html();
	var price = $("#3d"+int+"font3").html();
	$("#3d"+int+"font2").html(Math.abs(value) + Math.abs(price))
	$("#3li"+int+"divrange"+int).html(++add);
	var pricess = $("#d0price").html();
	var li1divrange1nums = Math.abs(pricess)  + Math.abs(price);
	$("#d0price").html(li1divrange1nums);

}


/** *加载订单* */
function onepage2(){
	var one=$("#one_list_length").html();
	var two=$("#two_list_length").html();
	var three=$("#three_list_length").html();
	for (var int = 1; int <= one; int++) {
		 $("#li"+int+"divrange"+int).html();
		 if($("#li"+int+"divrange"+int).html()>0){
			 //辣椒
			 var lajia=$("input[name='radio-choice-h-1-"+int+"'][checked]").val();
			 if(lajia==1){
				 $("#radio-choice-dh-1a"+int).attr("checked",true); 
			 }
			 if(lajia==2){
				 $("#radio-choice-dh-1b"+int).attr("checked",true); 
			 }
			 if(lajia==3){
				 $("#radio-choice-dh-1c"+int).attr("checked",true); 
			 }
			 $("#d"+int+"font1").html($("#li"+int+"divrange"+int).html());
				$("#d"+int+"font2").html($("#li"+int+"divrange"+int).html() * $("#liprice"+int).html());
				var li1divrange1price = $("#d0price").html();
				var li1divrange1num = $("#d"+int+"font2").html();
				var li1divrange1nums = Math.abs(li1divrange1price)
						+ Math.abs(li1divrange1num);
				$("#d0price").html(li1divrange1nums);
				$("#pd"+int).show();
		 }else{
				 if( $("#d"+int+"font1").html()>0){
				    $("#d"+int+"font1").html(0);
					$("#d"+int+"font2").html(0);
					$("#pd"+int).hide();
			 }
		 }
		
	}
	for (var int = 1; int <= two; int++) {
		 $("#2li"+int+"divrange"+int).html();
		 if($("#2li"+int+"divrange"+int).html()>0){
			 //辣椒
			 var lajia=$("input[name='radio-choice-h-2-"+int+"'][checked]").val();
			 if(lajia==1){
				 $("#radio-choice-dh-2a"+int).attr("checked",true); 
			 }
			 if(lajia==2){
				 $("#radio-choice-dh-2b"+int).attr("checked",true); 
			 }
			 if(lajia==3){
				 $("#radio-choice-dh-2c"+int).attr("checked",true); 
			 }
			 
			 $("#2d"+int+"font1").html($("#2li"+int+"divrange"+int).html());
				$("#2d"+int+"font2").html($("#2li"+int+"divrange"+int).html() * $("#li2price"+int).html());
				var li1divrange1price = $("#d0price").html();
				var li1divrange1num = $("#2d"+int+"font2").html();
				var li1divrange1nums = Math.abs(li1divrange1price)
						+ Math.abs(li1divrange1num);
				$("#d0price").html(li1divrange1nums);
				$("#p2d"+int).show();
		 }else{
			 if( $("#2d"+int+"font1").html()>0){
				    $("#2d"+int+"font1").html(0);
					$("#2d"+int+"font2").html(0);
					$("#p2d"+int).hide();
			 }
		 }
	}
	for (var int = 1; int <= three; int++) {
		 $("#3li"+int+"divrange"+int).html();
		 if($("#3li"+int+"divrange"+int).html()>0){
			 //辣椒
			 var lajia=$("input[name='radio-choice-h-3-"+int+"'][checked]").val();
			 if(lajia==1){
				 $("#radio-choice-dh-3a"+int).attr("checked",true); 
			 }
			 if(lajia==2){
				 $("#radio-choice-dh-3b"+int).attr("checked",true); 
			 }
			 if(lajia==3){
				 $("#radio-choice-dh-3c"+int).attr("checked",true); 
			 }
			 
			 $("#3d"+int+"font1").html($("#3li"+int+"divrange"+int).html());
				$("#3d"+int+"font2").html($("#3li"+int+"divrange"+int).html() * $("#li3price"+int).html());
				var li1divrange1price = $("#d0price").html();
				var li1divrange1num = $("#3d"+int+"font2").html();
				var li1divrange1nums = Math.abs(li1divrange1price)
						+ Math.abs(li1divrange1num);
				$("#d0price").html(li1divrange1nums);
				$("#p3d"+int).show();
		 }else{
			 if( $("#3d"+int+"font1").html()>0){
				    $("#3d"+int+"font1").html(0);
					$("#3d"+int+"font2").html(0);
					$("#p3d"+int).hide();
			 }
		 }
	}
}


//单选 辣椒框
function radiochoiceh1a(index){
	$("#radio-choice-h-1a"+index).attr("checked",true); 
	$("#radio-choice-h-1b"+index).attr("checked",false); 
	$("#radio-choice-h-1c"+index).attr("checked",false); 
}

function radiochoiceh1b(index){
	$("#radio-choice-h-1a"+index).attr("checked",false); 
	$("#radio-choice-h-1b"+index).attr("checked",true); 
	$("#radio-choice-h-1c"+index).attr("checked",false); 
}
function radiochoiceh1c(index){
	$("#radio-choice-h-1a"+index).attr("checked",false); 
	$("#radio-choice-h-1b"+index).attr("checked",false); 
	$("#radio-choice-h-1c"+index).attr("checked",true); 
}
function radiochoiceh2a(index){
	$("#radio-choice-h-2a"+index).attr("checked",true); 
	$("#radio-choice-h-2b"+index).attr("checked",false); 
	$("#radio-choice-h-2c"+index).attr("checked",false); 
}
function radiochoiceh2b(index){
	$("#radio-choice-h-2a"+index).attr("checked",false); 
	$("#radio-choice-h-2b"+index).attr("checked",true); 
	$("#radio-choice-h-2c"+index).attr("checked",false); 
}
function radiochoiceh2c(index){
	$("#radio-choice-h-2a"+index).attr("checked",false); 
	$("#radio-choice-h-2b"+index).attr("checked",false); 
	$("#radio-choice-h-2c"+index).attr("checked",true); 
}

function radiochoiceh3a(index){
	$("#radio-choice-h-3a"+index).attr("checked",true); 
	$("#radio-choice-h-3b"+index).attr("checked",false); 
	$("#radio-choice-h-3c"+index).attr("checked",false); 
}
function radiochoiceh3b(index){
	$("#radio-choice-h-3a"+index).attr("checked",false); 
	$("#radio-choice-h-3b"+index).attr("checked",true); 
	$("#radio-choice-h-3c"+index).attr("checked",false); 
}
function radiochoiceh3c(index){
	$("#radio-choice-h-3a"+index).attr("checked",false); 
	$("#radio-choice-h-3b"+index).attr("checked",false); 
	$("#radio-choice-h-3c"+index).attr("checked",true); 
}



function radiochoicedh1a(index){
	$("#radio-choice-dh-1a"+index).attr("checked",true); 
	$("#radio-choice-dh-1b"+index).attr("checked",false); 
	$("#radio-choice-dh-1c"+index).attr("checked",false); 
}
function radiochoicedh1b(index){
	$("#radio-choice-dh-1a"+index).attr("checked",false); 
	$("#radio-choice-dh-1b"+index).attr("checked",true); 
	$("#radio-choice-dh-1c"+index).attr("checked",false); 
}
function radiochoicedh1c(index){
	$("#radio-choice-dh-1a"+index).attr("checked",false); 
	$("#radio-choice-dh-1b"+index).attr("checked",false); 
	$("#radio-choice-dh-1c"+index).attr("checked",true); 
}

function radiochoicedh2a(index){
	$("#radio-choice-dh-2a"+index).attr("checked",true); 
	$("#radio-choice-dh-2b"+index).attr("checked",false); 
	$("#radio-choice-dh-2c"+index).attr("checked",false); 
}


function radiochoicedh2b(index){
	$("#radio-choice-dh-2a"+index).attr("checked",false); 
	$("#radio-choice-dh-2b"+index).attr("checked",true); 
	$("#radio-choice-dh-2c"+index).attr("checked",false); 
}
function radiochoicedh2c(index){
	$("#radio-choice-dh-2a"+index).attr("checked",false); 
	$("#radio-choice-dh-2b"+index).attr("checked",false); 
	$("#radio-choice-dh-2c"+index).attr("checked",true); 
}

function radiochoicedh3a(index){
	$("#radio-choice-dh-3a"+index).attr("checked",true); 
	$("#radio-choice-dh-3b"+index).attr("checked",false); 
	$("#radio-choice-dh-3c"+index).attr("checked",false); 
}

function radiochoicedh3b(index){
	$("#radio-choice-dh-3a"+index).attr("checked",false); 
	$("#radio-choice-dh-3b"+index).attr("checked",true); 
	$("#radio-choice-dh-3c"+index).attr("checked",false); 
}
function radiochoicedh3c(index){
	$("#radio-choice-dh-3a"+index).attr("checked",false); 
	$("#radio-choice-dh-3b"+index).attr("checked",false); 
	$("#radio-choice-dh-3c"+index).attr("checked",true); 
}





//-----------------------------------------------

//选菜
function addGoodspage1(index){
	var i=$("#li"+index+"divrange"+index).html();
	$("#li"+index+"divrange"+index).html(Math.abs(i) +1);
	var j=$("#wuxianbanner font").html();
	$("#wuxianbanner font").html(Math.abs(j) +1);
	/*var oneInner = document.createElement("div");
	oneInner.setAttribute("class", "caidanxieru");
	oneInner.innerText=3;
	document.getElementById("one").appendChild(oneInner);*/
}

function minusGoodspage1(index){
	var i=$("#li"+index+"divrange"+index).html();
	if(i==0){
		return;
	}
	$("#li"+index+"divrange"+index).html(Math.abs(i) -1);
	var j=$("#wuxianbanner font").html();
	$("#wuxianbanner font").html(Math.abs(j) -1);

}
function addGoodspage2(index){
	var i=$("#2li"+index+"divrange"+index).html();
	$("#2li"+index+"divrange"+index).html(Math.abs(i) +1);
	var j=$("#wuxianbanner font").html();
	$("#wuxianbanner font").html(Math.abs(j) +1);
	//alert($("input[name='radio-choice-h-2-"+index+"'][checked]").val());
}
function minusGoodspage2(index){
	var i=$("#2li"+index+"divrange"+index).html();
	if(i==0){
		return;
	}
	$("#2li"+index+"divrange"+index).html(Math.abs(i) -1);
	var j=$("#wuxianbanner font").html();
	$("#wuxianbanner font").html(Math.abs(j) -1);
}

function addGoodspage3(index){
	var i=$("#3li"+index+"divrange"+index).html();
	$("#3li"+index+"divrange"+index).html(Math.abs(i) +1);
	var j=$("#wuxianbanner font").html();
	$("#wuxianbanner font").html(Math.abs(j) +1);
	//alert($("input[name='radio-choice-h-2-"+index+"'][checked]").val());
}
function minusGoodspage3(index){
	var i=$("#3li"+index+"divrange"+index).html();
	if(i==0){
		return;
	}
	$("#3li"+index+"divrange"+index).html(Math.abs(i) -1);
	var j=$("#wuxianbanner font").html();
	$("#wuxianbanner font").html(Math.abs(j) -1);
}
//-------------------------------


//商品订购
/**
function addGoods(id,index){
	var qty=$("#li"+index+"divrange"+index).val();
	alert(qty);
	$.ajax({
		type: "post",
		url: "addGoods",
		cache:false,
		data: "id="+id+","+qty,
		dataType:'json',
		success:function(json){
			alert(json[0].id+""+json[0].number);
		}
	});
}

*/

$(document).ready(
		function() {
			$("#wuxianmoveBar").css("top", $(document).scrollTop()+150 );
			$("#wuxianmoveBar").css("position","fixed" );
			$("#wuxianmoveBar").css("bottom","0" );
			$("#wuxianmoveBar").css("right","0" );
			$("#wuxianbanner").css("font-size","18" );
			$('#wuxianbanner').mousedown(
				function(event) {
					var isMove = true;
					var abs_x = event.pageX - $('div.wuxianmoveBar').offset().left;
					var abs_y = event.pageY - $('div.wuxianmoveBar').offset().top;
					$(document).mousemove(function(event) {
						if (isMove) {
							var obj = $('div.wuxianmoveBar');
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











