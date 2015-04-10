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
<link rel="stylesheet" href="${BasePath}/res/wap/css/employee.css" />
<script src="${BasePath}/res/wap/js/jquery.mobile-1.4.5.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/order.js" type="text/javascript" charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/wap.js" type="text/javascript" charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/employee.js" type="text/javascript" charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/greens.js" type="text/javascript" charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/drink.js" type="text/javascript" charset="utf-8"></script>
<script src="${BasePath}/res/wap/js/employee-order.js" type="text/javascript" charset="utf-8"></script>
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
		
			<div data-role="tabs" id="tabs">
				<div data-role="navbar" > <!-- data-iconpos="left" -->
					<ul class="ui-body-d ui-content">
						<li>
							<a href="#emplyeeone" data-ajax="false" class="ui-btn-active" data-icon="location">肉类</a>
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
				<!---------------------p1点餐肉类-------------------------->
				<div id="emplyeeone" data-iconpos="left" > 
				
					<table class="tableconext1">
					<#list assemblelist as assemble>
						<tr >
						 <td>
						  <a href="#" data-mini="true" data-role="button"  onclick="worktable1td1(${assemble_index+1});">
						  	<font id="worktable1td1font1${assemble_index+1}">${assemble.name}</font>
						  	<font color="red"  id="worktable1td1font2${assemble_index+1}" >${assemble.price!''}</font>
						  	<font color="red">元</font>
						  </a>
						 </td>
						 <td>
						  <a href="#" data-mini="true" data-role="button"  onclick="worktable1td2(${assemble_index+1});">
						  	<font id="worktable1td2font1${assemble_index+1}">${assemble.nameone}</font>
						  	<font color="red"  id="worktable1td2font2${assemble_index+1}" >${assemble.priceone!''}</font>
						  	<font color="red">元</font>
						  </a>
						 </td>
						</tr>
					</#list>
					</table>
					  
				</div>
				<!-----------------------蔬菜--------------------------->
				<div id="three" data-iconpos="left" class="ui-body-d ui-content"> 
				<table class="tableconext1">
					<#list greensList as greens>
						<tr >
						 <td>
						  <a href="#" data-mini="true" data-role="button"  onclick="worktable1td3(${greens_index+1});">
						  	<font id="worktable1td1font3${greens_index+1}">${greens.name}</font>
						  	<font color="red"  id="worktable2td1font3${greens_index+1}" >${greens.price!''}</font>
						  	<font color="red">元</font>
						  </a>
						 </td>
						 <td>
						  <a href="#" data-mini="true" data-role="button"  onclick="worktable1td4(${greens_index+1});">
						  	<font id="worktable1td2font4${greens_index+1}">${greens.nameone}</font>
						  	<font color="red"  id="worktable1td2font4p${greens_index+1}" >${greens.priceone!''}</font>
						  	<font color="red">元</font>
						  </a>
						 </td>
						</tr>
					</#list>
					</table> 
				</div>
				
				<!--------------------p1酒水--------------------------->
				<div id="two" data-iconpos="left" class="ui-body-d ui-content">
					<table class="tableconext1">
					<#list drinksList as drinks>
						<tr >
						 <td>
						  <a href="#" data-mini="true" data-role="button"  onclick="worktable1td5(${drinks_index+1});">
						  	<font id="worktable1td1font5${drinks_index+1}">${drinks.name}</font>
						  	<font color="red"  id="worktable2td1font5${drinks_index+1}" >${drinks.price!''}</font>
						  	<font color="red">元</font>
						  </a>
						 </td>
						 <td>
						  <a href="#" data-mini="true" data-role="button"  onclick="worktable1td6(${drinks_index+1});">
						  	<font id="worktable1td2font6${drinks_index+1}">${drinks.nameone}</font>
						  	<font color="red"  id="worktable1td2font6d${drinks_index+1}" >${drinks.priceone!''}</font>
						  	<font color="red">元</font>
						  </a>
						 </td>
						</tr>
					</#list>
					</table> 
					  
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

