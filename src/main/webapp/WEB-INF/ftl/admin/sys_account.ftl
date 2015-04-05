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
		
		
		<!--时间插件-->
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/jquery-calendar.css" />
		<script src="${BasePath}/res/wangcao/js/jquery-1.11.1.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/jquery-calendar.js"></script>
		
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
										<li><a href="${BasePath}/admin/toOrder" id="order">订单管理</a>
										</li>
										<li><a href="#" id="goods">结账管理</a>
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
								<div style="float: left; width:250px; margin: 10px 0 0 0;">
									<form action="${BasePath}/admin/accountList" method="post">
										&nbsp;&nbsp;时间：<input type="text"  id="calendar1" maxlength="16" onfocus="$(this).calendar()" name="start" readonly="readonly"  ></input>
													<input style="float: left;  position: relative; left: 240px; top:-22px;" type="text"  id="calendar2" maxlength="16" onfocus="$(this).calendar()" name="end" readonly="readonly" ></input>
													<input type="submit" style="  position: relative; left: 250px; top:-23px;" value="搜索"/>
									</form>																										
								</div>
								<!--
								<div style="float: left; width:250px; margin: 10px 0 0 0;">
									&nbsp;&nbsp;时间：									
									<input type="text" id="start" name="start"  value="" ></input>--
								</div>
								
								<div style="float: left; width:250px;  margin: 10px 0 0 0;">
									<input type="text" id="end" name="end" value="" ></input>
								</div>
								<div  style=" margin: 10px 0 0 0; ">
									<input type="button" id="sys_delete_5"  value="搜索" ></input>
								</div>
								-->
							<form name="frm">
								<table cellspacing="1" class="tablesorter" id="mySelTable" >
									<thead>
										<tr>
											<th></th>
  											<th >姓名</th>
  											<th>时间段</th>
  											<th >桌号</th>
 								 			<th>订单号</th>  											
  											<th>结账价格</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th></th>
  											<th >姓名</th>
  											<th>时间段</th>
  											<th >桌号</th>
 								 			<th>订单号</th>  											
  											<th>结账价格</th>
										</tr>
									</tfoot>
									<tbody  >

									<#list accountCountList as s>
  										<tr>
  											<td align="center">
													<input type="checkbox"  value="${s.orderTable.id}" ></input>
											</td>
											<td>${s.employee.waiterName!''}</td>
  											<td>${s.orderTable.createTime!''}</td>
  											<td>${s.desk.deskName}</td>	
  											<td>
  												${s.myOrder.id}
  											</td>  											
  											<td>${s.myOrder.totalPrice}</td>
  									</tr>
 						 		</#list>
									<tr><td  colspan="2"></td><td style="text-align: right;">总桌数:</td><td>${deskTotal}</td><td style="text-align: right;">总价格:</td><td>${totalPrice}</td></tr>
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
												<a href="${BasePath}/admin/accountList?pageNo=${page.pageNow-1}">上一页</a>									
										</#if>
										<a href="#">第${page.pageNow}页</a>
										<#if page.pageNow==page.totalPageCount>
												<a href="#">下一页</a>
											<#else>
												<a href="${BasePath}/admin/accountList?pageNo=${page.pageNow+1}">下一页</a>
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