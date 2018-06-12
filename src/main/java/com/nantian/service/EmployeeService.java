package com.nantian.service;

import java.util.List;

import com.nantian.dto.Attendance;

public interface EmployeeService {

	// 获得单个员工的统计信息
	//Attendance getSingleAttendanceByEmpno(String empno);
	Attendance getSingleAttendanceByEmpno(String empno,String yymm);
	
	// 获得所有员工的考勤信息
	List<Attendance> getEnames();

	/**
	 * @param empno
	 * @return
	 */
	List<String> getDateyymmByEmpno(String empno);

	/**
	 * @return
	 */
	List<String> getDateyymm();

	/**
	 * @param yymm
	 * @return
	 */
	List<Attendance> getAttendancesByTime(String yymm);
}
