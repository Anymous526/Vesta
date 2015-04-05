<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="${BasePath}/res/css/jquery-ui-1.10.4.custom.min.css">
		<link rel="stylesheet" type="text/css" href="${BasePath}/res/css/style.css" />
		<script src="${BasePath}/res/wangcao/js/jquery-1.10.2.js"></script>
		<script src="${BasePath}/res/wangcao/js/jquery-ui-1.10.4.custom.min.js"></script>
		<title>无线点餐-登录</title>
		<style>
			label {
				display: inline-block;
				width: 7em;
			}
		</style>
		<script>
			$(function() {
				$(document).tooltip();
				$("#login_sub")
					.button()
					.click(function() {
						location.href = "desk.html";
					});
				/***对话框***/
				$("#dialog").dialog({
					autoOpen: false,
					show: {
						effect: "blind",
						duration: 500
					},
					hide: {
						effect: "explode",
						duration: 500
					}
				});

				$("#houtaisys").button().click(function() {
					$("#dialog").dialog("open");
				});
			});
		</script>

	</head>

	<body>
		<div class="frist"> </div>
		<div class="secend">
			<div class="content">
				<form id="form1" name="form1" method="post" action="${BasePath}/admin/login ">
				<table class="secend_table">
					<tr>
						<td><font size="5">登录:</font>
						</td>
						<td>
							<input id="login_name" name="username" title="员工ID...">
						</td>
						<td>
							<input id="login_password" name="password" title="密码...">
						</td>
						<td>
							<input id="login_sub" class="ui-corner-left" type="submit" value="进入系统">
						</td>
						<td>
							<img class="login_img" src="${BasePath}/res/img/login_go.jpg">
						</td>
					</tr>

				</table>
				 </form>
				<div class="houtai">
					<table>
						<tr>
							<td>
								<input id="houtaisys" type="button" value="后台管理" />
							</td>
							<td>
								<img class="login_img" src="${BasePath}/res/img/login_go.jpg">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<!--  对话框   -->
		<div id="dialog" title="Basic dialog">
		<form id="form1" name="form1" method="post" action="${BasePath}/admin/toSysLogin ">
			<table>
				<tr>
					<td nowrap="nowrap">用户名：</td>
					<td>
						<input type="text" name="username" /> </td>
				</tr>
				<tr>
					<td>密 码：</td>
					<td>
						<input type="text" name="password" />
					</td>
				</tr>
				<tr>
					<td colspan="2" style="float: right;">
						
						<input type="submit" value="进入" />
						
					</td>
				</tr>
			</table>
		</form>
		</div>

	</body>

</html>