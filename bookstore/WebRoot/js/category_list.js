$(function() {
	$(".showsecondlevel").toggle(function() {
		$(this).parent(".firstlevel_info").next(".secondlevel").slideDown(800);
		$(this).text("-");
	}, function() {
		$(this).parent(".firstlevel_info").next(".secondlevel").slideUp(800);
		$(this).text("+");
	});
});
function addcategory() {
	apprise("增加一级分类", {'input' : true}, function(category) {
		if (category) {
			var url = "hastopcategory.action";
    		$.ajax( {
    			url : url,
    			type : "POST",
    			dataType : "json",
    			data: {"category": category},
    			success : function(data) {
    				if (data.result == "exist") {
    					$("#operate_result").text("分类 " + category + " 已存在");
    				} else {
	    				location.href = "addtopcategory.action?category=" + category;
    				}
    			}
    		});
		}
	});
}
function addchildcategory(parent, name) {
	apprise("增加&nbsp;" + name + "&nbsp;子分类", {
		'input' : true
	}, function(category) {
		if (category) {
			location.href = "addlowcategory.action?category=" + category
					+ "&parent=" + parent;
		}
	});
}
function moidfytopcategory(categoryId, name) {
	apprise("修改分类&nbsp;" + name, {'input' : true}, function(category) {
		if (category) {
			location.href = "modifytopcategory.action?categoryId=" + categoryId
					+ "&category=" + category;
		}
	});
}
function moidfylowcategory(categoryId, name, parentId) {
	apprise("修改子分类&nbsp;" + name, {'input' : true}, function(category) {
		if (category) {
			location.href = "modifylowcategory.action?categoryId=" + categoryId
					+ "&category=" + category + "&parentId=" + parentId;
		}
	});
}

function deletecategory(categoryId) {
	topCategoryService.getChildrenCount(categoryId, callba);
	location.href = "categorylist.action";
}
function callba(data) {
	alert(data);
}
function deletechildcategory(t, categoryId) {
	var url = "deletelowcategory.action";
	$.ajax( {
		url : url,
		type : "POST",
		dataType : "json",
		data: {"categoryId": categoryId},
		success : function(data) {
			if (data.result == "success") {
				$(t).parent(".secondlevel_delete").parent(".secondlevel_info")
						.parent(".secondlevel_item").remove();
				$("#operate_result").text("删除成功");
			} else {
				$("#operate_result").text("由于该分类任有许多图书，因此不能删除");
			}
		}
	});
}
function deletetopcategory(t, categoryId) {
	var url = "deletetopcategory.action";
	$.ajax( {
		url : url,
		type : "POST",
		dataType : "json",
		data: {"categoryId": categoryId},
		success : function(data) {
			if (data.result == "success") {
				$(t).parent(".firstlevel_delete").parent(".firstlevel_info")
						.remove();
				$("#operate_result").text("删除成功");
			} else {
				$("#operate_result").text("删除失败,须先删除该分类的子类别");
			}
		}
	});
}