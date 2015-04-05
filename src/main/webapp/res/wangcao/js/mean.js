//添加商品,用ajax异步动态生成商品列表
	function addgoods(id){
	$.post("add",{"id":id},function(returnData,status){
		
		var html="<table class='order_table'>";
			var totalQty=0;
			var totalPrice=0;
				for(var i=0;i<returnData.length;i++){
					var goodsvo=returnData[i];
					var id=goodsvo.id;
					var name=goodsvo.name;
					var price=goodsvo.price;
					var qty=goodsvo.qty;
					totalQty=totalQty+qty;
					totalPrice=totalPrice+qty*price;
					html+="<tr id='div"+id+"'><td class='order_table_td_1'>"+name+"</td>"
					+"<td class='order_table_td_2'>"+price+"元</td>"
					+"<td class='order_table_td_3'>&nbsp;x<a id='demo"+id+"' name='goodsNum'>"+qty+"</a>份</td>"
					+"<td class='order_table_td_4'><div class='menu_box' ><div class='menu_delete' ><a href='#' name='price'  onclick='removeGoods("+id+","+price+");' ><h1 style='margin: 1px;' title='删除'>x</h1></a></div>"
					+"</td></tr>";
					/***
					 * +"<div class='menu_btn'><a href='#'  class='l_btn' onclick='subGoods("+id+","+price+");'><h1 style='margin: 1px;' title='减少'>-</h1></a>"
					+"<a href='#' class='r_btn' onclick='addGoods("+id+","+price+");' ><h1 style='margin: 1px;' title='添加'>+</h1></a></div></div>
					 * */
				}		
		html+="<tr ><td class='order_table_total' colspan='2'>共<i id='qty'>"+totalQty+"</i>份美食</td><td class='order_table_total' colspan='2'>总价:<i id='totalPrice' name='totalPrice'>"+totalPrice+"</i>元</td></tr></table>";
		
			//清理以前的数据
			$("#order_table1 table:eq(0)").remove();
				//添加新的
			$("#order_table1").append(html);
	});
	
	
	}
	
	//订单中添加商品数量			
	function addGoods(num,price){
		
		var number=$("#demo"+num).text();
			number++;
		$.ajax({
          type: "post",
          url: "addqty",
          cache:false,
          data: "id="+num+","+number,
          dataType:'json',
          success:function(json){
          alert(json[0].id+""+json[0].number);
          }
    }); 	
    		var pric= parseFloat(price);
			var totalPrice= parseFloat($("#totalPrice").html());
			var qty=parseInt($("#qty").html());
				qty++;
				totalPrice=totalPrice+pric;
	    	document.getElementById("totalPrice").innerHTML=totalPrice; 
	    	document.getElementById("qty").innerHTML=qty; 
	    	document.getElementById("demo"+num).innerHTML=number; 
    
}

//订单中减少商品数量		
	function subGoods(num,price){
		var number=$("#demo"+num).text();
			if(number>1){
				number--;
			 $.ajax({
          type: "post",
          url: "subqty",
          cache:false,
          data: "id="+num+","+number,
          dataType:'json',
          success:function(json){
          alert(json[0].id+""+json[0].number);
          }
    }); 	
    		var pric= parseFloat(price);
			var totalPrice= parseFloat($("#totalPrice").html());
			var qty=parseInt($("#qty").html());
				qty--;
				totalPrice=totalPrice-pric;
	    	document.getElementById("totalPrice").innerHTML=totalPrice; 
	    	document.getElementById("qty").innerHTML=qty; 
	    	document.getElementById("demo"+num).innerHTML=number; 
    }else{
    	alert("对不起，不能减了，但可以删除!");
    }
}
//从订单中删除商品
function removeGoods(id,price){
		
		//对象的份数
		var number=$("#demo"+id).text();
		//对象的单价
		var pric= parseFloat(price);
		//所有对象的总价
		var totalPrice= parseFloat($("#totalPrice").html());
		//所有对象的总份数
		var qty=parseInt($("#qty").html());
		qty=qty-number;
		totalPrice=totalPrice- parseFloat(parseInt(number)*pric);
		 $.ajax({
          type: "post",
          url: "removegoods",
          cache:false,
          data: "id="+id,
          dataType:'json',
          success:function(json){
          alert(json[0].id+""+json[0].number);
          }
    }); 	
		
		$("#div"+id).remove();
		document.getElementById("totalPrice").innerHTML=totalPrice; 
	    document.getElementById("qty").innerHTML=qty; 
		
	}

	
		//提交订单时是否选择桌位的判断
		function check(){
			var id=$("#deskId").val();
			if(id!=null){
				$("#form1").submit();				
			}else{
				$("#span1").html("请先开台，再点餐");
			}
			
		}
		
		
		
		
		
		
		
		
		