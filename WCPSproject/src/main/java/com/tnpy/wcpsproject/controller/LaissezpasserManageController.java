package com.tnpy.wcpsproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tnpy.common.Enum.StatusEnum;
import com.tnpy.common.utils.web.TNPYResponse;
import com.tnpy.wcpsproject.model.mysql.TbLaissezPasserInfo;
import com.tnpy.wcpsproject.service.ILaissezpassersManageService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/laissezpasser")
public class LaissezpasserManageController {

	@Resource
	ILaissezpassersManageService laissezpassersManageService;
	
	@RequestMapping(value = "/laissezpasserregister")
	public TNPYResponse laissezpasserRegister(TbLaissezPasserInfo tbLaissezPasserInfo ) {
		TNPYResponse response = new TNPYResponse();
		try
		{
			if(!"0".equals(laissezpassersManageService.selectByCarLicenceTime(tbLaissezPasserInfo.getCarlicence())) )
			{
				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
				response.setMessage("该车辆有可用通行证 , 如需修改请联系管理员");
				return  response;
			}
			TbLaissezPasserInfo existstbLaissezPasserInfo = laissezpassersManageService.selectByPrimaryKey(tbLaissezPasserInfo.getId());
			if(existstbLaissezPasserInfo == null) {
				tbLaissezPasserInfo.setId(UUID.randomUUID().toString().replace("-", ""));
				laissezpassersManageService.insert(tbLaissezPasserInfo);
				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
				response.setMessage("通行证新增成功");
			}else {
				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
				response.setMessage("通行证已存在 , 如需修改请联系管理员");
				return  response;
			}
			
			return  response;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			response.setMessage("登记注册失败,请联系管理员");
			return  response;
		}
	}
	
	@RequestMapping(value = "/updateLaissezpasser")
	public TNPYResponse updateLaissezpasser(TbLaissezPasserInfo tbLaissezPasserInfo ) {
		TNPYResponse response = new TNPYResponse();
		try
		{
			TbLaissezPasserInfo existstbLaissezPasserInfo = laissezpassersManageService.selectByPrimaryKey(tbLaissezPasserInfo.getId());
			if(existstbLaissezPasserInfo == null) {
				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
				response.setMessage("出现错误, 修改的数据不存在");
			}else {
				laissezpassersManageService.updateByPrimaryKey(tbLaissezPasserInfo);
				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
				response.setMessage("修改成功");
				return  response;
			}
			
			return  response;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			response.setMessage("修改失败,请联系管理员");
			return  response;
		}
	}
	
	@RequestMapping(value = "/listLaissezpassers")
	public TNPYResponse listLaissezpassers(String columnName,String selectValue){
		TNPYResponse response = new TNPYResponse();
		try
		{
			String filter = "";
			if(!"-1".equals(columnName) )
			{
				filter = " and " + columnName + " like '%" + selectValue + "%' ";
			}
			List<TbLaissezPasserInfo> rs = laissezpassersManageService.listAll(filter);
			response.setData(JSONObject.toJSONString(rs, SerializerFeature.WriteMapNullValue).toString());
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("返回查询结果");
			return  response;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			response.setMessage("出现错误");
			return  response;
		}
	}
	
	@RequestMapping(value = "/deleteLaissezpasser")
	public TNPYResponse deleteVehicle(String ids) {
		TNPYResponse response = new TNPYResponse();
		try
		{
			int rs = laissezpassersManageService.deleteByPrimaryKey(ids);
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("删除成功");
			return  response;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			response.setMessage("出现错误");
			return  response;
		}
	}
	
	
}
