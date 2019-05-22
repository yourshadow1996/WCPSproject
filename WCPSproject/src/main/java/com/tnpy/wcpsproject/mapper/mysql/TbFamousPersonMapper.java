package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.TbFamousPerson;

public interface TbFamousPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbFamousPerson record);

    int insertSelective(TbFamousPerson record);

    TbFamousPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbFamousPerson record);

    int updateByPrimaryKey(TbFamousPerson record);
}