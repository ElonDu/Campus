package com.huifu.auth.dao;

import java.util.List;


import com.huifu.auth.entity.UserInfo;
import com.huifu.auth.entity.UserInfoExample;
import com.huifu.auth.entityVo.UserInfoVo;

public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(UserInfo record, UserInfoExample example);

    int updateByExample( UserInfo record, UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    List<UserInfoVo> selectByNameAndPassWord(UserInfoVo vo); 
}