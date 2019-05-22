package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.TbSearchRecord;

public interface TbSearchRecordMapper {
    int insert(TbSearchRecord record);

    int insertSelective(TbSearchRecord record);
}