<div id="workwuxianmoveBar" class="wuxianmoveBar">
			<div id="workwuxianbanner" ><font size='4'>0</font></div>
			
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
     		
			<ul data-role="listview" id="workorderconet" data-inset="true" data-mini="true" data-iconpos="notext">
				
					<!------------p2-肉类(1)-------------------->
				<#list assemblelist as goods>
					<li id="workul1li1${goods_index+1}" data-icon="no" style="display: none;"  onclick="workul1li1(${goods_index+1});" >
						<a href="#">
							<font id="workul1li1fontname${goods_index+1}" size="5">${goods.name!''}</font>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font id="workul1li1font1name${goods_index+1}" size="2">0</font><font size="2">份</font>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font id="workul1li1font2name${goods_index+1}" color="red" size="4">${goods.price!''}</font>
							<font color="red" size="4">元</font>
						
						</a>
						<div id="workli1${goods_index+1}li1div" style="display: none; background-color: white;">
							<div style="border-color: red; float: left;">
								<input type="button" id="workli1${goods_index+1}li1divdel" onclick="workul1li1click_del(${goods_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
							</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td>
						     	<fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="workli1radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1a(${goods_index+1})"  id="workli1radio-choice-dh-1a${goods_index+1}" value="1" checked="checked">
								        <label for="workli1radio-choice-dh-1a${goods_index+1}">不辣</label>
								        <input type="radio" name="workli1radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1b(${goods_index+1})"  id="workli1radio-choice-dh-1b${goods_index+1}" value="2">
								        <label for="workli1radio-choice-dh-1b${goods_index+1}">微辣</label>
								        <input type="radio" name="workli1radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1c(${goods_index+1})"  id="workli1radio-choice-dh-1c${goods_index+1}" value="3">
								        <label for="workli1radio-choice-dh-1c${goods_index+1}">辣</label>
								</fieldset>
							 </td>
						     <td>
						     	<input type="button" id="workul1li1${goods_index+1}li1divmin" data-inline="true" onclick="workli1click_min(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     	<input type="button" data-inline="true" id="workul1li1${goods_index+1}li1divplus" onclick="workli1click_plus(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							</tr>
						 </table>
						</div>
					</div>
					</li>
				</#list>
				
				<!------------------(2)-------------------->
				
				<#list assemblelist as goods>
				<li id="workul1li2${goods_index+1}" data-icon="no" style="display: none;"  onclick="workul1li2(${goods_index+1});" >
					<a href="#">
							<font id="workul1li2fontname${goods_index+1}" size="5">${goods.nameone!''}</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font size="2" id="workul1li2font1name${goods_index+1}">0</font><font size="2">份</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="red" id="workul1li2font2name${goods_index+1}" size="4">${goods.priceone!''}</font><font color="red" size="4">元</font>
					</a>
					<div id="workli2${goods_index+1}li1div" style="display: none; background-color: white;">
						<div style="border-color: red; float: left;">
							<input type="button" id="workli2${goods_index+1}li1divdel" onclick="workul1li2click_del(${goods_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
						</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td><fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1a(${goods_index+1})"  id="workli2radio-choice-dh-1a${goods_index+1}" value="1" checked="checked">
								        <label for="workli2radio-choice-dh-1a${goods_index+1}">不辣</label>
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1b(${goods_index+1})"  id="workli2radio-choice-dh-1b${goods_index+1}" value="2">
								        <label for="workli2radio-choice-dh-1b${goods_index+1}">微辣</label>
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1c(${goods_index+1})"  id="workli2radio-choice-dh-1c${goods_index+1}" value="3">
								        <label for="workli2radio-choice-dh-1c${goods_index+1}">辣</label>
									 </fieldset>
							 </td>
						     <td>
						     <input type="button" id="workul1li2${goods_index+1}li1divmin" data-inline="true" onclick="workli2click_min(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     <input type="button" data-inline="true" id="workul1li2${goods_index+1}li1divplus" onclick="workli2click_plus(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							   </tr>
						 </table>
							</div>
					</div>
				</li>
				</#list>				
				<span id="one_list_assemble_length" style="display: none;">${assemblelistlength}</span>	
				
				<!----蔬菜类----->
			<#list greensList as greens>
					<li id="workul1li3${greens_index+1}" data-icon="no" style="display: none;"  onclick="workul1li3(${greens_index+1});" >
						<a href="#">
							<font id="workul1li1fontname3${greens_index+1}" size="5">${greens.name!''}</font>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font id="workul1li1font1name3${greens_index+1}" size="2">0</font><font size="2">份</font>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font id="workul1li1font2name3${greens_index+1}" color="red" size="4">${greens.price!''}</font>
							<font color="red" size="4">元</font>
						
						</a>
						<div id="workli1${greens_index+1}li1div3" style="display: none; background-color: white;">
							<div style="border-color: red; float: left;">
								<input type="button" id="workli1${greens_index+1}li1divdel" onclick="workul1li1click_delg(${greens_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
							</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td>
						     	<fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="workli1radio-choice-dh-1-${greens_index+1}" onclick="radiochoicedh1a(${greens_index+1})"  id="workli1radio-choice-dh-1a${greens_index+1}" value="1" checked="checked">
								        <label for="workli1radio-choice-dh-1a${greens_index+1}">不辣</label>
								        <input type="radio" name="workli1radio-choice-dh-1-${greens_index+1}" onclick="radiochoicedh1b(${greens_index+1})"  id="workli1radio-choice-dh-1b${greens_index+1}" value="2">
								        <label for="workli1radio-choice-dh-1b${greens_index+1}">微辣</label>
								        <input type="radio" name="workli1radio-choice-dh-1-${greens_index+1}" onclick="radiochoicedh1c(${greens_index+1})"  id="workli1radio-choice-dh-1c${greens_index+1}" value="3">
								        <label for="workli1radio-choice-dh-1c${greens_index+1}">辣</label>
								</fieldset>
							 </td>
						     <td>
						     	<input type="button" id="workul1li1${greens_index+1}li1divmin" data-inline="true" onclick="workli1click_min1(${greens_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     	<input type="button" data-inline="true" id="workul1li1${greens_index+1}li1divplus" onclick="workli1click_plus1(${greens_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							</tr>
						 </table>
						</div>
					</div>
					</li>
				</#list>	
				
				<!-----------蔬菜2------------->
				<#list greensList as goods>
				<li id="workul1li4${goods_index+1}" data-icon="no" style="display: none;"  onclick="workul1li4(${goods_index+1});" >
					<a href="#">
							<font id="workul1li2fontname4${goods_index+1}" size="5">${goods.nameone!''}</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font size="2" id="workul1li2font1name4${goods_index+1}">0</font><font size="2">份</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="red" id="workul1li2font2name4${goods_index+1}" size="4">${goods.priceone!''}</font><font color="red" size="4">元</font>
					</a>
					<div id="workli2${goods_index+1}li1div4" style="display: none; background-color: white;">
						<div style="border-color: red; float: left;">
							<input type="button" id="workli2${goods_index+1}li1divdel" onclick="workul1li2click_delg(${goods_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
						</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td><fieldset data-role="controlgroup"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1a(${goods_index+1})"  id="workli2radio-choice-dh-1a${goods_index+1}" value="1" checked="checked">
								        <label for="workli2radio-choice-dh-1a${goods_index+1}">不辣</label>
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1b(${goods_index+1})"  id="workli2radio-choice-dh-1b${goods_index+1}" value="2">
								        <label for="workli2radio-choice-dh-1b${goods_index+1}">微辣</label>
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1c(${goods_index+1})"  id="workli2radio-choice-dh-1c${goods_index+1}" value="3">
								        <label for="workli2radio-choice-dh-1c${goods_index+1}">辣</label>
									 </fieldset>
							 </td>
						     <td>
						     <input type="button" id="workul1li2${goods_index+1}li1divmin" data-inline="true" onclick="workli2click_min1(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     <input type="button" data-inline="true" id="workul1li2${goods_index+1}li1divplus" onclick="workli2click_plus1(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							   </tr>
						 </table>
							</div>
					</div>
				</li>
				</#list>				
				<span id="one_list_greens_length" style="display: none;">${greenslistlength}</span>	
				
						<!----酒水类----->
			<#list drinksList as drinks>
					<li id="workul1li5${drinks_index+1}" data-icon="no" style="display: none;"  onclick="workul1li5(${drinks_index+1});" >
						<a href="#">
							<font id="workul1li1fontname5${drinks_index+1}" size="5">${drinks.name!''}</font>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font id="workul1li1font1name5${drinks_index+1}" size="2">0</font><font size="2">份</font>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font id="workul1li1font2name5${drinks_index+1}" color="red" size="4">${drinks.price!''}</font>
							<font color="red" size="4">元</font>
						
						</a>
						<div id="workli1${drinks_index+1}li1div5" style="display: none; background-color: white;">
							<div style="border-color: red; float: left;">
								<input type="button" id="workli1${drinks_index+1}li1divdel" onclick="workul1li1click_deld(${drinks_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
							</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td>
						     	<fieldset data-role="controlgroup" style="display: none;"   data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="workli1radio-choice-dh-1-${drinks_index+1}" onclick="radiochoicedh1a(${drinks_index+1})"  id="workli1radio-choice-dh-1a${drinks_index+1}" value="1" checked="checked">
								        <label for="workli1radio-choice-dh-1a${drinks_index+1}">不辣</label>
								        <input type="radio" name="workli1radio-choice-dh-1-${drinks_index+1}" onclick="radiochoicedh1b(${drinks_index+1})"  id="workli1radio-choice-dh-1b${drinks_index+1}" value="2">
								        <label for="workli1radio-choice-dh-1b${drinks_index+1}">微辣</label>
								        <input type="radio" name="workli1radio-choice-dh-1-${drinks_index+1}" onclick="radiochoicedh1c(${drinks_index+1})"  id="workli1radio-choice-dh-1c${drinks_index+1}" value="3">
								        <label for="workli1radio-choice-dh-1c${drinks_index+1}">辣</label>
								</fieldset>
							 </td>
						     <td>
						     	<input type="button" id="workul1li1${drinks_index+1}li1divmin" data-inline="true" onclick="workli1click_min2(${drinks_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     	<input type="button" data-inline="true" id="workul1li1${drinks_index+1}li1divplus" onclick="workli1click_plus2(${drinks_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							</tr>
						 </table>
						</div>
					</div>
					</li>
				</#list>	
				
				<!-----------酒水2------------->
				<#list drinksList as goods>
				<li id="workul1li6${goods_index+1}" data-icon="no" style="display: none;"  onclick="workul1li6(${goods_index+1});" >
					<a href="#">
							<font id="workul1li2fontname6${goods_index+1}" size="5">${goods.nameone!''}</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font size="2" id="workul1li2font1name6${goods_index+1}">0</font><font size="2">份</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="red" id="workul1li2font2name6${goods_index+1}" size="4">${goods.priceone!''}</font><font color="red" size="4">元</font>
					</a>
					<div id="workli2${goods_index+1}li1div6" style="display: none; background-color: white;">
						<div style="border-color: red; float: left;">
							<input type="button" id="workli2${goods_index+1}li1divdel" onclick="workul1li2click_deld(${goods_index+1});" data-inline="true" data-icon="delete" data-iconpos="notext"/>
						</div>
						<div style="border-color: red;">
						 <table>
						   <tr>
						     <td><fieldset data-role="controlgroup"  style="display: none;"  data-mini="true"  data-type="horizontal">      
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1a(${goods_index+1})"  id="workli2radio-choice-dh-1a${goods_index+1}" value="1" checked="checked">
								        <label for="workli2radio-choice-dh-1a${goods_index+1}">不辣</label>
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1b(${goods_index+1})"  id="workli2radio-choice-dh-1b${goods_index+1}" value="2">
								        <label for="workli2radio-choice-dh-1b${goods_index+1}">微辣</label>
								        <input type="radio" name="workli2radio-choice-dh-1-${goods_index+1}" onclick="radiochoicedh1c(${goods_index+1})"  id="workli2radio-choice-dh-1c${goods_index+1}" value="3">
								        <label for="workli2radio-choice-dh-1c${goods_index+1}">辣</label>
									 </fieldset>
							 </td>
						     <td>
						     <input type="button" id="workul1li2${goods_index+1}li1divmin" data-inline="true" onclick="workli2click_min2(${goods_index+1});" data-icon="minus" data-iconpos="notext"/>
						     </td>
						     <td>
						     <input type="button" data-inline="true" id="workul1li2${goods_index+1}li1divplus" onclick="workli2click_plus2(${goods_index+1});" data-icon="plus" data-iconpos="notext"/>
						     </td>
							   </tr>
						 </table>
							</div>
					</div>
				</li>
				</#list>				
				<span id="one_list_drinks_lengthsize" style="display: none;">${drinksListlengthsize}</span>	
				
				
				
				
				<li id="workkaitai" onclick="workkaitai();"  data-icon="no">
                <table>
					<tr>	
					<td><input type="button" data-icon="info" data-mini="true" data-iconpos="notext"/> </td>
					  <td> 桌号： </td>
					        <td> <input type="button" data-icon="minus" onclick="workkaitaiminus();"  data-mini="true" data-iconpos="notext" /></td>
							<td><font id="workaddkaitai" style="width:15px;height:10px; " color="blue"> 0 </font></td>
							<td><input type="button" data-icon="plus" onclick="workkaitaiplus();"  data-mini="true" data-iconpos="notext" /></td>
				</tr>
				</table>
               </li>
				
				<li id="workrenshu" onclick="workrenshu();" data-icon="no">
                <table>
					<tr>	
					<td><input type="button" data-icon="info" data-mini="true" data-iconpos="notext"/> </td>
					  <td> 就餐人数： </td>
					        <td> <input type="button" data-icon="minus" onclick="workrensuminus();"  data-mini="true" data-iconpos="notext" /></td>
							<td><font id="workaddrensu" style="width:15px;height:10px; " color="blue"> 0 </font></td>
							<td><input type="button" data-icon="plus" onclick="workrensuplus();"  data-mini="true" data-iconpos="notext" /></td>
				</tr>
				</table>
               </li>

				<li id="d0" data-icon="no"><a href="#">
						<h1>
							总计：<font color="red" id="work0price" size="6">0</font><font	color="red" size="6">元</font>
						</h1>
				</a></li>
				
			</ul>
			 <input type="button"  data-mini="true" onclick="worksubmit();" id="page2sub"
				style="background-color: red;" value="提交订单"/> 
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