package com.inspur.controller;

import com.inspur.service.ShareResourceService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 共享交换--共享资源页面
 * 
 * @author wangjinli
 * @date 2018年12月27日
 */
@Controller
@RequestMapping("/shareResourceController")
public class ShareResourceController {

	@Autowired
	ShareResourceService shareResourceService;

	/**
	 * 资源类型统计
	 */
	@RequestMapping("/resourceTypeTj")
	@ResponseBody
	public Map<String, Object> resourceTypeTj() {
		// 数据目录总数、库表总数、文件总数、接口总数
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapCataTotal = new HashMap<String, Object>();
		mapCataTotal = shareResourceService.getCataTotal();
		map.put("total_cata_count", mapCataTotal.get("total_cata_count").toString());
		map.put("count_db_table", mapCataTotal.get("count_db_table").toString());
		map.put("count_file", mapCataTotal.get("count_file").toString());

		// 接口总数
		Map<String, Object> mapServiceTotal = new HashMap<String, Object>();
		mapServiceTotal = shareResourceService.getServiceTotal();
		map.put("total_service", mapServiceTotal.get("total_service"));
		return map;
	}

	/**
	 * 各部门可共享资源目录数
	 * 
	 */
	@RequestMapping("/bmCatalogTj")
	@ResponseBody
	public List<Map<String, Object>> bmCatalogTj() {
		List<Map<String, Object>> bmCatalogTjList = shareResourceService.bmCatalogTj();
		return bmCatalogTjList;
	}

