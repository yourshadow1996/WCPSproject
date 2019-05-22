package com.tnpy.wcpsproject.service.impl;

import java.util.List;

import com.tnpy.wcpsproject.mapper.mysql.TbCarInfoMapper;
import com.tnpy.wcpsproject.model.mysql.TbCarInfo;
import com.tnpy.wcpsproject.service.IVehicleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vehicleRegisterService")
public class VehicleManageServiceImpl implements IVehicleManageService {
	@Autowired
	TbCarInfoMapper tbCarInfoMapper;
	
	@Override
	public int insert(TbCarInfo tbcarinfo) {
		// TODO Auto-generated method stub
		return tbCarInfoMapper.insert(tbcarinfo);
	}

	@Override
	public TbCarInfo selectByPrimaryKey(String id) {
		TbCarInfo tbcar = tbCarInfoMapper.selectByPrimaryKey(id);
		return tbcar;
	}

	@Override
	public List<TbCarInfo> listAll(String filter) {
		// TODO Auto-generated method stub
		List<TbCarInfo> lstbcar = tbCarInfoMapper.listAll(filter);
		return lstbcar;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return tbCarInfoMapper.deleteByChangeStatus(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TbCarInfo tbcarinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TbCarInfo tbcarinfo) {
		// TODO Auto-generated method stub
		return tbCarInfoMapper.updateByPrimaryKey(tbcarinfo);
	}

}
