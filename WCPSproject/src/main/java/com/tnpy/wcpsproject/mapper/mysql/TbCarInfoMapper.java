package com.tnpy.wcpsproject.mapper.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tnpy.wcpsproject.model.mysql.TbCarInfo;
import org.apache.ibatis.annotations.Update;

public interface TbCarInfoMapper {
    int deleteByPrimaryKey(String carlicence);

    int insert(TbCarInfo record);

    int insertSelective(TbCarInfo record);

    TbCarInfo selectByPrimaryKey(String carlicence);

    int updateByPrimaryKeySelective(TbCarInfo record);

    int updateByPrimaryKey(TbCarInfo record);
/*
    @Select("select * from tb_carinfo where status != '-1'  ${filter} order by registrationTime desc limit 1000")
    List<TbCarInfo> listAll(@Param("filter") String filter);
*/
    @Select("SELECT a.carLicence,a.carType,a.carColor,a.driverName,a.driverPhone,a.emergencyContact,a.emergencyPhone,a.registrationTime," +
            " case when  b.endTime  is null then '未办通行证' else '已办通行证' end as status FROM tb_carinfo a left join " +
            "( select carLicence as carLicencePasser,endTime  from  tb_laissezpasserinfo where status != '-1' and endTime > Now()) b " +
            " on a.carLicence = b.carLicencePasser  where a.status != '-1'  ${filter} order by registrationTime desc limit 1000")
    List<TbCarInfo> listAll(@Param("filter") String filter);

    @Update("update tb_carinfo set status = '-1' where carLicence = #{carlicence}")
    int deleteByChangeStatus(String carlicence);
}