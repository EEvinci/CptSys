package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.util.DbException;

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
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stu.getStuId());
			pstmt.setString(2, stu.getStuPsw());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				resultStu = new BeanStuInfo();
				resultStu.setStuId("id");
				resultStu.setStuPsw("password");
				
				return resultStu;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
