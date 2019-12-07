package com.inspur.controller;

import com.inspur.service.CountyLevelService;
import com.inspur.utils.DoubleUtils;
import com.inspur.utils.KeyConstants;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 县区级页面请求数据
 * @author wangjinli
 * @date 2018年12月14日
 */
@Controller
@RequestMapping("/countyLevelController")
public class CountyLevelController {

	@Autowired
	private CountyLevelService  countyLevelService;
	
	// 区县事项总览
	@RequestMapping("qxsxzl")
	@ResponseBody
	public Map<String, Object> qxsxzl(@RequestParam("county") String county) {
		
		String qxsxzl = countyLevelService.qxsxzlCounty(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("qxsxzl", qxsxzl);
		return _map;
	}
	
	// 线上、线下、线上线下办理事项全部数据
	@RequestMapping("/xsxxblsxqbsj")
	@ResponseBody
	public Map<String, Object> xsblsx(@RequestParam("county") String county) {
		Map<String, Object> _resultMap = new HashMap<String, Object>();
		// 事项总览数量
		String qxsxzl = countyLevelService.qxsxzlCounty(county);
		// 线上办理事项
		String xsblsx = countyLevelService.xsblsx(county);
		// 线下办理事项
		String xxblsx = countyLevelService.xxblsx(county);
		// 线上、线下办理事项
		// String xsxxblsx = countyLevelService.xsxxblsx(county);
		
		_resultMap.put("qxsxzl", qxsxzl);
		_resultMap.put("xsblsx", xsblsx);
		_resultMap.put("xxblsx", xxblsx);
		//_resultMap.put("xsxxblsx", xsxxblsx);
		return _resultMap;
	}
		
	// 信息公开数、依申请公开事项数
	@RequestMapping("/xxgkNumYsqgksxNum")
	@ResponseBody
	public Map<String, Object> xxgkNum(@RequestParam("county") String county) {
		Map<String, Object> _xxgkMap = new HashMap<String, Object>();
		String xxgkNum = countyLevelService.xxgkNum(county); // 信息公开
		String ysqgksxNum = countyLevelService.ysqgksxNum(county); // 依申请公开事项数
		_xxgkMap.put("xxgkNum", xxgkNum);
		_xxgkMap.put("ysqgksxNum", ysqgksxNum);
		return _xxgkMap;
	}

	// 各区县依申请公开可网上办理事项统计
	@RequestMapping("/ysqgkkwsblsxtjList")
	@ResponseBody
	public List<Map<String,Object>> ysqgkkwsblsxtjList(){
		List<Map<String,Object>> ysqgkkwsblsxtjList = countyLevelService.ysqgkkwsblsxtjList(); // 依申请公开事项数
		for(Map<String,Object> map1:ysqgkkwsblsxtjList){
			for(Entry<String, Object> entry:map1.entrySet()){
				for(Entry<String, String> entry1:KeyConstants.region_Code_Map.entrySet()){
					if(entry.getValue().toString().length()==12 && entry.getValue().toString().equals(entry1.getValue())){
						entry.setValue(entry1.getKey());
					}
				}
			}
		}


		return ysqgkkwsblsxtjList;
	}

	// 事项性质数量
	@RequestMapping("/sxxzsl")
	@ResponseBody
	public Map<String, Object> sxxzsl(@RequestParam("county") String county) {
		Map<String, Object> sxxzsl = countyLevelService.sxxzsl(county);
		return sxxzsl;
	}

	// 区县部门受理
	@RequestMapping("/qxbmsl")
	@ResponseBody
	public List<Map<String, Object>> qxbmsl(@RequestParam("county") String county) {
		List<Map<String, Object>> qxbmsl =countyLevelService.qxbmsl(county);
		return qxbmsl;
	}

	// 区县部门办结
	@RequestMapping("/qxbmbj")
	@ResponseBody
	public List<Map<String, Object>> qxbmbj(@RequestParam("county") String county) {
		List<Map<String, Object>> qxbmbj = countyLevelService.qxbmbj(county);
		return qxbmbj;
	}

	// 全区县事项性质和网上办理：已发布、可网上办理数
	@RequestMapping("/sxxzsyjwsbls")
	@ResponseBody
	public Map<String, Object> sxxzsyjwsbls(@RequestParam("county") String county) {
		Map<String, Object> _resultMap = new HashMap<String,Object>();
		// 已发布
		Map<String, Object> sxxzsyjwsbls_Publish = countyLevelService.sxxzsyjwsbls_Publish(county);
		_resultMap.put("sxxzsyjwsbls_Publish", sxxzsyjwsbls_Publish);
		// 可网上办理
		Map<String, Object> sxxzsyjwsbls_onLine = countyLevelService.sxxzsyjwsbls_onLine(county);
		_resultMap.put("sxxzsyjwsbls_onLine", sxxzsyjwsbls_onLine);
		return _resultMap;
	}

	// 当日线上变化趋势
	@RequestMapping("/drxsbhqs")
	@ResponseBody
	public Map<String, Object> drxsbhqs(@RequestParam("county") String county) {
		// 当日线上受理
		List<Map<String, Object>> drxsslcsList = countyLevelService.drxsslcs(county);
		// 当日线上办结
		List<Map<String, Object>> drxsbjcsList = countyLevelService.drxsbjcs(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("drxsslcsList", drxsslcsList);
		_map.put("drxsbjcsList", drxsbjcsList);
		return _map;
	}

	// 当日线下变化趋势
	@RequestMapping("/drxxbhqs")
	@ResponseBody
	public Map<String, Object> drxxbhqs(@RequestParam("county") String county) {
		// 当日线下受理
		List<Map<String, Object>> drxxslcsList = countyLevelService.drxxslcs(county);
		// 当日线下办结
		List<Map<String, Object>> drxxbjcsList = countyLevelService.drxxbjcs(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("drxxslcsList", drxxslcsList);
		_map.put("drxxbjcsList", drxxbjcsList);
		return _map;
	}

	// 当月线上变化趋势
	@RequestMapping("/dyxsbhqs")
	@ResponseBody
	public Map<String, Object> dyxsbhqs(@RequestParam("county") String county) {
		// 当月线上受理
		List<Map<String, Object>> dyxsslcsList = countyLevelService.dyxsslcs(county);
		// 当月线上办结
		List<Map<String, Object>> dyxsbjcsList = countyLevelService.dyxsbjcs(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dyxsslcsList", dyxsslcsList);
		_map.put("dyxsbjcsList", dyxsbjcsList);
		return _map;
	}

	// 当月线下变化趋势
	@RequestMapping("/dyxxbhqs")
	@ResponseBody
	public Map<String, Object> dyxxbhqs(@RequestParam("county") String county) {
		// 当月线下受理
		List<Map<String, Object>> dyxxslcsList = countyLevelService.dyxxslcs(county);
		// 当月线下办结
		List<Map<String, Object>> dyxxbjcsList = countyLevelService.dyxxbjcs(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dyxxslcsList", dyxxslcsList);
		_map.put("dyxxbjcsList", dyxxbjcsList);
		return _map;
	}

	// 当年线上变化趋势
	@RequestMapping("/dnxsbhqs")
	@ResponseBody
	public Map<String, Object> dnxsbhqs(@RequestParam("county") String county) {
		// 当年线上受理
		List<Map<String, Object>> dnxsslcsList = countyLevelService.dnxsslcs(county);
		// 当年线上办结
		List<Map<String, Object>> dnxsbjcsList = countyLevelService.dnxsbjcs(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dnxsslcsList", dnxsslcsList);
		_map.put("dnxsbjcsList", dnxsbjcsList);
		return _map;
	}

	// 当年线下变化趋势
	@RequestMapping("/dnxxbhqs")
	@ResponseBody
	public Map<String, Object> dnxxbhqs(@RequestParam("county") String county) {
		// 当年线下受理
		List<Map<String, Object>> dnxxslcsList = countyLevelService.dnxxslcs(county);
		// 当年线下办结
		List<Map<String, Object>> dnxxbjcsList = countyLevelService.dnxxbjcs(county);
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("dnxxslcsList", dnxxslcsList);
		_map.put("dnxxbjcsList", dnxxbjcsList);
		return _map;
	}

	// 全区县目录运行事项数据总览
	@RequestMapping("/sxsjzl")
	@ResponseBody
	public Map<String, Object> sxsjzl(@RequestParam("county") String county, @RequestParam("depth") String depth) {

		String ysqgksxNum = countyLevelService.ysqgksxNumSum(county); // 目录运行事项数
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("ysqgksxNum", ysqgksxNum);

		// 线上办理：可网上办理的数
		String xsblsx = countyLevelService.ysqgkkwshblNum(county,depth);
		_map.put("xsblsx", xsblsx);
		// 已发布
		Map<String, Object> sxxzsyjwsbls_Publish = countyLevelService.sxxzsyjwsbls_PublishSum(county);
		_map.put("sxxzsyjwsbls_Publish", sxxzsyjwsbls_Publish);
		// 可网上办理
		Map<String, Object> sxxzsyjwsbls_onLine = new HashMap<String, Object>();
		if (depth == null || depth.equals("")) {
			sxxzsyjwsbls_onLine = countyLevelService.sxxzsyjwsbls_onLine(county);

		} else {
			// 网办深度
			sxxzsyjwsbls_onLine = countyLevelService.sxxzsyjwsbls_depth(county, depth);
		}
		_map.put("sxxzsyjwsbls_onLine", sxxzsyjwsbls_onLine);
		return _map;
	}

	// 表格下载功能

	/**
	 *
	 * @param val
	 *            checkbox选中的值
	 * @param name
	 *            checkbox选中的名字
	 * @return
	 */
	@RequestMapping("/countyLevelDownload")
	public void countyLevelDownload(@RequestParam("checkVal") String depth, @RequestParam("checkName") String name,
                                    HttpServletResponse response) {
		OutputStream out = null;
		try {
			File file = ResourceUtils.getFile("classpath:static/excel/区县级事项数据表格.xlsx");
			// 模版文件名
			String oldName = file.getName();
			// 截取掉文件后缀名
			String fileName = oldName.substring(0, oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建一个Excel的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			// 设置单元格样式
			XSSFCellStyle cellStyle = workbook.createCellStyle();// 创建设置EXCEL表格样式对象
																	// cellStyle
			cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);// 下边框
			cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
			cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
			cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
			cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			// 字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);// 设置字体大小   
			cellStyle.setFont(font);// 选择创建的字体格式 
			// 读取workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 查询需要导出的数据
			// 读取全区县数据
			readData(null, depth, sheet, name, 0, cellStyle);
			// 历城区
			readData("历城区", depth, sheet, name, 12, cellStyle);
			// 历下区
			readData("历下区", depth, sheet, name, 24, cellStyle);
			// 市中区
			readData("市中区", depth, sheet, name, 36, cellStyle);
			// 天桥区
			readData("天桥区", depth, sheet, name, 48, cellStyle);
			// 槐荫区
			readData("槐荫区", depth, sheet, name, 60, cellStyle);
			// 章丘区
			readData("章丘区", depth, sheet, name, 72, cellStyle);
			// 长清区
			readData("长清区", depth, sheet, name, 84, cellStyle);
			// 济阳区
			readData("济阳区", depth, sheet, name, 96, cellStyle);
			// 商河县
			readData("商河县", depth, sheet, name, 108, cellStyle);
			// 平阴县
			readData("平阴县", depth, sheet, name, 120, cellStyle);

			// 清除buffer缓存
			response.reset();
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xlsx");
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
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void readData(String county, String depth, XSSFSheet sheet, String titleName, int rowNo,
                          XSSFCellStyle cellStyle) {
		sheet.getRow(rowNo).getCell(4).setCellValue(titleName); // 设置表头名称
		// sheet.getRow(rowNo).getCell(4).setCellStyle(cellStyle);
		Map<String, Object> qqxshx = sxsjzl(county, depth);
		// "事项情况" 数据
		int ysqgksxNum = Integer.parseInt(qqxshx.get("ysqgksxNum").toString());// 依申请事项数
		int xsblsx = Integer.parseInt(qqxshx.get("xsblsx").toString());// 可网上办理数
		// 各分类网办率 DoubleUtils.getDoublePercent(_ysqgksxgjwbsdcx, _ysqgksx);
		String flwb_rate = DoubleUtils.getDoublePercent(xsblsx, ysqgksxNum);
		// 整体网办率
		String ztwb_rate = DoubleUtils.getDoublePercent(xsblsx, ysqgksxNum);
		// 数据填充
		sheet.getRow(rowNo + 1).getCell(3).setCellValue(String.valueOf(ysqgksxNum)); // 依申请
		sheet.getRow(rowNo + 1).getCell(3).setCellStyle(cellStyle);
		sheet.getRow(rowNo + 1).getCell(4).setCellValue(String.valueOf(xsblsx)); // 可网上办理数
		sheet.getRow(rowNo + 1).getCell(4).setCellStyle(cellStyle);
		sheet.getRow(rowNo + 1).getCell(5).setCellValue(String.valueOf(flwb_rate)); // 各分类网办率
		sheet.getRow(rowNo + 1).getCell(5).setCellStyle(cellStyle);
		sheet.getRow(rowNo + 1).getCell(6).setCellValue(String.valueOf(ztwb_rate)); // 整体网办率
		sheet.getRow(rowNo + 1).getCell(6).setCellStyle(cellStyle);
		// "事项性质" 数据
		// 已发布
		Map<String, Object> publish_Map = new HashMap<String, Object>();
		publish_Map = (Map<String, Object>) qqxshx.get("sxxzsyjwsbls_Publish");
		// 可网上办理
		Map<String, Object> onLine_Map = (Map<String, Object>) qqxshx.get("sxxzsyjwsbls_onLine");

		String xzhName = "";
		for (Entry<String, Object> entry : publish_Map.entrySet()) {
			switch (entry.getKey()) {
			case "XK":
				xzhName = "行政许可";
				break;
			case "ZS":
				xzhName = "行政征收";
				break;
			case "QR":
				xzhName = "行政确认";
				break;
			case "JF":
				xzhName = "行政给付";
				break;
			case "JL":
				xzhName = "行政奖励";
				break;
			case "CJ":
				xzhName = "行政裁决";
				break;
			case "QT":
				xzhName = "其他权力";
				break;
			case "GG":
				xzhName = "公共服务";
				break;
			case "JD":
				xzhName = "行政监督";
				break;
			default:
				break;
			}
			sheet.getRow(rowNo + 2).getCell(2).setCellValue(xzhName); // 事项性质名称
			// sheet.getRow(rowNo+2).getCell(2).setCellStyle(cellStyle);
			int publicysqNum = Integer.parseInt(entry.getValue() == null ? "0" : entry.getValue().toString());
			sheet.getRow(rowNo + 2).getCell(3).setCellValue(String.valueOf(publicysqNum)); // 事项性质：依申请数
			sheet.getRow(rowNo + 2).getCell(3).setCellStyle(cellStyle);
			int onLineNum = 0;
			for (Entry<String, Object> entryLine : onLine_Map.entrySet()) {
				if (entry.getKey().equals(entryLine.getKey())) {
					onLineNum = Integer.parseInt(entryLine.getValue() == null ? "0" : entryLine.getValue().toString());
				}
			}
			sheet.getRow(rowNo + 2).getCell(4).setCellValue(onLineNum); // 事项性质:可网上办理
			sheet.getRow(rowNo + 2).getCell(4).setCellStyle(cellStyle);
			// 事项性质：各分类网办率
			// 各分类网办率
			String flwb_rate1 = DoubleUtils.getDoublePercent(onLineNum, publicysqNum);
			// 整体网办率
			String ztwb_rate1 = DoubleUtils.getDoublePercent(onLineNum, ysqgksxNum);
			sheet.getRow(rowNo + 2).getCell(5).setCellValue(flwb_rate1);
			sheet.getRow(rowNo + 2).getCell(5).setCellStyle(cellStyle);
			sheet.getRow(rowNo + 2).getCell(6).setCellValue(ztwb_rate1); // 事项性质：整体网办率
			sheet.getRow(rowNo + 2).getCell(6).setCellStyle(cellStyle);
			rowNo++;
		}

	}
}
