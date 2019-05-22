package com.tnpy.wcpsproject.service;

import com.tnpy.wcpsproject.model.mysql.Content;

import java.util.List;

public interface IArticlecontentService {
    int insert(Content content);

    Content selectByid(String id);

    List<Content> listAll();

    int deleteByid(String id);

    int updateByidSelective(Content content);

    int updateByid(Content content);
}

