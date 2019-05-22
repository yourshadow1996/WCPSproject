package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.Tbarticle_heat;

public interface Tbarticle_heatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tbarticle_heat record);

    int insertSelective(Tbarticle_heat record);

    Tbarticle_heat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tbarticle_heat record);

    int updateByPrimaryKey(Tbarticle_heat record);
}