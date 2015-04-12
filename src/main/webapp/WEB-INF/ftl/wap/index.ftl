<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${BasePath}/res/wap/js/jquery-2.1.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" href="${BasePath}/res/wap/css/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="${BasePath}/res/wap/css/main.css" />
<link rel="stylesheet" href="${BasePath}/res/wap/css/css.css" />
<script src="${BasePath}/res/wap/js/jquery.mobile-1.4.5.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/order.js" type="text/javascript" charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/wap.js" type="text/javascript" charset="utf-8"></script>

		
</head>
<body>
	<div id="page-1" data-role="page">
	<span id="deskNo" style="display: none;"></span>
		<div data-role="header"
			style="background-color: azimuth; font-style: color: white;"
			data-iconshadow="true" data-transition="slide" data-fullscreen="true">
			<img alt="logo1" src="${BasePath}/res/wap/img/logo1.png"
				style="width: 100%; height: 50px;">
			<h1>
				<font style="font-family: Georgia;">美食美客</font>
			</h1>
		</div>
		<div data-role="content">
		<!--
		<div data-role="navbar">
					<ul class="ui-body-d">
						<li><a href="#" data-icon="plus">更多</a>
						</li>
						<li><a href="#" data-icon="minus">更少</a>
						</li>
						<li><a href="#" data-icon="delete">删除</a>
						</li>
						<li><a href="#" data-icon="check">喜爱</a>
						</li>
						<li><a href="#" data-icon="info">信息</a>
						</li>
					</ul>
				</div>
			-->	
			<div data-role="tabs" id="tabs">
				<div data-role="navbar" > <!-- data-iconpos="left" -->
					<ul class="ui-body-d ui-content">
						<li>
							<a href="#one" data-ajax="false" class="ui-btn-active" data-icon="location">肉类</a>
						</li>
						<li>
							<a href="#three" data-ajax="false" data-icon="location">蔬菜</a>
						</li>
						
						<li>
							<a href="#two" data-ajax="false" data-icon="location">酒水</a>
						</li>
						<li>
							<a href="#two" data-ajax="false" data-icon="location">烟草</a>
						</li>
						<li>
							<a href="#two" data-ajax="false" data-icon="location">凉菜</a>
						</li>
					</ul>
				</div>
				<!---------------------p1点餐-------------------------->
				<div id="one" data-iconpos="left" class="ui-body-d ui-content"> 
				
					<ul data-role="listview">
						
						<#list goodsList as goods>
						
							<li id="li${goods_index+1}" data-icon="no" onclick="click_hidden(${goods_index+1});">
								<a href="#">
									<img	src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
									<h1>
										${goods.name!''}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font	color="red" size="2">￥</font>
										<font	color="red" size="2" id="liprice${goods_index+1}">${goods.price!''}</font>
									</h1>
									<p>${goods.introduce!''}</p>
						 		</a>
								<div id="li${goods_index+1}div" 	style="display: none; width: 100%; height: 90px;">
									<div style="border-color: red; float: left; font-style: italic;">
										<input type="button" data-icon="info" data-mini="true" data-iconpos="notext" value="点餐："/>
											
									</div>
									<div style="border-color: red; float: left; width: 80%;">
									<table >
									<tr><td >
									 <fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio"  name="radio-choice-h-1-${goods_index+1}" onclick="radiochoiceh1a(${goods_index+1})"  id="radio-choice-h-1a${goods_index+1}" value="1" checked="checked">
								        <label for="radio-choice-h-1a${goods_index+1}">不辣</label>
								        <input type="radio" name="radio-choice-h-1-${goods_index+1}"  onclick="radiochoiceh1b(${goods_index+1})"  id="radio-choice-h-1b${goods_index+1}" value="2">
								        <label for="radio-choice-h-1b${goods_index+1}">微辣</label>
								        <input type="radio" name="radio-choice-h-1-${goods_index+1}"  onclick="radiochoiceh1c(${goods_index+1})"  id="radio-choice-h-1c${goods_index+1}" value="3">
								        <label for="radio-choice-h-1c${goods_index+1}">辣</label>
									 </fieldset>
									 </td>
									 <td >
									    <input type="button" data-icon="minus" onclick="minusGoodspage1(${goods_index+1});"  data-mini="true" data-iconpos="notext" />
									 </td>
									 <td style="text-align: center; "   > 
									<!-- <input type="text" id="li${goods_index+1}divrange${goods_index+1}" style="width:15px;height:10px; " value="0" > -->
									 <font id="li${goods_index+1}divrange${goods_index+1}" style="width:15px;height:10px; " color="blue"> 0 </font>
									</td>
									 <td>
									  <input type="button" data-icon="plus" onclick="addGoodspage1(${goods_index+1});"  data-mini="true" data-iconpos="notext" />
									 </td>
									 </tr>
									 </table>
									 </div>

									<!--
									<div style="border-color: red; float: left; width: 80%;">
										<input type="range" id="li${goods_index+1}divrange${goods_index+1}"  value="0" min="0" max="3" data-highlight="true"/>
									</div>
									<font style="font-style: italic;">点餐时请点击或滑动，蒜茸生蚝一次最多只能点3份，吃完再点</font>
								     -->
									
								</div>
						</li>
						<span id="one_index_value${goods_index+1}" style="display: none;">${goods_index+1}</span>
					</#list>
					<span id="one_list_length" style="display: none;">${goodsListlength}</span>						
				</ul>
					  
				</div>
				<!-----------------------蔬菜--------------------------->
				<div id="three" data-iconpos="left" class="ui-body-d ui-content"> 
				
					<ul data-role="listview">
						
						<#list sucaiList as goods>
						
							<li id="3li${goods_index+1}" data-icon="no" onclick="click_hidden3(${goods_index+1});">
								<a href="#">
									<img	src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
									<h1>
										${goods.name!''}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font	color="red" size="2">￥</font>
										<font	color="red" size="2" id="li3price${goods_index+1}">${goods.price!''}</font>
									</h1>
									<p>${goods.introduce!''}</p>
						 		</a>
								<div id="3li${goods_index+1}div" 	style="display: none; width: 100%; height: 90px;">
									<div style="border-color: red; float: left; font-style: italic;">
										<input type="button" data-icon="info" data-mini="true" data-iconpos="notext" value="点餐："/>
											
									</div>
									<div style="border-color: red; float: left; width: 80%;">
									<table >
									<tr><td >
									 <fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio"  name="radio-choice-h-3-${goods_index+1}" onclick="radiochoiceh3a(${goods_index+1})"  id="radio-choice-h-3a${goods_index+1}" value="1" checked="checked">
								        <label for="radio-choice-h-3a${goods_index+1}">不辣</label>
								        <input type="radio" name="radio-choice-h-3-${goods_index+1}"  onclick="radiochoiceh3b(${goods_index+1})"  id="radio-choice-h-3b${goods_index+1}" value="2">
								        <label for="radio-choice-h-3b${goods_index+1}">微辣</label>
								        <input type="radio" name="radio-choice-h-3-${goods_index+1}"  onclick="radiochoiceh3c(${goods_index+1})"  id="radio-choice-h-3c${goods_index+1}" value="3">
								        <label for="radio-choice-h-3c${goods_index+1}">辣</label>
									 </fieldset>
									 </td>
									 <td >
									    <input type="button" data-icon="minus" onclick="minusGoodspage3(${goods_index+1});"  data-mini="true" data-iconpos="notext" />
									 </td>
									 <td style="text-align: center; "  nowrap="nowrap" > 
									<!-- <input type="text" id="3li${goods_index+1}divrange${goods_index+1}" style="width:15px;height:10px; " value="0" > -->
									 <font  id="3li${goods_index+1}divrange${goods_index+1}" style="width:15px;height:10px; " color="blue">0 </font>
									</td>
									 <td>
									  <input type="button" data-icon="plus" onclick="addGoodspage3(${goods_index+1});"  data-mini="true" data-iconpos="notext" />
									 </td>
									 </tr>
									 </table>
									 </div>

									<!--
									<div style="border-color: red; float: left; width: 80%;">
										<input type="range" id="3li${goods_index+1}divrange${goods_index+1}"  value="0" min="0" max="3" data-highlight="true"/>
									</div>
									<font style="font-style: italic;">点餐时请点击或滑动，蒜茸生蚝一次最多只能点3份，吃完再点</font>
								     -->
									
								</div>
						</li>
						<span id="three_index_value${goods_index+1}" style="display: none;">${goods_index+1}</span>
					</#list>
					<span id="three_list_length" style="display: none;">${sucaiListlength}</span>						
				</ul>
					  
				</div>
				
				<!--------------------p1酒水--------------------------->
				<div id="two" data-iconpos="left" class="ui-body-d ui-content">
					    
					<ul data-role="listview">
					<#list drinksList as goods>	
						<li id="2li${goods_index+1}" data-icon="no" onclick="click_hidden2(${goods_index+1});">
							<a href="#">
								<img src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
								<h1>
									${goods.name!''}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="red" size="2" id="li2price${goods_index+1}">${goods.price!''}</font>
									<font color="red" size="2">元/瓶</font>
									
									
								</h1>
								<p>${goods.introduce!''}</p>
						 	</a>
							<div id="2li${goods_index+1}div" style="display: none; width: 100%; height: 90px;">
								<div style="border-color: red; float: left; font-style: italic;">
									<input type="button" data-icon="info" data-mini="true" data-iconpos="notext" value="点餐："/>
									<!--	<font style="color: red;">注：</font> -->
								</div>
								<div style="border-color: red; float: left; width: 80%;">
								<table >
									<tr><td >
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;
									<!--
									 <fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="radio-choice-h-2-${goods_index+1}" onclick="radiochoiceh2a(${goods_index+1})"  id="radio-choice-h-2a${goods_index+1}" value="1" checked="checked">
								        <label for="radio-choice-h-2a${goods_index+1}">不辣</label>
								        <input type="radio" name="radio-choice-h-2-${goods_index+1}" onclick="radiochoiceh2b(${goods_index+1})"  id="radio-choice-h-2b${goods_index+1}" value="2">
								        <label for="radio-choice-h-2b${goods_index+1}">微辣</label>
								        <input type="radio" name="radio-choice-h-2-${goods_index+1}" onclick="radiochoiceh2c(${goods_index+1})"  id="radio-choice-h-2c${goods_index+1}" value="3">
								        <label for="radio-choice-h-2c${goods_index+1}">辣</label>
									 </fieldset>
									  -->
									 </td>
									 <td >
									    <input type="button" data-icon="minus" onclick="minusGoodspage2(${goods_index+1});"  data-mini="true" data-iconpos="notext" />
									 </td>
									 <td style="text-align: center; "  nowrap="nowrap" > 
									<!-- <input type="text" id="2li${goods_index+1}divrange${goods_index+1}" style="width:15px;height:10px; " value="0" > -->
									  <font  id="2li${goods_index+1}divrange${goods_index+1}" style="width:15px;height:10px; " color="blue">0 </font>
									
									</td>
									 <td>
									  <input type="button" data-icon="plus" onclick="addGoodspage2(${goods_index+1});"  data-mini="true" data-iconpos="notext" />
									 </td>
									 </tr>
									 </table>
								<!--	<input type="range" id="2li${goods_index+1}divrange${goods_index+1}"  value="0" min="0" max="3" data-highlight="true"/>
								<font style="font-style: italic;">点餐时请点击或滑动，${goods.name!''}一次最多只能点3瓶，喝完再点</font>
								 -->
								</div>
								
							</div>
						</li>
						<span id="two_list_length${goods_index+1}" style="display: none;">${goods_index+1}</span>
					</#list>
					<span id="two_list_length" style="display: none;">${drinksListlength}</span>	
					</ul>
					  
				</div>
				
				
			</div>
			<!-- 弹出框 -->
			<!--  data-rel="popup" -->
			<!-- <div data-role="popup" id="rengonwujiao" data-theme="a" style="margin:90px;height: 27px;" >
				店小二马上到..请稍等.....</div>
			<div data-role="popup" id="jiezhang" data-theme="a" style="margin:90px; height: 27px; ">
				客官销等..老板娘再穿衣服.....</div> -->
		</div>

