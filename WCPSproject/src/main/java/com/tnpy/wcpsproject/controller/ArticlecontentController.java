package com.tnpy.wcpsproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tnpy.common.Enum.StatusEnum;
import com.tnpy.common.utils.web.TNPYResponse;
import com.tnpy.wcpsproject.mapper.mysql.ArticlecontentMapper;
import com.tnpy.wcpsproject.model.mysql.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
//文章详情展示
@RestController
@RequestMapping(value = "/api/article")
public class ArticlecontentController {
    @Autowired
    private ArticlecontentMapper articlecontentMapper;

    @RequestMapping(value = "/getarticledetailbyid")
    public TNPYResponse getArticleDetailByID(String articleID ) {
        TNPYResponse response = new TNPYResponse();
        try
        {
            List<Content> rs = articlecontentMapper.getArticleDetailByID(articleID);
            response.setData(JSONObject.toJSONString(rs, SerializerFeature.WriteMapNullValue).toString());
            response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
            response.setMessage("返回查询结果");
            return  response;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            response.setMessage("获取数据失败失败,请联系管理员");
            return  response;
        }
    }
}
