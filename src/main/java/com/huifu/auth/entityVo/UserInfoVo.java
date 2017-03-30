package com.huifu.auth.entityVo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.entity.UserPassword;

@Component
public class UserInfoVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;
	private UserPassword userPassword;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserPassword getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(UserPassword userPassword) {
		this.userPassword = userPassword;
	}




}
