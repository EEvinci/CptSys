package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.zucc.edu.models.BeanStuInfo;

/**
 * 学生登录信息管理
 * @author PC
 *
 */
public class StuLogDao {
	
	/**
	 * 学生登录
	 * @param conn
	 * @param stu
	 * @return
	 * @throws Exception
	 */
	public static BeanStuInfo login(Connection conn, BeanStuInfo stu) throws Exception{
		BeanStuInfo resultStu = null;
		String sql = "select StuId,StuPsw from stu_info where StuId=? and StuPsw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stu.getStuId());
		pstmt.setString(2, stu.getStuPsw());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			resultStu = new BeanStuInfo();
			resultStu.setStuId("id");
			resultStu.setStuPsw("password");
		}
		return resultStu;
	}
}
