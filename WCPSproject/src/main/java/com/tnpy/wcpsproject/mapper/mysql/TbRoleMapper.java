package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.TbRole;

public interface TbRoleMapper {
    
	int insert(TbRole record);

	int insertSelective(TbRole record);

	TbRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(TbRole record);

	int updateByPrimaryKey(TbRole record);

	int deleteByPrimaryKey(String id);

	
}