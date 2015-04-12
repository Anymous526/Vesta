<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
		<title>无线点餐-订单</title>
		<link rel="stylesheet" href="${BasePath}/res/css/css.css" />
		<script src="${BasePath}/res/wangcao/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(document).ready(function(){
					//$("input").hide();
				//人工服务
					$(".tips").hide();
					$(".service_icon").click(function(){
						$(".tips").show();
						setTimeout(function(){
							$(".tips").hide();
						},2000);
					});
					
			});
					//添加商品数量			
	function addGoods(num,price){
		var number=$("#demo"+num).text();
			number++;
			 $.ajax({
          type: "post",
          url: "${BasePath}/order/addqty",
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
		
						//减少商品数量			
	function subGoods(num,price){
		var number=$("#demo"+num).text();
			if(number>1){
				number--;
			 $.ajax({
          type: "post",
          url: "${BasePath}/order/subqty",
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
	//删除				
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
          url: "${BasePath}/order/removegoods",
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
					
		function submitform(){
		var str="ok";
			 $.ajax({
          type: "post",
          url: "${BasePath}/order/submitorder",
          cache:false,
          data: "id="+str,
          dataType:'json',
          success:function(json){
          alert(json[0].id+""+json[0].number);
          }
    }); 
    
    alert("订单已生成!");	
		}			
					
					
			
		</script>
	</head>
	<body>
		<div class="tips"><em class="tips_icon"></em>您已呼叫人工服务，请稍候...</div>
		<div class="page">
			<div class="header">
				<div class="top"><a href="${BasePath}/order/goodslist"><em class="top_back"></em>返回</a><h2>我的菜单</h2></div>
			</div>
	<form  method="post">
			<div class="container">
				<div class="main">
					<ul>
					
						<#list goodsVoLists as goods >											         								        
								        <li id="div${goods.id}">								
											<a href="#" id="menu_a${goods.id}" onclick="push(${goods.id});">
											<div class="menu_list"  id="menu_list${goods.id}" >												
												<div class="menu_title" id="name">${goods.name}</div>
												<div class="menu_number"  >×&nbsp;<a id="demo${goods.id}" name="goodsNum"> ${goods.qty}</a></div>
												<div class="menu_price"><strong>${goods.price}</strong> 元/份</div>
											</div>
											</a>
											<div class="menu_box" id="menu_box${goods.id}">
													<div class="menu_delete" >
														<a href="#" name="price"  onclick="removeGoods(${goods.id},${goods.price});"></a>
													</div>
													<div class="menu_btn">
														<a href="#" class="l_btn" onclick="subGoods(${goods.id},${goods.price});" ></a>
														<a href="#" class="r_btn"  onclick="addGoods(${goods.id},${goods.price});"></a>
													</div>
											</div>
										</li>																	
						</#list>	
					</ul>
				</div>
				<p class="total_price">共&nbsp;<i id="qty">${myOrder.goodsNum}</i>&nbsp;份美食   <strong><i id="totalPrice" name="totalPrice">${myOrder.totalPrice}</i></strong>&nbsp;元</p>
				<div class="submit"><a href="${BasePath}/order/submitorder"; onclick="submitform();">提交菜单</a></div>
			</div>
			</form>  		
			<div class="copy">©2014一百英尺 </div>
			<div class="bottom_nav">
				<ul>
					<li><a href="${BasePath}/order/goodslist"><em class="home_icon"></em>主页</a></li>
					<li><a href="#" class="cur"><em class="menu_icon"></em>我的菜单</a></li>
					<li><a href="#"><em class="service_icon"></em>人工服务</a></li>
					<li><a href="#"><em class="order_icon"></em>结账</a></li>
				</ul>
			</div>
		</div>
	</body>
</html>
