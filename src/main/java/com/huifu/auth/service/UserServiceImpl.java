package com.huifu.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huifu.auth.dao.UserInfoMapper;
import com.huifu.auth.dao.UserPasswordMapper;
import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.entity.UserPassword;
import com.huifu.auth.entityVo.UserInfoVo;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserInfoMapper userMapper;
	@Autowired
	private UserPasswordMapper userPwdMapper;

//	public UserInfoVo login(UserInfo user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void save(UserInfoVo userInfoVo) {
		try {
		UserInfo user = new UserInfo();
		UserPassword pwd = new UserPassword();
		user.setUserId(1);
		user.setUserName(userInfoVo.getUserName());
		userMapper.insert(user);
		
		pwd.setUserId(user.getUserId());
		pwd.setUserPsw(userInfoVo.getUserPwd());
		userPwdMapper.insert(pwd);
		System.out.println("-------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public UserInfo login(UserInfo user) {
//		UserInfo userInfo = userMapper.selectByPrimaryKey(user);
//		return list;
//	}

	public void save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	public List login(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

}
