<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>无线点餐-开台</title>
		<link rel="stylesheet" href="${BasePath}/res/wangcao/css/app-jquery-ui-min.css">
		<link href="${BasePath}/res/wangcao/css/jq.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/table.css"/>
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/table2.css"/>
		<link href="${BasePath}/res/wangcao/css/theme.default.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/wangcao/css/desk.css" />
		<script src="${BasePath}/res/wangcao/js/app-jquery.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/app-jquery-ui.min.js"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/desk.js" type="text/javascript" charset="utf-8"></script>
		<script src="${BasePath}/res/wangcao/js/jquery.tablesorter.widgets.min.js"></script>
		<script>
			$(function() {
				$("table")
					.tablesorter({widthFixed: true, widgets: ['zebra']})
					.tablesorterPager({container: $("#pager")});	
			});
			
//开台验证
function checkTable(){
    var reg=/^[1-9]*$/;      
      var textBoxNum =document.getElementById("clientNum").value;
      if(!reg.test(textBoxNum))
      {
         alert("人数输入数字！");
         document.getElementById("clientNum").focus();
         return false;
      }
      

	var n=$("#clientNum").val();
		if(n!=""){
			$("#tableForm").submit();		
		}else{
			$("#span").html("请输入开台人数");
		}
}
			
		</script>
	</head>

	<body>
	<div class="tips" id="check"  >
	<div class="table_1"><b>开台</b></div>
	<form id="tableForm" action="${BasePath}/admin/addTable" method="post">
		餐桌:<input  type="text"  id="deskNo"  name="deskNo" readonly="readonly" /><br/>
		人数:<input type="text" id="clientNum" name="clientNum" /> &nbsp;
		服务员:<select name="waiterId" id="waiterId">
			<#list emps as emp>
			<option value="${emp.waiterId}">${emp.waiterName}</option>
			</#list>
		</select><br/>
		订金:<input type="text" name="payment" id="payment"/> &nbsp;&nbsp;&nbsp;&nbsp;
		VIP:<input type="checkbox" id="vip" name="vip" />是&nbsp;&nbsp;&nbsp;手机订单:<input type="checkbox" id="phone" name="phone"/>是<br/>
		备注:<input type="text" id="remarks" name="remarks" /><span style="color:red" id="span" ></span><br/>
		<input  class="cancel" onclick="checkTable();" type="button" value="开台"/>
		<input  class="cancel" id="cancel" type="reset" value="取消"/>
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
                   <a href="#" id="headerbtn1">开台</a>
                   <a href="${BasePath}/admin/tomean" id="headerbtn2">点餐</a>
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
									<button id="left1_but" style="width: 100%;">开台</button>
									<div class="left1_img"></div>
									
									
								</div>
								<div id="left2" class="ui-helper-hidden">
									<button id="left2_but" style="width: 100%;">点餐</button>
									<ul id="menu_2">
										<li><a href="#">B</a>
										</li>
										<li><a href="#">Adamsville</a>
										</li>
										<li><a href="#">Addyston</a>
										</li>
										<li><a href="#">Saarland</a>
										</li>
									</ul>
								</div>
								<div id="left3" class="ui-helper-hidden">
									<button id="left3_but" style="width: 100%;">订单</button>
									<ul id="menu_3">
										<li><a href="#">C</a>
										</li>
										<li><a href="#">Adamsville</a>
										</li>
										<li><a href="#">Addyston</a>
										</li>
										<li><a href="#">Saarland</a>
										</li>
									</ul>
								</div>
								<div id="left4" class="ui-helper-hidden">
									<button id="left4_but" style="width: 100%;">结账</button>
									<ul id="menu_4">
										<li><a href="#">D</a>
										</li>
										<li><a href="#">Adamsville</a>
										</li>
										<li><a href="#">Addyston</a>
										</li>
										<li><a href="#">Saarland</a>
										</li>
									</ul>
								</div>
							</div>
						</td>
						<td id="tablesecend">
							<div id="content_right" class="content_right">
									<table cellspacing="1" id="tablesorter" style="text-align: center;" >
										<thead>
											<tr >
  												<#list list1 as desk>
  													<#if desk.bookMark==2>
  														<td  style="background: #C77405;" ><a href="#" >${desk.deskName}<br/>${desk.id}<br/>已订</a></td>
  															<#elseif desk.bookMark==3>
  																<td  style="background: #D9534F;"><a href="#">${desk.deskName}<br/>${desk.id}<br/>就餐</a></td>
  																	<#else>		
  																<td><a href="#" onclick="table(${desk.id},${desk.deskNo});">${desk.deskName}<br/>${desk.id}</a></td>
  													</#if>
  												</#list>
  											</tr>
											<tr >
  												<#list list2 as desk1>
  													<#if desk1.bookMark==2>
  														<td  style="background: #C77405;"><a href="#" >${desk1.deskName}<br/>${desk1.id}<br/>已订</a></td>
  													<#elseif desk1.bookMark==3>
  														<td  style="background: #D9534F;"><a href="#" >${desk1.deskName}<br/>${desk1.id}<br/>就餐</a></td>
  													<#else>		
  														<td ><a href="#" onclick="table(${desk1.id},${desk1.deskNo});">${desk1.deskName}<br/>${desk1.id}</a></td>
  													</#if>
  												</#list>
  											</tr>
  		
  											<tr >
  												<#list list3 as desk2>
  													<#if desk2.bookMark==2>
  														<td  style="background: #C77405;" ><a href="#" >${desk2.deskName}<br/>${desk2.id}<br/>已订</a></td>
  													<#elseif desk2.bookMark==3>
  														<td  style="background: #D9534F;"><a href="#">${desk2.deskName}<br/>${desk2.id}<br/>就餐</a></td>
  													<#else>		
  														<td><a href="#" onclick="table(${desk2.id},${desk2.deskNo});">${desk2.deskName}<br/>${desk2.id}</a></td>
  													</#if>
  												</#list>
  										</tr>
											
										</thead>
									</table>
									<div id="pager" class="pager">
											<!--
										<form>
											<img src="${BasePath}/res/wangcao/img/page/first.png" class="first" />
											<img src="${BasePath}/res/wangcao/img/page/prev.png" class="prev" />
											<input type="text" class="pagedisplay" id="tabs1input" />
											<img src="${BasePath}/res/wangcao/img/page/next.png" id="tabs1next" onclick="tabs1next()" class="next" />
											<img src="${BasePath}/res/wangcao/img/page/last.png" class="last" />
											<select class="pagesize">
												<option selected="selected" value="10">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
												<option value="40">40</option>
											</select>
										</form>
											-->
										<#if deskPage.pageNow==1>
												<a href="#">上一页</a>
											<#else>
												<a href="${BasePath}/admin/totable?pageNo=${deskPage.pageNow-1}">上一页</a>									
										</#if>
										<a href="#">第${deskPage.pageNow}页</a>
										<#if deskPage.pageNow==deskPage.totalPageCount>
												<a href="#">下一页</a>
											<#else>
												<a href="${BasePath}/admin/totable?pageNo=${deskPage.pageNow+1}">下一页</a>
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