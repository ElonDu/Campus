package com.huifu.auth.entity;

import java.io.Serializable;

public class User implements Serializable {
//	DROP TABLE IF EXISTS `user_info`;
//	CREATE TABLE `user_info` (
//	  `USER_ID` int(6) NOT NULL AUTO_INCREMENT,
//	  `USER_NAME` varchar(20) NOT NULL,
//	  `GENDER` varchar(1) DEFAULT NULL,
//	  `ROLE_ID` varchar(1) DEFAULT NULL,
//	  `USER_MOBILE` varchar(11) DEFAULT NULL,
//	  `USER_ADDR` varchar(60) DEFAULT NULL,
//	  `CREATE_TIME` varchar(14) DEFAULT NULL,
//	  `USER_STATE` varchar(1) DEFAULT NULL,
//	  `LST_UPD_TIME` varchar(14) DEFAULT NULL,
//	  PRIMARY KEY (`USER_ID`)
//	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_name;
	private String gender;
	private String role_id;
	private String user_mobile;
	private String user_addr;
	private String create_time;
	private String user_state;
	private String lst_upd_time;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getLst_upd_time() {
		return lst_upd_time;
	}
	public void setLst_upd_time(String lst_upd_time) {
		this.lst_upd_time = lst_upd_time;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", gender=" + gender + ", role_id=" + role_id
				+ ", user_mobile=" + user_mobile + ", user_addr=" + user_addr + ", create_time=" + create_time
				+ ", user_state=" + user_state + ", lst_upd_time=" + lst_upd_time + "]";
	}
	
	
}
