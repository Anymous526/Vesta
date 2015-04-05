	
	//顾客结账
		function account(id){
			var date=$("#date"+id).text();
			var deskNo=$("#deskNo"+id).text();
			var totalPrice=$("#totalPrice"+id).text();
			var payment=$("#payment"+id).text();
			
			$.post("account",{"id":id},function(returnData,status){
			var html="<table class='accountlist'><tr ><td class='p_1' colspan='2' >单号:<input type='text' name='orderId' id='orderId' readonly='readonly' value='"+id+"'></input></td>"
  			+"<td class='p_1' colspan='2'>支付方式:<select><option>现金</option><option>农业银行</option><option>中国银行</option><option>工商银行</option></select></td>"
  			+"<td class='p_1' colspan='2'>日期:"+date+"</td></tr><tr><td class='p_2' colspan='6'>桌编号:<input type='text'  name='deskNo' id='deskNo' readonly='readonly' value='"+deskNo+"'></input></td></tr>"
  			+"<tr><th></th><th>菜名</th><th>单位</th><th>单价</th><th>数量</th><th></th></tr>";
				for(var i=0;i<returnData.length;i++){
					var goodsvo=returnData[i];
					var name=goodsvo.name;
					var price=goodsvo.price;
					var qty=goodsvo.qty;
					html+="<tr><td class='p_4' ></td><td>"+name+"</td><td>份</td><td>"+price+"</td><td>"+qty+"</td><td></td><tr>";
				}
				
				var all=totalPrice;		
		html+="<tr ><td class='p_3' colspan='2'>消费金额:"+totalPrice+"元</td><td class='p_3' colspan='2'>包厢费:0元</td><td class='p_3' colspan='2'>金额合计:"+all+"元</td></tr>"
  		+"<tr ><td class='p_3' colspan='2'>定金:"+payment+"元</td><td class='p_3' colspan='2'>优惠价:0元</td><td class='p_3' colspan='2'>应付金额:"+all+"元</td></tr>"
  		+"<tr ><td class='p_3'  colspan='2'><input id='income' type='text' hidden='hidden' style='width: 40px;'/></td><td class='p_3'  colspan='2'><i id='zero' ></i></td><td class='p_3'  colspan='2'>操作员:超级用户</td></tr></table>";
				
				
					//清理以前的数据
					$("#table_2 table:eq(0)").remove();
					//添加新的
					$("#table_2").append(html);
					
			
			});		
				$("#check").show();	
				$("#income").focusout(function(){
			  		var inc=$("#income").val();
			  		alert(inc);
			  	});
			  	
				/**
				$("#income").onfocusout(function(){
					var income=	$("#income").html();
					alert(income);
					alert("1");
				});
				var zero=payment+income-totalPrice;
				*/
			}
	
		