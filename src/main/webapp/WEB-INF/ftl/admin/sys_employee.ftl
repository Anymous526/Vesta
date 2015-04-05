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
		
		
	<!-----------employee----------->
		<div class="tips" id="check_6"  >
			<form action="${BasePath}/admin/addEmployee" method="post">
				<div class="orderId">添加员工信息</div>
				<div class="table_2" id="table3">
				 	姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="waiterName" id="waiterName" value=""/><br/>
					 姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
						 <select name="sex" id="sex">
		 					<option value="0"  selected="selected">男</option>
		 					<option value="1"  selected="selected">女</option>
				 		</select><br/>
					 年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" name="age" id="age" value=""/><br/>
					 联系电话:<input type="text" name="tel" id="tel" value=""/><br/>
					 部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:<input type="text" name="deptNo" id="deptNo" value=""/><br/>
					 权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限:<input type="text" name="auth" id="auth" value=""/><br/>
					 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="text" name="waiterPassword" id="waiterPassword" value=""/><br/>
					 地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:<br/><textarea  rows="1" cols="50" name="address" id="address" value=""></textarea>
  				</div>
				<input class="cancel_6"  style="position: relative; top:-15px;"  type="submit" value="确定"/>
				<input  class="cancel_6"  style="position: relative; top:-15px;" id="cancel_6" type="button" value="取消"/>
			</form>
		</div>
		
		<!--修改员工信息-->
		<div class="tips" id="check_7"  >
			<form action="updateEmployee" method="post">
				<div></div>
  				<div class="table_3" id="table_3">
  				</div>
				<input class="cancel_7" type="submit" value="确定"/>
				<input  class="cancel_7" id="cancel_7" type="button" value="取消"/>
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
										<li><a href="${BasePath}/admin/toOrder" id="order">订单管理</a>
										</li>
										<li><a href="${BasePath}/admin/accountList" id="account">结账管理</a>
										</li>
										<li><a href="#" id="goods">人事管理</a>
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
									<a href="#"  onclick="addemployee();" id="sys_add_4">添加</a>
								</div>
								<div style="float: left;  margin: 10px 0 0 0;">
									<a href="#"    id="sys_update_4">修改</a>
								</div>
								<div style=" margin: 10px 0 0 0;">
									<a href="#" id="sys_delete_4">删除</a>
								</div>
							<form name="frm">
								<table cellspacing="1" class="tablesorter" id="myEmployeeTable" >
									<thead>
										<tr>
											<th></th>
  											<th>姓名</th>
 								 			<th>性别</th>
  											<th >年龄</th>
  											<th >电话</th>
  											<th>部门</th>
  											<th>权限</th>
  											<th>入职时间</th>
  											<th >联系地址</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th></th>
  											<th>姓名</th>
 								 			<th>性别</th>
  											<th >年龄</th>
  											<th >电话</th> 											
  											<th>部门</th>
  											<th>权限</th>
  											<th>入职时间</th>
  											<th >联系地址</th>
										</tr>
									</tfoot>
									<tbody  >

									<#list employees as employee>
  										<tr>
  											<td align="center">
													<input type="checkbox"  value="${employee.waiterId}" ></input>
											</td>
  											<td>${employee.waiterName!''}</td>
  											<td>
  												<#if employee.sex==0>
  													男
  												<#else>
  													女	
  												</#if>
  											</td>
  											<td>${employee.age}</td>
  											<td>${employee.tel!''}</td>	
  											<td>${employee.deptNo}</td>
  											<td>${employee.auth}</td>
  											<td>${employee.createTime!''}</td>
  											<td>${employee.address!''}</td>
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
												<a href="${BasePath}/admin/tocustomer?pageNo=${page.pageNow-1}">上一页</a>									
										</#if>
										<a href="#">第${page.pageNow}页</a>
										<#if page.pageNow==page.totalPageCount>
												<a href="#">下一页</a>
											<#else>
												<a href="${BasePath}/admin/tocustomer?pageNo=${page.pageNow+1}">下一页</a>
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