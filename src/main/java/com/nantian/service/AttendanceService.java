package com.nantian.service;

import java.util.List;

import com.nantian.dto.Attendance;

public interface AttendanceService {

	// 添加考勤信息
	void addAttendance(Attendance att, String tableName);

	// 判断某表是否存在
	int ifTableExists(String name);

	// 删除某表
	void deleteTable(String name);

	// 由于月份不同，每个月份需要创建不同的表
	void copyTable(String yearAndMonth);

	// 创建数据库
	void createDataBase(String name);

	// 使用数据库
	void useDataBase(String name);

	// 创建要被复制的基础表
	void createBaseTable(String sql);

	// 将年月保存到数据库中
	void saveYearAndMonth(String yymm, List<Attendance> list);

	/**
	 * @param sql
	 */
	void createDateyymm(String sql);
}
