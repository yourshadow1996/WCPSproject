package com.tnpy.wcpsproject.service.userService;

import com.tnpy.wcpsproject.model.mysql.TbUser;

public interface ITbUserService {
    String selectByusername(String username);

    public TbUser selectByPrimaryKey(String id);

    int insert(TbUser tbUser);
}
