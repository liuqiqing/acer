package com.inspur.controller;

import com.inspur.service.CityLevelService;
import com.inspur.utils.DoubleUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * 政务服务市本级页面接口数据
 * @author zxp
 * @date 2018年12月5日
 *
 */
@Controller
@RequestMapping("/cityLevelController")
public class CityLevelController {
	
	@Autowired
	private CityLevelService cityLevelService;

	/**
	 * 济南市已发布事项总数，不区分服务类别和网办深度
	 *
	 */
	@RequestMapping("sxzlsl")
	@ResponseBody
	public Map<String, Object> sxzlsl() {
		Map<String, Object> _map = new HashMap<String,Object>();
		String sxzlsl = cityLevelService.sxzlsl();
		_map.put("sxzlsl", sxzlsl);
		return _map;
	}
	
	/**
	 * 济南市已发布事项总数，不区分服务类别和网办深度。
	 * 其中，线上、线下、线上线下均可的事项数量。
	 *
	 * project_item表的is_online字段区分是否网上办理，
	 * 1、2和3表示线上，0和null表示线下
	 *
	 */
	@RequestMapping("/xsxxblsxqbsj")
	@ResponseBody
	public Map<String, Object> xsblsx() {
		Map<String, Object> _resultMap = new HashMap<String,Object>();
		//济南市已发布事项总数
		String sxzlsl = cityLevelService.sxzlsl();
		//线上
		String xsblsx = cityLevelService.xsblsx();
		//线下
		String xxblsx = cityLevelService.xxblsx();
		//线上线下皆可
		//String xsxxblsx = cityLevelService.xsxxblsx();
		_resultMap.put("sxzlsl", sxzlsl);
		_resultMap.put("xsblsx", xsblsx);
		_resultMap.put("xxblsx", xxblsx);
		//_resultMap.put("xsxxblsx", xsxxblsx);
		return _resultMap;
	}
	
	//审批办件类型
	@RequestMapping("/spbjlx")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> spbjlx() {
		List<LinkedHashMap<String, Object>> _list = new ArrayList<LinkedHashMap<String, Object>>();
		Map<String, Object> spbjlx = cityLevelService.spbjlx();
		Set<Entry<String,Object>> _entrySet = spbjlx.entrySet();
		for(Entry<String,Object> _entry : _entrySet) {
			LinkedHashMap<String, Object> _map = new LinkedHashMap<String,Object>();
			_map.put("name", _entry.getKey());
			_map.put("value", _entry.getValue());
			_list.add(_map);
		}
		return _list;
	}
	
	//事项性质数量
	@RequestMapping("/sxxzsl")
	@ResponseBody
	public Map<String, Object> sxxzsl(){
		Map<String,Object> sxxzsl = cityLevelService.sxxzsl();
		return sxxzsl;
	}
	
	//济南市部门受理
	@RequestMapping("/jnsbmsl")
	@ResponseBody
	public List<Map<String, Object>> jnsbmsl() {
		List<Map<String,Object>> jnsbmsl = cityLevelService.jnsbmsl();
		return jnsbmsl;
	}
	
	@RequestMapping("/jnsbmbj")
	@ResponseBody
	//济南市部门办结
	public List<Map<String, Object>> jnsbmbj() {
		List<Map<String,Object>> jnsbmbj = cityLevelService.jnsbmbj();
		return jnsbmbj;
	}
	
	//当日线上变化趋势
	@RequestMapping("/drxsbhqs")
	@ResponseBody
	public Map<String, Object> drxsbhqs() {
		//当日线上受理
		List<Map<String,Object>> drxsslcsList = cityLevelService.drxsslcs();
		//当日线上办结
		List<Map<String,Object>> drxsbjcsList = cityLevelService.drxsbjcs();
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("drxsslcsList", drxsslcsList);
		_map.put("drxsbjcsList", drxsbjcsList);
		return _map;
	}
	
