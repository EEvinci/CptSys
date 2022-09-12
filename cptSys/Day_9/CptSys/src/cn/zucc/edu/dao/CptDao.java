package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.util.BaseException;
import cn.zucc.edu.util.DbException;
import cn.zucc.edu.util.StringUtil;

/**
 * 竞赛信息管理
 * @author PC
 *
 */
public class CptDao {

	/**
	 * 添加竞赛信息
	 * @param conn
	 * @param cptInfo
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn, BeanCptInfo cptInfo) throws BaseException{
		
		int rs = 0;
		String sql = "insert into cpt_info values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cptInfo.getCptId());
			pstmt.setString(2, cptInfo.getCptItemId());
			pstmt.setString(3, cptInfo.getCptName());
			pstmt.setString(4, cptInfo.getCptYear());
			pstmt.setString(5, cptInfo.getHoldYear());
			pstmt.setString(6, cptInfo.getHoldDay());
			pstmt.setString(7, cptInfo.getRegiStart());
			pstmt.setString(8, cptInfo.getRegiEnd());
			pstmt.setString(9, cptInfo.getContact());
			pstmt.setString(10, cptInfo.getWeb());
			
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
 * 查询竞赛信息
 * @param conn
 * @param cptInfo
 * @return
 * @throws BaseException
 */
	public ResultSet query(Connection conn,BeanCptInfo cptInfo)throws BaseException{

		ResultSet rs = null;
		StringBuffer sb = new StringBuffer("select * from cpt_info");
		
		try {
			if(StringUtil.isNotEmpty(cptInfo.getCptId())){
				sb.append(" and CptId = " + cptInfo.getCptId());
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
	 * 删除竞赛信息
	 * @param conn
	 * @param cptInfo
	 * @return
	 * @throws BaseException
	 */
	public int delete(Connection conn, BeanCptInfo cptInfo) throws BaseException{
		int rs = 0;
		String sql = "delete from cpt_info where CptId = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cptInfo.getCptId());
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
	 * 修改竞赛信息
	 * @param conn
	 * @param cptInfo
	 * @return
	 * @throws BaseException
	 */
	public int update(Connection conn, BeanCptInfo cptInfo) throws BaseException{
		int rs = 0;
		String sql = "update cpt_info where CptId=?, CptItemName=?, CptName=?, CptYear=?, HoldYear=?, HoldDay=?, RegiStart=?, RegiEnd=?, Contact=?, Web=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cptInfo.getCptId());
			pstmt.setString(2, cptInfo.getCptItemId());
			pstmt.setString(3, cptInfo.getCptName());
			pstmt.setString(4, cptInfo.getCptYear());
			pstmt.setString(5, cptInfo.getHoldYear());
			pstmt.setString(6, cptInfo.getHoldDay());
			pstmt.setString(7, cptInfo.getRegiStart());
			pstmt.setString(8, cptInfo.getRegiEnd());
			pstmt.setString(9, cptInfo.getContact());
			pstmt.setString(10, cptInfo.getWeb());
			
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
}
