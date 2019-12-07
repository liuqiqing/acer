package com.inspur.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TemplateExportExcelUtil {

    /**
     *
     * @param file static/excel下的模版文件
     * @param dataList 数据库查询到的list集合，保持List<Map<String,Object>>这种格式
     * @param response 输出流
     *
     */
    public static void exportExcel(File file, List<Map<String,Object>> dataList, HttpServletResponse response){
        OutputStream out = null;
        try {
            //模版文件名
            String oldName = file.getName();
            //截取掉文件后缀名
            String fileName = oldName.substring(0,oldName.lastIndexOf("."));
            FileInputStream fis = new FileInputStream(file);
            final XSSFWorkbook tpWorkbook = new XSSFWorkbook(fis);
            // 新建一个Excel的工作空间
            XSSFWorkbook workbook = new XSSFWorkbook();
            workbook = tpWorkbook;
            //创建样式
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
            //读取模版，判断为空的一行
            XSSFSheet sheet = workbook.getSheetAt(0);
            int startRowIndex = sheet.getLastRowNum()+1;
            //填充数据
            XSSFRow row = null;
            for(int i=0;i<dataList.size();i++){
                //获取list集合的一行数据
                Map<String, Object> tempMap = dataList.get(i);
                //sheet中创建一行，对应这个list
                row = sheet.createRow(startRowIndex);
                //获取tempMap中键的集合
                Set<String> keySet = tempMap.keySet();
                int cellIndex = 0;
                for(String key : keySet){
                    //在当前的一行中创建单元格
                    XSSFCell cell = row.createCell(cellIndex);
                    cellIndex++;
                    Object tempObj = tempMap.get(key);
                    String str = String.valueOf(tempObj);
                    cell.setCellValue(str);
                    cell.setCellStyle(cellStyle);
                }
                startRowIndex++;
            }

            //清除buffer缓存
            response.reset();
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso8859-1")+".xlsx");
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

}