	/**
	 * 现有资源数 :有效库表、数据量、接口、文件
	 */
	@RequestMapping("/xybResourceTj")
	@ResponseBody
	public Map<String, Object> xyResourceTj() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 资源数
		List<Map<String, Object>> zyTjList = shareResourceService.xyResourceTj_zy();
		map.put("zyTjList", zyTjList);
		// 有效库表
		List<Map<String, Object>> kbTjList = shareResourceService.xyResourceTj_kb();
		map.put("kbTjList", kbTjList);
		// 数据量
		List<Map<String, Object>> shjLTjList = shareResourceService.xyResourceTj_shjL();
		map.put("shjLTjList", shjLTjList);
		// 接口
		List<Map<String, Object>> jkTjList = shareResourceService.xyResourceTj_jk();
		map.put("jkTjList", jkTjList);
		// 文件
		List<Map<String, Object>> wjTjList = shareResourceService.xyResourceTj_wj();
		map.put("wjTjList", wjTjList);
		return map;
	}
	
	/**
	 * 现有资源数 :下载
	 */
	@RequestMapping("/xyResourceDownload")
	@ResponseBody
	public void xyResourceDownload(HttpServletResponse response) {
		
		OutputStream out = null;
		try {									
			File file = ResourceUtils.getFile("classpath:static/excel/市级部门现有资源情况汇总.xlsx");
			// 模板文件名
			String oldName = file.getName();
			// 截取掉文件后缀名
			String fileName = oldName.substring(0,oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建Excel 的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			// 设置单元格样式：居左
			XSSFCellStyle cellStyle = workbook.createCellStyle();//创建设置EXCEL表格样式对象 cellStyle
			cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//下边框
			cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
			cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
			cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);//水平居左
			cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
			// 设置单元格样式：居中
			XSSFCellStyle cellStyleCenter = workbook.createCellStyle();// 创建设置EXCEL表格样式对象
			cellStyleCenter.setBorderBottom(XSSFCellStyle.BORDER_THIN);// 下边框
			cellStyleCenter.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
			cellStyleCenter.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
			cellStyleCenter.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			cellStyleCenter.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
			cellStyleCenter.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			
			// 字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);//设置字体大小   
			cellStyle.setFont(font);//选择创建的字体格式 
			// 读取workbook：库表、数据量
			XSSFSheet sheet = workbook.getSheetAt(0);
			workbook.setSheetName(0, "资源总数");
			workbook.setSheetName(1, "库表和数据量");
			workbook.setSheetName(2, "接口");
			workbook.setSheetName(3, "文件");
			
			// ---------获取资源的数据
			// 资源总数
			List<Map<String, Object>> zyTjList = shareResourceService.xyResourceTj_zy();
			
			// 有效库表、数据量
			List<Map<String, Object>> kbTjList = shareResourceService.xyResourceTj_kb();
			
			// 接口
			List<Map<String, Object>> jkTjList = shareResourceService.xyResourceTj_jk();
			// 文件
			List<Map<String, Object>> wjTjList = shareResourceService.xyResourceTj_wj();
		// 填充数据 
			// 资源总览
			int rowZy = 1;
			for(int i=0;i<kbTjList.size();i++){ 
				Map<String,Object> zy_map = zyTjList.get(i);
				String bm = zy_map.get("organ_name").toString();
				
				// 创建行
				XSSFRow row = sheet.createRow(rowZy);

				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i + 1);
				cellNum.setCellStyle(cellStyle);

				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bm));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellbzy = row.createCell(2); // 资源总数
				cellbzy.setCellValue(zy_map.get("zyNum").toString());
				cellbzy.setCellStyle(cellStyleCenter);
				
				XSSFCell cellKb = row.createCell(3); // 库表
				cellKb.setCellValue(zy_map.get("kbNum").toString());
				cellKb.setCellStyle(cellStyleCenter);
				
				XSSFCell cellJk = row.createCell(4); // 接口
				cellJk.setCellValue(zy_map.get("jkNum").toString());
				cellJk.setCellStyle(cellStyleCenter);
				
				XSSFCell cellWj = row.createCell(5); // 文件
				cellWj.setCellValue(zy_map.get("wjNum").toString());
				cellWj.setCellStyle(cellStyleCenter);
				
				rowZy++;
			}
		// 库表、数据量
		int rowNo = 1;
		XSSFSheet sheetKb = workbook.getSheetAt(1);
		for(int i=0;i<kbTjList.size();i++){ 
			Map<String,Object> zy_map = kbTjList.get(i);
			String bm = zy_map.get("organ_name").toString();
			
			// 创建行
			XSSFRow row = sheetKb.createRow(rowNo);

			XSSFCell cellNum = row.createCell(0);// 序号
			cellNum.setCellValue(i + 1);
			cellNum.setCellStyle(cellStyle);

			XSSFCell cellBm = row.createCell(1);// 部门
			cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bm));
			cellBm.setCellType(Cell.CELL_TYPE_STRING);
			cellBm.setCellStyle(cellStyle);

			XSSFCell cellbzy = row.createCell(2); // 库表
			cellbzy.setCellValue(zy_map.get("kbNum").toString());
			cellbzy.setCellStyle(cellStyleCenter);
			
			rowNo++;
		}
		// 接口
		XSSFSheet sheetjk = workbook.getSheetAt(2);
		int rowJk = 1;
		for(int i=0;i<jkTjList.size();i++){ 
			Map<String,Object> zy_map = jkTjList.get(i);
			String bm = zy_map.get("organ_name").toString();
			
			// 创建行
			XSSFRow row = sheetjk.createRow(rowJk);

			XSSFCell cellNum = row.createCell(0);// 序号
			cellNum.setCellValue(i + 1);
			cellNum.setCellStyle(cellStyle);

			XSSFCell cellBm = row.createCell(1);// 部门
			cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bm));
			cellBm.setCellType(Cell.CELL_TYPE_STRING);
			cellBm.setCellStyle(cellStyle);

			XSSFCell cellbzy = row.createCell(2); // 接口
			cellbzy.setCellValue(zy_map.get("jkNum").toString());
			cellbzy.setCellStyle(cellStyleCenter);
		
			
			rowJk++;
		}
		
			// 文件
			XSSFSheet sheetWj = workbook.getSheetAt(3);
			int rowWj = 1;
			for (int i = 0; i < wjTjList.size(); i++) {
				Map<String, Object> zy_map = wjTjList.get(i);
				String bm = zy_map.get("organ_name").toString();

				// 创建行
				XSSFRow row = sheetWj.createRow(rowWj);

				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i + 1);
				cellNum.setCellStyle(cellStyle);

				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bm));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellbzy = row.createCell(2); // 文件
				cellbzy.setCellValue(zy_map.get("wjNum").toString());
				cellbzy.setCellStyle(cellStyleCenter);
				rowWj++;
			}
		
		// 清除buffer缓存
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
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
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
	 * 申请省级资源情况:申请接口数（项）、累计接口调用（次）
	 */
	@RequestMapping("/shqshjResourceQk")
	@ResponseBody
	public Map<String, Object> shqshjResourceQk() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 申请资源数
		List<Map<String, Object>> shQzyList = shareResourceService.shqshjResourceQk_shqzyNum();
		map.put("shQzyList", shQzyList);
		// 累计接口调用
		List<Map<String, Object>> ljJkDyList = shareResourceService.shqshjResourceQk_ljJkDyNum();
		map.put("ljJkDyList", ljJkDyList);
		return map;
	}
	/**
	 * 申请省级资源情况弹出框：下载(内容包括：申请资源数（项）、累计接口调用（次）
	 */
	@RequestMapping("/shQShjZyDownload")
	@ResponseBody
	public void shQShjZyDownload(HttpServletResponse response) {
		
		OutputStream out = null;
		try {									
			File file = ResourceUtils.getFile("classpath:static/excel/部门申请省级资源情况.xlsx");
			// 模板文件名
			String oldName = file.getName();
			// 截取掉文件后缀名
			String fileName = oldName.substring(0,oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建Excel 的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			workbook.setSheetName(0, "申请省级资源情况");
			// 设置单元格样式
			XSSFCellStyle cellStyleCenter = workbook.createCellStyle();//创建设置EXCEL表格样式对象 cellStyle
			cellStyleCenter.setBorderBottom(XSSFCellStyle.BORDER_THIN);//下边框
			cellStyleCenter.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
			cellStyleCenter.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
			cellStyleCenter.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
			cellStyleCenter.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
			cellStyleCenter.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
			
			// 设置单元格样式：居左
			XSSFCellStyle cellStyleLeft = workbook.createCellStyle();// 创建设置EXCEL表格样式对象cellStyle
			cellStyleLeft.setBorderBottom(XSSFCellStyle.BORDER_THIN);// 下边框
			cellStyleLeft.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
			cellStyleLeft.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
			cellStyleLeft.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			cellStyleLeft.setAlignment(XSSFCellStyle.ALIGN_LEFT);// 水平居左
			cellStyleLeft.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			// 字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);//设置字体大小   
			cellStyleCenter.setFont(font);//选择创建的字体格式 
			// 读取workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 查询需要导出的数据
			List<Map<String, Object>> shQzyList = shareResourceService.shqshjResourceQk_shqzyNum(); // 申请接口数
			List<Map<String, Object>> ljJkDyList = shareResourceService.shqshjResourceQk_ljJkDyNum(); // 累计接口调用
			readData(sheet,cellStyleCenter,cellStyleLeft,shQzyList,ljJkDyList);// 读取数据
			// 清除buffer缓存
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
			// TODO Auto-generated catch block
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
	// 申请省级资源情况下载：写入数据到Excel
	private void readData(XSSFSheet sheet, XSSFCellStyle cellStyleCenter, XSSFCellStyle cellStyleLeft, List<Map<String, Object>> listJK, List<Map<String, Object>> listTJ) {
		int rowNo = 1;
		// 获取数据
		List<String> bmList = new ArrayList<String>();// 部门名称
		List <String>dataList = new ArrayList<String>(); // 具体数据
		for(int i=0;i<listJK.size();i++){
			Map<String, Object> map = listJK.get(i);
			bmList.add(map.get("organ_name").toString());
			dataList.add(map.get("applyNum").toString());
		}		
		// 填充数据
		for(int i=0;i<bmList.size();i++){
			int tjJK = 0;
			for(int j=0;j<listTJ.size();j++){
				if(bmList.get(i).equals(listTJ.get(j).get("organ_name"))){
					tjJK = Integer.valueOf(listTJ.get(j).get("JkNum").toString());
					break;
				}else{
					tjJK = 0;
				}
			}
			// 创建行
			XSSFRow row = sheet.createRow(rowNo);
			
			XSSFCell cellNum = row.createCell(0);// 序号
			cellNum.setCellValue(i+1);
			cellNum.setCellStyle(cellStyleLeft);
			
			XSSFCell cellBm = row.createCell(1);// 部门
			cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bmList.get(i)));// ""转义
			cellBm.setCellType(Cell.CELL_TYPE_STRING);
			cellBm.setCellStyle(cellStyleLeft);

			XSSFCell cellJK = row.createCell(2); // 申请接口数
			cellJK.setCellValue(dataList.get(i));
			cellJK.setCellStyle(cellStyleCenter);
			
			XSSFCell cellTJ = row.createCell(3); // 累计接口调用次数
			cellTJ.setCellValue(tjJK);
			cellTJ.setCellStyle(cellStyleCenter);
			
			rowNo++;
		}
	}
	
	/**
	 * 申请市级资源情况:申请资源数（项） 、申请接口数（个）、累计接口调用（次） 
	 */
	@RequestMapping("/applyCityResourceQK")
	@ResponseBody
	public Map<String, Object> applyCityResourceQK() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 申请资源数（项） 、申请资源数（次）、通过数（次）、驳回数（次）
		List<Map<String, Object>> applyZyList = shareResourceService.applyCityResourceQK_applyZyNum();
		map.put("applyZyList", applyZyList);
		// 申请接口数（个）、申请数（次）、通过数（次）、驳回数（次）、累计接口调用（次）
		List<Map<String, Object>> applyJkList = shareResourceService.applyCityResourceQK_applyJkNum();
		map.put("applyJkList", applyJkList);
		// 累计接口调用（次）
		List<Map<String, Object>> totalJkDyList = shareResourceService.applyCityResourceQK_totalJkDyNum();
		map.put("totalJkDyList", totalJkDyList);
		return map;
	}
	
	/**
	 * 申请市级资源情况弹出框：下载
	 */
	@RequestMapping("/shqCityzyDownload")
	@ResponseBody
	public void shqCityzyDownload(HttpServletResponse response) {
		
		OutputStream out = null;
		try {									
			File file = ResourceUtils.getFile("classpath:static/excel/部门申请市级资源情况.xlsx");
			// 模板文件名
			String oldName = file.getName();
			// 截取掉文件后缀名
			String fileName = oldName.substring(0,oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建Excel 的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			workbook.setSheetName(0, "申请资源数");
			workbook.setSheetName(1, "申请接口数");
			// 设置单元格样式：居左
			XSSFCellStyle cellStyle = workbook.createCellStyle();//创建设置EXCEL表格样式对象 cellStyle
			cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//下边框
			cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
			cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
			cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);//水平居左
			cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
			// 设置单元格样式：居中
			XSSFCellStyle cellStyleCenter = workbook.createCellStyle();// 创建设置EXCEL表格样式对象
			cellStyleCenter.setBorderBottom(XSSFCellStyle.BORDER_THIN);// 下边框
			cellStyleCenter.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
			cellStyleCenter.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
			cellStyleCenter.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			cellStyleCenter.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
			cellStyleCenter.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			
			// 字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);//设置字体大小   
			cellStyle.setFont(font);//选择创建的字体格式 
			// 读取workbook：资源情况
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 读取workbook：接口情况
			XSSFSheet sheet1 = workbook.getSheetAt(1);
			// 查询需要导出的数据
			List<Map<String, Object>> shQzyList = shareResourceService.applyCityResourceQK_applyZyNum(); // 申请资源数（项）
			List<Map<String, Object>> listJK = shareResourceService.applyCityResourceQK_applyJkNum(); // 申请接口数
			// 读取资源数据
			int rowNum = 1;
			// 获取数据
			List<String> bmList_zy = new ArrayList<String>();// 部门名称
			List<String> dataList_zy = new ArrayList<String>(); // 具体数据:申请数（项）
			List<String> countList_zy = new ArrayList<String>(); // 具体数据:申请数（次）
			List<String> tgList_zy = new ArrayList<String>(); // 具体数据:通过数（次）
			List<String> bhList_zy = new ArrayList<String>(); // 具体数据:驳回数（次）
			for (int i = 0; i < shQzyList.size(); i++) {
				Map<String, Object> map = shQzyList.get(i);
				bmList_zy.add(map.get("organ_name").toString());
				dataList_zy.add(map.get("zyNum").toString());
				countList_zy.add(map.get("zyCount").toString());
				tgList_zy.add(map.get("tgCount").toString());
				bhList_zy.add(map.get("bhCount").toString());
			}
			// 填充数据
			for (int i = 0; i < bmList_zy.size(); i++) {
				
				// 创建行
				XSSFRow row = sheet.createRow(rowNum);

				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i + 1);
				cellNum.setCellStyle(cellStyle);

				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bmList_zy.get(i)));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellJK = row.createCell(2); // 申请资源数
				cellJK.setCellValue(dataList_zy.get(i));
				cellJK.setCellStyle(cellStyleCenter);
				
				XSSFCell cellCount = row.createCell(3); // 申请资源次数
				cellCount.setCellValue(countList_zy.get(i));
				cellCount.setCellStyle(cellStyleCenter);
				
				XSSFCell cellTg = row.createCell(4); // 通过数
				cellTg.setCellValue(tgList_zy.get(i));
				cellTg.setCellStyle(cellStyleCenter);
				
				XSSFCell cellBh = row.createCell(5); // 驳回数
				cellBh.setCellValue(bhList_zy.get(i));
				cellBh.setCellStyle(cellStyleCenter);
				
				rowNum++;
			}

			int rowNo = 1;// 读取接口数据
			// 获取数据
			List<String> bmList = new ArrayList<String>();// 部门名称
			List <String>dataList = new ArrayList<String>(); // 具体数据
			List<String> countList_jk = new ArrayList<String>(); // 申请数（次）
			List<String> tgList_jk = new ArrayList<String>(); // 通过数（次）
			List<String> bhList_jk = new ArrayList<String>(); // 驳回数（次）
			List<String> ljList_jk = new ArrayList<String>(); //  累计接口调用次数
			for(int i=0;i<listJK.size();i++){
				Map<String, Object> map = listJK.get(i);
				bmList.add(String.valueOf(map.get("organ_name")));
				dataList.add(map.get("jkNum").toString());
				countList_jk.add(map.get("jkCount").toString());
				tgList_jk.add(map.get("tgCount").toString());
				bhList_jk.add(map.get("bhCount").toString());
				ljList_jk.add(map.get("ljjkNum").toString());
			}		
			// 填充数据
			for(int i=0;i<bmList.size();i++){
				
				// 创建行
				XSSFRow row = sheet1.createRow(rowNo);
				
				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i+1);
				cellNum.setCellStyle(cellStyle);
				
				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bmList.get(i)));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellJK = row.createCell(2); // 申请接口数
				cellJK.setCellValue(dataList.get(i));
				cellJK.setCellStyle(cellStyleCenter);
				
				XSSFCell cellCount = row.createCell(3); // 申请接口次数
				cellCount.setCellValue(countList_jk.get(i));
				cellCount.setCellStyle(cellStyleCenter);
				
				XSSFCell cellTg = row.createCell(4); // 通过次数
				cellTg.setCellValue(tgList_jk.get(i));
				cellTg.setCellStyle(cellStyleCenter);
				
				XSSFCell cellBh = row.createCell(5); // 驳回次数
				cellBh.setCellValue(bhList_jk.get(i));
				cellBh.setCellStyle(cellStyleCenter);
				
				XSSFCell cellLj = row.createCell(6); // 累计接口调用次数
				cellLj.setCellValue(ljList_jk.get(i));
				cellLj.setCellStyle(cellStyleCenter);
				
				rowNo++;
			}
			
			// 清除buffer缓存
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
			// TODO Auto-generated catch block
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
	 * 市级资源提供响应情况 :资源（被申请数、被申请次数、被申请通过次数）、接口
	 */
	@RequestMapping("/cityZyProvideQK")
	@ResponseBody
	public Map<String, Object> cityZyProvideQK() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ---------获取资源的数据
		// 被申请数（项）
		List<Map<String, Object>> bShqZyList = shareResourceService.cityZyProvideQK_bShqZyNum();
		map.put("bShqZyList", bShqZyList);
		// 被申请次数（次）
		List<Map<String, Object>> bShqZyCshList = shareResourceService.cityZyProvideQK_bShqZyCshNum();
		map.put("bShqZyCshList", bShqZyCshList);
		// 被申请通过次数（次）
		List<Map<String, Object>> bShqZyTgList = shareResourceService.cityZyProvideQK_bShqZyTgNum();
		map.put("bShqZyTgList", bShqZyTgList);
		// --------获取接口的数据
		// 被申请数（项）
		List<Map<String, Object>> bShqJkList = shareResourceService.cityZyProvideQK_bShqJkNum();
		map.put("bShqJkList", bShqJkList);
		// 被申请次数（次）
		List<Map<String, Object>> bShqJkCshList = shareResourceService.cityZyProvideQK_bShqJkCshNum();
		map.put("bShqJkCshList", bShqJkCshList);
		// 被申请通过次数（次）
		List<Map<String, Object>> bShqJkTgList = shareResourceService.cityZyProvideQK_bShqJkTgNum();
		map.put("bShqJkTgList", bShqJkTgList);
		return map;
	}
	
	/**
	 * 市级资源提供响应情况 ：下载(资源、接口)
	 */
	@RequestMapping("/cityZyProvideDownload")
	@ResponseBody
	public void cityZyProvideDownload(HttpServletResponse response) {
		
		OutputStream out = null;
		try {									
			File file = ResourceUtils.getFile("classpath:static/excel/市级资源提供响应情况.xlsx");
			// 模板文件名
			String oldName = file.getName();
			// 截取掉文件后缀名
			String fileName = oldName.substring(0,oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建Excel 的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			workbook.setSheetName(0, "资源");
			workbook.setSheetName(1, "接口");
			// 设置单元格样式：居左
			XSSFCellStyle cellStyle = workbook.createCellStyle();//创建设置EXCEL表格样式对象 cellStyle
			cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//下边框
			cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
			cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
			cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);//水平居左
			cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
			// 设置单元格样式：居中
			XSSFCellStyle cellStyleCenter = workbook.createCellStyle();// 创建设置EXCEL表格样式对象
			cellStyleCenter.setBorderBottom(XSSFCellStyle.BORDER_THIN);// 下边框
			cellStyleCenter.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
			cellStyleCenter.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
			cellStyleCenter.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			cellStyleCenter.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
			cellStyleCenter.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			
			// 字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);//设置字体大小   
			cellStyle.setFont(font);//选择创建的字体格式 
			// 读取workbook：资源情况
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 读取workbook：接口情况
			XSSFSheet sheet1 = workbook.getSheetAt(1);
			// 查询需要导出的数据
			List<Map<String, Object>> bShqZyList = shareResourceService.cityZyProvideQK_bShqZyNum(); // 被申请数（项）
			List<Map<String, Object>> bShqZyCshList = shareResourceService.cityZyProvideQK_bShqZyCshNum(); // 被申请次数（次）
			List<Map<String, Object>> bShqZyTgList = shareResourceService.cityZyProvideQK_bShqZyTgNum(); // 被申请通过次数（次）
			// 读取资源数据
			int rowNum = 1;
			// 获取数据
			List<String> bmList_zy = new ArrayList<String>();// 部门名称
			List<String> dataList_bzy = new ArrayList<String>(); // 被申请数（项）
			List<String> dataList_bzyCount = new ArrayList<String>(); // 被申请次数（次）
			List<String> dataList_bzyTgCount = new ArrayList<String>(); // 被申请通过次数（次）
			for (int i = 0; i < bShqZyList.size(); i++) {
				Map<String, Object> map = bShqZyList.get(i);
				bmList_zy.add(map.get("organ_name").toString());
				dataList_bzy.add(map.get("bzy").toString());
				// 获取被申请次数数据
				String bm = map.get("organ_name").toString();
				int bzyCount = 0;
				for(int j =0;j<bShqZyCshList.size();j++){
					Map<String, Object> mapbzyC = bShqZyCshList.get(j);
					if(bm.equals(mapbzyC.get("organ_name"))){
						bzyCount = Integer.valueOf(mapbzyC.get("bshzy").toString());
						break;
					}
				}
				dataList_bzyCount.add(String.valueOf(bzyCount));
				
				// 获取被申请通过次数数据
				int bzyTgCount = 0;
				for(int j =0;j<bShqZyTgList.size();j++){
					Map<String, Object> mapbzyTgC = bShqZyTgList.get(j);
					if(bm.equals(mapbzyTgC.get("organ_name"))){
						bzyTgCount = Integer.valueOf(mapbzyTgC.get("bshtgzy").toString());
						break;
					}
				}
				dataList_bzyTgCount.add(String.valueOf(bzyTgCount));
				
			}
			// 填充数据
			for (int i = 0; i < bmList_zy.size(); i++) {
				
				// 创建行
				XSSFRow row = sheet.createRow(rowNum);

				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i + 1);
				cellNum.setCellStyle(cellStyle);

				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bmList_zy.get(i)));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellbzy = row.createCell(2); // 被申请数（项）
				cellbzy.setCellValue(dataList_bzy.get(i));
				cellbzy.setCellStyle(cellStyleCenter);
				
				XSSFCell cellbzyC = row.createCell(3); // 被申请次数（次）
				cellbzyC.setCellValue(dataList_bzyCount.get(i));
				cellbzyC.setCellStyle(cellStyleCenter);
				
				XSSFCell cellbzyTgC = row.createCell(4); // 被申请通过次数（此）
				cellbzyTgC.setCellValue(dataList_bzyTgCount.get(i));
				cellbzyTgC.setCellStyle(cellStyleCenter);
				
				rowNum++;
			}
			// -----读取接口数据
			int rowNo = 1;
			// 查询需要导出的数据
			List<Map<String, Object>> bShqJkList = shareResourceService.cityZyProvideQK_bShqJkNum(); // 被申请数（项）
			List<Map<String, Object>> bShqJkCshList = shareResourceService.cityZyProvideQK_bShqJkCshNum(); // 被申请次数（次）
			List<Map<String, Object>> bShqJkTgList = shareResourceService.cityZyProvideQK_bShqJkTgNum();// 被申请通过次数（次）
			// 获取数据
			List<String> bmList_jk = new ArrayList<String>();// 部门名称
			List<String> dataList_bjk = new ArrayList<String>(); // 被申请数（项）
			List<String> dataList_bjkCount = new ArrayList<String>(); // 被申请次数（次）
			List<String> dataList_bjkTgCount = new ArrayList<String>(); // 被申请通过次数（次）
			for (int i = 0; i < bShqJkList.size(); i++) {
				Map<String, Object> mapJk = bShqJkList.get(i);
				bmList_jk.add(mapJk.get("org_name").toString());
				dataList_bjk.add(mapJk.get("bjkNum").toString());
				// 获取被申请次数数据
				String bm = mapJk.get("org_name").toString();
				int bjkCount = 0;
				for(int j =0;j<bShqJkCshList.size();j++){
					Map<String, Object> mapbjkC = bShqJkCshList.get(j);
					if(bm.equals(mapbjkC.get("org_name"))){
						bjkCount = Integer.valueOf(mapbjkC.get("bjkCount").toString());
						break;
					}
				}
				dataList_bjkCount.add(String.valueOf(bjkCount));
				
				// 获取被申请通过次数数据
				int bjkTgCount = 0;
				for(int j =0;j<bShqJkTgList.size();j++){
					Map<String, Object> mapbjkTgC = bShqJkTgList.get(j);
					if(bm.equals(mapbjkTgC.get("org_name"))){
						bjkTgCount = Integer.valueOf(mapbjkTgC.get("btgCount").toString());
						break;
					}
				}
				dataList_bjkTgCount.add(String.valueOf(bjkTgCount));
				
			}
			// 填充数据
			for (int i = 0; i < bmList_jk.size(); i++) {
				
				// 创建行
				XSSFRow row = sheet1.createRow(rowNo);

				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i + 1);
				cellNum.setCellStyle(cellStyle);

				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bmList_zy.get(i)));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellbzy = row.createCell(2); // 被申请数（项）
				cellbzy.setCellValue(dataList_bzy.get(i));
				cellbzy.setCellStyle(cellStyleCenter);
				
				XSSFCell cellbzyC = row.createCell(3); // 被申请次数（次）
				cellbzyC.setCellValue(dataList_bzyCount.get(i));
				cellbzyC.setCellStyle(cellStyleCenter);
				
				XSSFCell cellbzyTgC = row.createCell(4); // 被申请通过次数（此）
				cellbzyTgC.setCellValue(dataList_bzyTgCount.get(i));
				cellbzyTgC.setCellStyle(cellStyleCenter);
				
				rowNo++;
			}
			
			// 清除buffer缓存
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
			// TODO Auto-generated catch block
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
	 * 区县资源使用情况 :数据资源目录总数、已挂接资源目录数
	 */
	@RequestMapping("/qxZyQk")
	@ResponseBody
	public Map<String, Object> qxZyQk() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ---------获取资源的数据
		// 数据资源目录总数
		List<Map<String, Object>> zyList = shareResourceService.qxZyQk_zymlNum();
		map.put("zyList", zyList);
		// 已挂接资源目录数(新)
		List<Map<String, Object>> gzZymLListN = shareResourceService.qxZyQk_gzZymLNum_N();
		map.put("gzZymLListN", gzZymLListN);
		// 已挂接资源目录数(旧)-----------旧表往新表中导数据，表处于数据整理阶段，暂且暂停。
		// List<Map<String, Object>> gzZymLListO = shareResourceService.qxZyQk_gzZymLNum_O();
		// map.put("gzZymLListO", gzZymLListO);
		// 接口
		List<Map<String, Object>> gzJkList = shareResourceService.qxZyQk_gzJkList();
		map.put("gzJkList", gzJkList);
		// 库表--仅为济南市数据
		List<Map<String, Object>> gzKbList = shareResourceService.qxZyQk_gzkbList();
		map.put("gzKbList", gzKbList);
		return map;
	}
	
	/**
	 * 区县资源使用情况 :下载
	 */
	@RequestMapping("/qxZyQkDownload")
	@ResponseBody
	public void qxZyQkDownload(HttpServletResponse response) {
		
		OutputStream out = null;
		try {									
			File file = ResourceUtils.getFile("classpath:static/excel/各区县资源使用情况汇总.xlsx");
			// 模板文件名
			String oldName = file.getName();
			// 截取掉文件后缀名
			String fileName = oldName.substring(0,oldName.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(file);
			final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
			// 新建Excel 的工作空间
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook = tpWorkbook;
			// 设置单元格样式：居左
			XSSFCellStyle cellStyle = workbook.createCellStyle();//创建设置EXCEL表格样式对象 cellStyle
			cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);//下边框
			cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
			cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
			cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
			cellStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);//水平居左
			cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
			// 设置单元格样式：居中
			XSSFCellStyle cellStyleCenter = workbook.createCellStyle();// 创建设置EXCEL表格样式对象
			cellStyleCenter.setBorderBottom(XSSFCellStyle.BORDER_THIN);// 下边框
			cellStyleCenter.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
			cellStyleCenter.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
			cellStyleCenter.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			cellStyleCenter.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
			cellStyleCenter.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			
			// 字体样式
			XSSFFont font = workbook.createFont();
			font.setFontName("Microsoft YaHei UI");
			font.setFontHeightInPoints((short) 11);// 设置字体大小   
			cellStyle.setFont(font);// 选择创建的字体格式 
			// 读取workbook：资源情况
			XSSFSheet sheet = workbook.getSheetAt(0);

			// ---------获取资源的数据
			// 数据资源目录总数
			List<Map<String, Object>> zyList = shareResourceService.qxZyQk_zymlNum();
			List<Map<String, Object>> gzZymLListN = shareResourceService.qxZyQk_gzZymLNum_N();// 已挂接：文件(新)
			// 已挂接资源目录数(旧)
			// List<Map<String, Object>> gzZymLListO =
			// shareResourceService.qxZyQk_gzZymLNum_O();
			List<Map<String, Object>> gzJkList = shareResourceService.qxZyQk_gzJkList();// 已挂接：接口
			List<Map<String, Object>> gzKbList = shareResourceService.qxZyQk_gzkbList();// 已挂接：库表
			// 填充数据
			int rowNo = 1;
			for (int i = 0; i < zyList.size(); i++) {
				Map<String, Object> zy_map = zyList.get(i);
				String bm = zy_map.get("region_name").toString();
				// 已挂接资源目录数(新)
				int gzzyNumN = 0;
				for (int j = 0; j < gzZymLListN.size(); j++) {
					Map<String, Object> gz_map = gzZymLListN.get(j);
					if (bm.equals(gz_map.get("region_name").toString())) {
						gzzyNumN = Integer.valueOf(gz_map.get("zygjNum_x").toString());
						break;
					}
				}
				/*
				 * // 已挂接资源目录数(旧) --- 旧表往新表中导数据，表处于数据整理阶段，暂且暂停。 int gzzyNumO =
				 * 0; for(int t =0;t<gzZymLListO.size();t++ ){
				 * Map<String,Object> gz_map = gzZymLListO.get(t);
				 * if(bm.equals(gz_map.get("region_name").toString())){ gzzyNumO
				 * = Integer.valueOf(gz_map.get("zygjNum_o").toString()); break;
				 * } }
				 * 
				 * // 新+旧 gzzyNumN = gzzyNumN + gzzyNumO;
				 */

				// 已挂接:接口
				for (int t = 0; t < gzJkList.size(); t++) {
					Map<String, Object> gz_map = gzJkList.get(t);
					if (bm.equals(gz_map.get("region_name").toString())) {
						gzzyNumN += Integer.valueOf(gz_map.get("qxjkNum").toString());
						break;
					}
				}
				// 已挂接:库表--仅济南市数据
				for (int t = 0; t < gzKbList.size(); t++) {
					Map<String, Object> kb_map = gzKbList.get(t);
					if (bm.equals(kb_map.get("region_name").toString())) {
						gzzyNumN += Integer.valueOf(kb_map.get("jnkbNum").toString());
						break;
					}
				}
				// 创建行
				XSSFRow row = sheet.createRow(rowNo);

				XSSFCell cellNum = row.createCell(0);// 序号
				cellNum.setCellValue(i + 1);
				cellNum.setCellStyle(cellStyle);

				XSSFCell cellBm = row.createCell(1);// 部门
				cellBm.setCellValue(StringEscapeUtils.unescapeHtml4(bm));
				cellBm.setCellType(Cell.CELL_TYPE_STRING);
				cellBm.setCellStyle(cellStyle);

				XSSFCell cellbzy = row.createCell(2); // 数据资源目录总数
				cellbzy.setCellValue(zy_map.get("zymlNum").toString());
				cellbzy.setCellStyle(cellStyleCenter);

				XSSFCell cellbzyC = row.createCell(3); // 已挂接资源目录数
				cellbzyC.setCellValue(String.valueOf(gzzyNumN));
				cellbzyC.setCellStyle(cellStyleCenter);

				rowNo++;
			}
		
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

}
