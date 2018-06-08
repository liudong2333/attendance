package com.nantian.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelForMySQLUtil {
	@SuppressWarnings("deprecation")
	public static List<String> getHeadListFromExcel(String filePath) {
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
		}

		FileInputStream fis = null;
		Workbook wookbook = null;
		int flag = 0;

		try {
			// 获取一个绝对地址的流
			fis = new FileInputStream(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// 2003版本的excel，用.xls结尾
			wookbook = new HSSFWorkbook(fis);

		} catch (Exception ex) {
			// ex.printStackTrace();
			try {
				// 2007版本的excel，用.xlsx结尾

				wookbook = new XSSFWorkbook(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 得到一个工作表
		Sheet sheet = wookbook.getSheetAt(0);

		// 获得表头
		Row rowHead = sheet.getRow(0);

		int j = rowHead.getPhysicalNumberOfCells();

		// 判断表头是否合格 ------------------------这里看你有多少列
		// 先暂定这个表有40列,不同的情况下表的列数会有不同
		/*
		 * if (rowHead.getPhysicalNumberOfCells() != 40) {
		 * System.out.println("表头列数与要导入的数据库不对应"); }
		 */

		// 用于存放表头信息
		List<String> headList = new ArrayList<String>();

		try {
			// ----------------这里根据你的表格有多少列
			while (flag < j) {
				Cell cell = rowHead.getCell(flag);

				// 其实这里可以返回一个表头的List集合的
				headList.add(getRightTypeCell(cell).toString());

				flag++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("表头不合规范，请修改后重新导入");
		}

		// System.out.println(headList.toString());

		return headList;
	}

	public static Object getRightTypeCell(Cell cell) {

		Object object = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING: {
			object = cell.getStringCellValue();
			break;
		}
		case Cell.CELL_TYPE_NUMERIC: {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			object = cell.getNumericCellValue();
			break;
		}

		case Cell.CELL_TYPE_FORMULA: {
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			object = cell.getNumericCellValue();
			break;
		}

		case Cell.CELL_TYPE_BLANK: {
			cell.setCellType(Cell.CELL_TYPE_BLANK);
			object = cell.getStringCellValue();
			break;
		}
		}
		return object;
	}
}
