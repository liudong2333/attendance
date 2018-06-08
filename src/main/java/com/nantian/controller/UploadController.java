package com.nantian.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nantian.dto.Attendance;
import com.nantian.service.AttendanceService;
import com.nantian.util.ExcelForMySQLUtil;
import com.nantian.util.ExcelUtil;
import com.nantian.util.MySQLUtil;

@Controller
public class UploadController {

	@Autowired
	AttendanceService attedanceService;

	// 常量可以提上来

	@ResponseBody
	@RequestMapping(value = "FileUpload")
	public String fileUpload(MultipartFile file) {
		// 设置文件存放的位置
		String path = "D:\\attedance";
		// 获取文件名(文件名中会存在有用的信息,比如是哪个月份...)
		String filename = file.getOriginalFilename();
		// 返回的结果如:201805,代表2018年5月份的表
		// 上传表格的标题一定要格式来才行...因为这里截取了内容...
		// 至少要是类似201806这样的格式...
		String substring = filename.substring(8, 14);

		// 创建文件对象
		File dir = new File(path, filename);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			file.transferTo(dir);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 文件上传到硬盘之后，可以调用工具类读取excel的内容到内存中
		String filePath = path + "\\" + filename;
		List<Attendance> list = ExcelUtil.getAttendancesFromExcel(filePath);

		// 得到Excel的表头信息
		List<String> headList = ExcelForMySQLUtil.getHeadListFromExcel(filePath);

		// 基础表创建之前需要先判断一下
		int baseTableExists = attedanceService.ifTableExists("attendance");
		if (baseTableExists == 0) {
			// 得到创建被复制的表的sql语句....
			String sql = MySQLUtil.createBaseTable(headList);
			// 创建基础attendance表
			attedanceService.createBaseTable(sql);
		}

		// 创建基础时间查询表
		int dateyymmTableExists = attedanceService.ifTableExists("dateyymm");
		if (dateyymmTableExists == 0) {
			String sql = "create table dateyymm ( yymm varchar(255) ,empno varchar(255),ename varchar(255))";
			attedanceService.createDateyymm(sql);
		}

		// 在插入之前还需判断数据库中是否存在这个表
		// 表的名字这个地方需要有一个规则
		int exists = attedanceService.ifTableExists("attendance" + substring);
		if (exists == 0) {

			// 说明表不存在，需要创建表(前提是有一张基础表)
			attedanceService.copyTable("attendance" + substring);
			// 得到list之后，需要调用service方法向数据库中存储数据
			// System.out.println("第一次插入表");
			for (Attendance attendance : list) {
				attedanceService.addAttendance(attendance, "attendance" + substring);
			}

			// 将年月信息保存到数据库中
			attedanceService.saveYearAndMonth(substring, list);
		} else {
			// 表已经存在，需要把表删除，把新表插入进去
			attedanceService.deleteTable("attendance" + substring);
			// System.out.println("已经删除了表");
			for (Attendance attendance : list) {
				attedanceService.addAttendance(attendance, "attendance" + substring);
			}

		}

		return "success";
	}
}
