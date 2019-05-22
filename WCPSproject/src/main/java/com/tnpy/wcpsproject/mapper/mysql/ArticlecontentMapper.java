package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.Content;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ArticlecontentMapper {
    //文章列表展示
    @Select("select c.id,c.title,c.contents, c.author,c.craw_time  as crawTime," +
            "c.dianji_num as dianjiNum from content c")
    List<Content> listAll();
  //文章详情展示SQL
    @Select("select c.id,c.title,c.contents, c.author,c.craw_time  as crawTime," +
            "c.dianji_num as dianjiNum from content c  where id = #{id}")
    List<Content> getArticleDetailByID(String id);

    @Update("update content set dianji_num = dianji_num + 1 where id = #{id}")
    int updateDJNum(String id);
}
