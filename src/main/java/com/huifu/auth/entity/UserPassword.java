package com.huifu.auth.entity;

public class UserPassword {
    private Integer userId;

    private String userPsw;

    private String lstUpdTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw == null ? null : userPsw.trim();
    }

    public String getLstUpdTime() {
        return lstUpdTime;
    }

    public void setLstUpdTime(String lstUpdTime) {
        this.lstUpdTime = lstUpdTime == null ? null : lstUpdTime.trim();
    }
}