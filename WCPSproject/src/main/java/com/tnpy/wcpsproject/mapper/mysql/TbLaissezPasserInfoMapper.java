package com.tnpy.wcpsproject.mapper.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tnpy.wcpsproject.model.mysql.TbLaissezPasserInfo;
import org.apache.ibatis.annotations.Update;

public interface TbLaissezPasserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbLaissezPasserInfo record);

    int insertSelective(TbLaissezPasserInfo record);

    TbLaissezPasserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbLaissezPasserInfo record);

    int updateByPrimaryKey(TbLaissezPasserInfo record);

    @Select("select * from tb_laissezpasserinfo where status != '-1'  ${filter} order by laissezPasserID  limit 1000")
    List<TbLaissezPasserInfo> listAll(@Param("filter") String filter);

    @Select("select count(1) from tb_laissezpasserinfo where status != '-1'  and carLicence = #{carLicence} and endTime > Now()")
    String selectByCarLicenceTime(String carLicence);

    @Update("update tb_laissezpasserinfo set status = '-1' where id = #{id}")
    int deleteByChangeStatus(String id);
}