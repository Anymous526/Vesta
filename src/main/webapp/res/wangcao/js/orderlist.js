
//订单详情
function account(id){
		$("#oid").text(id);
		var deskNum=$("#deskNo"+id).text();
		$("#deskNo").text(deskNum);
		var time=$("#date"+id).text();
		$("#ordertime").text(time);
		
		var pno=$("#person"+id).text();
		$("#pno").text(pno);
		
		
	$.post("account",{"id":id},function(returnData,status){
	var html="<input id='id' name='id' value='"+id+"' hidden='hidden'/><table class='goodslist'><tr id='t_tr'><td>菜名</td><td>数量</td><td>味道</td><td>单价</td></tr>";
	var totalQty=0;
	var totalPrice=0;
		for(var i=0;i<returnData.length;i++){
			var goodsvo=returnData[i];
			var name=goodsvo.name;
			var price=goodsvo.price;
			var qty=goodsvo.qty;
			var taste=goodsvo.taste;
			totalQty=totalQty+qty;
			totalPrice=totalPrice+qty*price;
			html+="<tr id='t_tr' class='goods_list'><td>"+name+"</td><td>x"+qty+"份</td><td>"+taste+"</td><td>"+price+"元/份</td><tr>";
		}		
//html+="<tr id='tr_r'><td colspan='2'>美食数量:</td><td class='toal' id='td_c' >"+totalQty+"份</td></tr><tr id='tr_r'><td colspan='2'>总价格:</td><td class='total' id='td_c'>"+totalPrice+"元</td></tr><tr id='tr_r'><td class='toal' colspan='2'>消费合计:</td><td id='td_c'>"+totalPrice+"元</td></tr><tr id='tr_r'><td class='toal' colspan='2'>付款金额:</td><td id='td_c'>"+totalPrice+"元</td></tr></table>";
 html+="</table>";
	//清理以前的数据
	$("#order_1 table:eq(0)").remove();
		//添加新的
	$("#order_1").append(html);
});

		
		$("#check").show();	
		
	}




	//对订单的操作
	function cancel(id){
	$("#demo"+id).hide();
	$.post("del",{"id":id},function(returnData,status){
		alert("1");
	});
}


function del(id){
	 var r = window.confirm("确定要删除此订单吗？\r\n删除后将不能恢复");
        if(r){
        window.location.href="delOrderList?id="+id;
        }
}