	//当日线下变化趋势
	@RequestMapping("/drxxbhqs")
	@ResponseBody
	public Map<String, Object> drxxbhqs() {
		//当日线下受理
		List<Map<String,Object>> drxxslcsList = cityLevelService.drxxslcs();
		//当日线下办结
		List<Map<String,Object>> drxxbjcsList = cityLevelService.drxxbjcs();
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("drxxslcsList", drxxslcsList);
		_map.put("drxxbjcsList", drxxbjcsList);
		return _map;
	}
	
	// 当月线上变化趋势
	@RequestMapping("/dyxsbhqs")
	@ResponseBody
	public Map<String, Object> dyxsbhqs() {
		// 当月线上受理
		List<Map<String, Object>> dyxsslcsList = cityLevelService.dyxsslcs();
		// 当月线上办结
		List<Map<String, Object>> dyxsbjcsList = cityLevelService.dyxsbjcs();
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dyxsslcsList", dyxsslcsList);
		_map.put("dyxsbjcsList", dyxsbjcsList);
		return _map;
	}

	// 当月线下变化趋势
	@RequestMapping("/dyxxbhqs")
	@ResponseBody
	public Map<String, Object> dyxxbhqs() {
		// 当月线下受理
		List<Map<String, Object>> dyxxslcsList = cityLevelService.dyxxslcs();
		// 当月线下办结
		List<Map<String, Object>> dyxxbjcsList = cityLevelService.dyxxbjcs();
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dyxxslcsList", dyxxslcsList);
		_map.put("dyxxbjcsList", dyxxbjcsList);
		return _map;
	}
	
	// ----------
	// 当年线上变化趋势
	@RequestMapping("/dnxsbhqs")
	@ResponseBody
	public Map<String, Object> dnxsbhqs() {
		// 当年线上受理
		List<Map<String, Object>> dnxsslcsList = cityLevelService.dnxsslcs();
		// 当年线上办结
		List<Map<String, Object>> dnxsbjcsList = cityLevelService.dnxsbjcs();
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dnxsslcsList", dnxsslcsList);
		_map.put("dnxsbjcsList", dnxsbjcsList);
		return _map;
	}

	// 当年线下变化趋势
	@RequestMapping("/dnxxbhqs")
	@ResponseBody
	public Map<String, Object> dnxxbhqs() {
		// 当年线下受理
		List<Map<String, Object>> dnxxslcsList = cityLevelService.dnxxslcs();
		// 当年线下办结
		List<Map<String, Object>> dnxxbjcsList = cityLevelService.dnxxbjcs();
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dnxxslcsList", dnxxslcsList);
		_map.put("dnxxbjcsList", dnxxbjcsList);
		return _map;
	}

	/**
	 * 市本级页面右侧数据表格中，事项情况分类。
	 * 查询的数据分别为下面四种情况：
	 * 	济南市已发布的依申请公开事项总数。
	 * 	济南市已发布的依申请公开事项总数中，可网上办理的。默认为1,2,4，页面可以选择不同的网办深度进行查询。
	 * 	根据事项性质分类，济南市已发布的依申请公开事项各个分类的数量。
	 * 	根据事项性质分类，济南市已发布的依申请公开事项各个分类的数量中，可网上办理的数量。
	 *
	 */
	@RequestMapping("/sbjsxqkfl")
	@ResponseBody
	public Map<String,Object> sbjsxqkfl() {
		Map<String,Object> _map = new HashMap<String, Object>();
		//依申请公开
		String ysqgksx = cityLevelService.ysqgksx();
		//依申请公开事项中，可网上办理数量
		String ysqgkkwsbl = cityLevelService.ysqgkkwsbl();
		//根据事项性质分类
		Map<String,Object>  _sxxzflMap = cityLevelService.jnssxxzflsxzs();
		//根据事项性质分类，各分类可网上办理
		Map<String,Object> _sxxzflkwsblMap = cityLevelService.jnssxxzflkwsbl();
		//将以上数据存放到最终的map中，用于返回给页面
		_map.put("YSQGKSX",ysqgksx);
		_map.put("YSQGKKWSBL",ysqgkkwsbl);
		_map.put("_sxxzflMap",_sxxzflMap);
		_map.put("_sxxzflkwsblMap",_sxxzflkwsblMap);
		return _map;
	}

