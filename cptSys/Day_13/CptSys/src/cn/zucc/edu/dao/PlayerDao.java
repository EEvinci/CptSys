package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zucc.edu.models.BeanPlayer;
import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.util.BaseException;
import cn.zucc.edu.util.DbException;
import cn.zucc.edu.util.StringUtil;

public class PlayerDao {
	/**
	 * 添加参赛队员信息
	 * @param conn
	 * @param cptInfo
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn, BeanPlayer player) throws BaseException{
		
		int rs = 0;
		String sql = "insert into player values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, player.getStuId());
			pstmt.setString(2, player.getCptId());
			pstmt.setString(3, player.getItemId());
			
			rs = pstmt.executeUpdate();
			
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 查询参赛队员信息
	 * @param conn
	 * @param stuInfo
	 * @return
	 * @throws BaseException
	 */
	public ResultSet query(Connection conn,BeanPlayer player)throws BaseException{

		ResultSet rs = null;
		StringBuffer sb = new StringBuffer("select * from player");
		
		try {
			if(StringUtil.isNotEmpty(player.getStuId())){
				sb.append(" and StuId = " + player.getStuId());
			}
			PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
			rs = pstmt.executeQuery();
			
			return rs;
		}catch(SQLException e){
			e.printStackTrace();
			throw new DbException(e);
		}
	}
	
	/**
	 * 修改参赛队员信息
	 * @param conn
	 * @param cptInfo
	 * @return
	 * @throws BaseException
	 */
	public int update(Connection conn, BeanPlayer player) throws BaseException{
		int rs = 0;
		String sql = "update player set StuId=?, CptId=?, ItemId=? where StuId=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, player.getStuId());
			pstmt.setString(2, player.getCptId());
			pstmt.setString(3, player.getItemId());
			pstmt.setString(4, player.getStuId());
			
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
	 * 删除参赛队员信息
	 * @param conn
	 * @param stuInfo
	 * @return
	 * @throws BaseException
	 */
	public int delete(Connection conn, String id) throws BaseException{
		
		int rs = 0;
		String sql = "delete from player where StuId = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			rs = pstmt.executeUpdate();
			
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
}
