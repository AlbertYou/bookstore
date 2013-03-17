$(function() {
	$("#findPswForm").validate( {
		rules : {
			username : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			validcode : {
				required : true
			}
		},
		messages : {
			username : "用户名输入错误",
			email : "邮箱输入错误",
			validcode : "验证码输入错误"
		}
	});
	$("#username").blur(function() {
		var url = "existusername.action";
		$.ajax({
    		url: url,
    		type: "POST",
    		dataType: "text",
    		data: {"username": $("#username").val()},
    		success: function(data) {
    			if(data == "false") {
            		$("#username_error").text("用户名输入错误");
    			} else {
            		$("#username_error").text("");
    			}
			}
		});
	});
	
	$("#email").blur(function() {
		var url = "existemail.action";
		$.ajax({
    		url: url,
    		type: "POST",
    		dataType: "text",
    		data: {"email": $("#email").val()},
    		success: function(data) {
    			if(data == "false") {
            		$("#email_error").text("邮箱输入错误");
    			} else {
            		$("#email_error").text("");
    			}
			}
		});
	});
});