<!----------弹出菜单------------->

<div id="wuxianmoveBar" class="wuxianmoveBar">
			<div id="wuxianbanner" ><font size='4'>0</font></div>
		</div>
<!--
<div id="rel_div" style="width:50px; z-index:100px; position:absolute; right:20px; float:right; background:#eea; ">
		xxxx	</div>
		-->
<!---------------------------->


		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="#page-1" data-role="tab" data-icon="home"
						class="ui-btn-active" data-iconpos="left">主页</a></li>
					<li><a href="#page-2" id="onepage-2" onclick="onepage2();" data-role="tab"
						data-icon="calendar" data-iconpos="left">我的订单</a></li>
					<li><a href="#" id="onepage-3" onclick="onepage3();" data-role="tab"
						data-icon="audio" data-iconpos="left">人工服务</a></li>
					<li><a href="#" id="onepage-4" onclick="onepage4();" data-role="tab"
						data-icon="star" data-iconpos="left">结账</a></li>
				</ul>
			</div>

		</div>


	</div>
	<div id="page-2" data-role="page">
		<div data-role="header"
			style="background-color: azimuth; font-style: color: white;"
			data-iconshadow="true" data-transition="slide" data-fullscreen="true">
			<img alt="logo1" src="${BasePath}/res/wap/img/logo1.png"
				style="width: 100%; height: 50px;">
			<!-- <div style="width: 100%;height: 10px;background-color: #38c;"></div> -->
			<h1>
				<font style="font-family: Georgia;">我的订单</font>
			</h1>
		</div>
		<div data-role="content">
     		
			<ul data-role="listview" data-inset="true" data-mini="true"
				data-iconpos="notext">
				
					<!------------p2-肉类-------------------->
				<#list goodsList as goods>
				<span id="pdid${goods_index+1}" style="display: none;" >${goods.id}  </span>
				<li id="pd${goods_index+1}" data-icon="no" style="display: none;"  onclick="pclick_hidden(${goods_index+1});" >
					<a href="#">
						<img	src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
						<h1>${goods.name!''}</h1>
						<p>x<font id="d${goods_index+1}font1"></font>份
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<font	color="blue" id="d${goods_index+1}font3" size="2">${goods.price!''}</font><font	color="blue" size="2">元/打</font>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="red"	id="d${goods_index+1}font2" size="4"></font><font color="red" size="4">元</font>
						</p>
					</a>
					<div id="d${goods_index+1}li1div" style="display: none; background-color: white;">
						<div style="border-color: red; float: left;">
							<input type="button" id="d${goods_index+1}li1divdel" onclick="click_del(${goods_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
						
						</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td><fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1a(${goods_index+1})"  id="radio-choice-dh-1a${goods_index+1}" value="1" checked="checked">
								        <label for="radio-choice-dh-1a${goods_index+1}">不辣</label>
								        <input type="radio" name="radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1b(${goods_index+1})"  id="radio-choice-dh-1b${goods_index+1}" value="2">
								        <label for="radio-choice-dh-1b${goods_index+1}">微辣</label>
								        <input type="radio" name="radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1c(${goods_index+1})"  id="radio-choice-dh-1c${goods_index+1}" value="3">
								        <label for="radio-choice-dh-1c${goods_index+1}">辣</label>
									 </fieldset>
							 </td>
						     <td>
						     <input type="button" id="d${goods_index+1}li1divmin" data-inline="true" onclick="click_min(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     <input type="button" data-inline="true" id="d${goods_index+1}li1divplus" onclick="click_plus(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							   </tr>
						 </table>
							</div>
					</div>
				</li>
				</#list>
				<span id="one_list_order_length" style="display: none;">${goodsListlength}</span>	
				<!------------p2-蔬菜-------------------->
				<#list sucaiList as goods>
				<span id="p3did${goods_index+1}" style="display: none;" >${goods.id}  </span>
				<li id="p3d${goods_index+1}" data-icon="no" style="display: none;"  onclick="pclick_hidden3(${goods_index+1});" >
					<a href="#">
						<img	src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
						<h1>${goods.name!''}</h1>
						<p>x<font id="3d${goods_index+1}font1"></font>份
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<font	color="blue" id="3d${goods_index+1}font3" size="2">${goods.price!''}</font><font	color="blue" size="2">元/打</font>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="red"	id="3d${goods_index+1}font2" size="4"></font><font color="red" size="4">元</font>
						</p>
					</a>
					<div id="3d${goods_index+1}li1div" style="display: none; background-color: white;">
						<div style="border-color: red; float: left;">
							<input type="button" id="3d${goods_index+1}li1divdel" onclick="click_del3(${goods_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
						
						</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td><fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="radio-choice-dh-3-${goods_index+1}" onclick="radiochoicedh3a(${goods_index+1})"  id="radio-choice-dh-3a${goods_index+1}" value="1" checked="checked">
								        <label for="radio-choice-dh-3a${goods_index+1}">不辣</label>
								        <input type="radio" name="radio-choice-dh-3-${goods_index+1}" onclick="radiochoicedh3b(${goods_index+1})"  id="radio-choice-dh-3b${goods_index+1}" value="2">
								        <label for="radio-choice-dh-3b${goods_index+1}">微辣</label>
								        <input type="radio" name="radio-choice-dh-3-${goods_index+1}" onclick="radiochoicedh3c(${goods_index+1})"  id="radio-choice-dh-3c${goods_index+1}" value="3">
								        <label for="radio-choice-dh-3c${goods_index+1}">辣</label>
									 </fieldset>
							 </td>
						     <td>
						     <input type="button" id="3d${goods_index+1}li1divmin" data-inline="true" onclick="click_min3(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     <input type="button" data-inline="true" id="3d${goods_index+1}li1divplus" onclick="click_plus3(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							   </tr>
						 </table>
							</div>
					</div>
				</li>
				</#list>
				<span id="three_list_order_length" style="display: none;">${sucaiListlength}</span>	
				<!---------p2-酒水---------->
				<#list drinksList as goods>
				<span id="p2did${goods_index+1}" style="display: none;" >${goods.id}  </span>
				<li id="p2d${goods_index+1}" data-icon="no" style="display: none;"  onclick="pclick_hidden2(${goods_index+1});">
					<a href="#">
						<img	src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
						<h1>${goods.name!''}</h1>
						<p>x<font id="2d${goods_index+1}font1"></font>份
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<font	color="blue" id="2d${goods_index+1}font3" size="2">${goods.price!''}</font><font	color="blue" size="2">元/打</font>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="red"	id="2d${goods_index+1}font2" size="4"></font><font color="red" size="4">元</font>
						</p>
					</a>
					<div id="2d${goods_index+1}li1div" style="display: none; background-color: white;">
						<div style="border-color: red; float: left;">
							<input type="button" id="2d${goods_index+1}li1divdel"  onclick="click_del2(${goods_index+1});"  data-inline="true" data-icon="delete" data-iconpos="notext"/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<div style="border-color: red;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 <input type="button" id="2d${goods_index+1}li1divmin" data-inline="true"  onclick="click_min2(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
							 <input type="button" data-inline="true" id="2d${goods_index+1}li1divplus" onclick="click_plus2(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						</div>
					</div>
				</li>
				</#list>
				<span id="two_list_order_length" style="display: none;">${drinksListlength}</span>	
				
				
				

               <li id="renshu" data-icon="no">
                <table>
					<tr>	
					<td><input type="button" data-icon="info" data-mini="true" data-iconpos="notext"/> </td>
					  <td> 就餐人数： </td>
					        <td> <input type="button" data-icon="minus" onclick="rensuminus();"  data-mini="true" data-iconpos="notext" /></td>
							<td><font id="addrensu" style="width:15px;height:10px; " color="blue"> 0 </font></td>
							<td><input type="button" data-icon="plus" onclick="rensuplus();"  data-mini="true" data-iconpos="notext" /></td>
				</tr>
				</table>
               </li>

				<li id="d0" data-icon="no"><a href="#">
						<h1>
							总计：<font color="red" id="d0price" size="6">0</font><font	color="red" size="6">元</font>
						</h1>
				</a></li>
				
			</ul>
			 <input type="button"  data-mini="true" onclick="page2submit();" id="page2sub"
				style="background-color: red;" value="提交订单"> 
				<!-- <a href="#order_sub" data-role="button" data-rel="dialog" data-mini="true" id="page2sub">提交订单</a> -->
				
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="#page-1" id="twopage-1"   onclick="twopage1();" data-role="tab"
						data-icon="home"  data-iconpos="left">主页</a></li>
					<li><a href="#page-2" class="ui-btn-active" id="twopage-2" data-role="tab" data-icon="calendar"
						data-iconpos="left">我的订单</a></li>
					<li><a href="#" id="twopage-3" onclick="twopage3();" data-role="tab"
						data-icon="audio" data-iconpos="left">人工服务</a></li>
					<li><a href="#" id="twopage-4" onclick="twopage4();" data-role="tab"
						data-icon="star" data-iconpos="left">结账</a></li>

				</ul>
			</div>
		</div>
	</div>
	
   
 
</div>


</body>
</html>