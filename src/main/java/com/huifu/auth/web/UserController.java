package com.huifu.auth.web;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;

import com.huifu.auth.entityVo.UserInfoVo;
import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.service.UserService;

/*
 * http://localhost:8080/Campus/user/registe
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 跳转到注册页面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login"; // regist.jsp
	}

	@RequestMapping("/toRegiste")
	public String toRegist() {
		return "regist"; // regist.jsp
	}

	// 注册用户
	@RequestMapping("/registe")
	public String regist(UserInfoVo userInfoVo) {
		userService.save(userInfoVo);
		return "login"; // regist.jsp
	}

	/**
	 * 判断用户名是否存在
	 */
	@RequestMapping("/checkUserName")
	public void checkCode(HttpServletResponse response, UserInfo userInfo) {
		// 调用业务层查询
		List list = userService.checkUserName(userInfo);
		response.setContentType("text/html;utf-8");

		try {
			PrintWriter writer = response.getWriter();
			if (list != null && list.size() > 0) {
				// 说明查询到用户，不能注册
				writer.print("no");
			} else {
				// 说明没有登陆名，可以注册
				writer.print("yes");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping("/login")
	public String login(UserInfoVo userInfoVo) {
		List<UserInfo> list = userService.login(userInfoVo);
		if (list == null) {
			return "login_error";
		} else {
			// 登陆成功
			// ServletActionContext.getRequest().getSession().setAttribute("existUser",
			// existUser);
			// return "loginOK";
			return "campus";
		}
	}

	@RequestMapping("/campus_top")
	public String campus_top() {
		return "campus_top";
	}

	@RequestMapping("/campus_menu")
	public String campus_menu() {
		return "campus_menu";
	}

	@RequestMapping("/campus_main")
	public String campus_main() {
		return "campus_main";
	}

	//
	// public String exit(){
	// ServletActionContext.getRequest().getSession().removeAttribute("existUser");
	// return LOGIN;
	// }
}
