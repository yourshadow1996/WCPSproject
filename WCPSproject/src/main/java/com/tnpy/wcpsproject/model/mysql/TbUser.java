package com.tnpy.wcpsproject.model.mysql;

public class TbUser {
    private String userid;

    private String username;

    private String password;

    private Integer stadu;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStadu() {
        return stadu;
    }

    public void setStadu(Integer stadu) {
        this.stadu = stadu;
    }
}