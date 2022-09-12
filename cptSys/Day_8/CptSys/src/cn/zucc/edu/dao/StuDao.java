package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.util.BaseException;
import cn.zucc.edu.util.DbException;

/**
 * 学生信息管理
 * @author PC
 *
 */
public class StuDao {

	/**
	 * 学生信息添加
	 * @param conn
	 * @param stuInfo
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn, BeanStuInfo stuInfo) throws BaseException{
		
		int rs = 0;
		String sql = "insert into stu_info values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stuInfo.getStuId());
			pstmt.setString(2, stuInfo.getName());
			pstmt.setString(3, stuInfo.getStuPsw());
			pstmt.setString(4, stuInfo.getSClass());
			pstmt.setString(5, stuInfo.getGrade());
			pstmt.setString(6, stuInfo.getProfess());
			pstmt.setString(7, stuInfo.getPhoneNum());
			
			rs = pstmt.executeUpdate();
			return rs;
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
	}
	
	/**
	 * 修改密码功能
	 * @param stuInfo
	 * @return
	 * @throws BaseException
	 */
	public int changePwd(Connection conn,BeanStuInfo stuInfo) throws BaseException{
		
		int n = 0;
		String sql = "update stu_info set StuPsw=? where StuId=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stuInfo.getStuPsw());
			pstmt.setString(2, stuInfo.getStuId());
			n = pstmt.executeUpdate();//executeUpdate执行成功返回1，失败返回0
			
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
		return 0;//如果上面的n没有返回1，那么下面就返回0，即代表失败
	}
}
