package com.huifu.auth.service;

import java.util.List;

import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.entityVo.UserInfoVo;

public interface UserService {

	public List login(UserInfoVo userInfoVo);
	
	public void save(UserInfoVo userInfoVo);

	public List checkUserName(UserInfo userInfo);

}
