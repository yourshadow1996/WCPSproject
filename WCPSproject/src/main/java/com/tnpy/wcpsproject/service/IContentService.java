package com.tnpy.wcpsproject.service;

import com.tnpy.wcpsproject.model.mysql.Content;

import java.util.List;

public interface IContentService {
	int insert(Content content);

	Content selectByPrimaryKey(String id);
	
	List<Content> listAll();

	List<Content> HotPush();

	int deleteByPrimaryKey(String id);
	
	int updateByPrimaryKeySelective(Content content);

	int updateByPrimaryKey(Content content);


}
