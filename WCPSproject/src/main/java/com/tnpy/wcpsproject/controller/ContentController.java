package com.tnpy.wcpsproject.controller;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tnpy.common.Enum.StatusEnum;
import com.tnpy.common.utils.web.TNPYResponse;
import com.tnpy.wcpsproject.mapper.mysql.ContentMapper;
import com.tnpy.wcpsproject.model.mysql.Content;
import com.tnpy.wcpsproject.model.mysql.Content_QingGan;
import com.tnpy.wcpsproject.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/content")
public class ContentController {
	@Resource
	IContentService contentService;
	@Autowired
	private ContentMapper contentMapper;
	//文章列表展示
	@RequestMapping(value = "/listAll")
	public TNPYResponse listAll() {
		TNPYResponse response = new TNPYResponse();
		try {
			List<Content> rs = contentService.listAll();
			response.setData(JSONObject.toJSONString(rs, SerializerFeature.WriteMapNullValue).toString());
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("返回查询结果");
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setMessage("获取数据失败失败,请联系管理员");
			return response;
		}
	}

	//文章热度可视化
	@RequestMapping(value = "/selectbyarticletitle")
	public TNPYResponse selectByArticleTitle(String title) {
		TNPYResponse response = new TNPYResponse();
		try {
			List<Content> rs = contentMapper.selectByArticleTitle(title);

			response.setData(JSONObject.toJSONString(rs, SerializerFeature.WriteMapNullValue).toString());
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("返回查询结果");
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setMessage("获取数据失败失败,请联系管理员");
			return response;
		}
	}
	//数量趋势可视化
	@RequestMapping(value = "/tree")
	public TNPYResponse tree(String title) {
		TNPYResponse response = new TNPYResponse();
		try {
			List<Content> rs = contentMapper.barShow(title);
			///////////////////////////////////
			//辅助列
			List rs1 = sumarr(rs);
			//x时间轴
			List xtime = new ArrayList<String>();
			for (int i = 0; i < rs.size(); i++) {
				xtime.add(i, rs.get(i).getCrawTime());
			}
			//数据列
			List sj = new ArrayList<String>();
			for (int i = 0; i < rs.size(); i++) {
				sj.add(i, rs.get(i).getDianjiNum());
			}
			Integer rsi = sum(rs);
			sj.add(rsi);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("fuzhu", rs1);
			result.put("time", xtime);
			result.put("datas", sj);
			response.setData(JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue).toString());
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("返回查询结果");
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setMessage("获取数据失败失败,请联系管理员");
			return response;
		}
	}
	//辅助列
	List sumarr(List<Content> arr) {

		List rsarrU = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getDianjiNum());

		}
		System.out.println("wanbi");

		for (int i = 0; i < arr.size(); i++) {
			if (i == 0) {
				//				rsarrU.set(i+1, 0);
				rsarrU.add(i, 0);
				continue;
			} else {
				Integer a1 = new Integer(arr.get(i - 1).getDianjiNum());
				Integer a2 = new Integer(rsarrU.get(i - 1).toString());
				rsarrU.add(i, a1 + a2);

				//				rsarrU.set(i+1, a1+a2   );
				//				rsarr[i] = arr.get(i).getDianjiNum() + rsarrU.get(i-1);
				//				System.out.println(rsarr.toString());
			}
		}
		//		rsarr[arr.length] = 0;
		rsarrU.add(0);
		for (int i = 0; i < rsarrU.size(); i++) {
			System.out.println(rsarrU.get(i));

		}
		return rsarrU;
	}
	//数据列
	Integer sum(List<Content> arr) {
		Integer rsi = 0;
		List sum = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			Integer a1 = new Integer(arr.get(i).getDianjiNum());
			rsi = rsi + a1;
		}
		System.out.println(rsi);
		return rsi;
	}
	@RequestMapping(value = "/fenXi")
	public TNPYResponse fenXi() {
		TNPYResponse response = new TNPYResponse();
		try {
			List<Content_QingGan> rs = contentMapper.fenXi("");
			response.setData(JSONObject.toJSONString(rs, SerializerFeature.WriteMapNullValue).toString());
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("返回查询结果");
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setMessage("获取数据失败失败,请联系管理员");
			return response;
		}
	}
//热点推荐
	@RequestMapping(value = "/HotPush")
	public TNPYResponse HotPush() {
		TNPYResponse response = new TNPYResponse();
		try {
			List<Content> rs = contentService.HotPush();
			response.setData(JSONObject.toJSONString(rs, SerializerFeature.WriteMapNullValue).toString());
			response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
			response.setMessage("返回查询结果");
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setMessage("获取数据失败失败,请联系管理员");
			return response;
		}
	}
}