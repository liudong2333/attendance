package com.nantian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nantian.dto.Attendance;

public interface AttendanceDao {

	// 添加考勤信息
	void insertExcel(@Param("att") Attendance att, @Param("tableName") String tableName);

	// 得出某表的行数
	int getTableRowsNumber(@Param("name") String name);

	// 判断某表是否存在
	int ifTableExists(@Param("name") String name);

	// 删除某表
	void deleteTabel(@Param("name") String name);

	/**
	 * @param yearAndMonth
	 */
	void copyTable(@Param("yearAndMonth") String yearAndMonth);

	/**
	 * @param name
	 */
	void createDataBase(@Param("name") String name);

	/**
	 * @param name
	 */
	void useDataBase(@Param("name") String name);

	/**
	 * @param sql
	 */
	void createBaseTable(@Param("sql") String sql);

	/**
	 * @param yymm
	 * @param attlist
	 */
	void insertYearAndMonth(@Param("yymm") String yymm, @Param("attlist") List<Attendance> attlist);

	/**
	 * @param sql
	 */
	void createDateyymm(@Param("sql") String sql);
}
