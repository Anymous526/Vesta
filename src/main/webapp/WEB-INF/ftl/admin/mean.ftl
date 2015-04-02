<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>无线点餐-点餐</title>
		
		<link rel="stylesheet" href="${BasePath}/res/wangcao/css/app-jquery-ui-min.css">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/desk.css" />
		<link href="${BasePath}/res/wangcao/css/jq.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/table.css"/>
		<link href="${BasePath}/res/wangcao/css/theme.default.css" rel="stylesheet">
		<link href="${BasePath}/res/wangcao/css/mean.css" rel="stylesheet">
		<script src="${BasePath}/res/wangcao/js/app-jquery.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/app-jquery-ui.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/desk.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.widgets.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/mean.js"></script>
		<script>
			$(function() {
				$("table")
					.tablesorter({widthFixed: true, widgets: ['zebra']})
					.tablesorterPager({container: $("#pager")});
				
			});
		  function tabs1next(){
				$.ajax({
						type: "POST",
						url: "http://localhost:8080/wuxian/desk/deskajax",
						data:{name="lisi"},
						success: function(map) {
							alert(map);
							$("#tabs1input").html(map);
						}
					});
					alert("ss");
			}
		</script>
	</head>

	<body>
		<div class="header">
			<div class="header_img">
				<div name="pic" style="float:left; position:relative;overflow:hidden;width:100%;height:90px;">
					<div>
						<img height="200" src="${BasePath}/res/wangcao/img/desk_img.jpg" alt="1" />
					</div>
					<div>
						<img height="200" src="${BasePath}/res/wangcao/img/desk_img1.jpg" alt="2" />
					</div>

				</div>
				<div id="headerbtndiv" >
				    <img src="${BasePath}/res/wangcao/img/tishi.jpg" id="headerbtn_img" onclick="headerbtnimg();" style="display: none; float: left;margin-left: 150px;width: 30px;height: 40px; " />
					<a href="#" id="headerbtn"   style="float: left; left: 80px;">手机点餐信息</a>
				</div>
				
				<div id="header_conent" style="float: right;">
                   <a href="${BasePath}/admin/totable" id="headerbtn1">开台</a>
                   <a href="#" id="headerbtn2">点餐</a>
                   <a href="${BasePath}/admin/toorderlist" id="headerbtn3">订单列表</a>
                   <a href="${BasePath}/admin/toaccount" id="headerbtn4">结账</a>
                   
				</div>

			</div>
			<div class="content">

				<table id="table1">
					<tr>
						<td id="tableone">
							<div class="content_left">
								<div id="left1">
									<button id="left1_but"  style="width: 100%;">品种</button>
									<ul>
										
										<li><a href="${BasePath}/admin/tomean">全部菜品</a></li>
    									<li><a href="${BasePath}/admin/tomean?type=1">特色</a></li>
    									<li><a href="${BasePath}/admin/tomean?type=2">主食</a></li>
    									<li><a href="${BasePath}/admin/tomean?type=3">热菜</a></li>
    									<li><a href="${BasePath}/admin/tomean?type=4">凉菜</a></li>
    									<li><a href="${BasePath}/admin/tomean?type=5">酒水</a></li>
    									
									</ul>
									</div>
									<div id="left2">
									<button id="left1_but2"  style="width: 100%; ">我的菜单</button>
								
									<ul>
										<form id="form1" action="${BasePath}/admin/submitorder" method="post">
											<div class="desk">桌编号：	
 												<select name="deskId" id="deskId" >
 													<#list reserve as desk>
 														<option value="${desk.id}">${desk.id}</option>
 													</#list>
 												</select>
 												<span id="span1" style="color:red"></span>	
 											</div><br/>
   										<div class="order_table1" id="order_table1" >
   										
   										</div>
   										<input class="suborder"   onclick="check();" type="button"  value="提交菜单" />
										</form>
									</ul>
									</div>
								</div>
								
							</div>
						</td>
						<td id="tablesecend">
							<div id="content_right" class="content_right">
									<table cellspacing="1" id="tablesorter" style=" text-align: center;"  >
										<thead>
  										<tr>
  											<#list list1 as goods>
  												<td >
  												<a href="#" onclick="addgoods(${goods.id})">
  												<div>
  												<img style="width: 150px; height: 100px;"  src="${BasePath}/res/img/${goods.type}/${goods.name}/${goods.phto}"/>
  												</div>
  												<div>
  												${goods.name}&nbsp;${goods.price}元/份
  												</div>
  												</a>
  												</td>
  											</#list>
  										</tr>
  										<tr>
  											<#list list2 as goods2>
  												<td>
  												<a href="#" onclick="addgoods(${goods2.id})" >
  												<div>
  												<img style="width: 150px; height: 100px;"  src="${BasePath}/res/img/${goods2.type}/${goods2.name}/${goods2.phto}" />
  												</div>
  												<div>
  												${goods2.name}&nbsp;${goods2.price}元/份
  												</div>
  												</a></td>
  											</#list>
  										</tr>
  										<tr>
  											<#list list3 as goods3>
  												<td><a href="#" onclick="addgoods(${goods3.id})" >
  												<div>
  												<img style="width: 150px; height: 100px;" src="${BasePath}/res/img/${goods3.type}/${goods3.name}/${goods3.phto}" />
  												</div>
  												<div>
  												${goods3.name}&nbsp;${goods3.price}元/份
  												</div>
  												</a>
  												</td>
  											</#list>
  										</tr>
										</thead>

									</table>
									<div id="pager" class="pager">
										<!--
										<form>
											<img src="${BasePath}/res/wangcao/img/page/first.png" class="first" />
											<img src="${BasePath}/res/wangcao/img/page/prev.png" class="prev" />
											<input type="text" class="pagedisplay" />
											<img src="${BasePath}/res/wangcao/img/page/next.png" class="next" />
											<img src="${BasePath}/res/wangcao/img/page/last.png" class="last" />
											<select class="pagesize">
												<option selected="selected" value="10">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
												<option value="40">40</option>
											</select>
										</form>
										-->
										
										<#if page.pageNow==1>
												<a href="#">上一页</a>
											<#else>
												<a href="${BasePath}/admin/tomean?pageNo=${page.pageNow-1}">上一页</a>									
										</#if>
										<a href="#">第${page.pageNow}页</a>
										<#if page.pageNow==page.totalPageCount>
												<a href="#">下一页</a>
											<#else>
												<a href="${BasePath}/admin/tomean?pageNo=${page.pageNow+1}">下一页</a>
										</#if>
									</div>
								</div>
							
							
						</td>
					</tr>
				</table>

			</div>
			<div class="footer">

			</div>


	</body>

</html>