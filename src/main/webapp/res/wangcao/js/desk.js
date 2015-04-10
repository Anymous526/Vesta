$(function() {
	$("#content_right").tabs();
	$("#menu_1").menu();
	$("#menu_2").menu();
	$("#menu_3").menu();
	$("#menu_4").menu();
	
	$("#sys_add").button();
	$("#sys_update").button();
	$("#sys_delete").button();
	
	$("#sys_add_1").button();
	$("#sys_update_1").button();
	$("#sys_delete_1").button();
	//手机订单
	$("#headerbtn").button({
		text: false,
		icons: {
			primary: "ui-icon-mail-closed",
		}
	});
	
	
	//异步刷新取手机订单
	setInterval ("shows()", 20000);
	
	
	
    //获取checkbox的选中商品的id			
	var id=0;
	//用jQuery获取table中td值
    $("#myGoodsTable td input").click(function(){
        id=$(this).val();
    });
    
   
    	 
    //修改商品信息
    $("#sys_update").button().click(function() {
    	$.post("toUpdateGoods",{"id":id},function(returnData,status){
			var goods=returnData;
		var html="<i><input type='hidden' name='id' id='id' value='"+id+"'/>名称:<input type='text' name='name' id='name' value='"+goods.name+"'/><br/>类型:<select name='type' id='type'>"
		+"<option value='1'  if("+goods.type+"==1){selected='selected'}>特色</option><option value='2'  if("+goods.type+"==2){selected='selected'}>主食</option><option value='3'  if("+goods.type+"==3){selected='selected'}>热菜</option><option value='4'  if("+goods.type+"==4){selected='selected'}>凉菜</option><option value='5'  if("+goods.type+"==5){selected='selected'}>酒水</option></select><br/>"
	     +"图片:<input type='file' name='phto' id='phto' value='"+goods.phto+"'/><br/>"
	     +"介绍:<input type='text' name='introduce' id='introduce' value='"+goods.introduce+"'/><br/>"
	     +"价格:<input type='text' name='price' id='price' value='"+goods.price+"'元/份/><br/>"
	     +" 描&nbsp;&nbsp;述:<br/><textarea  rows='1' cols='50' name='description' id='description'>"+goods.description+"</textarea></i>"
		//清理以前的数据
		$("#table_1 i:eq(0)").remove();
			//添加新的
		$("#table_1").append(html);
	});
    	$("#check_1").show();	
		$("#table_1").show();
		
	});
    
    
    
    var deskId=0;
    $("#myDeskTable td input").click(function(){
        deskId=$(this).val();
    });
    
   
    $("#sys_update_1").button().click(function() {
    	$.post("toUpdateDesk",{"id":deskId},function(returnData,status){
			var desk=returnData;
			var html="<i><input type='hidden' name='id' id='id' value='"+deskId+"'/>桌位号:<input type='text' name='deskNo' id='deskNo' value='"+desk.deskNo+"'/><br/>"
	 				+"桌号名:<input type='text' name='deskName' id='deskName' value='"+desk.deskName+"'/><br/>楼&nbsp;&nbsp;层:<select name='type' id='type'>"
			 	 +"<option value='0'  if("+desk.type+"==1){selected='selected'}>大厅</option><option value='1' if("+desk.type+"==2){selected='selected'}>二楼</option></select><br/>"
	 			+"描&nbsp;&nbsp;述:<br/><textarea  rows='1' cols='50' name='description' id='description'>"+desk.description+"</textarea></i>";	
			//清理以前的数据
		$("#table_3 i:eq(0)").remove();
			//添加新的
		$("#table_3").append(html);
	});
			$("#check_3").show();	
    });
    
    
    
    
    
    	//删除商品信息
    	$("#sys_delete").button().click(function() {
    		var r = window.confirm("确定要删除此商品信息吗？\r\n删除后将不能恢复");
    		if(r){
    			window.location.href="delGoods?id="+id;
    		}
    	});	
    
	
  
	//删除桌位信息
    $("#sys_delete_1").button().click(function() {
    	  var r = window.confirm("确定要删除此桌位吗？\r\n删除后将不能恢复");
          if(r){
          window.location.href="delDesk?id="+deskId;
          }
    });
    
	
	
	
	
	
	$("#check").hide();
	$("#check_1").hide();
	$("#check_2").hide();
	$("#check_3").hide();
	$(".search").hide();

	$("#cancel").click(function(event) {
		$("#check").hide();	
	});
	
	
	$("#cancel_1").click(function(event) {
		$("#check_1").hide();	
	});
	
	$("#cancel_2").click(function(event) {
		$("#check_2").hide();	
	});
	
	$("#cancel_3").click(function(event) {
		$("#check_3").hide();	
	});
	
	
	$("#headerbtn").button({
		text:false,
		icons: {
			primary: "ui-icon-mail-closed",
			
		}
		
	});
	$("#headerbtn1").button();
	$("#headerbtn2").button();
	$("#headerbtn3").button();
	$("#headerbtn4").button();
	$("#left1_but").button({
		icons: {
			primary: "ui-icon-locked",
			secondary: "ui-icon-triangle-1-s"
		}
	});
	$("#left1_but2").button({
		icons: {
			primary: "ui-icon-locked",
			secondary: "ui-icon-triangle-1-s"
		}
	});
	$("#left2_but").button({
		icons: {
			primary: "ui-icon-locked",
			secondary: "ui-icon-triangle-1-s"
		}
	});
	$("#left3_but").button({
		icons: {
			primary: "ui-icon-locked",
			secondary: "ui-icon-triangle-1-s"
		}
	});
	$("#left4_but").button({
		icons: {
			primary: "ui-icon-locked",
			secondary: "ui-icon-triangle-1-s"
		}
	});
	 $("#tablesorter1").tablesorter({widthFixed: true, widgets: ['zebra']}) 
    .tablesorterPager({container: $("#pager")}); 
	/*$('#tablesorter1').tablesorter({
					widgets        : ['zebra', 'columns'],
					usNumberFormat : false,
					sortReset      : true,
					sortRestart    : true
				});

*/
	 
	 
	 
	
	 
});
/************** 图片切换效果**************/
var t;
var speed = 2; //图片切换速度 
var nowlan = 0; //图片开始时间 
function changepic() {
	var imglen = $("div[name='pic']").find("div").length;
	$("div[name='pic']").find("div").hide();
	$("div[name='pic']").find("div").eq(nowlan).show();
	nowlan = nowlan + 1 == imglen ? 0 : nowlan + 1;
	t = setTimeout("changepic()", speed * 1000);
}
onload = function() {
	changepic();
}
$(document).ready(function() {
	//鼠标在图片上悬停让切换暂停 
	$("div[name='pic']").hover(function() {
		clearInterval(t);
	});
	//鼠标离开图片切换继续 
	$("div[name='pic']").mouseleave(function() {
		changepic();
	});
});
/**********************************/
function left1but() {
	$("#left1").removeClass("ui-helper-hidden", 500);
	$("#left2").addClass("ui-helper-hidden", 500);
	$("#left3").addClass("ui-helper-hidden", 500);
	$("#left4").addClass("ui-helper-hidden", 500);
}

