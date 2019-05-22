//package com.tnpy.wcpsproject.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.tnpy.common.Enum.StatusEnum;
//import com.tnpy.common.utils.web.TNPYResponse;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping(value = "/register")
//public class VehicleManageController {
//
//	@Resource
//	IVehicleManageService vehicleRegisterService;
//
//	@RequestMapping(value = "/vehicleRegister")
//	public TNPYResponse vehicleRegister(TbCarInfo tbcar ) {
//		TNPYResponse response = new TNPYResponse();
//		try
//		{
//			TbCarInfo existstbcar = vehicleRegisterService.selectByPrimaryKey(tbcar.getCarlicence());
//			if(existstbcar == null) {
//				vehicleRegisterService.insert(tbcar);
//				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
//				response.setMessage("登记注册成功");
//			}else {
//				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
//				response.setMessage("该车牌号已登记注册 , 如需修改请联系管理员");
//				return  response;
//			}
//
//			return  response;
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//			response.setMessage("登记注册失败,请联系管理员");
//			return  response;
//		}
//	}
//
//	@RequestMapping(value = "/updateVehicle")
//	public TNPYResponse updateVehicle(TbCarInfo tbcar ) {
//		TNPYResponse response = new TNPYResponse();
//		try
//		{
//			TbCarInfo existstbcar = vehicleRegisterService.selectByPrimaryKey(tbcar.getCarlicence());
//			if(existstbcar == null) {
//				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
//				response.setMessage("出现错误");
//			}else {
//				vehicleRegisterService.updateByPrimaryKey(tbcar);
//				response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
//				response.setMessage("修改成功");
//				return  response;
//			}
//
//			return  response;
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//			response.setMessage("登记注册失败,请联系管理员");
//			return  response;
//		}
//	}
//
//	@RequestMapping(value = "/listVehicles")
//	public TNPYResponse listVehicles(String columnName,String selectValue) {
//		TNPYResponse response = new TNPYResponse();
//		try
//		{
//			String filter = "";
//			if(!"-1".equals(columnName) )
//			{
//				filter = " and " + columnName + " like '%" + selectValue + "%' ";
//			}
//			List<TbCarInfo> existstbcar = vehicleRegisterService.listAll(filter);
//			response.setData(JSONObject.toJSONString(existstbcar, SerializerFeature.WriteMapNullValue).toString());
//			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
//			response.setMessage("返回查询结果");
//			return  response;
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//			response.setMessage("出现错误");
//			return  response;
//		}
//	}
//
//	@RequestMapping(value = "/deleteVehicle")
//	public TNPYResponse deleteVehicle(String ids) {
//		TNPYResponse response = new TNPYResponse();
//		try
//		{
//			int rs = vehicleRegisterService.deleteByPrimaryKey(ids);
//			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
//			response.setMessage("删除成功");
//			return  response;
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//			response.setMessage("出现错误");
//			return  response;
//		}
//	}
//
//}
