/*$(function(){
	$("#pop-layer").hide();
	 $(".welcome-immediately-bet").click(function(){
		$("#pop-layer").show("500");
		$("#all").show();
	});

	$("#all").click(function(){
		$("#pop-layer").hide();
		$("#all").hide();
	});
});

*/




//下面开始upper-lower部分
$(function(){
	$(".upper-lower").hide();
	 $(".welcome-follow-list-content-more").click(function(){
	 	var X = getElementPosition(this).x;
		var Y = getElementPosition(this).y;
		console.log(X+"<br />");
		console.log(Y+"<br />");
		$(".upper-lower").slideDown(500).css("top",Y).css("left",X);
		$("#all").show();
	});

	$("#all").click(function(){
		$(".upper-lower").hide();
		$("#all").hide();
	});
});



$(function(){
	$(".upper-lower").hide();
	 $(".welcome-win-xibao-content-more").click(function(){
	 	var X = getElementPosition(this).x;
		var Y = getElementPosition(this).y;
		console.log(X+"<br />");
		console.log(Y+"<br />");
		$(".upper-lower").slideDown(500).css("top",Y).css("left",X);
		$("#all").show();
	});

	$("#all").click(function(){
		$(".upper-lower").hide();
		$("#all").hide();
	});
});


function getElementPosition(el) { 
	var obj=el,offset=new Object(),x=0,y=0; 
	while(obj&&obj.tagName != "BODY") { 
		x+=obj.offsetLeft; 
		y+=obj.offsetTop; 
		obj=obj.offsetParent;
	}
	offset.x=x;//这里可以加减
	offset.y=y;
	return offset; 
}
/*上面结束upper-lower部分*/



  





/*
$(document).ready(function(){
  $(".today-some-football-team li div").click(function(){
    $(this).toggleClass("actice");
  });
});*/















//下面开始问号提示层
$(document).ready(function(){
     $(".welcome-question").mouseover(function(){
        $(".poptip").show();
    });
$(".welcome-question").mouseout(function(){
     $(".poptip").hide();
      });
});
//上面结束问号提示层



/*
$(document).ready(function(){
  $(".welcome-question").hover(function(){
    $(".popspan").toggle("poptip");
  });
 });*/






//下面这段是注册登录框部分
$(function(){
	 $(".welcome-immediately-bet").click(function(){
		$("#pop-outer").show("500");
		$("#all-login").show();
	});
	$("#all-login").click(function(){
		$("#all-login").show();
	});
    $(".icon-close").click(function(){
		$("#pop-outer").hide("500");
		$("#all-login").hide();
	});
	$(".poplogin-left input").focus(function(){
		$(this).css("color","#000");
	});
	$(".poplogin-left input").blur(function(){
		$(this).css("color","#A8A8A8");
	});
});
//上面这段是注册登录框部分







