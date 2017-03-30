function login() {
	form1.action = "login.action";
	document.form1.submit();
}


function toRegist(){
	form1.action = "toRegiste.action";
	document.form1.submit();
}


// 验证登录名
function checkUserName(){
	// 获取用户输入的登录名
	var userName = $("input[name='userInfo.userName']").val();
	// 进行判断，说明没有输入登录名
	if(userName.trim() == ""){
		// 给提示
		$("#codeId").addClass("error");
		$("#codeId").html("登录名不能为空");
	}else{
		// 登录名不为空，ajax请求，验证
		var url = "/Campus/user/checkUserName.action";
		var param = {"userName":userName};
		$.post(url,param,function(data){
			// 操作data，进行判断
			if(data && data == "no"){
				// 提示
				$("#codeId").addClass("error");
				$("#codeId").html("登录名已经存在");
			}else{
				$("#codeId").removeClass("normal");
				$("#codeId").html("可以注册");
			}
		});
	}
}

// 可以阻止表单的提交
function checkForm(){
	// 先让校验名称的方法先执行以下
	checkCode();
	// 获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
	if($(".error").size() > 0){
		return false;
	}
}
// 可以阻止表单的提交
function checkForm() {
	// 先让校验名称的方法先执行以下
	checkCode();
	// 获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
	if ($(".error").size() > 0) {
		return false;
	}
}
