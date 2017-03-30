package com.huifu.auth.dao;

import java.util.List;

import com.huifu.auth.entity.UserPassword;
import com.huifu.auth.entity.UserPasswordExample;

public interface UserPasswordMapper {
    int countByExample(UserPasswordExample example);

    int deleteByExample(UserPasswordExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    List<UserPassword> selectByExample(UserPasswordExample example);

    UserPassword selectByPrimaryKey(Integer userId);

    int updateByExampleSelective( UserPassword record,  UserPasswordExample example);

    int updateByExample( UserPassword record, UserPasswordExample example);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);
    
}