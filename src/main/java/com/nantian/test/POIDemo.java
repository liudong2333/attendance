/**  
* <p>Title: POIDemo.java</p>  
* <p>Description: 涓�鍙ヨ瘽鎻忚堪</p>  
* @author ASUS 
* @date 2018骞�5鏈�29鏃�  
* @version 1.0  
*/
package com.nantian.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nantian.dto.Attendance;
import com.nantian.util.ExcelUtil;

/**
 * @author ASUS
 *
 */
@Component
public class POIDemo {

	//private static final Logger log = Logger.getLogger(POIDemo.class);
    
	//·������д������Ҫ������䶯
	private static final String filePath = "D:\\attendance.xls";

	public static void main(String[] args) {
		List<Attendance> list = ExcelUtil.getAttendancesFromExcel(filePath);

		// System.out.println(list);

		try {
			// ��ȡmybatis-config.xml�ļ�
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis/mybatis.xml");

			// ��ʼ��mybatis,����SqlSessionFactory���ʵ��
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

			// ����sessionʵ��
			SqlSession session = sqlSessionFactory.openSession();

			for (Attendance att : list) {
				//session.insert("com.nantian.dao.TestDao.insertTest", testDTO);
				session.insert("com.nantian.dao.AttendanceDao.insertExcel",att);
			}

			
			
			// �ύ����
			session.commit();

			// �ر�session
			session.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
