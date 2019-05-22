package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.TbUser;
import org.apache.ibatis.annotations.Select;

public interface TbUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    @Select("select username from tb_user where username=#{username}")
    String selectByusername(String username);


}