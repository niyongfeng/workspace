package cn.itcast.bos.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;


/**
 * 操作Excel的工具类
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年1月20日 上午11:30:21
 * @version 1.0
 */
public final class ExcelUtil {
	/**
	 * 解析Excel文件的方法
	 * @param excelFile 文件
	 * @return
	 */
	public static List<Map<Integer, Object>> parseExcel(File excelFile) throws Exception {
		/** 通过指定的文件创建工作簿 */
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(excelFile));
		/** 获取工作单 */
		HSSFSheet sheet = workbook.getSheetAt(0);
		/** 获取最后一行的索引号 */
		int lastRowIndex = sheet.getLastRowNum();
		
		/** 定义List集合封装Excel文件中的数据 */
		List<Map<Integer, Object>> excelData = new ArrayList<>();
		
		/** 循环行   第一行是标题行(不要)*/
		for (int i = 1; i <= lastRowIndex; i++){
			/** 创建Map集合封装一行数据 */
			Map<Integer, Object> rowData = new HashMap<>();
			/** 获取一行 */
			HSSFRow row = sheet.getRow(i);
			/** 获取该行对应的列得迭代器 */
			Iterator<Cell> cells = row.cellIterator();
			/** 迭代所有的列 */
			while (cells.hasNext()){
				/** 获取一列 */
				Cell cell = cells.next();
				/** 获取列的索引号 */
				int columnIndex = cell.getColumnIndex();
				/** 判断列的内容对应的数据类型 */
				if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){ // 布尔
					rowData.put(columnIndex, cell.getBooleanCellValue());
				}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){ // 数值
					/** 判断是不是日期类型 */
					if (DateUtil.isCellDateFormatted(cell)){
						rowData.put(columnIndex, cell.getDateCellValue());
					}else{
						rowData.put(columnIndex, cell.getNumericCellValue());
					}
				}else{ // 字符串
					rowData.put(columnIndex, cell.getStringCellValue());
				}
			}
			excelData.add(rowData);
		}
		/** 关闭工作簿 */
		workbook.close();
		return excelData;
	}

	public static void exportExcel(String filename, String sheetname,
			String[] titles, List<?> data, HttpServletResponse response) 
					throws Exception{
		/** 创建空的工作簿 */
		HSSFWorkbook workbook = new HSSFWorkbook();
		/** 通过工作簿创建工作单 */
		HSSFSheet sheet = workbook.createSheet(sheetname);
		/** 创建第一行(标题行) */
		HSSFRow row = sheet.createRow(0);
		/** 循环创建第一行中所有列 */
		for (int i = 0; i < titles.length; i++){
			/** 创建列 */
			HSSFCell cell = row.createCell(i);
			/** 设置列中的内容 */
			cell.setCellValue(titles[i]);
		}
		
		/** #################### 中间数据行 ####################### */
		for (int i = 0; i < data.size(); i++){
			/** 创建行 */
			row = sheet.createRow(i + 1);
			/** 获取集合中的元素: SubAreaBean */
			Object obj = data.get(i);
			/** 获取对象中所有的Field */
			Field[] fields = obj.getClass().getDeclaredFields();
			/** 循环Field创建列 */
			for (int j = 0; j < fields.length; j++){
				/** 获取Field */
				Field field = fields[j];
				/** 设置Field可以访问 */
				field.setAccessible(true);
				/** 取字段的值  */
				Object value = field.get(obj);
				/** 创建列 */
				HSSFCell cell = row.createCell(j);
				/** 设置列中的值 */
				cell.setCellValue(value == null ? "" : value.toString());
			}
		}
		/** #################### 中间数据行 ####################### */
		
		/** 下载时文件名为中文：乱码解决 */
		// 响应的过程：
		// 服务器： utf-8|gbk --> iso8859-1    浏览器: iso8859-1 --> utf-8|gbk (firefox、chrome)
		// 服务器： gbk --> iso8859-1    浏览器: iso8859-1 --> gbk (msie)
		filename = new String(filename.getBytes("gbk"), "iso8859-1");
		/** 设置下载的文件名 */
		response.setHeader("content-disposition", "attachment;filename=" + filename + ".xls");
		/** 向浏览器输出Excel文件 */
		workbook.write(response.getOutputStream());
		/** 关闭工作簿 */
		workbook.close();
	}
	
}
