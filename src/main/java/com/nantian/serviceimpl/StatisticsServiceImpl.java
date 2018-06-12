/**
 * 
 */
package com.nantian.serviceimpl;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nantian.dto.Attendance;
import com.nantian.dto.StatisticsObject;
import com.nantian.service.StatisticsService;

/**
 * @author ld
 * @date 2018年5月31日
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

	// 定义常量
	// 定义开始加班时间
	private static String BASE_JIABANSHIJIAN = "19:00";

	// 定义开始上班时间
	private static String BASE_SHANGBANSHIJIAN = "9:00";

	// 定义下班时间
	private static String BASE_XIABANSHIJIAN = "17:00";

	/*
	 * 统计员工的各项数据
	 */
	@Override
	public StatisticsObject totalStatistics(Attendance attendance) {

		StatisticsObject so = new StatisticsObject();
		// 用于存储每天打卡的时间段
		String period = "";

		// 用于存储集中开发的天数
		int jizhongkaifa = 0;
		// 用于存储有哪些天集中开发
		List<String> daysjizhongkaifa = new ArrayList<String>();
		// 用于存储未打卡天数
		int weidaka = 0;
		// 用于存储有哪些天全天未打卡
		List<String> daysweidaka = new ArrayList<String>();
		// 用于存储上班未打卡天数
		int shangbanweidaka = 0;
		// 用于存储哪些天上班未打卡
		List<String> daysshangbanweidaka = new ArrayList<String>();
		// 用于存储下班未打卡天数
		int xiabanweidaka = 0;
		// 用于存储哪些天下班未打卡
		List<String> daysxiabanweidaka = new ArrayList<String>();
		// 用于存储早退天数
		int zaotui = 0;
		// 用于存储有哪些天早退
		List<String> dayszaotui = new ArrayList<String>();
		// 用于存储迟到天数
		int chidao = 0;
		// 用于存储有哪些天迟到
		List<String> dayschidao = new ArrayList<String>();

		// totaltime用于统计总加班时间，ljiaban用于判断时间的差值
		long totaltime = 0, ljiaban = 0, lshangban = 0, lxiaban = 0;
		// 格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		try {
			// 19:00为基准加班开始时间
			Date basejiabanshijian = sdf.parse(BASE_JIABANSHIJIAN);
			Date baseshangbanshijian = sdf.parse(BASE_SHANGBANSHIJIAN);
			Date basexiabanshijian = sdf.parse(BASE_XIABANSHIJIAN);
			Class<?> c = Class.forName("com.nantian.dto.Attendance");

			// 利用反射可以拼接方法名
			String[] times = null;
			for (int i = 1; i <= 31; i++) {
				Method method = c.getMethod("getDay" + i);
				period = (String) method.invoke(attendance);
				// 直接在这里处理时间
				if (period != null) {
					times = period.split("-");
				}

				// System.out.println(times.length);
				// times.length==2意味着上下班都打卡了
				if (times.length == 2) {

					if (times[0].equals(" ")) {// 需要判断上班未打卡的情况
						// 如果times[0]的值为空，则说明上班未打卡
						daysshangbanweidaka.add("day" + i);
						shangbanweidaka++;
					} else if (times[1].equals(" ")) {// 需要判断下班未打卡的情况
						// 如果times[1]的值为空，则说明下班未打卡
						daysxiabanweidaka.add("day" + i);
						xiabanweidaka++;
					} else {
						// 主要的统计都在这里.....

						// ontime为上班时间
						Date ontime = sdf.parse(times[0]);
						// offtime为下班时间
						Date offtime = sdf.parse(times[1]);

						// 下班时间差值
						lxiaban = offtime.getTime() - basexiabanshijian.getTime();
						if (lxiaban < 0) {
							// 早退
							dayszaotui.add("day" + i);
							zaotui++;
						}

						lshangban = baseshangbanshijian.getTime() - ontime.getTime();
						if (lshangban < 0) {
							// 迟到
							dayschidao.add("day" + i);
							chidao++;
						}

						// 加班时间差值
						ljiaban = offtime.getTime() - basejiabanshijian.getTime();
						// 如果下班时间大于19:00,则算为加班
						if (ljiaban > 0) {
							if (ljiaban >= 120 * 60 * 1000) {
								// 如果加班超过21:00，则加班时间就固定为到21:00的两个小时
								totaltime = 120 * 60 * 1000 + totaltime;
							} else {
								totaltime = ljiaban + totaltime;
							}

						}
					}

				} else if (times.length == 1 && times[0].equals("集中开发")) {
					daysjizhongkaifa.add("day" + i);
					jizhongkaifa++;
				} else if (period != null && times.length == 0) {
					daysweidaka.add("day" + i);
					weidaka++;
				}

			}

			// System.out.println("加班时间(分钟):" + totaltime / 1000 / 60 );
			totaltime = totaltime / 1000 / 60;
		} catch (Exception e) {
			e.printStackTrace();
		}

		so.setChidao(chidao);
		so.setDayschidao(dayschidao);
		so.setDaysjizhongkaifa(daysjizhongkaifa);
		so.setDaysshangbanweidaka(daysshangbanweidaka);
		so.setDaysweidaka(daysweidaka);
		so.setDaysxiabanweidaka(daysxiabanweidaka);
		so.setDayszaotui(dayszaotui);
		so.setJizhongkaifa(jizhongkaifa);
		so.setShangbanweidaka(shangbanweidaka);
		so.setTotaltimeminutes(totaltime);
		so.setWeidaka(weidaka);
		so.setXiabanweidaka(xiabanweidaka);
		so.setZaotui(zaotui);

		return so;
	}

}
