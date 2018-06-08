package com.nantian.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nantian.dao.AttendanceDao;
import com.nantian.dto.Attendance;
import com.nantian.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	AttendanceDao attendanceDao;

	@Override
	public void addAttendance(Attendance att, String tableName) {
		attendanceDao.insertExcel(att, tableName);
	}

	/*
	 * 下面的写法不对.....
	 */
	@Override
	public int ifTableExists(String name) {
		int i = attendanceDao.ifTableExists(name);
		return i;
	}

	/* 
	 * 
	 */
	@Override
	public void deleteTable(String name) {
		attendanceDao.deleteTabel(name);

	}

	/*
	 * 创建表
	 */
	@Override
	public void copyTable(String yearAndMonth) {
		attendanceDao.copyTable(yearAndMonth);

	}

	/*
	 * 
	 */
	@Override
	public void createDataBase(String name) {
		attendanceDao.createDataBase(name);
	}

	/*
	 * 
	 */
	@Override
	public void useDataBase(String name) {
		attendanceDao.useDataBase(name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nantian.service.AttendanceService#createBaseTable(java.lang.String)
	 */
	@Override
	public void createBaseTable(String sql) {
		attendanceDao.createBaseTable(sql);

	}

	/* 
	 * 
	 */
	@Override
	public void saveYearAndMonth(String yymm,List<Attendance> list) {
		attendanceDao.insertYearAndMonth(yymm,list);
	}

	/* 
	 * 创建日期和员工姓名对照表
	 */
	@Override
	public void createDateyymm(String sql) {
		attendanceDao.createDateyymm(sql);
		
	}

}