	//市本级事项情况分类根据网办深度进行查询
	@RequestMapping("/sbjsxqkflgjwbsdcx")
	@ResponseBody
	public Map<String,Object> sbjsxqkflgjwbsdcx(@RequestParam("check_val") String checkVal){
		Map<String,Object> _map = new HashMap<String, Object>();
		//济南市依申请公开事项数量
		String ysqgksx = cityLevelService.ysqgksx();
		String ysqgksxgjwbsdcx = cityLevelService.ysqgksxgjwbsdcx(checkVal);
		//济南市根据事项性质分类
		Map<String,Object>  sxxzflMap = cityLevelService.jnssxxzflsxzs();
		Map<String,Object> jnssxxzflgjwbsdcx = cityLevelService.jnssxxzflgjwbsdcx(checkVal);
		_map.put("YSQGKSX",ysqgksx);
		_map.put("YSQGKSXGJWBSDCX",ysqgksxgjwbsdcx);
		_map.put("SXSZFLMAP",sxxzflMap);
		_map.put("SXSZFLGJWBSDCX",jnssxxzflgjwbsdcx);

		return _map;
	}

	/**
	 * 济南市事项受理前十名
	 * @return
	 */
	@RequestMapping("/jnssxslqsm")
	@ResponseBody
	public List<Map<String,Object>> jnssxslqsm(){
		List<Map<String, Object>> jnssxslqsm = cityLevelService.jnssxslqsm();
		return jnssxslqsm;
	}

	/**
	 * 济南市事项办结前十名
	 * @return
	 */
	@RequestMapping("/jnssxbjqsm")
	@ResponseBody
	public List<Map<String,Object>> jnssxbjqsm(){
		List<Map<String, Object>> jnssxbjqsm = cityLevelService.jnssxbjqsm();
		return jnssxbjqsm;
	}

