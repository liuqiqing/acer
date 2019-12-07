package com.inspur.controller;

import com.inspur.service.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import net.sf.json.JSONObject;

/**
 * 共享交换首页数据统计功能
 */
@Controller
@RequestMapping("/shareIndex")
public class ShareIndexController {

	@Autowired
	ShareIndexService shareIndexService;

	/**
	 * 统计入口
	 */
	@RequestMapping("/statistics")
	@ResponseBody
	public Object statistics() {
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 数据交换量情况：总数，成功次数，失败次数
		Map<String, Object> mapDataExchangeCount = new HashMap<String, Object>();
		mapDataExchangeCount = shareIndexService.getDataExchangeCount();
		String total_count = mapDataExchangeCount.get("total_count").toString();
		String sum_success_times = mapDataExchangeCount.get("sum_success_times").toString();
		String sum_failed_times = mapDataExchangeCount.get("sum_failed_times").toString();
		
		map.put("total_count", total_count);
		map.put("sum_success_times", sum_success_times);
		map.put("sum_failed_times", sum_failed_times);
		//数据目录总数、库表总数、文件总数
		Map<String, Object> mapCataTotal = new HashMap<String, Object>();
		mapCataTotal = shareIndexService.getCataTotal();
		map.put("total_cata_count", mapCataTotal.get("total_cata_count").toString());
		map.put("count_db_table", mapCataTotal.get("count_db_table").toString());
		map.put("count_file", mapCataTotal.get("count_file").toString());
		//接口总数
		Map<String, Object> mapServiceTotal = new HashMap<String, Object>();
		mapServiceTotal = shareIndexService.getServiceTotal();
		map.put("total_service", mapServiceTotal.get("total_service"));
		//数据目录-无条件共享、有条件共享
		Map<String, Object> mapCataShareType = new HashMap<String, Object>();
		mapCataShareType = shareIndexService.getShareType();
		map.put("total_cata_count_condition", mapCataShareType.get("total_cata_count_condition"));
		map.put("total_cata_count_nocondition", mapCataShareType.get("total_cata_count_nocondition"));
		
		//数据提供单位数
		//1、首先查提供接口的单位
		List<Map<String, Object>> listServiceOrg = shareIndexService.getListServiceOrg();
		String org_code;
		List<String> listService = new ArrayList<String>();
		for(Map<String, Object> mapOne : listServiceOrg){
			org_code = mapOne.get("org_code").toString();
			listService.add(org_code);
		}
		//2、然后查提供库表和文件的单位
		List<Map<String, Object>> listNoServiceOrg = shareIndexService.getListNoServiceOrg();
		List<String> listNoService = new ArrayList<String>();
		for(Map<String, Object> mapTwo : listNoServiceOrg){
			org_code = mapTwo.get("ORGAN_CODE").toString();
			listNoService.add(org_code);
		}
		//3、单位合并
		for(String s : listNoService){
			listService.remove(s);
		}
		listService.addAll(listNoService);
		
		int totalOrg = listService.size();
		map.put("total_org", totalOrg);
		
		//已上传接口单位数
		int countOrgService = listServiceOrg.size();
		//未上传接口单位数
		int countOrgNoService = totalOrg - countOrgService;
		map.put("countOrgService", countOrgService);
		map.put("countOrgNoService", countOrgNoService);
		
		//热门资源排名
		List<Map<String, Object>> listHotSource = shareIndexService.getHotSource();
		for(int i = 0; i < listHotSource.size(); i++){
			String cata_name = listHotSource.get(i).get("cata_name").toString();
			String count_num = listHotSource.get(i).get("count_num").toString();
			map.put("cata_name" + i, cata_name);
			map.put("count_num" + i, count_num);
		}
		
		//共享资源部门排名
		List<Map<String, Object>> listHotOrg = shareIndexService.getHotOrg();
		List<String> xAxisData = new ArrayList<String>();
		List<String> seriesData = new ArrayList<String>();
		
		for(int i = 0; i < listHotOrg.size(); i++){
			String organ_name = listHotOrg.get(i).get("organ_name").toString().substring(3);
			String count_cata = listHotOrg.get(i).get("count_cata").toString();
//			map.put("organ_name" + i, organ_name);
//			map.put("count_cata" + i, count_cata);
			xAxisData.add(organ_name);
			seriesData.add(count_cata);
		}
		
		map.put("xAxisData", xAxisData);
		map.put("seriesData", seriesData);
		
		//共享度排名
		List<Map<String, Object>> listHotOrgShare = shareIndexService.getHotOrgShare();
		
		for(int i = 0; i < listHotOrgShare.size(); i++){
			String organ_name = listHotOrgShare.get(i).get("organ_name").toString().substring(3);
			String count_cata = listHotOrgShare.get(i).get("count_cata").toString();
			//某部门的目录占总目录的百分比
			double count_cata_percent_double = Double.valueOf(count_cata)/Double.valueOf(total_count)*100;
			String count_cata_percent_string = String.valueOf(count_cata_percent_double);
			String count_cata_percent = count_cata_percent_string.substring(0,4);
			
			map.put("organ_name" + i, organ_name);
			map.put("count_cata" + i, count_cata);
			map.put("count_cata_percent" + i, count_cata_percent);
		}
		
		
		return map;
	}
	
	/**
	 * 共享资源利用情况
	 */
	@RequestMapping("/statisticsUse")
	@ResponseBody
	public Object statisticsUse() {
		Map<String,Object> mapUse = new HashMap<String,Object>();
		
		List<String> fileData = new ArrayList<String>();
		List<String> dbtableData = new ArrayList<String>();
		List<String> serviceData = new ArrayList<String>();
		
		String count_file;//文件数
		String count_dbtable;//库表数
		String count_service;//接口数
		
		//共享资源利用情况-按月-文件
		List<Map<String, Object>> listSourceUseFile = shareIndexService.getSourceUseFile();
		//共享资源利用情况-按月-库表
		List<Map<String, Object>> listSourceUseDbTable = shareIndexService.getSourceUseDbTable();
		//共享资源利用情况-按月-接口
		List<Map<String, Object>> listSourceUseService = shareIndexService.getSourceUseService();
	
		
		for(int i = 0; i < 12; i++){
			//文件数
			if(listSourceUseFile.get(i).get("count_file") != null){
				count_file = listSourceUseFile.get(i).get("count_file").toString();
			}else {
				count_file = 0 + "";
			}
			fileData.add(count_file);
			
			//库表数	
			if(listSourceUseDbTable.get(i).get("count_dbtable") != null){
				count_dbtable = listSourceUseDbTable.get(i).get("count_dbtable").toString();
			}else{
				count_dbtable = 0 + "";
			}
			dbtableData.add(count_dbtable);
			
			//接口数
			if(listSourceUseService.get(i).get("count_service") != null){
				count_service = listSourceUseService.get(i).get("count_service").toString();
			}else{
				count_service = 0 + "";			
			}
			serviceData.add(count_service);
			
		}
		
		mapUse.put("fileData", fileData);
		mapUse.put("dbtableData", dbtableData);
		mapUse.put("serviceData", serviceData);
		return mapUse;
	}

}
