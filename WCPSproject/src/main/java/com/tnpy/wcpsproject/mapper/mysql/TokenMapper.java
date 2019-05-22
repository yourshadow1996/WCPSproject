package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.common.utils.token.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TokenMapper {
    int deleteByPrimaryKey(String tokenid);


    int insertSelective(Token record);

    Token selectByPrimaryKey(String tokenid);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);

    @Update("update tb_token set tokenid = #{tokenid},token = #{token},buildtime = #{buildtime} where userid = #{userid}")
    int updateToken(Token record);
    @Insert(" insert into tb_token (tokenid, userid, token, buildtime) values (#{tokenid}, #{userid}, #{token}, #{buildtime})")
    int insertToken(Token record);
    @Select("select * from tb_token where userid = #{userid}")
    Token findByUserId(String userid);

}