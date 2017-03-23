package com.huifu.auth.entityVo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserInfoVo implements Serializable {
	// DROP TABLE IF EXISTS `user_info`;
	// CREATE TABLE `user_info` (
	// `USER_ID` int(6) NOT NULL AUTO_INCREMENT,
	// `USER_NAME` varchar(20) NOT NULL,
	// `GENDER` varchar(1) DEFAULT NULL,
	// `ROLE_ID` varchar(1) DEFAULT NULL,
	// `USER_MOBILE` varchar(11) DEFAULT NULL,
	// `USER_ADDR` varchar(60) DEFAULT NULL,
	// `CREATE_TIME` varchar(14) DEFAULT NULL,
	// `USER_STATE` varchar(1) DEFAULT NULL,
	// `LST_UPD_TIME` varchar(14) DEFAULT NULL,
	// PRIMARY KEY (`USER_ID`)
	// ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private String gender;
	private String roleId;
	private String userMobile;
	private String userAddr;
	private String createTime;
	private String userState;
	private String lstUpdTime;
	private String userPwd;
	
	private UserInfoVo userInfoVo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getLstUpdTime() {
		return lstUpdTime;
	}

	public void setLstUpdTime(String lstUpdTime) {
		this.lstUpdTime = lstUpdTime;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", roleId=" + roleId
				+ ", userMobile=" + userMobile + ", userAddr=" + userAddr + ", createTime=" + createTime
				+ ", userState=" + userState + ", lstUpdTime=" + lstUpdTime + ", userPwd=" + userPwd + "]";
	}

	public UserInfoVo getUserInfoVo() {
		return userInfoVo;
	}

	public void setUserInfoVo(UserInfoVo userInfoVo) {
		this.userInfoVo = userInfoVo;
	}

}
