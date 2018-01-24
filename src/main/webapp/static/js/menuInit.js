$(function(){
	var curr = $(".content-header .breadcrumb li");
	var allLi = $(".sidebar-menu").find("li");
	out:for(var k=curr.length-1;k>=0;k--){//循环页面的导航栏，从低等级开始
		for(var i=0;i<allLi.length;i++ ){//循环所有菜单
			if(allLi.eq(i).find("a").eq(0).text().trim() == curr.eq(k).text().trim()){//菜单名称匹配
				var parentIds = allLi.eq(i).attr("parentIds");//取出菜单路径
				var parentIdArr = parentIds.split("/");
				for(var j=0;j<parentIdArr.length;j++){//循环所有父菜单
					$("#menu-"+parentIdArr[j].trim()).addClass("active");
				}
				allLi.eq(i).addClass("active");
				break out;
			}
		}
	}
})