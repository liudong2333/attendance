/**
 * 
 */
package com.nantian.service;

import com.nantian.dto.Attendance;
import com.nantian.dto.StatisticsObject;

/**
 * @author ld
 * @date   2018年5月31日
 * 统计的方法
 */
public interface StatisticsService {

	/**
	 * 统计加班时间
	 */
	StatisticsObject totalStatistics(Attendance attendance);
	
	
}
