package com.huifu.auth.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huifu.auth.entityVo.UserInfoVo;
import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.service.UserService;


/*
 * http://localhost:8080/Campus/user/registe
 */
@Controller
@RequestMapping("/user")
public class UserController{

	@Autowired
	private UserService userService;
	
    //跳转到注册页面
	@RequestMapping("/toRegiste")
	public String toRegist(){
		System.out.println("注册123。。。。。");
		return "regist"; // regist.jsp
	}
	
	//注册用户
	@RequestMapping("/registe")
	public String regist(UserInfoVo userInfoVo){
		System.out.println("注册345。。。。。");
		userService.save(userInfoVo);
		return "login"; //regist.jsp
	}
	
//	/**
//	 * 通过登录名判断登录名是否存在
//	 */
//	
//	public String checkCode(){
////		调用业务层查询
//		
//		User u = userService.checkCode(user.getUser_code());
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("text/html;utf-8");
//		
//		try {
//			PrintWriter writer = response.getWriter();
//			if(u!=null){
////				说明查询到用户，不能注册
//				writer.print("no");
//			}else{
////				说明没有登陆名，可以注册
//				writer.print("yes");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return NONE;
//	}
//	
	@RequestMapping("/login")
	public void  login(UserInfo userInfo){
		userInfo = new UserInfo();
		System.out.println("------------2--------------");
		userInfo.setUserName("11");
		List<UserInfo> list=   userService.login(userInfo);
		if(list==null){
			System.out.println("--------null");
		}else{
//			登陆成功
//			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
//			return "loginOK";
			System.out.println("--------ok");
		}
	}
//	
//	public String exit(){
//		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
//		return LOGIN;
//	}
}
