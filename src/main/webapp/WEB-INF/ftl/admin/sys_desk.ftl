<!doctype html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>后台管理系统</title>
		
		<link rel="stylesheet" href="${BasePath}/res/wangcao/css/app-jquery-ui-min.css">
		<link href="${BasePath}/res/wangcao/css/jq.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/table.css" />
		<link href="${BasePath}/res/wangcao/css/theme.default.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/desk.css" />
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/sys.css" />
		<script src="${BasePath}/res/wangcao/js/app-jquery.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/app-jquery-ui.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/desk.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.widgets.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/sys.js"></script>
		<script>
			$(function() {
				$("table")
					.tablesorter({
						widthFixed: true,
						widgets: ['zebra']
					})
					.tablesorterPager({
						container: $("#pager")
					});
					
					
		

			});

			function tabs1next() {
				$.ajax({
					type: "POST",
					url: "http://localhost:8080/wuxian/desk/deskajax",
					data: {
						name = "lisi"
					},
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
		
		
	<!-----------desk----------->
		<div class="tips" id="check_2"  >
			<form action="${BasePath}/admin/addDesk" method="post">
				<div class="orderId"></div>
				<div class="table_2" id="table3">
				 	桌位号:<input type="text" name="deskNo" id="deskNo" value=""/><br/>
					 桌号名:<input type="text" name="deskName" id="deskName" value=""/><br/>
					 楼&nbsp;&nbsp;层:
						 <select name="type" id="type">
		 					<option value="1"  selected="selected">大厅</option>
		 					<option value="2"  selected="selected">二楼</option>
				 		</select><br/>
					 描&nbsp;&nbsp;述:<br/><textarea  rows="1" cols="50" name="description" id="description" value=""></textarea>
  				</div>
				<input class="cancel_2" type="submit" value="确定"/>
				<input  class="cancel_2" id="cancel_2" type="button" value="取消"/>
			</form>
		</div>
		
		
		<div class="tips" id="check_3"  >
			<form action="updateDesk" method="post">
				<div></div>
  				<div class="table_3" id="table_3">
  				</div>
				<input class="cancel_3" type="submit" value="确定"/>
				<input  class="cancel_3" id="cancel_3" type="button" value="取消"/>
			</form>
	</div>
		
		
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
				<!--
				<div>
					<a href="#" id="headerbtn" style="float: left; left: 80px;">手机点餐信息</a>
				</div>
				-->
				<div id="header_conent" style="float: right;">

				</div>

			</div>
			<div class="content">

				<table id="table1">
					<tr>
						<td id="tableone">
							<div class="content_left">
								<div id="left1">
									<button id="left1_but" style="width: 100%;">后台管理系统</button>
									<ul id="menu_1">
										
										<li><a href="#" id="desk">桌位管理</a>
										</li>
										<li><a href="${BasePath}/admin/toSysGoods" id="goods">菜系管理</a>
										</li>
										<li><a href="${BasePath}/admin/tocustomer" id="customer">客户管理</a>
										</li>
										<li><a href="${BasePath}/admin/toOrder" id="order">订单管理</a>
										</li>
										<li><a href="${BasePath}/admin/accountList" id="account">结账管理</a>
										</li>
										<li><a href="${BasePath}/admin/toemployee" id="employee">人事管理</a>
										</li>
										<!--<li><a href="#" id="goods">采购管理</a>
										</li>
										<li><a href="#" id="goods">库存管理</a>
										</li> -->
										<li><a href="${BasePath}/admin/selList" id="sel">销售额管理(日、月、年)</a>
										</li>
									</ul>
								</div>
							</div>
						</td>
						<td id="tablesecend">						
						<!--desk-------------------------->
							
							<div id="content_right" class="content_right">
								<div style="float: left; margin: 10px 0 0 0;">
									<a href="#"  onclick="adddesk();" id="sys_add_1">添加</a>
								</div>
								<div style="float: left;  margin: 10px 0 0 0;">
									<a href="#"    id="sys_update_1">修改</a>
								</div>
								<div style=" margin: 10px 0 0 0;">
									<a href="#" id="sys_delete_1">删除</a>
								</div>
							<form name="frm">
								<table cellspacing="1" class="tablesorter" id="myDeskTable" >
									<thead>
										<tr>
											<th></th>
  											<th>桌编号</th>
 								 			<th>桌号名</th>
  											<th >楼层</th>
  											<th >描述</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th></th>
  											<th>桌编号</th>
  											<th>桌号名</th>
 								 			<th >楼层</th>
 								 			<th >描述</th>
										</tr>
									</tfoot>
									<tbody  >

									<#list desks as desk>
  										<tr>
  											<td align="center">
													<input type="checkbox"  value="${desk.id}" ></input>
											</td>
  											<td>${desk.id}</td>
  											<td>${desk.deskName!''}</td>
  											<td>
  												<#if desk.type==1>
  													大厅
  												<#elseif desk.type==2>
  													二楼
  												<#else>
  													三楼	
  												</#if>
  											</td>
  											<td>${desk.description!''}</td>
  									</tr>
 						 		</#list>

									</tbody>
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
												<a href="${BasePath}/admin/tomaintain?pageNo=${page.pageNow-1}">上一页</a>									
										</#if>
										<a href="#">第${page.pageNow}页</a>
										<#if page.pageNow==page.totalPageCount>
												<a href="#">下一页</a>
											<#else>
												<a href="${BasePath}/admin/tomaintain?pageNo=${page.pageNow+1}">下一页</a>
									</#if>
									
								</div>

							</div>
						
						</td>
					</tr>
				</table>
			</form>
			</div>
			<div class="footer">

			</div>


	</body>

</html>