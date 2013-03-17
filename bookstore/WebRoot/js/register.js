$(function() {        		
    		$("#registerForm").validate({
        		rules: {
    				username: {
						required: true,
						rangelength: [2,10]
    				},
    				email: {
    					required: true,
    					email: true
    				},
    				password: {
						required: true,
						rangelength: [6,20]
    				},
    				repeatPassword: {
    					required: true,
    					equalTo: "#password"
    				},
    				phone: {
    					digits: true,
    					rangelength: [11,11]
    				}
    			},
    			messages: {
    				username: {
    					required: "用户名不能为空",
    					rangelength: "用户名长度必须大于2小于10"
    				},
    				email: {
    					required: "邮箱不能为空",
    					email: "请输入正确的邮箱"
    				},
    				password: {
    					required: "密码不能为空",
    					rangelength: "密码必须大于6小于20"
    				},
    				repeatPassword: "两次密码输入不相同",
    				phone: "请输入正确的手机号码"
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
	        			if(data == "true") {
	                		$("#username_error").text("用户名已注册");
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
	        			if(data == "true") {
	                		$("#email_error").text("邮箱已注册");
	        			} else {
	                		$("#email_error").text("");
	        			}
        			}
        		});
    		});
});