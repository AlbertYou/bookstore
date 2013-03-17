$(function() {
	$("#modifyPswForm").validate( {
		rules : {
			oldpsw : {
				required : true,
				rangelength : [6,20]
			},
			password : {
				required : true,
				rangelength : [6,20]
			},
			repeatepsw : {
				required : true,
				equalTo : "#password"
			}
		},
		messages : {
			oldpsw : {
				required : "密码不能为空",
				rangelength : "密码输入错误"
			},
			password : {
				required : "密码不能为空",
				rangelength : "密码输入错误"
			},
			repeatepsw : "两次密码输入不相同"
		}
	});
});