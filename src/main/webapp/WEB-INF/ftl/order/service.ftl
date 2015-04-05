<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
		<title>无线点餐-订单列表</title>
		<link rel="stylesheet" href="${BasePath}/res/css/css.css" />
		<script src="${BasePath}/res/wangcao/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(document).ready(function(){
					$("#service").hide();
					$("#check").hide();
					$(".service_icon").click(function(){
						$("#service").show();
						setTimeout(function(){
							$("#service").hide();
						},3000);
					});
				});
				
			function check(){
				$("#check").show();
				setTimeout(function(){
							$("#check").hide();
						},20000);
			}
				
		</script>
		<style type="text/css">
			table{
				border: 1px solid #000000;
				font-size: 2em;
				width: 60%;
				text-align: center;
				
				height: auto;
				
			}
			table tr{
				height: 50px;
			}
			table td{
				
				height: 30px;
			}
			#head{
				text-align: center;
			}
			#total{
				text-align: right;
			}
			#orderId{
				text-align: left;
			}
		</style>
	</head>
	<body>
		<div class="tips" id="service"><em class="tips_icon"></em>您已呼叫人工服务，请稍候...</div>
		<div class="tips" id="check" style="width: 350px;" >
			<em class="tips_icon"></em>您已发出结账请求，请稍候,服务员马上就到!
		</div>
		<div class="page">
			<div class="header">
				<div class="top"><h2>我的菜单</h2></div>
			</div>
			<div class="container">
				<div class="main">
					<table align="center" >
						<tr><td colspan="3" ><h3>我的订单</h3></td></tr>
						<tr id="orderId"><td colspan="3">订单号:${myOrder.id}</td></tr>
						<#list orderList as goods >	
						<tr><td>${goods.name}</td><td>×&nbsp;${goods.qty}</td><td >${goods.price}元/份</td></tr>
						</#list>
						<tr id="total"><td>共${myOrder.goodsNum}份美食</td><td colspan="2">总价格:${myOrder.totalPrice}元</td></tr>
					</table>
					<div class="submit" ><a href="#" style="color: #000000; tab-size: 1em; background-color: #FFFFFF; width: 60%; " >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;温馨提示：请记住您的订单号，便于结账时查询</a></div>
				</div>
			</div>
			<div class="copy">©2014一百英尺 </div>
			<div class="bottom_nav">
				<ul>
					<li><a href="${BasePath}/order/goodslist"><em class="home_icon"></em>主页</a></li>
					<li><a href="#"><em class="menu_icon"></em>我的菜单</a></li>
					<li><a href="#" class="cur"><em class="service_icon"></em>人工服务</a></li>
					<li><a href="#"><em class="order_icon" onclick="check();"></em>结账</a></li>
				</ul>
			</div>
		</div>
	</body>
</html>
