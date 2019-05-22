package com.tnpy.wcpsproject.service.impl;

import com.tnpy.wcpsproject.mapper.mysql.ContentMapper;
import com.tnpy.wcpsproject.model.mysql.Content;
import com.tnpy.wcpsproject.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contentService")
public class ContentServiceImpl implements IContentService {

	@Autowired
	ContentMapper contentMapper;

	@Override
	public int insert(final Content content) {
		return 0;
	}

	@Override
	public Content selectByPrimaryKey(final String id) {
		return null;
	}

	@Override
	public List<Content> listAll() {
		// TODO Auto-generated method stub
		return  contentMapper.listAll();
	}
	@Override
	public List<Content> HotPush() {
		// TODO Auto-generated method stub
		return  contentMapper.HotPush();
	}

	@Override
	public int deleteByPrimaryKey(final String id) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(final Content content) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(final Content content) {
		return 0;
	}


}
