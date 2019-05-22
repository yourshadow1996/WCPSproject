package com.tnpy.common.utils.web;

import com.tnpy.common.Enum.StatusEnum;

/**
 * @Description: TODO
 * @Author: LLS
 * @Date: 2018/12/19 14:37
 */
public class TNPYResponse {
    private int status= StatusEnum.ResponseStatus.Fail.getIndex();
    private String message="";
    private String data="";
    private String token="";

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