function left2but() {
	$("#left1").addClass("ui-helper-hidden", 500);
	$("#left2").removeClass("ui-helper-hidden", 500);
	$("#left3").addClass("ui-helper-hidden", 500);
	$("#left4").addClass("ui-helper-hidden", 500);
}

function left3but() {
	$("#left1").addClass("ui-helper-hidden", 500);
	$("#left2").addClass("ui-helper-hidden", 500);
	$("#left3").removeClass("ui-helper-hidden", 500);
	$("#left4").addClass("ui-helper-hidden", 500);
}

function left4but() {
	$("#left1").addClass("ui-helper-hidden", 500);
	$("#left2").addClass("ui-helper-hidden", 500);
	$("#left3").addClass("ui-helper-hidden", 500);
	$("#left4").removeClass("ui-helper-hidden", 500);
}

//开台
function table(id,deskNo){
		$("#deskNo").val(id);
		$("#check").show();
		setTimeout(function(){
					$("#check").hide();
				},70000);
		
	}
	
//就餐
function eate(id){
	location.href="eate?id="+id;
}
//异步刷新


function shows()
{
	$.ajax({
		url: '../wap/telmessage', //后台处理类
		type: "post",
		dataType: "json",
		success: function(data) {
			if(data){
				$("#headerbtn").css("display","none"); 
				$("#headerbtn_img").css("display","block"); 
			
			}else{
				$("#headerbtn").css("display","block"); 
				$("#headerbtn_img").css("display","none"); 
			}
		},
		error: function() {
			$("#headerbtn").css("display","block"); 
			$("#headerbtn_img").css("display","none");
		}
	});
}

function headerbtnimg(){
	$("#headerbtn").css("display","block"); 
	$("#headerbtn_img").css("display","none");
	alert("手机有新订单，请及时处理！");
}



