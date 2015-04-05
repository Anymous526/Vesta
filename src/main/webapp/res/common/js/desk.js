$(function() {
	$("#content_right").tabs();
	$("#menu_1").menu();
	$("#menu_2").menu();
	$("#menu_3").menu();
	$("#menu_4").menu();
	$("button").button({
		icons: {
			primary: "ui-icon-locked",
			secondary: "ui-icon-triangle-1-s"
		}
	});
		
	
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












