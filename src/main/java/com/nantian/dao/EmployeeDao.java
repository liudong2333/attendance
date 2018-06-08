package com.nantian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nantian.dto.Attendance;

/**
 * @author ld
 * @date 2018年5月31日
 */
public interface EmployeeDao {

	/**
	 * @param empno
	 * @return 根据用户的编号查询用户的信息
	 */
	//Attendance selectSingleAttendanceByEmpno(String empno);
	Attendance selectSingleAttendanceByEmpno(@Param("empno")String empno,@Param("yymm")String yymm);

	/**
	 * @return
	 */
	List<Attendance> selectEnames();

	/**
	 * @param empno
	 * @return
	 */
	List<String> selectDateyymm(String empno);
}
