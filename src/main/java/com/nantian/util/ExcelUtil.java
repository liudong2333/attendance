package com.nantian.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nantian.dto.Attendance;

public class ExcelUtil {

	@SuppressWarnings("deprecation")
	public static int getColumnNumbers(String filePath) {
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
		}

		FileInputStream fis = null;
		Workbook wookbook = null;

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
				e.printStackTrace();
			}
		}

		// 得到一个工作表
		Sheet sheet = wookbook.getSheetAt(0);

		// 获得表头
		Row rowHead = sheet.getRow(0);

		// 考虑不同的月份，表的列数会存在不同，40--31天 39--30天 38--29天 37--28天
		int numberOfColumns = rowHead.getPhysicalNumberOfCells();

		return numberOfColumns;
	}

	@SuppressWarnings("deprecation")
	public static List<Attendance> getAttendancesFromExcel(String filePath) {
		// List<TestDTO> list = new ArrayList<TestDTO>();
		List<Attendance> list = new ArrayList<Attendance>();
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
				e.printStackTrace();
			}
		}

		// 得到一个工作表
		Sheet sheet = wookbook.getSheetAt(0);

		// 获得表头
		Row rowHead = sheet.getRow(0);

		// 根据不同的data放置不同的表头
		Map<Object, Integer> headMap = new HashMap<Object, Integer>();

		// int j = rowHead.getPhysicalNumberOfCells();

		// 判断表头是否合格 ------------------------这里看你有多少列
		// 先暂定这个表有40列
		// 考虑不同的月份，表的列数会存在不同，40--31天 39--30天 38--29天 37--28天
		int numberOfCells = rowHead.getPhysicalNumberOfCells();
		// 如果表的格式就一种情况，那就可以固定下面的数字
		/*
		 * if (numberOfCells != 40) { System.out.println("表头列数与要导入的数据库不对应"); }
		 */

		// List<String> headList = new ArrayList<String>();

		try {
			// ----------------这里根据你的表格有多少列,不同的情况列数是变化的
			while (flag < numberOfCells) {
				Cell cell = rowHead.getCell(flag);

				if (cell != null && getRightTypeCell(cell).toString().equals("员工编号")) {
					headMap.put("empno", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("姓名")) {
					headMap.put("ename", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("厂商名称")) {
					headMap.put("company", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day1")) {
					headMap.put("day1", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day2")) {
					headMap.put("day2", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day3")) {
					headMap.put("day3", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day4")) {
					headMap.put("day4", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day5")) {
					headMap.put("day5", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day6")) {
					headMap.put("day6", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day7")) {
					headMap.put("day7", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day8")) {
					headMap.put("day8", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day9")) {
					headMap.put("day9", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day10")) {
					headMap.put("day10", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day11")) {
					headMap.put("day11", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day12")) {
					headMap.put("day12", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day13")) {
					headMap.put("day13", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day14")) {
					headMap.put("day14", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day15")) {
					headMap.put("day15", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day16")) {
					headMap.put("day16", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day17")) {
					headMap.put("day17", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day18")) {
					headMap.put("day18", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day19")) {
					headMap.put("day19", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day20")) {
					headMap.put("day20", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day21")) {
					headMap.put("day21", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day22")) {
					headMap.put("day22", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day23")) {
					headMap.put("day23", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day24")) {
					headMap.put("day24", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day25")) {
					headMap.put("day25", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day26")) {
					headMap.put("day26", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day27")) {
					headMap.put("day27", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day28")) {
					headMap.put("day28", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day29")) {
					headMap.put("day29", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day30")) {
					headMap.put("day30", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("day31")) {
					headMap.put("day31", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("应到")) {
					headMap.put("yingdao", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("实到")) {
					headMap.put("shidao", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("迟到")) {
					headMap.put("chidao", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("早退")) {
					headMap.put("zaotui", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("部室")) {
					headMap.put("bushi", flag);
				}
				if (cell != null && getRightTypeCell(cell).toString().equals("所属部门")) {
					headMap.put("suoshubumen", flag);
				}

				flag++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("表头不合规范，请修改后重新导入");
		}

		// System.out.println(headList.toString());

		// 获得数据的总行数
		int totalRowNum = sheet.getLastRowNum();

		// 要获得属性
		// String name = "";
		// double latitude = 0;

		String empno = "", yingdao = "", shidao = "", chidao = "", zaotui = "";
		String ename = "";
		String company = "";
		String day1 = "", day2 = "", day3 = "", day4 = "", day5 = "", day6 = "", day7 = "", day8 = "", day9 = "",
				day10 = "", day11 = "", day12 = "", day13 = "", day14 = "", day15 = "", day16 = "", day17 = "",
				day18 = "", day19 = "", day20 = "", day21 = "", day22 = "", day23 = "", day24 = "", day25 = "",
				day26 = "", day27 = "", day28 = "", day29 = "", day30 = "", day31 = "";
		String bushi = "", suoshubumen = "";

		if (0 == totalRowNum) {
			System.out.println("Excel内没有数据！");
		}

		// Cell cell_1 = null, cell_2 = null;

		Cell cell_1 = null, cell_2 = null, cell_3 = null, cell_4 = null, cell_5 = null, cell_6 = null, cell_7 = null,
				cell_8 = null, cell_9 = null, cell_10 = null, cell_11 = null, cell_12 = null, cell_13 = null,
				cell_14 = null, cell_15 = null, cell_16 = null, cell_17 = null, cell_18 = null, cell_19 = null,
				cell_20 = null, cell_21 = null, cell_22 = null, cell_23 = null, cell_24 = null, cell_25 = null,
				cell_26 = null, cell_27 = null, cell_28 = null, cell_29 = null, cell_30 = null, cell_31 = null,
				cell_32 = null, cell_33 = null, cell_34 = null, cell_35 = null, cell_36 = null, cell_37 = null,
				cell_38 = null, cell_39 = null, cell_40 = null;

		// 获得所有数据
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			try {
				// cell_1 = row.getCell(headMap.get("jizhan"));
				// cell_2 = row.getCell(headMap.get("jingweidu"));

				cell_1 = row.getCell(headMap.get("empno"));
				cell_2 = row.getCell(headMap.get("ename"));
				cell_3 = row.getCell(headMap.get("company"));
				cell_4 = row.getCell(headMap.get("day1"));
				cell_5 = row.getCell(headMap.get("day2"));
				cell_6 = row.getCell(headMap.get("day3"));
				cell_7 = row.getCell(headMap.get("day4"));
				cell_8 = row.getCell(headMap.get("day5"));
				cell_9 = row.getCell(headMap.get("day6"));
				cell_10 = row.getCell(headMap.get("day7"));
				cell_11 = row.getCell(headMap.get("day8"));
				cell_12 = row.getCell(headMap.get("day9"));
				cell_13 = row.getCell(headMap.get("day10"));
				cell_14 = row.getCell(headMap.get("day11"));
				cell_15 = row.getCell(headMap.get("day12"));
				cell_16 = row.getCell(headMap.get("day13"));
				cell_17 = row.getCell(headMap.get("day14"));
				cell_18 = row.getCell(headMap.get("day15"));
				cell_19 = row.getCell(headMap.get("day16"));
				cell_20 = row.getCell(headMap.get("day17"));
				cell_21 = row.getCell(headMap.get("day18"));
				cell_22 = row.getCell(headMap.get("day19"));
				cell_23 = row.getCell(headMap.get("day20"));
				cell_24 = row.getCell(headMap.get("day21"));
				cell_25 = row.getCell(headMap.get("day22"));
				cell_26 = row.getCell(headMap.get("day23"));
				cell_27 = row.getCell(headMap.get("day24"));
				cell_28 = row.getCell(headMap.get("day25"));
				cell_29 = row.getCell(headMap.get("day26"));
				cell_30 = row.getCell(headMap.get("day27"));
				cell_31 = row.getCell(headMap.get("day28"));
				if (headMap.get("day29") != null) {
					cell_32 = row.getCell(headMap.get("day29"));
				}
				if (headMap.get("day30") != null) {
					cell_33 = row.getCell(headMap.get("day30"));
				}
				if (headMap.get("day31") != null) {
					cell_34 = row.getCell(headMap.get("day31"));
				}
				cell_35 = row.getCell(headMap.get("yingdao"));
				cell_36 = row.getCell(headMap.get("shidao"));
				cell_37 = row.getCell(headMap.get("chidao"));
				cell_38 = row.getCell(headMap.get("zaotui"));
				cell_39 = row.getCell(headMap.get("bushi"));
				cell_40 = row.getCell(headMap.get("suoshubumen"));

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("获取单元格错误");
			}

			try {
				// ��վ
				// name = (String) getRightTypeCell(cell_1);
				// ��γ��
				// latitude = (Double) getRightTypeCell(cell_2);

				empno = (String) getRightTypeCell(cell_1);
				ename = (String) getRightTypeCell(cell_2);
				company = (String) getRightTypeCell(cell_3);
				day1 = (String) getRightTypeCell(cell_4);
				day2 = (String) getRightTypeCell(cell_5);
				day3 = (String) getRightTypeCell(cell_6);
				day4 = (String) getRightTypeCell(cell_7);
				day5 = (String) getRightTypeCell(cell_8);
				day6 = (String) getRightTypeCell(cell_9);
				day7 = (String) getRightTypeCell(cell_10);
				day8 = (String) getRightTypeCell(cell_11);
				day9 = (String) getRightTypeCell(cell_12);
				day10 = (String) getRightTypeCell(cell_13);
				day11 = (String) getRightTypeCell(cell_14);
				day12 = (String) getRightTypeCell(cell_15);
				day13 = (String) getRightTypeCell(cell_16);
				day14 = (String) getRightTypeCell(cell_17);
				day15 = (String) getRightTypeCell(cell_18);
				day16 = (String) getRightTypeCell(cell_19);
				day17 = (String) getRightTypeCell(cell_20);
				day18 = (String) getRightTypeCell(cell_21);
				day19 = (String) getRightTypeCell(cell_22);
				day20 = (String) getRightTypeCell(cell_23);
				day21 = (String) getRightTypeCell(cell_24);
				day22 = (String) getRightTypeCell(cell_25);
				day23 = (String) getRightTypeCell(cell_26);
				day24 = (String) getRightTypeCell(cell_27);
				day25 = (String) getRightTypeCell(cell_28);
				day26 = (String) getRightTypeCell(cell_29);
				day27 = (String) getRightTypeCell(cell_30);
				day28 = (String) getRightTypeCell(cell_31);
				if (cell_32 != null) {
					day29 = (String) getRightTypeCell(cell_32);
				}
				if (cell_33 != null) {
					day30 = (String) getRightTypeCell(cell_33);
				}
				if (cell_34 != null) {
					day31 = (String) getRightTypeCell(cell_34);
				}
				yingdao = (String) getRightTypeCell(cell_35);
				shidao = (String) getRightTypeCell(cell_36);
				chidao = (String) getRightTypeCell(cell_37);
				zaotui = (String) getRightTypeCell(cell_38);
				bushi = (String) getRightTypeCell(cell_39);
				suoshubumen = (String) getRightTypeCell(cell_40);

				Attendance att = new Attendance();
				att.setEmpno(empno);
				att.setEname(ename);
				att.setCompany(company);
				att.setDay1(day1);
				att.setDay2(day2);
				att.setDay3(day3);
				att.setDay4(day4);
				att.setDay5(day5);
				att.setDay6(day6);
				att.setDay7(day7);
				att.setDay8(day8);
				att.setDay9(day9);
				att.setDay10(day10);
				att.setDay11(day11);
				att.setDay12(day12);
				att.setDay13(day13);
				att.setDay14(day14);
				att.setDay15(day15);
				att.setDay16(day16);
				att.setDay17(day17);
				att.setDay18(day18);
				att.setDay19(day19);
				att.setDay20(day20);
				att.setDay21(day21);
				att.setDay22(day22);
				att.setDay23(day23);
				att.setDay24(day24);
				att.setDay25(day25);
				att.setDay26(day26);
				att.setDay27(day27);
				att.setDay28(day28);
				if (day29 != "") {
					att.setDay29(day29);
				}
				if (day30 != "") {
					att.setDay30(day30);
				}
				if (day31 != "") {
					att.setDay31(day31);
				}
				att.setYingdao(yingdao);
				att.setShidao(shidao);
				att.setChidao(chidao);
				att.setZaotui(zaotui);
				att.setBushi(bushi);
				att.setSuoshubumen(suoshubumen);

				// TestDTO dto= new TestDTO();
				// dto.setJizhanming(name);
				// dto.setWeidu(latitude);
				list.add(att);
			} catch (ClassCastException e) {
				e.printStackTrace();
				System.out.println("数据不全是数字或全部是文字!");
			}

		}

		return list;
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
