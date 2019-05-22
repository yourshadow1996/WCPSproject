package com.tnpy.common.utils.token;

import java.util.UUID;

/**
 * @Description: TODO
 * @Author: LLS
 * @Date: 2018/12/1914:31
 */
public class TokenUtil {

    //生成Token信息方法（根据有效的用户信息）
    public  Token creatToken(String userID) {
        Token token = new Token();
        token = new Token();
        token.setTokenid(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        token.setToken(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        token.setBuildtime(System.currentTimeMillis());
        token.setUserid(userID);
        return  token;
    }
}
