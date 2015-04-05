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
		
		
	<!-----------customer----------->
		<div class="tips" id="check_4"  >
			<form action="${BasePath}/admin/addCustomer" method="post">
				<div class="orderId">添加顾客信息</div>
				<div class="table_2" id="table3">
				 	顾客姓名:<input type="text" name="name" id="name" value=""/><br/>
					 姓&nbsp;&nbsp;别:
						 <select name="sex" id="sex">
		 					<option value="0"  selected="selected">男</option>
		 					<option value="1"  selected="selected">女</option>
				 		</select><br/>
					 年龄:<input type="text" name="age" id="age" value=""/><br/>
					 联系电话:<input type="text" name="tel" id="tel" value=""/><br/>
					 地&nbsp;&nbsp;址:<br/><textarea  rows="1" cols="50" name="address" id="address" value=""></textarea>
  				</div>
				<input class="cancel_4" type="submit" value="确定"/>
				<input  class="cancel_4" id="cancel_4" type="button" value="取消"/>
			</form>
		</div>
		
		
		<div class="tips" id="check_5"  >
			<form action="updateCustomer" method="post">
				<div></div>
  				<div class="table_3" id="table_3">
  				</div>
				<input class="cancel_5" type="submit" value="确定"/>
				<input  class="cancel_5" id="cancel_5" type="button" value="取消"/>
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
										
										<li><a href="${BasePath}/admin/tomaintain" id="desk">桌位管理</a>
										</li>
										<li><a href="${BasePath}/admin/toSysGoods" id="goods">菜系管理</a>
										</li>
										<li><a href="${BasePath}/admin/tocustomer" id="customer">客户管理</a>
										</li>
										<li><a href="#" id="goods">订单管理</a>
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
									<a href="#"  onclick="addcustomer();" id="sys_add_3">添加</a>
								</div>
								<div style="float: left;  margin: 10px 0 0 0;">
									<a href="#"    id="sys_update_3">修改</a>
								</div>
								<div style=" margin: 10px 0 0 0;">
									<a href="#" id="sys_delete_3">删除</a>
								</div>
							<form name="frm">
								<table cellspacing="1" class="tablesorter" id="myCustomerTable" >
									<thead>
										<tr>
											<th></th>
  											<th style=" text-align: center;">订单号</th>
  											<th style=" text-align: center;">手机订单</th>		
											<th style=" text-align: center;">桌号</th>
											<th style=" text-align: center;">商品名称</th>											
											<th style=" text-align: center;">商品总数</th>
											<th style=" text-align: center;">商品总价</th>
											<th style=" text-align: center;">订单时间</th>	
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th></th>
  											<th style=" text-align: center;">订单号</th>
  											<th style=" text-align: center;">手机订单</th>		
											<th style=" text-align: center;">桌号</th>
											<th style=" text-align: center;">商品名称</th>											
											<th style=" text-align: center;">商品总数</th>
											<th style=" text-align: center;">商品总价</th>
											<th style=" text-align: center;">订单时间</th>	
										</tr>
									</tfoot>
									<tbody  >

									<#list accountList as account>
  												<tr id="demo${account.myOrder.id}">
  													<td align="center">
														<input type="checkbox"  value="${account.myOrder.id}" ></input>
													</td>
  													<td style=" text-align: center;"><a href="#" onclick="account(${account.myOrder.id});">${account.myOrder.id}</a></td>
  													<td style=" text-align: center;">
  														<#if account.orderTable.phone==1>
  															<img src="${BasePath}/res/wangcao/img/phone.png" style="width: 15px;height: 20px; "  />
  														<#else>
  														<img src="${BasePath}/res/wangcao/img/dianlao.png" style="width: 17px;height: 17px; "  />
  															
  														</#if>
  													</td>
  													<td style=" text-align: center;" id="deskNo${account.myOrder.id}">${account.orderTable.deskNo}</td>
  													<td style=" text-align: center;"><i id="person${account.myOrder.id}">${account.myOrder.goodsNames}</i></td>
  													<td style=" text-align: center;"><i id="person${account.myOrder.id}">${account.myOrder.goodsNum}</i></td>
  													<td style=" text-align: center;"><i id="person${account.myOrder.id}">${account.myOrder.totalPrice}</i></td>
  													<td style=" text-align: center;" id="daa"><i id="date${account.myOrder.id}">${account.myOrder.createDate}</i></td>
  													
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
												<a href="${BasePath}/admin/toOrder?pageNo=${page.pageNow-1}">上一页</a>									
										</#if>
										<a href="#">第${page.pageNow}页</a>
										<#if page.pageNow==page.totalPageCount>
												<a href="#">下一页</a>
											<#else>
												<a href="${BasePath}/admin/toOrder?pageNo=${page.pageNow+1}">下一页</a>
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