<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>无线点餐-结账</title>
		
		<link rel="stylesheet" href="${BasePath}/res/wangcao/css/app-jquery-ui-min.css">
		<link href="${BasePath}/res/wangcao/css/jq.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/table.css"/>
		<link href="${BasePath}/res/wangcao/css/theme.default.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/desk.css" />
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/account.css" />
		<script src="${BasePath}/res/wangcao/js/app-jquery.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/app-jquery-ui.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/desk.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.widgets.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/account.js"></script>
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
		<div class="tips" id="check"  >
			<form action="${BasePath}/admin/checkout" method="post">
				<div class="orderId">下酒菜 </div>
				<div class="table_2" id="table_2">
						
  				</div>
				<input class="cancel1" type="submit" value="结账"/>
				<input  class="cancel1" id="cancel" type="button" value="取消"/>
				<!--
				<input class="cancel1"  onclick="printAccount()"  type="button"     value="打印账单"/>
				-->
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
				<div id="headerbtndiv" >
				    <img src="${BasePath}/res/wangcao/img/tishi.jpg" id="headerbtn_img" onclick="headerbtnimg();" style="display: none; float: left;margin-left: 150px;width: 30px;height: 40px; " />
					<a href="#" id="headerbtn"   style="float: left; left: 80px;">手机点餐信息</a>
				</div>
				
				<div id="header_conent" style="float: right;">
                    <a href="${BasePath}/admin/totable" id="headerbtn1">开台</a>
                   <a href="${BasePath}/admin/tomean" id="headerbtn2">点餐</a>
                   <a href="${BasePath}/admin/toorderlist" id="headerbtn3">订单</a>
                   <a href="#" id="headerbtn4">结账</a>
                   
				</div>

			</div>
			<div class="content">

				<table id="table1">
					<tr>
						<td id="tableone">
							<div class="content_left">
								<div id="left1">
									<button id="left1_but"  style="width: 100%;">结帐</button>
									<div class="money_left1_img"></div>
									<ul id="menu_1" style="height: 270px;">
										<li><a href="#"></a>
										</li>
										<li><a href="#"></a>
										</li>
										<li><a href="#"></a>
										</li>
										<li><a href="#"></a>
										</li>
									</ul>
								</div>
								
							</div>
						</td>
						<td id="tablesecend">
							<div id="content_right" class="content_right">
								<table cellspacing="1" class="tablesorter">
										<thead>
											<tr>
												<th style=" text-align: center;">订单号</th>
  												<th style=" text-align: center;"> 桌编号</th>
  												<th style=" text-align: center;">人数</th>
  												<th style=" text-align: center;" id="daa"> 订餐时间</th>
  												<th style=" text-align: center;">手机订单</th>
  												<th style=" text-align: center;">VIP</th>
  												<th style=" text-align: center;">优惠价</th>
  												<th style=" text-align: center;">订金</th>
  												<th style=" text-align: center;">实付价格</th>
  												<th style=" text-align: center;">结账</th>
  												<th style=" text-align: center;" colspan="2">备注</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th style=" text-align: center;">订单号</th>
  												<th style=" text-align: center;"> 桌编号</th>
  												<th style=" text-align: center;">人数</th>
  												<th style=" text-align: center;" id="daa"> 订餐时间</th>
  												<th style=" text-align: center;">手机订单</th>
  												<th style=" text-align: center;">VIP</th>
  												<th style=" text-align: center;">优惠价</th>
  												<th style=" text-align: center;">订金</th>
  												<th style=" text-align: center;">实付价格</th>
  												<th style=" text-align: center;">结账</th>
  												<th style=" text-align: center;" colspan="2">备注</th>
											</tr>
										</tfoot>
										<tbody>

											<#list accountList as account>
  												<tr >
  													<td style=" text-align: center;"><a href="#" onclick="account(${account.myOrder.id})">${account.myOrder.id}</a></td>
  													<td style=" text-align: center;" id="deskNo${account.myOrder.id}">${account.orderTable.deskNo}</td>
  													<td style=" text-align: center;">${account.orderTable.clientNo}人</td>
  													<td style=" text-align: center;" id="daa"><i id="date${account.myOrder.id}">${account.orderTable.createTime}</i></td>
  													<td style=" text-align: center;">
  														<#if account.orderTable.phone==1>
  															<img src="${BasePath}/res/wangcao/img/phone.png" style="width: 15px;height: 20px; "  />
  														<#else>
  														<img src="${BasePath}/res/wangcao/img/dianlao.png" style="width: 20px;height: 15px; "  />
  															
  														</#if>
  													</td>
  													<td style=" text-align: center;">
  														<#if account.orderTable.vip==1>
  																是
  															<#else>
  																否
  														</#if>
  													</td>
  													<td style=" text-align: center;">0.00</td>
  													<td style=" text-align: center;"><i id="payment${account.myOrder.id}">${account.orderTable.payment}</i>元</td>
  													<td style=" text-align: center;"><i id="totalPrice${account.myOrder.id}">${account.myOrder.totalPrice}</i>元</td>
  													<td style=" text-align: center;">
  														<#if account.orderTable.checkOut==1>
  																是
  															<#else>
  																<img src="${BasePath}/res/wangcao/img/fou.png" style="width: 15px;height: 20px; "  />
  														</#if>
  													</td>
  													<td style=" text-align: center;" colspan="2">${account.orderTable.remark}</td>
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
										<a href="${BasePath}/admin/toaccount?pageNo=${page.pageNow-1}">上一页</a>									
										<a href="#">第${page.pageNow}页</a>
										<#if page.pageNow==page.totalPageCount>
												<a href="#">下一页</a>
											<#else>
											<a href="${BasePath}/admin/toaccount?pageNo=${page.pageNow+1}">下一页</a>
										</#if>
									</div>	
								</div>
						</td>
					</tr>
				</table>

			</div>
			<div class="footer">

			</div>

		</div>
	</body>

</html>