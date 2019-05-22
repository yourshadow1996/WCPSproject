package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.Fenci;
import com.tnpy.wcpsproject.model.mysql.Fenci_Show;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FenciMapper {
    int insert(Fenci record);

    int insertSelective(Fenci record);
   //高频词云可视化SQL
    @Select("select ci as name, val as value from fenci where title = #{title} limit 20")
    List<Fenci_Show> listAll(@Param("title") String title);

}