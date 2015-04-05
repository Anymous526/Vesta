<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
		
		<title>无线点餐-客户端</title>
		<link href="${BasePath}/res/css/css.css" rel="stylesheet" type="text/css" media="screen"/>
		<script src="${BasePath}/res/wangcao/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			//人工服务
					$("#tips").hide();
					$("#check").hide();
					$(".service_icon").click(function(){
						$("#tips").show();
						setTimeout(function(){
							$("#tips").hide();
						},2000);
					});
					
				//全部显示
		 	$("#two1").mouseover(function(){
			$("div[id^=con_two_]").show();
			});
			//部分显示 0
			$("#two2").mouseover(function(){
				$("div[id^=con_two_]").hide();
				$("#con_two_2").show();		
			});
			//1
			$("#two3").mouseover(function(){
				$("div[id^=con_two_]").hide();
				$("#con_two_3").show();		
			});
			//2
			$("#two4").mouseover(function(){
				$("div[id^=con_two_]").hide();
				$("#con_two_4").show();		
			});
			//3
			$("#two5").mouseover(function(){
				$("div[id^=con_two_]").hide();
				$("#con_two_5").show();		
			});	
			//3
			$("#two6").mouseover(function(){
				$("div[id^=con_two_]").hide();
				$("#con_two_6").show();		
			});		
				
								
				});
		
		
	//减少商品
	function sub(num){
		var number=$("#demo"+num).html();
		if(number>0){
			number--;	
		}
		alert(number);
		 $.ajax({
          type: "post",
          url: "${BasePath}/order/delete",
          cache:false,
          data: "id="+num+","+number,
          dataType:'json',
          success:function(json){
          alert(json[0].id+""+json[0].number);
          }
    }); 
		document.getElementById("demo"+num).innerHTML=number;
		
		}
		
		//(1)从页面获得当前数据，并添加数据,并将添加后的数据显示到页面 
		//(2)将商品的信息 id,num通过异步传输提交到controller保存
				
		function add(num){
		var number=$("#demo"+num).html();
			number++;	
		 $.ajax({
          type: "post",
          url: "${BasePath}/order/add",
          cache:false,
          data: "id="+num+","+number,
          dataType:'json',
          success:function(json){
          alert(json[0].id+""+json[0].number);
          }
    }); 
		document.getElementById("demo"+num).innerHTML=number;
		
		}
		
		function check(){
				$("#check").show();
				setTimeout(function(){
							$("#check").hide();
						},20000);
			}

