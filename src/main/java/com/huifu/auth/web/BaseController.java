package com.huifu.auth.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.qqy.domain.User;

public class BaseController {

	
	public static void main(String[] args) {
		System.out.println("Hello");
	}
	
	/**
	 * 通过登录名判断登录名是否存在
	 */
	
	public String checkCode(){
//		调用业务层查询
		
		User u = userService.checkCode(user.getUser_code());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;utf-8");
		
		try {
			PrintWriter writer = response.getWriter();
			if(u!=null){
//				说明查询到用户，不能注册
				writer.print("no");
			}else{
//				说明没有登陆名，可以注册
				writer.print("yes");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return NONE;
	}
}
