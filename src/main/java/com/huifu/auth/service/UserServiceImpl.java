package com.huifu.auth.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huifu.auth.dao.UserInfoMapper;
import com.huifu.auth.dao.UserPasswordMapper;
import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.entity.UserInfoExample;
import com.huifu.auth.entity.UserInfoExample.Criteria;
import com.huifu.auth.entity.UserPassword;
import com.huifu.auth.entityVo.UserInfoVo;
import com.huifu.auth.utils.CPublic;

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
		
		UserInfo user = userInfoVo.getUserInfo();
		UserPassword pwd = userInfoVo.getUserPassword();
		
		user.setCreateTime(CPublic.getDateAndTime());
		user.setUserState("1");
		userMapper.insert(user);
		
		pwd.setUserId(user.getUserId());
		pwd.setLstUpdTime(CPublic.getDateAndTime());
		userPwdMapper.insert(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	public List login(UserInfoVo userInfoVo) {
		
		List list = userMapper.selectByNameAndPassWord(userInfoVo);
		return list;
	}


	public List checkUserName(UserInfo userInfo) {
		List list = new ArrayList();
		UserInfoExample userInfoExample = new UserInfoExample();
		Criteria criteria = userInfoExample.createCriteria();    
		criteria.andUserNameEqualTo(userInfo.getUserName());
		list = userMapper.selectByExample(userInfoExample);
		return list;
	}


	public List login(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

}
