package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import cn.zucc.edu.models.BeanCptInfo;

public class CptDao {

	public int add(Connection conn, BeanCptInfo cptInfo) throws Exception{
		String sql = "insert into cpt_info values(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*

		 */
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
		
		
		return pstmt.executeUpdate();
	}
}
