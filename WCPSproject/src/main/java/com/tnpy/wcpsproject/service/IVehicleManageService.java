package com.tnpy.wcpsproject.service;

import java.util.List;

import com.tnpy.wcpsproject.model.mysql.TbCarInfo;

public interface IVehicleManageService {
	int insert(TbCarInfo tbcarinfo);
	 
	TbCarInfo selectByPrimaryKey(String id);
	
	List<TbCarInfo> listAll(String filter);
	
	int deleteByPrimaryKey(String userid);
	
	int updateByPrimaryKeySelective(TbCarInfo tbcarinfo);

	int updateByPrimaryKey(TbCarInfo tbcarinfo);
}
