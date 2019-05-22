package com.tnpy.wcpsproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tnpy.common.Enum.StatusEnum;
import com.tnpy.common.utils.web.TNPYResponse;
import com.tnpy.wcpsproject.mapper.mysql.FenciMapper;
import com.tnpy.wcpsproject.model.mysql.Fenci_Show;
import com.tnpy.wcpsproject.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//高频词云可视化
@RestController
@RequestMapping(value = "/fenci")
public class FenCiController {

    @Autowired
    FenciMapper fenciMapper;

    @Resource
    IContentService contentService;

    @RequestMapping(value = "/listAll")
    public TNPYResponse listAll(String articleTitle ) {

        TNPYResponse response = new TNPYResponse();
        try
        {
            List<Fenci_Show> rs = fenciMapper.listAll(articleTitle);
//            Map<String,Object> m = new HashMap<String, Object>();
//            m.put("name","分词");
//            m.put("children",rs );
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