	/**
	 *
	 * @param val checkbox选中的值
	 * @param name checkbox选中的名字
	 * @return
	 */
	@RequestMapping("/cityLevelDownload")
	public void cityLevelDownload(@RequestParam("checkVal") String val,
									@RequestParam("checkName") String name,
									HttpServletResponse response){
		OutputStream out = null;
		try {
			File file = ResourceUtils.getFile("classpath:static/excel/市本级.xlsx");
			//模版文件名
			String oldName = file.getName();
			//截取掉文件后缀名
			String fileName = oldName.substring(0,oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建一个Excel的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			//设置单元格样式
			XSSFCellStyle cellStyle = workbook.createCellStyle();//创建设置EXCEL表格样式对象 cellStyle
			cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//下边框
			cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
			cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
			cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
			cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
			//字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);//设置字体大小   
			cellStyle.setFont(font);//选择创建的字体格式 
			//查询需要导出的数据
			//济南市依申请公开事项数量
			String ysqgksx = cityLevelService.ysqgksx();
			//网办深度不同的条件
			String ysqgksxgjwbsdcx = cityLevelService.ysqgksxgjwbsdcx(val);
			//济南市根据事项性质分类
			Map<String,Object>  sxxzflMap = cityLevelService.jnssxxzflsxzs();
			//济南市根据事项性质分类，网办深度不同
			Map<String,Object> jnssxxzflgjwbsdcx = cityLevelService.jnssxxzflgjwbsdcx(val);
			//读取workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			//填充数据
			sheet.getRow(0).getCell(3).setCellValue(name);
			XSSFRow row1 = sheet.getRow(1);
			XSSFCell topCell2 = row1.createCell(2);
			topCell2.setCellValue(ysqgksx);
			topCell2.setCellStyle(cellStyle);
			XSSFCell topCell3 = row1.createCell(3);
			topCell3.setCellValue(ysqgksxgjwbsdcx);
			topCell3.setCellStyle(cellStyle);
			double _ysqgksx =  Double.valueOf(ysqgksx);
			double _ysqgksxgjwbsdcx = Double.valueOf(ysqgksxgjwbsdcx);
			String percent = DoubleUtils.getDoublePercent(_ysqgksxgjwbsdcx, _ysqgksx);
			XSSFCell topCell4 = row1.createCell(4);
			topCell4.setCellStyle(cellStyle);
			topCell4.setCellValue(percent);
			XSSFCell topCell5 = row1.createCell(5);
			topCell5.setCellStyle(cellStyle);
			topCell5.setCellValue(percent);
			//获取总行数
			int num = sheet.getLastRowNum();//11
			String tempObj1 = "";
			String tempObj2 = "";
			double _tempObj1 = 0;
			double _tempObj2 = 0;
			XSSFCell cell2 = null;
			XSSFCell cell3 = null;
			XSSFCell cell4 = null;
			XSSFCell cell5 = null;
			for(int i=2;i<num;i++){
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(1);
				switch (cell.getStringCellValue()){
					case "行政许可":
						tempObj1 = String.valueOf(sxxzflMap.get("XK"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("XK"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "行政确认":
						tempObj1 = String.valueOf(sxxzflMap.get("QR"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("QR"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "公共服务":
						tempObj1 = String.valueOf(sxxzflMap.get("GG"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("GG"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "行政征收":
						tempObj1 = String.valueOf(sxxzflMap.get("ZS"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("ZS"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "行政给付":
						tempObj1 = String.valueOf(sxxzflMap.get("JF"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("JF"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "行政监督":
						tempObj1 = String.valueOf(sxxzflMap.get("JD"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("JD"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "行政奖励":
						tempObj1 = String.valueOf(sxxzflMap.get("JL"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("JL"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "行政裁决":
						tempObj1 = String.valueOf(sxxzflMap.get("CJ"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("CJ"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
					case "其他权力":
						tempObj1 = String.valueOf(sxxzflMap.get("QT"));
						cell2 = row.createCell(2);
						cell2.setCellStyle(cellStyle);
						cell2.setCellValue(tempObj1);
						tempObj2 = String.valueOf(jnssxxzflgjwbsdcx.get("QT"));
						cell3 = row.createCell(3);
						cell3.setCellStyle(cellStyle);
						cell3.setCellValue(tempObj2);
						_tempObj1 = Double.valueOf(tempObj1);
						_tempObj2 = Double.valueOf(tempObj2);
						cell4 = row.createCell(4);
						cell4.setCellStyle(cellStyle);
						cell4.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_tempObj1));
						cell5 = row.createCell(5);
						cell5.setCellStyle(cellStyle);
						cell5.setCellValue(DoubleUtils.getDoublePercent(_tempObj2,_ysqgksx));
						break;
						default:
							break;
				}

			}
			//清除buffer缓存
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("gb2312"),"ISO8859-1")+".xlsx");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			out = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(out);

			bos.flush();
			workbook.write(out);
			bos.flush();


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 济南市已发布的依申请公开事项
	 * 网办深度为：全程网办（0跑腿）、在线预审（只跑1次）、在线申办
	 * 统计9类权力类型
	 *
	 */
	@RequestMapping("/jnssxxzflbt")
	@ResponseBody
	public List<Map<String,Object>> jnssxxzflbt(){
		List<Map<String,Object>> resultList = new ArrayList<Map<String, Object>>();

		Map<String, Object> jnssxxzflbt = cityLevelService.jnssxxzflsxzs();
		for (Entry<String,Object> entry : jnssxxzflbt.entrySet()){
			Map<String,Object> _map = new HashMap<String, Object>();
			String key = entry.getKey();
			String tempName = null;
			switch (key){
				case "XK":
					tempName = "行政许可";
					break;
				case "ZS":
					tempName = "行政征收";
					break;
				case "QR":
					tempName = "行政确认";
					break;
				case "JF":
					tempName = "行政给付";
					break;
				case "JL":
					tempName = "行政奖励";
					break;
				case "CJ":
					tempName = "行政裁决";
					break;
				case "QT":
					tempName = "其他权利";
					break;
				case "GG":
					tempName = "公共服务";
					break;
				case "JD":
					tempName = "行政监督";
					break;
				default:
					tempName = "";
			}
			_map.put("name",tempName);
			_map.put("value",entry.getValue());
			resultList.add(_map);
		}

		return resultList;
	}



}