</script>
	</head>
	
	<body>
		<div class="tips" id="tips"><em class="tips_icon"></em>您已呼叫人工服务，请稍候...</div>
		<div class="tips" id="check" style="width: 300px;" >
			<form action="${BasePath}/order/findOrder" method="post">
					订单号&nbsp;&nbsp;<input type="text" name="id" value="请输入订单号" />	
					<input type="submit" value="提交"/>
			</form>
		</div>
		<div class="page">
			<div class="header">
				<div class="top"><h2>下酒菜</h2></div>
				<div class="nav">
			    	<ul>
			    		<li><a id="two1" href="#" class="cur">全部菜品</a></li>
			    		<li><a id="two2"  href="#" class="cur">特色</a></li>
			    		<li><a id="two3"  href="#" class="cur">主食</a></li>
			    		<li><a id="two4"  href="#" class="cur">热菜</a></li>
			    		<li><a id="two5"  href="#" class="cur">凉菜</a></li>
			    		<li><a id="two6"  href="#" class="cur">酒水</a></li>
				</ul>
			    </div>
			</div>
			<div class="wrap" id="con_two_2">
				<#list goodsVoList as goods>
				  <#if goods.type ==1 >
				<div class="food">
					<div class="food_pic"><img style="width: 90px; height: 80px;" src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}" /></div>
					<div class="food_title">
						<h3>${goods.name!''}</h3>
						<p class="food_info">${goods.introduce!''}</p>
						<div class="food_price">
							<h1>￥${goods.price!''}</h1>
							<div class="quantity">
								<div class="minus" id="minus"  onclick="sub(${goods.id});"><a href="#"></a></div>
								<div class="number"  id="demo${goods.id}">
								${goods.qty}
								</div>
								<div class="plus" onclick="add(${goods.id});"><a href="#"></a></div>
							</div>
						</div>
					</div>
				</div>
				</#if>
				</#list>				
			</div>
			
			
			<div class="wrap" id="con_two_3">
				<#list goodsVoList as goods>
				  <#if goods.type == 2>
				<div class="food">
					<div class="food_pic"><img style="width: 90px; height: 80px;" src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/></div>
					<div class="food_title">
						<h3>${goods.name!''}</h3>
						<p class="food_info">${goods.introduce!''}</p>
						<div class="food_price">
							<h1>￥${goods.price!''}</h1>
							<div class="quantity">
								<div class="minus" id="minus"  onclick="sub(${goods.id});"><a href="#"></a></div>
								<div class="number"  id="demo${goods.id}">
								${goods.qty}  
								</div>
								<div class="plus" onclick="add(${goods.id});"><a href="#"></a></div>
							</div>
						</div>
					</div>
				</div>
				</#if>
				</#list>				
			</div>
			
			<div class="wrap" id="con_two_4">
				<#list goodsVoList as goods>
				  <#if goods.type == 3>
				<div class="food">
					<div class="food_pic"><img style="width: 90px; height: 80px;" src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}" /></div>
					<div class="food_title">
						<h3>${goods.name!''}</h3>
						<p class="food_info">${goods.introduce!''}</p>
						<div class="food_price">
							<h1>￥${goods.price!''}</h1>
							<div class="quantity">
								<div class="minus" id="minus"  onclick="sub(${goods.id});"><a href="#"></a></div>
								<div class="number"  id="demo${goods.id}">
								 ${goods.qty}
								</div>
								<div class="plus" onclick="add(${goods.id});"><a href="#"></a></div>
							</div>
						</div>
					</div>
				</div>
				</#if>
				</#list>				
			</div>
			
			<div class="wrap" id="con_two_5">
				<#list goodsVoList as goods>
				  <#if goods.type == 4>
				<div class="food">
					<div class="food_pic"><img style="width: 90px; height: 80px;" src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}" /></div>
					<div class="food_title">
						<h3>${goods.name!''}</h3>
						<p class="food_info">${goods.introduce!''}</p>
						<div class="food_price">
							<h1>￥${goods.price!''}</h1>
							<div class="quantity">
								<div class="minus" id="minus"  onclick="sub(${goods.id});"><a href="#"></a></div>
								<div class="number"  id="demo${goods.id}">
								 ${goods.qty}
								</div>
								<div class="plus" onclick="add(${goods.id});"><a href="#"></a></div>
							</div>
						</div>
					</div>
				</div>
				</#if>
				</#list>				
			</div>
			
			<div class="wrap" id="con_two_6">
				<#list goodsVoList as goods>
				  <#if goods.type == 5>
				<div class="food">
					<div class="food_pic"><img style="width: 130px; height: 80px;" src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}" /></div>
					<div class="food_title">
						<h3>${goods.name!''}</h3>
						<p class="food_info">${goods.introduce!''}</p>
						<div class="food_price">
							<h1>￥${goods.price!''}</h1>
							<div class="quantity">
								<div class="minus" id="minus"  onclick="sub(${goods.id});"><a href="#"></a></div>
								<div class="number"  id="demo${goods.id}">
								 ${goods.qty}
								</div>
								<div class="plus" onclick="add(${goods.id});"><a href="#"></a></div>
							</div>
						</div>
					</div>
				</div>
				</#if>
				</#list>				
			</div>
			
			<div class="copy">©2014一百英尺 </div>
			<div class="menu_icon02">
				<em><a href="${BasePath}/order/toOrder"></a></em>
				<font>99</font>
			</div>
			<div class="bottom_nav">
				<ul>
					<li><a href="#" class="cur"><em class="home_icon"></em>主页</a></li>
					<li><a href="${BasePath}/order/toOrder"><em class="menu_icon"></em>我的菜单</a></li>
					<li><a href="#"><em class="service_icon"></em>人工服务</a></li>
					<li><a href="#" onclick="check();"><em class="order_icon"></em>结账</a></li>
				</ul>
			</div>
		</div>
	</body>
</html>
