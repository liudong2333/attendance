/**
 * 
 */
package com.nantian.util;

import java.util.List;

/**
 * @author ld
 * @date 2018年6月4日
 */
public class MySQLUtil {

	// 创建被复制(基准)的表
	public static String createBaseTable(List<String> headList) {

		String sql = "";

		for (int i = 0; i < headList.size(); i++) {
			String name = headList.get(i);

			// 以下为特殊处理
			if (name.equals("员工编号")) {
				name = "empno";
			} else if (name.equals("姓名")) {
				name = "ename";
			} else if (name.equals("厂商名称")) {
				name = "company";
			}
			sql += name + " " + "varchar(255)" + ",";
		}
		sql = "(" + sql;
		sql = sql.substring(0, sql.length() - 1);
		sql += ")";

		// System.out.println("MySQLUtil" + sql);

		return sql;
	}

	
	
}
