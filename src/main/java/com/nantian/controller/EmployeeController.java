/**
 * 
 */
package com.nantian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nantian.dto.Attendance;
import com.nantian.dto.StatisticsObject;
import com.nantian.service.AttendanceService;
import com.nantian.service.EmployeeService;
import com.nantian.service.StatisticsService;

/**
 * @author ld
 * @date 与员工(Employee)相关的查询操作
 * 
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	StatisticsService statisticsService;
	
	@Autowired
	AttendanceService attendanceService;

	// 获取所有员工的姓名，不单单是姓名
	@ResponseBody
	@RequestMapping(value = "getEnames")
	public Object getEnames() {
		int i = attendanceService.ifTableExists("dateyymm");
		if(i!=0) {
			List<Attendance> empsInfo = employeeService.getEnames();
			return empsInfo;
		}else {
			return "";
		}
		
	}

	// 一个员工的统计信息
	@RequestMapping(value = "getSingleAttendanceByEmpno")
	public String getSingleAttendanceByEmpno(Model model, HttpServletRequest request) {
		String empno = request.getParameter("empno");
		String yymm = request.getParameter("time");

		// Attendance attendance = employeeService.getSingleAttendanceByEmpno(empno);
		Attendance attendance = employeeService.getSingleAttendanceByEmpno(empno, yymm);

		StatisticsObject so = statisticsService.totalStatistics(attendance);
		Float totalOverTimeHours = Float.valueOf(so.getTotaltime()) / 60;
		model.addAttribute("totalOverTimeMinutes", so.getTotaltime());
		model.addAttribute("totalOverTimeHours", totalOverTimeHours);
		model.addAttribute("attendance", attendance);
		model.addAttribute("so", so);

		return "statistics";
	}

	// 根据传过来的员工编号查询出其所在的年月信息
	@ResponseBody
	@RequestMapping(value = "getDateyymm")
	public Object getDateyymm(String empno) {
		List<String> list_date = employeeService.getDateyymm(empno);
		return list_date;
	}
}
