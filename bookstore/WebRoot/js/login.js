$(function() {        		
    		$("#loginForm").validate( {
        		rules: {
    				username: {
    					required: true,
    					rangelength: [2,10]
    				},
    				password: {
    					required: true,
    					rangelength: [6,20]
    				},
    				validcode: {
    					required: true,
    					rangelength: [4,4]
    				}
    			},
    			messages: {
    				username: "用户名输入错误",
    				password: "密码输入错误",
    				validcode: "验证码输入错误"
    			}
    		});
    		$("#username").focus(function() {
    			var name = $(this).val();
    			if(name == "请输入用户名或邮箱...") {
    				$(this).val("");
    				$(this).removeClass("default_name_input");
    			}
    		});
    		$("#username").blur(function() {
        		var url = "existusernameoremail.action";
        		$.ajax( {
            		url: url,
            		type: "POST",
            		dataType: "text",
            		data: {"username" : $("#username").val()},
            		success: function(data) {
        				if(data == "false") {
        					if($("#username").val() == "") {
        						$("#username_error").text("用户名不能为空");
        		    				$("#username").val("请输入用户名或邮箱...");
        		    				$("#username").addClass("default_name_input");
        					} else {
        						$("#username_error").text("用户名不存在");
        					}
            			} else {
                    		$("#username_error").text("");
            			}
        			}
        		});
    		});
});