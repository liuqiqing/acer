package com.inspur.controller;

import com.inspur.service.LibIndexService;
import com.inspur.utils.TemplateExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;


@Controller
@RequestMapping("/libIndexController")
public class LibIndexController {
	
	@Autowired
	private LibIndexService libIndexService;
	
	//登记单位
	@RequestMapping("/djdws")
	@ResponseBody
	public Map<String, String> djdws() {
		Map<String, String> resultMap = new HashMap<String,String>();
		String djdws = libIndexService.djdws();
		resultMap.put("djdws", djdws);
		return resultMap;
	}
	
	//证照目录
	@RequestMapping("/zzml")
	@ResponseBody
	public Map<String, Object> zzml(){
		Map<String, Object> zzml = libIndexService.zzml();
		return zzml;
	}

	//按目录统计
	@RequestMapping("/amltj")
	@ResponseBody
	public Map<String,Object> amltj(@RequestParam("page") Integer page,
										  @RequestParam("limit")Integer limit){

		int startRows = (page - 1) * limit;
		int endRows = page * limit + 1;
		Map<String, Object> map = libIndexService.amltj(startRows, endRows);

		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count",map.get("num"));
		resultMap.put("data", map.get("pageList"));

		return resultMap;
	}
	
	//证照数据与未签章数据
	@RequestMapping("/zzsjywqzsj")
	@ResponseBody
	public Map<String, Object> zzsjywqzsj(){
		Map<String, Object> zzsjywqzsj = libIndexService.zzsjywqzsj();
		return zzsjywqzsj;
	}
	
	//证照模版统计-按主题统计
	@RequestMapping("/zzmbtjazttj")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> zzmbtjazttj() {
		//数据集合
		List<LinkedHashMap<String, Object>> resultList = new ArrayList<LinkedHashMap<String, Object>>();
		
		Map<String, Object> zzmbtjazttj = libIndexService.zzmbtjazttj();
		Set<Entry<String,Object>> _entrySet = zzmbtjazttj.entrySet();
		for(Entry<String,Object> _entry : _entrySet) {
			LinkedHashMap<String, Object> _map = new LinkedHashMap<String,Object>();
			_map.put("value", _entry.getValue());
			_map.put("name", _entry.getKey());
			resultList.add(_map);
		}
		
		return resultList;
	}
	
	//证照统计
	@RequestMapping("/zztjTableData")
	@ResponseBody
	public Map<String, Object> zztjTableData(@RequestParam("page")int page,
			   								 @RequestParam("limit")int limit) {
		
		//page当前页，limit每页显示的条数
		//计算开始行和结束行
		int startRows = (page - 1) * limit;
		int endRows = page * limit + 1;
		Map<String, Object> _map = libIndexService.zztjTableData(startRows,endRows);
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count",_map.get("nums"));
		resultMap.put("data", _map.get("resultList"));
		
		return resultMap;
	}

	//下载
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response){
		try {
			File file = ResourceUtils.getFile("classpath:static/excel/证照统计.xlsx");
			List<Map<String,Object>> dataList = libIndexService.zjsjywqzsjMoreTable();
			TemplateExportExcelUtil.exportExcel(file,dataList,response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
