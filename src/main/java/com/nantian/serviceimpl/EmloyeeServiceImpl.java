package com.nantian.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nantian.dao.EmployeeDao;
import com.nantian.dto.Attendance;
import com.nantian.service.EmployeeService;

/**
 * @author ld
 * @date 2018年5月31日
 */
@Service
public class EmloyeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	/*
	 * @Override public Attendance getSingleAttendanceByEmpno(String empno) {
	 * Attendance attendance = employeeDao.selectSingleAttendanceByEmpno(empno);
	 * return attendance; }
	 */

	@Override
	public Attendance getSingleAttendanceByEmpno(String empno, String yymm) {
		Attendance attendance = employeeDao.selectSingleAttendanceByEmpno(empno, yymm);
		return attendance;
	}

	/* 
	 * 
	 */
	@Override
	public List<Attendance> getEnames() {
		List<Attendance> listAtt = employeeDao.selectEnames();
		return listAtt;
	}

	/* 
	 * 
	 */
	@Override
	public List<String> getDateyymmByEmpno(String empno) {
		List<String> list_date = employeeDao.selectDateyymmByEmpno(empno);
		return list_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nantian.service.EmployeeService#getDateyymm()
	 */
	@Override
	public List<String> getDateyymm() {
		List<String> list_date = employeeDao.selectDateyymm();
		return list_date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nantian.service.EmployeeService#getAttendancesByTime(java.lang.String)
	 */
	@Override
	public List<Attendance> getAttendancesByTime(String yymm) {
		List<Attendance> list_atttendances = employeeDao.selectAttendancesByTime(yymm);
		return list_atttendances;
	}

}
