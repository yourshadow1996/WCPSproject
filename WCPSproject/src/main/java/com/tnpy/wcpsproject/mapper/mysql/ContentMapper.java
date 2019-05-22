package com.tnpy.wcpsproject.mapper.mysql;

import com.tnpy.wcpsproject.model.mysql.Content;
import com.tnpy.wcpsproject.model.mysql.Content_QingGan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);
  //文章列表展示SQL
    @Select("select c.id,c.title,left(c.contents,100) as contents, c.author,c.craw_time  as crawTime," +
            "c.dianji_num as dianjiNum from content c ")
    List<Content> listAll();
//文章热度可视化SQL
    @Select("select craw_time as crawTime,dianji_num as dianjiNum from content where title = #{title} order by craw_time ")
    List<Content> selectByArticleTitle(String title);
    
//    @Select("select c.craw_time  as crawTime," +
//            "c.dianji_num as dianjiNum from content c where title = #{title} limit 10")
    //数量趋势可视化SQL
    @Select("select c.craw_time  as crawTime," +
            "c.dianji_num as dianjiNum  from content c where title =#{title} limit 10")
    List<Content> barShow(@Param("title") String title);
//热点推送SQL
@Select("select c.id,c.title,left(c.contents,100) as contents, c.author,c.craw_time  as crawTime," +
        "c.dianji_num as dianjiNum  from content c order by (dianji_num + 0) DESC limit 10")
//    @Select("SELECT\n" +
//            "\t*\n" +
//            "FROM\n" +
//            "\content\n" +
//            "ORDER BY\n" +
//            "\t(dianji_num + 0) DESC\n" +
//            "LIMIT 10")
    List<Content>HotPush();

    //文章正负面分析SQL
    @Select("(\n" +
            " SELECT\n" +
            "  m.word as p_word,\n" +
            "  m.strong AS p_strong,\n" +
            "CASE m.jixing\n" +
            " WHEN '0' THEN\n" +
            "  '无情感倾向'\n" +
            " WHEN '1' THEN\n" +
            "  '正面词汇'\n" +
            " ELSE\n" +
            "  '负面词汇'\n" +
            " END AS p_leibie,\n" +
            "  CASE m.jixing\n" +
            " WHEN '0' THEN\n" +
            "  '0'\n" +
            " WHEN '1' THEN\n" +
            "  '1'\n" +
            " ELSE\n" +
            "  '-1'\n" +
            " END AS p_jixing,\n" +
            " fc.val AS p_val\n" +
            "FROM\n" +
            " doc_qinggan_main m,\n" +
            " fenci fc\n" +
            "WHERE\n" +
            " fc.title = '这就是今晚的祝酒辞！'\n" +
            "AND m.word = fc.ci\n" +
            "GROUP BY\n" +
            " fc.ci\n" +
            ")\n" +
            "UNION ALL\n" +
            " (\n" +
            "  SELECT\n" +
            "   '最后总分数',\n" +
            "   '',\n" +
            "  '',\n" +
            "   '',\n" +
            "   COUNT((p_strong * p_jixing * p_val)) AS sum\n" +
            "  FROM\n" +
            "   (\n" +
            "    SELECT\n" +
            "     m.strong AS p_strong,\n" +
            "     CASE m.jixing\n" +
            "    WHEN '0' THEN\n" +
            "     '0'\n" +
            "    WHEN '1' THEN\n" +
            "     '1'\n" +
            "    ELSE\n" +
            "     '-1'\n" +
            "    END AS p_jixing,\n" +
            "    fc.val AS p_val\n" +
            "   FROM\n" +
            "    doc_qinggan_main m,\n" +
            "    fenci fc\n" +
            "   WHERE\n" +
            "    fc.title = '这就是今晚的祝酒辞！'\n" +
            "   AND m.word = fc.ci\n" +
            "   GROUP BY\n" +
            "    fc.ci\n" +
            "   ) AS rs\n" +
            " )")
    List<Content_QingGan> fenXi(String title);
}

